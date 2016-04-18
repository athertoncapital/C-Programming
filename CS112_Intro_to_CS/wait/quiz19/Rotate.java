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
	b.add(12);
        b.add(2);
        b.add(4);
        b.add(9);
        b.add(6);
	System.out.println("Here is the array a:");
	System.out.println(a.toString());
	System.out.println("Here is the array b:");
	System.out.println(b.toString());



	ArrayList<Integer> c = diff(a,b);

	//	System.out.println(a.toString());
	//System.out.println(b.toString());
	System.out.println("The following is the result:");
	System.out.println(c.toString());

    }
    public static ArrayList<Integer> diff(ArrayList<Integer> a, ArrayList<Integer> b)
    {
	
        ArrayList<Integer> r=new ArrayList<Integer>();
        ArrayList<Integer> rr=new ArrayList<Integer>();
        ArrayList<Integer> rrr=new ArrayList<Integer>();



        

	//a=[2,4,9,6]
	//b=[13,11,11,13,2,4,9,6]
	//add all elements of array a that are not in array b to the new array r
        for(int i=0; i < a.size(); i++)
        {int TR=1;
            int t=a.get(i);
            for (int p=0; p<b.size();p++){
                
                if (t==b.get(p)) TR=0;}
            if (TR==1)
                r.add(t);
            
        }
	System.out.println("Here is the new array r (for now it has every element that is not in array b, but in array a):");
        System.out.println(r.toString());
        for(int i=0; i < b.size(); i++)
        {int TR=1;
            int t=b.get(i);
            for (int p=0; p<a.size();p++){
                
                if (t==a.get(p)) TR=0;}
            if (TR==1)
                r.add(t);
            
        }
	System.out.println("Here is the new array r (for now array r has all elements that are both hold for (1) in a, not in b and (2) in b, not in a):");
        System.out.println(r.toString());
        
        for(int i=0; i < r.size(); i++)
        {int TR=1;
            int t=r.get(i);
            for (int p=i+1; p<rr.size();p++){
                
                if (t==rr.get(p)) TR=0;}
            if (TR==1)
                rrr.add(t);



            
        }
	System.out.println("Here is the new array rr (it turns out this rr array is redundant. Originally, I planned to use it to take down the duplications.):");
        System.out.println(rr.toString());
	System.out.println("Here is the result array rrr:");
        System.out.println(rrr.toString());
       
	return rrr;
    }

}
