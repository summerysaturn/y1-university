// We need to access some JavaFX classes so we list ('import') them here
import javafx.application.Application;
import javafx.stage.Stage;

/**
 * The main class for the application, which instantiates the other classes
 * needed for correct operation.
 * @author Charlotte Ward
 * @version 1.0
 */
public class Main extends Application {

  // The 'main' method - this is only used when launching from the command line.
  /**
   * 'main' method, which is only utilised when running from the command line
   * @param args[] Command line arguments
   */
  public static void main(String args[]) {
    // 'launch' initialises the system and then calls 'start'
    // (When running in BlueJ, the menu option 'Run JavaFX Application'
    // calls 'start' itself)
    launch(args);
  }

  /**
   * The 'start' method, which instantiates the Model, View and Controller objects, then sets them up to talk to each other. This then instantiates the user interface (view object) and starts the game (model object).
   * @param window The JavaFX window (passed in by javafx)
   * @see Model
   * @see View
   * @see Controller
   */
  public void start(Stage window) {
    /**
     * Height of game window (in pixels)
     */
    int H = 800;
    /**
     * Width  of game window (in pixels)
     */
    int W = 600;

    // set up debugging and print initial debugging message
    Debug.set(true); // change this to 'false' to stop breakout printing messages
    Debug.trace("Main::start: Breakout starting");

    // Create the Model, View and Controller objects
    Model model = new Model(W, H);
    View view = new View(W, H);
    Controller controller = new Controller();

    // Link them together so they can talk to each other
    // Each one has instance variables for the other two
    model.view = view;
    model.controller = controller;

    controller.model = model;
    controller.view = view;

    view.model = model;
    view.controller = controller;

    // start up the game interface (the View object, passing it the window
    // object that JavaFX passed to this method, and then tell the model to
    // start the game
    view.start(window);
    model.startGame();

    // application is now running - print a debug message to say so
    Debug.trace("Main::start: Breakout running");
  }
}
