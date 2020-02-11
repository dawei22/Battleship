package test;

import battleship.ship.*;
import static org.junit.Assert.*;

import org.junit.Test;

import battleship.ISpot;
import battleship.WaterSpot;

public class SpotTest {
  
  @Test
  public void testCreation() {
    ISpot[][] s = new ISpot[1][1] ;
    s[0][0] = new WaterSpot();
    assertEquals(s[0][0].getShip().getLength(), 0);
    assertTrue(s[0][0].isWater());
    assertFalse(s[0][0].isShip());
    IShip ship = new Ship("test",5);
    s[0][0].deployShip(s, 0, 0, ship);
    assertTrue(s[0][0].isShip());
    assertFalse(s[0][0].isWater());
    assertEquals(ship,s[0][0].getShip());
    s[0][0].attacked(s, 0, 0);
    assertTrue(s[0][0].isAttacked());
    assertFalse(s[0][0].isShip());
    s[0][0].defeated(s, 0, 0);
    assertTrue(s[0][0].isDefeated());
    assertFalse(s[0][0].isAttacked());
    s[0][0] = new WaterSpot();
    s[0][0].attacked(s, 0, 0);
    assertTrue(s[0][0].isOut());
    
    
  }

}
