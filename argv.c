#include<stdio.h>

int main(int argc, char* argv[])
{

  int i;
  int j;
  for (i = 0; i < argc; i++)
    printf("%s\n", argv[i]);
  //printf("%d\n",argc);
  //  while (argc-- > 0)
  //{

  //  printf("%s\n", *argv++);
  //}
  //  printf("%s\n",argv[0]);
     for (j=0; j<argc; j++)
  {
      printf("%s\n", argv[j]);
      printf("%d\n",j);
      }

}
