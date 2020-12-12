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
*Please complete and submit Exercise #7 from page 374 from chapter-6 from your book. 
* 
* 
* Poses some questions on how to retest conditions in a loop if it is checking the validity of cin population of a variable.
* (this is an error that needs to be debugged: if a value that is of the not expected type is inputted, then the loop gets stuck in an infinite loop ) possibly use a try-catch ? need to find out the specific error beign thrown
*/

#include <iostream>		//input output stream. Preprocessor command to include the input output stream library
//#include <string>		//import string library
//#include <cmath>
#include <iomanip>
//#include <cstdlib>	//not used and when included casues the cout and cin to be marked by intellisence as missing 
using namespace std;	//using the standard library ( allows to display simply cout and cin instead of std::cout or std::cin )

//prototypes:
void homeworkHeader(string, string);
void choice(double(&function1)(double), double(&function2)(double), void(&function3)(int, int, char), string , string , string , string , string , string , string);
void tempTable(int , int , char);
void tempTable(int , int );
void tempTable();
double celsius(double);
double fahrenheit(double);

//main 
int main() {					//main class
	//cin is request input from user
	//cout is output to the screen
	//endl is endline 
	//';' ends a statment
	//variables declared with camelHump notation
	//int refers to integer
	//double refers to decimal number or floating point number
	bool runAgain = bool(true);//sets default value of boolean to true
	string yesOrNo = string();
	string option1 = "Convert to Celsius";
	string option2 = "Convert to Fahreneheit";
	string option3 = "Display a table of Temperature Conversion";
	string prompt1 = "Please input degrees in fahrenheit to be converted";
	string prompt2 = "Please input degrees in Centigrade to be converted";
	string prompt3 = "Please input the starting value in table ( only an integer, no decimals ) \nand the ending value in the table ( only an integer, no decimals) , followed by \na C or F representing which value you want to convert from: ";
	string nullString = "";
	//Declaration of variables:
		//initialization and instatiation.

	
	//End Declaration of variables
	homeworkHeader("Halpern_Project7_CelsiusTemperatureTable.cpp", "October 22, 2020");//calls the homeworkHeader function to display the homework header
	while (runAgain) {
		choice(celsius, fahrenheit, tempTable, option1, option2, option3, prompt1, prompt2, prompt3, nullString);
		//may think of taking this out of a loop, or once again finding a way to better clear the input string to allow for a reprompting of variables. 
		do {//loops as long as the values are not any of the valid options ( however is not needed because it is short circutted by the first condition, and the runAgain, tells the program whether to run again
			cout << endl;//blank line for visibility
			cout << "Do you want to run again ( Please enter either 'yes' or 'no' )" << endl;
		} while (!(cin >> yesOrNo));//&& !( (yesOrNo == "yes" || yesOrNo == "y") || (yesOrNo == "no" || yesOrNo == "n")));// might look to revise this do - while loop's conditions
		runAgain = (((yesOrNo) == "yes" || yesOrNo == "y"));//&& !(yesOrNo == "no" || yesOrNo == "n"));
	}



	return 0; //returns to the system 0 if succesfull , not neccesary for int main () but it is good practice

}//End of main()


void homeworkHeader( string title, string date ){
	//HOMEWORK HEADER
	//program header
	cout << "=====================================================================" << endl;
	cout << endl;									//blank line for readability
	cout << "Author's Name: Ben Halpern" << endl;
	//displays Authors Name, followed by an end-line command, printing the next line on a new line
	cout << "Program Name : " << title << endl;
	//displays Program Name, followed by an end-line command, printing the next line on a new line
	cout << "Date : " << date << endl;
	//display's date, followed by an end-line command, printing the next line on a new line
	cout << "College Name : Santa Ana College(SAC)" << endl;
	//displays College Name, followed by an end-line command, printing the next line on a new line
	cout << endl;									//blank line for readability
	cout << "=====================================================================" << endl;
	cout << endl;

	
}





