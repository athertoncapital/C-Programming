import java.util.ArrayList;
import java.util.*;

public class Rotate {
    public static void main(String[] args)
    {


	ArrayList<Integer> a = new ArrayList<Integer>();
	a.add(2);
	a.add(4);
	a.add(9);
	a.add(6);
	ArrayList<Integer> b = new ArrayList<Integer>();
	b.add(13);
        b.add(11);
        b.add(11);
	b.add(13);
	b.add(2);
        b.add(2);
        b.add(4);
        b.add(9);
        b.add(6);
	System.out.println(a.toString());
	System.out.println(b.toString());

	ArrayList<Integer> c = diff(a,b);
	System.out.println(a.toString());
	System.out.println(b.toString());
	System.out.println(c.toString());

    }
    public static ArrayList<Integer> diff(ArrayList<Integer> a, ArrayList<Integer> b)
    {
	
        ArrayList<Integer> r=new ArrayList<Integer>();
        ArrayList<Integer> rr=new ArrayList<Integer>();
        ArrayList<Integer> rrr=new ArrayList<Integer>();



        

       
        for(int i=0; i < a.size(); i++)
	    {int TR=1;
		int t=a.get(i);
		for (int p=0; p<b.size();p++){
                
		    if (t==b.get(p)) TR=0;}
		if (TR==1)
		    r.add(t);
            
	    }
        
        for(int i=0; i < b.size(); i++)
	    {int TR=1;
		int t=b.get(i);
		for (int p=0; p<a.size();p++){
                
		    if (t==a.get(p)) TR=0;}
		if (TR==1)
		    r.add(t);
            
	    }
        
        for(int i=0; i < r.size(); i++)
	    {int TR=1;
		int t=r.get(i);
		for (int p=i+1; p<rr.size();p++){
                
		    if (t==rr.get(p)) TR=0;}
		if (TR==1)
		    rrr.add(t);
   
            
	    }


        return rrr;
    }

}
