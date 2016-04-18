/******************************************************************/
/* Author: CS112 William Chuang                                   */
/* Date: October 20, 2015                                         */
/* Description: assignment 3-2 Product                            */
/******************************************************************/

import java.io.*;

public class Product
{
    private final int number;//immutable
    private double price;
    private String description; // instance variable
    public static int member=1000;
    
    public Product(String description, double price)
    {
        if (price<=0){
	    throw new IllegalArgumentException("Price must be positive");
        }
        
        this.description=description;
       
        this.price=price;
        this.number=member++;
        //member++;
        
        
    }
    public Product(Product aProduct)
    {
        // this(aProduct.getDescription(), aProduct.getPrice());
  
        this.price=aProduct.getPrice();
        this.number=aProduct.number;
        this.description=aProduct.description;
    }

    public String getDescription()        
    {                                    
	return description; // return value of part_number to caller        
    }
    public void setDescription(String description)
    {
	this.description=description;
    }


    public double getPrice()
    {                                    
	return price; // return value of part_number to caller        
    }
    public void setPrice(double price)
    {
        if (price<=0){
	    throw new IllegalArgumentException("Price must be positive");
        }
        else{
	this.price=price;
            }
    }

    public int getNumber()        
    {
        
	return number; // return value of part_number to caller
    }

    public int getMember()        
    {                                    
	return member; // return value of part_number to caller        
    }

    public String toString()
    {
	return String.format("Product No: %d, Description: %s, Price: %f.", getNumber(), getDescription(), getPrice()); 
	
    }
}