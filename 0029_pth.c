#include <stdio.h>
#include <sys/stat.h>

int main() {
  char path[100];
  size_t size;
  getcwd(path, sizeof(path));
  printf("path=%s\n", path);
  mkdir("/temp1", S_IWRITE);
  chdir("/temp1");
  getcwd(path);
  printf("path=%s\n", path);
}
