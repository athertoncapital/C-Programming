/******************************************************************/
/* Author: CS112 William Chuang                                   */
/* Date: Octobor 20, 2015                                         */
/* Description: Assignment 3-1                                    */
/******************************************************************/
import java.util.Scanner;
import java.security.SecureRandom;
//Your program chooses the number to be guessed by selecting a random integer in the range 1 to 1000 (use the SecureRandom class). 
public class GuessNumber {
    public static void main(String[] args) {
	// Creating a random number generator
	SecureRandom random = new SecureRandom();
	// Using Scanner for getting input from user
	Scanner scanner = new Scanner(System.in);
       
	// Use the random generator to 
	//The program then displays the prompt "Guess a number between 1 and 1000".        
	int guess = -1;
	// Loop until the user has guessed the number
	String awnser="";
	do{
	int number = random.nextInt(1000)+1;
	while (guess!=number) {
	    // Prompt the user for their next guess
	    System.out.print("Enter your guess: ");
	    // Read the users guess
	    guess = scanner.nextInt();
	    // Check if the guess is high, low or correct
	    if (guess<number) {
		// The guessing is too low
		System.out.println("Too low. Try again");
	    } else if (guess>number) {
		// The guessing is too high
		System.out.println("Too high. Try again");
	    } else {
                // Guess is correct !!
             	System.out.println("Congratulations. You guessed the number!");
	    }
	}	
	guess=-1;//Prepare for the next run,in case user type y or Y    
	System.out.println("Press 'y' or 'Y' to try again, or press any other keys to quit.");
	    Scanner scan = new Scanner(System.in);
	    awnser = scan.next();
	}while(awnser.equals("Y")|| awnser.equals("y"));
    }
}

