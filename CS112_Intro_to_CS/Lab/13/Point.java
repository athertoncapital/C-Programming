public class Point {
    private int x;
    private int y;

    public Point(int X, int Y)
    {
	this.x = X;
	this.y = Y;
    }
    public Point()
    {
        this.x = 0;
        this.y = 0;
    }
    public String toString()
    {
	return String.format("x: %d, y: %d\n", x, y);
    }

}