/*
* Author's Name: Ben Halpern
* Program Name:  Halpern_Project10_Gradebook.cpp
* Date: November 18, 2020
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
* A teacher has five students who have taken four tests. The teacher uses the following 
* grading scale to assign a letter grade to a student, based on the average of his or her four test scores
* 
* _________________________________________________________________________________________
*   Test Score									Letter Grade
* _________________________________________________________________________________________
* 90-100											A
* 80-89												B
* 70-79												C
* 60-69												D
* 0-59												F
* 
* Write a program that uses and array of string objects to hold the five student names,
* an array of five characters to hold the five students' letter grades, and five arrays of four double
* to hold each student's set of test scores
* 
* The program should allow the user to enter each student's name and his or her four test score. 
* It should then calculate and dislay each student's average test score, and a letter grade based on the average.
* Input validation: Do not accept test scores less that 0 or greater than 100
* 
* 
* 
* needs to improve input of file handling. Can output to a file easily reading from file for some reason isn't working
* 
*/

#include <iostream>		//input output stream. Preprocessor command to include the input output stream library
#include <string>
//#include <cmath>
#include <iomanip>
#include <fstream>
#include <istream>
#include <sstream>
#include <cstdlib>	//not used and when included casues the cout and cin to be marked by intellisence as missing 
using namespace std;	//using the standard library ( allows to display simply cout and cin instead of std::cout or std::cin )

//prototypes
void gradeBook();
int sizeOfGB(ifstream&, int lines = 3);


//global variables

const int MAXSTUDENTS = 30;
const int MAXTESTS = 4;
const double LOWER_BOUNDS = 0.0;
const double UPPER_BOUNDS = 100.0;

void homeworkHeader(string programName, string date) {
	//HOMEWORK HEADER
	//program header
	cout << "=====================================================================" << endl;
	cout << endl;									//blank line for readability
	cout << "Author's Name: Ben Halpern" << endl;
	//displays Authors Name, followed by an end-line command, printing the next line on a new line
	cout << "Program Name : " + programName << endl;
	//displays Program Name, followed by an end-line command, printing the next line on a new line
	cout << "Date : " + date << endl;
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
	const string PROJECTNAME = "Halpern_Program10_Gradebook.cpp";
	const string DATE = "November 18, 2020";

	//End Declaration of variables

	//HOMEWORK HEADER
	homeworkHeader( PROJECTNAME , DATE );
	gradeBook();
	


	return 0; //returns to the system 0 if succesfull , not neccesary for int main () but it is good practice

}//End of main()

//Algorithm
// 	create a gradebook function: driver function
// X	create a MAXSTUDENTS for the size of the array
// X 	create a active student counter
// X	create a LETTERGRADE array

//	possibly use a vector


//validation for strings
//method for input validation
//returns the choice 
string inputValidation(string errorMsg, string errorRsp) {
	string choice = string();
	while (!(cin >> choice)) {//tell the user there was a problem and clear the iostream in an attempt to try again
		cout << errorMsg << endl;
		cout << errorRsp << endl;
		//discard
		cin.clear();
		cin.ignore(1000, '\n');//ignore next 1000 chars until the next \n char
	}//while loop to reget input if it fails to read from the keyboard
	return choice;

}//end inputValidation

bool inputValidation(string errorMsg, string errorRsp, char y, char n) {
	string choice = string();
	while (!(cin >> choice) || !( choice.at(0) == y || choice.at(0) == n)) {//tell the user there was a problem and clear the iostream in an attempt to try again
		cout << errorMsg << endl;
		cout << errorRsp << endl;
		//discard
		cin.clear();
		cin.ignore(1000, '\n');//ignore next 1000 chars until the next \n char
	}//while loop to reget input if it fails to read from the keyboard
	return choice.at(0) == y;

}//end inputValidation

