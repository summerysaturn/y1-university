// The breakout controller converts key presses from the user (received by the View object)
// into commands for the game (in the Model object)

// we need to use on JavaFX class
import javafx.scene.input.KeyEvent;

/**
 * Controller class, which is the primary input handling from the View class, and communicates with the Model class
 * @author Charlotte Ward
 * @version 1.0
 */
public class Controller {

  /**
   * instance variable for the model component of the MVC. This value is set by the main class
   * @see Main#start
   */
  public Model model;
  /**
   * instance variable for the view component of the MVC. This value is set by the main class
   * @see Main#start
   */
  public View view;

  /**
   * Constructor method which outputs a debug message on initialisation. No other logic is included in the constructor.
   */
  public Controller() {
    Debug.trace("Controller::<constructor>");
  }

  /**
   * Primary method in the Controller class, takes in a Key Event from the View class, then uses that information to call a function in the Model class.
   * @param event KeyEvent from view class
   * @see View#handle
   */
  public void userKeyInteraction(KeyEvent event) {
    // print a debugging message to show a key has been pressed
    Debug.trace("Controller::userKeyInteraction: keyCode = " + event.getCode());

    // KeyEvent objects have a method getCode which tells us which key has been pressed.
    // KeyEvent also provides variables LEFT, RIGHT, F, N, S (etc) which are the codes
    // for individual keys. So you can add keys here just by using ther name (which you
    // can find out by googling 'JavaFX KeyCode')
    switch (event.getCode()) {
      case LEFT: // Left Arrow
        model.moveBat(-1); // move bat left
        break;
      case RIGHT: // Right arrow
        model.moveBat(+1); // Move bat right
        break;
      case F:
        // Very fast ball movement
        model.setFast(true);
        break;
      case N:
        // Normal speed ball movement
        model.setFast(false);
        break;
      case S:
        // stop the game
        model.setGameState("finished");
        break;
      default:
        break;
    }
  }
}
