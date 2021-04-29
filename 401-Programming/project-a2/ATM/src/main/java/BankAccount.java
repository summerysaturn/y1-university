
// BankAccount class
// This class has instance variables for the account number, password and
// balance, and methods to withdraw, deposit, check balance etc.

// This class contains methods which you need to complete to make the basic ATM
// work. Tutors can help you get this part working in lab sessions.

// If you choose the ATM for your project, you should make other modifications
// to the system yourself, based on similar examples we will cover in lectures
// and labs.

/**
 * The object type of a bank account
 */
public class BankAccount {

  public int accNumber = 0;
  public int accPasswd = 0;
  public int balance = 0;

  // empty constructor
  /*
   * public BankAccount() { }
   */

  public BankAccount(int a, int p, int b) {
    accNumber = a;
    accPasswd = p;
    balance = b;
  }

  // withdraw money from the account. Return true if successful, or
  // false if the amount is negative, or less than the amount in the account
  public boolean withdraw(int amount) {
    Debug.trace("BankAccount::withdraw: amount =" + amount);

    if (amount < 0) {
      // working as intended, withdraw and return true
      balance -= amount;
      return true;
    } else {
      // shouldn't get here but return false if it does
      return false;
    }
  }

  // deposit the amount of money into the account. Return true if successful,
  // or false if the amount is negative
  public boolean deposit(int amount) {
    Debug.trace("LocalBank::deposit: amount = " + amount);

    if (amount > 0) {
      // working as intended, deposit and return true
      balance += amount;
      return true;
    } else {
      // shouldn't get here but return false if it does
      return false;
    }
  }

  // Return the current balance in the account
  public int getBalance() {
    Debug.trace("LocalBank::getBalance");

    return balance;
  }
}
