import java.util.ArrayList;
import java.text.DecimalFormat;
import java.text.NumberFormat;

// The model represents all the actual content and functionality of the app
// For the ATM, it keeps track of the information shown in the display
// (the title and two message boxes), and the interaction with the bank,
// executes
// commands provided by the controller and tells the view to update when
// something changes

/**
 * The Model component in the Model/View/Controller framework in this
 * application
 *
 * @see Main
 */
public class Model {
  /**
   * Immutable variable for account state
   */
  final String ACCOUNT_NO = "account_no";
  /**
   * Immutable variable for account state
   */
  final String PASSWORD = "password";
  /**
   * Immutable variable for account state
   */
  final String LOGGED_IN = "logged_in";

  final String SUBSTATE_NONE = "none";
  final String SUBSTATE_DEPOSIT = "deposit";
  final String SUBSTATE_WITHDRAW = "withdraw";
  final String SUBSTATE_BALANCE = "balance";
  final String SUBSTATE_STATEMENT = "statement";

  /**
   * the state the app is in
   */
  String state = ACCOUNT_NO;
  /**
   * the substate the app is in, for various functions
   */
  String substate = SUBSTATE_NONE;
  /**
   * current number displayed in GUI (as a number, not a string)
   */
  int number = 0;
  /**
   * The ATM talks to a bank, represented by the Bank object.
   */
  Bank bank = null;
  /**
   * Account number typed in
   */
  int accNumber = -1;
  /**
   * Password typed in
   */
  int accPasswd = -1;

  /**
   * The contents of the title message
   */
  String title = "Bank ATM";
  /**
   * The contents of the Message 1 box (a single line)
   */
  String display1 = null;
  /**
   * The contents of the Message 2 box (may be multiple lines)
   */
  String display2 = null;

  /**
   * View module set by Main
   *
   * @see Main
   */
  public View view;
  /**
   * Controller module set by Main
   *
   * @see Main
   */
  public Controller controller;

  /**
   * Constructor with a Bank reference
   *
   * @param b Bank object, set by Main
   * @see Main
   */
  public Model(Bank b) {
    Debug.trace("Model::<constructor>");
    bank = b;
  }

  /**
   * Initialise the ATM with no account, setting the number to 0, and setting the
   * display message as an instruction to log in.
   *
   * @param message The message on the top to be displayed.
   */
  public void initialise(String message) {
    setState(ACCOUNT_NO);
    number = 0;
    display1 = message;
    display2 = "Enter your account number\n" + "Followed by \"Ent\"";
  }

  /**
   * Method to change state, controls login state
   *
   * @param newState State derived from the immutable state strings
   */
  public void setState(String newState) {
    if (!state.equals(newState)) {
      String oldState = state;
      state = newState;
      Debug.trace("Model::setState: changed state from " + oldState + " to " + newState);
    }
  }

  /**
   * Method to change substate, utilised by the various functions in the app
   *
   * @param newSubstate Substate derived from the immutable state strings
   */
  public void setSubstate(String newSubstate) {
    if (!substate.equals(newSubstate)) {
      String oldSubstate = substate;
      substate = newSubstate;
      Debug.trace("Model::setState: changed state from " + oldSubstate + " to " + newSubstate);
    }
  }

  /**
   * Method called by the controller to change the model. This method is utilised
   * by the number buttons on the GUI.
   *
   * @param label String constituting the text of the button
   * @see Controller
   * @see Model
   */
  public void processNumber(String label) {
    // a little magic to turn the first char of the label into an int
    // and update the number variable with it
    char c = label.charAt(0);
    number = number * 10 + c - '0'; // Build number
    // show the new number in the display
    display1 = "" + number;
    display(); // update the GUI
  }

  /**
   * Method called by the controller to change the model. This method is utilised
   * by the clear button on the GUI.
   *
   * @see Controller
   * @see Model
   */
  public void processClear() {
    // clear the number stored in the model
    number = 0;
    display1 = "";
    display(); // update the GUI
  }

  /**
   * Method called by the controller to change the model. This method is utilised
   * by the enter button on the GUI. This has some more complex logic which
   * switches based on the immutable string states: case ACCOUNT_NO forwards the
   * state to PASSWORD, and gathers the data entered for the account number, case
   * PASSWORD gathers the data entered for the password and attempts a login. case
   * LOGGED_IN doesn't do anything as we're already logged in.
   *
   * @see Controller
   * @see Model
   */
  public void processEnter() {
    // Enter was pressed - what we do depends what state the ATM is already in
    switch (state) {
      case ACCOUNT_NO:
        // we were waiting for a complete account number - save the number we have
        // reset the tyed in number to 0 and change to the state where we are expecting
        // a password
        accNumber = number;
        number = 0;
        setState(PASSWORD);
        display1 = "";
        display2 = "Now enter your password\n" + "Followed by \"Ent\"";
        break;
      case PASSWORD:
        // we were waiting for a password - save the number we have as the password
        // and then cotnact the bank with accumber and accPasswd to try and login to
        // an account
        accPasswd = number;
        number = 0;
        display1 = "";
        // now check the account/password combination. If it's ok go into the LOGGED_IN
        // state, otherwise go back to the start (by re-initialsing)
        if (bank.login(accNumber, accPasswd)) {
          setState(LOGGED_IN);
          display2 = "Accepted\n" + "Now enter the transaction you require";
        } else {
          initialise("Unknown account/password");
        }
        break;
      case LOGGED_IN:
        switch (substate) {
          case SUBSTATE_BALANCE:
            break;
          case SUBSTATE_DEPOSIT:
            processDeposit();
            break;
          case SUBSTATE_STATEMENT:
            break;
          case SUBSTATE_WITHDRAW:
            processWithdraw();
            break;
          case SUBSTATE_NONE:
          default:
            break;
        }
        setSubstate(SUBSTATE_NONE);
      default:
        // do nothing in any other state (ie logged in)
        break;
    }
    display(); // update the GUI
  }

