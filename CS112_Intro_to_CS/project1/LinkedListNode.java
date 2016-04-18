
public class LinkedListNode
{   
    public Object data;
    public LinkedListNode next;

    public LinkedListNode(Object d)
    {
        data = d;
    }

    public LinkedListNode(Object d, LinkedListNode n)
    {
        data = d;
        next = n;
    }

}