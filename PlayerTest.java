package test;

import static org.junit.Assert.*;

import org.junit.Test;

import battleship.HorizontalPosition;
import battleship.ISpot;
import battleship.Player;
import battleship.ship.IShip;
import battleship.ship.Ship;


public class PlayerTest {

  public PlayerTest() {
    
  }
  
  @Test
  public void testCreation() {
    Player p = new Player();
    Player o = new Player("oo");
    p.setName("oo");
    assertEquals(p.getName(),o.getName());
  }
  
  @Test
  public void testAttacked() {
    Player p = new Player();
    p.attacked(4, 7);
    ISpot[][] state = p.getTerritory().getState();
    assertTrue(state[7][4].isOut());
    assertFalse(state[7][4].isDefeated());
    IShip ship = new Ship("test",2);
    ship.setOrientation(new HorizontalPosition(4,4));
    ship.setHome(4, 4);
    assertTrue(state[4][4].isWater());
    state[4][4].deployShip(state,4,4,ship);
    assertTrue(state[4][4].isShip());
    p.attacked(4, 4);
    assertTrue(state[4][4].isAttacked());
    assertFalse(state[4][4].isDefeated());
    assertFalse(state[4][4].isOut());
    assertFalse(state[4][4].isWater());
    p.attacked(5, 4);
    assertTrue(state[4][4].isAttacked());
  }
  

}
