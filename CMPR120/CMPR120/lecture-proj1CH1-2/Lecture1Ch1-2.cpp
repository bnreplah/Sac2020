/*
lecture for chapter 1



*/

//no semicolon after preprocessor command
#include <iostream>		//input/output stream: a library which is included by the preprocessor command ( anything tha follows #) ( i.e. #include means include this library ) 
using namespace std;	//some programs and books don't include this line, use the standard library ( from above ) (standard input output)
#include <string>
int main() {//can be void main() as well the class object identifier in this case is int so the class is expecting and int to be returned.
	//variable is a storage location in memory, has a name and data type, it needs to be declared
	//a proper way to initialize a varaible is with the variable defintion
	double initMe = double();
	int initMeToo = int();
	bool imABool = bool();
	string isThereOne = string();
	initMe = 20.0; //this is a double literal
	initMeToo = 20; // this is a integer literal
	//words like double and cout etc are all key words; identifiers are name like variables and functions - programer dfined words like variables and functions
	//Identifiers must start with an alpahbetic character or an underscore, after the first character you may use alphanumeric but no other symbols, upper and lowercase must be distinct
	//the same ranges of bytes that apply in java apply in C++
	//To stor and integer as a long or a long long convert it wiht the L at the end of the literal ie 1234L or 12LL
	//Constants that begin with 0 are base 8
	//constants that begin with 0x are base 16 ( hexadecimal )
	//there are 84 C++ key words
	double rate;//int rate;//int age; //this is known as a declaration or initilization 
	double hours;// rate and hours need to be doubles because they may have decimal input 
	cout << "Hello World" << endl; // COUT means Console OUTput, outputs anything in the double quotes ( syntax )
	cout << "===================" << endl;//endl means end line and breaks the line
	cout << "Please enter your rate per hour: ";// note that the query is asking for rate per hour but the variable says age, so change the varaible so the programmer can follow
	String hello = "this is a string literal";
	cin >> rate;//age; //CIN means Console INput, notice the operator changed direction. The computer doesn't know what age is, it requirs an identifier so it knows what data to look for to be
				//stored in the age variable
				//at this current stage the program is poorly ( logically ) designed and the user doesn't know they are being requested an input.
				// create a query for the user to input their age
	cout << "Please enter number of weekly hours worked: ";
	cin >> hours;

	//PROCESSING
	double gross = rate * hours; // creates an algorithm
	cout << "Your Gross pay is $" << gross; //outputs gross pay 
									// concatination, or integrating variables 
	char imAChar = 'a';//this is a char literal
	//chars are singular characters which correspond to their place in ascii or unicode
	// they represent numbers on the chart
	//a series of character in consecutive memory location is a string, compromised between the "" double quotes
	//|H|E|L|L|O|\0| stored with a null terminator \0 at the end in memory
	//the #inclue <string> class is a special data type working with strings

	//floating point data types are of the following
	//float
	//double
	//long double and so on
	// they can hold real numbers ( all floating point numbers are signed ( with + or - ))
	//can be reprecented in either decimal notation or E notation 
	//are double ( decimal ) by defaul or forced to be float with f at the end 3.14159f or long double 0.000625L

	//booleans as seen above are of true or false ( 1/ 0)

	//the sizeof operator gives the size of any data type or varaible
	//ie: sizeof(double)

	//initliaization ( as covered before and again in cahpter two ) 
	//introduces multiple initialization
	//int length = 12, width = 5, area;
	//this initializes all three varaibles under an int
	// or witht he class initialization 
	// int length = int();

	//C++ 11 introduces an alternative way to define varaibles using the auto keyword
	auto amount = 100; //initializes it as an int
	auto doub = 10.0; // initializes as a double 
	auto car = 'c'; // char 
	
	//as is covered in java, C++ aslos has varaible scope: a variable cannot be used before it is defined or in an outside function if nto defiend globally
	
	//Arithmetic operators:
	// C++ has unary, binary, and ternary operators
		//unary -5 ( 1 operand )
		//binary 13-7	( 2 operands )
		//ternary exp1 ? exp2 : exp3 ( 3 operands )
	
	//in C++ if either operand is a floating point the result is a floating point number
	cout << 13 / 5; // both are int so the result is an int
	//displays 2
	cout << 91.0 / 7; // one is a floating point so the result is a floating point
	//displays 13.0
	//this is the opposite of java

	//Constants
	//named constants numbers which will not change during execution are represented in all caps and withe const before
	const double TAX_RATE = 0.0675;



}