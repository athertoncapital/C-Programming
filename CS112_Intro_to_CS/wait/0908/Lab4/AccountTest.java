public class AccountTest
{
    public static void main( String args[] )
    {
        Account account1 = new Account();
        
        
        System.out.println(account1.getLast());//null
        System.out.println(account1.getFirst());//null
        System.out.println(account1.getInitial());//space line ''
        System.out.println(account1.getAccNumber());//5
        System.out.println(account1.getBalance());//0.0
        System.out.println(account1.getClosed());//false
    } // end main
}