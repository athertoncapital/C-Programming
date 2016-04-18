public class CheckingAccount extends BankAccount
{
    private int transactionCount=0;

    public CheckingAccount(double balance)
    {
        super(balance);
    }
    
@Override
    public void deposit(double amount)
    {
        transactionCount++;
        if (amount < 0.0)
        {
            throw new IllegalArgumentException("amount must be >= 0.0");
        }
	balance = balance + amount;
    }
    
@Override
    public void withdraw(double amount)
    {
        transactionCount++;
        if (amount < 0.0)
        {
            throw new IllegalArgumentException("amount must be >= 0.0");
        }
	balance = balance - amount;
    }

    public void deductFees()
    {
	balance = balance + (-2.5)*(transactionCount-3);
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