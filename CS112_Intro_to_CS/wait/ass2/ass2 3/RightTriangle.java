/******************************************************************/
/* Author: CS112 William Chuang                                   */
/* Date: September 28, 2015                                       */
/* Description: Assignment 2                                      */
/******************************************************************/

import java.util.Scanner; // program uses Scanner

public class RightTriangle
{  
    public static void main( String args[] ) 
    {
	Scanner input = new Scanner(System.in);
	int a, b, c;
	
	System.out.printf("Please enter the first side, a = "); 
	a = input.nextInt(); 
	System.out.printf("Please enter the second side, b= "); 
	b = input.nextInt();
	System.out.printf("Please enter the third side, c= ");
	c = input.nextInt();
	
	if (a*b*c==0){System.out.printf("At least one of your input equals to zero, so it's not a triangle.%n"); }
	else if (a<0||b<0||c<0){System.out.printf("At least one of your input is less than zero, so it's not a triangle.%n");}
    else if ((a+b)>c&&(b+c)>a&&(c+a)>b){
        if ((a*a+b*b)==(c*c)){System.out.printf("It's a right triangle, and the right angle is the angle between the side a(a=%d) and the side b(b=%d).%n",a,b);}

  
        else if ((c*c+b*b)==(a*a)){System.out.printf("It's a right triangle, and the right angle is the angle between the side b(b=%d) and the side c(c=%d).%n",b,c);}


        else if ((c*c+a*a)==(b*b)){System.out.printf("It's a right triangle, and the right angle is the angle between the side c(c=%d) and the side a(a=%d).%n",c,a);}
        else {System.out.printf("It's a triangle, but not a right triangle.%n");}
    }
    else {System.out.printf("It's not a triangle.%n");}



    } // end main 
} // end class