//gets passed 3 functions ( 2 of return type double, and one of type void ), and 6 string arguments, the first 3 string arguments are the names of the function to be dispalyed on the menue, the last 3 are prompts to prompt the user; has extra argument to make signature unique
//within the choice functions: need to figure out how to clear the input stream properly and allow for the loop to restest the condition if it is not met. Some of the while loops
//when given bad input loop and take 0 as their default value,not allowing the user to input a new attempt. IF the user inputs a value that is not an integer, the loop loops until the loop limit, and then exits with the default values.
void choice(double(&function1)(double) , double(&function2)(double), void(&function3)(int, int, char), string option1name, string option2name, string option3name, string prompt1, string prompt2, string prompt3, string blankIdentifier) {//a function which takes three functions as options
	//varaible declarations
	int optionChoice = int();
	//int param1 = int(), param2 = int(), param3 = int();//variables for the parameters to be inputted into the function
	int param1 = int();
	int param2 = int();
	int param3 = int(), param4 = int();
	char param5 = char();
	int itterator = 1;
	//variables for the parameters to be inputted into the function
	//end varaible declarations


	do {//creates a menue for the use to select function
		cout << "Please pick a function to run: "
			<< endl << "1: " << option1name
			<< endl << "2: " << option2name
			<< endl << "3: " << option3name
			<< endl << "0: to exit\n";
	} while (!(cin >> optionChoice ) || (optionChoice != 1 && optionChoice != 2 && optionChoice != 3 && optionChoice != 0));
	if (optionChoice != 0)
		switch (optionChoice) {
		case (1):
			//local variable declaration
			itterator = 1;//itterator to only display the loop 3 times if the cin fails, local variable only exists within swithc
			//end local variable declaration
			cout << prompt1 << endl;
			while (!(cin >> param1) && itterator <= 3) {//to loop while input isn't valid of type double
				cout << prompt1 << endl << "Please try again" << endl;
				//cin.clear();
				if( cin >> param1)//to retest condition
					break;
				//cout << param1;
				itterator++;
			}//end while
			cout << function1(param1) << endl;
			break;
		case (2):
			//local variable declaration
			itterator = 1;//itterator to only display the loop 3 times if the cin fails, local variable only exists within switch //varaible reused because only one switch element is used ( shadowing ?)
			//end local variable declaration
			cout << prompt2 << endl;
			while (!(cin >> param2) && itterator <= 3) {//to loop while input isn't valid of type double
				cout << prompt2 << endl << "Please try again" << endl;
				//clears input stream
				//cin.clear();
				if (cin >> param2)//to retest condition
					break;
				//cout << param2;
				itterator++;
			}//end while
			cout << function2(param2) << endl;

			break;
		case (3):
			//local variable declaration
			itterator = 1;//itterator to only display the loop 3 times if the cin fails, local variable only exists within switch //varaible reused because only one switch element is used ( shadowing ?)
			//end local variable declaration
			cout << prompt3 << endl;
			while (!(cin >> param3 >> param4 >> param5) && itterator <= 3) {//to loop while input isn't valid of type double
				cout << prompt3 << endl << "Please try again" << endl;
				//clears input stream
				//cin.ignore();
				//cin.clear();
				
				if (cin >> param3 >> param4 >> param5)
					break;
				//cout << param3 << param4 << param5;
				itterator++;
			}//end while
			function3(param3, param4, param5);

			break;
		case (4)://hidden option
			for (double i = (cin.get()); i < 100.0; i++)
				cout << "TEST CASES TO 100: " << endl << ((9.0 / 5.0) * i) + 32 << " , " << i << " , " << i + 273.15 << endl;
			break;
		}//end switch
	else// if 0 is inputted, exit
		exit(0);
	cin.clear(); //clears input stream ( especially after the use of cin.get() )
}//end choice

