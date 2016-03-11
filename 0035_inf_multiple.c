int lcm(long int x, long int y) {
  return (x * y) / gcd(x, y);
}
int gcd(long int x, long int y) {
  if (y == 0)
    return x;
  return gcd(y, x % y);
}

void fun() {
  long int i;
  long int val = 1;
  for (i = 2; i < 21; i++)
    val = lcm(val, i);
  printf("%d\n", val);
}

void (*solutions[])() = { fun, NULL };
