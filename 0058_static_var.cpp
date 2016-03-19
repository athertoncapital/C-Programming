// Static local variables are only initialized once.
#include <iostream>
using namespace std;

void printStatic(); 
void print();

int main()
{

  for (int count = 0; count < 5; count++)
    printStatic();
  for (int count = 0; count < 5; count++)
    print();

  return 0;
}
void print()
{
  int Num = 10;
  cout << "Num is " << Num << endl;
  Num++;
}

void printStatic()
{
  static int statNum = 5;

  cout << "statNum is " << statNum << endl;
  statNum++;
} 
