import java.util.ArrayList;
import java.util.*;
public class ArrayMethods {
    public static void main(String[] args)
    {
	ArrayList<String> list1=new ArrayList<String>();
	ArrayList<String> list1copy1=new ArrayList<String>();
	ArrayList<String> list1copy2=new ArrayList<String>();
	ArrayList<String> list2=new ArrayList<String>();
	list1.add("red");
	list1.add("yellow");
	list1.add("blue");
	list1.add("green");
	list1.add("orange");
	list1.add("purple");
	System.out.print("list1 before downsize:");
	System.out.println(list1.toString());	 
	downsize(list1);
	System.out.print("list1 after downsize:");
	System.out.println(list1.toString());	 


	list2.add("white");
	list2.add("black");
	System.out.print("list2 before downsize:");
	System.out.println(list2.toString());	 

	
	list1copy1.add("red");
	list1copy1.add("yellow");
	list1copy1.add("blue");
	list1copy1.add("green");
	list1copy1.add("orange");
	list1copy1.add("purple");
	System.out.print("list1 before reverse:");
	System.out.println(list1copy1.toString());	 

	reverse(list1copy1);
	System.out.print("list1 after reverse:");
	System.out.println(list1copy1.toString());	 



	
        list1copy2.add("red");
	list1copy2.add("yellow");
	list1copy2.add("blue");
	list1copy2.add("green");
	list1copy2.add("orange");
	list1copy2.add("purple");
	System.out.print("list1 before transfer:");
	System.out.println(list1copy2.toString());	 
	transfer(list1copy2,list2);
	System.out.print("list1 after transfer:");
	System.out.println(list1copy2.toString());	 
	System.out.print("list2 after transfer:");
	System.out.println(list2.toString());	 



    }
    public static void downsize(ArrayList<String> list) 
    {
	ArrayList<String> iter = new ArrayList<String>();
	for(int i=0; i<list.size(); i++)
	    {
		//		iter.next();
		if (i % 2 != 0) 
		    {
			iter.add(list.get(i));
		    }
		//		i--;

	    }

	list.clear();
	for(int i=0; i<iter.size(); i++)
	    {
	
	       list.add(iter.get(i));
	
	    }
	System.out.println(list.toString());	
    }
    public static void reverse(ArrayList<String> list)
    {
	ArrayList<String> rev = new ArrayList<String>();
	int t=list.size();
	for(int i=t-1; i>0; i--)
	  {
		rev.add(list.get(i));
	  }
	    

		list.clear();
		for(int i=0; i<rev.size(); i++)
	  {
	
	       list.add(rev.get(i));
	
	  }
	System.out.println(rev.toString());	
    }
    public static void transfer(ArrayList<String> list1, ArrayList<String> list2)
    {

	for(int i=0; i<list1.size(); i++)
	  {
		list2.add(list1.get(i));
	  }
	    
	list1.clear();
	System.out.println(list2.toString());	
    }

}
