
public class Rectangle
{
    
    private Point topleft;
    private Point bottomrt;
    private static int count=0;
    
    public Rectangle(Point topleft, Point bottomrt)
    {
        this.topleft = topleft;
        this.bottomrt = bottomrt;
        
        count++;
    }
    public static int getCount()
    {
        return count;
    }
    
    public String toString()
    {
        return String.format("topleft: %s, bottomrt: %s",topleft, bottomrt);
        
    }
    
    
}


