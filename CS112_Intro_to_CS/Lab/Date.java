// Exercise 8.14 Solution: Date.java
// Date class definition

public class Date
{
    private static final String[] monthNames = {"January", "February", 
						"March", "April", "May", "June", "July", "August", 
						"September", "October", "November", "December"};
    private static final int[] monthDays = {31, 28, 31, 30, 31, 30, 
					    31, 31, 30, 31, 30, 31};

    private int day; // day of the month
    private int month; // month in the year
    private int year; // year

    // no-argument constructor
    public Date()
    {
	this(1, 1, 2000);
    }

    // constructor for format MM/DD/YYYY
    public Date(int month, int day, int year)
    {
	if (year < 0) // validate year
	    throw new IllegalArgumentException("year must be > 0");

	if (month <= 0 || month > 12) // validate month
	    throw new IllegalArgumentException("month must be 1-12");

	if (day < 1 || day > daysInMonth(month, year))
	    throw new IllegalArgumentException("day out of range for specified month");

	this.year = year;
	this.month = month;
	this.day = day;
    }

    // constructor for format MonthName dd, yyyy
    public Date(String month, int day, int year)
    {
	this(convertFromMonthName(month), day, year);
    }
   
    // constructor for format DDD YYYY
    public Date(int ddd, int year)
    {
	if (year < 0) // validate year
	    throw new IllegalArgumentException("year must be > 0");

	if (ddd < 1 || ddd > 366) // check for invalid day
	    throw new IllegalArgumentException("day out of range");

	this.year = year;

	int dayTotal = 0;

	for (int m = 1; 
	     m < 13 && (dayTotal + daysInMonth(m, year)) < ddd; ++m)
	    {
		dayTotal += daysInMonth(m, year);
		this.month = m + 1;
	    } 

	this.day = ddd - dayTotal;
    }
  
    // Set the day
    public void setDay(int day)
    { 
	if (day < 1 || day > daysInMonth(month, year))
	    throw new IllegalArgumentException("day out of range for current month");

	this.day = day;
    }

    // Set the month
    public void setMonth(int mm) 
    { 
	if (month <= 0 || month > 12) // validate month
	    throw new IllegalArgumentException("month must be 1-12");

	this.month = month;
    }

    // Set the year
    public void setYear(int year)
    { 
	if (year < 0) // validate year
	    throw new IllegalArgumentException("year must be > 0");

	this.year = year;
    }

    // return Date in format: mm/dd/yyyy
    public String toString() 
    { 
	return String.format("%d/%d/%d", month, day, year); 
    }

    // return Date in format: MonthName dd, yyyy
    public String toMonthNameDateString()
    { 
	return String.format(
			     "%s %d, %d", monthNames[month - 1], day, year);
    }

    // return Date in format DDD YYYY
    public String toDayDateString() 
    { 
	return String.format("%d %d", convertToDayOfYear(), year);
    }

    // Return the number of days in the month
    private static int daysInMonth(int month, int year)
    { 
	return leapYear(year) && month == 2 ? 29 : monthDays[month - 1];
    }

    // test for a leap year
    private static boolean leapYear(int year)
    {
	if (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0))
	    return true;
	else
	    return false;
    }

    // convert mm and dd to ddd
    private int convertToDayOfYear()    
    {
	int ddd = 0;

	for (int m = 1; m < month; ++m)
	    {
		if (leapYear(year) && m == 2)
		    ddd += 29;
		else 
		    ddd += monthDays[m -1];
	    } // end for

	ddd += day;
	return ddd;
    }

    // convert from month name to month number
    private static int convertFromMonthName(String monthName)
    {
	for (int subscript = 0; subscript < 12; subscript++)
	    {
		if (monthName.equals(monthNames[subscript]))
		    {
			return subscript + 1;
		    }
	    }

	throw new IllegalArgumentException("Invalid month name");
    }
} // end class Date

