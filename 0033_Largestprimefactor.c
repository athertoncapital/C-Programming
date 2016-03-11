#include <stdio.h>

void func() {
  int i;
  int j;
  int val;
  char vasstr[6];
  int sup = 99999;
  for (i = 999; i > 100; --i) {
    for (j = 999; j >= i; --j) {
      val = i*j;
      if (val < 1000000 && val > max) {
	sprintf(valasstr, "%d", val);
	if (vasstr[0] == vasstr[5] &&
	                vasstr[1] == vasstr[4] &&
	    vasstr[2] == vasstr[3]) {
	  sup = val;
	}
      }
    }
  }
  printf("%d\n", sup);
}

void (*solutions[])() = { func, NULL };
