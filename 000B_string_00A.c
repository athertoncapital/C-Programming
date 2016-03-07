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

int readLines(char ***pStrings) {
  int n, i;
  printf("How many strings to input: ");
  scanf("%d", &n);
  // skip newline
  getc(stdin);
  *pStrings = (char **)calloc(n, sizeof(char *));
  for (i = 0; i < n; i++)
    readLine(&(*pStrings)[i]);
  return n;
}

int compareStrings(const void *pStr1, const void *pStr2) {
  return strcmp(*(char **)pStr1, *(char **)pStr2);
}

int main() {
  char **strings;
  int n, i;
  n = readLines(&strings);
  qsort(strings, n, sizeof(char *), compareStrings);
  printf("Sorted strings: \n");
  for (i = 0; i < n; i++)
    printf("%s\n", strings[i]);
  // free memory
  for (i = 0; i < n; i++)
    free(strings[i]);
  free(strings);
  system("PAUSE");
  return 0;
}
