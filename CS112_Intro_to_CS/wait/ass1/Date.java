/******************************************************************/
/* Author: CS112 William Chuang                                   */
/* Date: September 13, 2015                                       */
/* Description: assignment 1-2 Date                               */
/******************************************************************/

public class Date
{
    private int month; // instance variable
    private int day; // instance variable
    private int year; // instance variable

    public Date(int month, int day, int year) {
	this.month = month; 
	this.day = day; 
	this.year = year;
    }
    // method to set the name in the object              
    public void setMonth(int month)      
    {                                             
	this.month = month; // store the month value
    }         
    public void setDay(int day)      
    {                                             
	this.day = day; // store the day value
    }         
    public void setYear(int year)      
    {                                             
	this.year = year; // store the year value
    }         

    
    // method to retrieve the month from the object
    public int getMonth()        
    {                                    
	return month; // return value of the month to caller        
    }
    // method to retrieve the day from the object
    public int getDay()        
    {                                    
	return day; // return value of the day to caller        
    }
    // method to retrieve the year from the object
    public int getYear()        
    {                                    
	return year; // return value of the year to caller        
    }
    
   
    // method to retrieve the average from the object
    public String displayDate()
    {
	return ""+month+"/"+day+"/"+year;
    }
} // end class Date