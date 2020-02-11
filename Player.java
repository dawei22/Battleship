package battleship;

import battleship.attack.AttackResult;
import battleship.attack.IAttackResult;
import battleship.ship.IShip;

/**
 * Clase Player que representa a cada jugador.
 * 
 * @author david
 *
 */
public class Player {
  private String name;
  protected Territory territory;
  protected Fleet fleet;
  protected IDeployment deployMode;
  protected IVisualization visualizationMode;

  /**
   * Constructor, recibe nombre de jugador. Inicia todo en la configuracion por defecto.
   * 
   * @param name : nombre de jugador.
   */
  public Player(String name) {
    this.name = name;
    this.territory = new Territory();
    this.fleet = new Fleet();
    this.deployMode = new SpaciousDeployment();
    this.visualizationMode =
        new DesktopVisualization(this.name, this.territory, new TildeDisplay());
  }

  /**
   * Constructor por defecto.
   */

  public Player() {
    this.name = "a player";
    this.territory = new Territory();
    this.fleet = new Fleet();
    this.deployMode = new SpaciousDeployment();
    this.visualizationMode =
        new DesktopVisualization(this.name, this.territory, new TildeDisplay());

  }

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Territory getTerritory() {
    return this.territory;
  }

  public Fleet getFleet() {
    return this.fleet;
  }

  public IDeployment getDeploy() {
    return this.deployMode;
  }

  public IVisualization getVisualization() {
    return this.visualizationMode;
  }

  public IDisplay getDisplay() {
    return this.visualizationMode.getDisplay();
  }

  /**
   * Procedimiento cuando un barco es dañado. Se marca la casilla y se chequea si se hundio tal
   * barco
   * 
   * @param hor : posicion horizontal atacada.
   * @param ver : posicion vertical atacada.
   */

  public IAttackResult attacked(int hor, int ver) {
    this.territory.attacked(ver, hor);
    if (this.territory.state[ver][hor].isAttacked()) {
      IAttackResult result = new AttackResult(true);
      this.territory.addAttackedParts();
      IShip ship = this.territory.state[ver][hor].getShip();
      ship.shoot();
      if (ship.defeat()) {
        ship.getOrientation().defeat(this.territory.state, ship.getHomeRow(), ship.getHomeCol(),
            ship.getLength());
        result.setDefeat();
      }

      return result;
    } else {
      return new AttackResult(false);
    }

  }

  /**
   * Template para desplegar mesa de juego, con ambos territorios.
   * 
   * @param enemy : player enemigo
   * @return string que representa el tablero.
   */

  public String displayDesk(Player enemy) {
    return this.visualizationMode.displayWithInfo(this, enemy);
  }



  public void setDisplay(IDisplay displayMode) {
    this.visualizationMode.setDisplay(displayMode);
  }

}
