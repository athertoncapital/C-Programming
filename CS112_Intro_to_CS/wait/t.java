public class t
{
    // recursive method factorial (assumes its parameter is >= 0
    public static void main(String[] args)
    {
	// calculate the factorials of 0 through 21
	//	for (int counter = 2; counter <= 5; counter++)
	    System.out.printf("%d! %n",  factorial(5));
    }




    public static long factorial(long number)
    {


	System.out.printf("%d%n",number);
	if (number <= 1) // test for base case
	    return 1; // base cases: 0! = 1 and 1! = 1
	else // recursion step
	    return number * factorial(number - 1);
    } 

    // output factorials for values 0-21
} // end class FactorialCalculator