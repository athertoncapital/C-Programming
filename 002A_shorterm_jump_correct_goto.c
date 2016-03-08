#include <stdio.h>

int main(int argc, char *argv[]) {
  int a = atoi(argv[1]);
  int b = atoi(argv[2]);
  char *fileName = argv[3];
  if (b == 0) // can't divide by 0
    goto DivideByZero;
  int result = a/b;
  FILE *file;
  if ((file=fopen(fileName, "w")) == NULL)
    goto FileError;
  else {
    fprintf(file, "%d/%d=%d\n", a, b, result);
    printf("save to file %s : %d/%d=%d\n", fileName, a, b, result);
  }
  fclose(file);
  goto Exit;
 DivideByZero:
  printf("Error  : Divide by zero\n");
  goto Exit;
 FileError:
  printf("Error : File error\n");
  goto Exit;
 Exit:
  return 0;
}
