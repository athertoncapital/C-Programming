public class DoubleLinkedList 
{
	
    protected ListNode head;
    protected ListNode tail;
	
	
    
    public DoubleLinkedList()
    {
        head = null;
        tail = null;
    }
    
    // Method add(Object o)
    // Adds the object at the end of the linked list
    public void add(Object o)
    {
        ListNode newElem = new ListNode(o);
        if (tail != null)
        {
        	tail.setNext(newElem);
        	newElem.setPrev(tail);
        	tail =  tail.next();
        }
        else
        {
        	head = newElem;
        	tail = newElem;
        }
    }
    // Method reverse
    // Reverses the string
    public void reverse()
    {
    	ListNode current = tail;
    	DoubleLinkedList m = new DoubleLinkedList();
    	while(current.prev()!=null)
    	{
    		m.add(current.data());
    		current = current.prev();
    	}
    	if(current.prev() == null)
		{
    		m.add(current.data());
		}
    	head = m.head;
    }
    
    // Method toString()
    // Creates a String representation of the list:
    //  Left bracket, followed by by concatenating the result of toString() 
    //  called on each element of the list (separated by commas), fooled by a 
    //  right bracket.
    //  Empty list:  toString => "[]"
    //  List containing the single Integer 3: toString => "[3]"
    //  List containing three integers 1, 2, 3:  toString => "[1,2,3]"
    public String toString()
    {
	// Fill me in!
        //return "";
    	ListNode current = head;
        String result = "";
        if(current!= null)
        	{
        	//result = head.data();
        	if(current.next() != null){
        		while (current.next() != null) {
        			
        			result = result + "" + current.data();
        			current = current.next();
        			if(current.next() != null)
        				result = result + ",";	
        		}
        		if(current.next() == null)
        		{
        			result = result + "," + current.data() + "";
        		}
        	}
        	else
        	{
        		result = result + "" + current.data() + "";
        	}
        }
        else
        	result = result+ "";

        return  "=>"+ "[" +result+ "]";
    }
    
    
    // Method removeFirst(Object o)
    //  Removes the first occurrence of the Object o from the list.  If
    //    the object appears more than once, only the first occurrence is
    //    removed.  If the object does not occur in the list, the method
    //    does nothing. removeFirst and removeLast should reuse as much
    //    code as possible!
    public void removeFirst(Object o)
    {
    	ListNode current = head;
    	ListNode temp = current;
    	if(current != null)
    	{
    		if(current.data().equals(o)){
    			head=current.next();
    		}
    		else{
    			if(current.next()!=null)
    			{
    				while(current.next()!=null)
    				{
    					if(current.data().equals(o)){
    						temp=current.next();
    						current=current.prev();
    						current.setNext(temp);
    						temp.setPrev(current);
    						current=temp;
    						break;
    					}
    					current = current.next();
    			
    				}	
    				if(current.data().equals(o)){
    					current=current.prev();
    					tail=current;
    					tail.setPrev(null);
						current.setNext(null);
						tail=current;
    				}
    			}
    			}
    		}
    }
    public void removeLast(Object o)
    {
	// FIll me in!!
       	ListNode current = head;
    	ListNode temp = current;
    	int count =0;
    	int flag = 1;
    	if(current != null)
    	{
    		while(current!=null)
    		{
    			count++;
    			if(current.next()!=null)
    			current=current.next();
    			else
    				break;
    			
    		}
    		//current=current.prev();
    		tail=current;		
    		if(count!=0)
    		{
    			if(count==1)
    			{
    				if(current.data().equals(o)){
    					head=null;
    					tail=head;
    				}
    			}
    			else if(count>1)
    			{
    				if(current.prev()!=null)
        			{
        				while(current.prev()!=null)
        				{
        					if(current.data().equals(o)){
        						temp=current.prev();
        						if(current.next()!=null)
        						{
        							current=current.next();
            						current.setPrev(temp);
            						temp.setNext(current);
            						current=temp;
            						flag=0;
            						break;
        						}
        						else
        						{
            						tail=current.prev();
            						tail.setNext(null);
            						current=null;
            						flag=0;
            						current=tail;
            						break;	
        						}
        					}
        					current = current.prev();
        				}	
        				
        				if(flag == 1){
        					if(current.data().equals(o)){
        						//System.out.printf("fffffffffff");
        						head=current.next();
        						
        					}
        				}
        			}
    			}
    		}
    		}
    }
    
    
    public static void main(String args[])
    {
    	DoubleLinkedList l = new DoubleLinkedList();
    	l.add(new Integer(99));
        for (int i = 0; i < 5; i++)
        {
            l.add(new Integer(i));
        }
    	l.add(new Integer(99));
        for (int i = 5; i < 10; i++)
        {
            l.add(new Integer(i));
        }
    	l.add(new Integer(99));
        
        System.out.println(l);
        l.reverse();
        System.out.println(l);
 
        l.removeFirst(99);
        System.out.println(l);
        l.removeLast(new Integer(99));
        System.out.println(l);
        l.removeLast(new Integer(99));
        System.out.println(l);
        l.removeLast(new Integer(9));
        System.out.println(l);

        DoubleLinkedList l2 = new DoubleLinkedList();
        System.out.println(l2);
        l2.add(new Integer(2));
        System.out.println(l2);
        l2.removeLast(new Integer(2));
        System.out.println(l2);
    }
}

