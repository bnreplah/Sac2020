/*
* Author's Name: Ben Halpern
* Program Name: Project-1-BenHalpern.cpp
* Date: September 5, 2020
* College Name: Santa Ana College (SAC)
*
* Assignment details:
*
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
* Author's Name, e.g., Tahir Aziz
*
* Program Name, e.g., Aziz_Assign1_Salary.cpp
*
* Date, e.g., Feb. 23, 2020
*
* College Name, e.g., Santa Ana College (SAC)
*/

#include <iostream>		//input output stream. Preprocessor command to include the input output stream library
using namespace std;	//Using the standard library

int main() {			//main class

	//program header
	cout << "Author's Name: Ben Halpern" << endl;
	//Displays Authors Name, followed by an end-line command, printing the next line on a new line
	cout << "Program Name : Project - 1 - BenHalpern.cpp" << endl;
	//Displays Program Name, followed by an end-line command, printing the next line on a new line
	cout << "Date : September 5, 2020" << endl;
	//Display's date, followed by an end-line command, printing the next line on a new line
	cout << "College Name : Santa Ana College(SAC)" << endl;
	//Displays College Name, followed by an end-line command, printing the next line on a new line
	cout << endl;		//Blank line for readability

	//Request the users inout on the following:
	//Employee ID				(integers)
	//Number of hours worked	(double)
	//Rate per hour				(double)

	//instantiation:
	int employeeId;		//Creates a integer variable space for employeeId
	double hoursWorked;	//Create a double variable space for hoursWorked
	double ratePerHour;	//Creates a double variable space for ratePerHour


	//INPUT
	//#################################################
	//Prompts user:
	cout << "Please enter your Employee ID: ";
	cin >> employeeId;
	cout << "Please enter the number of hours worked ( weekly ): ";
	cin >> hoursWorked;
	cout << "Please enter the rate per hour: $";
	cin >> ratePerHour;

	//Processing: Proceesing the information the User inputed to calcualte the gross salary
	//Gross pay is equal to ratePerHour times the hoursWorked ( without overtime )
	//Gross pay with overtime is the Gross pay( for 40 hours worked ) + (( hoursWorked - 40) times ratePerHour times 1.5 ( or 2 depending on the overtime ))

	//gross pay algorithm:
	double gross = ratePerHour * hoursWorked;
	//Creates the algorithm mentioned above ( line 67 - 70) and calculates the basic Gross pay

//OUTPUT
//################################################
	cout << "Your Employee ID is: " << employeeId << endl;
	cout << "Your hours worked this week are: " << hoursWorked << " Hours" << endl;
	cout << "Your rate per hour is: $" << ratePerHour << " per hour" << endl;
	cout << "Your Gross pay is: $" << gross << endl;
	cout << endl;		//empty space for readibility
	//Showing work for gross pay
	cout << "Gross pay calculation:" << endl;
	cout << hoursWorked << " * " << ratePerHour << " = Gross Pay" << endl;
	cout << "Gross Pay = " << gross;



}//EOF