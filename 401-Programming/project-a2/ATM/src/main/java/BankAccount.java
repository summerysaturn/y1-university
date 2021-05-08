import java.sql.Time;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 * The object type of a bank account
 */
public class BankAccount {

  /**
   * Value for the number of the account (updated on construction)
   */
  public int accNumber = 0;
  /**
   * Value for the password of the account (updated on construction)
   */
  public int accPasswd = 0;
  /**
   * Value for the money in the account (updated on construction)
   */
  public int balance = 0;
  /**
   * History log for the statement feature
   */
  public ArrayList<String> history = new ArrayList<String>();

  /**
   * empty constructor for 0, 0, 0. This shouldn't be utilised as an account
   * number and password of 0 is unsupported..
   */
  public BankAccount() {
  }

  /**
   * Default constructor for the account specifying parameters.
   *
   * @param a Account Number
   * @param p Account Password
   * @param b Balance
   */
  public BankAccount(int a, int p, int b) {
    accNumber = a;
    accPasswd = p;
    balance = b;
  }

  /**
   * withdraw money from the account. Must be greater than 0 and less than the
   * amount in the account
   *
   * @param amount to withdraw
   *
   * @return true if successful, false if negative or less than the amount in the
   *         account.
   */
  public boolean withdraw(int amount) {
    Debug.trace("BankAccount::withdraw: amount =" + amount);

    if (amount > 0 && balance > amount) {
      balance -= amount;
      history.add("withdrew " + amount + " on " + LocalDate.now());
      return true;
    } else {
      return false;
    }
  }

  /**
   * deposit the amount of money into the account.
   *
   * @param amount to deposit
   * @return true if successful, false if the amount is negative.
   */
  public boolean deposit(int amount) {
    Debug.trace("LocalBank::deposit: amount = " + amount);

    if (amount > 0) {
      balance += amount;
      history.add("deposited " + amount + " on " + LocalDate.now());
      return true;
    } else {
      return false;
    }
  }

  /**
   * @return the ArrayList String for the Statement feature.
   */
  public ArrayList<String> getHistory() {
    return history;
  }

  /**
   * @return the current balance in the account
   */
  public int getBalance() {
    Debug.trace("LocalBank::getBalance");

    return balance;
  }
}
