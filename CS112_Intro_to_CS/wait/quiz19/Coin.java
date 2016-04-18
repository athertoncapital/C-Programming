public class Coin{
    private double value=0.0;
    private String name;
    public Coin(double value, String name)
    {
	this.value=value; 
	this.name=name;
    }
    public String toString()
    {
	return "Name "+name+" Value "+ value;
    }
    public boolean equals(Coin other)
    {
	return value==other.value && name==other.name;
    }
}