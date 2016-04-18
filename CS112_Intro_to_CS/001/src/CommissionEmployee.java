public class CommissionEmployee extends Employee 
{
    private double grossSales; // gross weekly sales
    private double commissionRate; // commission percentage

    // constructor
    public CommissionEmployee(String firstName, String lastName, 
			      String socialSecurityNumber, double grossSales, 
			      double commissionRate)
    {
	super(firstName, lastName, socialSecurityNumber);

	if (commissionRate <= 0.0 || commissionRate >= 1.0) // validate 
	    throw new IllegalArgumentException(
					       "Commission rate must be > 0.0 and < 1.0");

	if (grossSales < 0.0) // validate
	    throw new IllegalArgumentException("Gross sales must be >= 0.0");

	this.grossSales = grossSales;
	this.commissionRate = commissionRate;
    } 
    public CommissionEmployee(CommissionEmployee C) {
    	super(C);
    	this.grossSales = C.grossSales;
    	this.commissionRate = C.commissionRate;
    	//this(aSalariedEmployee.getFirstName(), aSalariedEmployee.getLastName(), aSalariedEmployee.getSocialSecurityNumber(), aSalariedEmployee.getWeeklySalary());
      }
    //public CommissionEmployee(CommissionEmployee aC) {
    	//this(aC.getFirstName(), aC.getLastName(), aC.getSocialSecurityNumber(), aC.getGrossSales(), aC.getCommissionRate());
     //}
    // set gross sales amount
    public void setGrossSales(double grossSales)
    {
	if (grossSales < 0.0) // validate
	    throw new IllegalArgumentException("Gross sales must be >= 0.0");

	this.grossSales = grossSales;
    } 

    // return gross sales amount
    public double getGrossSales()
    {
	return grossSales;
    } 

    // set commission rate
    public void setCommissionRate(double commissionRate)
    {
	if (commissionRate <= 0.0 || commissionRate >= 1.0) // validate
	    throw new IllegalArgumentException(
					       "Commission rate must be > 0.0 and < 1.0");

	this.commissionRate = commissionRate;
    } 

    // return commission rate
    public double getCommissionRate()
    {
	return commissionRate;
    } 

    // calculate earnings; override abstract method earnings in Employee


    public boolean equals(Object other)
    {
        if(!(other instanceof Employee))
            return false;
        CommissionEmployee o = (CommissionEmployee) other;
        return super.equals((Employee)o) && this.grossSales == o.getGrossSales()&& this.commissionRate == o.getCommissionRate();
    }
   @Override                                                           
       public double earnings()                                            
    {                                                                   
	return getCommissionRate() * getGrossSales();                    
    }                                             

    // return String representation of CommissionEmployee object
   @Override                                                   
       public String toString()                                    
    {                                                           
	return String.format("%s: %s%n%s: $%,.2f; %s: %.2f",    
			     "commission employee", super.toString(),              
			     "gross sales", getGrossSales(),                       
			     "commission rate", getCommissionRate());             
    } 
} // end class CommissionEmployee