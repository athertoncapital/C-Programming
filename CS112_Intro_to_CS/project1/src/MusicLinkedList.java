import java.util.*;
public class MusicLinkedList implements MusicList{
    private int Length=0;
    int newLength=0;
    int numChannels;
    float sampleRate;
    int channel;
    
    Node Head = new Node(0,null,null);
    Node newhead = new Node(0,null,null);
    Node changespeedhead = new Node(0,null,null);
    Node temphead = new Node(0,null,null);
    //Node node=Head;
    Node Taily = Head;
    Node Tailx = Head;
    Node tempy = Head;
    Node tempx = Head;
    Node connector1 = Head;
    Node connector2 = Head;
    Node counter = Head;
    Node current;
    Node call=Head;
    Node X = Head;
    Node Y = X;
    Node X1 = Head;
    Node Y1 = X1; 
    Node Y2 = Y1;
    Node tempX = new Node(0,null,null);
    Node tempY = tempX;
    Node reversehd = new Node(0,null,null);
    Node rex = reversehd;
    Node rey = rex;
    /**
     * Clip
     * @author William_Chuang
     *
     */
    Node cliphd = new Node(0,null,null);
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

    public MusicLinkedList(float sampleRate, int numChannels)
    {
	if(sampleRate<0||numChannels<0) {
	    throw new NoSuchElementException();
	}
	//Head = new Node(0, null,null);
	
	Taily = Head;
	for(int k=1; k<numChannels; k++)
	    {
		Taily.nextChannel = new Node(0,null,null);
		Taily=Taily.nextChannel;
	    }
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
	rewritehd=newhead;
	Taily = Head;
	Tailx = Head;
	tempy = Head;
	connector1 = Head;
	counter = Head;
        this.sampleRate = sampleRate;
        this.numChannels = numChannels;
        Length = 0;
        Tail = Head;
	
    }
    public void clip(float startTime, float duration){
	int index_i = (int) (startTime*sampleRate);
	int index_f = (int) ((startTime*sampleRate)+(duration*sampleRate));
	if(index_f>Length)
	    {
		index_f = Length;
	    }
	int newLength=index_f-index_i;
	//System.out.printf("newLength=%d%n",newLength);
	Iterator<float[]> it = this.iterator();
	for(int y=0; y<index_i ; y++)
	    {
		it.next();
	    }
	MusicLinkedList clone = new MusicLinkedList(sampleRate, numChannels );
	for(int h=0; h<newLength ; h++)
	    {
		if(it.hasNext())
		    clone.addSample(it.next());
	    }
	Length=newLength;
	Head = clone.Head;
	
    }
    public int getLength(){
	return Length;
    }
    public void combine(MusicList clipToCombine, boolean allowClipping){
	MusicLinkedList mlist = (MusicLinkedList) clipToCombine;
	Node m1p1c = Head;
	Node m1p1s = Head;
	Node m2p1c = mlist.Head;
	Node m2p1s = mlist.Head;
	m1p1c = m1p1s;
	m2p1c = m2p1s;
	for(int i=0; i<Length;i++)
	    {
		m1p1c = m1p1s;
		m2p1c = m2p1s;
		for(int j=0; j<numChannels;j++)
		    {
			m1p1c.value+=m2p1c.value;
			if(m1p1c.nextChannel!=null)
			    m1p1c=m1p1c.nextChannel;
			if(m2p1c.nextChannel!=null)
			    m2p1c=m2p1c.nextChannel;
		    }
		if(m1p1s.nextSample!=null)
		    m1p1s = m1p1s.nextSample;
		if(m2p1s.nextSample!=null)
		    m2p1s = m2p1s.nextSample;
	    }
	if(!allowClipping){
	    Node y = Head;
	    Node x = y;
	    float norm = x.value;
	    
	    for(int channel=0;channel<numChannels;channel++){
		x=y;
		for(int k = 0;k<Length;k++){
		    if(x.value>norm)
			norm = x.value;
		    if(x.nextSample!=null)
			x=x.nextSample;
		}
		if(y.nextChannel!=null)
		    y=y.nextChannel;
	    }
	    y=Head;
	    for(int channel=0;channel<numChannels;channel++){
		x=y;
		for(int k = 0;k<Length;k++){
		    
		    x.value/=norm;
		    
		    y=Head;
		    if(x.nextSample!=null)
			x=x.nextSample;
		}
		if(y.nextChannel!=null)
		    y=y.nextChannel;
	    }
	    
	}
	if(allowClipping)
	    {
		Node y = Head;
		Node x = y;
		y=Head;
		for(int channel=0;channel<numChannels;channel++){
		    x=y;
		    for(int k = 0;k<Length;k++){
			if(x.value>1)
			    x.value=1;
			if(x.value<-1)
			    x.value=-1;
			if(x.nextSample!=null)
			    x=x.nextSample;
		    }
		    if(y.nextChannel!=null)
			y=y.nextChannel;
		}
	    }
    }
    Node rewritehd = newhead;
    public void makeMono(boolean allowClipping){
	rewritehd = newhead;
	Node mMx = Head;
	Node mMy = mMx;
	for(int s = 0; s<Length; s++)
	    {
		mMy = mMx;
		for(int c = 0; c<numChannels;c++)
		    {
			rewritehd.value += mMy.value;
			mMy = mMy.nextChannel;
		    }
		mMx = mMx.nextSample;
		rewritehd.nextSample = new Node(0,null,null);
		rewritehd = rewritehd.nextSample; 
		
	    }
	rewritehd = newhead;
	if(allowClipping)
	    for(int s = 0; s<Length;s++)
		{
		    if(rewritehd.value>1)rewritehd.value=1;
		    else if(rewritehd.value<-1)rewritehd.value=-1;
		    rewritehd = rewritehd.nextSample;
		}
	else
	    {
		float norm = rewritehd.value;
		for(int s = 0; s<Length;s++)
		    {
			if(rewritehd.value>norm)norm=rewritehd.value;
			rewritehd = rewritehd.nextSample;
		    }
		rewritehd = newhead;
		for(int s = 0; s<Length;s++)
		    {
			rewritehd.value/=norm;
			rewritehd = rewritehd.nextSample;
		    }
	    }
	numChannels=1;
	Head = newhead;
	
    }
    public float getDuration()
    {
        float duration;
        duration=((float)Length)/sampleRate;//@return  the duration of the sound, in seconds.
        return duration;
    }
    public MusicList clone(){
	float buff1[] = new float[numChannels];
	MusicLinkedList clone = new MusicLinkedList(sampleRate, numChannels );
	Iterator<float[]> it = this.iterator();
	while(it.hasNext()){
	    buff1 = it.next();
	    clone.addSample(buff1);
	}
	return clone;
    }
    public void spliceIn(float startSpliceTime, MusicList clipToSplice){
	MusicLinkedList ml = (MusicLinkedList) clipToSplice;    
	//System.out.printf("%d%n",ml.Length);
	//System.out.printf("ml.Head.nextSample.nextSample.value=%f%n",ml.Head.nextSample.nextSample.value);
	if(ml.sampleRate!=sampleRate)
	    {
		ml.changeSampleRate(sampleRate);
	    }
	int index_i = (int) (startSpliceTime*sampleRate);
	
	Node tx=Head;
	Node ty=tx;
	
	Node sx=ml.Head;
	Node sy=sx;
	
	Node ux=Head;
	Node uy=ux;
	for(int y=0; y<index_i-1 ; y++)
	    {
		//if(tempx.nextSample.nextSample!=null)
		//System.out.printf("%f%n",tx.nextSample.value);
		tx=tx.nextSample;
	    }
	ty=tx;
	ux=tx.nextSample;
	uy=ux;
	for(int y=0;y<numChannels;y++)
	    {
		ty.nextSample = sy;
		ty=ty.nextChannel;
		sy=sy.nextChannel;
		
	    }
	int l =ml.Length;
	for(int y=0;y<l-1;y++)
	    {
		sx = sx.nextSample;
	    }
	sy = sx;
	for(int y=0;y<numChannels;y++)
	    {
		sy.nextSample = uy;
		if(y==numChannels-1)
		    break;
		sy=sy.nextChannel;
		uy=uy.nextChannel;
	    }
	
	int newLength=Length+l;
	Length=newLength;
    }
    Node Tail = Head;
    
