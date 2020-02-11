package battleship;

import battleship.ship.IShip;
import battleship.ship.NullShip;

/**
 * Clase abstracta para spots.
 * 
 * @author david
 *
 */

public abstract class AbstractSpot implements ISpot {
  protected IShip ship;

  public AbstractSpot() {
    this.ship = new NullShip();
  }

  public AbstractSpot(IShip ship) {
    this.ship = ship;
  }

  @Override
  public IShip getShip() {
    return this.ship;
  }

  @Override
  public void setShip(IShip ship) {
    this.ship = ship;
  }

  @Override
  public void attacked(ISpot[][] state, int ver, int hor) {
    throw new RuntimeException();
  }

  @Override
  public void defeated(ISpot[][] state, int ver, int hor) {
    throw new RuntimeException();
  }

  @Override
  public void deployShip(ISpot[][] state, int ver, int hor, IShip ship) {
    throw new RuntimeException();
  }

  public boolean isOut() {
    return false;
  }

  public boolean isShip() {
    return false;
  }

  public boolean isAttacked() {
    return false;
  }

  public boolean isDefeated() {
    return false;
  }

  public boolean isWater() {
    return false;
  }
}
