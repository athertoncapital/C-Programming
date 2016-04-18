/******************************************************************/
/* Author: CS112 William Chuang                                   */
/* Date: September 15, 2015                                       */
/* Description: Lab 6 CreditCheck.java                            */
/******************************************************************/

import java.util.Scanner; // program uses Scanner

public class CreditCheck
{  
    public static void main( String args[] ) 
    {
	// create Scanner to obtain input from command window
	Scanner input = new Scanner(System.in);

	int account_number;
	double balance;
	double charges;
	double credits;
	double credit_limit;

	System.out.printf("Enter Account Number: "); // prompt for greeting
	account_number = input.nextInt(); // read the A_N of user
	System.out.printf("Enter Balance: "); // prompt for input
	balance = input.nextDouble(); // read the B of user
	System.out.printf("Enter Charges: "); // prompt for input
	charges = input.nextDouble(); // read the Charges of user
	System.out.printf("Enter Credits: "); // prompt for input
	credits = input.nextDouble(); // read the Credits of user
	System.out.printf("Enter Credit Limit: "); // prompt for input
	credit_limit = input.nextDouble(); // read the CL of user
	balance = balance + charges - credits;
	/*if (balance > credit_limit)
	    {
	    System.out.printf("New balance is %.2f%n", balance); 
	    System.out.printf("Credit limit exceeded.%n");
	    }
	else
     	System.out.printf("New balance is %.2f%n", balance); */
	System.out.printf(balance>credit_limit ?"%nNew balance is Credit limit exceeded.%n":"New balance is %.2f%n",balance);

    } // end main 
} // end class Grade 

/*
Develop a Java class  CreditCheck  that determines whether a customer has exceeded the credit limit on a charge account. Prompts the users for the following customer information: 
a) account number (type int)
b) balance at the beginning of the month (type double)
c) total of all items charged by the customer this month (type double)
d) total of all credits applied to the customer’s account this month (type double)
e) allowed credit limit. (type double)
After receiving these information, the program should calculate the new balance (= beginning balance + charges – credits), display the new balance and determine whether the new balance exceeds the customer’s credit limit. For those customers whose credit limit is exceeded, the program should display the message "Credit limit exceeded". 

Here are some sample outputs:

> java CreditCheck
Enter Account Number: 1001 
Enter Balance: 100 
Enter Charges: 80 
Enter Credits: 25 
Enter Credit Limit: 200 
New balance is 155.00 

> java CreditCheck
Enter Account Number:645
Enter Balance: 500 
Enter Charges: 300 
Enter Credits: 125 
Enter Credit Limit: 400 
New balance is 675 .00
Credit limit exceeded 
*/