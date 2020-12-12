/*
* Author's Name: Ben Halpern
* Program Name:  Halpern_Project8_RockPaperScissors.cpp
* Date: October 27th, 2020
* College Name: Santa Ana College (SAC)
* CMPR 120
* Professor Aziz
* 
*
*
*####################################################
* Assignment details:
*####################################################
* Please complete and submit Exercise #24 from page 379 from chapter-6 from your book 
* 
* 
*/

#include <iostream>		//input output stream. Preprocessor command to include the input output stream library
//#include <cmath>
#include <iomanip>		//setw(), setprecision()
//#include <string>		//allows for concatination with +
#include <ctime>		//used for seeding srand(time(NULL))
#include <cstdlib>		//rand(), srand()
using namespace std;	//using the standard library ( allows to display simply cout and cin instead of std::cout or std::cin )

//Global variable for choices possible const non malleable varible
const string choices[] = { "rock", "paper", "scissors" };//array of the possible choices

//function needed
	//	homeworkHeader(string title, string date)
	//	string getchoice(string[] choices, Scanner input)
	//	string getchoice(string[] choices)
	//	string getCompChoice(string[] choices)
	//	void displayMenu()
	//	void displayChoices()
	//	void play()
	//if want to overlaod for the ticTacToe objects ( need class ) in order to use 	.compare()
//end functions needed

//prototypes:
void homeworkHeader(string, string);	
void play();							//only the play() prototype needed to run the program becuase the rest are claled within the driver

//string getUserChoice();
//string getchoice(string);//overloaded, for automated testing
//string getCompChoice();
//end prototypes

//Algorithm
	//	-Displays the menu
	//	-the computer generates a value (1 - 3) ( or 0-2 if want to use a choice array ) 
	//	-Asks the play to enter 
	//	-displays the computer's choice
	//	-output the winner
	//optional addition 
	//	-tournament: count the number of games and wins and loss
	//	- create a score board to file
//end algorithm


int main() {					//main class
	//cin is request input from user
	//cout is output to the screen
	//endl is endline 
	//';' ends a statment
	//variables declared with camelHump notation
	//int refers to integer
	//double refers to decimal number or floating point number

	//Declaration of variables://initialization and instatization.
	const string PROJECTNAME = "Halpern_Project8_RockPaperScissors.cpp";//title of the file
	const string PROJECTDATE = "October 27th, 2020";//date of the program
	//string testingValues[] = { "s", "r", "p", "rock", "paper", "scissors", "R", "P","S", "Rah", "Pah", "Scah", "FailMe" };//test values
	//End Declaration of variables

	//HomeworkHeader call
	homeworkHeader(PROJECTNAME, PROJECTDATE);//calls to display homeworkHeader
	play();//runs the play driver ( found near the end of the program )


	//##################################################################################3
	//debugging / testing block
	//##################################################################################3
	//automated debugging
	//for (string test : testingValues){
	//	cout << test << endl;
	//	cout << getChoice(test) << endl;
	//	//system("pause");//debugging
	//}//end testing loop

	//debugging rand()
	/*for (int i = 0; i < 20; i++) {
		cout << (rand() % (RANDMAX + 1 - RANDMIN)) << endl;
	}*/
	//srand(time(NULL));//seeds rand with the current time for randomness
	////this makes the results of rand() different each itteration
	////debugging srand()
	//for (int i = 0; i < 20; i++) {
	//	
	//	cout << (rand() % 10 + 1) << endl;
	//}
	/*for (string choice : choices)
	  cout << choice << endl;*/

	//end debugging / testing
	return 0; //returns to the system 0 if succesfull , not neccesary for int main () but it is good practice

}//End of main()



void homeworkHeader(string title, string date) {
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


}//end homeworkHeader

//function needed
	//	homeworkHeader(string title, string date)
	//	string getUserChoice() reliant on global 
	//	string getChoice(string choice) reliant on global
	//	string getCompChoice() reliant on global
	//	void displayMenu() reliant on global
	//	int checkWinner(string userChoice, string compchoice)
	//	void play()
	//if want to overlaod for the ticTacToe objects ( need class ) in order to use 	.compare()
