public class main 
{
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
}
