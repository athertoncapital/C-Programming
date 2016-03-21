#include <iostream>
#include <iomanip>
using namespace std;


// Function prototypes
void showMenu();
void showFees(double, int);

int main()
{
  int choice;       // To hold a menu choice
  int months;       // To hold a number of months

  // Constants for the menu choices
  const int A_CHOICE = 1,
    C_CHOICE = 2,
    B_CHOICE = 3,
    QUIT_CHOICE = 4;

  // Constants for membership rates
  const double A = 40.0,
    B = 30.0,
    C = 20.0;

  // Set up numeric output formatting.
  cout << fixed << showpoint << setprecision(3);

     do
       {
	 showMenu();
	 cin >> choice;

	 while (choice < A_CHOICE || choice > QUIT_CHOICE)
	   {
	     cout << "Please enter a valid menu choice: ";
	     cin >> choice;
	   }

	 // If the user does not want to quit, proceed.
	 if (choice != QUIT_CHOICE)
	   {
	     // Get the number of months.
	     cout << "For how many months? ";
	     cin >> months;

	     // Display the membership fees.
	     switch (choice)
	       {
	       case A_CHOICE:
		 showFees(A, months);
		 break;
	       case C_CHOICE:
		 showFees(C, months);
		 break;
	       case B_CHOICE:
		 showFees(B, months);
	       }
	   }
       } while (choice != QUIT_CHOICE);
     return 0;
}

//*****************************************************************
// Definition of function showMenu which displays the menu.       *
//*****************************************************************

void showMenu()
{
  cout << "\n\t\tMenu\n\n"
       << "1. A\n"
       << "2. B\n"
       << "3. C\n"
       << "4. Quit the Program\n\n"
       << "Enter your choice: ";
}

void showFees(double mRate, int months)
{
  cout << "The total charges are $"
       << (mRate * months) << endl;
}
