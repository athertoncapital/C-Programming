public class TriangleTest
{
    public static void main(String[] args)
    {
	Triangle t1 = new Triangle();
	System.out.printf("%s \n", t1.toString());

	Triangle t2 = new Triangle(5,12,13);
	System.out.printf("%s \n", t2.toString());

	try{
	    Triangle t3 = new Triangle(9,4,5);
	}
	catch(IllegalArgumentException e)
	    {
		System.out.printf("Exception while initializing t3: %s\n",e.getMessage());
	    }

	Triangle t4 = new Triangle(t2);
	System.out.printf("%s \n", t4.toString());
    }
}