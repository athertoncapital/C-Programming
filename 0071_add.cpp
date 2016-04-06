int Add(int a, int b)
{
  while (b != 0)
    {
      int c = a & b;
      a = a ^ b;
      b = c << 1;
    }
  return x;
}
