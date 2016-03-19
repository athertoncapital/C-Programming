#include <iostream>
#include <cstdlib>   // Needed for the exit function
using namespace std;

void exit_func();

int main()
{
  exit_func();
  return 0;
}


void exit_func()
{
  cout << "This program terminates within the exit function.\n";
  exit(0);
  cout << "This message will never be displayed.\n";
}
