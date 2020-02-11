package battleship;

import battleship.ship.IShip;

/**
 * Estado con barco.
 * 
 * @author david
 *
 */

public class ShipSpot extends AbstractSpot {


  public ShipSpot(IShip ship) {
    super(ship);
  }

  @Override
  public void attacked(ISpot[][] state, int ver, int hor) {
    state[ver][hor] = new AttackSpot(this.getShip());
  }

  @Override
  public boolean isShip() {
    return true;
  }
}
