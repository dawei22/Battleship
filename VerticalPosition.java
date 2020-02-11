package battleship;

import battleship.ship.IShip;

/**
 * clase que implementa movimientos verticales en tablero.
 * 
 * 
 * @author david
 *
 */
public class VerticalPosition extends AbstractPosition {

  /**
   * constructor, recibe coordenadas iniciales.
   * 
   * @param hor : coordenada horizontal.
   * @param ver : coordenada vertical.
   */
  public VerticalPosition(int hor, int ver) {
    super(hor, ver);
  }

  @Override
  public boolean check(IDeployment deployMode, int lengthShip, Territory territory) {
    for (int i = 0; i < lengthShip; i++) {
      if (!deployMode.isAvailable(territory, this.getHorizontal(), this.getVertical() + i)) {
        return false;
      }
    }
    return true;
  }

  @Override
  public void set(int index, Territory territory, IShip ship) {
    territory.state[this.ver - 1 + index][this.hor - 1].deployShip(territory.state, this.ver - 1
        + index, this.hor - 1, ship);

  }


  @Override
  public void defeat(ISpot[][] state, int ver, int hor, int shipLength) {
    for (int i = 0; i < shipLength; i++) {
      state[ver + i][hor].defeated(state, ver + i, hor);
    }

  }

  @Override
  public boolean isVertical() {
    return true;
  }

}
