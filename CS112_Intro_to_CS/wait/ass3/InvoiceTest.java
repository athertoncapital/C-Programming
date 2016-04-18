
public class InvoiceTest
{
    public static void main(String[] args)
    {
        // create invoice1
        Product p1 = new Product("Hammer", 14.95);
        Invoice invoice1 = new Invoice(p1, 2);
        
        // display invoice1
        System.out.println(invoice1);
        System.out.printf("Invoice amount: %.2f%n", invoice1.getInvoiceAmount());
        
        // change invoice1's data
        try
        {
            invoice1.setQuantity(-3);
        }
        catch (IllegalArgumentException e)
        {
            System.out.printf("Exception while set invoice1: %s\n",e.getMessage());
        }
        
        Product p2=new Product(p1);
        p2.setPrice(5.2);
        System.out.println(p2);
        
        try
        {
            Invoice invoice2 = new Invoice(p2, -5);
        }
        catch (IllegalArgumentException e)
        {
            System.out.printf("Exception while initialize invoice2: %s\n",e.getMessage());
        }
        
        Product p3=new Product(p1);
        p3.setPrice(5.2);
        System.out.println(p3);
        try
        {
            Invoice invoice2 = new Invoice(p3, -5);
        }
        catch (IllegalArgumentException e)
        {
            System.out.printf("Exception while initialize invoice2: %s\n",e.getMessage());
        }
        
        Invoice invoice2 = new Invoice(p3, 99);
        
        // display invoice2
        System.out.println(invoice2);
        System.out.printf("Invoice amount: %.2f%n", invoice2.getInvoiceAmount());
        
        try
        {
            Product p4=new Product("brush",0);
        }
        catch (IllegalArgumentException e)
        {
            System.out.printf("Exception while initialize p3: %s\n",e.getMessage());
        }
        
        // change p3's data
        try
        {
            p3.setPrice(-3);
        }
        catch (IllegalArgumentException e)
        {
            System.out.printf("Exception while set p2: %s\n",e.getMessage());
        }
        
        Invoice invoice3 = new Invoice(invoice1);
        invoice3.setQuantity(100);
        // display invoice3
        System.out.println(invoice3);
        System.out.printf("Invoice amount: %.2f%n", invoice3.getInvoiceAmount());
        
        Product p5 = new Product("Brush",2.3);
        System.out.println(p5);
    } // end main
} // end class InvoiceTest


/**************************************************************************
 * (C) Copyright 1992-2015 by Deitel & Associates, Inc. and               *
 * Pearson Education, Inc. All Rights Reserved.                           *
 *                                                                        *
 * DISCLAIMER: The authors and publisher of this book have used their     *
 * best efforts in preparing the book. These efforts include the          *
 * development, research, and testing of the theories and programs        *
 * to determine their effectiveness. The authors and publisher make       *
 * no warranty of any kind, expressed or implied, with regard to these    *
 * programs or to the documentation contained in these books. The authors *
 * and publisher shall not be liable in any event for incidental or       *
 * consequential damages in connection with, or arising out of, the       *
 * furnishing, performance, or use of these programs.                     *
 *************************************************************************/