import java.util.Arrays;
public class Matrix {
    public static void main(String[] args)
    {
	//your code to create the 2-D array
	int matrix[][]=new int[4][4];
	int value=1;
	for (int row=0; row<=3; row++)
	    for (int col=3; col>=0; col--)
		    matrix[row][col]=value++;
	System.out.println(Arrays.deepToString(matrix));
	// your code to display the 2-D array of the specified sequence
	int col;
	int row;
	for(col=0; col <4; col++)
	  for(row=3; row>=0; row--)
	System.out.print(matrix[row][col]+" ");
	System.out.println("");
    }
}