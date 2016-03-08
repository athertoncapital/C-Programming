#include <stdio.h>

int main () {
  char buffer[BUFSIZ];  
  FILE *file;
  file=fopen ("test.txt","w");
  setbuf (file, buffer ); // setbuf(file, NULL) cancel buf, output directly
  fclose (file);
  return 0;
}
