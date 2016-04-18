public class BinarySearch{
    public int binarySearch(int[] a, int x) { 
	return binarySearch(a, x, 0, a.length - 1);}
    private int binarySearch(int[ ] a, int x, int low, int high) {
	if (low > high) return -1; 
	int mid = (low + high)/2;
	if (a[mid] == x) return mid;
	else if (a[mid] < x)
	    return binarySearch(a, x, mid+1, high);
	else
	    return binarySearch(a, x, low, mid-1);}
    public static void main(String[] args) {
      BinarySearch bin = new BinarySearch();
      int[] a = { 2, 8,12,14,16,19,24,28,31,33};
      //      for (int i = 0; i < a.length; i++)
      //  System.out.print(bin.binarySearch(a, a[i]) + " ");
      System.out.print(bin.binarySearch(a,1) +" ");}}