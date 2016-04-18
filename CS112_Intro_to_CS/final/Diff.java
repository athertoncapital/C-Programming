import java.util.ArrayList;

public class Diff {

    public static void main(String[] args)
    {
	ArrayList<Integer> a = new ArrayList<Integer>();
	a.add(1);
	a.add(4);
	a.add(9);
	a.add(6);
	ArrayList<Integer> b = new ArrayList<Integer>();
	b.add(1);
	b.add(2);
	b.add(6);
	System.out.println(a);
	System.out.println(b);
	ArrayList<Integer> result=diff(a,b);
	System.out.print(result);
    }
    public static ArrayList<Integer>diff(ArrayList<Integer>a,ArrayList<Integer>b)
    {
	ArrayList<Integer>result = new ArrayList<Integer>();
	for(int i=0;i<a.size(); i++)
	    if(!b.contains(a.get(i)))
		result.add(a.get(i));
	for(int i=0;i<b.size(); i++)
	    if(!a.contains(b.get(i)))
		result.add(b.get(i));
	return result;
    }

    

}