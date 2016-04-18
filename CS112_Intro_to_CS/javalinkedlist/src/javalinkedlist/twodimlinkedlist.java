package javalinkedlist;
import java.util.*;
public class twodimlinkedlist {
	int numChannels;
    float sampleRate;
    int channel;
    int Length;
    Node newhead = new Node(0,null,null);
    Node newhead2 = new Node(0,null,null);
	Node temphead = new Node(0,null,null);
	Node Head = new Node(0,null,null);
	Node Taily = Head;
	Node Tailx = Head;
	Node ttailx = newhead2;
	Node tempy = Head;
	Node tempx = Head;
	Node tempxx = temphead;
	Node connector1 = Head;
	Node connector2 = Head;
	Node counter = Head;
	Node connector =newhead2;
	Node p = newhead;
	
	
	/*pointers for reverse*/
	//pointers of old list	
	Node X = Head;
	Node Y = X;
	Node X1 = Head;
	Node Y1 = X1; 
	Node Y2 = Y1;
	//pointers of temp list
	Node tempX = new Node(0,null,null);
	Node tempY = tempX;
	//pointers of new reverse list
	Node reversehd = new Node(0,null,null);
	Node rex = reversehd;
	Node rey = rex;
	
	
	
	//Node nnx =newhead;
	//Node x=Head;
	//Node y=x;
	//Node nx=temphead;
	//Node ny=nx;
	//Node nny=nnx;
//	Node z =newhead;
	int newLength=0;

