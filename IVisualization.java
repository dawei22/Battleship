package battleship;

/**
 * Interfaz para distintos tipos de visualizacion del juego.
 * 
 * @author david
 *
 */

public interface IVisualization {
  public void setDisplay(IDisplay displayMode);

  public IDisplay getDisplay();

  public String display();

  public void setTerritory(Territory territory);

  public char getSymbol(int row, int col);

  public String displayWithInfo(Player player, Player enemy);
  
  public String displayTerritory();


}
