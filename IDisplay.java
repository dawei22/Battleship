package battleship;

/**
 * Interfaz para tipos de display. Funciones devuelven simbolo asociado a cada estado posible.
 * 
 * @author david
 *
 */

public interface IDisplay {

  public String getDisplayName();

  public char shipSymbol();

  public char waterSymbol();

  public char affectedSymbol();

  public char defeatSymbol();

  public char outSymbol();


}
