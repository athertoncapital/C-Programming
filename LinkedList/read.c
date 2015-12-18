#include <stdlib.h>
#include <string.h>
#include <stdio.h>
#include "header.h"


void disp(struct entry* a)
{
    while(a != NULL)
    {
        
        printf("%s\n", a->quote);
        a=a->next;
    }
}

struct entry* process(char* pStr);



int checkq(char *name)
{
    int j=0;
    int q=0;
    int blank=0;
    for(int k=0; k<strlen(name);k++)
    {
        
        if (name[k]==' ') {blank++;}
        else if (name[k]=='Q') {q++;}
    }
    if (strlen(name)==1&&name[0]=='Q') j=1;
    else if(q==1 && blank==(strlen(name)-1))
    {
        j=1;
    }
    else j=0;
    return j;
}
int checknonempty(char *name)
{
    int i,j=0;
    for (i=0; i<(strlen(name)); i++)
    {
        if (name[i]!=' ')
            j=1;
    }
    return j;
}
int word_count(char *name)
{
    int i,j=0;
    for (i=0; i<(strlen(name)); i++)
    {
        if (name[i]!=' ') j++;
    }
    return j;
}



void read(void)
{

    int entries=0;
    int test=0;
    char *q;
    do{
        unsigned int len_max = 10;
        unsigned int current_size = 0;
        current_size = len_max;
        char *pStr = malloc(len_max);
        printf("Enter a quote or Q to quit:");
        if(pStr != NULL)
        {
            int c = EOF;
            unsigned int i =0;
            //accept user input until hit enter or eof
            while (( c = getchar() ) != '\n' && c != EOF){
                pStr[i++]=(char)c;
                //if i reached maximize size then realloc size
                if(i == current_size)
                {
                    current_size = i+len_max;
                    pStr = realloc(pStr, current_size);
                }
            }
            pStr[i] = '\0';
            if (strlen(pStr)>100||strlen(pStr)==0||checknonempty(pStr)==0||checkq(pStr)==1)//e.g.123'\0'
            {
                test=checkq(pStr);
                free(pStr);
                pStr = NULL;
                c='\0';
            }
            else
            {
                entries++;
                process(&pStr);
                
            }
            c='\0';
        }
        q=pStr;
    }while(entries<4&&test==0);
    //process(Head);
    
    
    
    struct entry* temp;
    struct entry* b = Head;
    struct entry* recent;
    while(b->next!=NULL&& b != NULL)
    {
        
        
        // printf("%d\n",b->count);
        int s,t;
        s=(int)b->count;
        t=(int)((b->next)->count);
        if(s==t)
        {
            //printf("*\n");
            recent=b->next;
            temp = (recent->next);
            b->next = temp;
            free(recent);
            b=Head;
            
        }
        
        
        b=b->next;
    }

    disp(Head);
    free(q);
}
