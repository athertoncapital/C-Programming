public class BankAccountTest
{  
    public static void main(String[] args)
    {  
	SavingsAccount momsSavings = new SavingsAccount(50,0.5);
	CheckingAccount harrysChecking = new CheckingAccount(100);
         
	momsSavings.deposit(10000);
	momsSavings.withdraw(1500);
	harrysChecking.deposit(1500);
	harrysChecking.withdraw(80);      

	harrysChecking.withdraw(400);      
	harrysChecking.withdraw(100);
	// Simulate end of month
	momsSavings.addInterest();
	harrysChecking.deductFees();
      
	System.out.println("Mom's savings balance: "
			   + momsSavings.getBalance());

	System.out.println("Harry's checking balance: "
			   + harrysChecking.getBalance());

    }
}

