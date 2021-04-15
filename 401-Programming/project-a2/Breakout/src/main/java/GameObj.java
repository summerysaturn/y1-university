// An object in the game, represented as a rectangle, with a position,
// a size, a colour and a direction of movement.

// import Athe JavaFX Color class
import javafx.scene.paint.Color;

/**
 * An object in the game, represented as a rectangle, with a position, a size, a colour and a direction of movement. This class is instanced in {@link Model#initialiseGame}
 */
public class GameObj {

  /**
   * Controls the visibility of the object
   */
  public boolean visible = true;
  /**
   * Position from the top left corner in the X dimesion (left to right)
   */
  public int topX = 0;
  /**
   * Position from the top left corner in the Y dimesion (top to bottom)
   */
  public int topY = 0;
  /**
   * Width of the object
   */
  public int width = 0;
  /**
   * Height of object
   */
  public int height = 0;
  /**
   * Colour of object
   */
  public Color colour;
  /**
   * Movement value in the X dimension (1, 0 or -1)
   */
  public int dirX = 1;
  /**
   * Movement value in the Y dimension (1, 0 or -1)
   */
  public int dirY = 1;

  /**
   * Constructor method for the Game Object
   * @param x topX value (left to right), integer
   * @param y topY value (top to bottom), integer
   * @param w width value, integer
   * @param h height value, integer
   * @param c Color of the object
   */
  public GameObj(int x, int y, int w, int h, Color c) {
    topX = x;
    topY = y;
    width = w;
    height = h;
    colour = c;
  }

  /**
   * Method to move the object in the X axis
   * @param units value to move by
   */
  public void moveX(int units) {
    topX += units * dirX;
  }

  /**
   * Method to move the object in the Y axis
   * @param units value to move by
   */
  public void moveY(int units) {
    topY += units * dirY;
  }

  /**
   * Method to swap the move direction in the X axis
   */
  public void changeDirectionX() {
    dirX = -dirX;
  }

  /**
   * Method to swap the move direction in the Y axis
   */
  public void changeDirectionY() {
    dirY = -dirY;
  }

  // Detect collision between this object and the argument object
  // It's easiest to work out if they do NOT overlap, and then
  // return the opposite
  /**
   * Collision detection algorithm, works by detecting if objects don't overlap and then returning the inverse of that value.
   * @param obj GameObj we're detecting collision with
   * @return boolean, collision detected
   */
  public boolean hitBy(GameObj obj) {
    boolean separate =
      topX >= obj.topX + obj.width || // '||' means 'or'
      topX + width <= obj.topX ||
      topY >= obj.topY + obj.height ||
      topY + height <= obj.topY;

    // use ! to return the opposite result - hitBy is 'not separate')
    return (!separate);
  }
}
