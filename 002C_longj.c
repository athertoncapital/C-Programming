#include <stdio.h>
#include <setjmp.h>

jmp_buf jumper;

int div(int a, int b) {
  if (b == 0) { // can't divide by 0
    longjmp(jumper, -3);
  }
  return a / b;
}

int main(int argc, char *argv[]) {
  int jstatus = setjmp(jumper);
  if (jstatus == 0) {
    int a = atoi(argv[1]);
    int b = atoi(argv[2]);
    printf("%d/%d", a, b);
    int result = div(a, b);
    printf("=%d\n", result);
  }
  else if (jstatus == -3)
    printf(" --> Error:divide by zero\n");
  else
    printf("Unhandled Error Case");
}
