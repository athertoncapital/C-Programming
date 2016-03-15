#include <stdio.h>


void ascending(int n)
{
    if(n > 0)
    {
        ascending(n - 1);
        printf("%d", n);
    }
    
}