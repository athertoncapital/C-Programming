#include <stdio.h>
#include <string.h>
#include <stdlib.h>

int readLine(char **pStr) {
  char buf[256];
  int len;
  printf("Input string: ");
  fgets(buf, sizeof(buf), stdin);
  len = strlen(buf);
  // remove new line character
  if (buf[len - 1] == '\n')
    buf[len - 1] = 0;
  *pStr = (char *)calloc(len, sizeof(char));
  strcpy(*pStr, buf);
  return len;
}

int main() {
  char *str;
  readLine(&str);
  printf("Your string: %s\n", str);
  free(str);
  system("PAUSE");
  return 0;
}
