//Product 1, $2.98; product 2, $4.50; product 3, $9.98; product 4, $4.49 and product 5, $6.87

// Program calculates sales, based on an input of product
// number and quantity sold
import java.util.Scanner;

public class sales
{
    // calculates sales for 5 products
    public static void main(String[] args)
    {
	Scanner input = new Scanner(System.in);
      
	double total = 0; // total of all products sold
	int productID; // specifies product entered by the user

	// determine the product chosen
	System.out.print("Enter product number (1-5 or 0 to stop): ");
	productID = input.nextInt();

	// ask user for product number until flag value entered
	while (productID != 0)
	    {
		if (productID >= 1 && productID <= 5)
		    {
			// determine the number sold of the item
			System.out.print("Enter quantity sold: ");
			int quantity = input.nextInt();

			// increment the total for the item by the
			// price times the quantity sold
			switch (productID)
			    {
			    case 1:
				total += quantity * 2.98;
				break;
			    case 2:
				total += quantity * 4.50;
				break;
			    case 3:
				total += quantity * 9.98;
				break;
			    case 4:
				total += quantity * 4.49;
				break;
			    case 5:
				total += quantity * 6.87;
				break;
			    } 
		    } 
		else if (productID != 0)
		    System.out.println(
				       "Product number must be between 1 and 5 or 0 to stop");

		// determine the product chosen
		System.out.print("Enter product number (1-5 or 0 to stop): ");
		productID = input.nextInt();
	    } 

	// print summary
	System.out.println();
	System.out.printf("Total retail value of all products sold is: $%.2f%n", total);
    } 
} // end class Sales

