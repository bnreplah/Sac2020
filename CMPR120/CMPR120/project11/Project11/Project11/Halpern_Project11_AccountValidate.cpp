/*
* Author's Name: Ben Halpern
* Program Name:  Halpern_Project11_AccountValidate.cpp
* Date: November 25, 2020
* College Name: Santa Ana College (SAC)
* CMPR 120
* Professor Aziz
* 
*
*
*####################################################
* Assignment details:
*####################################################
*	provide different sorting options
*	create a menu with the following options:
* 
* 
* 
*	functions
* 
*	load the data from a file
*		load account numbers,
*		load names
*	
*	load the data from user
*		load account numbers,
*		load names
*	
*	search to see if the name is in the list
*	search to see if the value is in the list
*	
*	linearSearch()
*	binarySearch()
*	bubbleSort()
*	selectionSort()
*	
* 
* 
* 
* 
* 
*/

#include <iostream>		//input output stream. Preprocessor command to include the input output stream library
#include <conio.h>		//_getch() needs this library
#include <string>
#include <fstream>	

//#include <cmath>
#include <iomanip>
#include <cstdlib>	//not used and when included casues the cout and cin to be marked by intellisence as missing 
using namespace std;	//using the standard library ( allows to display simply cout and cin instead of std::cout or std::cin )


/// <summary>
/// 
/// </summary>
/// <param name="title"></param>
/// <param name="date"></param>
void homeworkHeader(string title, string date) {
	//HOMEWORK HEADER
//program header
	cout << "=====================================================================" << endl;
	cout << endl;									//blank line for readability
	cout << "Author's Name: Ben Halpern" << endl;
	//displays Authors Name, followed by an end-line command, printing the next line on a new line
	cout << "Program Name :  "<< title << endl;
	//displays Program Name, followed by an end-line command, printing the next line on a new line
	cout << "Date : "<< date << endl;
	//display's date, followed by an end-line command, printing the next line on a new line
	cout << "College Name : Santa Ana College(SAC)" << endl;
	//displays College Name, followed by an end-line command, printing the next line on a new line
	cout << endl;									//blank line for readability
	cout << "=====================================================================" << endl;
	cout << endl;

}//end homeworkHeader

/// <summary>
/// 
/// </summary>
void cls() {
	//source:https://stackoverflow.com/questions/17335816/clear-screen-using-c
	cout << "\033[2J\033[1;1H";
	//the escapes translate to clear screen equivalent, supposidly cross platform
	//trying to avoid system("cls"); because its platform dependant
}//end cls

