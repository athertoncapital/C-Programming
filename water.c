#include <stdio.h>
#include <stdlib.h>
#include <string.h>
int power(int i);
int main(void)
{
  char a[500];
  for(int i=0; i<500;i++)
    {      a[i]='\0';    }
  int flag = 0;
  int c = 0;
 LOOP: do{
    flag = 0;
    c = 0;
    printf("minutes: ");
    for(int i=0; i<500;i++)
      {      a[i]='\0';    }
    fgets(a,500,stdin);
    if(a[0]=='\0'||a[0]==' '||a[0]=='\n')
      {
	flag = 1;
	continue;
      }
    for(int i=0;i<500;i++){
      c++;
      //      printf("c=%d\n",c);
      if(a[i]=='\0'||a[i]==' '||a[i]=='\n')
	{
	  flag = 0;
	  break;
	}
      if(a[i]<48||a[i]>57)
	{
	  flag = 1;
	  break;
	}
    }
  }while(flag==1);
  int c1=c-1;
  int c2=c1-1;
  int k = 0;
  int count=0;
  count=power(c2);
  for(int i=0;i<c1;i++){
    k += (a[i]-48)*count;
    count /=10;
  }
  int result;
  result = k*12;
  if(result==0) goto LOOP;
  printf("bottles: %d\n",result);
  return 0;

}
int power(int i){
  if (i==0)
    return 1;
  else if (i==1)
    return 10;
  else
    return 10*power(i-1);
}
