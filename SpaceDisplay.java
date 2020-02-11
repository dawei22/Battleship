package battleship;

/**
 * Display con simbolos para desplegar en modo Space.
 * 
 * @author david
 *
 */

public class SpaceDisplay implements IDisplay {
  char shipSymbol = '*';
  char waterSymbol = ' ';
  char affectedSymbol = 'x';
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
    return "space";
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
