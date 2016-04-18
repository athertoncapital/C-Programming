// Exercise 8.14 Solution: DateTest.java
// Program that tests Date class
import java.util.Scanner;

public class DateTest
{
    public static void main(String[] args)
    {
	Scanner input = new Scanner(System.in);
      
	int choice = getMenuChoice();
      
	while (choice != 4)
	    {
		int month; // month of year
		int day; // day of month or day of year
		int year; // year
		String monthName; // name of month
		Date date = new Date(); // the date object
         
		switch (choice)
		    {
		    case 1:
			// format: MM/DD/YYYY
			System.out.print("Enter Month (1-12): ");
			month = input.nextInt();
			System.out.print("Enter Day of Month: ");
			day = input.nextInt();
			System.out.print("Enter Year: ");
			year = input.nextInt();
               
			date = new Date(month, day, year);
			break;

		    case 2:
			// format: Month DD, YYYY
			System.out.print("Enter Month Name: ");
			monthName = input.next();
			System.out.print("Enter Day of Month: ");
			day = input.nextInt();
			System.out.print("Enter Year: ");
			year = input.nextInt();
               
			date = new Date(monthName, day, year);
			break;

		    case 3:
			// format: DDD YYYY
			System.out.print("Enter Day of Year: ");
			day = input.nextInt();
			System.out.print("Enter Year: ");
			year = input.nextInt();
               
			date = new Date(day, year);
			break;
		    } // end switch
         
		System.out.printf("%n%s: %s%n%s: %s%n%s: %s%n%n",
				  "MM/DD/YYYY", date.toString(),
				  "Month DD, YYYY", date.toMonthNameDateString(),
				  "DDD YYYY", date.toDayDateString());
         
		choice = getMenuChoice();
	    }
    }

    // get user choice
    private static int  getMenuChoice()
    {
	Scanner input = new Scanner(System.in);
	System.out.println("Enter 1 for format: MM/DD/YYYY");
	System.out.println("Enter 2 for format: Month DD, YYYY");
	System.out.println("Enter 3 for format: DDD YYYY");
	System.out.println("Enter 4 to exit");
	System.out.print("Choice: ");
	int selection = input.nextInt();
	input.nextLine(); // clear newline from input
	return selection;
    }
} // end class DateTest