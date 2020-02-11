package test;

import static org.junit.Assert.*;

import org.junit.Test;

import battleship.ship.*;

public class NullShipTest {
  
  @Test
  public void testCreation() {
    IShip n = new NullShip();
    assertEquals(n.getLength(),0);
    assertEquals(n.getName()," ");
    assertFalse(n.isShip());
    assertEquals(0,n.getHomeCol(),n.getHomeRow());
    assertNull(n.getOrientation());
    assertFalse(n.defeat());
  }

}
