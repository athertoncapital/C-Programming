// Exercise 4.17 Solution: Gas.java
// Program calculates average mpg
import java.util.Scanner;

public class Gas
{
   // perform miles-per-gallon calculations
   public static void main(String[] args)
   {
      Scanner input = new Scanner(System.in);
      
      int totalMiles = 0; // total miles for trip
      int totalGallons = 0; // total gallons for trip

      // prompt user for miles and obtain the input from user
      System.out.print("Enter miles (-1 to quit): ");
      int miles = input.nextInt(); // miles for one tankful

      // exit if the input is -1; otherwise, proceed with the program
      while (miles != -1)
      {
         // prompt user for gallons and obtain the input from user
         System.out.print("Enter gallons: ");
         int gallons = input.nextInt(); // gallons for one tankful

         // add gallons and miles for this tank to total
         totalMiles += miles;
         totalGallons += gallons;

         // calculate miles per gallon for the current tank
         if (gallons != 0)
         {
            double milesPerGallon = (double) miles / gallons;
            System.out.printf("MPG this tankful: %.2f%n", milesPerGallon);            
         } 

         // calculate miles per gallon for the total trip
         if (totalGallons != 0)
         {
            double totalMilesPerGallon = (double) totalMiles / totalGallons;
            System.out.printf("Total MPG: %.2f%n", totalMilesPerGallon);
         } 

         // prompt user for new value for miles
         System.out.print("Enter miles (-1 to quit): ");
         miles = input.nextInt();
      }       
   } 
} // end class Gas


/**************************************************************************
 * (C) Copyright 1992-2015 by Deitel & Associates, Inc. and               *
 * Pearson Education, Inc. All Rights Reserved.                           *
 *                                                                        *
 * DISCLAIMER: The authors and publisher of this book have used their     *
 * best efforts in preparing the book. These efforts include the          *
 * development, research, and testing of the theories and programs        *
 * to determine their effectiveness. The authors and publisher make       *
 * no warranty of any kind, expressed or implied, with regard to these    *
 * programs or to the documentation contained in these books. The authors *
 * and publisher shall not be liable in any event for incidental or       *
 * consequential damages in connection with, or arising out of, the       *
 * furnishing, performance, or use of these programs.                     *
 *************************************************************************/
