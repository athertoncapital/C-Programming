public class template
{

    public static void main(String args[])
    {
	int x=0;
	for(int i=0;i<11;i++)
	    {
		if (i%3==0)continue;
		if (i%5==0)break;
		x++;
	    }
	System.out.printf("%d ",x);
    }
}
