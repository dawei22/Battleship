package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import battleship.Battleship;
import battleship.ISpot;
import battleship.Player;
import battleship.SpaceDisplay;
import battleship.attack.IAttackResult;
import battleship.ship.*;


public class BattleshipTest {


  @Test
  public void testCreation() {
    Player p = new Player();
    assertNotNull(p);
    assertEquals(p.getTerritory().getHeight(), 10);
    assertEquals(p.getTerritory().getWidth(), 10);
    assertEquals("spacious", p.getDeploy().getRule());
    assertEquals("tilde", p.getDisplay().getDisplayName());
    
  }

  @Test
  public void testSetSize() {
    Battleship b = new Battleship();
    b.setTerritorySize(5, 6);
    assertEquals(5, b.getTerritoryWidth());
    assertEquals(6, b.getTerritoryHeight());
  }

  @Test
  public void testDisplayMode() {
    Player b = new Player();
    b.setDisplay(new SpaceDisplay());
    assertEquals(b.getDisplay().getDisplayName(), "space");
    assertEquals(b.getDisplay().getDisplayName(), "space");
    
  }


  @Test
  public void testDisplay1() {
    Battleship b = new Battleship();
    assertEquals(b.getPlayerOneName(),"a player");
    assertEquals(b.getPlayerTwoName(),"a player");
    b.setPlayerOneName("david");
    b.setPlayerTwoName("matias");
    assertEquals(b.getPlayerOneName(),"david");
    assertEquals(b.getPlayerTwoName(),"matias");
    b.setTerritorySize(3, 3);
    b.useSpaceDisplay();
    b.useTildeDisplay();
    String expected = "~~~\n~~~\n~~~\n";
    String probe = b.displayPlayerOneTerritory();
    assertEquals(probe, expected);
  }

  @Test
  public void testDisplay2() {
    Battleship b = new Battleship();
    b.setTerritorySize(2, 3);
    b.useSpaceDisplay();
    b.useCustomFleet();
    b.useCompactDisplay();
    b.addShip("test", 1);
    /*b.playerOneDeployHorizontally(1,3);
    String expected = "  \n  \n* \n";
    String probe = b.displayPlayerOneTerritory();
    assertEquals(probe, expected);*/
  }

  @Test
  public void testTraditionalFleet() {
    Battleship b = new Battleship();
    Battleship f = new Battleship();
    f.useCustomFleet();
    f.useTraditionalFleet();
    assertNotNull(f);
    b.useTacticalFleet();
    b.useTraditionalFleet();
    assertEquals(b.getPlayerOne().getFleet().size(), 5);
    assertEquals(b.getPlayerOne().getFleet().get(0).getName(), "Aircraft carrier");
    assertEquals(b.getPlayerOne().getFleet().get(0).getLength(), 5);
    assertEquals(b.getPlayerTwo().getFleet().get(4).getName(), "Patrol boat");
    assertEquals(b.getPlayerTwo().getFleet().get(4).getLength(), 2);
  }

  @Test
  public void testTacticalFleet() {
    Battleship b = new Battleship();
    Battleship f = new Battleship();
    f.useCustomFleet();
    f.useTacticalFleet();
    assertNotNull(f);
    b.useTraditionalFleet();
    b.useTacticalFleet();
    assertEquals(b.getPlayerOne().getFleet().size(), 7);
    assertEquals(b.getPlayerOne().getFleet().get(0).getName(), "Aircraft carrier");
    assertEquals(b.getPlayerOne().getFleet().get(0).getLength(), 5);
    assertEquals(b.getPlayerTwo().getFleet().get(6).getName(), "Submarine");
    assertEquals(b.getPlayerTwo().getFleet().get(6).getLength(), 1);
  }

  @Test
  public void testCustomFleet() {
    Battleship b = new Battleship();
    b.useCustomFleet();
    assertTrue(b.getPlayerOne().getFleet().isEmpty());
    assertFalse(b.getPlayerOne().getFleet().getNext().isShip());
    b.addShip("test",3);
    assertFalse(b.getPlayerOne().getFleet().isEmpty());
    b.getFleetIterator();
    assertTrue(b.getPlayerOne().getFleet().iterator().hasNext());
    
  }

  @Test
  public void testFleetSize() {
    Battleship b1 = new Battleship();
    Battleship b2 = new Battleship();
    b1.useTraditionalFleet();
    b2.useTacticalFleet();
    assertEquals(5, b1.getFleetSize());
    assertEquals(7, b2.getFleetSize());

  }

