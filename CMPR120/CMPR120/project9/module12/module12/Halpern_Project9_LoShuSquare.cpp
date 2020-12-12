/*
* Author's Name: Ben Halpern
* Program Name:  Halpern_Project9_LoShuSquare.cpp
* Date: Novemeber 12th , 2020
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
* create a function that tests if the values in a 2d array make up a lo shu square
* 
* 
* 
* 
* https://stackoverflow.com/questions/5131647/why-would-we-call-cin-clear-and-cin-ignore-after-reading-input
* used for undersatndign issues with my input handling
*/

#include <iostream>		//input output stream. Preprocessor command to include the input output stream library
//#include <limits>
//#include <cmath>
//#include <iomanip>
//#include <cstdlib>	//not used and when included casues the cout and cin to be marked by intellisence as missing 
using namespace std;	//using the standard library ( allows to display simply cout and cin instead of std::cout or std::cin )

//prototype
int sumSqr(int [3][3], int length = 3);
void userInput(int[3][3], int);
void drawSqr(int[3][3], int);
//end prototypes

void homeworkHeader() {
//HOMEWORK HEADER
//program header
	cout << "=====================================================================" << endl;
	cout << endl;									//blank line for readability
	cout << "Author's Name: Ben Halpern" << endl;
	//displays Authors Name, followed by an end-line command, printing the next line on a new line
	cout << "Program Name :  Halpern_Project9_LoShuSquare.cpp" << endl;
	//displays Program Name, followed by an end-line command, printing the next line on a new line
	cout << "Date : November 12th, 2020 " << endl;
	//display's date, followed by an end-line command, printing the next line on a new line
	cout << "College Name : Santa Ana College(SAC)" << endl;
	//displays College Name, followed by an end-line command, printing the next line on a new line
	cout << endl;									//blank line for readability
	cout << "=====================================================================" << endl;
	cout << endl;

}//end homeworkHeader

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
	int square[3][3] = {  {4,9,2},
						  {3,5,7},
						  {8,1,6} };
	int loshuSum = int();//the sum of the loshu square
	bool loshu = bool();//bool for if is loshu square
	int length = sizeof(square[0]) / sizeof(int);//calculates the length of the array
	string description = "The Lo Shu Magic Square is a grid with 3 rows and 3 columns \nThe Lo Shu Magic Square has the following properties: \n\n * Th grid contains the numbers 1 - 9 exactly. \n * The sum of each row, each column, and each diagonal, all equating the same number";
	//End Declaration of variables
	
	//calling homeworkHeader
	homeworkHeader();

	cout << description << endl;//description about what a Lo Shu square is
	userInput(square, length);//if the user wants to input their own values for the lo shu square, the followng function allows that, otherwise the array remains untouched
	loshuSum = sumSqr(square, 3);//produces  if the value is true, 0 if false
	loshu = loshuSum;//is true if is value other than 0
	//draw the square
	drawSqr(square, 3);
	if (loshu) {//if is loshu then outputs to user that is it indeed 
		cout << "The square is indeed a Lo Shu Square" << endl;
		cout << "The sum of each of the rows, columns, and diagonals all equate to " << loshuSum << endl;
	}//end if
	else//else outputs that is not
		cout << "The square is not a Lo Shu Square";
	

	return 0; //returns to the system 0 if succesfull , not neccesary for int main () but it is good practice

}//End of main()

