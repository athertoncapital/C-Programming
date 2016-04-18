// Lab 2: GradeBookTest.java
import java.util.Scanner;
public class GradeBookTest
{
    // main method begins program execution
    public static void main( String args[] )
    {
        Scanner input = new Scanner( System.in );
        // create first GradeBook object
        GradeBook gradeBook1 = new GradeBook();
        gradeBook1.displayMessage(); // display inital messageg
        
        System.out.println();
        System.out.println( "Please enter the first updated course name:" );
        String inputName = input.nextLine();
        gradeBook1.setCourseName(inputName);
        gradeBook1.displayMessage(); // display messageg with updated course name
        
        // create second GradeBook object
        GradeBook gradeBook2 = new GradeBook();
        System.out.println();
        gradeBook2.displayMessage(); // display inital messageg
        System.out.println( "Please enter the second updated course name:" );
        inputName = input.nextLine();
        gradeBook2.setCourseName(inputName);
        
        gradeBook2.displayMessage(); // display messageg
    }
}