  @Test
  public void testTight() {
    Battleship b = new Battleship();
    b.useTightDeployment();
    assertEquals(b.getPlayerOne().getDeploy().getRule(), "tight");
  }

  @Test
  public void testDeployWithTight() {
    Battleship b = new Battleship();
    b.setTerritorySize(5, 5);
    b.useTightDeployment();
    b.useCompactDisplay();
    b.getPlayerOne().getVisualization().setTerritory(b.getPlayerOne().getTerritory());
    b.playerOneDeployHorizontally(1, 1);
    assertFalse(b.getPlayerOne().getDeploy().isAvailable(b.getPlayerOne().getTerritory(), 4, 1));
    assertFalse(b.playerOneDeployHorizontally(6, 6).isShip());

    b.playerOneDeployVertically(5, 2);
    assertFalse(b.getPlayerOne().getDeploy().isAvailable(b.getPlayerOne().getTerritory(), 5, 4));
    assertFalse(b.playerOneDeployVertically(5, 6).isShip());
    assertFalse(b.playerOneDeployVertically(5,3).isShip());
    String expected = "ooooo\n~~~~o\n~~~~o\n~~~~o\n~~~~~\n";
    String probe = b.displayPlayerOneTerritory();
    assertEquals(expected, probe);

  }
  
  @Test
  public void testDeployWithSpacious() {
    Battleship b = new Battleship();
    b.setTerritorySize(5, 5);
    b.useTightDeployment();
    b.useSpaciousDeployment();
    b.useCompactDisplay();
    b.getPlayerTwo().getVisualization().setTerritory(b.getPlayerTwo().getTerritory());
    b.playerTwoDeployHorizontally(1, 1);
    assertFalse(b.playerTwoDeployVertically(5, 2).isShip());
    assertFalse(b.playerTwoDeployHorizontally(5, 5).isShip());
    String expected = "ooooo\n~~~~~\n~~~~~\n~~~~~\n~~~~~\n";
    String probe = b.displayPlayerTwoTerritory();
    assertEquals(expected, probe);

  }

  @Test
  public void testDeployedShip() {
    Battleship b = new Battleship();
    IShip ship_1 = b.playerOneDeployHorizontally(1, 1);
    IShip ship_2 = b.playerOneDeployVertically(5, 5);
    assertEquals(2, b.playerOneNumberOfDeployedShips());
    assertEquals(3, b.playerOneNumberOfAnchoredShips());
    assertEquals("Aircraft carrier", ship_1.getName());
    assertEquals("Battleship", ship_2.getName());
    assertTrue(b.isPlayerOneShipAt(5, 1));
    assertFalse(b.isPlayerOneShipAt(6, 1));
    assertTrue(b.isPlayerOneShipAt(5, 8));
    assertFalse(b.isPlayerOneShipAt(5, 9));
    
    IShip ship_3 = b.playerTwoDeployHorizontally(1, 1);
    IShip ship_4 = b.playerTwoDeployVertically(1, 1);
    assertEquals(1, b.playerTwoNumberOfDeployedShips());
    assertEquals(4, b.playerTwoNumberOfAnchoredShips());
    assertTrue(b.isPlayerTwoShipAt(1, 1));
    assertFalse(b.isPlayerTwoShipAt(5, 5));
    
  }
  
  @Test
  public void war() {
    Battleship b = new Battleship();
    ISpot[][] state = b.getPlayerOne().getTerritory().getState();
    assertTrue(state[0][0].isWater());
    b.playerOneDeployHorizontally(1, 1);
    assertTrue(state[0][0].isShip());
    IAttackResult ia0 = b.playerTwoAttackAt(0, 0);
    assertTrue(ia0.isMissedTarget());
    IAttackResult ia1 = b.playerTwoAttackAt(1, 1);
    assertTrue(ia1.isAffectedTarget());
    b.playerTwoAttackAt(2, 1);
    b.playerTwoAttackAt(3, 1);
    assertTrue(state[0][2].isAttacked());
    b.playerTwoAttackAt(4, 1);
    b.playerTwoAttackAt(5, 1);
    IAttackResult ia5 = b.playerTwoAttackAt(5, 1);
    assertTrue(ia5.isMissedTarget());
    assertTrue(state[0][2].isDefeated());
    b.playerTwoAttackAt(6, 1);
    assertTrue(state[0][5].isOut());
 
    
    
  }
  
  @Test
  public void last() {
    Battleship b = new Battleship(new Player(),new Player());
    assertEquals(b.getTurn(),0);
    b.swapTurn();
    assertEquals(b.getTurn(), 1);
  }


}