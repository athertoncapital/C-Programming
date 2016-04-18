

public class test2
{
    public static void main(String[] args)
    {
	// create Scanner to obtain input from command window
        int i=5;
        int row =5;
        int column;
        while (i-->0){
	    System.out.printf("%d ", i);
        
        }
        System.out.printf("%n");
        column = 1 ;
        
        while (row >=1)
	    {
		column = 1;
		while (column <=5)
		    {
			System.out.print ((row+column)%2 == 1 ? "<" : ">");
			System.out.printf("%d,%d%n",row,column);
			++column;
		    }
		--row;
		System.out.println();
	    }

    } // end method main
} // end class Product


