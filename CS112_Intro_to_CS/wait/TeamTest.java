/******************************************************************/
/* Author: CS112 William Chuang                                   */
/* Date: September 13, 2015                                       */
/* Description: Demos constructors, static vs instance methods,   */
/*              and method overloading. Write a test class named  */
/*              TeamTest that creates a Team object using the     */
/*              default constructor. Next, print the team's name  */
/*              and average score (type float). After that, prompt*/
/*              the users to enter name and scores to update the  */
/*              Team object information. Finally, print the team's*/
/*              updated name and average score. You can assume the*/
/*              entered scores are valid.                         */
/******************************************************************/


import java.util.Scanner;

public class TeamTest
{

    public static void main(String[] args)
    { 
        float avg=0.00f;
	// create a Scanner object to obtain input from the command window
	Scanner input = new Scanner(System.in);

	// create a Team object and assign it to defaultTeam
	Team defaultTeam = new Team(); //using default constructor 

	// display initial value of name (null)
	System.out.printf("Team: %s; average score:%.2f%n", defaultTeam.getName(),avg);

	// prompt for and read name
	System.out.printf("Please enter team's name:%n");
	String theName = input.nextLine(); // read a line of text
	defaultTeam.setName(theName); // put theName in defaultTeam
	//System.out.println(); // outputs a blank line

	// prompt for and read score1
	System.out.println("Please enter team's first socre:");
	int score1 = input.nextInt(); // read a line of text
	defaultTeam.setScore1(score1); // put score1 in defaultTeam
	//System.out.println(); // outputs a blank line
	
	// prompt for and read score2
	System.out.println("Please enter team's second socre:");
	int score2 = input.nextInt(); // read a line of text
	defaultTeam.setScore2(score2); // put score2 in defaultTeam
	//System.out.println(); // outputs a blank line
	
	// prompt for and read score3
	System.out.println("Please enter team's third socre:");
	int score3 = input.nextInt(); // read a line of text
	defaultTeam.setScore3(score3); // put score3 in defaultTeam
	//System.out.println(); // outputs a blank line
    
	avg=(defaultTeam.getScore1()+defaultTeam.getScore2()+defaultTeam.getScore3())/3;
	
	
	// display the name stored in object defaultTeam
	System.out.printf("Team: %s; average score: %.2f%n",
			  defaultTeam.getName(),avg);
    } 
} // end class TeamTest