package battleship;

/**
 * Clase abstracta que implementa interfaz de tipos de visualizaciones. Contiene settes, getter y
 * metodo getSymbol para asociar simbolo a casilla del tablero.
 * 
 * @author david
 *
 */
public abstract class AbstractVisualization implements IVisualization {
  protected IDisplay displayMode;
  protected StringBuffer rep;
  protected Territory territory;
  protected String name;

  /**
   * Constructor.
   * 
   * @param name : nombre de jugador.
   * @param territory : terreno a desplegar.
   * @param displayMode : modo de despliegue de casillas.
   */
  public AbstractVisualization(String name, Territory territory, IDisplay displayMode) {
    this.displayMode = displayMode;
    this.rep = new StringBuffer();
    this.name = name;
    this.territory = territory;
  }

  public void setTerritory(Territory territory) {
    this.territory = territory;
  }

  @Override
  public void setDisplay(IDisplay displayMode) {
    this.displayMode = displayMode;
  }

  @Override
  public IDisplay getDisplay() {
    return this.displayMode;
  }

  @Override
  public char getSymbol(int row, int col) {
    if (this.territory.state[row][col].isAttacked()) {
      if (this.territory.state[row][col].isOut()) {
        return this.displayMode.outSymbol();
      } else {
        if (this.territory.state[row][col].isDefeated()) {
          return this.displayMode.defeatSymbol();
        } else {
          return this.displayMode.affectedSymbol();
        }
      }
    } else {
      if (this.territory.state[row][col].isShip()) {
        return this.displayMode.shipSymbol();
      } else {
        return this.displayMode.waterSymbol();
      }
    }
  }

  @Override
  public String displayWithInfo(Player player, Player enemy) {
    StringBuffer repAux = new StringBuffer();
    repAux.append('\n');
    repAux.append("Player: " + player.getName() + '\n');
    repAux.append(" with " + player.getTerritory().getAttackedParts() + " out of "
        + player.getTerritory().getTotalParts() + " affected ship parts." + '\n' + '\n');
    repAux.append(player.visualizationMode.display());
    repAux.append('\n');
    repAux.append('\n');
    repAux.append("Opponent player: " + enemy.getName() + '\n');
    repAux.append(" with " + enemy.getTerritory().getAttackedParts() + " out of "
        + enemy.getTerritory().getTotalParts() + " affected ship parts." + '\n' + '\n');
    enemy.visualizationMode.setDisplay(new OppositeDisplay());
    enemy.visualizationMode.setTerritory(enemy.getTerritory());
    repAux.append(enemy.visualizationMode.display());
    return repAux.toString();

  }

  @Override
  public String displayTerritory() {
    for (int row = 0; row < this.territory.height; row++) {
      for (int col = 0; col < this.territory.width; col++) {
        this.rep.append(this.getSymbol(row, col));
      }
      if (row < this.territory.height) {
        this.rep.append('\n');
      }
    }
    return rep.toString();
  }
}
