#include <cs50.h>
#include <stdio.h>
#include <stdbool.h>
int main()
{
  printf("Number: ");
  long long n = GetLongLong();
  bool flag = true;
  int add1, add2;
  add1=0;
  add2=0;
  int name;
  while (n > 0)
    {
      int  second_to_last = n % 10;
      name = n;
      n /= 10;
      if (flag == true)
	{
	  add1 += second_to_last ;
	  flag = false;
	}
      else
	{
	  second_to_last  *= 2;
	  while (second_to_last  > 0)
	    {
	      add2 += second_to_last  % 10;
	      second_to_last  /= 10;
	    }
	  flag = true;
	}
    }
  int k = add1+add2;
  if (k % 10 == 0)
    {
      switch (name)
	{
	case 3:
	  printf("AMEX\n");
	  break;
	case 4:
	  printf("VISA\n");
	  break;
	case 5:
	  printf("MASTERCARD\n");
	  break;
	}
    }
  else
    {
      printf("INVALID\n");
    }
  return (0);
}