//overlaoded function with doubles 
//method for input validation
//returns the choice 
double inputValidation(string errorMsg, string errorRsp, double lwrBound, double upprBound) {
	double choice = double();
	while (!(cin >> choice) || !(choice >= lwrBound && choice <= upprBound)) {//tell the user there was a problem and clear the iostream in an attempt to try again
		cout << errorMsg << endl;
		cout << errorRsp << endl;
		//discard
		cin.clear();
		cin.ignore(1000, '\n');//ignore next 1000 chars until the next \n char
	}//while loop to reget input if it fails to read from the keyboard
	return choice;

}//end inputValidation

//overloaded function with ints
int inputValidation(string errorMsg, string errorRsp, int lwrBound, int upprBound) {
	int choice = int();
	while (!(cin >> choice) || !(choice >= lwrBound && choice <= upprBound)) {//tell the user there was a problem and clear the iostream in an attempt to try again
		cout << errorMsg << endl;
		cout << errorRsp << endl;
		//discard
		cin.clear();
		cin.ignore(1000, '\n');//ignore next 1000 chars until the next \n char
	}//while loop to reget input if it fails to read from the keyboard
	return choice;

}//end inputValidation





void getManualInput(string students[], double grades[MAXSTUDENTS][MAXTESTS], int &activeStudents) {
	int count = int(0);
	const string errorMsg = string("Please enter a valid input ");
	string errorRsp = string("Valid inputs are string values");//fill in valid inputs
	
	//end declarations

	//################################################################################################################################################
	//asking user to manually input data
	//################################################################################################################################################

	//loads the names of the students
	while ((count < MAXSTUDENTS) && (cout << "Enter the student at the " << count + 1 << " row in the gradebook ( enter 0 or a single value when you are done with the names, maximum " << MAXSTUDENTS <<  " students )" << endl)) {
		students[count] = inputValidation(errorMsg, errorRsp);//sets the names of the students
		if ((students[count].empty()) || (students[count].length() <= 1))//breaks out of the loop if the value is empty or two characters or less
			break;
		count++;											//increments count by 1
		activeStudents++;
	}//end while

	errorRsp = "Valid inputs are grades between the range of 0 and 100 inclusive (1.0, 1.5, 1.3, 50, 100, 75.25, etc...) ";

	for (count = 0; (count < activeStudents) && (cout << "Enter "<< students[count] << "\'s grade for"); count++) {
		cout << endl;
		for (int i = 0; i < MAXTESTS; i++) {
			cout << "\ttest #" << i + 1 << ":" << endl;
			grades[count][i] = inputValidation(errorMsg, errorRsp, LOWER_BOUNDS, UPPER_BOUNDS);//sets the grade values in the 2d double array
			//cout << grades[count][i] << endl;//debugging
		}//end for
		
	}//end for
	//return "";
}//end getManualInput


//finds the average and populates the unpopulated arrays
void findAverage(double grades[MAXSTUDENTS][MAXTESTS], int gradebook[], int activeStudents) {//populates the gradebooks with the average grade
	for (int i = 0; i < activeStudents; i++) {
		double gradesum = double();//local loop variable
		for (int j = 0; j < MAXTESTS; j++)//cycles through the tests 
			gradesum += grades[i][j];//adds them to the gradebook sum to later find the average with
		gradebook[i] = gradesum / MAXTESTS;//finds the average sum/totalCount ( integer division, implicit conversion )
		//cout << gradebook[i] << endl;//should expect an integer values //debugging
	}
}//end getAverage


//tests the grade and sees if it is in bounds
//returns a char
//parameter int grade
char getLGrade(int grade) {//gets the letter grade
	const char LETTERGRADE[5] = { 'A','B','C','D','F' };
	int upper = int();
	int lower = int();
	int gradeRange[5][2] = { {90 ,100 }, {80,89}, { 70, 79 }, { 60,69 }, { 0, 59} };
	for (int i = 0; i < 5; i++) {//note the number of letter grade is hard coded, this is something that can change in the future ( possible consider implimenting it as a const variable )
		lower = gradeRange[i][0];//lower bound
		upper = gradeRange[i][1];//upper bound

		if (lower <= grade && upper >= grade)
			return LETTERGRADE[i];
	}//end for
	return 'E';//returns E if there is an error
}//end getGrade

