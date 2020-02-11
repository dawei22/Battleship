package battleship;

/**
 * Implementa visualizacion estandar invertida.
 * 
 * @author david
 *
 */

public class ReverseVisualization extends AbstractVisualization {

  public ReverseVisualization(String name, Territory territory, IDisplay displayMode) {
    super(name, territory, displayMode);
  }

  @Override
  public String display() {
    this.rep.append(this.header(this.territory.width));
    for (int row = 0; row < this.territory.height; row++) {
      this.rep.append(" ");
      this.rep.append(Character.toChars(row + 65));
      this.rep.append(" ");
      for (int col = 0; col < this.territory.width; col++) {
        this.rep.append(this.getSymbol(row, col));
      }
      if (row < this.territory.height - 1) {
        this.rep.append('\n');
      }

    }
    return rep.toString();
  }

  /**
   * Crea el campo que indica columnas.
   * 
   * @param width : ancho de campo
   * @return : string que representa indice de columnas.
   */

  public StringBuffer header(int width) {
    StringBuffer head = new StringBuffer();
    head.append("   ");
    for (int i = 1; i <= width; i++) {
      head.append(i);
    }
    head.append('\n');
    return head;
  }

}
