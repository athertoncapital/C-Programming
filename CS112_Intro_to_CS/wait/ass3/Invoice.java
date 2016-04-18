/******************************************************************/
/* Author: CS112 William Chuang                                   */
/* Date: October 20  , 2015                                       */
/* Description: assignment 3-2 Invoice                            */
/******************************************************************/

import java.io.*;

public class Invoice
{
    private Product product;
    private int quantity; // instance variable
    
    public Invoice(Product product, int quantity)
    {
        if (quantity<=0){
	    throw new IllegalArgumentException("Product quantity must be positive");
        }
	this.quantity=quantity;
	this.product=product;
    }
    public Invoice(Invoice aInvoice) {
	this(aInvoice.getProduct(), aInvoice.getQuantity());

    }
    
    private String part_number; // instance variable
    private String part_description; // instance variable

    private double price; // instance variable
    

    // method to set the part number in the object              
    public void setpart_number(String part_number)      
    {                                             
	this.part_number = part_number; 
    }

    // method to set the part description in the object              
    public void setpart_description(String part_description)      
    {                                             
	this.part_description = part_description; 
    }         

    // method to retrieve the par description from the object
    public String getpart_description()        
    {                                    
	return part_description; // return value of part_description to caller        
    }
    // method to set the part description in the object              
    public void setProduct(Product product)      
    {                                             
	this.product = product; 
    }         

    // method to retrieve the par description from the object
    public Product getProduct()
    {                                    
	return product; // return value of part_description to caller        
    }
    
    // method to retrieve the par description from the object
    public double getInvoiceAmount()        
    {                                    
	return quantity*product.getPrice();
    }
   
 
    // method to set the quantity in the object              
    public void setQuantity(int quantity)      
    {                      
	    
	if (quantity<0){
	    throw new IllegalArgumentException("Product quantity must be positive");
        }
	this.quantity=quantity;

    }
    
    // method to retrieve the quantity from the object
    public int getQuantity()
    {
        return quantity; // return value of quantity to caller
    }

    // method to set the price in the object
    public void setPrice(double price)      
    {                             
	if (price<0)
	    {
		this.price = 0.0;
	    }
	else
	    this.price = price; 
    }         
    // method to retrieve the price from the object
    public double getPrice()
    {
        return price; // return the value of price to caller
    }
    

    public String toString()
	{
	    return String.format("Product No: %d, Description: %s, Price: %f, Qty: %d ", product.getNumber(), product.getDescription(), product.getPrice(), getQuantity());
	
	}
    
} // end class Invoice