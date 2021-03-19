
// Bank class - simple implementation of a bank, with a list of bank accounts, an
// a current account that we are logged in to.

// This class contains one method ('login') which you need to complete as part of 
// the lab exercise to make the basic ATM work. Tutors can help you get this part 
// working in lab sessions. 

// If you choose the ATM for your project, you should make other modifications to 
// the system yourself, based on similar examples we will cover in lectures and labs.
public class Bank
{
    // Instance variables containing the bank information
    int maxAccounts = 10;       // maximum number of accounts the bank can hold
    int numAccounts = 0;        // the number of accounts currently in the bank
    BankAccount[] accounts = new BankAccount[maxAccounts];  // array to hold the bank accounts
    BankAccount account = null; // currently logged in acccount ('null' if no-one is logged in)

    // Constructor method - this provides a couple of example bank accounts to work with
    public Bank()
    {
        Debug.trace( "Bank::<constructor>"); 

        
    }

    // a method to create new BankAccounts - this is known as a 'factory method' and is a more
    // flexible way to do it than just using the 'new' keyword directly.
    public BankAccount makeBankAccount(int accNumber, int accPasswd, int balance) 
    {
        return new BankAccount(accNumber, accPasswd, balance);
    }
    
    // a method to add a new bank account to the bank - it returns true if it succeeds
    // or false if it fails (because the bank is 'full')
    public boolean addBankAccount(BankAccount a)
    {
        if (numAccounts < maxAccounts) {
            accounts[numAccounts] = a;
            numAccounts++ ;
            Debug.trace( "Bank::addBankAccount: added " + 
                         a.accNumber +" "+ a.accPasswd +" £"+ a.balance);
            return true;
        } else {
            Debug.trace( "Bank::addBankAccount: can't add bank account - too many accounts"); 
            return false;
        }                
    }
    
    // a variant of addBankAccount which makes the account and adds it all in one go.
    // Using the same name for this method is called 'method overloading' - two methods
    // can have the same name if they take different argument combinations
    public boolean addBankAccount(int accNumber, int accPasswd, int balance)
    {
        return addBankAccount(makeBankAccount(accNumber, accPasswd, balance));
    }    
    
    // Check whether the current saved account and password correspond to 
    // an actual bank account, and if so login to it (by setting 'account' to it)
    // and return true. Otherwise, reset the account to null and return false
    // YOU NEED TO ADD CODE TO THIS METHOD FOR THE LAB EXERCISE
    public boolean login(int newAccNumber, int newAccPasswd) 
    { 
        Debug.trace( "Bank::login: accNumber = " + newAccNumber);       
        logout(); // logout of any previous account

        // search the array to find a bank account with matching account and password.
        // If you find it, store it in the variable currentAccount and return true.
        // If you don't find it, reset everything and return false
        
        // YOU NEED TO ADD CODE HERE TO FIND THE RIGHT ACCOUNT IN THE accounts ARRAY, 
        // SET THE account VARIABLE AND RETURN true
        for (BankAccount b: accounts) {
            if (b.accNumber == newAccNumber && b.accPasswd == newAccPasswd) {
                // found the right account
                Debug.trace( "Bank::login: logged in, accNumber = " + newAccNumber ); 
                account = b;
                return true;
            }
        }    

        // not found - return false
        account = null;
        return false;
    }

    // Reset the bank to a 'logged out' state
    public void logout() 
    {
        if (loggedIn())
        {
            Debug.trace( "Bank::logout: logging out, accNumber = " + account.accNumber);
            account = null;
        }
    }
    
    // test whether the bank is logged in to an account or not
    public boolean loggedIn()
    {
        if (account == null)
        {
            return false;
        } else {
            return true;
        }
    }   
    
    // try to deposit money into the account (by calling the deposit method on the 
    // BankAccount object)
    public boolean deposit(int amount) 
    {
        if (loggedIn()) {
            return account.deposit(amount);   
        } else {
            return false;
        }
    }
    
    // try to withdraw money into the account (by calling the withdraw method on the 
    // BankAccount object)
    public boolean withdraw(int amount) 
    {
        if (loggedIn()) {
            return account.withdraw(amount);   
        } else {
            return false;
        }
    }
    
    // get the account balance (by calling the balance method on the 
    // BankAccount object)
    public int getBalance() 
    {
        if (loggedIn()) {
            return account.getBalance();   
        } else {
            return -1; // use -1 as an indicator of an error
        }
    }
}