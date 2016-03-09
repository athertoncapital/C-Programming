#include <iostream>
#include <cstdlib>
#include <ctime>
using namespace std;
int rand_0toN1(int n);
int main()
{
  int n=0;
  int r=0;
  srand(time(nullptr));//set seed for rand
  cout<<"Enter number of dice: ";
  cin>>n;
  for(int i=1; i<=n; i++){
    r = rand0toN1(6)+1;
    cout<<r<<" ";
  }
  return 0;
}
int rand_0toN1(int n)
{
  return rand() %n;
}
