package test;

import static org.junit.Assert.*;

import org.junit.Test;

import battleship.attack.AttackResult;
import battleship.attack.IAttackResult;

public class AttackTest {



  @Test
  public void testCreation() {
    IAttackResult ia = new AttackResult(true);
    assertTrue(ia.isAffectedTarget());
    assertFalse(ia.isMissedTarget());
    IAttackResult ib = new AttackResult(false);
    assertTrue(ib.isMissedTarget());
    IAttackResult ic = new AttackResult(true,false);
    assertFalse(ic.isDefeatTarget());
  }


}
