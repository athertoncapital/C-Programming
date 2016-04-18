import java.util.Scanner;
public class quiz16 {
    public static void main(String[] args)
	int[] frequency= new int[10];
	Scanner s=new Scanner(System.in);	
	prompt(frequency,s);print_(frequency);	s.close();}
    public static void prompt(int[] frequency, Scanner s){
	for(int i =0; i< 5; i++){
		System.out.println("Pick an integer between 0 and 9, inclusive that you have not picked previously:");
		int number = s.nextInt();
		checkdup(number,frequency,s);}}
    public static void print_(int[] frequency)
    {System.out.println("The numbers you picked are:");	
	for(int i=0; i < frequency.length; i++)
	    if (frequency[i] ==1)
		System.out.println(i);}
    public static void checkdup(int number, int[] frequency, Scanner s)
    {		try{if(frequency[number] != 0)
			    System.out.println("You have picked "+number+" previously" );
			else
			    frequency[number]++;}
		catch(ArrayIndexOutOfBoundsException e)
		    {System.out.println(e+" is not between 0 and 9"); }}