#include <iostream>
using namespace std;

// Gobal constant.
const int Num = 500;

// Function prototype
void print();

int main()
{
  cout << "In main there are " << Num <<endl;
  print();
  return 0;
}

//********************************************
// print function                            *
//********************************************

void print()
{
  const int Num = 10000;
  cout << "In print func there are " << Num
       << ".\n";
}
