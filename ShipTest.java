package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import battleship.ship.*;

public class ShipTest {
  Ship s;
  
  @Before
  public void setUp(){
    s = new Ship("shipTest",5);
  }

  @Test
  public void testCreation() {
    assertNotNull(s);
    assertEquals("shipTest",s.getName());
    assertEquals(5,s.getLength());
    assertTrue(s.isShip());
  }
  
  @Test
  public void testgetName(){
    assertEquals("shipTest",s.getName());
  }
  
  @Test
  public void testgetLength(){
    assertEquals(5,s.getLength());
  }

}