//end functions needed



/* getUserChoice()
* Queries the user for their choice and converts it into a lowercase form ( uses the first character in order to check that they didn't misspell
*/
string getUserChoice() {//requires <iostream>
	//declarations
	string choice = string();
	bool loopPass = true;
	//end declarations

	//used to set the value of the string in case the user misspells or only inputs a single character
	//if (tolower(choice.at(0)) == 'r')
	//	choice = "rock";
	//else if (tolower(choice.at(0)) == 's')
	//	choice = "scissors";
	//else if (tolower(choice.at(0)) == 'p')
	//	choice = "paper";
	//else {//trailing else
	//	cout << "An incorrect option has been inputted!" << endl
	//		<< "the options are of the following:" << endl;
	//	for (string choice : choices)//loops through the global to show the values possible
	//		cout << choice << endl;
	//}//end trailing else
	
	//this is not necessarily necessary, but it sets the correct values in case of misspellings
	//switch version
	cout << "Please input what you want to play ( rock, paper, scissors):" << endl;
	cin >> choice;
	do{//loops and if the value doesn't start with r, p , or s, then it will return loop quering another response.
		loopPass = true;
		switch (tolower(choice.at(0))) {
		case ('r'):	//if starts with r
			choice = "rock";
			loopPass = true;
			break;

		case('p')://if starts with p
			choice = "paper";
			loopPass = true;
			break;

		case('s')://if starts with s
			choice = "scissors";
			loopPass = true;
			break;

		default:
			cout << "An incorrect option has been inputted!" << endl
				<< "the options are of the following:" << endl;
			for (string choice : choices)//loops through the global to show the values possible
				cout << choice << endl;
			loopPass = false;
			cin >> choice;
			//cin.clear();//attempts to clear inputstream//not needed
			break;
		}//end switch

		 //cout << choice << endl;//debugging
	}while(!loopPass);
	return choice;
}//end getUserChoice


//function for testing functionality through automation
/**
*	does the same thing as getUserChoice, however with an inputted value
*	The purpose of this is for automated testing and getting the computers choice.
*/
string getChoice(string choice) {//parameter string choice , note will return the false value if it exists
	//string choice = string();
	//declarations
	bool loopPass = true;
	//end declarations

	//used to set the value of the string in case the user misspells or only inputs a single character
	//if (tolower(choice.at(0)) == 'r')
	//	choice = "rock";
	//else if (tolower(choice.at(0)) == 's')
	//	choice = "scissors";
	//else if (tolower(choice.at(0)) == 'p')
	//	choice = "paper";
	//else {//trailing else
	//	cout << "An incorrect option has been inputted!" << endl
	//		<< "the options are of the following:" << endl;
	//	for (string choice : choices)//loops through the global to show the values possible
	//		cout << choice << endl;
	//}//end trailing else

	//switch version
	//do {
	switch (tolower(choice.at(0))) {//checks the input based off the first letter
	case ('r')://if starts with r
		choice = "rock";
		break;

	case('p')://if starts with p
		choice = "paper";
		break;

	case('s')://if starts with s
		choice = "scissors";
		break;

	default:
		//cout << "An incorrect option has been inputted!" << endl
		//	<< "the options are of the following:" << endl;
		//for (string validChoice : choices)//loops through the global to show the values possible
		//	cout << validChoice << endl;
		//loopPass = false;
		////cin.clear();//attempts to clear inputstream
		////for automated loop
		////system("pause");//debugging pause
		//loopPass = true;//only used for the automation otherwise will be sent into a endless loop
		return "";
			
		break;
		}//end switch
		//cout << choice << endl;//debugging
	//} while (!loopPass);
	return choice;
}//end getChoice



/**getCompChoice function
*	gets a random value and returns that value as the computers choice
*	is reliant on <cstdlib> rand() and srand(). If seed is present in containing function then it is seeded, otherwise nto seeded
*/
string getCompChoice() {//no params, requires cstdlib
	//declarations
	const int RANDMAX = 3;
	//const int RANDMIN = 1;
	//compChoice = rand() % (RANDMAX + 1 - RANDMIN);
	int compChoice = rand() % (RANDMAX); //range is from [0,2] ( inclusive )
	//end declarations

	//cout << compChoice << endl;//debugging
	return choices[compChoice]; //returns the value at the 
}//end getCompChoice
 
 /** checkWinner function
 *	Will compare the user's choice and the computer's choice and return a winner(int). -1 is the computer, 1 is the user, 0 is draw
 *  checks winner of each round
 */
