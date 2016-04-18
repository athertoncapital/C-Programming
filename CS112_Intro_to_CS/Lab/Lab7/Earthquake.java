import java.util.Scanner;

public class Earthquake
{
    // perform miles-per-gallon calculations
    public static void main(String[] args)
    {
	Scanner input = new Scanner(System.in);
      
	
	//	double mag= 0; // total gallons for trip

	// prompt user for miles and obtain the input from user
	System.out.printf("Enter a magnitude on the Richter scale: %n");
	double mag = input.nextDouble(); // miles for one tankful

  	if (mag <0)
	{
	    System.out.printf("Negative numbers are not valid%n");            
	} 
	else if (mag >= 0 && mag < 3.5)
	{
	    System.out.printf("Generally not felt by people%n");            
	}
	else if (mag >=3.5 && mag < 4.5)
	{
	    System.out.printf("Negative numbers are not valid%n");            
	}
	else if (mag >=4.5 && mag < 6.0)
	{
	    System.out.printf("Damage to poorly constructed buildings%n");            
	}
	else if (mag >=6.0 && mag < 7.0)
	{
	    System.out.printf("Many buildings considerably damaged%n");
	}
	else if(mag >=7.0& mag <8.0)
	{
	    System.out.printf("Many buildings destroyed%n");
	}
	else if(mag >=8.0)
	{
	    System.out.printf("Most structures falls%n");            
	}
	
    }
} // end class Earthquake



