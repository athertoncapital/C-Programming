/******************************************************************/
/* Author: CS112 William Chuang                                   */
/* Date: September 28, 2015                                       */
/* Description: Assignment 2                                      */
/******************************************************************/
import java.util.Scanner; // program uses Scanner

public class PrintTriangle
{
    public static void main(String[] args)
    {
        
        int a;
        int c=0;
        int d=0;
        Scanner input = new Scanner(System.in);
        System.out.printf("Enter a positive integer from 1 and 10 to draw%n");
        a = input.nextInt();
        if (a<=10&&a>=1){
            for (c=0;c<a;c++)
            {
                for (d=0;d<c+1;d++)
                {
                    System.out.printf("*");
                }
                System.out.println();
            }
        
        }
        else {System.out.println("Data format error.");}

    }
}

     // end method main



