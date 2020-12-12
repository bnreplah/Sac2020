/*
* Author's Name: Ben Halpern
* Program Name:  Halpern_Project12_Encryption.cpp
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
*	Please complete and submit Encryption Project. 
*	I have uploaded the screenshot of this project on Canvas. Please use at least two string functions of your choosing from chapter-10.
*	Please upload Project-12.cpp file along with the screenshots under this link. Please read the encrypted code from an input file to save time.
*	Please upload the input file in your submission as well.
* 
* notes:
* There are multiple string functions used in this program
*	.at()
*	+= for append
*	+ for concatination
*	.length()
*	string name("name"); //for string assignment
* and possibly mores
*/

#include <iostream>		//input output stream. Preprocessor command to include the input output stream library
#include <conio.h>
#include <fstream>
#include <string>
//#include <cmath>
#include <iomanip>
//#include <cstdlib>	//not used and when included casues the cout and cin to be marked by intellisence as missing 
using namespace std;	//using the standard library ( allows to display simply cout and cin instead of std::cout or std::cin )

//prototypes:
string encryption(string text, int key);
char encrypt(char unenc, int key);
string decryption(string encText, int key);
char decrypt(char cipherChar, int key);


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

void cls() {
	//source:https://stackoverflow.com/questions/17335816/clear-screen-using-c
	cout << "\033[2J\033[1;1H";
	//the escapes translate to clear screen equivalent, supposidly cross platform
	//trying to avoid system("cls"); because its platform dependant
}//end cls

void pause() {//function to pause screen, may need to add cin.ignore prior
	char key = char();
	cout << "Please press enter to continue ... ";
	//cin.ignore();
	key = _getch();
}//end pause


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



int menu(string options[], int size) {
	int selection = int();
	cout << right << setw(50) << "=== MENU ===" << endl;
	for (int i = 0; i < size; i++) {
		cout << right << setw(35) << "" << left << "\t" << (i + 1) << ")" << options[i] << endl;
	}
	selection = inputValidation("Please enter a valid response ", "Please enter a value between 1 - " + to_string(size), 1, size);//string function ( concatination )
	return selection;
}//end menu

void outputFile(ofstream& out) {
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
			out = ofstream(outFileName, ofstream::out | ofstream::app);//appends to file
		else
			out.open(outFileName);							//overwrites file
		cin.clear();										//clears characters from input stream
	}//end if
	else
		out = ofstream(outFileName);								//creates new file
	read.close();//close read

}//end output


//end basic homework hard import




void readFile(string &encrypted, int size, ifstream& file) {
	//the program is set up currently to read "only data" files, no titles, only content.
	cls();
	if (file) {//if the file exists
		cout << "file exists" << endl;
		file >> encrypted;
		close(file);//closes the input stream
	}//end if
	else//if file is false
		cout << "The file doesn't exist" << endl;

}//end readFile

