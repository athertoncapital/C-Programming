#include <math.h>
#include <inttypes.h>

void fun() {
  int64_t number = 600851475143;
  int d = 2;
  while (number > 1) {
    if (0 == (number % d)) {
      number /= d;
    } else {
      ++d;
    }
  }
  printf("%d\n", d);
}

void (*solutions[])() = { fun, NULL };