int checkWinner(string userChoice, string compChoice) {//parameters are string userChoice, compChoice
	// index values which beat each other:
		//0 < 1 : paper beats rock
		//1 < 2 : scissors beats paper
		//2 < 0 : rock beats scissors
	if (userChoice == compChoice)
		return 0;
	if (userChoice == choices[0]) {//player plays rock
		if (compChoice == choices[1])//computer needs paper
			return -1;
		else //if computer doesn't put paper then it loses
			return 1;
	}//end if
	else if (userChoice == choices[1]) {//player plays paper
		if (compChoice == choices[2])//computer needs scissors 
			return -1;
		return 1;//else computer loses
	}//end if
	else if (userChoice == choices[2])//computer plays 
		if (compChoice == choices[0])//if computer needs rock
			return -1;
	return 1;//else the player wins
 }//end checkWinner



/*displayMenu function
* displays the header of the game
*/
void displayMenu() {//requires iomanip
	for (int i = 1; i <= 155; i++)//creates border of welcome screen
		cout << "#";
	cout << endl;//blank line for visibility
	cout << endl <<setw(45) << "" << setw(45) << left << "ROCK PAPER SCISSORS \n" << right << endl;//extra blank line for visibility //uses right to change the formatting back
	cout <<"      rrrrooooooccccckkkkk           ppppppaaaappppeeeeer     sssssssccccciiii                                 \n"
		<< "   rrrrr   oooooo   ccc kkkkk        pa   ~~~~~~~~    per     ssss      ccciii           sooooooooorrrrrss      \n"
		<< "   rrrrrrr \\ o0oo\\ oooo  cckkkk      pa   ~~~~~~~~    per     sscccciiiiiiissssoo    rrrrrrrrrrrrrrrrrrrrr      \n"
		<< "   rrrrrr        oo   ockkkk         pa   ~~~~~~~~    per     sssssscccciiiiiiiiisssssssoooorrrrr               \n"
		<< "     rrooooo   oooooo cckk           pa               per     sssssscccciiiiii  ssssssoooorrr                   \n"
		<< "     roooooooccc  kkkkkkkkk          pa   ~~~~~~~~    per                      ssss                             \n"
		<< "      roooooockkkkkkkkkk             pa        ~~~    per     sssssssscccciiiiii    iiiissssrrrrrr              \n"
		<< "          roockkkkk                  pppppppappppeeerrrr      sscc      iiisssc      cooooororrrrssssssssssss   \n"
		<< "            rock                     pppappppppepeeeeerr      sssccccc iisssors          ssssssssssssssssssss  \n"
		<< endl;
	cout << endl;//blank line for visibility
	for (int i = 1; i <= 155; i++)//creates lower border of welcome screen
		cout << "#";
	cout << endl;//blank line for visibility

	cout << endl;//blank line for visibility
	cout << endl;//blank line for visibility
	cout << endl << setw(45) << "" << setw(45) << left << "RULES\n" << right << endl;
	for (int i = 1; i <= 155; i++)//creates Horizontal line
		cout << "_";
	cout << endl; ///blank line for visbility
	cout << endl;//blank line for visibility
	cout << "-- If one player chooses rock and the other player chooses scissors, then rock wins.\n"
		<< "(The rock smashes the scissors.)\n"
		<< "-- If one player chooses scissors and the other player chooses paper, then scissors wins.\n"
		<< "(Scissors cuts rock.)\n"
		<< "-- If one players chooses paper and the other player chooses rock, then paper wins.\n"
		<< "(Paper wraps rock.)\n"
		<< "-- If there is a draw, you can either choose to keep playing, or forfeit\n"
		<< "(Draws are not counted towards wins)\n";
	cout << endl;//blank line for visibility
	cout << endl;//blank line for visibility
}//end displayMenu


