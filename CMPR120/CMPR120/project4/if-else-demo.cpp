#include <iostream>
#include <string>
using namespace std;

int main()
{
	int value = int();
	double rate = double();
	string fname = string();
	char gender = char();
	bool flag = bool();

	cout << "Enter Your First Name: ";
	cin >> fname;

	cout << "Please enter your gender: ";
	cin >> gender;

	if (fname != "Diana")
	{
		cout << "You are NOT a verified User..." << endl;
	}
	else
	{
		cout << "Please enter rate: ";
		cin >> rate;

		if (rate <= 10)
		{
			cout << "Rate = " << rate << endl;
		}
		if (rate > 10)
		{
			if (rate < 20)
			{
				rate = rate + .5;
				cout << "Rate after bonus = " << rate << endl;
			}
		}
		if (rate > 21)
		{
			if (gender == 'f' || gender == 'F')
			{
				rate = rate + 1.0;
				cout << "Hello Miss, Your Rate after additional bonus = " << rate << endl;
			}
		}
	}


	system("pause");
}
