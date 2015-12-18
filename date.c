#include <stdio.h>
#include <stdlib.h>
#include <string.h>


int main(int argc, char **argv) {
    
    int a,b,c;
    char  d[2],e[2];
    printf("What kind of scanning formats you'd like to use date-month-year or date/month/year:\n");
    scanf("%2d %1s %2d %1s %4d", &a,d, &b, e, &c);
    if ((strcmp(d,e)==0&&strcmp(d,"-")==0)||(strcmp(d,e)==0&&strcmp(d,"/")==0)){
        if (a>0&&a<13&&b>0&&b<32){
            char str[80];
            char a2[10];
            char b2[3];
            char c2[5];
            if(a==1) strcpy(a2,"January ");
            if(a==2) strcpy(a2,"February ");
            if(a==3) strcpy(a2,"March ");
            if(a==4) strcpy(a2,"April ");
            if(a==5) strcpy(a2,"May ");
            if(a==6) strcpy(a2,"June ");
            if(a==7) strcpy(a2,"July ");
            if(a==8) strcpy(a2,"August ");
            if(a==9) strcpy(a2,"September ");
            if(a==10) strcpy(a2,"October ");
            if(a==11) strcpy(a2,"November ");
            if(a==12) strcpy(a2,"December ");
            sprintf(b2, "%d", b);
            sprintf(c2, "%d", c);
            strcpy(str,a2);
            strcat(str,b2);
            strcat(str,", ");
            strcat(str,c2);
            printf("%s\n",str);
        }
        else
        {
            printf("The input format isn't correct.\n");
        }
        
    }
    else
    {
        printf("The input format isn't correct.\n");
    }
    return 0;
}
