package battleship;

import battleship.ship.IShip;

/**
 * Estado dañado.
 * 
 * @author david
 *
 */

public class AttackSpot extends AbstractSpot {

  public AttackSpot(IShip ship) {
    super(ship);
  }

  @Override
  public void defeated(ISpot[][] state, int ver, int hor) {
    state[ver][hor] = new DefeatSpot(this.getShip());
  }

  @Override
  public boolean isAttacked() {
    return true;
  }

}