/**playAgain function
*	takes no parameters and asks if the user would like to play again
*/
bool playAgain() {
	//declarations
	string response = string();
	//end declarations

	cout << endl <<"Would you like to play again ( yes or no ):";
	cin >> response;
	return (tolower(response.at(0)) == 'y') ? true: false;// if the user says yes or any varaition with a y in the start then true, else false
}

/**finalScoreBoard
*	Checks the tournament style winner and then displays the winner
*/
void finalScoreBoard( int playerScore, int drawScore, int computerScore){
	//declarations
	string winner = string();//the winner string
	if ((playerScore > computerScore) || (playerScore < computerScore)) {//if not draw
		if (playerScore > computerScore)//check if user won
			winner = "!!!!!!YOU WIN!!!!!!";
		else//otherwise the computer won
			winner = "THE COMPUTER WON!!!!";
	}//end if
	else//if a draw is higher
		winner = "IT'S A DRAW!!!!!!";
	//end delcarations

	for (int i = 1; i <= 155; i++)//prints out upper boarder
		cout << "=";
	cout << endl;
	cout <<left << setw(55) << "===" << setw(70) << winner << right << setw(30) << "===" << endl;//print out who won


	for (int i = 1; i <= 155; i++)//prints out lower border
		cout << "=";
	cout << endl;
}//end finalScoreBoard


/**play function
* plays and loops as long as player would like to keep playing
* driver function for all the rock paper scissor functions
*/
void play() {//requires ctime, cstdlib
	//play variable declarations
	int playerWins = int();				//number of player wins
	int computerWins = int();			//number of computer wins
	int draws = int();					//number of draws
	srand(time(NULL));					//will be put in the play function
	string userChoice = string();		//getUserChoice();
	string compChoice = getCompChoice();
	bool keepPlaying = true;
	//end play declarations

	displayMenu();//displays the header art and displays the rules
	
	//didn't set a force play on draw.
	while (keepPlaying) {//loops as long as the player would like to still play 
		userChoice = getUserChoice();//gets the user choice
		cout << endl;//blank line for visibility
		cout << setw(40) << "" <<setw(15) << "Your Choice: " << left << userChoice << left <<setw(20) << "" << setw(20) << right << "Computer's choice: " << compChoice << endl;
		cout << endl;//blank line for visibility
		//for (int i = 0; i < 20; i++)//debugging the computer choice
		//	cout << "Computer's Choice " << getCompChoice() << endl;
		switch (checkWinner(userChoice, compChoice)) {
		case (-1):
			cout << endl;//blank line for visibility
			cout << compChoice << " beats " << userChoice << endl;
			cout << "The computer beat you! (>-.-<)" << endl;//losing message with sad face 
			computerWins++;
			break;
		case (0):
			cout << endl;//blank line for visibility
			cout << "It's a draw" << endl;//its a draw so add to draw
			//keepPlaying = true;//forces play when draw is hit
			draws++;
			break;
		case (1):
			cout << endl; //blank line for visibility
			cout << userChoice << " beats " << compChoice << endl;
			cout << "You WON!!! ^(U u U)^ " << endl;//winning message with happy face
			playerWins++;
			break;
		default://if for some reason the function checkWinner gives a different valeu outside the range
			cout << "ERROR has occured" << endl;
			break;
		}//end switch
		cout << setw(70) << "Score Board" << endl;
		for (int i = 1; i <= 155; i++)
			cout << "_";
		cout << endl; //blank line for visibility
		cout << setprecision(1);
		cout << setw(35) << "User Wins: " << playerWins << setw(35) << "Draws: " << draws << setw(45) << "Computer Wins:" << computerWins << endl;
		cout << endl;//blank line for visibility
		cout << endl;//blank line for visibility
		compChoice = getCompChoice();//gets the next computer choice if wishing to keep playing
		keepPlaying = playAgain();
	}//end for loop

	finalScoreBoard(playerWins, draws, computerWins);//displays the winner
 }//end play
 
 //idea for addition:
//give the option to print out to a file / append, the score board with a name and ranking. Will requrie rankings to be updated, along with the date.
 //EOF
