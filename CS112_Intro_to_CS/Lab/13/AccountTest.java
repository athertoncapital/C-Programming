public class AccountTest
{

    public static void main(String[] args)
    {

	Person mom = new Person("Sue","Smith", 45);
	Account a1 = new Account(mom);
	System.out.println(a1);

	Person dad = new Person("John","Smith", 49);
	Account a2 = new Account(dad);
	System.out.println(a2);

	Person zoe = new Person("Zoe","Smith", 19);
	Account a3 = new Account(zoe);
	System.out.println(a3);

    }
}
