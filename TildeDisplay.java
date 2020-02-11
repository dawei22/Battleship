package battleship;

/**
 * display con simbolos para desplegar en modo tilde.
 * 
 * @author david
 *
 */

public class TildeDisplay implements IDisplay {
  char shipSymbol = 'o';
  char waterSymbol = '~';
  char affectedSymbol = '+';
  char sinkSymbol = '#';
  char outSymbol = '.';

  @Override
  public char shipSymbol() {
    return this.shipSymbol;
  }

  @Override
  public char waterSymbol() {
    return this.waterSymbol;
  }

  @Override
  public String getDisplayName() {
    return "tilde";
  }

  @Override
  public char affectedSymbol() {
    return this.affectedSymbol;
  }

  @Override
  public char defeatSymbol() {
    return this.sinkSymbol;
  }

  @Override
  public char outSymbol() {
    return this.outSymbol;
  }

}
