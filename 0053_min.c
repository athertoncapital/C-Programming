int min(int a[], int start, int end) {
    static int smallest=2^15-1;
    if (a[start]<smallest && start<end)
        {
            smallest=a[start];
            min(a, start+1, end);
        }
        if (a[start]>smallest && start<end )
        {
            min(a, start+1, end);
        }	
        return smallest;
    }