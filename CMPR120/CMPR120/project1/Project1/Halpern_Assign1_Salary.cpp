/*
* Author's Name: Ben Halpern
* Program Name:  Halpern_Assign1_Salary.cpp
* Date: September 5, 2020
* College Name: Santa Ana College (SAC)
* CMPR 120 
* Professor Aziz
*####################################################
* Assignment details:
*####################################################
*A. Get the user input for the following information:
*
*	Employee ID (integers)
*	Number of hours worked (double)
*	Rate per hour (double)
*
*B. Display the following (with appropriate headings):
*
*	EmployeeID
*	HoursWorked
*	RatePerHour
*	GrossSalary
*
*C. Program header is required. The following information is suggested for the program header:
*
*	Author's Name, e.g., Tahir Aziz
*	Program Name, e.g., Aziz_Assign1_Salary.cpp
*	Date, e.g., Feb. 23, 2020
*	College Name, e.g., Santa Ana College (SAC)
*/

#include <iostream>		//Input output stream. Preprocessor command to include the input output stream library
using namespace std;	//Using the standard library ( allows to display simply cout and cin instead of std::cout or std::cin )

int main() {			//main class
	//cin is request input from user
	//cout is output to the screen
	//endl is endline 
	//';' ends a statment
	//variables declared with camelHump notation
	//int refers to integer
	//double refers to decimal number or floating point number

	//Program Title
	cout << "####################   Employee Salary Records   ####################" << endl;
	//Displays the title of the program to the screen

	//Program header
	cout << "=====================================================================" << endl;
	cout << endl;		//Blank line for readability
	cout << "Author's Name: Ben Halpern" << endl;
	//Displays Authors Name, followed by an end-line command, printing the next line on a new line
	cout << "Program Name : Halpern_Assign1_Salary.cpp" << endl;
	//Displays Program Name, followed by an end-line command, printing the next line on a new line
	cout << "Date : September 5, 2020" << endl;
	//Display's date, followed by an end-line command, printing the next line on a new line
	cout << "College Name : Santa Ana College(SAC)" << endl;
	//Displays College Name, followed by an end-line command, printing the next line on a new line
	cout << endl;		//Blank line for readability
	cout << "=====================================================================" << endl;

	//Request the users inout on the following:
	//Employee ID				(integers)
	//Number of hours worked	(double)
	//Rate per hour				(double)


	//Instantiation:
	int employeeID;		//Creates a integer variable space for employeeID ( Employee ID)
	double hoursWorked;	//Create a double variable space for hoursWorked  ( Hours Worked per Week )
	double ratePerHour;	//Creates a double variable space for ratePerHour ( Rate per Hour )
	double grossSalary;	//Creates a double variable space for grossSalary ( Gross Salary )

//INPUT
//#################################################
	//Prompts user	
	cout << endl;		//Blank line for readibility
	cout << "Please enter your Employee ID ( up to 9 digits ): ";
						//Prompts user for the Employee ID
	cin >> employeeID;	//note: is subject to buffer overflow if user inputs more than 9 digits
	cout << "Please enter the number of hours worked ( weekly ): ";
						//Prompts user for the number of hours worked during the week
	cin >> hoursWorked;
	cout << "Please enter the rate per hour: $";
						//Prompts user for the rate per hour paid
	cin >> ratePerHour;
	cout << endl;		//Blank line for readibility
	cout << "=====================================================================" << endl;

	//Processing: Proceesing the information the User inputed to calcualte the gross salary
	//Gross pay is equal to ratePerHour times the hoursWorked ( without overtime )
	//Gross pay with overtime is the Gross pay( for 40 hours worked ) + (( hoursWorked - 40) times ratePerHour times 1.5 ( or 2 depending on the overtime ))

	//Gross pay algorithm:
	grossSalary = ratePerHour * hoursWorked;
	//Creates the algorithm mentioned above ( line 67 - 70) and calculates the basic Gross pay

//OUTPUT
//################################################
	cout << "Employee ID: " << employeeID << endl;
	cout << "Hours Worked: " << hoursWorked << " Hours" << endl;
	cout << "Rate per Hour: $" << ratePerHour << "/hour" << endl;
	cout << "Gross Salary: $" << grossSalary << "/week" << endl;
	cout << endl;		//empty space for readibility

	//Showing work for gross pay -- Debugging purposes:
	//cout << "Gross pay calculation:" << endl;
	//cout << hoursWorked << " * " << ratePerHour << " = Gross Pay" << endl;
	//cout << "Gross Pay = $" << grossSalary ;



}//EOF -- End Of FILE --