package battleship;

import battleship.ship.IShip;

/**
 * Interfaz para distintos tipos de estados.
 * 
 * @author david
 *
 */

public interface ISpot {
  public boolean isOut();

  public boolean isShip();

  public boolean isAttacked();

  public boolean isDefeated();

  public boolean isWater();

  public void attacked(ISpot[][] state, int ver, int hor);

  public void defeated(ISpot[][] state, int ver, int hor);

  public void deployShip(ISpot[][] state, int ver, int hor, IShip ship);

  public void setShip(IShip ship);

  public IShip getShip();


}
