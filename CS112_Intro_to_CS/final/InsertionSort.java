import java.util.Arrays;
public class InsertionSort{
public static void insertionSort(int a[], int s, int n) {
    if(s>= n-1)	return;
    int i = s + 1; int j = i; int B = a[i];
    j=h(a, j, B); a[j] = B;
    insertionSort(a, s + 1, n);}
private static int h(int[] a, int j, int B) {
    if(j <= 0 || a[j-1] <= B) return j;
    a[j] = a[j - 1];
    return h(a, j-1, B);}
    public static void main(String[] args) {
      InsertionSort bin = new InsertionSort();
      int[] a = { 4,2,12,14,16,19,24,28,31,33};
      bin.insertionSort(a,0,a.length);
            for (int i = 0; i < a.length; i++)
		System.out.print(a[i] + " ");}}
