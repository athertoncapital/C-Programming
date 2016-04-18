import java.util.Scanner;
import java.security.SecureRandom;
public class GuessNumber {
    public static void main(String[] args) {
	SecureRandom random = new SecureRandom();
	Scanner scanner = new Scanner(System.in);
	int guess = -1;String awnser="";
	do{int number = random.nextInt(1000)+1;
	    while (guess!=number) {
		System.out.print("Enter your guess: ");
		guess = scanner.nextInt();
		if (guess<number) {
		    System.out.println("Too low. Try again");
		} else if (guess>number) {
		    System.out.println("Too high. Try again");
		} else {System.out.println("Congratulations. You guessed the number!");}}
	    guess=-1;//Prepare for the next run,in case user type y or Y    
	    System.out.println("Press 'y' or 'Y' to try again, or press any other keys to quit.");
	    Scanner scan = new Scanner(System.in);
	    awnser = scan.next();}while(awnser.equals("Y")|| awnser.equals("y"));}}

