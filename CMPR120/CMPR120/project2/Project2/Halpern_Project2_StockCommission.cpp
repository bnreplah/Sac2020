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
* 
* 
* 
*/

#include <iostream>		//Input output stream. Preprocessor command to include the input output stream library

using namespace std;	//Using the standard library ( allows to display simply cout and cin instead of std::cout or std::cin )


int main() {					//main class
	//cin is request input from user
	//cout is output to the screen
	//endl is endline 
	//';' ends a statment
	//variables declared with camelHump notation
	//int refers to integer
	//double refers to decimal number or floating point number

	//Program Title
	cout << "####################   Stock Commission   ####################" << endl;
	//Displays the title of the program to the screen

	//Program header
	cout << "=====================================================================" << endl;
	cout << endl;		//Blank line for readability
	cout << "Author's Name: Ben Halpern" << endl;
	//Displays Authors Name, followed by an end-line command, printing the next line on a new line
	cout << "Program Name : Halpern_Project2_StockCommission.cpp" << endl;
	//Displays Program Name, followed by an end-line command, printing the next line on a new line
	cout << "Date : September 12, 2020" << endl;
	//Display's date, followed by an end-line command, printing the next line on a new line
	cout << "College Name : Santa Ana College(SAC)" << endl;
	//Displays College Name, followed by an end-line command, printing the next line on a new line
	cout << endl;		//Blank line for readability
	cout << "=====================================================================" << endl;

	//Request the users input on the following:
	//Amount of Shares				(integers)
	//Amount per stock				(double)
	//Rate of commision				(double)


	//Instantiation:
	int amountOfShares = int();		//Creates a integer variable space for amountOfShares ( Amount of Shares)
	double costPerStock= double();	//Create a double variable space for costPerStock ( Cost per Share )
	double rateOfComm = double();	//Creates a double variable space for rateOfComm ( Rate of Commission )
	double grossCost = double();	//Creates a double variable space for grossCost ( Gross Cost )
	double grossComm = double();	//Creates a double variable space for grossComm ( Gross Commision )
	double grossCostWOComm = double(); //Creates a double variable space for grossCostWOComm ( Gross Cost without Commision )

// INPUT
//#################################################
	//Prompts user 
	cout << endl;		//Blank line for readibility
	while (true)
	{
		cout << "Please enter your Amount of Shares ( up to 9 digits ): ";
		//Prompts user for the Amount of Shares
		cin >> amountOfShares;	//note: is subject to buffer overflow if user inputs more than 9 digits
		if (amountOfShares > 0 && amountOfShares <= 2147483647   ) {//makes sure is in viable range of an int
			break;
		}//end if
		else {
			cout << " Please enter a number of shares in the range of 0 - 2,147,483,647" << endl;
		}
		//else continues to loop
	}//end of while
	
	cout << "Please enter the Amount per Share ( Stock price ): ";
	//Prompts user for the cost per stockholder share 
	cin >> costPerStock;
	cout << "Please enter the commision rate (ie: 0.02 is 2%): ";
	//Prompts user for the rate of  commision paid
	cin >> rateOfComm;
	cout << endl;		//Blank line for readibility
	cout << "=====================================================================" << endl;

	//Gross Cost of shares ( without commision ) algorithm
	//		Amount of Shares * the Cost per Stock = Gross Cost of Shares
	//Gross Cost of Commision
	//		Gross Cost of Shares * Rate per Commision = Gross Cost of Commision

	//Processing
	grossCostWOComm = double(amountOfShares) * costPerStock;
	grossComm = (grossCostWOComm * rateOfComm);
	grossCost = grossCostWOComm + grossComm;

// OUTPUT
//################################################
	cout << "The amount paid for the stock alone ( without commision ): $" << grossCostWOComm << endl;
	cout << "The cost of commision: $" << grossComm << endl;
	cout << "Gross Cost: $" << grossCost <<  endl;
	cout << endl;		//empty space for readibility
	return 0;//ends program
}//EOF