#include <iostream>
using namespace std;

int main()
{
  char feedGrade;

   cout << "Our pet food is available in three grades:\n";
  cout << "a, b, and c. Which do you want pricing for? ";
  cin >> feedGrade;

  // Display the price.
  switch(feedGrade)
    {
    case 'a':
    case 'A': cout << "50 cents per pound.\n";
      break;
    case 'b':
    case 'B': cout << "30 cents per pound.\n";
      break;
    case 'c':
    case 'C': cout << "20 cents per pound.\n";
      break;
    default:  cout << "That is an invalid choice.\n";
    }
  return 0;
}