	public twodimlinkedlist(float sampleRate, int numChannels) {
		if(sampleRate<0||numChannels<0) {
	        throw new NoSuchElementException();
	      }
    	//Head = new Node(0, null,null);
		
		//z=newhead;
    	//nnx=newhead;
    	p = newhead;
    	Taily = Head;
    	for(int k=1; k<numChannels; k++)
    	{
    		Taily.nextChannel = new Node(0,null,null);
    		Taily=Taily.nextChannel;
    	}
    	
    	/*pointers for reverse*/
    	//pointers of old list	
    	Y = X;
    	Y1 = X1;
    	Y2 = Y1;
    	//pointers of temp list
    	Node tempX = new Node(0,null,null);
    	Node tempY = tempX;
    	//pointers of new reverse list
    	Node reversehd = new Node(0,null,null);
    	Node rex = reversehd;
    	Node rey = rex;
    	
    	
    	
    	Taily = Head;
    	Tailx = Head;
    	ttailx = newhead2;
    	tempy = Head;
    	connector1 = Head;
    	connector = newhead2;
    	//connector2 = tempx;
    	counter = Head;
        this.sampleRate = sampleRate;
        this.numChannels = numChannels;
        Length = 0;
	}
	private void addSample(float[] sample) {
		int count = 0;
		counter=Head;//necessary
		while(counter!=null)
		{
			counter=counter.nextSample;
			++count;
			//System.out.printf("count=%d%n",count);
		}
		Taily=Head;
		if(Length==0)
		{
			for(int i=0;i<numChannels;i++)
			{
				Taily.value=sample[i];
				Taily=Taily.nextChannel;
			}
			Taily=Head;
		}
		else
		{
			tempx= new Node(0, null,null);
			//Tailx=Head;	it doesn't work					
			connector2=tempx;
			for(int i=0;i<numChannels;i++)
			{
				connector2.value=sample[i];
				connector2.nextChannel= new Node(0,null,null);
				connector2=connector2.nextChannel;
			}
			//System.out.printf("sc=%f%n",sample[numChannels-1]);
			connector2.value=sample[numChannels-1];

			connector2=tempx;
			connector1=Tailx;
			for(int i=0;i<numChannels;i++)
			{
				connector1.nextSample=connector2;				
				connector2=connector2.nextChannel;
				connector1=connector1.nextChannel;
			}
			
			//free redundant nodes
			/*
			Taily=Head.nextSample;
			for(int i=0;i<numChannels-2;i++)
			{
				Taily=Taily.nextChannel;
			}
			
			
			for(int i=0;i<Length-1;i++)
			{
				//null;
				Taily=Taily.nextSample;
			}
			System.out.printf("Taily=%f%n",Taily.value);
			Taily.nextChannel=new Node(sample[numChannels-1],null,null);
					*/
			//connector1.nextSample=connector2;
			//System.out.printf("connector1=%f%n",connector1.value);
			//System.out.printf("connector2=%f%n",connector2.value);
			
			Tailx=Tailx.nextSample;
			//System.out.printf("Tailx=%f%n",Tailx.value);

		}


		/*it doesn't work
		Tailx=Head;
		connector1=Head;
		connector2=Head.nextSample;
		for(int cx = 0; cx<count-1;cx++)
		{	
			connector1=Tailx;
			connector2=Tailx.nextSample;
			for(int cy=0;cy<numChannels;cy++)
			{
			connector1.nextSample=connector2;
			connector1=connector1.nextChannel;
			connector2=connector2.nextChannel;
			}
			Tailx=Tailx.nextSample;
		}
		*/
		Length++;
	}
	//Node nnx=newhead;
	public void reverse(){
		//make a new list at newhd (in y direction)		
    	for(int s=0;s<Length-1;s++)
    	{
    		X=X.nextSample;
    	}
    	Y=X;

    	/*pointers for reverse*/
    	//pointers of old list	
    	/*Node X = Head;
    	Node Y = X;
    	//pointers of temp list
    	Node tempX = new Node(0,null,null);
    	Node tempY = tempX;
    	//pointers of new reverse list
    	Node reversehd = new Node(0,null,null);
    	Node rex = reversehd;
    	Node rey = rex;*/	
    	rex=reversehd;
    	rey=rex;
    	for(int c=0;c<numChannels;c++)
		{
    		rey.value=Y.value;
    		Y=Y.nextChannel;
    		rey.nextChannel=new Node(0,null,null);
    		rey=rey.nextChannel;
		}
    	rey=rex;
    	int remain = 1;
    	int count = 0;
		
		//
		for(int i=0;i<Length;i++){
			X1=Head;//necessary
			for(int j=0;j<Length-remain-1;j++)
			{
				X1=X1.nextSample;
				++count;
				//	System.out.printf("count=%d%n",count);
			}
			remain +=1; 
			Y1 = X1;
			tempY = tempX;
	    	for(int c=0;c<numChannels;c++)
			{
	    		tempY.value = Y1.value;
	    		tempY.nextChannel = new Node(0,null,null);
	    		tempY = tempY.nextChannel;
	    		Y1 = Y1.nextChannel;
			}
	    	tempY = tempX;
	    	Y1 = X1;
	    	for(int c=0;c<numChannels;c++)
			{
	    		System.out.printf("tempX%f%n",tempY.value);
	    		tempY=tempY.nextChannel;
			}
	    	tempY = tempX;
	    	Y1 = X1;
	    	System.out.printf("Y1=%f%n",Y1.value);
	    	rey = rex;
	    	
	    	for(int c=0;c<numChannels;c++)
			{
	    		rey.nextSample = Y1;
	    		System.out.printf("reversehd.nextSample.value=%f%n",reversehd.nextSample.value);
	    		rey = rey.nextChannel;
	    		Y1 = Y1.nextChannel;
			}
	    	rey = rex;
	    	rex = rex.nextSample;
			//
			//System.out.printf("rey.value=%f%n",rey.value);
			Y1 = X1;
		}
    	Head=reversehd;
    	reversehd = new Node(0,null,null);
    	tempX = new Node(0,null,null);
    	X1=Head;
    	tempY = tempX;
    	Y1 = X1;
    	rey = rex;
    	rex = tempX;
    	X = Head;
    }
	
