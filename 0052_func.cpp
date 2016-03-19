#include <iostream>
using namespace std;
// Prototype
void show(double, int);

int main()
{

  const double A = 40.0;
  const double B = 30.0;
  const double C = 20.0;


  cout << "Testing Case A"
       << A << " and 10.\n";
  show(A, 10);

  cout << "Testing Case B"
       << SENIOR << " and 10.\n";
  show(B, 10);


  cout << "Testing Case C"
       << C << " and 10.\n";
  show(C, 10);
  return 0;
}

//*****************************************************************
// Definition of function 
//*****************************************************************

void showFees(double memberRate, int months)
{
  cout << "The total charges are $"
       << (memberRate * months) << endl;
}
