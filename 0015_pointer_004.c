#include <stdio.h>

int sum(int a, int b) {
  return a+b;
}

int mult(int a, int b) {
  return a*b;
}

int main() {
  int (*opr)(int a, int b);
  opr = sum;
  printf("opr(2,8)=%d\n", opr(2,8));
  opr = mult;
  printf("opr(3,5)=%d\n", opr(9,10));
}
