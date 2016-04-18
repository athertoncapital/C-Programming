import java.util.ArrayList;

public class DeleteNegative {
    public static void main(String[] args)
    {
	ArrayList<Integer> list = new ArrayList<Integer>();
	list.add(-3);
	list.add(5);
	list.add(7);
	list.add(-11);
	list.add(-13);
	list.add(2);
	list.add(0);
	
	System.out.println(list.toString());
	deleteNegative(list);
	System.out.println(list.toString());

    }
    public static void deleteNegative(ArrayList<Integer> list)
    {
	int i=0;
	while(i < list.size())
	    if(list.get(i) <0)
		list.remove(i);
	    else
		i++;
    }
}