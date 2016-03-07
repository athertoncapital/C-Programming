#include <cstdlib>
#include <time.h>
#include <iostream>

using namespace std;

int main() {
  srand(time(0));
  int number;
  number = rand() % 1000 + 1;
  int guess;
  do {
    cout << "Enter your estimate: ";
    cin >> guess;
    if (guess < number)
      cout << "Your estimate is less, than the secret number" << endl;
    else if (guess > number)
      cout << "Your estimate is more, than the secret number" << endl;
    else
      cout << "Your guess is right!" << endl;
  } while (guess != number);
  system("PAUSE");
  return 0;
}
