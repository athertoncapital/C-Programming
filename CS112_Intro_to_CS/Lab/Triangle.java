public class Triangle
{

    private final int a;
    private final int b;
    private final int c;

 
    public Triangle()
    {
        this(3, 4, 5);
    }
    // constructor for format MM/DD/YYYY
    public Triangle(int side1, int side2, int side3)
    {

        
	if (side1*side2*side3 == 0) // validate year
	    throw new IllegalArgumentException("at least the length of one side equals to 0");

	if (side1 < 0 || side2 < 0 || side3<0) // validate month
	    throw new IllegalArgumentException("at least the length of one side is less than 0");

	if ((side1+side2)<=side3 || (side2+side3)<=side1 || (side3+side1)<=side2)
	    throw new IllegalArgumentException("these three sides could not form a triangle");
        
        this.a=side1;
        this.b=side2;
        this.c=side3;

    }
    public Triangle(Triangle aTriangle)
    {
        this(aTriangle.getSide1(),aTriangle.getSide2(),aTriangle.getSide3());
        
    }
    public int getSide1() {
        return a;
    }
    public int getSide2() {
        return b;
    }
    public int getSide3() {
        return c;
    }


    public String toString()
    { 
	return String.format("side1: %d, side2: %d, side3: %d", a, b, c);
    }


}