	public static void main(String[] args)
	{
		twodimlinkedlist m = new twodimlinkedlist(4,4);
    	float[] Array1 = {1,2,3,3};
    	float[] Array2 = {5,6,7,8};
    	float[] Array3 = {11,16,17,18};
    	float[] Array4 = {12,13,14,15};
    	m.addSample(Array1);
    	m.addSample(Array2);
    	m.addSample(Array3);
    	m.addSample(Array4);
    	m.reverse();
    	m.reverse();
    	//twodimlinkedlist rev = (twodimlinkedlist) m.clone();
    	
    	Iterator<float[]> it = m.iterator();
    	Iterator<float[]> it2 = m.iterator();
    	System.out.printf("%nHOHOHO%f%n",it.next()[1]);
    	System.out.printf("%nHOHOHO%f%n",it2.next()[1]);
    	System.out.printf("%nHOHOHO%f%n",it.next()[3]);
    	//for(int c=0;c<m.numChannels;c++)
		//{
    		//System.out.printf("reversehd%f%n",m.rey.value);
    		//m.rey=m.rey.nextChannel;
		//}
/*
    	System.out.printf("m.reversehd.value=%f%n",m.reversehd.value);
    	System.out.printf("m.reversehd.nextSample.value=%f%n",m.reversehd.nextSample.value);
    	System.out.printf("m.reversehd.nextSample.nextSample.value=%f%n",m.reversehd.nextSample.nextSample.value);
    	System.out.printf("m.reversehd.nextSample.nextSample.nextSample.value=%f%n",m.reversehd.nextSample.nextSample.nextSample.value);
    	//System.out.printf("m.reversehd.nextSample.nextSample.nextSample.nextSample.value=%f%n",m.reversehd.nextSample.nextSample.nextSample.nextSample.value);
    	System.out.printf("m.reversehd.nextSample.nextChannel.value=%f%n",m.reversehd.nextSample.nextChannel.value);
    	System.out.printf("m.reversehd.nextChannel.nextSample.value=%f%n",m.reversehd.nextChannel.nextSample.value);
    	System.out.printf("m.reversehd.nextSample.nextSample.value=%f%n",m.reversehd.nextSample.nextSample.value);
    	*/
    	//System.out.printf("m.Head.nextChannel.value=%f%n",m.Head.nextChannel.nextSample.value);
    	//System.out.printf("m.Head.nextSample.value=%f%n",m.newhead.nextSample.value);
    	//System.out.printf("m.Head.nextSample.nextSample.value=%f%n",m.Head.nextSample.nextSample.value);
    	//System.out.printf("m.Head.nextSample.nextSample.nextSample.value=%f%n",m.Head.nextSample.nextSample.nextSample.value);
    	//System.out.printf("m.Head.value=%f%n",m.Head.value);
    	//System.out.printf("m.Head.nextSample.value=%f%n",m.Head.nextSample.value);
    	//System.out.printf("m.Head.nextSample.nextSample.value=%f%n",m.Head.nextSample.nextSample.value);
    	//System.out.printf("m.Head.nextSample.nextSample.nextSample.value=%f%n",m.Head.nextSample.nextSample.nextSample.value);
    	
    	//System.out.println("\n==> Iterator Example...");
    	/*Iterator<float[]> it1= m.iterator();
    	float[] q = new float[m.numChannels]; 
    	int k=0;
		while (it1.hasNext()) {
			q=it1.next();
			for(int i=0;i<m.numChannels;i++)
			{
				System.out.printf("%f%n",q[i]);
			}
			k++;
		}
		System.out.printf("k=%d%n",k);
	*/
    	
    	
    	
    	
    	
    	
    	
    	
	}

	private Iterator<float[]> iterator() {
		// TODO Auto-generated method stub
		return new InnerIteratorfloatarry(); 
	}

	class InnerIteratorfloatarry  implements Iterator<float []>
    {
    	// current position in list
    	Node current;
    	private int index;
    	public InnerIteratorfloatarry() {
    		current = Head;
    		System.out.printf("Head.value=%f",Head.value);
    		index=0;    		
    		}
    	public boolean hasNext() {
    		System.out.printf("index=%d",index);
    		System.out.printf("Length=%d",Length);
            return index < Length;
        }
    	

		@Override
		public float[] next() {
			Node y = current;
			// TODO Auto-generated method stub
			index++;			
			float[] array = new float[numChannels];
			for(int i=0;i<numChannels;i++)
			{
				array[i]=y.value;
				y=y.nextChannel;						
			}
			current= current.nextSample;
			return array;
		}
    	
    	
    }
	static class Node
    {
        public Node(float val, Node nc, Node ns)
        {
            this.value = val;
            this.nextChannel=nc;
            this.nextSample=ns;
        }
    	public Node nextChannel=null;
    	public Node nextSample=null;
        public float value;
    }
}
