import java.util.Scanner;
public class main 
{
    public static void main(String[] args)
    {
	int[] a=new int[10];
	for (int counter = 0; counter < array.length; counter++)
	    a[counter]=-10;
	for (int counter = 0; counter < array.length; counter++)
	    ++frequency[randomNumbers.nextInt(11)];
	for (int k: a)
	    total += k;
	int smallest;
	smallest=a[0];
	for (int k: a)
	    if (k<smallest)smallest=k;
	int largest;
	largest=a[0];
	for (int k: a)
	    if (k<largest)largest=k;
	
	int fre = new int[10];
	int[] responses = {0,1,2,3,4,5,6,7,8,9};
	
	Scanner sc = new Scanner(System.in);
	for (int answer = 0; answer < responses.length; answer++)
	    {
		System.out.printf("Enter a number:");
		int answer=scan.nextInt();	
		try
		    {
			++fre[responses[answer]];
		    } 
		catch (ArrayIndexOutOfBoundsException e)
		    {
			System.out.println(e); // invokes toString method
			System.out.printf("   responses[%d] = %d%n%n", 
				   answer, responses[answer]);
		    } 
	     } 

	
	System.out.printf("%s%10s%n", "Numbers", "Frequency");
	for (int rating = 1; rating < frequency.length; rating++)
	    System.out.printf("%6d%10d%n", rating, frequency[rating]);
    
	public class Book{
	    public String title;
	    public String author;
	    public Book(String title, String author) {
		this.title = title;
		this.author = author;
	    }
	    public toString()
	    {
		return author +","+ title;
	    }

	}
	public class BookTest{
	    Book[] abook = new Book[5];
	    Scanner s = new Scanner(System.in);
	    for (int count = 0; count < 5; count++)
		{
		    System.out.printf("Enter a title of the book");
		    String title = s.nextLine();
		    System.out.printf("Enter an autuhor's name:");
		String abook[]=scan.nextString();
	    }
	}
    }
}