/*
* Author's Name: Ben Halpern
* Program Name:  Halpern_Project.cpp
* Date: 
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

#include <iostream>		//input output stream. Preprocessor command to include the input output stream library
//#include <string>
//#include <cmath>
//#include <iomanip>
//#include <cstdlib>	//not used and when included casues the cout and cin to be marked by intellisence as missing 
using namespace std;	//using the standard library ( allows to display simply cout and cin instead of std::cout or std::cin )



void homeworkHeader(string title, string date) {
	//HOMEWORK HEADER
//program header
	cout << "=====================================================================" << endl;
	cout << endl;									//blank line for readability
	cout << "Author's Name: Ben Halpern" << endl;
	//displays Authors Name, followed by an end-line command, printing the next line on a new line
	cout << "Program Name :  "<< title << endl;
	//displays Program Name, followed by an end-line command, printing the next line on a new line
	cout << "Date : "<< date << endl;
	//display's date, followed by an end-line command, printing the next line on a new line
	cout << "College Name : Santa Ana College(SAC)" << endl;
	//displays College Name, followed by an end-line command, printing the next line on a new line
	cout << endl;									//blank line for readability
	cout << "=====================================================================" << endl;
	cout << endl;

}//end homeworkHeader

void cls() {
	//source:https://stackoverflow.com/questions/17335816/clear-screen-using-c
	cout << "\033[2J\033[1;1H";
	//the escapes translate to clear screen equivalent, supposidly cross platform
	//trying to avoid system("cls"); because its platform dependant
}//end cls


int main() {					//main class
	//cin is request input from user
	//cout is output to the screen
	//endl is endline 
	//';' ends a statment
	//variables declared with camelHump notation
	//int refers to integer
	//double refers to decimal number or floating point number
	
	//Declaration of variables:
		//initialization and instatiation.
	const string DATE = ",2020";//DATE
	const string TITLE = "Halpern_Project.cpp";//NAME OF PROGRAM
	int test = int();
	char ch = char();
	//End Declaration of variables
	homeworkHeader(TITLE, DATE);
	
	//to pause screen
	cout << "Please press enter to continue ... ";
	//cin.ignore();
	cin.get();
	cls();

	//Algorithm




	return 0; //returns to the system 0 if succesfull , not neccesary for int main () but it is good practice

}//End of main()
//EOF