//overloaded of the choice function, allowing for the other void function wiht 2 int as a parameter
void choice(double(&function1)(double), double(&function2)(double), void(&function3)(int, int), string option1name, string option2name, string option3name, string prompt1, string prompt2, string prompt3) {//a function which takes three functions as options
	//varaible declarations
	int optionChoice = int();
	double param1 = double();
	double param2 = double();
	int param3 = int(), param4 = int();
	int itterator = 1;
	
	//variables for the parameters to be inputted into the function
	//end varaible declarations


	do {//creates a menue for the use to select function
		cout << "Please pick a function to run: B "
			<< endl << "1: " << option1name
			<< endl << "2: " << option2name
			<< endl << "3: " << option3name
			<< endl << "0: to exit\n";
	} while (!(cin >> optionChoice ) || (optionChoice != 1 && optionChoice != 2 && optionChoice != 3 && optionChoice != 0));
	if (optionChoice != 0)
		switch (optionChoice) {//switch for the menu
			case (1):
				//local variable declaration
				itterator = 1;//itterator to only display the loop 3 times if the cin fails, local variable only exists within swithc
				//end local variable declaration
				cout << prompt1 << endl;
				while (!(cin >> param1) && itterator <= 3){//to loop while input isn't valid of type double
					cout << prompt1 << endl << "Please try again" << endl;
					//cin.clear(); 
					if (cin >> param1)
						break;
					//cout << param1;
					itterator++;
				}//end while
				cout << function1(param1) << endl;
				break;
			case (2):
				//local variable declaration
				itterator = 1;//itterator to only display the loop 3 times if the cin fails, local variable only exists within switch //varaible reused because only one switch element is used ( shadowing ?)
				//end local variable declaration
				cout << prompt2 << endl;
				while (!(cin >> param2) && itterator <= 3) {//to loop while input isn't valid of type double
					cout << prompt2 << endl << "Please try again" << endl;
					cin.clear(); 
					if (cin >> param2)
						break;
					//cout << param2; 
					itterator++;
				}//end while
				cout << function2(param2) << endl;

				break;
			case (3):
				//local variable declaration
				itterator = 1;//itterator to only display the loop 3 times if the cin fails, local variable only exists within switch //varaible reused because only one switch element is used ( shadowing ?)
				//end local variable declaration
				cout << prompt3 << endl;
				while (!(cin >> param3 >> param4) && itterator <= 3){//to loop while input isn't valid of type double
					cout << prompt3 << endl << "Please try again" << endl;
					//cin.clear(); 
					if (cin >> param3 >> param4)
						break;
					//cout << param3 << param4;
					itterator++;
				}//end while
					function3(param3, param4);

					break;
		}//end switch
	cin.clear();

}//end overloaded choice

//overloaded choice allowing for the no parameter void function to be called
void choice(double(&function1)(double), double(&function2)(double), void(&function3)(), string option1name, string option2name, string option3name, string prompt1, string prompt2) {//a function which takes three functions as options
	//varaible declarations
	int optionChoice = int();
	double param1 = double();
	double param2 = double();
	int param3 = int(), param4 = int();
	int itterator = 1;
	//variables for the parameters to be inputted into the function
	//end varaible declarations


	do {//creates a menue for the use to select function
		cout << "Please pick a function to run: "
			<< endl << "1: " << option1name
			<< endl << "2: " << option2name
			<< endl << "3: " << option3name
			<< endl << "0: to exit";
	} while (cin >> optionChoice && !(optionChoice == 1 || optionChoice == 2 || optionChoice == 3 || optionChoice == 0));
	if (optionChoice != 0)
		switch (optionChoice) {//switch for the menu
		case (1):
			//local variable declaration
			itterator = 1;//itterator to only display the loop 3 times if the cin fails, local variable only exists within swithc
			//end local variable declaration
			cout << prompt1 << endl;
			while (!(cin >> param1) && itterator <= 3) {//to loop while input isn't valid of type double
				cout << prompt1 << endl << "Please try again" << endl;
				//cin.clear(); 
				if (cin >> param1)
					break;
				//cout << param1;
				itterator++;
			}//end while
			cout << function1(param1) << endl;
			break;
		case (2):
			//local variable declaration
			itterator = 1;//itterator to only display the loop 3 times if the cin fails, local variable only exists within switch //varaible reused because only one switch element is used ( shadowing ?)
			//end local variable declaration
			cout << prompt2 << endl;
			while (!(cin >> param2) && itterator <= 3) {//to loop while input isn't valid of type double
				cout << prompt2 << endl << "Please try again" << endl;
				//cin.clear();
				if( cin >> param2)
					break;
				//cout << param2;
				itterator++;
			}//end while
			cout << function2(param2) << endl;

			break;
		case (3):
			//local variable declaration
			//int itterator = 1;//itterator to only display the loop 3 times if the cin fails, local variable only exists within switch //varaible reused because only one switch element is used ( shadowing ?)
			//end local variable declaration
			//cout << prompt3;
			function3();

			break;
		}//end switch
	else//if 0 is inputted, exit program
		exit(0);
	cin.clear();
}//end overloaded choice