void readFile(int size, string encrypted[], ifstream& file) {//changed the signature, this will read the whole line from the file
	//the program is set up currently to read "only data" files, no titles, only content.
	cls();
	if (file) {//if the file exists
		bool eof = file.eof();
		for (int i = 0; (i < size) && (!eof); i++, eof = file.eof()) {
			getline(file, encrypted[i]);//gets the full line// file encrypted[i];
			//eof = file.eof();
			cout << "read line " << (i + 1) << endl;
		}//end for
		if (!eof) {//if reaches doesn't reach end of file
			cout << "The data was loaded, however not all the data was loaded from the file" << endl;
		}//endif 
		//close(file);//closes the input stream
	}//end if
	else//if file is false
		cout << "The file doesn't exist" << endl;
	
}//end readFile




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
	//fstream file = fstream();
	ifstream in = ifstream();
	ofstream out = ofstream();
	const string DATE("Decemebr 2, 2020");//DATE
	const string TITLE("Halpern_Project12_Encryption.cpp");//NAME OF PROGRAM
	string plainText = string();
	string cipherText = string();
	int key = int();//value to hold the key as inputed from the user
	const int MINKEY = int(1);//min value for the key
	const int MAXKEY = int(127);//max value for the key
	const int MAXFILELEN = int(100);//max possible lines in the file
	string options[] = {"Encrypt", "Decrypt", "Decryption brute force", "Key discovery", "Load encrypted text from file","Decrypt a file ( known key )", "Encrypt a file", "exit"};//5 options
	int optSize = 8;//9;//for the menu
	int selection = int();//for the menu selection
	bool loop = true;
	string loaded[MAXFILELEN] = { "" };//can load up to 100 lines
	string result[MAXFILELEN] = { "" };//for the encrypted/decrypted text
	string fileName = string();
	//End Declaration of variables
	homeworkHeader(TITLE, DATE);
	
	cout << "WWWW   WWWWW   WWWW        EEEEEEEEEEEEE        LLLLL       CCCCCCCCCCCCC      OOOOOOOOOO       MMMMM   MMMMMMM   MMMM    EEEEEEEEEEEEE" << endl
		 << " WWWW WWWWWWW WWWW         EEE                  LLLLL       CCC                OOOO    OOO      MMMMMM MMMMMMMMM MMMMMM   EEE          " << endl
		 << "  WWW WWWWWWW WWW           EEEEEEEEEEEE        LLLLL       CCC                OOOO    OOO      MM  MMMMM     MMMMM  MM    EEEEEEEEEEEE" << endl
		 << "   WWWWWWWWWWWWW           EEE                  LLLLL       CCC                OOOO    OOO      MM   MMMM     MMMM   MM   EEE          " << endl
		 << "    WWWWWWWWWW              EEEEEEEEEEEE        LLLLLLLLL    CCCCCCCCCCCCC     OOOOOOOOOOO      MM   MMMM     MMMM   MM    EEEEEEEEEEEE" << endl;

	cout << "TO THE ROT-N CIPHER " << endl;
	cout << "About Rot-N:" << endl;
	cout << "\t\t Rot ciphers are basic substitution ciphers which rotate the alphabet based off the value of the key" << endl
		<< "\t\tThe more known cesarian cipher is a rot-3 shift" << endl
		<< "\t\tAnother common cipher is the rot-13 cipher, which was previously used in basic security until it was deemd too vulnerable" << endl;
	cout << endl;//blank line for visbility
	cout << endl;//blank line for visibility
	while (loop) {
		selection = menu(options, optSize);
		//there are 5 different types of categories of encryption attacks.
		//included are four
		//	known plain text: access to encryption and key
		//	known cipher text: access to decryption and key
		//	chosen text:	access to only ciphertext, plaintext, and decryption, no key
		//	cipher text only: access to only cipher text and decryption no key or plain text
		switch (selection) {
		case(1):
			//known plain text
			cout << "please enter some text to be encrypted:" << endl;
			cin >> plainText;
			cout << "Please enter a key for the encryption: " << endl;
			cin >> key;
			cout << "the encrypted text is : " << encryption(plainText, key) << endl;
			key = 0;
			pause();
			cls();
			break;
		case(2):
			//known cipher text attack
			cout << "Please enter the text you would like to decrypt:" << endl;
			cin >> cipherText;
			cout << "Please enter the key to decrypt:" << endl;
			cin >> key;
			cout << endl;
			cout << "The decrypted text of " << cipherText << " is " << decryption(cipherText, key) << endl;
			//to pause screen
			pause();
			cls();
			break;
		case(3):
			//key brute force
			//cipher text attack
			cout << endl;
			cout << "Please enter the text that needs to be decrypted:" << endl;
			cin >> cipherText;
			for (key = MINKEY; key < MAXKEY; key++)
				cout << "key: " << key << "\t" << cipherText << "\t" << "decrypted: " << decryption(cipherText, key) << endl;
			pause();
			cls();
			break;
		case(4):
			//chosen text attack
			cout << "Please enter the known plain text and the known cipher text:" << endl;
			cout << "Plain text: ";
			cin >> plainText;
			cout << "Cipher text: ";
			cin >> cipherText;
			for (key = MINKEY; key < MAXKEY; key++) {
				//cout << (encryption(plainText, key).compare(cipherText) == 0) << endl;
				//cout << encryption(plainText, key) << " : " << cipherText << endl;
				if (encryption(plainText, key).compare(cipherText) == 0)
					cout << "found key: " << key << endl;
			}

			pause();
			cls();
			break;

		case(5)://load text from a file to decrypt
			in = ifstream();//resets the file stream in case it was closed
			loaded[1] = "";//loading only a singular value from the file, zeros the value
			cout << "Please enter the name of a file:";
			cin >> fileName;
			in.open(fileName);
			readFile(loaded[1], 1, in);//loads the single word to the encrypted array
			cout << loaded[1] << endl;
			for (key = MINKEY; key < MAXKEY; key++)//loops through all the keys for a possible match
				cout << "key: " << key << "\t" << loaded[1] << "\t" << "decrypted: " << decryption(loaded[1], key) << endl;
			pause();
			cls();
			break;

		case(6)://decrypting whole file, known key
			in = ifstream();
			//cin.ignore();
			cout << "Please enter a key to decrypt the file with:";
			cin >> key;
			cout << "Please enter the name of a file:";
			cin >> fileName;
			in.open(fileName);
			//cin.clear();
			//cin.ignore();
			readFile(MAXFILELEN, loaded, in);//will load full line
			pause();
			if (in) {//if the file exists
				for (int i = 0; i < MAXFILELEN; i++) {
					result[i] = decryption(loaded[i], key);
				}//end for
				outputFile(out);
				cout << "The decrypted file:" << endl;
				for (string line : result) {
					cout << line << endl;
					out << line << endl;
				}//end for
				cout << "sent to file" << endl;
			}//end if
			pause();
			cls();
			break;

		case(7)://enrypt whole file
			in = ifstream();
			//cin.ignore();//to eat up extra space
			cout << "Please enter a key to encrypt the file with:";
			cin >> key;
			cout << "Please enter the name of a file:";
			cin >> fileName;
			in.open(fileName);
			//cin.clear();
			//cin.ignore();
			readFile(MAXFILELEN, loaded, in);//will load full line
			if (in) {//if the file exists
				for (int i = 0; i < MAXFILELEN; i++) {
					result[i] = encryption(loaded[i], key);
				}//end for

				outputFile(out);
				cout << "The encrypted file:" << endl;
				for (string line : result) {
					cout << line << endl;
					out << line << endl;
				}//end for
				cout << "sent to file" << endl;
			}//end if
			pause();
			cls();
			break;
		//case(8):
		//	in = ifstream();
		//	//cin.ignore();
		//	cout << "Please enter a plaintext file with:";
		//	cin >> fileName;
		//	in.open(fileName);
		//	readFile(MAXFILELEN, result, in);
		//	cout << "Please enter the ciphertext of the file:";
		//	cin >> fileName;
		//	in = ifstream(fileName);
		//	//cin.clear();
		//	//cin.ignore();
		//	readFile(MAXFILELEN, loaded, in);//will load full line
		//	for (key = MINKEY; key < MAXKEY; key++) {
		//		//cout << (encryption(plainText, key).compare(cipherText) == 0) << endl;
		//		//cout << encryption(plainText, key) << " : " << cipherText << endl;
		//		if (encryption(loaded[1], key).compare(result[1]) == 0)
		//			cout << "found key: " << key << endl;
		//	}
		//	cin.ignore();
		//	pause();
		//	cls();
		//	break;
		case(8)://exit
			loop = false;
			break;//unreachable statement
		}//end switch
	}//end forever loop
	cls();
	cout << "Bye ! " << endl;
	pause();
	close(out);
	close(in);
	close();
	return 0; //returns to the system 0 if succesfull , not neccesary for int main () but it is good practice

}//End of main()
//encryption

