package battleship;

import battleship.ship.IShip;
import battleship.ship.NullShip;
import battleship.ship.Ship;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Clase Fleet, representa la flota disponible.
 * 
 * @author david.
 *
 */
public class Fleet {
  public ArrayList<IShip> fleet;
  public long deployedShips = 0;
  public Iterator<IShip> shipIterator;

  /**
   * Constructor por defecto, inicia flota tradicional.
   */
  public Fleet() {
    this.fleet = new ArrayList<IShip>();
    this.fleet.add(new Ship("Aircraft carrier", 5));
    this.fleet.add(new Ship("Battleship", 4));
    this.fleet.add(new Ship("Submarine", 3));
    this.fleet.add(new Ship("Destroyer", 3));
    this.fleet.add(new Ship("Patrol boat", 2));
    this.shipIterator = this.iterator();
  }


  /**
   * Ingresa a la flota los barcos de la configuracion tradicional.
   */

  public void traditionalFleet() {
    this.fleet = new ArrayList<IShip>();
    this.fleet.add(new Ship("Aircraft carrier", 5));
    this.fleet.add(new Ship("Battleship", 4));
    this.fleet.add(new Ship("Submarine", 3));
    this.fleet.add(new Ship("Destroyer", 3));
    this.fleet.add(new Ship("Patrol boat", 2));
    this.deployedShips = 0;
    this.shipIterator = this.iterator();
  }

  /**
   * Ingresa a la flota los barcos de la configuracion tactica.
   */

  public void tacticalFleet() {
    this.fleet = new ArrayList<IShip>();
    this.fleet.add(new Ship("Aircraft carrier", 5));
    this.fleet.add(new Ship("Battleship", 4));
    this.fleet.add(new Ship("Cruiser", 3));
    this.fleet.add(new Ship("Destroyer", 2));
    this.fleet.add(new Ship("Destroyer", 2));
    this.fleet.add(new Ship("Submarine", 1));
    this.fleet.add(new Ship("Submarine", 1));
    this.deployedShips = 0;
    this.shipIterator = this.iterator();
  }

  /**
   * Inicia flota costum.
   */

  public void costumFleet() {
    this.fleet = new ArrayList<IShip>();
    this.deployedShips = 0;
    this.shipIterator = this.iterator();
  }

  public boolean isEmpty() {
    return this.fleet.isEmpty();
  }

  /**
   * Agrega barco a la flota.
   * 
   * @param ship : barco a agregar.
   */

  public void add(IShip ship) {
    this.fleet.add(ship);
  }

  public int size() {
    return this.fleet.size();
  }

  public Iterator<IShip> iterator() {
    return this.fleet.iterator();
  }

  public IShip get(int ind) {
    return this.fleet.get(ind);
  }

  public long getDeployedShips() {
    return this.deployedShips;
  }

  public long getAnchoredShips() {
    return this.size() - this.deployedShips;
  }

  /**
   * Retorna proximo barco en la flota, de acuerdo al iterador.
   * 
   * @return proximo barco.
   */

  public IShip getNext() {
    if (this.shipIterator.hasNext()) {
      return this.shipIterator.next();
    } else {
      return new NullShip();
    }
  }

}
