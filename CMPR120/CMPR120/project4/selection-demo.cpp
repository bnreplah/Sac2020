/*
#include <iostream>
#include <string>
using namespace std;

int main()
{

	int age = int();
	
	cout << "Please enter your age: ";
	cin >> age;

	//checking for the correct data type
	if(cin.fail())
	{
		cin.clear();
		cout << "Invalid Value" << endl;
		cin.ignore(1000,'\n');
	}
	else
	{
		if (age < 18)
		{
			cout << "Sorry, you are under age." << endl;
		}
		else if (age > 18)
		{
			cout << "Welcome...do you go to SAC?" << endl;
		}
		else if (age == 18)
		{
			cout << "mmmmm....You are 18." << endl;
		}
		else
		{
			cout << "Invalid selection." << endl;
		}
	}


	return 0;
}
*/

#include <iostream>
#include <string>
using namespace std;

int main()
{
	char grade = char();
	bool flag = true;
	char cont = char();
	char gender = 'F';


	while (flag)//if flag is true then stay inside this loop
	{
		cout << "Enter your grade: ";
		cin >> grade;

		switch(grade)
		{
		case 'A':
		case 'a':
		{
			if (gender == 'F' || gender == 'f')
			{

				cout << "Congratulations! You have earned an A grade." << endl;
			}
			
			break;
		}
		case 'B':
		case 'b':
			{
				cout << "B" << endl;
				break;
			}
		case 'C':
		case 'c':
			{
				cout << "C" << endl;
				break;
			}
		case 'D':
		case 'd':

			{
				cout << "D" << endl;
				break;
			}
		case 'F':
		case 'f':
			{
				cout << "F grade...Please work harder." << endl;
				break;
			}
		default:
			{
				cout << "Invalid grade!" << endl;
				break;
			}
		}
		cout << "Do you want to continue? (y/n): ";
		cin >> cont;

		if (cont == 'Y' || cont == 'y')
		{
			flag = true;
		}
		else
		{
			flag = false;
		}
	}
	system("pause");
}
