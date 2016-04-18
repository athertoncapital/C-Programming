// Lab 2: GradeBook.java
// GradeBook class with a constructor to initialize the course name.
public class GradeBook
{
    private String courseName; // course name for this GradeBook
    
    // method to set the course name
    public void setCourseName( String name )
    {
        courseName = name; // store the course name
    } // end method setCourseName
    
    // method to retrieve the course name
    public String getCourseName()
    {
        return courseName;
    } // end method getCourseName
    
    
    // display a welcome message to the GradeBook user
    
    public void displayMessage()
    {
        System.out.printf( "\nWelcome to the grade book for: %s!!\n", courseName);
    } // end method displayMessage
} // end class GradeBook 
