#include <stdlib.h>
#include <string.h>
#include <stdio.h>
struct entry {
    char *quote;
    int count;
    struct entry* next;
};
/*
void disp(struct entry* a)
{
while(a != NULL)
  {
        
    printf("%s\n", a->quote);
    a=a->next;
  }
}
*/