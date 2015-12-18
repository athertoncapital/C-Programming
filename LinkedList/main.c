#include "header.h"
#include <stdlib.h>
#include <string.h>
#include <stdio.h>
void free_mem(struct entry* a)
{
  if(a == NULL)
    return;
  else
    {
      free_mem(a->next);
      free(a->next);
    }
  return;
}
/* A utility function to create a new node */
int main(){
    
    //Head=NULL;
    read();
    disp(Head);
    free_mem(Head);
    
  return 0;
}
