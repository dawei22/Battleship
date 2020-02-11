package battleship;

/**
 * Clase que implementa visualizacion compacta.
 * 
 * @author david
 *
 */
public class CompactVisualization extends AbstractVisualization {

  /**
   * Constructor que recibe nombre del jugador.
   * 
   * @param name : nombre de jugador.
   * @param territory : territorio a desplegar.
   * @param displayMode : modo de despliegue de casillas.
   */
  public CompactVisualization(String name, Territory territory, IDisplay displayMode) {
    super(name, territory, displayMode);
  }

  @Override
  public String display() {
    this.rep.append('\n');
    for (int row = 0; row < this.territory.height; row++) {
      this.rep.append("   ");
      for (int col = 0; col < this.territory.width; col++) {

        this.rep.append(this.getSymbol(row, col));
      }
      if (row < this.territory.height - 1) {
        this.rep.append('\n');
      }

    }
    return rep.toString();
  }


}
