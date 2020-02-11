package battleship;

/**
 * Interfaz para metodo para colocacion de barcos.
 * 
 * @author david
 *
 */

public interface IDeployment {

  public boolean isAvailable(Territory territory, int hor, int ver);

  public String getRule();

}
