import java.util.Scanner;
public class PrintTriangle
{

    public static void main(String[] args)
    {
	int side;

	Scanner input = new Scanner(System.in);
      
	System.out.print("Enter the side of the triangle to draw: ");
	side = input.nextInt();
	printTriangle(side);
    }      // draw triangle

    public static void printTriangle(int side)
    {

	if (side == 1) {
	    System.out.println("*");
	} else {
	    int k;
	    printTriangle(side - 1);
	    for (k=0;k<side;k++)
	    System.out.print("*");
	    System.out.print("\n");


	}

}
} // end class PrintTriangles
