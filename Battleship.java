package battleship;

import battleship.attack.AttackResult;
import battleship.attack.IAttackResult;
import battleship.ship.IShip;
import battleship.ship.Ship;

import java.util.Iterator;

/**
 * Clase Battleship.
 * 
 * @author david.
 *
 */

public class Battleship {
  private final Player[] players = new Player[2];
  private int turn;
  private Player winner;


  /**
   * Constructor clase Battleship. Inicia una flota tradicional, un terreno de 10x10, visualización
   * Tilde regla Spacious.
   * 
   */

  public Battleship() {
    this.players[0] = new Player();
    this.players[1] = new Player();
    this.turn = 0;
  }

  /**
   * Constructor que recibe los dos jugadores.
   * 
   * @param playerOne : primer jugador.
   * @param playerTwo : segundo jugador.
   */
  public Battleship(Player playerOne, Player playerTwo) {
    this.players[0] = playerOne;
    this.players[1] = playerTwo;
    this.turn = 0;
  }

  public int getTurn() {
    return this.turn;
  }

  public Player getCurrentPlayer() {
    return players[turn];
  }

  public void swapTurn() {
    turn = turn == 0 ? 1 : 0;
  }

  /**
   * Chequea si hay o no un perdedor.
   * 
   * @return De haber perdedor, el otro jugador es el ganador.
   */
  public boolean checkWinner() {
    if (this.players[turn].getTerritory().lost()) {
      swapTurn();
      this.winner = players[turn];
      return true;
    } else {
      return false;
    }
  }


  public Player getWinner() {
    return this.winner;
  }

  /**
   * Setea parametros de territorio.
   * 
   * @param width : ancho.
   * @param height : alto.
   */

  public void setTerritorySize(int width, int height) {
    this.players[0].territory = new Territory(width, height);
    this.players[1].territory = new Territory(width, height);
    this.players[0].visualizationMode.setTerritory(this.players[0].territory);
    this.players[1].visualizationMode.setTerritory(this.players[1].territory);
  }


  public void setPlayerOneName(String name) {
    this.players[0].setName(name);
  }

  public void setPlayerTwoName(String name) {
    this.players[1].setName(name);
  }

  public int getTerritoryHeight() {
    return this.players[0].territory.getHeight();
  }

  public int getTerritoryWidth() {
    return this.players[0].territory.getWidth();
  }

  public String getPlayerOneName() {
    return this.players[0].getName();
  }

  public String getPlayerTwoName() {
    return this.players[1].getName();
  }

  public void useTildeDisplay() {
    this.players[0].visualizationMode.setDisplay(new TildeDisplay());
    this.players[1].visualizationMode.setDisplay(new TildeDisplay());
  }

  public void useSpaceDisplay() {
    this.players[0].visualizationMode.setDisplay(new SpaceDisplay());
    this.players[1].visualizationMode.setDisplay(new SpaceDisplay());
  }

  /**
   * Estable la visualizacion compacta.
   */
  public void useCompactDisplay() {
    this.players[0].visualizationMode =
        new CompactVisualization(this.players[0].getName(), this.players[0].territory,
            this.players[0].getDisplay());
    this.players[1].visualizationMode =
        new CompactVisualization(this.players[1].getName(), this.players[1].territory,
            this.players[1].getDisplay());

  }

  /**
   * Estable la visualizacion estandar.
   */
  public void useDesktopDisplay() {
    this.players[0].visualizationMode =
        new DesktopVisualization(this.players[0].getName(), this.players[0].territory,
            this.players[0].getDisplay());
    this.players[1].visualizationMode =
        new DesktopVisualization(this.players[1].getName(), this.players[1].territory,
            this.players[1].getDisplay());

  }

  /**
   * Estable la visualizacion estadar invertida.
   */

  public void useReverseDesktopDisplay() {
    this.players[0].visualizationMode =
        new ReverseVisualization(this.players[0].getName(), this.players[0].territory,
            this.players[0].getDisplay());
    this.players[1].visualizationMode =
        new ReverseVisualization(this.players[1].getName(), this.players[1].territory,
            this.players[1].getDisplay());

  }

  public String displayPlayerOneTerritory() {
    return this.players[0].visualizationMode.displayTerritory();
  }

  public String displayPlayerTwoTerritory() {
    return this.players[1].visualizationMode.displayTerritory();
  }

  /**
   * despliega mesa de primer jugador.
   * 
   * @return : string representativo
   */
  public String displayPlayerOneDesk() {
    String result = this.players[0].displayDesk(this.players[1]);
    this.players[1].setDisplay(this.players[0].getDisplay());
    return result;
  }

  /**
   * despliega mesa de segundo jugador.
   * 
   * @return : string representativo
   */

  public String displayPlayerTwoDesk() {
    String result = this.players[1].displayDesk(this.players[0]);
    this.players[0].setDisplay(this.players[1].getDisplay());
    return result;

  }

  public void useTraditionalFleet() {
    this.players[0].fleet.traditionalFleet();
    this.players[1].fleet.traditionalFleet();
  }

  public void useTacticalFleet() {
    this.players[0].fleet.tacticalFleet();
    this.players[1].fleet.tacticalFleet();
  }

  public void useCustomFleet() {
    this.players[0].fleet.costumFleet();
    this.players[1].fleet.costumFleet();
  }