    public void addSample(float sample[])
    {
	if(sample.length>1){
	    int size = sample.length;
	    Taily=Head;
	    if(Length==0)
		{
		    for(int i=0;i<size;i++)
			{
			    Taily.value=sample[i];
			    Taily=Taily.nextChannel;
			}
		    Taily=Head;
		}
	    else
		{
		    tempx= new Node(0, null,null);
		    connector2=tempx;
		    for(int i=0;i<size;i++)
			{
			    connector2.value=sample[i];
			    connector2.nextChannel= new Node(0,null,null);
			    connector2=connector2.nextChannel;
			}
		    connector2.value=sample[size-1];
		    connector2=tempx;
		    //for(int y=0;y<Length-1;y++)
		    //Tailx=Tailx.nextSample;
		    connector1=Tailx;
		    for(int i=0;i<numChannels;i++)
			{
			    connector1.nextSample=connector2;
			    connector2=connector2.nextChannel;
			    connector1=connector1.nextChannel;
			}
		    Tailx=Tailx.nextSample;
		}

	    Length++;
	}

	else
	    {
		int size = sample.length;
		Taily=Head;
		if(Length==0)
		    {
			for(int i=0;i<size;i++)
			    {
				Taily.value=sample[i];
				Taily=Taily.nextChannel;
			    }
			Taily=Head;
		    }
		else
		    {
			tempx= new Node(0, null,null);
			connector2=tempx;
			for(int i=0;i<size;i++)
			    {
				connector2.value=sample[i];
				connector2.nextChannel= new Node(0,null,null);
				connector2=connector2.nextChannel;
			    }

			connector2.value=sample[size-1];
			connector2=tempx;
			//for(int y=0;y<Length-1;y++)
			//Tailx=Tailx.nextSample;
			connector1=Tailx;
			for(int i=0;i<numChannels;i++)
			    {
				connector1.nextSample=connector2;
				connector2=connector2.nextChannel;
				connector1=connector1.nextChannel;
			    }
			Tailx=Tailx.nextSample;
		    }

		Length++;
	    }
    } 

    
    public void addSample(float sample){
	rex=Head;
	rey=rex;
	for(int y=0;y<Length;y++)
	    rey=rey.nextSample;
	rey.value=sample;
	rey = rey.nextSample;
    }
    public float getSampleRate(){

        return sampleRate;
    }
    public void changeSampleRate(float newRate){
	if(newRate!=sampleRate){
	    float totaltime = Length/sampleRate;
	    int nLength = (int) (totaltime*newRate);
	    float t_original = 0;
	    float t_new = 0;
	    int T1;
	    int T2;
	    float a =1;
	    float old_unit = a/sampleRate;
	    float new_unit = a/newRate;
	    float buffer1[] = new float[numChannels];
	    float prebuffer1[] = new float[numChannels];
	    float buffer2[] = new float[numChannels];
	    MusicLinkedList write = new MusicLinkedList(sampleRate, numChannels);
	    
	    Iterator<float[]> itr = this.iterator();  
	    buffer1 = itr.next();
	    rex=write.Head;
	    rey=rex;
	    for(int i =0;i<numChannels;i++ )
		{
		    rey.value=buffer1[i];
		    rey=rey.nextChannel;
		}
	    rey=rex;
	    write.addSample(buffer1);
	    float search=0;
	    float csearch=0;
	    if(sampleRate%newRate==0){
		int m=(int)(sampleRate/newRate);
		for (int i = 0; i < Length-1; i++)
		    {
			
			//T1 = (int)(t_original*1000000);
			//T2 = (int)(t_new*1000000);
			prebuffer1=buffer1;
			if(itr.hasNext()){
			    for(int k=0;k<m;k++)
				{
				    if(itr.hasNext()){
					buffer1 = itr.next();
				    }
				}
			    write.addSample(buffer1);
			}
		    }
	    }
	    else{

		prebuffer1 = buffer1;

		for(int j=1;j<Length;j++)
		    {
			if(itr.hasNext()){
			    search = j*old_unit;
			    prebuffer1 = buffer1;
			    buffer1=itr.next();
			    
			    for(int g=1;g<j;g++)
				{
				    
				    csearch = g*new_unit;
				    if(search==csearch)
					{
					    
					    write.addSample(buffer1);
					    
					}
				    
				    else if(search>csearch&&((j-1)*old_unit)<csearch)
					{
					    for(int k=0;k<numChannels;k++)
						{
						    
						    buffer2[k]=(sampleRate)*(prebuffer1[k]*(search-csearch)
									     +buffer1[k]*(csearch-(old_unit*(j-1))));
						}

					    write.addSample(buffer2);
					    
					    break;
					}
				    else
					continue;

				    
				}
			}
			
		    }
		
	    }
	    
	    
	    
	    
	    sampleRate = newRate;
	    Head = write.Head;
	    Length = nLength;
	}
	
	count=0;
	
    }
    
