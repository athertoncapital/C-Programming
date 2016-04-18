import java.util.ArrayList;
public class ArrayMethods {
    public static void main(String[] args)
    {
	ArrayList<String> list1=new ArrayList<String>();
	ArrayList<String> list2=new ArrayList<String>();
	list1.add("red");
	list1.add("yellow");
	list1.add("blue");
	list1.add("green");
	list1.add("orange");
	list1.add("purple");

	ArrayList<String> list1Copy1 = new ArrayList<String>(list1);
	ArrayList<String> list1Copy2 = new ArrayList<String>(list1);
    
	list2.add("white");
	list2.add("black");

	System.out.println("list1 before downsize: "+list1);
	downsize(list1);
	System.out.println("list1 after downsize: "+list1);
	System.out.println("list1 before reverse: "+list1Copy1);
	reverse(list1Copy1);
	System.out.println("list1 after reverse: "+list1Copy1);
	System.out.println("list1 before transfer: "+list1Copy2);
	System.out.println("list2 before transfer: "+list2);
	transfer(list1Copy2,list2);
	System.out.println("list1 after transfer: "+list1Copy2);
	System.out.println("list2 after transfer: "+list2);
    }
    public static void downsize(ArrayList<String> list)
    {
	for(int i=0; i < list.size(); i++)
	    list.remove(i);
    }
    public static void reverse(ArrayList<String> list)
    {
	int i, j;
	for (i=0, j=list.size()-1; i < j; i++, j--)
	    {
		String temp=list.get(i);
		list.set(i,list.get(j));
		list.set(j,temp);
	    }
    }
    public static void transfer(ArrayList<String> list1, ArrayList<String> list2)
    {
	for(int i=0; i < list1.size(); i++)
	    {
		String temp=list1.remove(i--);
		list2.add(temp);
	    }
    }
}