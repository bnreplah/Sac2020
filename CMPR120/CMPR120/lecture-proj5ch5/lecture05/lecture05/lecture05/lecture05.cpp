/*
* Author's Name: Ben Halpern
* Program Name: lecture05.cpp
* Date: October 1, 2020
* College Name: Santa Ana College (SAC)
* CMPR 120
* Professor Aziz
* 
*
*
*####################################################
* Assignment details:
*####################################################
*
*/

#include <iostream>//input output stream. Preprocessor command to include the input output stream library
#include <fstream>//file input output

//#include <cmath>
//#include <iomanip>
//#include <cstdlib>	//not used and when included casues the cout and cin to be marked by intellisence as missing 
using namespace std;	//using the standard library ( allows to display simply cout and cin instead of std::cout or std::cin )


int Main() {					//main class
	//cin is request input from user
	//cout is output to the screen
	//endl is endline 
	//';' ends a statment
	//variables declared with camelHump notation
	//int refers to integer
	//double refers to decimal number or floating point number
	
	//Declaration of variables:
		//initialization and instatiation.


	//End Declaration of variables

	//HOMEWORK HEADER
	//program header
	cout << "=====================================================================" << endl;
	cout << endl;									//blank line for readability
	cout << "Author's Name: Ben Halpern" << endl;
	//displays Authors Name, followed by an end-line command, printing the next line on a new line
	cout << "Program Name :  Halpern_Project4_QuadraticEquation.cpp" << endl;
	//displays Program Name, followed by an end-line command, printing the next line on a new line
	cout << "Date : October 5, 2020 " << endl;
	//display's date, followed by an end-line command, printing the next line on a new line
	cout << "College Name : Santa Ana College(SAC)" << endl;
	//displays College Name, followed by an end-line command, printing the next line on a new line
	cout << endl;									//blank line for readability
	cout << "=====================================================================" << endl;
	cout << endl;

	//lecture 05, Lecture code will be added to this project as well as this program.
	//when reading files, when wanting to read more than one line, loops will be used.
	//recall for() loop is exactly like in java: (initialization; conditional; manipulator )
	//for loop is almost ( is ) identical in java and c# and sometimes other programing languages as well
	string name = string();
	int value = int();
	double rate = double();
	ifstream in;//creates input object
	ofstream out;//creates output object

	in.open("name.txt");
	//out.open("createNew.txt");

	in >> name >> value >> rate;
	cout << name << " " << value, rate;
	//out << name, value, rate;

	in.close();
	out.close();
	return 0; //returns to the system 0 if succesfull , not neccesary for int main () but it is good practice

}//End of main()
//EOF
