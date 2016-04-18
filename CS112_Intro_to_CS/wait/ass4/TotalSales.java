public class TotalSales 
{
    public static void main(String[] args)
    {
	double[][] salesInfo={{180.35,166.99,55.38,103.23},
			      {158.96,133.77,94.77,17.36},
			      {186.77,3.25,164.56,0.0},
			      {34.55,133.92,84.75,108.56},
			      {129.01,179.5,109.32,135.93}};
	//your code here
	System.out.println("Values in array1 by row are");
	System.out.print("                 ");
	for (int test = 0; test < salesInfo[0].length; test++)
	    System.out.printf("Salesperson %d ", test + 1);
	System.out.println("Tot. of the products:");
	
    double TotproductTotal = 0.0;
	double salesPersonTotal[] = new double [4];
	for (int row = 0; row < 5; row++)
	    {
		double productTotal = 0.0;
        
		System.out.printf( "     %8d", (row+1));

		for (int column = 0; column < 4; column++)
		    {
			System.out.printf("%14.2f", salesInfo[row][column]);
			productTotal += salesInfo[row][column];
			salesPersonTotal[column] += salesInfo[row][column];
		    }

		System.out.printf("%10.2f\n", productTotal);
        TotproductTotal += productTotal;
	    }


        System.out.printf("%8s", "Total     ");
        
        for (int column = 0; column < 4; column++)
            System.out.printf(" %14.2f", salesPersonTotal[column]);
        System.out.printf("   %.2f",TotproductTotal);


	System.out.println();
	}

    public static double getTot(double[] setOfGrades)
    {
	double total = 0.0;
	for (double value : setOfGrades)
	    total += value;
	return total;
    }

    public static void outputArray(double[][] array)
    {
	    for (int row = 0; row < array.length; row++)
		{
		    for (int column = 0; column < array[row].length-1 ; column++)
			System.out.printf("%f  ", array[row][column]);
		    System.out.println();
		}
     }
	
    
}