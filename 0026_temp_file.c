#include <stdio.h>

int main(void){
  FILE *file;
  if((file=tmpfile())==NULL) {
    printf("Cannot open temporary work file.\n");
    exit(1);
  }
  fprintf(file, "They are a garland to grace your head and a chain to adorn your neck.");
  fflush(file);

  char msg[10];
  fseek(file, 0, SEEK_SET);
  fscanf(file, "%s", msg);
  printf("msg=%s", msg);
  fclose(file);
}