//in the future can create an overlaoded function that takes in the value as a double
//tempTable function, prints out a list in a table of temperatrue conversions ( celsius to fahrenheit ) 
void tempTable(int lowerLim, int upperLim,  char tempType ) {
	if (tolower(tempType) == 'c') {//converts the single char character to a lower case and compares that int value with the int of 'c'
		
		//if (upperLim > 100 || lowerLim > 100) {
		//	cout << "Please enter a valid upper limit, below 100!";
		//	cin.get();//waits for enter, then exits
		//	cin.ignore();//ignores character from input stream
		//	exit(1);//exit code 1, meaning minor error
		//}//end if
		//
		//const int SIZE = 100;//max spaces is 100
		//double predicted[SIZE][3];
		//Algorithm
		cout << setw(50) << right << "Celsius to Fahrenheit Table" << endl ;//title of the table
		
		for (int i = 150; i > 0; i--)
			cout << "=";//prints out '=' 100 times
		cout << endl << setw(30) << left << "Celsius" << setw(40) << "" << setw(50) << right << "Fahreneheit" << endl;//header row ( key/ legend )
		for (int i = 150; i > 0; i--)
			cout << "=";//prints out '=' 100 times
		cout << endl;//next line after the loop
		for (int i = lowerLim; i <= upperLim; i++) {//for loop to populate array
			double cel = i;//implicit conversion
			//predicted[i][3] = { (((9.0 / 5.0) * celsius) + 32), celsius , (celsius + 273.15) };
			cout << fixed << setprecision(2);
			cout <<setw(30) << left << cel << setw(40) << "" << setw(50) << right << fahrenheit(cel) << endl;
		}//end for
	}//end if
	else {//redudent, simply to show the ability of overloaded functions
		tempTable(lowerLim, upperLim);//passes to overloaded function
	}
}//end  tempTable


//creates a temperature table with the conversion from Fahrenehit ( left ) to Celsius ( right )
void tempTable(int lowerLim, int upperLim) {
	cout << setw(50) << right << "Fahrenheit to Celsius Table" << endl;//title of the table
	//creates legend for table
	for (int i = 150; i > 0; i--)
		cout << "=";//prints out '=' 100 times
	cout << endl << setw(30) << left << "Fahreneheit" << setw(40) << "" << setw(50) << right << "Celsius" << endl;//header row ( key/ legend )
	for (int i = 150; i > 0; i--)
		cout << "=";//prints out '=' 100 times
	//end legend
	cout << endl;//line after the legend header border
	for (int i = lowerLim; i <= upperLim; i++) {//for loop to populate array
		double fahr = i;//implicit conversion, local variable in loop
		cout << fixed << setprecision(2);
		cout << setw(30) << left << fahr << setw(40) << "" << setw(50) << right <<  celsius(fahr) << endl;
	}//end for
}//end overloaded tempTable

//creates a temperature table 0 - 100 celsius
void tempTable() {//default tempTable
	cout << setw(50) << right << "Temperature Table" << endl;//title of the table
//creates legend for table
	for (int i = 150; i > 0; i--)
		cout << "=";//prints out '=' 100 times
	cout << setw(30) << left << "Fahreneheit" << setw(40) << "" << setw(50) << right << "Celsius" << endl;//header row ( key/ legend )
	for (int i = 150; i > 0; i--)
		cout << "=";//prints out '=' 100 times
	//end legend
	cout << endl;//line break after header
	for (int i = 0 ; i < 101; i++) {//for loop to populate array
		double cel = i;//implicit conversion, local variable in loop
		cout << fixed << setprecision(2);
		cout << setw(15) << celsius(cel) << setw(15) << cel << setw(15) <<(cel + 273.15)<< endl;
	}//end for
	
}//end overloaded tempTable

