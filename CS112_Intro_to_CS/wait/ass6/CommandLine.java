public class CommandLine
{
    public static void main(String[] args)
    {
	int count=0, flag=0;
	double total=0, avg, arg;
	//System.out.println(args[0]);
	for (String argument : args) {
	   try {
		arg = Double.parseDouble(argument);
		// If an error occurs, the next 2 lines are skipped!
		total+= arg;
		count++;
	   }//try
	    catch (RuntimeException e) {
		System.out.println("Not a legal number! Usage: java CommandLine <double>");
		System.exit(0);
		//		flag=1;
	    }//catch

	}//for
	if (count!=0){ 
	    avg = total/count;
	    System.out.printf("The average of %d numbers is %f %n", count, avg);
	}

	else if (count==0)
	System.out.println("0");
	else
	    System.out.println("");

    } //main
} // end class InitArray