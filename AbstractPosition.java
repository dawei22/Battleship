package battleship;

import battleship.ship.IShip;
import battleship.ship.NullShip;

/**
 * Clase abstracta que implementa interfaz de posicion. Metodos set/get y deploy generalizados.
 * 
 * @author david
 *
 */
public abstract class AbstractPosition implements IPosition {
  public int hor;
  public int ver;



  public AbstractPosition(int hor, int ver) {
    this.hor = hor;
    this.ver = ver;
  }

  @Override
  public int getHorizontal() {
    return this.hor;
  }

  @Override
  public int getVertical() {
    return this.ver;
  }

  @Override
  public IShip deploy(IShip ship, Territory territory, IDeployment deployMode, Fleet fleet) {
    if (ship.isShip()) {
      if (this.check(deployMode, ship.getLength(), territory)) {
        ship.setOrientation(this);
        ship.setHome(this.getVertical() - 1, this.getHorizontal() - 1);
        for (int ind = 0; ind < ship.getLength(); ind++) {
          this.set(ind, territory, ship);
          territory.addTotalParts();
        }
        fleet.deployedShips++;
        return ship;
      } else {
        return new NullShip();
      }

    } else {
      return new NullShip();
    }

  }
  
  public boolean isHorizontal() {
    return false;
  }
  
  public boolean isVertical() {
    return false;
  }

  public abstract boolean check(IDeployment deployMode, int lengthShip, Territory territory);

  public abstract void set(int index, Territory territory, IShip ship);

}
