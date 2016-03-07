#include <stdio.h>
#include <string.h>
#include <stdlib.h>

int main() {
  char buf[256];
  char *str;
  int len;
  printf("Input string: ");
  fgets(buf, sizeof(buf), stdin);
  len = strlen(buf);
  /* remove new line character */
  if (buf[len - 1] == '\n')
    buf[len - 1] = 0;
  str = (char *)calloc(len, sizeof(char));
  strcpy(str, buf);
  printf("Enter your string: %s\n", str);
  free(str);
  system("PAUSE");
  return 0;
}
