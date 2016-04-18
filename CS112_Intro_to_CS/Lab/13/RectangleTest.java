public class RectangleTest
{

    public static void main(String[] args)
    {
	System.out.printf("Rectangles before instaniation: %d\n",Rectangle.getCount());
	
	Point p1 = new Point(0,20);
	Point p2 = new Point(10,0);
	Rectangle r1= new Rectangle(p1, p2);
	System.out.println(r1);

	Point p3 = new Point();
	Point p4 = new Point(5,-5);
	Rectangle r2= new Rectangle(p3, p4);
	System.out.println(r2);
	
	System.out.printf("Rectangles after instaniation: %d\n",Rectangle.getCount());

    }




}