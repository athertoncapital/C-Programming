import java.util.Random;
import java.util.Arrays;
import java.util.Scanner;

public class BinarySearchTest
{
    // // Loop version perform a binary search on the data      
    public static int binarySearch(int[] data, int key)
    {
	int low = 0;                 
	int high = data.length - 1; 
	int middle = (low + high + 1) / 2;     
	int location = -1; 
	do 
	    {                       
		if (key == data[middle])                                  
		    location = middle;   
		else if (key < data[middle]) 
		    high = middle - 1;        
		else                          
		    low = middle + 1;          
		middle = (low + high + 1) / 2; 
	    } while ((low <= high) && (location == -1));               
	return location; 
    }                        

    public static int binarySearchRecursion(int[ ] data, int key, int low, int high) 
    {
	if (low > high) return -1; 
	int mid = (low + high)/2;
	if (data[mid] == key) return mid;
	else if (data[mid] < key)
	    return binarySearchRecursion(data, key, mid+1, high);
	else
	    return binarySearchRecursion(data, key, low, mid-1);
    }

    public static void main(String[] args)
    {
	Scanner input = new Scanner(System.in);
	Random generator = new Random(1);
	int[] data = new int[15]; // create array
	for (int i = 0; i < data.length; i++) // populate array
	    data[i] = 10 + generator.nextInt(90);
	Arrays.sort(data); // binarySearch requires sorted array
	System.out.printf("%s%n%n", Arrays.toString(data)); // display array
	// get input from user
	System.out.print("Please enter an integer value (-1 to quit): ");
	int searchInt = input.nextInt(); 
	// repeatedly input an integer; -1 terminates the program
	while (searchInt != -1)
	    {
		//int location = binarySearch(data, searchInt);
		int location = binarySearchRecursion(data,searchInt,0,data.length-1);
		if (location == -1) // not found
		    System.out.printf("%d was not found%n%n", searchInt); 
		else // found
		    System.out.printf("%d was found in position %d%n%n",  searchInt, location);
		// get input from user
		System.out.print("Please enter an integer value (-1 to quit): ");
		searchInt = input.nextInt();
	    } 
    } // end main
} // end class BinarySearchTestpublic class BinarySearch