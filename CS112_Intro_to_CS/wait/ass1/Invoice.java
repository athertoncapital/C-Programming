/******************************************************************/
/* Author: CS112 William Chuang                                   */
/* Date: September 13, 2015                                       */
/* Description: assignment 1-3 Invoice                            */
/******************************************************************/

public class Invoice
{
    private String part_number; // instance variable
    private String part_description; // instance variable
    private int quantity; // instance variable
    private double price; // instance variable
    
    public Invoice(String part_number, String part_description, int quantity,  double price) {
	this.part_number = part_number; 
	this.part_description = part_description; 
	if (quantity<0)
	    quantity = 0;
	else
	    this.quantity = quantity;
	if (price<0)
	    price = 0.0;
	else
	    this.price = price;
    }


    // method to set the part number in the object              
    public void setpart_number(String part_number)      
    {                                             
	this.part_number = part_number; 
    }         

    // method to retrieve the part number from the object
    public String getpart_number()        
    {                                    
	return part_number; // return value of part_number to caller        
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
    
   
 
    // method to set the quantity in the object              
    public void setQuantity(int quantity)      
    {                      
	if (quantity<0)
	    {
		this.quantity = 0;
	    }
	else
	    this.quantity = quantity; // store the quantity
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
    

    // method to retrieve the average from the object
    public double getInvoiceAmount()
    {
	return price * quantity;
    }
} // end class Invoice