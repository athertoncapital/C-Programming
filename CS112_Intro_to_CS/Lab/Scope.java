public class Scope
{
    static constant i =20;
    public static void f(int i)
    {
	System.out.printf("%d\n",++i);
    }
    public static void g()
    {
	int i = 2;
	i++;
	System.out.printf("%d\n", i);
    }
    public static void h()
    {
	i++;
	System.out.printf("%d\n",i);
       
    }
    public static void j()
    {
	i+=2;
	System.out.printf("%d\n",i);
    }
    public static void main(String[] args)
    {
	f(5);
	g();
	h();
	h();
	h();
	j();
    }


}