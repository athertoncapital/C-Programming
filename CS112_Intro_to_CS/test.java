import java.util.Scanner;
public class test{
    public static void main(String[] args){
    	int[] frequency = new int[10];
	Scanner s = new Scanner(System.in);
	prompt(frequency,s);
	print_(frequency);
	s.close();
    }
//prompt, scan, and check dup
















    public static void prompt(int[]frequency, Scanner s){
	for(int i=0; i<5; i++)
	    {
		System.out.println("type");
		int number = s.nextInt();
		check(number,frequency,s);
	    }
    }
    public static void check(int number, int[] frequency, Scanner s)
    {
	try
	    {
		if(frequency[number]!=0){
		    System.out.println("dup:"+number);
		}
		else{
		    frequency[number]++;
		}
	    }
	catch(ArrayIndexOutOfBoundsException e)
	    {
		System.out.println(e+"isn't in 0-9");
	    }
    }
    public static void print_(int[] frequency)
    {
	System.out.println("Inputs:");
	for (int i=0; i<frequency.length; i++)
	    if(frequency[i]==1)System.out.println(i);
    }
}