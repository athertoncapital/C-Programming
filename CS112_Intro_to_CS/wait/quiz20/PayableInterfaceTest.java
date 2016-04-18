public class PayableInterfaceTest 
{
    public static void main(String[] args)
    {
	// create six-element Payable array
	Payable[] payableObjects = new Payable[6];
      
	// populate array with objects that implement Payable
	payableObjects[0] = new Invoice("01234", "seat", 2, 375.00);
	payableObjects[1] = new Invoice("56789", "tire", 4, 79.95);
      payableObjects[2] = 
	  new SalariedEmployee("John", "Smith", "111-11-1111", 800.00);
      payableObjects[3] = 
	  new HourlyEmployee("Karen", "Price", "222-22-2222", 16.75, 40);
      payableObjects[4] = 
	  new CommissionEmployee(
				 "Sue", "Jones", "333-33-3333", 10000, .06);
      payableObjects[5] = 
	  new BasePlusCommissionEmployee(
					 "Bob", "Lewis", "444-44-4444", 5000, .04, 300);

      System.out.println("The total payment due is: "+ totalPayment(payableObjects)); 

    } // end main
    public static double totalPayment(Payable[] payableObjects)
    {
	// your code here
        double sum=0;

	double sum2=0;
	for (Payable currentPayable : payableObjects)
	    {
		sum2+=currentPayable.getPaymentAmount();
	    }




	for (Payable currentPayable : payableObjects)
	    {
		// output currentPayable and its appropriate payment amount
		System.out.printf("%s \n", currentPayable.toString()); 
            
		if (currentPayable instanceof BasePlusCommissionEmployee)
		    {
			// downcast Payable reference to 
			// BasePlusCommissionEmployee reference
            BasePlusCommissionEmployee employee1 =
		(BasePlusCommissionEmployee) currentPayable;

            double S1 = employee1.getPaymentAmount();
	    sum+=S1;
		    } // end if
            
		if (currentPayable instanceof SalariedEmployee)
		    {
			// downcast Payable reference to
			// SalariedEmployee reference
                SalariedEmployee employee2 =
		    (SalariedEmployee) currentPayable;
                
                double S2 = employee2.getPaymentAmount();
                sum+=S2;
                
		    } // end if
		if (currentPayable instanceof HourlyEmployee)
		    {
			// downcast Payable reference to
			// SalariedEmployee reference
                HourlyEmployee employee3 =
		    (HourlyEmployee) currentPayable;
                
                double S3 = employee3.getPaymentAmount() ;
                sum+=S3;
                
		    } // end if
		if (currentPayable instanceof CommissionEmployee)
		    {
			// downcast Payable reference to
			// SalariedEmployee reference
                CommissionEmployee employee4 =
		    (CommissionEmployee) currentPayable;
                
                double S4 = employee4.getPaymentAmount();
                sum+=S4;
                
		    } // end if

		//System.out.printf("%s: $%,.2f\n\n",
		//  "payment due", currentPayable.getPaymentAmount());
	    } // end for
	return sum2;


    }

} // end class PayableInterfaceTest