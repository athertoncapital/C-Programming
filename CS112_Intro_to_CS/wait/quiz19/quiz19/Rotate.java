import java.util.ArrayList;

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
	b.add(2);
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
        
        int TR=1;
    if (a.size()<b.size())
    {
       
        for(int i=0; i < a.size(); i++)
        {
            int t=a.get(i);
            for (int p=0; p<b.size();p++)
                
                if (t==b.get(p)) TR=0;
            if (TR==1)
                r.add(t);
            
        }
    }
    else
    {
        
        for(int i=0; i < b.size(); i++)
        {
            int t=b.get(i);
            for (int p=0; p<a.size();p++)
                
                if (t==a.get(p)) TR=0;
            if (TR==1)
                r.add(t);
            
        }
    }
        ArrayList<Integer> result=new ArrayList<Integer>();
        
        if (a.size()<b.size()){
            for(int i=0; i < r.size(); i++)
            {
                result.add(r.get(i));
                result.add(b.get(i));
            }
        for(int j=a.size(); j< b.size(); j++)
            result.add(b.get(j));}
        else{
            for(int i=0; i < r.size(); i++)
            {
                result.add(r.get(i));
                result.add(a.get(i));
            }
        for(int j=r.size(); j< a.size(); j++)
            result.add(a.get(j));
    

        }


	
	    
	return result;
    }

}
