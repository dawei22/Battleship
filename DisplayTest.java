package test;

import static org.junit.Assert.*;

import org.junit.Test;

import battleship.IDisplay;
import battleship.OppositeDisplay;
import battleship.SpaceDisplay;
import battleship.TildeDisplay;

public class DisplayTest {
  
  @Test
  public void testCreation() {
    IDisplay s = new SpaceDisplay();
    assertEquals(s.affectedSymbol(),'x');
    assertEquals(s.defeatSymbol(), '#');
    assertEquals(s.shipSymbol(),'*');
    assertEquals(s.waterSymbol(),' ');
    assertEquals(s.outSymbol(),'.');
    
    IDisplay p = new OppositeDisplay();
    assertEquals(p.affectedSymbol(),'x');
    assertEquals(p.defeatSymbol(), '#');
    assertEquals(p.shipSymbol(),' ');
    assertEquals(p.waterSymbol(),' ');
    assertEquals(p.outSymbol(),'/');
    assertEquals(p.getDisplayName(),"opposite");
    
    IDisplay t = new TildeDisplay();
    assertEquals(t.affectedSymbol(),'+');
    assertEquals(t.defeatSymbol(), '#');
    assertEquals(t.shipSymbol(),'o');
    assertEquals(t.waterSymbol(),'~');
    assertEquals(t.outSymbol(),'.');
    
  }

}
