/***********************************/
/* Author: CS112 William H. Chuang */
/* Date: September 13, 2015        */
/* Assignment 1-1 BMI calculator   */
/***********************************/

import java.util.Scanner; // program uses Scanner

public class BMICalculator
{
    public static void main(String[] args)
    {
	// create Scanner to obtain input from command window
	Scanner input = new Scanner(System.in);
        
	int weight;
	int height;
	int BMI;
	
	System.out.printf("Welcome to the body mass index (BMI) calculator%n"); // prompt for greeting
	System.out.printf("Enter your weight in pounds: "); // prompt for input
	weight = input.nextInt(); // read the weight of user
	
	System.out.printf("Enter your height in inches: "); // prompt for input
	height = input.nextInt(); // read the height of user
	if (weight>0 && height>0)
	    {
	    BMI = (weight * 703)/(height * height);
	    System.out.printf("Your BMI is: %d%n", BMI); // prompt for output
	    }
	else
	    System.out.printf("The entered weight or height value is not valid%n"); // prompt for output
	
    }
}




	    