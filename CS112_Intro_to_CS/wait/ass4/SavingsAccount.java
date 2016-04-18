public class SavingsAccount extends BankAccount
{
    private double interest;


    public SavingsAccount(double balance, double initialInterest)
    {
        super(balance);
        if (balance < 0.0)
        {
            throw new IllegalArgumentException("initial Balance must be >= 0.0");
        }
        if (initialInterest < 0.0)
        {
            throw new IllegalArgumentException("iinitial Interest must be >= 0.0");
        }
        else
        {
            this.interest=initialInterest/100;
        }

    }

    public void deposit(double amount)
    {
        if (amount < 0.0)
        {
            throw new IllegalArgumentException("amount must be >= 0.0");
        }
	balance = balance + amount;
    }

    public void withdraw(double amount)
    {
        if (amount < 0.0)
        {
            throw new IllegalArgumentException("amount must be >= 0.0");
        }
	balance = balance - amount;
    }

    public void addInterest()
    {
	balance = balance + balance * interest;
    }

    public double getBalance()
    {
	return balance;
    }

@Override
    public String toString()
{
    return String.format("%s", super.toString() );
     
}
}