    public int getNumChannels(){
	//System.out.printf("getNumChannels(): %d",numChannels);
        return numChannels; //@return The number f channels in the SoundList
    }
    public int getNumSamples(){
	//System.out.printf(" getNumSamples(): %d",Length);
        return Length; //@return The number of samples in the MusicList. (per channel?
    }
    public void addEcho(float delay, float percent){
	float a =1;
	int ntimes = (int)((Length*(a/sampleRate))/delay);
	int interval = (int)(delay*sampleRate);
	
	MusicLinkedList write = (MusicLinkedList) this.clone();
	Iterator<float[]> itr = this.iterator();
	float buffer[] = new float[numChannels];
	buffer = itr.next();
	rex=write.Head;
	rey=rex;
	for(int i =0;i<numChannels;i++ )
	    {
		rey.value=buffer[i];
		rey=rey.nextChannel;
	    }
	rey=rex;
	write.addSample(buffer);
	//System.out.printf("%f%n",delay);
	//System.out.printf("%f%n",sampleRate);
	//System.out.printf("%d%n",Length);
	//System.out.printf("%d%n",ntimes);
	//System.out.printf("%d%n",interval);
	
	for(int j=1;j<=ntimes;j++)
	    {
		Iterator<float[]> itr_delay = write.iterator();
		buffer = itr_delay.next();
		rex = write.Head;
		for(int e=0;e<j*interval;e++)
		    {
			rex = rex.nextSample;
		    }
		rey = rex;
		for(int r=0;r<Length-j*interval;r++)
		    {
			for( int c_th = 0; c_th<numChannels;c_th++)
			    {
				rey.value+=buffer[c_th]*percent;
				if(rey.value>1)
				    rey.value=1;
				else if(rey.value<-1)
				    rey.value=-1;
				rey = rey.nextChannel;
				
			    }
			rex = rex.nextSample;
			rey = rex;
			buffer = itr_delay.next();
		    }
		
	    }
	
	
	Head = write.Head;
	/*System.out.printf("%f%n",delay);
	  System.out.printf("%f%n",sampleRate);
	  System.out.printf("%d%n",Length);
	  System.out.printf("%d%n",ntimes);
	  System.out.printf("%d%n",interval);*/
	
	
	
	
    }
    public void reverse(){
	//make a new list at newhd (in y direction)
	for(int s=0;s<Length-1;s++)
	    {
		X=X.nextSample;
	    }
	Y=X;
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
		    //System.out.printf("tempX%f%n",tempY.value);
		    tempY=tempY.nextChannel;
		}
	    tempY = tempX;
	    Y1 = X1;
	    //System.out.printf("Y1=%f%n",Y1.value);
	    rey = rex;
	    
