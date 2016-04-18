import java.util.Scanner; 
public class frequency
{
    public static void main(String[] args)
    {
	Scanner input = new Scanner(System.in);
	int[] frequency = new int[10];
	int count=0;
	int[] responses = {0,1,2,3,4,5,6,7,8,9};
	while(count<3){
	System.out.printf("Pick an integer between 0 and 9, inclusive, that you have not picked previously:%n");
	int number = input.nextInt();
		if(frequency[number]<2)
		    {
			try
			    {
				++frequency[responses[number]];
				count++;
			    }

			catch (ArrayIndexOutOfBoundsException e)
			    {
				System.out.println(e);
				System.out.printf("   your input: %d = %d%n%n",number, responses[number]);
			    }
					
		    }
		
		else
		    {
			System.out.printf("You have picked %d previously%n",number);
		    }
	}
	System.out.printf("The number you picked are:%n");
	
	for (int face = 1; face < frequency.length; face++)
	    if(frequency[face]>0)

	    System.out.printf("%d%n",face);
    }
}