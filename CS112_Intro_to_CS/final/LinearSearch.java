public class LinearSearch{
    public int linearSearch(int[] a, int x) {return linear(a, x, 0);}
    public static int linear(int list[], int key, int k){
	if(k==list.length)return -1;
	else{if(list[k]==key)return k;
	    else return linear(list, key, k+1);}}
    public static void main(String[] args) {
      BinarySearch bin = new BinarySearch();
      int[] a = { 2, 8,12,14,16,19,24,28,31,33};
      //      for (int i = 0; i < a.length; i++)
      //  System.out.print(bin.binarySearch(a, a[i]) + " ");
      System.out.print(bin.binarySearch(a,1) +" ");System.out.println();}}