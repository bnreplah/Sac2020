/*


*/
//NOTES for zoom meetin september 14 
//supplementary to notebook notes
// will cover new concepts
#include <iostream>
#include <string>
#include <iomanip>
#include <cmath>
#include <cstdlib>
using namespace std;

int main()
{
	double num = 34.55764;
	double newNum = 3.0;
	double sqNum = double();
	string name = string();

	cout << fixed << setprecision(2);
	cout << setw(10) << left << "Number:" << setw(8) << right << num << endl; //Number:34.56

	//sqNum = newNum * newNum;
	sqNum = sqrt(newNum);//9
	cout << sqNum << endl;

	cout << "Enter your name: ";
	//cin >> name;
	//cout << name << endl;//Tim Smith
	getline(cin, name);
	cout << name.length() << endl;
	cout << name << endl;
	system("pause");
	return 0;
}