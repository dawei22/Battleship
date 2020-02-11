package battleship;

/**
 * Clase Tight que implementa metodo de colocacion de barcos.
 * 
 * @author david
 *
 */
public class TightDeployment implements IDeployment {


  @Override
  public boolean isAvailable(Territory territory, int hor, int ver) {
    return territory.inRange(ver - 1, hor - 1) && !territory.state[ver - 1][hor - 1].isShip();
  }

  @Override
  public String getRule() {
    return "tight";
  }

}
