public class Divisor
{
    /*    public static void main(String[] args)
    {
        System.out.printf("GCD is %d%d%n%n", gcd(52, 12));
    }
    public static int gcd(int x, int y)
    {
	System.out.println(x+","+y);
        if (y == 0)
            return x;
        else
            return gcd(y, x % y);
	    }*/
    public static void main(String[] args)
    {
        System.out.println(someMethod(5));
    }

    public static int someMethod(int n)
    {
        System.out.println(n);
        if (n == 0)
            return 0;
        else
            return n + someMethod(n-1);
    }
} // end class Divisor