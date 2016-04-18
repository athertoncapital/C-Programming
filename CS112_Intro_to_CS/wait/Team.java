/******************************************************************/
/* Author: CS112 William Chuang                                   */
/* Date: September 13, 2015                                       */
/* Description: Demos constructors, static vs instance methods,   */
/*              and method overloading.                           */
/******************************************************************/

public class Team
{
    private String name; // instance variable
    private int score1; // instance variable
    private int score2; // instance variable
    private int score3; // instance variable
    
    // method to set the name in the object              
    public void setName(String name)      
    {                                             
	this.name = name; // store the name
    }         

    // method to retrieve the name from the object
    public String getName()        
    {                                    
	return name; // return value of name to caller        
    }
    
   
 
    // method to set the score1 in the object              
    public void setScore1(int score1)      
    {                                             
	this.score1 = score1; // store the score1
    }
    
    // method to retrieve the score1 from the object
    public int getScore1()
    {
        return score1; // return value of score1 to caller
    }

    // method to set the score2 in the object
    public void setScore2(int score2)      
    {                                             
	this.score2 = score2; // store the score2
    }         
    // method to retrieve the score2 from the object
    public int getScore2()
    {
        return score2; // return value of score1 to caller
    }
    

    // method to set the score3 in the object              
    public void setScore3(int score3)      
    {                                             
	this.score3 = score3; // store the score3
    }         
    // method to retrieve the score3 from the object
    public int getScore3()
    {
        return score3; // return value of score1 to caller
    }
    // method to retrieve the average from the object
    public float getAvg()
    {
	return (score1+score2+score3)/3;
    }
} // end class Team