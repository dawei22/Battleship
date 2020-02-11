package battleship;

/**
 * Estado disparo fallido.
 * 
 * @author david
 *
 */

public class OutSpot extends AbstractSpot {

  @Override
  public boolean isOut() {
    return true;
  }

}
