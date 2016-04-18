public class BasePlusCommissionEmployee extends Employee{
    
    private double commissionRate;
    private double grossSales;
    //    private String name;
    //private double salary; 


    public BasePlusCommissionEmployee(String name, double salary, double commissionRate,  double grossSales) {
	//			if (grossSales < 0.0)
	//throw new IllegalArgumentException("Gross sales must be >= 0.0");
	//if (commissionRate <= 0.0 || commissionRate >= 1.0)
	//throw new IllegalArgumentException("Commission rate must be > 0.0 and < 1.0");
	
	super(name, salary);
	this.commissionRate=commissionRate;
    this.grossSales=grossSales;

    }
@Override
       public String toString()
     {
	 return String.format("Name:%s, salary %f, grossSales: %.2f, commissionRate: %.2f",name, salary,grossSales, commissionRate);
    }

    public double pay()
    {
	return salary + ( commissionRate * grossSales );
    }
}