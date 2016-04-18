public class Executive extends Manager{
	private final double bonusRate=0.3;
    public Executive(String name, double salary, String department)
    {

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