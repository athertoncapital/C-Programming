/**
   An account that earns interest at a fixed rate.
*/
public class SavingsAccount extends BankAccount
{  
    private double interestRate;

    /**
      Constructs a bank account with a given interest rate.
      @param rate the interest rate
    */
    public SavingsAccount(double initialBalance,double rate) 
    {  
	super(initialBalance);
	interestRate = rate;
    }

    /**
      Adds the earned interest to the account balance.
    */
    public SavingsAccount (SavingsAccount s2) {
	this.interestRate = s2.interestRate;
	//	this.initialBalance = s2.initialBalance;
	//Do this process for all variables in class
    }


    public void addInterest() 
    {  
	double interest = getBalance() * interestRate / 100;
	deposit(interest); 
    }

    public String toString(  )
    {
	return( "interestRate: "  + this.interestRate);
    }
}