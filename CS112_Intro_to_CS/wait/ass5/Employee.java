public abstract class Employee implements Comparable 
{
    private final String firstName;
    private final String lastName;
    private final String socialSecurityNumber;

    // constructor
    public Employee(String firstName, String lastName, 
		    String socialSecurityNumber)
    {
	this.firstName = firstName;
	this.lastName = lastName;                                    
	this.socialSecurityNumber = socialSecurityNumber;         
    } 
    public Employee(Employee aE)
    {
	this.firstName = aE.firstName;
	this.lastName = aE.lastName;                                    
	this.socialSecurityNumber = aE.socialSecurityNumber;
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

    // return String representation of Employee object

    public boolean equals(Employee other)
    {
	if(!(other instanceof Employee))
	    return false;
	Employee o = (Employee) other;
        return this.firstName.equals(o.getFirstName()) && this.lastName.equals(o.lastName) && this.socialSecurityNumber.equals(o.socialSecurityNumber);
	//        if(!(otherObject instanceof Coin))
	//            return false;
	//        Coin other = (Coin) otherObject;
	//        return name.equals(other.name) && value == other.value;
    }
    
    @Override   
	public int compareTo(Object employee) {
	if(!(employee instanceof Employee))
	    throw new IllegalArgumentException(
					       "Compared object isn't an instance of Employee");
	Employee o = (Employee) employee;
	if ((this.earnings() - o.earnings())>0) return 1;
	else if ((this.earnings() - o.earnings())<0) return -1;
	else return 0;
        
    }
    
   @Override
       public String toString()
    {
	return String.format("%s %s%nsocial security number: %s", 
			     getFirstName(), getLastName(), getSocialSecurityNumber());
    } 

    // abstract method must be overridden by concrete subclasses
    public abstract double earnings(); // no implementation here
} // end abstract class Employee