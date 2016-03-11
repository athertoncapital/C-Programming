void fun() {
  int i;
  int j;
  int val;
  char vstr[6];
  int max = 99999;
  for (i = 999; i > 100; --i) {
    for (j = 999; j >= i; --j) {
      val = i*j;
      if (val < 1000000 && val > max) {
	sprintf(vstr, "%d", val);
	if (vstr[0] == vstr[5] &&
	                vstr[1] == vstr[4] &&
	    vstr[2] == vstr[3]) {
	  max = val;
	}
      }
    }
  }
  printf("%d\n", max);
}

void (*solutions[])() = { fun, NULL };
