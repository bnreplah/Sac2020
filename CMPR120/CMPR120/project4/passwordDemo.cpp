
#include <iostream>
#include <string>
#include <fstream>
//#include <iomanip>
#include <conio.h>
using namespace std;

int main( )
{
	int id = int();
	string fname = string();
	double wages = double();
	double sum = double();
	double avg = double();
	int count = int();
	char ch[8];

	cout << scientific;
	
	
	//<< .6614 << endl;
	system("pause");

	ifstream in;
	in.open("password.txt");
	ofstream out;
	out.open("password.txt");

	cout << "Enter a character: ";
	for(int i=0; i<8; i++)
	{
		ch[i] = getch();//dumpnow1
		cout << "*";
	}

	for(int i=0; i<8; i++)
	{
		ch[i] = ch[i] + 100;//key
	}

	cout << "\nYou entered: ";
	
	for(int i=0; i<8; i++)
	{
		out << ch[i];
	}
	cout << endl;
	cout << "\nHit any key to decrypt" << endl;

	//system("pause");

	for(int i=0; i<8; i++)
	{
		in >> ch[i];
		ch[i] = ch[i] - 100;//key
	}
	
	for(int i=0; i<8; i++)
	{
		cout << ch[i];
	}
	cout << endl;

	//ifstream in;
	//in.open("data.txt");

	//ofstream out;
	//out.open("report.txt");

	//while(!in.eof())
	//{
	//	in >> id >> fname >> wages;//"A" failed 'in' object
	//	while(in.fail())
	//	{
	//		in.clear();//back to the good state
	//		in.ignore(1, '\n');
	//		in >> wages;
	//	}

	//	sum = sum + wages;
	//	
	//	cout << id << " " << fname << " " << wages << endl;
	//	out << id << " " << fname << " " << wages << endl;
	//	++count;
	//}
	//avg = sum /count;

	//cout << "Total Records Read: " << count << endl;
	//cout << "Total Wages: " << sum << endl;
	//cout << "Average Wage: " << avg << endl;
	//out << "Total Records Read: " << count << endl;




   /* char grade;

    cout << "Enter your midterm grade and press Return: ";
    cin >> grade;

    switch (grade)
    {
        case 'A':
            cout << "Excellent. "
                 << "You need not take the final.\n";
            break;
        case 'B':
            cout << "Very good. ";
            grade = 'A';
            cout << "Your midterm grade is now "
                 << grade << endl;
            break;
        case 'C':
            cout << "Passing.\n";
            break;
        case 'D':
        case 'F':
            cout << "Not good. "
                 << "Go study.\n";
            break;
        default:
            cout << "That is not a possible grade.\n";
    }

    cout << "End of program.\n";*/
    return 0;
}