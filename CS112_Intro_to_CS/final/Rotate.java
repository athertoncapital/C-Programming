import java.util.ArrayList;
public class Rotate {
    public static void main(String[] args)
    {	ArrayList<Integer> list = new ArrayList<Integer>();
	list.add(3);	list.add(5);
	System.out.println(list.toString());
	rotate(list);
	System.out.println(list.toString());}
    public static void rotate(ArrayList<Integer> list)
    {	int first = list.get(0);
	for(int i=0; i< list.size()-1; i++)
	    list.set(i, list.get(i+1));
	list.set(list.size()-1,first);}}