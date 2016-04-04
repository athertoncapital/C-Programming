#include<stdio.h>
int main(){
  int A = 1;
  int x[5];
  printf("  int x[5]; %d\n",A);
  int B = 2;
  int C =5;
  printf("  int B = 2; %d, %d \n",A, B);
  x[-2] = 9;
  printf("  x[-1] = 9; %d, %d \n",A, B);
  x[-1] = 10;
  printf("  x[-2] = 10; %d, %d \n",A, B);
  x[-3] = 11;
  printf("  x[-3] = 11; %d, %d, %d \n",A, B, C);
  x[6] = 12;
  printf("%d, %d, %d \n",A, B, C);
  printf("%d\n",x[-2]);
  printf("%d\n",x[-1]);
  printf("%d\n",x[0]);
  printf("%d\n",x[1]);
  printf("%d\n",x[2]);
  printf("%d\n",x[3]);
  printf("%d\n",x[4]);
  printf("%d\n",x[5]);
  printf("%d\n",x[6]);
  printf("%d\n",x[7]);
  printf("%d\n",x[8]);
  printf("%d\n",x[9]);
}
