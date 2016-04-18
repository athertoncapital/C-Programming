// Coding Exercise: Question 2:
import java.security.SecureRandom;
import java.util.Scanner;

public class MulTest
{
    public static void main( String args[] )
    {
	Scanner in = new Scanner(System.in);
	SecureRandom randomNumbers = new SecureRandom();

	int num1 = 1+randomNumbers.nextInt(10);
	int num2 = 1+randomNumbers.nextInt(10);
	System.out.printf("How much is %d times %d?\n", num1, num2);
	int answer = in.nextInt();
	if( answer == num1*num2)
	    System.out.println("Correct");
	else
	    System.out.println("Incorrect");

    } // end main
} // end class FlipCoin