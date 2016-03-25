#include <stdio.h>
#include <string.h>
int count(char s[], char c)

{
    
    if (strlen(s)==0){ return 0;}
    else if (s[0]==c){return 1+count((s+1),c);}
        
    else {
        return count((s+1),c);}
    
    
}
