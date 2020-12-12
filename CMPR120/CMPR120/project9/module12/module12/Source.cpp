/*
*lecture code
* 
*/

#include <iostream>
using namespace std;
void mainMenu(int value[], string name[], double taxes[], double rate[], int size) {//function needs to know what is the size of technique, good technique. 

	for (int i = 0; i < size; i++)
		cout << "ID :" << i << " : " << value[i] << " : " << name[i] << " : " << taxes[i] << " : " << rate[i] << endl;



}//end mainMenue
int mainB() {
	const int SIZE = 5;
	int tests[SIZE];//note cannot do like previous variables of = new int() or = new int[]
	int spaces = sizeof(tests) / sizeof(int);//there are built in functions in c++ to do this as well
	int nullArr[2] = {};//initialized with null
	
	int array[10] = { 0 };//initializes all with the value 0
	string parallel[10] = { "names" };//is a parallel index, this is used in records, records are parallel arrays, same id are associated with each other
	double tax[10] = { 0.0 };
	double rate[10] = { 0.01 };
	int arraySize = sizeof(array) / sizeof(int);
	int multi[SIZE][SIZE];

	cout << "there are " << spaces << " spaces within the array tests" << endl;//this is done manually determining the size
		cout << "this is the memory address of the tests array" << tests << endl;
	cout << "using the sizeof method to view the size of the array, this can be used to determine the size if you know the bytes of the type" << endl;
	cout << sizeof(tests) << endl;

	for (int i = 0; i < SIZE; i++)
		cout << "the memory at the location " << i + 1 << ": " << &tests[i] << endl;

	cout << "in terms of parallel arrays" << endl;

	mainMenu(array, parallel, tax, rate, arraySize);

	for (int i = 0; i < SIZE; i++)//rows
		for (int j = 0; j < SIZE; j++)//col
			multi[i][j] = (i + (j * SIZE));

	for (int i = 0; i < SIZE; i++) {//rows
		for (int j = 0; j < SIZE; j++)//col
			cout << " |  " <<multi[i][j] << "  | ";
		cout << endl;
	}//end for



	return 0;

}
//note c++ may allow you to access soemthing that your not allowed. Sometimes it will crash the program, cause a compiler error out of bounds, or crash the system
