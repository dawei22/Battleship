package test;

import static org.junit.Assert.*;

import org.junit.Test;

import battleship.ship.*;
import battleship.ISpot;
import battleship.Territory;

public class TerritoryTest {
  
  
  @Test
  public void testCreation() {
    Territory t = new Territory();
    assertEquals(t.getHeight(),10);
    assertEquals(t.getWidth(),10);
    Territory t2 = new Territory(5,6);
    assertEquals(t2.getHeight(),6);
    assertEquals(t2.getWidth(),5);
  }
  
  
  @Test
  public void testInRange() {
    Territory t = new Territory();
    t.setHeight(5);
    t.setWidth(8);
    assertTrue(t.inRange(3, 2));
    assertFalse(t.inRange(5, 8));
    }
  
  @Test
  public void testIsShipAt() {
    Territory t = new Territory();
    assertFalse(t.isShipAt(5, 5));
    assertFalse(t.isShipAt(20, 20));
    IShip s = new Ship("test",5);
    ISpot[][] state = t.getState();
    state[5][4].deployShip(state,5,4,s);
    assertTrue(t.isShipAt(4,5));
    
  }
  

}