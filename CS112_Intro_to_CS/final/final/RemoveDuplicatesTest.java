import java.util.ArrayList;

public class RemoveDuplicatesTest {
    public static void main(String[] args)
    {
	ArrayList<Integer> a = new ArrayList<Integer>();
	a.add(1);
	a.add(9);
	a.add(9);
	a.add(6);
	a.add(1);
	a.add(9);
	System.out.println("Original list a :"+a);
	removeDuplicates(a);
	System.out.println("Remove Duplicate a :"+ a);

	ArrayList<Integer> b = new ArrayList<Integer>();
	System.out.println("Original list b :"+b);
       	removeDuplicates(b);
	System.out.println("Remove Duplicate b :"+b);

    }
    public static void removeDuplicates(ArrayList<Integer> data)
    {
	//your code here
	//find the max and min in the data
	if(data.size()==0)return;
	else
	    {
		int min=data.get(1);
		for (int j=0;j<data.size();j++)
		    {
			if(data.get(j)<min)min=data.get(j);
		    }
		int max=data.get(1);
		for (int j=0;j<data.size();j++)
		    {
			if(data.get(j)>max)max=data.get(j);
		    }
		int[] f = new int[(max-min+1)];
		ArrayList<Integer> r = new ArrayList<Integer>();
		//	System.out.printf("%d\n",data.size());
	
		for (int i=0;i<data.size();i++)
		    {
			int k=(data.get(i))-min;
			f[k]++;
		    }
		for (int s=0;s<(max-min+1);s++)
		    {
			if(f[s]!=0)
			    {
				r.add(s+min);
			    }

		    }
		data.clear();
		for(int t=0;t<r.size();t++)
		    {
			data.add(r.get(t));
		    }
		r.clear();
	    }
    }
}