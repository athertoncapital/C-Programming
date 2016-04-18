/******************************************************************/
/* Author: CS112 William Chuang                                   */
/* Date: September 13, 2015                                       */
/* Description: assignment 1-3 InvoiceTest                        */
/******************************************************************/

public class InvoiceTest
{

    public static void main(String[] args)
    { 
	// create an Invoice object and assign it to Invoice1
	Invoice Invoice1 = new Invoice ("1234","Hammer",2,14.95); //using convenience constructor with four parameterized values
	System.out.printf("Original invoice information%n");
	System.out.printf("Part number: %s%n", Invoice1.getpart_number());
	System.out.printf("Description:  %s%n", Invoice1.getpart_description());
	System.out.printf("Quantity: %d%n", Invoice1.getQuantity());
	System.out.printf("Price:  %.2f%n", Invoice1.getPrice());
	System.out.printf("Invoice amount: %.2f%n", Invoice1.getInvoiceAmount());
    // put new values in partnumbers
	Invoice1.setpart_number("001234");
	Invoice1.setpart_description("Yellow Hammer");
	Invoice1.setQuantity(3);
	Invoice1.setPrice(19.49);
    // print out the updated data
	System.out.printf("%nUpdated invoice information%n");
	System.out.printf("Part number: %s%n", Invoice1.getpart_number());
	System.out.printf("Description:  %s%n", Invoice1.getpart_description());
	System.out.printf("Quantity: %d%n", Invoice1.getQuantity());
	System.out.printf("Price:  %.2f%n", Invoice1.getPrice());
	System.out.printf("Invoice amount: %.2f%n", Invoice1.getInvoiceAmount());

	// create the other Invoice object and assign it to Invoice2
	Invoice Invoice2 = new Invoice ("5678","Paint Brush",-5,-9.99); //using convenience constructor with four parameterized values
	System.out.printf("%nOriginal invoice information%n");
	System.out.printf("Part number: %s%n", Invoice2.getpart_number());
	System.out.printf("Description:  %s%n", Invoice2.getpart_description());
	System.out.printf("Quantity: %d%n", Invoice2.getQuantity());
	System.out.printf("Price:  %.2f%n", Invoice2.getPrice());
	System.out.printf("Invoice amount: %.2f%n", Invoice2.getInvoiceAmount());

	// put new values in partnumbers
	Invoice2.setQuantity(3);
	Invoice2.setPrice(9.49);

	System.out.printf("%nUpdated invoice information%n");
	System.out.printf("Part number: %s%n", Invoice2.getpart_number());
	System.out.printf("Description:  %s%n", Invoice2.getpart_description());
	System.out.printf("Quantity: %d%n", Invoice2.getQuantity());
	System.out.printf("Price:  %.2f%n", Invoice2.getPrice());
	System.out.printf("Invoice amount: %.2f%n", Invoice2.getInvoiceAmount());

    } 
} // end class InvoiceTest