#include "bits/stdc++.h"
int getInvCount(int arr[], int n)
{
  int inv_count = 0;
  for (int i = 0; i < n - 1; i++)
    for (int j = i+1; j < n; j++)
      if (arr[i] > arr[j])
	inv_count++;

  return inv_count;
}

/* Driver: to test above functions */
int main(int argv, char** args)
{
  int arr[] = {2, 4, 1, 3, 5};
  int n = sizeof(arr)/sizeof(arr[0]);
  printf(" %d \n", getInvCount(arr, n));
  return 0;
}
