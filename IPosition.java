package battleship;

import battleship.ship.IShip;

/**
 * Interfaz de posibles movimientos en el tablero.
 * 
 * @author david
 *
 */

public interface IPosition {
  public IShip deploy(IShip ship, Territory territory, IDeployment deployMode, Fleet fleet);

  public int getHorizontal();

  public int getVertical();
  
  public void defeat(ISpot[][] state, int ver, int hor, int shipLength);
  
  public boolean isHorizontal();
  
  public boolean isVertical();

}
