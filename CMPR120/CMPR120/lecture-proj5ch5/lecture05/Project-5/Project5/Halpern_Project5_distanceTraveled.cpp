/*
* Author's Name: Ben Halpern
* Program Name:  Halpern_Project5_distanceTraveled.cpp
* Date: October 5, 2020
* College Name: Santa Ana College (SAC)
* CMPR 120
* Professor Aziz
* 
*
*
*####################################################
* Assignment details:
*####################################################
*Please complete and submit Exercise #6 from page 298 from chapter-5
*/

#include <iostream>		//input output stream. Preprocessor command to include the input output stream library
//#include <cmath>
#include <iomanip>
using namespace std;	//using the standard library ( allows to display simply cout and cin instead of std::cout or std::cin )


int main() {					//main class
	
	//Declaration of variables:
	//initialization and instatiation.
	int speed = int();
	int distance = int();
	int time = int();
	int totDistance = int();
	int counter = int(1);//initializes int counter as 1
	double temp = double();	//temporary input variable
							//set as double for input, then casted to int
						    //used to allow for the user to input decimal numbers as well then for thsoe inputs to be casted to the int variables speed and time
	//string temp = string();
	//bool exitcondition = false;
	//had issues with the user input being assigned to int variables. When inputted values were not int values, 
	//the program would loop due to the failure of cin >> var, assigning to double mitigates the exiting of the new code every time that 
	//a double value is inputed and coverts it to an int.
	//end Declaration of variables

	//HOMEWORK HEADER
	//program header
	cout << "=====================================================================" << endl;
	cout << endl;									//blank line for readability
	cout << "Author's Name: Ben Halpern" << endl;
	//displays Authors Name, followed by an end-line command, printing the next line on a new line
	cout << "Program Name :  Halpern_Project5_distanceTraveled.cpp" << endl;
	//displays Program Name, followed by an end-line command, printing the next line on a new line
	cout << "Date : October 5, 2020 " << endl;
	//display's date, followed by an end-line command, printing the next line on a new line
	cout << "College Name : Santa Ana College(SAC)" << endl;
	//displays College Name, followed by an end-line command, printing the next line on a new line
	cout << endl;									//blank line for readability
	cout << "=====================================================================" << endl;
	cout << endl;
	//end Homework Header

	//Algorithm
	//distance a vehicle travels can be calculated by 
	//		s=rt or distance = speed * time
	//request users input
	//while user input is valid loop to continue
	//and how long has traveled ( hours )
	//while user input is valid loop to continue
	//use a loop to loop until that time and output the distance at each hour
	//when user input is invalid display a message and exit

	cout << "What is the speed of the vehicle in mph? ";
	while (cin >> temp) {								//sets while to loop when the user inputs a valid value, exits when an invalid value is present
		//cin.ignore();
		speed = static_cast<int>(temp);					//implicitly casts temp as an int
		//cout << speed << " mph" << endl;				//debugging
		temp = 0.0;										//resets temp value
		cin.clear();									//clears any bad characters from console input stream
		if (speed >= 0) {
			cout << "How many hours has it traveled? ";
			while (cin >> temp) {						//sets while to loop when the user inputs a valid value, exits when an invalid value is present
				time = static_cast<int>(temp);			//implicitly casts temp as an int
				//cout << time << " hrs" << endl;			//debugging
				temp = 0.0;								//resets temp value
				cin.clear();							//clears any bad characters from console input stream
				if (time >= 1 ) {
					//header of report
					cout << fixed;
					cout << setw(10) << left << "Hour" << setw(15) << right << "Distance Traveled" << endl;
					cout << "---------------------------------------------------" << endl;

					//for loop
					for (int i = 1; i <= time; i++) {	//loops until the time is == to the itterator value, using each itteration as the hour traveled
						distance = (speed * i);			//speed times the time at i
						//cout << fixed << setprecision(2);
						cout << setw(4) << right << i << setw(15) << right << distance << endl;
					}//end for

					//while loop version below
					//while(counter <= time) {//loops until the counter reaches the amount of time inputted
					//	distance = (speed * counter); //speed times time at counter
					//	cout << setw(3) << right << counter << setw(15) << right << distance << endl;
					//	counter++;
					//}//end while

					totDistance = (speed * time);		//calculation for the total average distance.
					cout << endl;					//blank line for visibility
					cout << fixed << setprecision(2);
					cout << "The total distance traveled is " << totDistance << " miles" << endl;

					system("pause");					//waits for user to press any key before exiting
					return 0;							//returns to the system 0 if succesfull , not neccesary for int main () but it is good practice
				}//end if
				else {									//if the value is less than or equal to 0
					cin.ignore();						//clears any leftover blank spaces
					cout << endl;					//blank line for visibility
					//prompts user again
					cout << "Please input time as a digit greater than or equal to 1" << endl;
					cout << "How many hours has it traveled? ";
				}
			}//end while
		}//end if
		else {											//if the value is less than or equal to 0
			cin.ignore();								//clears any leftover blank spaces
			cout << endl;							//blank line for visibility
			//prompts user again
			cout << "Please input speed as a digit greater than or equal to 0" <<endl;
			cout << "What is the speed of the vehicle in mph? ";

		}//end else
	}//end while
	//error handeling
	cout << endl;
	cout << "Exitted due to an error" << endl;
	cout << "Please only input digits" << endl;
	system("pause");									//requests user input to continue
	return 0;											//exits application
	//end of error handeling

	//Having issues getting the program to loop back after a failure to assign to a variable using cin
	//it seems that it doesn't recheck the condition, or is using the old bad value each itteration.
	//attempted to clear out th bad characters with cin.ignore() and cin.clear() but more may need to be done.

}//End of main()
//EOF