#include <stdio.h>
#include <cs50.h>
int main(void)
{
  int h = 0;
  do {
    printf("Height:");
    h = GetInt();
    if (h == 0)return 0;
  } while (h < 1 || h > 23);
  int count = 0;
  //int index = 0;
  while(count<h)
    {

      for(int j = 0; j < h-count-1; j++)
	// while(index<(h-count-1))
	{
	  printf("%s", " ");
	  //	  index++;
	}
      for(int k = 0; k < count+1; k++)
	{
	  printf("#");
	}
      printf("  ");
      for(int k = 0; k < count+1; k++)
	{
	  printf("#");
	}
      printf("\n");
      count++;
    }
  return 0;
}
