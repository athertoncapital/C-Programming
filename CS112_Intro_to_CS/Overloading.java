import java.util.Scanner;
public class Overloading {
    public static void main(String arg[])
    {
	Scanner in = new Scanner(System.in);
	System.out.println("Please enter 3 integer values:");
	int num1=in.nextInt();
	int num2=in.nextInt();
	int num3=in.nextInt();
	System.out.println("The sum is: "+add3(num1,num2,num3));
	System.out.println("Please enter 3 String values:");
	String str1=in.next();
	String str2=in.next();
	String str3=in.next();
	System.out.println("The Concatenated string is: "+add3(str1,str2,str3));
    }

    public static int add3(int a, int b, int c)
    {
	return a+b+c;
    }
    public static String add3(String a, String b, String c)
    {
	return a+b+c;
    }
}