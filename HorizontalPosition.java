package battleship;

import battleship.ship.IShip;

/**
 * Clase que implementa movimientos horizontales en tablero.
 * 
 * @author david
 *
 */

public class HorizontalPosition extends AbstractPosition {

  /**
   * Constructor, recibe coordenadas iniciales.
   * 
   * @param hor : coordenada horizontal.
   * @param ver : coordenada vertical.
   */

  public HorizontalPosition(int hor, int ver) {
    super(hor, ver);
  }

  @Override
  public boolean check(IDeployment deployMode, int lengthShip, Territory territory) {
    for (int i = 0; i < lengthShip; i++) {
      if (!deployMode.isAvailable(territory, this.getHorizontal() + i, this.getVertical())) {
        return false;
      }
    }
    return true;
  }

  @Override
  public void set(int index, Territory territory, IShip ship) {
    territory.state[this.ver - 1][this.hor - 1 + index].deployShip(territory.state, this.ver - 1,
        this.hor - 1 + index, ship);
  }

  @Override
  public void defeat(ISpot[][] state, int ver, int hor, int shipLength) {
    for (int i = 0; i < shipLength; i++) {
      state[ver][hor + i].defeated(state, ver, hor + i);
    }

  }
  
  @Override
  public boolean isHorizontal() {
    return true;
  }

}
