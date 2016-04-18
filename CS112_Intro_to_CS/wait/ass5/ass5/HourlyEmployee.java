public class HourlyEmployee extends Employee 
{
    private double wage; // wage per hour
    private double hours; // hours worked for week

    // constructor
    public HourlyEmployee(String firstName, String lastName,
			  String socialSecurityNumber, double wage, double hours)
    {
	super(firstName, lastName, socialSecurityNumber);

	if (wage < 0.0) // validate wage
	    throw new IllegalArgumentException(
					       "Hourly wage must be >= 0.0");

	if ((hours < 0.0) || (hours > 168.0)) // validate hours
	    throw new IllegalArgumentException(
					       "Hours worked must be >= 0.0 and <= 168.0");

	this.wage = wage;
	this.hours = hours;
    } 
    public HourlyEmployee(HourlyEmployee H) {
	super(H);
	this.wage = H.wage;
	this.hours = H.hours;
	//this(aSalariedEmployee.getFirstName(), aSalariedEmployee.getLastName(), aSalariedEmployee.getSocialSecurityNumber(), aSalariedEmployee.getWeeklySalary());
    }
    //public HourlyEmployee(HourlyEmployee aH) {
    //this(aH.getFirstName(), aH.getLastName(), aH.getSocialSecurityNumber(), aH.getWage(), aH.getHours());
    //}

    // set wage
    public void setWage(double wage)
    {
	if (wage < 0.0) // validate wage
	    throw new IllegalArgumentException(
					       "Hourly wage must be >= 0.0");

	this.wage = wage;
    } 

    // return wage
    public double getWage()
    {
	return wage;
    } 

    // set hours worked
    public void setHours(double hours)
    {
	if ((hours < 0.0) || (hours > 168.0)) // validate hours
	    throw new IllegalArgumentException(
					       "Hours worked must be >= 0.0 and <= 168.0");

	this.hours = hours;
    } 

    // return hours worked
    public double getHours()
    {
	return hours;
    } 

    // calculate earnings; override abstract method earnings in Employee
    
    public boolean equals(Object other)
    {
        if(!(other instanceof Employee))
            return false;
        HourlyEmployee o = (HourlyEmployee) other;
        return super.equals((Employee)o) && this.wage == o.getWage() && this.hours == o.getHours();
    }

    
   @Override                                                           
       public double earnings()                                            
    {                                                                   
	if (getHours() <= 40) // no overtime                           
	    return getWage() * getHours();                                
	else                                                             
	    return 40 * getWage() + (getHours() - 40) * getWage() * 1.5;
    }                                          

    // return String representation of HourlyEmployee object              
   @Override                                                             
       public String toString()                                              
    {                                                                     
	return String.format("hourly employee: %s%n%s: $%,.2f; %s: %,.2f",
			     super.toString(), "hourly wage", getWage(),                     
			     "hours worked", getHours());                                   
    }                                    
} // end class HourlyEmployee