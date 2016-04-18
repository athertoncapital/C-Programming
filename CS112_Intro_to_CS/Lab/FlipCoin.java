// Coding Exercise: Question 2:
import java.security.SecureRandom;

public class FlipCoin
{
    public static void main( String args[] )
    {
	SecureRandom randomNumbers = new SecureRandom();
	int tail = 0, head = 0, face; 
	for(int roll=1;roll<=10;roll++)
	    {
		face = randomNumbers.nextInt(2);
		switch ( face ) {
		case 0:
		    ++head;
		    break;
		case 1:
		    ++tail;
		    break;
		} // end switch
	    }//endfor
	System.out.printf( "Tails\tHeads\n%d\t%d\n", tail, head ); 
    } // end main
} // end class FlipCoin