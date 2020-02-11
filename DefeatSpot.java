package battleship;

import battleship.ship.IShip;

/**
 * Estado derrotado.
 * 
 * @author david
 *
 */

public class DefeatSpot extends AbstractSpot {

  public DefeatSpot(IShip ship) {
    super(ship);
  }

  @Override
  public boolean isDefeated() {
    return true;
  }

}