//prints out the gradebook to the screen in a report format
void printGradebook(string students[], int gradebook[], int activeStudents) {
	cout << endl;//blank line for visibility
	cout << right << setw(55) << "G R A D E B O O K" << endl;//title
	for (int i = 0; i < 115; i++) cout << "_";//border
	cout << endl;//blank line for visibility
	cout << left << setw(45) << "Student" <<left << setw(45) << "Average Test Score" << left << setw(45) << "Letter Grade" << endl;//students
	for (int i = 0; i < 115; i++) cout << "_";//border
	cout << endl;//blank line for visibility
	for (int student = 0; student < activeStudents; student++) {
		cout << left << setw(45) << students[student] << left << setw(45) << gradebook[student] << left << setw(45) << getLGrade(gradebook[student]) << endl;//prints out each row
	}//end for

}//end printGradebook

//prints the grade book out to a file, overwrites the file if it exists.
void printGradebook(string students[], int gradebook[], int activeStudents, ofstream& out) {
	out << endl;//blank line for visibility
	out << right << setw(70) << "G R A D E B O O K" << endl;//title
	for (int i = 0; i < 115; i++) out << "_";//border
	out << endl;//blank line for visibility
	out << left << setw(45) << "Student" << left << setw(45) << "Average Test Score" << left << setw(45) << "Letter Grade" << endl;//students
	for (int i = 0; i < 115; i++) out << "_";//border
	out << endl;//blank line for visibility
	for (int student = 0; student < activeStudents; student++) {
		out << left << setw(45) << students[student] << left << setw(45) << gradebook[student] << left << setw(45) << getLGrade(gradebook[student]) << endl;//prints out each row
	}//end for

}//end printGradebook

//if provided with the letter grades of each student, then print out the grades using that array
void printGradebook(string students[], int gradebook[], int activeStudents, char lGrades[]) {
	cout << endl;//blank line for visibility
	cout << right << setw(55) << "G R A D E B O O K" << endl;//title
	for (int i = 0; i < 115; i++) cout << "_";//border
	cout << endl;//blank line for visibility
	cout << left << setw(45) << "Student" << left << setw(45) << "Average Test Score" << left << setw(45) << "Letter Grade" << endl;//students
	for (int i = 0; i < 115; i++) cout << "_";//border
	cout << endl;//blank line for visibility
	for (int student = 0; student < activeStudents; student++) {
		cout << left << setw(45) << students[student] << left << setw(45) << gradebook[student] << left << setw(45) << lGrades[student] << endl;//prints out each row
	}//end for

}//end printGradebook



//prints out the menu and returns the choice selected
int menu() {
	string welcome = " Welcome to the gradebook application!";
	string menu = " What would you like to do?:  \n\t1) enter a new gradebook? \n\t2) test a students grade?";
	//int choice = int();
	const string ERRORMSG = string("Please enter a valid input ");
	const string ERRORRSP = string("Valid inputs are integers 1 - 2 values");//fill in valid inputs // 1-3 when the file input is working
	const int LOWER = 1;
	const int UPPER = 4;

	for (int i = 0; i < 100; i++) cout << "#";
	cout << endl;
	cout << welcome << endl << endl << menu << endl;
	for (int i = 0; i < 100; i++) cout << "#";
	cout << endl;

	cout << endl << endl;//blank lines for visbility
	cout << "your choice (1, 2)?:";
	return (inputValidation(ERRORMSG, ERRORRSP, LOWER, UPPER));
	
}//end menu
//
//string initializeFileStream(ifstream& in) {//returns the valid name fo the file
//	string fileName = string();
//	cout << "Please input a file name in which you would like to read the data from:" << endl;
//	cin >> fileName;
//
//	in.open(fileName);//sets the input stream to the fileName
//
//
//
//	//if the filename fails, loops while the fileName is not valid
//	while (in.fail()) {//loops while the file is not found
//		cout << "Please specify another file. " << endl;
//		cout << "The file at location \"" << fileName << "\" can't be found.";
//		cout << "Try specifying the full file path of the file if it is not within the same directory as the current running program." << endl;
//		cout << endl;				//blank line for visibility
//		cout << "Please input a file name in which you would like to read the data from:" << endl;
//		cin >> fileName;
//		in.open(fileName);
//		cout << fileName;
//
//		cin.clear();									//clears characters from input stream
//	}//end while
//	return fileName;//if valid returns the name of the file
//}//end initializeFileStream

