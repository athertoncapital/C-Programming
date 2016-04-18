import java.util.Scanner;
public class quit{
    public static void main(String[] args)
    {
	Scanner input = new Scanner(System.in);
	int number;
	int x;
	int dol;
	int quarter;
	int nick;
	int pen;
	int dim;
	
	int counter;
	String k;
	System.out.print("Enter enter a number of your money in cents: ");
	number=input.nextInt();
	dol=number/100;
	x=number%100;
	quarter=x/25;
	x=x%25;
	dim=x/10;
	x=x%10;
	nick=x/5;
	pen=x%5;
	
	

	System.out.printf("%d dollars\n",dol);
	System.out.printf("%d quarters\n",quarter);
	System.out.printf("%d dimes\n",dim);
	System.out.printf("%d nickels\n",nick);
	System.out.printf("%d pennies\n",pen);
	

    }
}

