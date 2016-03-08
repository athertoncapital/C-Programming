#include <stdio.h>

void div() {
 DivideByZero:
  printf("Error  : Divide by zero\n");
}

int main(int argc, char *argv[]) {
  int a = atoi(argv[1]);
  int b = atoi(argv[2]);
  char *fileName = argv[3];
  if (b == 0) // can't divide by 0
    goto DivideByZero;
  int result = a/b;
  return 0;
}
