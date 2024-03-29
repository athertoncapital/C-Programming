// This program uses reference variables as function inputs.
#include <iostream>
using namespace std;

void triNum(int &);
void getNum(int &);

int main()
{
  int store;

  // Get a number and store it in store.
  getNum(store);

  // triple the number that stored in store.
  triNum(store);

  // Display the resulting number.
  cout << "That value tripled is " << store << endl;
  return 0;
}

//*************************************************************
// Definition of getNum.                          
// The parameter userNum is a reference variable. 
// User's input is stored in userNum.       
//*************************************************************

void getNum(int &userNum)
{
  cout << "Enter a number: ";
  cin >> userNum;
}

//**********************************************************
// Definition of doubleNum.                      
// The parameter refVar is a reference variable. 
//**********************************************************

void triNum (int &refVar)
{
  refVar *= 3;
}
