/*
* Author's Name: Ben Halpern
* Program Name:  Halpern_Project4_QuadraticEquation.cpp
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
*	SEE ASSIGNMNET WORKSHEET :
*	https://rsccd.instructure.com/courses/50692/files/5391984/download?download_frd=1
*	Note the link above is a download link
*/

//Program flow
//algorithm comments will be included above each section or function
//create four parts of functions:
//	function to getCoefficient: if the leading coefficient is a non-zero calculate and report the solutions
//		this will be done in the main function
//	function to getDiscriminent: calculates the discriminent
//	funtion getQuad: evaluates
//	function getNumberOfSolutions: number of soluations is based off the discriminent 
//		Then three functions based off the answer given by getDiscriminent:
//		function to ifImaginary
//		function to ifZero
//		function to ifPositive
//


#include <iostream>		//input output stream. Preprocessor command to include the input output stream library
#include <cmath>		//needed for the pow() function
#include <iomanip>
//#include <string>
//#include <cstdlib>	//not used and when included casues the cout and cin to be marked by intellisence as missing 
using namespace std;	//using the standard library ( allows to display simply cout and cin instead of std::cout or std::cin )

//instantiation and initialization of a global variable
double glob_Coeff = double(); //generally defaults to 0, will let the double() function initialize

int numOfSolutions(double discriminent) {//takes discriminent for comparison of solutions
	//initialize local varaible 
	double a = discriminent;//shorter identifier name for visibilitiy
	//end variable initialization

	if (a > 0.0) {		//if discriminent is greater than zero (positive)(double comparison)
		return 2;		//number of solutions is 2
	}//end if
	else if (a == 0.0) {	//if discriminent is equal to zero (double)
		return 1;		//number of solutions is 1
	}//end else if
	else{				//if discriminent is less than zero (negative)
		return -2;		//number of solutions is 2 imaginary solutions
	}//end else
}//end numOfSolutions


//getDiscriminent @args double a, double b, double c
double getDiscriminent(double a,double b, double c) {//takes the 3 coefficients of the quadratic equation. 
	//passes parameters to local varaibles and implicitly converts to double
	//the following produces error code C2082 : redefinition of a formal parameter
	//double a = a;
	//double b = b;
	//double c = c;
	double discriminent = double();
	//end variable initialization

	//The discriminent is calculated by the following equation :
	//B ^ 2 - 4AC = Discriminent

	//Algorithm:
	//take in a,b,c
	//use the pow() function to get the value of b^2 
	//then multiply a and c by 4, 
	//then subtract from b^2
	//PEMDAS
	//solving for pow(B,2) - (4 * A * C)
	
	discriminent = (pow(b, 2)) - ((4.0) * a * c);		//the formula for the discriminent
	return discriminent;								//returns the discriminent
}//end getDiscriminent


//ifImaginary @args double a, double b, double c; loads globCoeff Global Variable
double ifImaginary(double a, double b, double c) {//takes in 3 double parameters 
	//instatiate parameters as local variables
	//the following produces error code C2082 : redefinition of a formal parameter
	//double a = a;
	//double b = b;
	//double c = c;
	double discriminent;
	//instatiate and initialize result variable
	double result = double();
	//end varaible instatiation

	//If the discriminent is negative, convert to positive and complete the quadratice equation that way
	//note in the display report the format will be (b^2)/2a +/- sqrt(disriminent)/2a
	//this function will only produce the second half of the display
	//may load the first half into a global variable

	//Algorithm
	//x = (-B + Sqrt(B^2 - 4AC))/2A		or			x = (-B - Sqrt(B^2 - 4AC))/2A
	//calls discriminent fuction (assuming the value is negative) checks and converts to positive
	//if by error the value is not negative, pass to another function
	//calculate with positive discriminent
	//return the second half of the equation
	//solving for sqrt(pow(B,2) - (4 * A * C)) / (2 * A)
	//(-B / (2*A) ) is loaded into the global varriable


	if (getDiscriminent(a, b, c) < 0.0) {//if discriminent is less than zero ( 2 imaginary solutions ) 
	//if (numOfSolutions(getDiscriminent(a,b,c) == -2 )			//alternatively could use numOfSolutions as well
		
		discriminent = getDiscriminent(a, b, c);
		discriminent *= (-1);									//produces a positive discriminent
	
	}//end if
	else {//if discriminent is not zero and was incorrectly passed to the ifZero function
	
		cout << "The discriminent was already positive, please check for an error and that the program is flowing correctly"; //debugging
		return 0;												//exits function, note may disrupt calulations so message is outputed along with
	
	}//else if 
	result = (sqrt(discriminent) / (2.0 * a));

	//Global Variable set
	glob_Coeff = (((-1.0 * b)) / (2.0 * a));					//this can be removed to make function not dependent on Global Variable and it can be calculated elsewhere
	//end Global Variable set
	
	return result;												//returns the second half of the equation
}//end ifImaginary