  public void useTightDeployment() {
    this.players[0].deployMode = new TightDeployment();
    this.players[1].deployMode = new TightDeployment();
  }

  public void useSpaciousDeployment() {
    this.players[0].deployMode = new SpaciousDeployment();
    this.players[1].deployMode = new SpaciousDeployment();
  }


  public void addShip(String shipName, int shipLength) {
    this.players[0].fleet.add(new Ship(shipName, shipLength));
    this.players[1].fleet.add(new Ship(shipName, shipLength));
  }


  public int getFleetSize() {
    return this.players[0].fleet.size();
  }

  public Iterator<IShip> getFleetIterator() {
    return this.players[0].fleet.iterator();
  }

  /**
   * Primer jugador coloca un barco en determinada posicion horizontalmente.
   * 
   * @param horizontalPosition : posicion horizontal
   * @param verticalPosition : posicion vertical
   * @return : Barco, si pudo ser colocado
   */

  public IShip playerOneDeployHorizontally(int horizontalPosition, int verticalPosition) {
    IPosition horizontal = new HorizontalPosition(horizontalPosition, verticalPosition);
    return horizontal.deploy(this.players[0].fleet.getNext(), this.players[0].territory,
        this.players[0].deployMode, this.players[0].fleet);
  }

  /**
   * Primer jugador coloca un barco en determinada posicion verticalmente.
   * 
   * @param horizontalPosition : posicion horizontal
   * @param verticalPosition : posicion vertical
   * @return : Barco, si pudo ser colocado
   */

  public IShip playerOneDeployVertically(int horizontalPosition, int verticalPosition) {
    IPosition vertical = new VerticalPosition(horizontalPosition, verticalPosition);
    return vertical.deploy(this.players[0].fleet.getNext(), this.players[0].territory,
        this.players[0].deployMode, this.players[0].fleet);
  }

  /**
   * Segundo jugador coloca un barco en determinada posicion horizontalmente.
   * 
   * @param horizontalPosition : posicion horizontal
   * @param verticalPosition : posicion vertical
   * @return : Barco, si pudo ser colocado
   */

  public IShip playerTwoDeployHorizontally(int horizontalPosition, int verticalPosition) {
    IPosition horizontal = new HorizontalPosition(horizontalPosition, verticalPosition);
    return horizontal.deploy(this.players[1].fleet.getNext(), this.players[1].territory,
        this.players[1].deployMode, this.players[1].fleet);
  }

  /**
   * Segundo jugador coloca un barco en determinada posicion verticalmente.
   * 
   * @param horizontalPosition : posicion horizontal
   * @param verticalPosition : posicion vertical
   * @return : Barco, si pudo ser colocado
   */

  public IShip playerTwoDeployVertically(int horizontalPosition, int verticalPosition) {
    IPosition vertical = new VerticalPosition(horizontalPosition, verticalPosition);
    return vertical.deploy(this.players[1].fleet.getNext(), this.players[1].territory,
        this.players[1].deployMode, this.players[1].fleet);
  }

  public long playerOneNumberOfDeployedShips() {
    return this.players[0].fleet.getDeployedShips();
  }

  public long playerOneNumberOfAnchoredShips() {
    return this.players[0].fleet.getAnchoredShips();
  }

  public long playerTwoNumberOfDeployedShips() {
    return this.players[1].fleet.getDeployedShips();
  }

  public long playerTwoNumberOfAnchoredShips() {
    return this.players[1].fleet.getAnchoredShips();
  }

  public boolean isPlayerOneShipAt(int horizontalPosition, int verticalPosition) {
    return this.players[0].territory.isShipAt(horizontalPosition - 1, verticalPosition - 1);
  }

  public boolean isPlayerTwoShipAt(int horizontalPosition, int verticalPosition) {
    return this.players[1].territory.isShipAt(horizontalPosition - 1, verticalPosition - 1);
  }

  /**
   * Implementa ataque de primer jugador a determinada posicion.
   * 
   * @param horizontally : posicion horizontal atacada.
   * @param vertically : posicion vertical atacada.
   * @return : resultado del ataque
   */

  public IAttackResult playerOneAttackAt(int horizontally, int vertically) {
    if (this.players[1].territory.inRange(vertically - 1, horizontally - 1)
        && !this.players[1].territory.state[vertically - 1][horizontally - 1].isAttacked()
        && !this.players[1].territory.state[vertically - 1][horizontally - 1].isDefeated()) {
      return this.players[1].attacked(horizontally - 1, vertically - 1);
    } else {
      return new AttackResult(false);
    }
  }

  /**
   * Implementa ataque de segundo jugador a determinada posicion.
   * 
   * @param horizontally : posicion horizontal atacada.
   * @param vertically : posicion vertical atacada.
   * @return : resultado del ataque
   */

  public IAttackResult playerTwoAttackAt(int horizontally, int vertically) {
    if (this.players[0].territory.inRange(vertically - 1, horizontally - 1)
        && !this.players[0].territory.state[vertically - 1][horizontally - 1].isAttacked()
        && !this.players[0].territory.state[vertically - 1][horizontally - 1].isDefeated()) {
      return this.players[0].attacked(horizontally - 1, vertically - 1);
    } else {
      return new AttackResult(false);
    }
  }

  public Player getPlayerOne() {
    return this.players[0];
  }

  public Player getPlayerTwo() {
    return this.players[1];
  }

}
