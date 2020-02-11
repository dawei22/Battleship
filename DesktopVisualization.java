package battleship;

/**
 * Clase que implementa metodo de visualizacion estandar.
 * 
 * @author david
 *
 */

public class DesktopVisualization extends AbstractVisualization {

  public DesktopVisualization(String name, Territory territory, IDisplay displayMode) {
    super(name, territory, displayMode);
  }

  @Override
  public String display() {
    this.rep.append(this.header(this.territory.width));
    for (int row = 1; row <= this.territory.height; row++) {
      if (row <= 9) {
        this.rep.append(" ");
      }
      this.rep.append(row);
      this.rep.append(" ");
      for (int col = 0; col < this.territory.width; col++) {
        this.rep.append(this.getSymbol(row - 1, col));
      }
      if (row < this.territory.height) {
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
    for (int i = 0; i < width; i++) {
      head.append(Character.toChars(i + 65));
    }
    head.append('\n');
    return head;
  }

}
