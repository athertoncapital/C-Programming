public class Executive extends Manager{
    public Executive(String name, double salary, String department)
    {
	constant double bonusRate=0.3;
	super(name,salary,department);
    }
@Override
    public String toString()
    {
	return super.toString();
    }
    public double pay()
    {
	return salary+(bonusRate*salary);
    }
}