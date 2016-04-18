public class Employee {
    protected String name;
    protected double salary;
    public Employee(String name, double salary)
    {
	this.name=name;
	this.salary=salary;
    }
    public String toString()
    {
	return String.format("Name: %s, salary %.2f", name,salary);
    }

    public double pay()
    {
	return salary;
    }
}
/*
    public class BasePlusCommissionEmployee extends Employee{
	private double commissionRate;
	private double grossSales;
	public BasePlusCommissionEmployee(double commissionRate, double grossSales) {
	    if (grossSales < 0.0)
		throw new IllegalArgumentException("Gross sales must be >= 0.0");
	    if (commissionRate <= 0.0 || commissionRate >= 1.0)
		throw new IllegalArgumentException("Commission rate must be > 0.0 and < 1.0");
	    
	}
	public String toString()
	{
	    return String.format("%f, %f", commissionRate, grossSales);
	}

	public double pay()
	{
	    return salary + ( commissionRate * grossSales );
	}
    }

*/

