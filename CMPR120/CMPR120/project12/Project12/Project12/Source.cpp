#include <iostream>
#include <iomanip>
using namespace std;

int main() {
	const int S = 5;
	double x[S] = { 99, 87 };
	//for (int i = 2; i <= S; i++)
	//	x[i] = 0.0;
	for (double val : x)
		cout << val;
	cout << "hellow world";
	return 0;



}