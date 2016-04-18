/******************************************************************/
/* Author: CS112 William Chuang                                   */
/* Date: September 13, 2015                                       */
/* Description: assignment 1-2 DateTest                           */
/******************************************************************/



public class DateTest
{

    public static void main(String[] args)
    { 
        
	// create an Date object and assign it to date
	Date date = new Date(9,11,2001); //using convenience constructor with three parameterized values
	System.out.printf("The initial date is: %s%n", date.displayDate());
	date.setMonth(10); // put the month value in date
	date.setDay(17); // put the day value in date
	date.setYear(1989);
		
	// display the name stored in object myAccount
	System.out.printf("Date with new values is: %s%n",
			  date.displayDate());
    } 
} // end class DateTest