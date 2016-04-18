public class AccountTest
{
    
    public static void main(String[] args)
    {
        
        Person p1 = new Person("Sue","Smith", 45);
        Account a1 = new Account(p1);
        System.out.println(a1);
        
        try
        {
            Person p2 = new Person("John","Smith", 0);
        }
        catch(IllegalArgumentException e)
        {
            System.out.printf("Exception while creating Person object p2: %s\n",e.getMessage());
        }
        
        Person p3 = new Person(p1);
        System.out.println(p3);
        
        Person p4 = new Person("Zoe","Smith", 19);
        Account a2 = new Account(p4);
        System.out.println(a2);
    }
}