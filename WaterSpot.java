package battleship;

import battleship.ship.IShip;

/**
 * Estado agua.
 * 
 * @author david
 *
 */

public class WaterSpot extends AbstractSpot {

  @Override
  public void attacked(ISpot[][] state, int ver, int hor) {
    state[ver][hor] = new OutSpot();
  }

  @Override
  public void deployShip(ISpot[][] state, int ver, int hor, IShip ship) {
    state[ver][hor] = new ShipSpot(ship);

  }

  @Override
  public boolean isWater() {
    return true;
  }



}