//ifPositive @args double a, double b, double c; loads globCoeff Global Variable
double ifPositive(double a, double b, double c) {//takes in 3 double parameters, int inputted will be implicitly converted to doubles
	//instatiate parameters as local variables
	//the following produces error code C2082 : redefinition of a formal parameter
	//double a = a;
	//double b = b;
	//double c = c;
	double discriminent;
	//instatiate and initialize result variable
	double result = double();
	//end varaible instatiation

	//If the discriminent is positive, load variable discriminent

	//Algorithm
	//x = (-B + Sqrt(B^2 - 4AC))/2A		or			x = (-B - Sqrt(B^2 - 4AC))/2A
	//calls discriminent fuction (assuming the value is positive) 
	//if by error the value is not positive, pass to another function/ display message
	//calculate with positive discriminent
	//this function will produce only the second half of the equation, the final display caluculation will be done before the report
	//solving for sqrt(pow(B,2) - (4 * A * C)) / (2 * A)
	//(-B / (2*A) ) is loaded into the global varriable

	if (getDiscriminent(a, b, c) > 0.0) {//if discriminent is greater than zero ( 2 real solutions ) 
	//if (numOfSolutions(getDiscriminent(a,b,c) == 2 )			//alternatively could use numOfSolutions as well
	
		discriminent = getDiscriminent(a, b, c);

	}//end if
	else {//if discriminent is not positive and was incorrectly passed to the ifZero function
	
		cout << "The discriminent is negative or 0, please check for an error and that the program is flowing correctly"; //debugging
		return 0;												//exits function, note may disrupt calulations so message is outputed along with
	
	}//else if 
	result = (sqrt(discriminent) / (2.0 * a));
	
	//Global Variable set
	glob_Coeff = (((-1.0 * b)) / (2.0 * a));					//this can be removed to make function not dependent on Global Variable and it can be calculated elsewhere
	//end Global Variable set

	return result;												//returns the second half of the equation
}//end ifPositive


//ifZero @args double a, double b, double c; loads globCoeff Global Variable
double ifZero(double a, double b, double c) {//takes in 3 doub;e parameters, int inputted will be implicitly converted to doubles
	//instatiate parameters as local variables
	//the following produces error code C2082 : redefinition of a formal parameter
	//double a = a;
	//double b = b;
	//double c = c;
	double discriminent = double();
	//instatiate and initialize result variable
	double result = double();
	//end varaible instatiation

	//If the discriminent is zero, load variable discriminent

	//Algorithm
	//x = (-B + Sqrt(B^2 - 4AC))/2A		or			x = (-B - Sqrt(B^2 - 4AC))/2A
	//calls discriminent fuction (assuming the value is zero) 
	//if by error the value is not zero, pass to another function/ display message
	//works the equation above, really only solving for (-B / 2A)
	
	discriminent = getDiscriminent(a, b, c);
	if (discriminent == 0.0) {//if discriminent is equal to zero ( 1 real solutions ) 
	//if (numOfSolutions(getDiscriminent(a,b,c) == 0 )	//alternatively could use numOfSolutions as well

		
		result = (((-1.0 * b) - (discriminent) )/ (2.0 * a));		//discriminent value should be 0, put in equation to fit algorithm and for readability

	}//end if
	else {//if discriminent is not zero and was incorrectly passed to the ifZero function

		cout << "The discriminent is positive or negative, please check for an error and that the program is flowing correctly"; //debugging
		return 0;													//exits function, note may disrupt calulations so message is outputed along with

	}//else if 
	

	return result;													//returns the second half of the equation
}//end ifZero


