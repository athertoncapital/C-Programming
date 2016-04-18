
public abstract class Employee 
{
    private final String firstName;
    private final String lastName;
    private final String socialSecurityNumber;
    private final Date birthDate;

    // constructor
    public Employee(String firstName, String lastName, 
		    String socialSecurityNumber, int month, int day, int year)
    {
	this.firstName = firstName;                                    
	this.lastName = lastName;                                    
	this.socialSecurityNumber = socialSecurityNumber;         
	birthDate = new Date(month, day, year);
    } 

    // return first name
    public String getFirstName()
    {
	return firstName;
    } 

    // return last name
    public String getLastName()
    {
	return lastName;
    } 

    // return social security number
    public String getSocialSecurityNumber()
    {
	return socialSecurityNumber;
    } 

    // return birth date
    public Date getBirthDate()
    {
	return birthDate;
    } 

    // return String representation of Employee object
   @Override
       public String toString()
    {
	return String.format("%s %s\n%s: %s\n%s: %s", 
			     getFirstName(), getLastName(), 
			     "social security number", getSocialSecurityNumber(), 
			     "birth date", getBirthDate());
    } 

    // abstract method must be overridden by concrete subclasses
    public abstract double earnings(); // no implementation here
} // end abstract class Employee
