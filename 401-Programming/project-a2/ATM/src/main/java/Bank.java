import java.util.ArrayList;

/**
 * A simple implementation of a bank object, which contains a list of bank
 * accounts.
 */
public class Bank {
  // Instance variables containing the bank information
  /**
   * maximum number of accounts the bank can hold
   */
  int maxAccounts = 10;
  /**
   * The number of accounts currently in the bank
   */
  int numAccounts = 0;
  /**
   * Array to hold the bank accounts
   */
  BankAccount[] accounts = new BankAccount[maxAccounts]; // array to hold the bank accounts
  /**
   * currently logged in acccount ('null' if no-one is logged in)
   */
  BankAccount account = null;

  /**
   * Basic constructor method with debug logging
   */
  public Bank() {
    Debug.trace("Bank::<constructor>");
  }

  /**
   * Inialisation method for a bank account. This is a factory method and differs
   * from using the 'new' keyword.
   *
   * @param accNumber account number
   * @param accPasswd account password
   * @param balance   initial balance
   * @return a new BankAccount object
   */
  public BankAccount makeBankAccount(int accNumber, int accPasswd, int balance) {
    return new BankAccount(accNumber, accPasswd, balance);
  }

  /**
   * Method which creates a new bank account.
   *
   * @param a new bank account passed
   * @return true if success or false if there's too many bank accounts
   */
  public boolean addBankAccount(BankAccount a) {
    if (numAccounts < maxAccounts) {
      accounts[numAccounts] = a;
      numAccounts++;
      Debug.trace("Bank::addBankAccount: added " + a.accNumber + " " + a.accPasswd + " £" + a.balance);
      return true;
    } else {
      Debug.trace("Bank::addBankAccount: can't add bank account - too many accounts");
      return false;
    }
  }

  /**
   * Variant of addBankAccount which constructs a new account from three integers
   * (rather than an existing account)
   *
   * @param accNumber account number
   * @param accPasswd account password
   * @param balance   initial balance
   * @return true if success or false if there's too many bank accounts
   */
  public boolean addBankAccount(int accNumber, int accPasswd, int balance) {
    return addBankAccount(makeBankAccount(accNumber, accPasswd, balance));
  }

  // Check whether the current saved account and password correspond to
  // an actual bank account, and if so login to it (by setting 'account' to it)
  // and return true. Otherwise, reset the account to null and return false
  /**
   * Method to log in an account using an account number and a password
   *
   * @param newAccNumber login account number
   * @param newAccPasswd login account password
   * @return true if logged in, false if not. on true the account is set to the
   *         account. on false the account is set to null.
   */
  public boolean login(int newAccNumber, int newAccPasswd) {
    Debug.trace("Bank::login: accNumber = " + newAccNumber);
    logout(); // logout of any previous account

    // search the array to find a bank account with matching account and password.
    // If you find it, store it in the variable currentAccount and return true.
    // If you don't find it, reset everything and return false

    for (BankAccount bankAccount : accounts) {
      if (newAccNumber == bankAccount.accNumber) {
        // found this in the search
        if (newAccPasswd == bankAccount.accPasswd) {
          // found in search and password correct
          account = bankAccount;
          return true;
        } else {
          // password false
          break;
        }
      } else {
        // account not yet found, continue
        continue;
      }
    }

    // no account found or password false, return false.
    account = null;
    return false;
  }

  /**
   * method to log out the current account by setting it to null
   */
  public void logout() {
    if (loggedIn()) {
      Debug.trace("Bank::logout: logging out, accNumber = " + account.accNumber);
      account = null;
    }
  }

  /**
   * Method to check whether or not an account is currently logged in
   *
   * @return false if not, true if it is.
   */
  public boolean loggedIn() {
    if (account == null) {
      return false;
    } else {
      return true;
    }
  }

  /**
   * Method which tries to call account.deposit() if logged in, otherwise returns
   * false.
   *
   * @param amount integer amount of money to deposit
   * @return true if success, false if not logged in or amount can't be deposited.
   * @see BankAccount
   */
  public boolean deposit(int amount) {
    if (loggedIn()) {
      return account.deposit(amount);
    } else {
      return false;
    }
  }

  /**
   * Method which tries to call account.withdraw() if logged in, otherwise returns
   * false.
   *
   * @param amount integer amount of money to withdraw
   * @return true if success, false if not logged in or amount can't be withdrew.
   * @see BankAccount
   */
  public boolean withdraw(int amount) {
    if (loggedIn()) {
      return account.withdraw(amount);
    } else {
      return false;
    }
  }

  /**
   * Method which tries to call account.getBalance() if logged in, otherwise
   * returns false.
   *
   * @return -1 as an error value, otherwise returns the account balance.
   */
  public int getBalance() {
    if (loggedIn()) {
      return account.getBalance();
    } else {
      return -1; // use -1 as an indicator of an error
    }
  }

  /**
   * Method which tries to call account.getHistory() if logged in, otherwise
   * returns false.
   *
   * @return null on error, otherwise an ArrayList of Strings with the history.
   */
  public ArrayList<String> getHistory() {
    if (loggedIn()) {
      return account.getHistory();
    } else {
      return null;
    }
  }
}
