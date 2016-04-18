import java.util.ArrayList;

public class Merge {
    public static void main(String[] args)
    {
	ArrayList<Integer> a = new ArrayList<Integer>();
	a.add(1);
	a.add(4);
	a.add(9);
	a.add(6);
	ArrayList<Integer> b = new ArrayList<Integer>();
	b.add(13);
	b.add(2);

	System.out.println(a.toString());
	System.out.println(b.toString());
	ArrayList<Integer> c = merge(a,b);
	System.out.println(a.toString());
	System.out.println(b.toString());
	System.out.println(c.toString());

    }
    public static ArrayList<Integer>merge(ArrayList<Integer> a, ArrayList<Integer>b)
    {
	ArrayList<Integer> result=new ArrayList<Integer>();
	if(a.size() < b.size())
	    {
		for(int i=0; i < a.size(); i++)
		    {
			result.add(a.get(i));
			result.add(b.get(i));
		    }
		for(int j=a.size(); j< b.size(); j++)
		    result.add(b.get(j));
	    }
	else
	    {
		for(int i=0; i < b.size(); i++)
		    {
			result.add(a.get(i));
			result.add(b.get(i));
		    }
		for(int j=b.size(); j< a.size(); j++)
		    result.add(a.get(j));
	    }
	return result;
    }
}