//###############################################################################################################################
//conversion functions:
//###############################################################################################################################
double celsius(double fahrenheit) {//converts fahreneheit to celsius ( if converting to kelvin as well suggest using a different name or adding a parameter for the conversion type )
	//cout << "celsius" << endl;
	//Algortihm:
	//celsius = ( 5/9 * ( fahrenehit - 32 )|| ((0.55556 * (fahrenheit - 32)
	return ((5.0/9.0) * (fahrenheit - 32));//returns converted value
}//end celsius

double fahrenheit(double celsius) {//converts celsius to fahrenheit ( same possibly issue as posed above )
	//cout << "fahreneheit" << endl;
	//Algortihm:
	
	//Fahrenheit = ( 1.8 * celsius ) + 32 || ((9/5) * celsius) + 32
	return ((1.8 * celsius) + 32);//returns converted value

}//end fahrenheit

//different signatures of the above functios, this time with the ability to pass by reference
void celsiusPoint(double &celsius, double fahrenheit) {//converts to celsius using the pass by reference
	//Algortihm:
	//Fahrenheit = ( 1.8 * celsius ) + 32 || ((9/5) * celsius) + 32
	fahrenheit = (1.8 * (fahrenheit - 32));//returns converted value
		
}//end overloaded celsius

void fahrenheitPoint(double &fahrenheit, double celsius) {//converts to fahrenheit using the pass by reference
	//Algortihm:
	//celsius = ( 5/9 * ( fahrenehit - 32 )|| ((0.55556 * (fahrenheit - 32)
	fahrenheit = ((1.8 * celsius) + 32);//returns converted value

}//end overloaded fahrenheit

//Kelvin conversions:

//double celsiusToKelvin(double celsius) {
//	return (celsius + 273.15);
//}//end c
//
////prototype for fahrenheit to kelvin
////celsiusToFahrenheit(double);
////fahrenheitToCelsius(double);
//double fahreneheitToKelvin(double fahreneheit) {
//	return celsiusToKelvin(celsius(fahreneheit));//passing one function call to another
//}//end fahrenheitToKelvin