/// <summary>
/// The algorithm for encryption is a rotational cipher. It rotates the values within the basic printable characters 
/// the decreyption could possible be made easier by finding the difference between from the min and max and seelcting the value from an array
/// this would change the encryption but it would also 
/// </summary>
/// <param name="unenc"></param>
/// <param name="key"></param>
/// <returns></returns>
char encrypt(char unenc, int key) {
	char encryptedChar = char();
	if (unenc + key > 126) {
		//cout << ((int)unenc + key) << "," << ((int)unenc + key) - 127 << "," << 32 + (((int)unenc + key) - 127) << endl;//debugging
		encryptedChar = 32 + ((unenc + key) - 127);	// ((x + 10 ) - 127 ) + 32 = y
													//((x + key) - 127) + 32 = y
	}//end if
	else
		encryptedChar = (unenc + key);
	
	return encryptedChar;


}//end encrypt

/// <summary>
/// encrypts string, uses encrypt for each char adding to the string
/// </summary>
/// <param name="text"></param>
/// <param name="key"></param>
/// <returns></returns>
string encryption(string text, int key) {
	string cipherText = string();
	for (int i = 0; i < text.length(); i++) {
		cipherText += encrypt(text.at(i), key);//uses .at() string function
	}//end for
	//cout << "Text has been encrypted" << endl;//debugging
	return cipherText;
	
 }//encryption end
 
//this is a rot cipher
//the first 32 characters of ascii are unprintable
// so the domain is [32, 127] of valid characters.
// in order to create a rotating cipher any characters that are too great are rotated back down
// the same can be applied fi the number is too small and the key can't be subtrated

/// <summary>
/// decrypts each character
/// </summary>
/// <param name="encChar"></param>
/// <param name="key"></param>
/// <returns></returns>
char decrypt(char encChar, int key) {
	char decChar = char();
	if ((encChar - key) < 32) {//if the values falls below the values of readable ascii, take the difference from 32 and add it to 127 then subtract the key
		decChar = ((encChar - 32) + 127) - key;
	}//end if
	else//if the encChar - key > 32
		decChar = encChar - key;
	return decChar;//returns the decrypted char
}//end decrypt

/// <summary>
/// decryption of text, uses decrypt
/// </summary>
/// <param name="encText"></param>
/// <param name="key"></param>
/// <returns></returns>
string decryption(string encText, int key) {
	string cipherText = string();
	for (int i = 0; i < encText.length(); i++) {//using the encText.length() string function 
		cipherText += decrypt(encText.at(i), key);//use of .at() string function, appends the char to the text with the overlaoded oepratior
		//cout << decrypt(encText.at(i), key);
	}//end for
	//cout << "Text has been dencrypted"<< endl;
	return cipherText;
}//encryption end

 
 
 
 //EOF