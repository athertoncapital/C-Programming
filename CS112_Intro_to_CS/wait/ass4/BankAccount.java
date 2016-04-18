public class BankAccount
{
    protected double balance;


    public BankAccount(double initialBalance)
    {
	if (initialBalance < 0.0)
	    {
		throw new IllegalArgumentException("initialBalance must be >= 0.0");
	    }
	balance = initialBalance;

    }

    public void deposit(double amount)
    {
        if (amount < 0.0)
        {
            throw new IllegalArgumentException("amount must be >= 0.0");
        }
	double newBalance = balance + amount;
	balance = newBalance;
    }
    public void withdraw(double amount)
    {
        if (amount < 0.0)
        {
            throw new IllegalArgumentException("amount must be >= 0.0");
        }
	double newBalance = balance - amount;
	balance = newBalance;
    }

    public double getBalance()
    {
	return balance;
    }

    public String toString()
    {
	return String.format("%s", super.toString() );
			 
    }
}