/*
* populated array with 
* for(double i = 0.0; i < 100.0 ; i++)
*	predicted[i][] = {((9.0/5.0)*i) + 32, i, i + 273.15}; 
* check common test cases, here
//test case 2D array 0 - 100 degrees fahreneheit, celsius, kelvin
		//array size as seen above double predicted
		double[100][3] predicted = {{  32.00  ,     0  ,  273.15  },
				{  33.80  ,  1.00  ,  274.15  },
				{  35.60  ,  2.00  ,  275.15  },
				{  37.40  ,  3.00  ,  276.15  },
				{  39.20  ,  4.00  ,  277.15  },
				{  41.00  ,  5.00  ,  278.15  },
				{  42.80  ,  6.00  ,  279.15  },
				{  44.60  ,  7.00  ,  280.15  },
				{  46.40  ,  8.00  ,  281.15  },
				{  48.20  ,  9.00  ,  282.15  },
				{  50.00  ,  10.00  ,  283.15  },
				{  51.80  ,  11.00  ,  284.15  },
				{  53.60  ,  12.00  ,  285.15  },
				{  55.40  ,  13.00  ,  286.15  },
				{  57.20  ,  14.00  ,  287.15  },
				{  59.00  ,  15.00  ,  288.15  },
				{  60.80  ,  16.00  ,  289.15  },
				{  62.60  ,  17.00  ,  290.15  },
				{  64.40  ,  18.00  ,  291.15  },
				{  66.20  ,  19.00  ,  292.15  },
				{  68.00  ,  20.00  ,  293.15  },
				{  69.80  ,  21.00  ,  294.15  },
				{  71.60  ,  22.00  ,  295.15  },
				{  73.40  ,  23.00  ,  296.15  },
				{  75.20  ,  24.00  ,  297.15  },
				{  77.00  ,  25.00  ,  298.15  },
				{  78.80  ,  26.00  ,  299.15  },
				{  80.60  ,  27.00  ,  300.15  },
				{  82.40  ,  28.00  ,  301.15  },
				{  84.20  ,  29.00  ,  302.15  },
				{  86.00  ,  30.00  ,  303.15  },
				{  87.80  ,  31.00  ,  304.15  },
				{  89.60  ,  32.00  ,  305.15  },
				{  91.40  ,  33.00  ,  306.15  },
				{  93.20  ,  34.00  ,  307.15  },
				{  95.00  ,  35.00  ,  308.15  },
				{  96.80  ,  36.00  ,  309.15  },
				{  98.60  ,  37.00  ,  310.15  },
				{  100.40  ,  38.00  ,  311.15  },
				{  102.20  ,  39.00  ,  312.15  },
				{  104.00  ,  40.00  ,  313.15  },
				{  105.80  ,  41.00  ,  314.15  },
				{  107.60  ,  42.00  ,  315.15  },
				{  109.40  ,  43.00  ,  316.15  },
				{  111.20  ,  44.00  ,  317.15  },
				{  113.00  ,  45.00  ,  318.15  },
				{  114.80  ,  46.00  ,  319.15  },
				{  116.60  ,  47.00  ,  320.15  },
				{  118.40  ,  48.00  ,  321.15  },
				{  120.20  ,  49.00  ,  322.15  },
				{  122.00  ,  50.00  ,  323.15  },
				{  123.80  ,  51.00  ,  324.15  },
				{  125.60  ,  52.00  ,  325.15  },
				{  127.40  ,  53.00  ,  326.15  },
				{  129.20  ,  54.00  ,  327.15  },
				{  131.00  ,  55.00  ,  328.15  },
				{  132.80  ,  56.00  ,  329.15  },
				{  134.60  ,  57.00  ,  330.15  },
				{  136.40  ,  58.00  ,  331.15  },
				{  138.20  ,  59.00  ,  332.15  },
				{  140.00  ,  60.00  ,  333.15  },
				{  141.80  ,  61.00  ,  334.15  },
				{  143.60  ,  62.00  ,  335.15  },
				{  145.40  ,  63.00  ,  336.15  },
				{  147.20  ,  64.00  ,  337.15  },
				{  149.00  ,  65.00  ,  338.15  },
				{  150.80  ,  66.00  ,  339.15  },
				{  152.60  ,  67.00  ,  340.15  },
				{  154.40  ,  68.00  ,  341.15  },
				{  156.20  ,  69.00  ,  342.15  },
				{  158.00  ,  70.00  ,  343.15  },
				{  159.80  ,  71.00  ,  344.15  },
				{  161.60  ,  72.00  ,  345.15  },
				{  163.40  ,  73.00  ,  346.15  },
				{  165.20  ,  74.00  ,  347.15  },
				{  167.00  ,  75.00  ,  348.15  },
				{  168.80  ,  76.00  ,  349.15  },
				{  170.60  ,  77.00  ,  350.15  },
				{  172.40  ,  78.00  ,  351.15  },
				{  174.20  ,  79.00  ,  352.15  },
				{  176.00  ,  80.00  ,  353.15  },
				{  177.80  ,  81.00  ,  354.15  },
				{  179.60  ,  82.00  ,  355.15  },
				{  181.40  ,  83.00  ,  356.15  },
				{  183.20  ,  84.00  ,  357.15  },
				{  185.00  ,  85.00  ,  358.15  },
				{  186.80  ,  86.00  ,  359.15  },
				{  188.60  ,  87.00  ,  360.15  },
				{  190.40  ,  88.00  ,  361.15  },
				{  192.20  ,  89.00  ,  362.15  },
				{  194.00  ,  90.00  ,  363.15  },
				{  195.80  ,  91.00  ,  364.15  },
				{  197.60  ,  92.00  ,  365.15  },
				{  199.40  ,  93.00  ,  366.15  },
				{  201.20  ,  94.00  ,  367.15  },
				{  203.00  ,  95.00  ,  368.15  },
				{  204.80  ,  96.00  ,  369.15  },
				{  206.60  ,  97.00  ,  370.15  },
				{  208.40  ,  98.00  ,  371.15  },
				{  210.20  ,  99.00  ,  372.15  },
				{  212.00  ,  100.00  ,  373.15  }};
		//end initialization and instatiation



*/