	    for(int c=0;c<numChannels;c++)
		{
		    rey.nextSample = Y1;
		    //System.out.printf("reversehd.nextSample.value=%f%n",reversehd.nextSample.value);
		    rey = rey.nextChannel;
		    Y1 = Y1.nextChannel;
		}
	    rey = rex;
	    rex = rex.nextSample;
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
	count = 0;
    }
    public void changeSpeed(float percentChange){
	if(percentChange>0)
	    sampleRate/=percentChange;
    }
    /**
     * Return an iterator that traverses the entire sample, returning an array floats (one for each channel)
     */
    public Iterator<float[]> iterator(){
	return new InnerIteratorfloatarry(); 
    }
    /**
     * Return an iterator that traverses a single channel of the list
     * @param channel The channel to traverse
     */
    public Iterator<Float> iterator(int channel){
	return new InnerIteratorfloat(channel); 
    }
    
    /*******************************************************
     *
     *  The Iterator class--float
     *
     ********************************************************/
    int c = 0;
    class InnerIteratorfloat  implements Iterator<Float>
    {
        Node node;
        public InnerIteratorfloat(int channel)
	    {
		node=Head;
		for(int i=0; i<channel;i++)
		    node=node.nextChannel;
		

		//            if(c==Length-1)
		//            c=0;
	    }
        public boolean hasNext()
        {
	    return node != null;
	    //            if(c<Length)
	    //        //if(node.nextSample!=null)
	    //            return true;
	    //            else return false;
        } 
        
        public Float next()
        {
	    float forreturn =node.value;
            node = node.nextSample;

            return forreturn;
        }
    }
    /*******************************************************
     *
     *  The Iterator class--floatarray
     *
     ********************************************************/
    int count=0;
    class InnerIteratorfloatarry  implements Iterator<float []>
    {
	private Node node=Head;
	private Node temp = Head;
	
	public InnerIteratorfloatarry()
	    {
		node = Head;
		count=0;
		temp = Head;
		//System.out.printf("numChannels: %d",numChannels);
	    }
	public boolean hasNext()
	{
	    if(count<Length) 
		{
		    return true;
		}
	    else 
		{
		    return false;
		}
	}
	
	public float[] next()
	{

	    if(!hasNext()) {
		throw new NoSuchElementException();
	    }
	    temp=node;
	    float[] array = new float[numChannels]; 
	    for(int i=0;i<numChannels;i++){
		//System.out.printf("%f%n",temp.value);
		array[i]=temp.value;
		if(numChannels>1){
		    temp=temp.nextChannel;
		}
	    }
	    node=node.nextSample;
	    count++;
	    return array;
	}
	public void setCount()
	{
	    count = 0;
	}
    }

}