//start of main
int main() {//main class

	//Declaration of variables:
	//initialization and instatiation.
	double a = double();
	double b = double();
	double c = double();
	double discriminent = double();
	int switchCount = int();
	double result = double();
	double loc_Coeff = double();
	//string solutionStatement1 = string();
	//string solutionStatement2 = string();
	//End Declaration of variables

	//logic flow:
	//1) get coeffecients from user
	//2) using conditional statments check if the values of the discriminent are positve negative or 0
	//		then forward to their respectable functions
	//3) calculate the second half of the answer
	//4) output to the screen (in scientific notation) the answer and the report
	
	/*
	*The quadratic formula is calculated by the following equation:
	*	x = (-B + Sqrt(B^2 - 4AC))/2A		or			x = (-B - Sqrt(B^2 - 4AC))/2A
	*
	*The discriminent is calculated by the following equation:
	*	B^2 - 4AC = Discriminent
	*/



	//HOMEWORK HEADER
	//program header
	cout << "=====================================================================" << endl;
	cout << endl;									//blank line for readability
	cout << "Author's Name: Ben Halpern" << endl;
	//displays Authors Name, followed by an end-line command, printing the next line on a new line
	cout << "Program Name :  Halpern_Project4_QuadraticEquation.cpp" << endl;
	//displays Program Name, followed by an end-line command, printing the next line on a new line
	cout << "Date : October 1, 2020 " << endl;
	//display's date, followed by an end-line command, printing the next line on a new line
	cout << "College Name : Santa Ana College(SAC)" << endl;
	//displays College Name, followed by an end-line command, printing the next line on a new line
	cout << endl;									//blank line for readability
	cout << "=====================================================================" << endl;
	cout << endl;

	//report header
	//cout << fixed << setprecision(4) << scientific;//format is 0.000E+00
	cout << "This program will provide solutions for an equation of the form" << endl;
	cout << setw(42) << right << "A*x^2 + B*x + C = 0," << endl;
	cout << "where A, B, and C are integers and A is not equal to zero." << endl;
	cout << endl;									//blank line for readability
	//end report header

	//get user input
	cout << "Please enter the following with a space between each input" << endl;
	cout << "Enter A, B, and C: ";
	cin >> a >> b >> c;								//loads user input into variables a,b,c . The variables are doubles so they user input is able to be directly used in the calculations
	cin.ignore();									//to eat up the \n at the end of the line
	//check if leading coefficient is zero
	if (a == 0) {//if a is 0, the leading coefficient is zero
		cout << "No solutions wil be calculated for a leading coefficient of 0 !" << endl;
		cout << endl;								//blank line for visibility

	}//end if
	else {//if the leading coefficient is not 0 proceed
		//end user input

		//temp
		//a	= 2;
		//b = -5;
		//c = -3;
		//end temp

		discriminent = getDiscriminent(a, b, c);
		switchCount = numOfSolutions(discriminent);
	
		//Nested switch inside if - else statment
		//selected the options using a switch, see code commented out below for use with if and else
		switch (switchCount) {
		case (2)://two positive solutions
			result = ifPositive(a, b, c);
			loc_Coeff = glob_Coeff;					//loads Global Variable to Local Variable
			glob_Coeff = 0;	//resets global variable

			cout << fixed << setprecision(4) << scientific;//format is 0.000E+00
			//left sets the associativity to left hand side
			//setw(n) gives the output the width of n
			cout << setw(33) << left << "The two real solutions are ";
			cout << setw(5) << right << " X =  ";
			cout << setw(11) << right << (loc_Coeff + result) << endl;
			cout << setw(26) << right << " and";
			cout << setw(12) << right << " X =  ";
			cout << setw(11) << right << (loc_Coeff - result) << endl;
			cout << endl;							//blank line for visibility
			//end output for the report

			break;
		case (1):
			result = ifZero(a, b, c);

			cout << fixed << setprecision(4) << scientific;//format is 0.000E+00
			//left sets the associativity to left hand side
			//setw(n) gives the output the width of n
			cout << setw(33) << left << "The one real solutions is ";
			cout << setw(5) << right << " X =  ";
			cout << setw(11) << right << result << endl;
			cout << endl;							//blank line for visibility
			//end output for the report

			break;
		case (-2):
			result = ifImaginary(a, b, c);
			loc_Coeff = glob_Coeff;					//loads Global Variable to Local Variable
			glob_Coeff = 0;//resets global variable
			cout << fixed << setprecision(4) << scientific;//format is 0.000E+00
			//left sets the associativity to left hand side
			//setw(n) gives the output the width of n
			//they are broken up upon multiple lines so each can have a set width of their own and visibility
			cout << setw(33) << left << "The two imaginary solutions are ";
			cout << setw(5) << right << " X =  ";
			cout << setw(11) << right << loc_Coeff;
			cout << setw(8) << right << "+  ( ";
			cout << setw(11) << right << result;
			cout << setw(5) << right << ") *I" << endl;
			//second value in the pair
			cout << setw(33) << right << "and  ";
			cout << setw(5) << right << " X =  ";
			cout << setw(11) << right << loc_Coeff;
			cout << setw(8) << right << "-  ( ";
			cout << setw(11) << right << result;
			cout << setw(5) << right << ") *I" << endl;
			cout << endl;							//blank line for visibility
			//end output of report

			break;
		}//end switch
	}//end else

	//end of program termination statement
	cout << "Press ENTER to terminate .  .  .";
	cin.get();
	//end of program

	return 0; //returns to the system 0 if succesfull , not neccesary for int main () but it is good practice
	

	//#########################################################################################################
	//Here is the program without outside functions and with nested if else if else instead of a switch
	//#########################################################################################################
	/*double a = double();
	double b = double();
	double c = double();
	double discriminent = double();
	int solutions = int();
	double result = double();
	double loc_Coeff = double();
	*/
	////
	////report header
	////cout << fixed << setprecision(4) << scientific;//format is 0.000E+00
	//cout << "This program will provide solutions for an equation of the form" << endl;
	//cout << setw(42) << right << "A*x^2 + B*x + C = 0," << endl;
	//cout << "where A, B, and C are integers and A is not equal to zero." << endl;
	//cout << endl;							//blank line for readability
	////end report header

	////get user input
	//cout << "Enter A, B, and C: ";
	//cin >> a >> b >> c;						//loads user input into variables a,b,c
	//cin.ignore();							//to eat up the \n at the end of the line
	////check if leading coefficient is zero
	//if (a == 0) {//if a is 0, the leading coefficient is zero
	//	cout << "No solutions wil be calculated for a leading coefficient of 0 !" << endl;
	//	cout << endl;						//blank line for visibility

	//}//end if
	//else {//if the leading coefficient is not 0 proceed
	//	//end user input

	//	//temp
	//	//a	= 2;
	//	//b = -5;
	//	//c = -3;
	//	//end temp

	//	//discriminent = getDiscriminent(a, b, c);
	//	//switchCount = numOfSolutions(discriminent);
	//	
	//	//double a = discriminent;//shorter identifier name for visibilitiy
	//	//set of conditional statements to check number of solutions ( optional, can be done along with nexted if statement below )
	//	if (discriminent > 0.0) {		//if discriminent is greater than zero (positive)(double comparison)
	//		solutions = 2;		//number of solutions is 2
	//	}//end if
	//	else if (discriminent == 0.0) {	//if discriminent is equal to zero (double)
	//		solutions = 1;		//number of solutions is 1
	//	}//end else if
	//	else {				//if discriminent is less than zero (negative)
	//		solutions = -2;		//number of solutions is 2 imaginary solutions
	//	}//end else
	//****************************************************
	//	//use with nested if ... else-if
	//****************************************************
	//
	//	if(solutions == 2 || discriminenet > 0.0){//two positive solutions
	//		result = ((sqrt(discriminent)) / (2 * a));
	//		loc_Coeff = ((-1.0 * b)/(2 * a )); //glob_Coeff;					//loads Global Variable to Local Variable
	//		//glob_Coeff = 0;	//resets global variable

	//		cout << fixed << setprecision(4) << scientific;//format is 0.000E+00
	//		//left sets the associativity to left hand side
	//		//setw(n) gives the output the width of n
	//		cout << setw(33) << left << "The two real solutions are ";
	//		cout << setw(5) << right << " X = ";
	//		cout << setw(11) << right << (loc_Coeff + result) << endl;
	//		cout << setw(26) << right << " and";
	//		cout << setw(12) << right << " X = ";
	//		cout << setw(11) << right << (loc_Coeff - result) << endl;
	//		cout << endl;							//blank line for visibility
	//		//end output for the report

	//	}//end if
	//	else if ( solutions == 1  || discriminent == 0.0){
	//		result = ((-1.0 * b) / (2 * a)) + ((sqrt(discriminent))/ (2 * a ));
	//		//right side of equation evaluates to 0
	//		cout << fixed << setprecision(4) << scientific;//format is 0.000E+00
	//		//left sets the associativity to left hand side
	//		//setw(n) gives the output the width of n
	//		cout << setw(33) << left << "The one real solutions is ";
	//		cout << setw(5) << right << " X =  ";
	//		cout << setw(11) << right << result << endl;
	//		cout << endl;							//blank line for visibility
	//		//end output for the report

	//	}//end else if
	//	else if ( solutions == -2 || discriminent < 0.0){
	//		result = ((sqrt((-1.0 * discriminent))) / (2 * a));
	//		loc_Coeff = ((-1.0 * b) / (2 * a));//glob_Coeff;					//loads Global Variable to Local Variable
	//		//glob_Coeff = 0;//resets global variable
	//		cout << fixed << setprecision(4) << scientific;//format is 0.000E+00
	//		//left sets the associativity to left hand side
	//		//setw(n) gives the output the width of n
	//		cout << setw(33) << left << "The two imaginary solutions are ";
	//		cout << setw(5) << right << " X =  ";
	//		cout << setw(11) << right << loc_Coeff;
	//		cout << setw(8) << right << "+  ( ";
	//		cout << setw(11) << right << result;
	//		cout << setw(5) << right << ") *I" << endl;
	//		//second value in the pair
	//		cout << setw(33) << right << "and  ";
	//		cout << setw(5) << right << " X =  ";
	//		cout << setw(11) << right << loc_Coeff;
	//		cout << setw(8) << right << "-  ( ";
	//		cout << setw(11) << right << result;
	//		cout << setw(5) << right << ") *I" << endl;
	//		cout << endl;							//blank line for visibility
	//		//end output of report

	//		
	//	}//end else if
	//	else
	//		cout << "An error occured check the code in the nested if else staments";//debugging
	//}//end else

	////end of program termination statement
	//cout << "Press ENTER to terminate .  .  .";
	//cin.get();
	//#########################################################################################################
	//End program example without functions
	//#########################################################################################################

}//End of main()
//EOF