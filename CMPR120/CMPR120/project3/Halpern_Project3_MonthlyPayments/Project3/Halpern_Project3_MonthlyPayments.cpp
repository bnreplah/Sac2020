/*
* Author's Name: Ben Halpern
* Program Name:  Halpern_Project3_MonthlyPayments.cpp
* Date: September 18, 2020
* College Name: Santa Ana College (SAC)
* CMPR 120
* Professor Aziz
* 
* 
* 
*####################################################
* Assignment details:
*####################################################
*Please complete programming exercise #19 from chapter-3:
*""" The monthly payment on a loan may be calucalted by the following formula:
* payment = (Rate * (1 + Rate) ^ N ) / (((1 + Rate ) ^ N ) - 1)
* Where Rate is the monthly interest rate, which is the annual interest rate divided by 12 
* (12 percent annual interest would be 1 percent monthly interest.)
* N is the number of payments, and L is the amount of the loan. Write a program that asks for these values then displays a report
* similar to:
* 
* Loan Amount:					$ 10000.00
* Monthly Interest Rate:				1%
* Number of Payments:					36
* Monthly Payment:				$   332.14
* Amount Paid Back:				$ 11957.15
* Interest Paid:				$  1957.15
*"""
*/

#include <iostream>		//input output stream. Preprocessor command to include the input output stream library
#include <cmath>
#include <iomanip>
//#include <cstdlib>	//not used and when included casues the cout and cin to be marked by intellisence as missing 
using namespace std;	//using the standard library ( allows to display simply cout and cin instead of std::cout or std::cin )


