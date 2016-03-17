// This progam calculates the wave length of matters.
#include <iostream>
using namespace std;

int main()
{
  double p, h, lambda, m, v;

  h = 4.135;
  
  // Get the momentum
  cout << "How much mass (in kg) does the particle or object have? ";
  cin >> m;

  cout << "What velocity (in m/s)  does the particle or object have? ";
  cin >> v;


  // Calculate the momentum.
  p = m*v;

  // Calculate the wave length
  lambda = h/p;

  // Display the wave length.
  cout << "The wave length(m) is " << lambda << endl; //f*eV*s, f= 10^-15
  return 0;
}
