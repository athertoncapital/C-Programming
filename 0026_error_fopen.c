#include <stdio.h>
#include <stdlib.h>

int main(int argc, char *argv[]) {
  FILE *in, *out;
  char ch;

  if((in=fopen(argv[1], "rb")) == NULL) {
    perror("Error");
    exit(1);
  }

  while(!feof(in)) {
    ch = getc(in);
    if(ferror(in)) {
      perror("Error");
      clearerr(in);
      break;
    }
    putchar(ch);
  }
  fclose(in);
  return 0;
}