/// <summary>
/// 
/// </summary>
void pause() {//function to pause screen, may need to add cin.ignore prior
	char key = char();
	cout << "Please press enter to continue ... ";
	//cin.ignore();
	key = _getch();
}//end pause

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
	while (!(cin >> choice) || !(choice.at(0) == y || choice.at(0) == n)) {//tell the user there was a problem and clear the iostream in an attempt to try again
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




//sends the termination signal to the program with exit code 1
void close() {
	exit(1);
}

//closes the passed filestream objects
void close(ifstream& stream) {
	stream.close();
}

void close(ofstream& stream) {
	stream.close();
}

void close(fstream& stream) {
	stream.close();
}









int menu() {
	int selection = int();
	cls();
	cout << endl;//blank line for visibility
	cout << right << setw(50) << "=== MENU ===" << endl;
	cout << right << setw(35) << "" << left << "\t1) load user files" << endl;
	cout << right << setw(35) << "" << left << "\t2) update user data" << endl;
	cout << right << setw(35) << "" << left << "\t3) save user data" << endl;
	cout << right << setw(35) << "" << left << "\t4) search" << endl;
	cout << right << setw(35) << "" << left << "\t5) sort by ID" << endl;
	cout << right << setw(35) << "" << left << "\t6) sort by username" << endl;
	cout << right << setw(35) << "" << left << "\t7) exit" << endl;
	cout << endl << endl << "Which would you like to do ?";
	selection = inputValidation( "Please enter a valid response ","Please enter a value between 1 - 7" ,1,7);
	return selection;
}//end menu


int menu(string options[], int size) {
	int selection = int();
	cout << right << setw(50) << "=== MENU ===" << endl;
	for (int i = 0; i < size; i++) {
		cout << right << setw(35) << "" << left << "\t" << (i + 1) << ")" << options[i] << endl;
	}
	selection = inputValidation("Please enter a valid response ", "Please enter a value between 1 - " + size, 1, size);
	return selection;

}


void validateFile(ofstream& out) {
	string outFileName = string();
	fstream read = fstream();
	//fstream out = fstream();
	int append = int();
	
	cls();
	//check if file exists
	cout << "Please specify name of the file to write to: \n";
	cin >> outFileName;
	read.open(outFileName);//could also use the 'in' object from before to check, but I wanted to use the fstream object ( both to check functionality and to create a seperate varaible for readability ) 
	if (read) {//if read is true ( file exists )
		do {//loops when fails to load input to append and the value is a number other than 1 or 2
			cout << "File already exits, would you like to append: \n"
				<< setw(10) << left << "1: Yes" << setw(10) << right << "2: no" << endl;
			cout << "Please input either \'1\' or \'2\'" << endl;
			cin.clear();									//clears characters from input stream
		} while ((cin >> append) && (append != 1 && append != 2));
		if (append == 1)
			out.open(outFileName, ofstream::out | ofstream::app);//appends to file
		else
			out.open(outFileName);							//overwrites file
		cin.clear();										//clears characters from input stream
	}//end if
	else
		out.open(outFileName);								//creates new file
	read.close();//close read

}//end validate






void readFile(int id[], string usrnames[], int size, ifstream& file ) {
	//the program is set up currently to read "only data" files, no titles, only content.
	cls();
	if (file) {//if the file exists
		bool eof = file.eof();
		for (int i = 0; (i < size) && (!eof); i++, eof = file.eof()) {
			file >> id[i] >> usrnames[i];
			//eof = file.eof();
			cout << "read line " << (i + 1) << endl;
		}//end for
		if (!eof) {//if reaches doesn't reach end of file
			cout << "The data was loaded, however not all the data was loaded from the file" << endl;
		}//endif 
		close(file);
	}//end if
	else//if file is false
		cout << "The file doesn't exist" << endl;

}//end readFile


void readFile(int id[], string usrnames[], int size) {
	ifstream file = ifstream("data.txt");
	//the program is set up currently to read "only data" files, no titles, only content.
	cls();
	if (file) {//if the file exists
		bool eof = file.eof();
		for (int i = 0; (i < size) && !eof; i++, eof = file.eof()) {
			file >> id[i] >> usrnames[i];
			//eof = file.eof();
			cout << "read line " << (i + 1) << endl;
		}//end for
		if (!eof) {//if reaches doesn't reach end of file
			cout << "The data was loaded, however not all the data was loaded from the file" << endl;
		}//endif 
		close(file);
	}//end if
	else//if file is false
		cout << "The file doesn't exist" << endl;

	close(file);
}//end readFile




void updateUsrFile(int id[], string usrnames[], int size) {
	cls();
	int selection = int();
	int lineNum = int();
	string options[] = { "Update all the data","Update only one line","Go Back" };
	selection = menu(options, 3);
	switch (selection) {
	case (1):
		cls();
		for (int i = 0; i < size; i++) {
			cout << "old values line  "<< i+1 << " :" << endl;
			cout << id[i] << "\t" << usrnames[i] << endl;
			cout << "new values:" << endl;
			cin >> id[i] >> usrnames[i];
		}

		break;
	case(2):
		cls();
		
		cout << "Please enter a line number you would like to edit: ";
		lineNum = inputValidation("Please input a valid selection", "Valid selections are 1 - " + size, 1, size);
		cls();
		cout << "old values of line " << lineNum << endl;
		cout << id[lineNum - 1] << "\t" << usrnames[lineNum - 1] << endl;
		cout << "new values:" << endl;
		cin >> id[lineNum - 1] >> usrnames[lineNum - 1];


		break;
	default://possible set options 3 to search by value

		break;//if option 3 is selected exits


	}
}


void saveUsrFile(int id[], string usrnames[], int size) {
	ofstream out = ofstream();
	cls();
	validateFile(out);//prompts for a file name and checks if it exists, if it doesn't exist it creates it, asks if user wants to append of overwrite.
	for (int i = 0; i < size; i++) {
		out << id[i] << "\t" << usrnames[i] << endl;
	}//loops through the content printing it to a file
	close(out);

}


/// <summary>
/// compares the values by pairs and swaps each pair accordingly 
/// </summary>
/// <param name="id"></param>
/// <param name="names"></param>
/// <param name="size"></param>
/// <returns></returns>
void bubbleSort(int id[], string names[], int size) {

	int temp = int();
	string sTemp = string();
	//print out the unsorted values
	for (int i = 0; i < size; i++)
		cout << id[i] << "\t" << names[i] << endl;
	cout << endl;


	for (int i = 1; i < size; i++) {
		for (int j = 0; j < size - i; j++) {//size-i is the sorted part of the array	
			if (id[j] > id[j + 1]) {//if the value is greater than the next value in the array, swap it
				temp = id[j];
				sTemp = names[j];
				
				id[j] = id[j + 1];//swap the two values
				names[j] = names[j + 1];

				id[j + 1] = temp;
				names[i + 1] = sTemp;


			}//end if
		}//end for
	}//end for

}//end bubbleSort

/// <summary>
///algorithm above
/// </summary>
/// <param name="names"></param>
/// <param name="id"></param>
/// <param name="size"></param>
void bubbleSort(string names[], int id[], int size) {
	int temp = int();
	string sTemp = string();
	//print out the unsorted values
	for (int i = 0; i < size; i++)
		cout << id[i] << "\t" << names[i] << endl;
	cout << endl;


	for (int i = 1; i < size; i++) {
		for (int j = 0; j < size - i; j++) {//size-i is the sorted part of the array	
			if (names[j].compare(names[j + 1]) > 0) {//if the value is greater than the next value in the array, swap it
				temp = id[j];
				sTemp = names[j];

				id[j] = id[j + 1];//swap the two values
				names[j] = names[j + 1];

				id[j + 1] = temp;
				names[j + 1] = sTemp;


			}//end if
		}//end for
	}//end for

	//print out sorted values
	for (int i = 0; i < size; i++)
		cout << id[i] << "\t" << names[i] << endl;
	cout << endl;


}

/// <summary>
/// compares the values to a minimum and swaps it at the next value fo the sorted
/// </summary>
/// <param name="id"></param>
/// <param name="names"></param>
/// <param name="size"></param>
void selectionSort(int id[], string names[], int size) {
	int min = int();
	int temp = int();
	string sTemp = string();
	
	//print out the unsorted values
	for (int i = 0; i < size; i++)
		cout << id[i] << "\t" << names[i] << endl;
	cout << endl;

	for (int i = 0; i < size; i++) {
		min = i;
		//cout << i;
		for (int j = i + 1; j < size; j++)
			if (id[min] > id[j]) {
				//temp = min;
				min = j;
			}//end if
		//swaps
		temp = id[i];
		sTemp = names[i];
		
		id[i] = id[min];
		names[i] = names[min];

		id[min] = temp;
		names[min] = sTemp;


	}//end for


	//print out sorted values
	for (int i = 0; i < size; i++)
		cout << id[i] << "\t" << names[i] << endl;
	cout << endl;



}
/// <summary>
/// algorithm above
/// </summary>
/// <param name="names"></param>
/// <param name="id"></param>
/// <param name="size"></param>
void selectionSort(string names[], int id[], int size) {
	int min = int();
	int temp = int();
	string sTemp = string();

	//print out the unsorted values
	for (int i = 0; i < size; i++)
		cout << id[i] << "\t" << names[i] << endl;
	cout << endl;

	for (int i = 0; i < size; i++) {
		min = i;
		for (int j = i + 1; j < size;j++ )
			if (names[min].compare(names[j]) > 0) {
				//temp = min;
				min = j;
			}//end if
		//swaps
		temp = id[i];
		sTemp = names[i];

		id[i] = id[min];
		names[i] = names[min];

		id[min] = temp;
		names[min] = sTemp;


	}//end for


	//print out sorted values
	for (int i = 0; i < size; i++)
		cout << id[i] << "\t" << names[i] << endl;
	cout << endl;




}


/// <summary>
/// menu for sorts
/// </summary>
/// <param name="id"></param>
/// <param name="names"></param>
/// <param name="size"></param>
void sort(string names[], int id[], int size) {
	int selection = int();
	string options[] = { "Selection Sort Users", "Bubble Sort Users" ,"Go back" };
	cls();
	selection = menu(options, 3);
	switch (selection) {
	case(1):
		selectionSort(names, id, size);

		break;
	case(2):
		bubbleSort(names, id, size);

		break;

		break;
	default://selection 3
		//breaks
		break;
	}//end switch

}//end sort


void sort(int id[], string names[], int size) {
	int selection = int();
	string options[] = { "Selection Sort ID" ,"Bubble Sort ID" ,"Go back" };
	cls();
	selection = menu(options, 3);
	switch (selection) {
	case(1):
		selectionSort(id, names, size);

		break;
	case(2):
		bubbleSort(id, names, size);

		break;

		break;
	default://selection 3
		//breaks
		break;
	}//end switch

}//end sortID


//search algorithms return the index of the desired search item, or return -1 if not found

int binarySearch( string names[], int id[] ,string item, int size) {
	int right = int(size);
	int left = int(0);
	int ind = int();
	cout << "the Binary Sort requires the values to be sorted first" << endl;
	sort(names, id, size);

	//once sorted
	while (right >= left) {
		ind = left + (right - left) / 2;
		if (names[ind].compare(item) == 0)
			return ind;
		else if (names[ind].compare(item) > 0)
			right = ind - 1;
		else
			left = ind - 1;
	}//end while
	return -1;

}

int linearSearch( string names[], string item, int size) {

	for (int i = 0; i < size; i++) {
		if (item.compare(names[i]) == 0)
			return i;

	}//end for
	return -1;//if not found returns -1


}

int binarySearch( int id[], string names[] ,int item, int size) {
	int right = int(size);
	int left = int(0);
	int ind = int();
	cout << "the Binary Sort requires the values to be sorted first" << endl;
	sort(id, names, size);

	//once sorted
	while (right >= left) {
		ind = left + (right - left) / 2;
		if (id[ind] == item )
			return ind;
		else if (id[ind] > item )
			right = ind - 1;
		else
			left = ind - 1;
	}//end while
	return -1;

}

/// <summary>
/// doesn't need to be sorted first, searches each value individually
/// finds first instance
/// </summary>
/// <param name="id"></param>
/// <param name="item"></param>
/// <param name="size"></param>
/// <returns></returns>
int linearSearch( int id[], int item, int size) {
	
	for (int i = 0; i < size -1; i++ ) {
		if (item == id[i])
			return i;

	}//end for
	return -1;//if not found returns -1

}

/// <summary>
/// menu for search algorithms
/// </summary>
/// <param name="id"></param>
/// <param name="names"></param>
/// <param name="size"></param>
void search( int id[], string names[], int size) {//search methods
	//linear search
	//binary search
	int selection = int();
	int rId = int();//returned id
	string sItem = string();
	int iItem = int();

	string options[] = { "Binary Search ID" ,"Linear Search ID" ,  "Binary Search Users" ,"Linear Search Users"  ,"Go back" };
	cls();
	selection = menu(options, 5);
	switch (selection) {
	case(1):

		cout << "Please enter the item you are searching for:" << endl;
		cin >> iItem;

		rId = binarySearch(id, names, iItem, size );
		if (rId != -1)
			cout << id[rId] << "\t" << names[rId] << endl;
		else
			cout << "The value was not found";
		break;
	case(2):
		cout << "Please enter the item you are searching for:" << endl;
		cin >> iItem;
		rId = linearSearch(id, iItem, size);
		if (rId != -1)
			cout << id[rId] << "\t" << names[rId] << endl;
		else
			cout << "The value was not found";
		break;
	case(3):
		
		cout << "Please enter the item you are searching for:" << endl;
		cin >> sItem;
		rId = binarySearch( names, id, sItem, size);
		if (rId != -1)
			cout << id[rId] << "\t" << names[rId] << endl;
		else
			cout << "The value was not found";
		break;
	case(4):
		cout << "Please enter the item you are searching for:" << endl;
		cin >> sItem;
		rId = linearSearch(names, sItem, size);
		if (rId != -1)
			cout << id[rId] << "\t" << names[rId] << endl;
		else
			cout << "The value was not found";

		break;
	default://selection 3
		//breaks
		break;
	}//end switch

}//end searchID()




void main() {					//main class
	//cin is request input from user
	//cout is output to the screen
	//endl is endline 
	//';' ends a statment
	//variables declared with camelHump notation
	//int refers to integer
	//double refers to decimal number or floating point number
	const int SIZE = 18;
	int selection = int();
	bool cont = true;
	int id[SIZE] = { 0 };
	string names[SIZE] = { "" };
	ifstream in = ifstream();
	ofstream out = ofstream();
	string fileName = string();
	//Declaration of variables:
		//initialization and instatiation.
	const string DATE = "November 25 ,2020";//DATE
	const string TITLE = "Halpern_Project11_AccountValidate.cpp";//NAME OF PROGRAM
	//End Declaration of variables
	homeworkHeader(TITLE, DATE);
	readFile(id, names, SIZE);//attempts the default "data.txt" file
	while (cont) {
		selection = menu();

		switch (selection) {
		case(1)://load user files
			cls();
			
			
			cout << "Please enter a file name to read from:";
			cin >> fileName;
			in.open(fileName);
			readFile(id, names, SIZE, in);
			break;
		case(2)://update user data
			updateUsrFile(id, names, SIZE);
			break;
		case(3)://save user data
			cls();
			if (id[0] != 0)
				saveUsrFile(id, names, SIZE);
			else
				cout << "please load or input values to ID and Usernames" << endl;
			break;
		case(4)://search
			if (id[0] != 0)
				search(id, names, SIZE);
			else
				cout << "please load or input values to ID and Usernames" << endl;

			break;
		case(5)://sort by ID
			if (id[0] != 0)
				sort(id, names, SIZE);
			else
				cout << "please load or input values to ID and Usernames" << endl;
			break;

		case(6)://sort by name
			if (id[0] != 0)
				sort(names, id, SIZE);
			else
				cout << "please load or input values to ID and Usernames" << endl;

			break;
		case(7)://exit
			cont = false;

			break;
		
		}//end switch
		pause();
		cls();
	}//end while

	/*
	
int menu() {
	int selection = int();
	cls();
	cout << endl;//blank line for visibility
	cout << right << setw(50) << "=== MENU ===" << endl;
	cout << right << setw(35) << "" << left << "\t1) load user files" << endl;
	cout << right << setw(35) << "" << left << "\t2) update user data" << endl;
	cout << right << setw(35) << "" << left << "\t3) save user data" << endl;
	cout << right << setw(35) << "" << left << "\t4) search by ID" << endl;
	cout << right << setw(35) << "" << left << "\t5) sort by ID" << endl;
	cout << right << setw(35) << "" << left << "\t6) search by username" << endl;
	cout << right << setw(35) << "" << left << "\t7) sort by username" << endl;
	cout << right << setw(35) << "" << left << "\t8) exit" << endl;
	cout << endl << endl << "Which would you like to do ?";
	selection = inputValidation( "Please enter a valid response ","Please enter a value between 1, 8" ,1,8);
	return selection;
}//end menu
	
	*/
	//to pause screen
	

	//Algorithm


	close();

	//return 0; //returns to the system 0 if succesfull , not neccesary for int main () but it is good practice

}//End of main()
//EOF