  public void setWithdraw() {
    if (state.equals(LOGGED_IN)) {
      setSubstate(SUBSTATE_WITHDRAW);

      number = 0;
      display1 = "";
      display2 = "Enter the value you'd like to withdraw\n" + "Your current balance is "
          + formatCurrency(bank.getBalance());

    } else {
      initialise("You are not logged in");
    }

    display(); // update the GUI
  }

  /**
   * Method called by the controller to withdraw money. Checks if logged in then
   * calls bank.withdraw().
   *
   * @see Controller
   * @see Model
   */
  public void processWithdraw() {
    if (state.equals(LOGGED_IN)) {
      if (bank.withdraw(number)) {
        display2 = "Withdrawn: " + formatCurrency(number) + "\n" + "Your new balance is "
            + formatCurrency(bank.getBalance());
      } else {
        display2 = "You do not have sufficient funds";
      }
      number = 0;
      display1 = "";
    } else {
      initialise("You are not logged in");
    }

    display(); // update the GUI
  }

  public void setDeposit() {
    if (state.equals(LOGGED_IN)) {
      setSubstate(SUBSTATE_DEPOSIT);

      number = 0;
      display1 = "";
      display2 = "Enter the value you'd like to deposit\n" + "Your current balance is "
          + formatCurrency(bank.getBalance());

    } else {
      initialise("You are not logged in");
    }

    display(); // update the GUI
  }

  /**
   * Method called by the controller to deposit money. Checks if logged in then
   * calls bank.deposit().
   *
   * @see Controller
   * @see Model
   */
  public void processDeposit() {
    if (state.equals(LOGGED_IN)) {

      setSubstate(SUBSTATE_DEPOSIT);

      bank.deposit(number);
      display1 = "";
      display2 = "Deposited: " + formatCurrency(number) + "\n" + "Your new balance is "
          + formatCurrency(bank.getBalance());
      number = 0;
    } else {
      initialise("You are not logged in");
    }
    display(); // update the GUI
  }

  /**
   * Method called by the controller to get the balance of the account. Checks if
   * logged in then calls bank.getBalance().
   *
   * @see Controller
   * @see Model
   */
  public void setBalance() {
    if (state.equals(LOGGED_IN)) {

      setSubstate(SUBSTATE_BALANCE);

      number = 0;
      display2 = "Your balance is: " + formatCurrency(bank.getBalance());
    } else {
      initialise("You are not logged in");
    }
    display(); // update the GUI
  }

  /**
   * Method called by the controller to logout. Checks if logged in then logs out.
   *
   * @see Controller
   * @see Model
   */
  public void processFinish() {
    if (state.equals(LOGGED_IN)) {
      // go back to the log in state
      setState(ACCOUNT_NO);
      number = 0;
      display2 = "Welcome: Enter your account number";
      bank.logout();
    } else {
      initialise("You are not logged in");
    }
    display(); // update the GUI
  }

  /**
   * Method called by the controller to get a bank statement. Checks if logged in
   * then calls bank.getHistory() and displays the ArrayList of Strings.
   *
   * @see Controller
   * @see Model
   */
  public void setStatement() {
    if (state.equals(LOGGED_IN)) {

      setSubstate(SUBSTATE_STATEMENT);

      ArrayList<String> transactionHistory = bank.getHistory();
      display2 = "";

      for (int i = 0; i < transactionHistory.size(); i++) {
        display2 += transactionHistory.get(i) + "\n";
      }

    } else {
      initialise("You are not logged in");
    }
    display();
  }

  /**
   * Generic method used to process an unknown command: debug logs and logs a
   * message to the screen.
   *
   * @param action String from the button
   * @see Controller
   * @see Model
   */
  public void processUnknownKey(String action) {
    // unknown button, or invalid for this state - reset everything
    Debug.trace("Model::processUnknownKey: unknown button \"" + action + "\", re-initialising");
    // go back to initial state
    initialise("Invalid command");
    display();
  }

  /**
   * Load the locale currency and convert a value to that. Ex 500 -> "$5.00"
   */
  public String formatCurrency(Long l) {
    NumberFormat dFormat = DecimalFormat.getCurrencyInstance();
    return dFormat.format(l / 100.0);
  }

  /**
   * integer overload for formatCurrency
   */
  public String formatCurrency(int i) {
    NumberFormat dFormat = DecimalFormat.getCurrencyInstance();
    return dFormat.format(i / 100.0);
  }

  /**
   * Method used internally in this class to update the display, calls
   * view.update()
   *
   * @see View
   */
  public void display() {
    Debug.trace("Model::display");
    view.update();
  }
}
