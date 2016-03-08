#include <stdio.h>

typedef struct {
  char *name;
  int age;
} foo;

int main() {
  foo p = {
    .name = "John",
          .age = 40
  };

  printf("%s is %d years old", p.name, p.age);
}
