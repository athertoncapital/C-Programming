/**
   This program tests the BankAccount class and
   its subclasses. 
*/
public class BankAccountTest
{  
    public static void main(String[] args)
    {  
	SavingsAccount momsSavings = new SavingsAccount(50,0.5);
	System.out.println("*****momsSaving*****");
	System.out.println(momsSavings);
	System.out.println();
	SavingsAccount momsSavingsDeepCopy = new SavingsAccount(momsSavings);
	System.out.println("*****momsSavingDeepCopy*****");
	System.out.println(momsSavingsDeepCopy);

	CheckingAccount harrysChecking = new CheckingAccount(100);
	System.out.println("*****harrysChecking*****");
	System.out.println(harrysChecking);
	System.out.println();
	CheckingAccount harrysCheckingDeepCopy = new CheckingAccount(harrysChecking);
	System.out.println("*****momsSavingDeepCopy*****");
	System.out.println(harrysCheckingDeepCopy);
    }
}