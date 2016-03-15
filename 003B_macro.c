/***************************************************/
//One thing a lot of programmers forget is
//cache effects, a modern CPU as typically
//used by the beginner C programmer, will
//pre-load as much code to execute into a
//cache as it can before it begins to actually
//execute it. In some cases, code prefetched into
//the cache is pre-cracked to make it easier for
//the actual processor to work upon. I have glossed
//over the details, because what exactly happens here
//is beyond the scope of this document. The point
//is, there is only a certain amount of memory
//available for a cache on an instruction stream.
//If you have filled up your cache with repeated
//expansions of the exact same code, you can
//actually make your code slow down, not speed up   
/***************************************************/




#include <limits.h>
#include <stdio.h>
#include <time.h>
#include <sys/time.h>
#define SWAP(t, x, y) do { t SWAP = x; x = y; y = SWAP; } while (0)
void swap(int x, int y) {  
int temp=x;  
x=y; 
y=temp;  
} 

int i,j;
int main() {  
int temp=100;  
int a=10;  
int b=20;  
swap(a,b);
printf("(a,b)=(10,20), now, test swap function: after swaped (a,b)=(%d,%d)\n", a, b);
int c=10;
int d=20;
int i=j=0;
SWAP(int, a, b);
printf("(c,d)=(10,20), now, test swap function: after swaped (c,d)=(%d,%d)\n",a ,b);

    
    struct timeval  tv1, tv2;
    gettimeofday(&tv1, NULL);

    printf ("Begins at = %f\n",
            (double) (tv1.tv_usec) / 1000000 +
            (double) (tv1.tv_sec));
    for (i=0;i<INT_MAX;i++)
    {
        swap(a,b);
    }
    gettimeofday(&tv2, NULL);
    printf ("Ends at = %f\n",
            (double) (tv2.tv_usec) / 1000000 +
            (double) (tv2.tv_sec));
    
    printf ("Total time for swap function = %f seconds\n",
            (double) (tv2.tv_usec - tv1.tv_usec) / 1000000 +
            (double) (tv2.tv_sec - tv1.tv_sec));
    printf ("Begins at = %f\n",
            (double) (tv1.tv_usec) / 1000000 +
            (double) (tv1.tv_sec));
    for (i=0;i<INT_MAX;i++)
    {
        SWAP(int, a, b);
    }
    gettimeofday(&tv2, NULL);
    printf ("Ends at = %f\n",
            (double) (tv2.tv_usec) / 1000000 +
            (double) (tv2.tv_sec));
    
    printf ("Total time for swap function = %f seconds\n",
            (double) (tv2.tv_usec - tv1.tv_usec) / 1000000 +
            (double) (tv2.tv_sec - tv1.tv_sec));
}