void userInput(int square[3][3], int length) {//gets the user's input to populate the array if desired, otherwise the array remains untouched from it's default values
	bool setOwn = bool(false);
	string userResponse = string();
	//end declarations

	cout << "Would you like to input your own values to test the Lo Shu square? ( yes or no ):" << endl;
	while (!(cin >> userResponse)) {//tell the user there was a problem and clear the iostream in an attempt to try again
		cout << "ERROR: invaid input" << endl;
		cout << "Please input a valid " << endl;
		//discard
		cin.clear();
		cin.ignore(1000, '\n');//ignore next 1000 chars until the next \n char
	}//while loop to reget input if it fails to read from the keyboard

	if (tolower(userResponse.at(0)) == 'y') {//if the user says yes
		for (int i = 0; i < length; i++) {//populate the 2d array
			for (int j = 0; j < length; j++) {
				//cout << i << ":" << j << endl;//note after first itteration, the value of j changes by +1 due to the post increment call
				cout << "Please enter the " << i + 1 << " row, " << j + 1 << " column value as a valid integer:" << endl;
				//populate array
				while (!(cin >> square[i][j])) {//tell the user there was a problem and clear the iostream in an attempt to try again
					cout << "ERROR: invaid input" << endl;
					cout << "Please input a valid: " << endl;
					//discard
					cin.clear();
					cin.ignore(1000, '\n');//ignore next 1000 chars until the next \n char
				}//while loop to reget input if it fails to read from the keyboard
				while (square[i][j] > 9 || square[i][j] < 1) {// if the value is out of bounds
					cout << "Please enter a value between 1 - 9 " << endl;
					cin >> square[i][j];//populate array
				}//end while
				//having issue with user validation

				//if ((cout << "Please enter the " << i + 1 << " row, " << j + 1 << " column value:" << endl )){
				//	if (!(cin >> square[i][j])) {
				//		//--j;
				//		//if (!(cin >> square[i][j]))//remember to ask, erraneous answers are proving difficult with this kind of check
				//		//to counteract the post increment used in the for loop
				//		//cout << i << ":" << j << endl;//debugging
				//		while (cin.fail()) {
				//			//cout << "Please enter a valid value";
				//			//cin.clear();
				//			//cin.ignore(std::numeric_limits<std::streamsize>::max(), '\n');//ingores the next characters for the size fo the erraneous input which was inputted
				//			//cout.flush();
				//			cin >> square[i][j];//error from visual studios : that -4 bytes may be read
				//			//cout << i << ":" << j << endl;
				//		}//end while
				//	}
				//}//end if
				
			}//end for
		}//end for
	}//end if

}//end userInput


void drawSqr(int square[3][3], int length) {//draws the square to the screen
	cout << endl;//blank line for visibility
	for (int i = 0; i < length; i++) {//itterate and draw out each value of the square // row
		
		for (int j = 0; j < length; j++) {//column
			cout << "| " << square[i][j];
		}//end for
		cout << "|"<< endl;//end of row marker
		if(i != length -1)
			for (int c = 0; c < 10; c++) cout << "_";//creates square lines in the middle
		cout << endl;//breaks to next line
	}//end for

}


//algorithm
//check if the square is a lo shu square
//add the sum of the rows
//add the sum of colums
//add the sum of diagonals
//assignments functions:
//accepts 2d array as a parameter and returns the sum if the array is a Lo Shu square
//produces the sum of the Lo Shu square, if the sums do not matche, returns 0
int sumSqr(int square[3][3], int length) {
	//int lengthA = sizeof(square[0])/sizeof(int);
	int sumRow[3] = { 0 };
	int sumCol[3] = { 0 };
	int sumDiag[2] = { 0 };
	int equivSum = int();
	//end variable declarations

	for (int i = 0; i < length; i++) {
		for (int j = 0; j < length; j++) {
			sumRow[i] += square[i][j];//add the sum of each row
			sumCol[i] += square[j][i];//add the sum of each column
			
		}

	}//end for
	
	//cout << length << endl;//debugging
	//cout << "diag" << endl;//debugging
	for (int i = 0; i < length; i++) {
		int j = (length - 1) - i;//local loop variable
		//cout << j;
		sumDiag[0] += square[i][j];//add the sum of the right diagonal
		//cout << "sum Diag 1 " << sumDiag[0] << endl;
		sumDiag[1] += square[i][i];//add the sum of the left diagona
		//cout << "sum Diag 2 " << sumDiag[1] << endl;
	}//end for

	//cout << sumDiag[0] << endl;//debugging
	//cout << sumDiag[1] << endl;//debugging
	
	/*
	//debugging
	for(int value : sumCol){//debugging
		//cout << value << endl;
	}//end for
	for (int value : sumRow) {//debugging
		//cout << value << endl;
	}//end for
	*/

	//checks comparisons
	for (int rowSum : sumRow) {//3
		for (int colSum : sumCol) {//3*3
			for (int diagSum : sumDiag) {//2*3*3 comparisons
				if (diagSum == colSum) {
					//cout << diagSum << " = " << colSum << endl;
					if (colSum == rowSum) {
						//cout << colSum << " = " << rowSum;
						//cout << equivSum << endl;
						equivSum++;//should be 18 if is true lo shu square

					}//end if



				}//end if
			}//end for
		}//end for

	}//end for
	
	return ((equivSum == 18)? sumRow[0] : 0);//returns the value of the sum if they are all equal, if not returns 0

}//end sumSqr


 
 
 
 //EOF