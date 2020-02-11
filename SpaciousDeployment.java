package battleship;

/**
 * Clase Spacious que implementa metodo de colocacion de barcos.
 * 
 * @author david
 *
 */

public class SpaciousDeployment implements IDeployment {

  @Override
  public boolean isAvailable(Territory territory, int hor, int ver) {
    if (territory.inRange(ver - 1, hor - 1)) {
      for (int i = -1; i <= 1; i++) {
        for (int j = -1; j <= 1; j++) {
          if (territory.inRange(ver - 1 + j, hor - 1 + i)
              && territory.state[ver - 1 + j][hor - 1 + i].isShip()) {
            return false;
          }
        }
      }
      return true;
    } else {
      return false;
    }
  }

  @Override
  public String getRule() {
    return "spacious";
  }

}
