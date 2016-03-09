#include<iostream>
using namespace std;
long long foo(long long n, int t);
int main()
{
  int i;
  cin >> i;
  while (i--)
    {
      long long n;
      cin >> n;
      cout << foo(n, 3) + foo(n, 5) - foo(n, 15) << endl;
    }
  return 0;
}
long long foo(long long n, int t){
  return (t + (n - 1) / t * t) *((n - 1) / t) / 2;
}