int main() {					//main class
	//cin is request input from user
	//cout is output to the screen
	//endl is endline 
	//';' ends a statment
	//variables declared with camelHump notation
	//int refers to integer
	//double refers to decimal number or floating point number

	//Algorithm:
	//monthly payments on a loan can be calculated by the following algorithm
	//monthly payment rate = ( rate * (1 + rate)^N )/((1+rate)^N - 1)
	//rate is the monthly interest rate, which is the annual interest rate divided by 12 ( ie: 12 percent anual interest would be 1 percent monthly interest )
	//where N is the amount of payments, and L is the amount of the loan 
	//Using the example from the text, use the monthly payment rate and multiply it by the overall loan amount ( or remaining balance ) resulting in the monthly interest rate
	//multiply that interest rate that was found in the equation above by the amount of months, results in the overall amount of payment ( loan + interest )
	//subtract the loan amount, to get the overall interest that is paid

	//request user input on anual rate ( which is divided by 12)
	//request user input on number of payments
	//request user input on loan amount

	//request the users input on the following :
	//annualRate				(double)
	//numOfPayments				(integer)
	//loanAmount				(double)

	//initialization and instatiation of variables
	double annualRate = double();					// rate in the equation over a year divided by 12 to produce monthly rate
	int numOfPayments = int();						// request int from user, later convert ot double in calculations
	double loanAmount = double();					// overall loan amount
	//end user inputed variables
	double monRate = double();						// annual rate divided by 12
	double monPayRate = double();					// the result of the equation described in the algorithm, to be multiplied by the loanAmount
	double monPayment = double();					// the result of the monPayRate in the algorithm multiplied by the loanAmount
	double grossPayment = double();					// the result of the multiplication of the monPayment times the numOfPayments
	double grossIntrest = double();					// the result of the grossPayment subtracted from the initial loanAmount
	bool annualRateFormat = bool();
	//end variable initilization and instatiation
	
	//program Title
	cout << "####################################################################" << endl;
	cout << "#######################   Monthly Payments   #######################" << endl;
	cout << "####################################################################" << endl;
	cout << endl;									//blank line for visibility
	//displays the title of the program to the screen

	//program header
	cout << "=====================================================================" << endl;
	cout << endl;									//blank line for readability
	cout << "Author's Name: Ben Halpern" << endl;
	//displays Authors Name, followed by an end-line command, printing the next line on a new line
	cout << "Program Name : Halpern_Project3_MonthlyPayments.cpp" << endl;
	//displays Program Name, followed by an end-line command, printing the next line on a new line
	cout << "Date : September 18, 2020" << endl;
	//display's date, followed by an end-line command, printing the next line on a new line
	cout << "College Name : Santa Ana College(SAC)" << endl;
	//displays College Name, followed by an end-line command, printing the next line on a new line
	cout << endl;									//blank line for readability
	cout << "=====================================================================" << endl;
	cout << endl;									//blank line for readability
	
	//queries user for desired format of annual interest rate
	for (int input = 3; !(input == 1 || input == 0) ; ) {//loops until input is either 1 or 0
		cout << "How would you like to input the annual interest rate \nas a decimal or as a percent? ( input 0 for decimal and 1 for percent ):  ";//written over two lines
		cin >> input;
		//cout << input << endl;		 // debugging purposes
		if (input == 1) {
			annualRateFormat = true; // if the input is 1 set annualRateFormat to true
			break;					 // breaks out of loop if input == 1
		}//end if 
		else if (input == 0) {
			annualRateFormat = false; // if the input is 0 set the annualRateFormat to false
			break;					  // breaks loop if input == 0
		}//end else if
	}//end for

	do {//loops to make sure is within data type range and doesn't become victim to an overflow
		cout << setw(50) << left << "Please enter the annual interest rate:";
		if (annualRateFormat) {// if the user requested to input as a percent dispaly the percent symbol
			cout << "%";
		}//end if
		cin >> annualRate;
		if ( annualRate <= static_cast<double>(0)) {//prompts user to enter a value within the compatible range 
			cout << " Please input a value within the range 0.00 and " << 1.7E308 << " ( greater than 0 )" << endl;
		}//end if
	} while ( annualRate <= static_cast<double>(0)); //implicit conversion from the int 0 to the double to meet annual rate
																//loops if the rate is outside of the possible range for a double and is greater than 0
																//can't have a negative value for the annual rate
	//end do while

	do {//loops to make sure is within data type range and doesn't become victim to an overflow
		cout << setw(50) << left << "Please enter the number of payments:";
		cin >> numOfPayments;
		if ( numOfPayments <= 0) {//prompts user to enter a value within the compatible range 
			cout << " Please input a value within the range 0 and " << 2147483647 << " ( greater than 0 )" << endl;
		}//end if
	} while ( numOfPayments <= 0);
	//end do while

	do {//loops to make sure is within data type range and doesn't become victim to an overflow
		cout << setw(50) << left << "Please enter the total loan amount:";
		cout << "$";
		cin >> loanAmount;
		if ( loanAmount <= static_cast<double>(0)) {
			cout << " Please input a value within the range 0.00 and " << 1.7E308 << " ( greater than 0 )" << endl;
		}//end if
	} while (loanAmount <= static_cast<double>(0));
	//end do while

	//annualRateFormat = true : percent
	//annualRateFormat = false : decimal

	if (annualRateFormat) {// if annualRateFormat is true : the user inputed a interest rate as a percent not a decimal
		//converting from a percent to a decimal for the calculation, and then into the monthly interest rate monRate
		//converting from a percent to a decimal for the calculation, and then into the monthly interest rate monRate
		monRate = annualRate / static_cast<double>(12 * 100);		// written out for readability
																	//needs to be casted otherwise implicit casting will occur and create and mess up the calculations
	}//end if
	else {//if annualRateFormat is false, the user is requsting to input the interest rate as a decimal not a percent, convert the annual rate to a monthly rate by dividing by 12 months
		monRate = annualRate / static_cast<double>(12); //explicit conversion, if annualRate = 0.12; monRate = 0.01
	}//end else

	//algorithm
	monPayRate = ((monRate * pow((1 + monRate), static_cast<double>(numOfPayments))) / (pow((1 + monRate), static_cast<double>(numOfPayments)) - 1)); //implicit conversion and explicit conversion providing an example of 
	monPayment = monPayRate * loanAmount;
	grossPayment = monPayment * numOfPayments;
	grossIntrest = grossPayment - loanAmount;
	monRate *= 100; // multiplies monRate to be ready to be displayed as a percentage and not a decimal
	
	cout << endl;																	//blank line for readability
	//only uses setprecision() in dipslay so the calculations are more accurate
	cout << fixed << setprecision(2);												//keeps decimals to two decimal places
	cout << "###########################################################################" << endl;
	cout << endl;																	//blank line for readability

	cout << setw(50) << left << "Loan Amount:";
	cout << "$" <<setw(10) << right <<loanAmount << endl;							//outputs the loanAmount ( loan amount ) 
	cout << setw(50) << left << "Monthly Interest Rate:";
	if(static_cast<int>(monRate) == 0)
		cout << setw(10) << right << monRate << "%" << endl;							//outputs the monthly interest rate as a percentage as a double since it is so small and if it were casted as an int would equate to 0
	//end if
	else
		cout << setw(10) << right << (static_cast<int>(monRate)) << "%" << endl;		//outputs the monthly interest rate if the integer value doesn't equate to 0 ( casts it as an int first )
	//end else
	cout << setw(50) << left << "Number of Payments:";								
	cout << setw(11) << right << numOfPayments << endl;								//outputs the numOfPayments	( number of payments )
	cout << setw(50) << left << "Monthly Payment:";
	cout << "$" << setw(10) << right << monPayment << endl;							//outputs the  monPayment ( monthly payment )
	cout << setw(50) << left << "Amount Paid Back:";
	cout << "$" << setw(10) << right << grossPayment << endl;						//outputs the grossPayment ( total needs to be paid )
	cout << setw(50) << left << "Interest Paid:";
	cout << "$" << setw(10) << right << grossIntrest << endl;						//outputs the grossInterest ( total interest )
	cout << endl;																	//blank line for readability
	cout << "############################################################################" << endl;
	return 0; //returns to the system 0 if succesfull , not neccesary for int main () but it is good practice

}//End of main()
//EOF