#include<stdio.h>
#include<string.h>
#include <stdlib.h>
#include <ctype.h>

int main(int argc, char* argv[])
{
    
    int i;
    int printa=0;
    int prints=0;
    int printm=0;
    
    if (argc == 1) return 0;
    else if (argv[2] == '\0') {printf("There is no number in your input.\n"); return 0;}

    
    //flag can be in any position
    //lets sort out the flag
    for(i=0; i < argc; i++)
    {
        if (strcmp(argv[i], "-a") == 0)
            printa = 1;
        if (strcmp(argv[i], "-s") == 0)
            prints = 1;
        
        
        if (strcmp(argv[i], "-m") == 0)
            printm = 1;
        
        if (strcmp(argv[i], "-as") == 0 || strcmp(argv[i],"-sa")== 0)
        {
            printa = 1;
            prints = 1;
        }
        
        if (strcmp(argv[i], "-am") == 0 || strcmp(argv[i],"-ma")== 0)
        {
            printa = 1;
            printm = 1;
        }
        if (strcmp(argv[i], "-sm") == 0 || strcmp(argv[i],"-ms")== 0)
        {
            printm = 1;
            prints = 1;
        }
        if (strcmp(argv[i], "-asm") == 0 || strcmp(argv[i],"-sam")== 0|| strcmp(argv[i],"-sma")== 0|| strcmp(argv[i],"-ams")== 0|| strcmp(argv[i],"-msa")== 0|| strcmp(argv[i],"-mas")== 0)
        {
            printa = 1;
            prints = 1;
            printm = 1;
        }
    }
    //printf("%d\n", prints);
    /*
    int j;
    j=atoi(argv[2]);
    printf("%s\n",argv[0] );//./command
    printf("%s\n",argv[1] );//-mn
    printf("%s\n",argv[2] );//1
    printf("%s\n",argv[3] );//2
    printf("%d\n",j );//1
    if (atoi(argv[2])>=0)
        printf("%s\n",argv[2] );//1
    */
    if (printa)
    {
        int sum=0;
        for(i=1; i < argc; i++)
        {
            
            if (atoi(argv[i])>=0 && atoi(argv[i])<=9)
                sum+=atoi(argv[i]);
            
        }
        printf("%d\n", sum);
    }
   
    if (prints)
    {
        int i;
        
        int s=atoi(argv[2]);
        
        for(i=3; i < argc; i++)
        {
            
            
            if (atoi(argv[i])>=0 && atoi(argv[i])<=9)
                s-=atoi(argv[i]);
            
        }
        printf("%d\n", s);
    }
    
    if (printm)
    {
        if (argv[2]!='\0')
        {
            int m=1;
            for(i=2; i < argc; i++)
            {
                
                if (atoi(argv[i])>=0 && atoi(argv[i])<=9)
                    m*=atoi(argv[i]);
                
            }
            printf("%d\n", m);
        }
        else
            printf("%d\n", 0);
    }
    
    printf("\n");
    
    return 0;
}
