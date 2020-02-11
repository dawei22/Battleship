package battleship;

/**
 * Clase Territorio. Contiene ancho, largo, tipo de visualizacion del mapa (tilde o space) y arreglo
 * que lo representa.
 * 
 * @author david
 *
 */
public class Territory {
  protected int width = 10;
  protected int height = 10;
  protected ISpot[][] state;
  protected int totalParts;
  protected int attackedParts;

  /**
   * Constructor de la clase. Setea la configuracion inicial del tablero.
   */

  public Territory() {
    this.state = new ISpot[this.height][this.width];
    for (int i = 0; i < this.width; i++) {
      for (int j = 0; j < this.height; j++) {
        state[j][i] = new WaterSpot();
      }
    }
    this.totalParts = 0;
    this.attackedParts = 0;
  }

  /**
   * Constructor que recibe parámetros distintos para dimensiones de tablero.
   */

  public Territory(int width, int heigth) {
    this.width = width;
    this.height = heigth;
    this.state = new ISpot[this.height][this.width];
    for (int i = 0; i < this.width; i++) {
      for (int j = 0; j < this.height; j++) {
        state[j][i] = new WaterSpot();
      }
    }
    this.totalParts = 0;
    this.attackedParts = 0;
  }

  public int getWidth() {
    return this.width;
  }

  public int getHeight() {
    return this.height;
  }
  
  public void setWidth(int width) {
    this.width = width;
  }
  
  public void setHeight(int height) {
    this.height = height;
  }

  public boolean inRange(int ver, int hor) {
    return ver >= 0 && ver < this.height && hor >= 0 && hor < this.width;
  }

  /**
   * Revisa si hay barco en determinada posicion.
   * 
   * @param horizontalPosition : posicion horizontal.
   * @param verticalPosition : posicion vertical.
   * @return : booleano.
   */

  public boolean isShipAt(int horizontalPosition, int verticalPosition) {
    if (inRange(verticalPosition, horizontalPosition)) {
      return this.state[verticalPosition][horizontalPosition].isShip();
    } else {
      return false;
    }
  }

  public int getTotalParts() {
    return this.totalParts;
  }

  public int getAttackedParts() {
    return this.attackedParts;
  }

  public void addTotalParts() {
    this.totalParts++;
  }

  public void addAttackedParts() {
    this.attackedParts++;
  }
  
  public ISpot[][] getState() {
    return this.state;
  }

  public void attacked(int ver, int hor) {
    this.state[ver][hor].attacked(this.state, ver, hor);
  }

  public boolean lost() {
    return this.attackedParts == this.totalParts;
  }


}
