#include <iostream>
using namespace std;

// Function prototype
void printLocal();

int main()
{
  printLocal();
  printLocal();
  return 0;
}


void printLocal()
{
  int Num = 5; // Local variable

  cout << "local Num is " << Num << endl;
  Num = 99;
}
