// This program uses two variables with the name number.
#include <iostream>
using namespace std;

int main()
{
  // Define a variable named numb
  int numb;

  cout << "Enter a number greater than 0: ";
  cin >> numb;
  if (numb > 0)
    {
      int numb;  // Another variable named number.
      cout << "Now enter another number: ";
      cin >> numb;
      cout << "The second number you entered was "
	   << numb << endl;
    }
  cout << "Your first number was " << numb << endl;
  return 0;
}
