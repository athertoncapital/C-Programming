import java.util.Scanner;
public class quitz10 {

    
    
    //Department 1 calculates bonus for their sales persons based on the sales amount they made
    //department 2 calculates bonus for their sales persons based on the number of product units they sold
    
    
    //first prompt the users to enter their department number (int type)
    public static void main(String arg[])
    {
        Scanner in = new Scanner(System.in);
        System.out.println("Please enter their department number:");
        int num=in.nextInt();
        if (num==1){
            System.out.println("Please enter the sales amount:");
            double amt=in.nextDouble();
            System.out.println("The bonus is: "+bonus(amt));}
        else if (num==2){
            System.out.println("Please enter the unit sold:");
            int unit=in.nextInt();
            System.out.println("The bonus is: "+bonus(unit));}
    }


        
        
        
    public static double bonus(double sales)
    {
	//returns 10 percent of the sales amount as the bonus
        return 0.1*sales;
    }
    public static double bonus(int unit)
    {
        //each unit receives $2 bonus
        return unit*2;
    }

}