string initializeFileStream(ofstream& out) {//returns the valid name fo the file
	string fileName = string();
	cout << "Please pick the name of a file, existing filenames will be overwritten!" << endl;
	cout << "Please input a file name in which you would like to read the data from:" << endl;

	cin >> fileName;

	out.open(fileName);//sets the input stream to the fileName

	return fileName;//if valid returns the name of the file
}//end initializeFileStream







//finalization function
void close(ifstream& in, ofstream& out) {
	in.close();//closes in
	out.close();//closes out
	exit(0);//exit with code 0
}


//overall gradebook driver
void gradeBook() {
	const string ERRORMSG = string("Please enter a valid input ");
	const string ERRORRSP = string("Valid inputs are 0 - 100 ");//fill in valid inputs
	//int choice = int();
	string students[MAXSTUDENTS] = { "" };
	//double  grades[MAXSTUDENTS] = { 0.0 };
	int activeStudents = int(0);
	double grades[MAXSTUDENTS][MAXTESTS] = { 0.0 };//2D parallell array holding the students test grades
	int gradebook[MAXSTUDENTS] = { 0 };//averages of the students grades
	int choice = menu();//prints out the menu and gets the user's choice
	//char lGrades[MAXSTUDENTS] = { 0 };
	ofstream out = ofstream();
	ifstream in = ifstream();
	bool i4File = bool();
	bool p2File = bool();
	bool namesPres = bool();
	

	//cout << choice << endl; //debugging

	switch (choice) {

		//case (1)://print out save gradebook
		//	
		//	cout << "Do you want to input a gradebook from a file (yes or no ) ?: ";
		//	i4File = inputValidation("Please input a valid response", "Valid responses are \'yes\' or \'no\'", 'y', 'n');
		//	if (i4File) {
		//		initializeFileStream(in);
		//		cout << "Are the student names included? ( yes or no ):";
		//		namesPres = inputValidation(ERRORMSG, "Please enter either \'yes\' or \'no\':", 'y', 'n');
		//		if(namesPres)
		//			getGradeFile(students, gradebook, activeStudents, in);
		//		else
		//			getGradeFile(gradebook, activeStudents, in);
		//		
		//		printGradebook(students, gradebook, activeStudents);



		//	}//end if
		//	break;
		//case(2)://manually enter new gradebook
		case 1:
			
			getManualInput(students, grades, activeStudents);
			findAverage(grades, gradebook, activeStudents);
			printGradebook(students, gradebook, activeStudents);
			
			cout << endl;//blank line for visibility

			cout << "Do you want to output the gradebook out to a file (yes or no ) ?: ";
			p2File = inputValidation("Please input a valid response", "Valid responses are \'yes\' or \'no\'", 'y', 'n');
			if (p2File) {
				initializeFileStream(out);
				printGradebook(students, gradebook, activeStudents, out);//prints out grade book to file
				cout << "printed out to file";

			}//end if
			break;
		//case(3)://test a students grade
		case (2)://test a students grade
			cout << "Please input a grade to be tested ( all numbers will be converted to whole numbers ):" << endl;
			cout << "Letter Grade: " << getLGrade(inputValidation(ERRORMSG, ERRORRSP, 0, 100));

			break;
		
	}//end switch

	cout << endl;//blank line for visibility
	close(in, out);



	
}//end gradebook

//commented out needs further in depth debugging: issue with the compiler recognizing the ifstream





//EOF