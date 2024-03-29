#include <iostream>
using namespace std;

int main()
{
  double dU, m=2.0,  g = -9.8, t=100.5, S_i=100.0, S_f;

  // Calculate the amount of a 20% discount.
  S_f = S_i + 0.5*g*t*t;
  dU =m*g*0.5*t*t*g;

  // Display the results.
  cout << "Displacement: " << S_f << "m" << endl;
  cout << "Potential Energy Changes: " << dU  << " joules"<<endl;

  return 0;
}
