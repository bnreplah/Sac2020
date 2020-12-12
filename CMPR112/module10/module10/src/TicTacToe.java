
/**
 * TicTacToe object
 * @author benha
 */

import java.awt.*;//used for joption pane
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;//used for joption pane 
import java.util.Scanner;
//import java.io.*;
import java.util.Random;
import java.lang.Math;//needed for the seeding of the random generator.
public class TicTacToe {

    //global private final data for the dimensions
    public final int DIM = 3;
    private char[][] board;
    private char userSymb;
    private char compSymb;
    private Scanner in;
    private final boolean debug = false;
    private TicTacToe.CompA_I compA ;
    private TicTacToe.CompB_I compB ;

    //constructor
    /**
     * default constructor, x is player o is computer
     * the board is initialized
     */
    public TicTacToe(){
        board = new char[3][3];
        //instatiates array with char number values
        for (int i = 0; i < DIM; i++){
            for(int j = 0 ; j < DIM ; j++){
                //board[j][i] = (char)('a' + i + (j*3));//loads the board with test values of demonstartion purposes //debugging
                //System.out.println((((char)('a' + i + (j*3))) + " " +i + " " + (j*3)));//debugging
                board[j][i] = (char)((48 + (i + (j*3))));
                //System.out.println(board[i][j]);//debugging

            }//end for
        }//end for loop
        //in = new Scanner( System.in );
        this.userSymb = 'x';
        this.compSymb = 'o';
    }//end TicTacToe constructor, initializes the board variable.
    
    /**
     * secondary constructor,
     * the symbols for the player is initialized
     * the board is initialized
     * @param userSymbol
     * @param computerSymbol 
     */
    public TicTacToe(char userSymbol, char computerSymbol){
        board = new char[3][3];
        //instatiates array with char number values
        for (int i = 0; i < DIM; i++){
            for(int j = 0 ; j < DIM ; j++){
                //board[j][i] = (char)('a' + i + (j*3));//loads the board with test values of demonstartion purposes //debugging
                //System.out.println((((char)('a' + i + (j*3))) + " " +i + " " + (j*3)));//debugging
                board[j][i] = (char)((48 + (i + (j*3))));
                //System.out.println(board[i][j]);//debugging

            }//end for
        }//end for loop
        //in = new Scanner( System.in );
        this.userSymb = userSymbol;
        this.compSymb = computerSymbol;
    }//end TicTacToe constructor, initializes the board variable.
    
    
    /**
     * constructor which allows for the copying fo an array into the object
     * @param gameBoard 
     */
    public TicTacToe(char gameBoard[][]){//arrays are pass by reference
        this.board = new char[gameBoard.length][gameBoard.length];//initializes array size
        //copies the values
        for(int i = 0; i < gameBoard.length ; i++)
            for(int j = 0; j < gameBoard.length; j++)//the IDE recomends System.arrcopy
                this.board[i][j] = gameBoard[i][j];
        this.compSymb = 'o';
        this.userSymb = 'x';
    }//end TicTacToe constructor
    
    /**
     * overlaoded constructor, allowing for a previous board to be imported and for the symbols to be set
     * @param gameBoard
     * @param userSymbol
     * @param computerSymbol 
     */
    public TicTacToe(char gameBoard[][], char userSymbol, char computerSymbol){//arrays are pass by reference
        this.board = new char[gameBoard.length][gameBoard.length];//initializes array size
        //copies the values
        for(int i = 0; i < gameBoard.length ; i++)
            for(int j = 0; j < gameBoard.length; j++)//the IDE recomends System.arrcopy
                this.board[i][j] = gameBoard[i][j];
        this.compSymb = computerSymbol;
        this.userSymb = userSymbol;
    }//end TicTacToe constructor
    /**
     * used to set the symbols held by each user
     * @param userSymbol
     * @param computerSymbol 
     */
    public void setSym(char userSymbol, char computerSymbol){
        this.userSymb = userSymbol;
        this.compSymb = computerSymbol;
    }//end setSym
    
    
    /**
     *Returns the current board 
     *@return  
    */
    public char[][] getBoard(){
        return this.board;
    }
    
    /**
     * overloaded method
     * gets the value at that location
     * @param row
     * @param col
     * @return 
     */
    public char getBoard(int col, int row){
        return this.board[col][row];
    }

    //methods to return the symbol
    /**
     * getter method for the computerSymbol
     * @return 
     */
    public char getCompSymb(){return this.compSymb;}
    
    /**
     * getter method for the stored user symbol
     * @return 
     */
    public char getUserSymb(){return this.userSymb;}
    
    /**
     * method to draw the board to the screen
     */
    public void drawBoard(){
        //System.out.println(board.length);//board length is 3
        System.out.println();//blank line
        System.out.println();//balnk line
        for(int row = 0; row < board.length; row++){
            for(int col = 0; col < board.length; col++){
                if(col != 2) 
                    System.out.print("\t" + board[row][col] + "\t|" );
                else
                    System.out.print("\t" + board[row][col]);
                //System.out.print(col);
            }//end for
            //System.out.print(row);
            System.out.println();//blank line
            if(row != 2)
                System.out.println("\n--------------------------------------------------\n");
            System.out.println();//blank line
        }//end for
        if(debug)System.out.println("Board drawn");
        if(debug)System.out.println("Im in draw Board");
       //visual aide
       //0     |1       |2
       //      |        |
       //=======================
       //3     |4       |5
       //      |        |
       //=======================
       //6     |7       |8
       //      |        |
       //
       //
       //

    }//end drawBoard
    
    /**
     * version to be called on outside arrays
     * @param board 
     */
    public void drawBoard(char[][] board){
        //System.out.println(board.length);//board length is 3
        System.out.println();//blank line
        System.out.println();//balnk line
        for(int row = 0; row < board.length; row++){
            for(int col = 0; col < board.length; col++){
                if(col != 2) 
                    System.out.print("\t" + board[row][col] + "\t|" );
                else
                    System.out.print("\t" + board[row][col]);
                //System.out.print(col);
            }//end for
            //System.out.print(row);
            System.out.println();//blank line
            if(row != 2)
                System.out.println("\n--------------------------------------------------\n");
            System.out.println();//blank line
        }//end for
        if(debug) System.out.println("Board drawn");
        if(debug) System.out.println("Im in draw Board");
       //visual aide
       //0     |1       |2
       //      |        |
       //=======================
       //3     |4       |5
       //      |        |
       //=======================
       //6     |7       |8
       //      |        |
       //
       //
       //

    }//end drawBoard

    /**
     * method to clear/flush the board and replace all the values with 0 or empty spaces
     */
    public void clear(){

        //System.out.print("\u001B[2J");//attempted to clear the screen
        //System.out.flush();
        for(int i = 0; i < board.length; i++)
            for(int j = 0 ; j < board.length; j++)
               board[i][j] = 0;

    }//end clear

    /**
    * gets the players move and breaks down into dimensions for the array.
    * Places symbol in place at that spot.
    * @param move
    * @param symbol
    * @return 
    */
    public int setMove(int move, char symbol){
       int row = move % 3;
       int  col = move / 3;
       if (debug) System.out.println((col) + " : " +(row));//debugging
       //i.e. if move = 5; col = 2; row = 
       board[col][row] = symbol;
       if(debug) drawBoard();
       return move;
    }//end getPlayerMove
    
    /**
     * overloaded void method 
     * @param row
     * @param col
     * @param symbol 
     */
    public void setMove(int row, int col, char symbol){
       //int row = move % 3;
       //int  col = move / 3;
       System.out.println((col) + " : " +(row));//debugging
       //i.e. if move = 5; col = 2; row = 
       board[col][row] = symbol;
       if(debug) drawBoard();
       //return move;
    }//end getPlayerMove
    
    /**
     * method to convert a numerical space value into a row values
     * @param value
     * @return 
     */
    public int convToRow(int value){return value /3 ;}
    
    /**
     * method to convert a numerical value into a col value
     * @param value
     * @return 
     */
    public int convToCol(int value){return value % 3;}
    
    /**
     * method to convert a row and column value into a singular numerical values
     * @param col
     * @param row
     * @return 
     */
    public int convToLeg(int col, int row){return (col*3) + row;}
    
    /**
     * redundant, used for abstraction
    * gets the computer's move and translates into dimensions for the array
    * @param move
    * @param symbol
    * @return 
    */
    public int setCompMove (int move, char symbol){
       return setMove(move, symbol);
    }//end getCompMove
    
    //initializes the compB for use
    public void setCompB(){
        compB = new CompB_I(board);
    }//end setCompB
    
    public void setCompA(){
        compA = new CompA_I();
    }
    
    public int getCompBMove(){
        compB.updateBoard(this);
        return compB.compChoice(this);
    }//end getCompMove
    
    public int getCompAMove(){
        return compA.compChoice();
    }
    
    /**
     * method to check if the value at that spot is empty 
     * @param col
     * @param row
     * @return 
     */
    public boolean isEmpty(int col, int row){
        return board[col][row] == 0; //System.out.println();
        //System.out.println((int)board[row][col]);//debugging
    }//end isEmpty
    
    /**
     * method to check if value at numerical value is empty
     * dependent on convToRow() and convToCol()
     * @param move
     * @return 
     */
    public boolean isEmpty(int move){
        return board[convToRow(move)][convToCol(move)] == 0;
    }//end isEmpty

    /**
     * method to check if that value isWinner and has 3 spots in succession
     * @param symb
     * @return 
     */
    public boolean isWinner(char symb){
        //boolean winner = false;
        int rowItter = 0;
        //boolean inRow = false;
        //int emptySpace = -1;
        //int blockingSpace = 0;
        int diagItter = 0;
        boolean inDiag = false;
        int colItter = 0;
        //boolean inCol = false;
            
        //the last three variables are succesion counters 
        
        //checks diagonal
        if(debug)System.out.println("DIAG");//debugging


        //end declarations

        for(int row = 0, col = 0;  row < this.DIM && col <= this.DIM  ; row++, col++ ){
            if(debug)System.out.println("i:" + row);//debugging
            if(debug)System.out.println("i: " + col);//debugging
            if(debug)System.out.println(this.getBoard(col, row));//debugging
            if(this.getBoard(col,row) == symb)//if symbol is found
                diagItter++;//increase itterator
            

        }//end for
        if(debug) System.out.println("1st inDiag: " + inDiag);

        //if diagItter is less than 2 set reset the inDiag and do next check
        if(diagItter < 3) 
            inDiag = false;
        else//if greater than 2 return value if matched with needing blockign 
            return (diagItter == 3);

        //if first inDiag is false, check the other side
        if(!inDiag){
            diagItter = 0;
            for(int row = this.DIM -1, col = 0;  row >= 0 && col < this.DIM ; row--, col++ ){
                if(debug)System.out.println("i:" + row);//debugging
                if(debug)System.out.println("i: " + col);//debugging
                if(debug)System.out.println(this.getBoard(col, row));//debugging

                if(this.getBoard(col,row) == symb)
                    diagItter++;

                if(debug){ 
                    System.out.println("diagItter: " + diagItter);

                }//end debug if  


            }//end for

        }//end if
        if(debug)System.out.println("2nd inDiag:" + inDiag);//debugging
        if (diagItter == 3)
            return true;


        //end check diagonal

        if(debug) System.out.println("Row");// debugging
        //row check

        //end declarations


        for(int col = 0;  col < this.DIM  ; col++ ){//loops as long as is within bounds, and there are not 2 in a row
            rowItter = 0;//resets itterator if on next row 
            if(debug) System.out.println("col:" + col);//debugging
            for(int row = 0; row < this.DIM; row++){
                if(debug)System.out.println("row: " + row);//debugging
                if(debug)System.out.println(this.getBoard(col, row));//debugging
               
                if(this.getBoard(col,row) == symb)//if symbol found
                    rowItter++;//raise itterator


                if (rowItter ==  3)//if reaches 3 before reset on new row
                    return true;
                
            }//end for
            if(debug){ 
                System.out.println("rowItter: " + rowItter);
            }//end debug if  

            
        }//end for
        //if(debug) System.out.println(inRow);//debugging
        if (rowItter ==  3)//if exits loop at 3
            return true;
        
        //column check
        if(debug) System.out.println("COL");

        //end declarations

        for(int row = 0;  row < this.DIM ; row++ ){//loops as long as the inCol is false and within bounds of array
            if(debug)System.out.println("row:" + row);
            colItter = 0;
            //inCol = false;
            for(int col = 0; col < this.DIM; col++){
                if(debug)System.out.println("col: " + col);//debugging
                if(debug)System.out.println(this.getBoard(col, row));//debugging
                
                if(this.getBoard(col,row) == symb)//if symbol is found
                    colItter++;//raise itterator
                
            if (colItter == 3)
                return true;
            }//end for
            //if(debug)System.out.println("inCol: "+inCol);
            if(debug){ 
                System.out.println("colItter: " + colItter);
            }//end debug if

        }
        //if(debug)System.out.println(inCol);//debugging
        //end for
        return colItter == 3;
    }//end isWinner
   
   
    public boolean isDraw(){
        int spacesFilled = 0;
        for(char[] col : board)
            for(char space : col)
                if(space != 0)
                    spacesFilled++;
        //if neither are winners and all the spaces are full
        
        return !isWinner(userSymb) && !isWinner(compSymb) && spacesFilled == 9;
    }//end isDraw
    
    /**
     *  calls the garbage collector
     */
    public void close(){
        in.close();
        System.gc();
        System.exit(0);//ends and wraps up objects
    }//end close
    
    
    
    /**
     * playing driver
     */
    public void play(){
        in = new Scanner(System.in);//initializes scanner object
        //TicTacToe.CompB_I comp = new CompB_I(board);//used for testing
        int difficulty = 0;
        boolean userStarts = false;
        boolean keepPlaying = true;
        int loopIt = 0;
        int userMove = 0;
        int compMove = 0;
        int compWins = 0;
        int userWins = 0;

        System.out.println("Would you like to go first? (YES : NO):");
        if(in.nextLine().toLowerCase().charAt(0) == 'y'){
            System.out.println("What would you like to play as, enter a character followed by the computer's character(x o): ");
            this.setSym(in.nextLine().charAt(0), in.nextLine().charAt(0));
            System.out.println("You will be playing as " + this.getUserSymb() + " and the computer will be " + this.getCompSymb());
            userStarts = true;
        }//end if
            
        do{//loops as long as the value si not within the input
            
            System.out.println("Which difficulty would you like? (1, 2):");
            difficulty = Integer.parseInt(in.nextLine());
            if(debug)System.out.println(difficulty);
            
                
        }while(difficulty != 1 && difficulty != 2 ); 
        while(keepPlaying){
            System.out.println();
            drawBoard();//draws the legend
            clear();//clears the board for gameplay
            if(difficulty == 2) compB.updateBoard(this);//if hard is chosen update board
            System.out.println();//blank line for visibility
            System.out.println();//blank line for visibility
            System.out.println();//blank line for visibility
            if(userStarts ){
                do{//loops as long as is not a valid move or is taken
                    System.out.println("Please enter a valid your move");
                    userMove = Integer.parseInt(in.nextLine());
                    //userStarts = false;
                    if(debug)System.out.println(isEmpty(userMove));
                }while((userMove >= 9 || userMove < 0) || !isEmpty(userMove) );//if user move is out of bounds of moves or move is not empty
                this.setMove(userMove, userSymb);//sets the user move to the board

            }//end if
            while(!( isWinner(userSymb) || isWinner(compSymb) || isDraw())){//loops as long a no one is the winner and no draw
                //if(userStarts ){
//                do{//loops as long as is not a valid move or is taken
//                    System.out.println("Please enter a valid your move");
//                    userMove = in.nextInt();
//                    //userStarts = false;
//                }while((userMove >= 9 || userMove < 0) && !isEmpty(userMove) );//if user move is out of bounds of moves or move is not empty
//                this.setMove(userMove, userSymb);//sets the user move to the board

                //}//end if
                
                System.out.println();//blank line for visibility
                System.out.println();//blank line for visibility
                System.out.println();//blank line for visibility
                this.drawBoard();//draws the board

                if(difficulty == 2) compMove = compB.compChoice(this);
                else compMove = compA.compChoice();

                if(debug) System.out.println("Computers move: " + compMove);
                this.setCompMove(compMove, compSymb);
                System.out.println("The computer moves");//blank line for visibility
                System.out.println();//blank line for visibility
                System.out.println();//blank line for visibility
                this.drawBoard();
                if(difficulty == 2 )compB.updateBoard(this);
                if(debug)System.out.println("looping?: "+  isWinner(userSymb)  + " : " + isWinner(compSymb) + " : " + isDraw());
                //loopIt++;
                if(isWinner(userSymb))
                    break;
                else if(isWinner(compSymb))
                    break;
                else if (isDraw())
                    break;
                
                do{//loops as long as is not a valid move or is taken
                        System.out.println("Please enter a valid move");
                        userMove = Integer.parseInt(in.nextLine());
                        if(debug)System.out.println(isEmpty(userMove));
                }while((userMove >= 9 || userMove < 0) || !isEmpty(userMove) );//if user move is out of bounds of moves or move is not empty
                this.setMove(userMove, userSymb);//sets the user move to the board

            }//end while
            if(isWinner(userSymb)){
                System.out.println("YOU WONNNNNNN");
                userWins++;
            }//end if
            else if (isWinner(compSymb)){
                 System.out.println("The Computer Won :\'( ");
                 compWins++;
            }//end else if
            else if (isDraw()){
                System.out.println("IT WAS A DRAW");
            }//end draw
            else//trailing else
                System.out.println("There was an error");
            this.clear();
            System.out.printf("%50s%n %31s %35s%n","ScoreBoard","Computer Wins: " + compWins, "User Wins " + userWins);
            System.out.println("Would you like to keep playing? (YES : NO):");
            //in.next();//eats up blank space
            //in.reset();//scanner has a habit of eating up my null space
            keepPlaying = in.nextLine().toLowerCase().charAt(0) == 'y';//if they want to keep playing is true
            //in.nextInt();//to eat up next space
        }//end while
        this.close();//if doesn't want to keep playing
        System.out.println("Bye");
    }//end play
    
    
    
    //methods for the computer algorithm
    //was thinking of providing a minimax algorithm based off game theory, however didn't have the time
    //nor thought it would be appropriate since the user would have little to no chance to winning,
    //created 2 types of algorithms: one that was recommended in class and a prioritization and blocking algorithm
    //random setting simply picks random values and checks to see if they are in use, if they are picks another value
    //choice algorithm prioritizes blocking the user, if the user can't be blocked picks the pivotal points to hold
        //didn't make this algorithm attempt to create the perfect game by also attempting to attempt to test if won and then play that spot,
        //however I did impliment, i believe so the baselines for it and on the lines of that
    
    public boolean getDebugStatus(){
        return this.debug;
    }
    
    
        /**
     * computer choice algorithm option1 selected using random numbers
     * subclass of TicTacToe
     */
    public class CompA_I{
        private final Random rand = new Random( (long)(System.currentTimeMillis() * Math.random()));//instatiates random number generator with a seed fo the current time as the range of a random number 
        
        /**
         * primary random intelligence constructor
         */
        public CompA_I(){//constructor
            //System.out.println(System.currentTimeMillis());//debugging
        }//end public
        
        /**
         * get's the choice from the random number generator
         * uses MATH.random() and time to see the Random() generator from the Random class
         * @return 
         */
        public int compChoice(){
            int choice = rand.nextInt(9);
            while(!isEmpty((choice /3),(choice %3)))//loops as long as the value at that choice is empty
                choice = rand.nextInt(9);
            return choice;//produces a result from 0-8 inclusive of 0 and exclusive of 9
        }//end compChoice
    }//end ComputerAI1
    
    
    /**
     * computer choice algorithm option2 intuitive selection
     * subclass of TicTacToe
     */
    public class CompB_I{
        private final TicTacToe compBoard;//empty char array space to be populated with current board to predict results
        //class methods are not necessarily dependant on recursive object, but if taken out would need to change some functionality.
        
        /**
         * constructor
         * @param currentBoard 
         */
        public CompB_I(char currentBoard[][]){
            compBoard = new TicTacToe(currentBoard);//creates new TicTacToe board with the current symbols
        }//end CompB_I constructor
    
        
        /**
         * 
         * default constructor 
         * uses the outer object's board
           */
//        public CompB_I(){
//            compBoard = new TicTacToe(board);//creates new TicTacToe board with the current symbols
//        }//end CompB_I constructor
//        
        /**
         *checks the sides that are open by importance and sees if available 
         * @return negative value if non of the values are available, otherwise returns the value of the open preferred space.
         */
        public int preferredOpen(){
            if(compBoard.isEmpty(1,1))
                return 4;//if the center is open, take the center.
            //then checks corners
            else if(compBoard.isEmpty(0,0))
                return 0;
            else if(compBoard.isEmpty(0,2))
                return 2;
            else if(compBoard.isEmpty(2,0))
                return 6;
            else if(compBoard.isEmpty(2,2))
                return 8;
            return -1;//return -1 if none of the values are available
        }//end preferedOpen
        
        
        /**
         * checks to see if there are 2 values in a row and returns the third that would result in a winning choice
         * @param symb
         * @return 
         */
        public int checkInRow(char symb){
            if(debug) System.out.println("ROW");
            int emptySpace = -1;
            int blockingSpace = 0;
            int rowItter = 0;
            boolean inRow = false;
            //end declarations
            
            
            for(int col = 0;  col < compBoard.DIM && !inRow ; col++ ){//loops as long as is within bounds, and there are not 2 in a row
                rowItter = 0;//resets itterator if on next row 
                if(debug) System.out.println("col:" + col);//debugging
                for(int row = 0; row < compBoard.DIM; row++){
                    if(debug)System.out.println("row: " + row);//debugging
                    if(debug)System.out.println(compBoard.getBoard(col, row));//debugging
                    if(compBoard.getBoard(col,row) == symb)//if symbol found
                        rowItter++;//raise itterator
                    else if(compBoard.getBoard(col, row) == 0){//if empty space
                        emptySpace = compBoard.convToLeg(col, row);//set emptySpace value
                        if(debug)System.out.println("ES:" + emptySpace);//debugging
                    }//end else if
                    
                    if(compBoard.getBoard(col,row) != symb)
                        blockingSpace = compBoard.convToLeg(col, row);
                    
                    if(rowItter == 2)//if there are 2 in a row
                        inRow = (emptySpace == blockingSpace);//check to see if the blocking space and the empty space are the same
                }//end for
                if(debug){ 
                    System.out.println("blockSpace: " + blockingSpace);
                    System.out.println("emptySpace: " + emptySpace);
                    System.out.println("rowItter: " + rowItter);
                }//end debug if  
            
                if(inRow)
                    return (emptySpace == blockingSpace)? emptySpace: -1;//if the blocking space and empty space are the same then output the empty space, otherwise -1
            }//end for
            if(debug) System.out.println(inRow);//debugging
            return (rowItter < 2)? -1 : ((emptySpace == blockingSpace)? emptySpace: -1);
            //if the row itterator is less than 2 produce -1, if it is greater than 2 check if the blocking space and epty space are the same
            //if the blocking space and empty space are the same then output the empty space, otherwise -1
        }//end checkInRow
        
        
        /**
         * checks to see if in the column there are 2 in a row and returns the third ( if nothing is blocking it ) with the potential to win
         * @param symb
         * @return 
         */
        public int checkInCol(char symb){
            if(debug) System.out.println("COL");
            int emptySpace = -1;
            int blockingSpace = 0;
            int colItter = 0;
            boolean inCol = false;
            
            //end declarations
            
            for(int row = 0;  row < compBoard.DIM ; row++ ){//loops as long as the inCol is false and within bounds of array
                if(debug)System.out.println("row:" + row);
                colItter = 0;
                inCol = false;
                for(int col = 0; col < compBoard.DIM; col++){
                    if(debug)System.out.println("col: " + col);//debugging
                    if(debug)System.out.println(compBoard.getBoard(col, row));//debugging
                    if(compBoard.getBoard(col,row) == symb)//if symbol is found
                        colItter++;//raise itterator
                    else if(compBoard.getBoard(col, row) == 0){//if empty space
                        emptySpace = compBoard.convToLeg(col, row);//set emptySpace value
                        if(debug)System.out.println("ES:" + emptySpace);//debugging
                    }//end else if
                    
                    if(compBoard.getBoard(col,row) != symb)//if not the symbol looking for
                        blockingSpace = compBoard.convToLeg(col, row);//set the blocking space
                    
                    if(colItter == 2)
                        inCol = (emptySpace == blockingSpace);//if the space to block is already taken don't set inCol to true
                }//end for
                if(debug)System.out.println("inCol: "+inCol);
                if(debug){ 
                    System.out.println("blockSpace: " + blockingSpace);
                    System.out.println("emptySpace: " + emptySpace);
                    System.out.println("colItter: " + colItter);
                }//end debug if
                if(inCol)
                    return (emptySpace == blockingSpace)? emptySpace: -1;
            }//end for
            if(debug)System.out.println(inCol);//debugging
            return (colItter < 2)? -1 : ((emptySpace == blockingSpace)? emptySpace: -1);
             //if the row itterator is less than 2 produce -1, if it is greater than 2 check if the blocking space and epty space are the same
            //if the blocking space and empty space are the same then output the empty space, otherwise -1
        }//end checkInCol
        
        /**
         * checks the diagonal for 2 in a row and returns the third value in the efforts to block from winning
         * @param symb
         * @return 
         */
         public int checkInDiag(char symb){
            if(debug)System.out.println("DIAG");//debugging
            int emptySpace = -1;
            int blockingSpace = 0;
            int diagItter = 0;
            boolean inDiag = false;
            
            //end declarations
            
            for(int row = 0, col = 0;  row < compBoard.DIM && col <= compBoard.DIM && !inDiag ; row++, col++ ){
                if(debug)System.out.println("i:" + row);//debugging
                if(debug)System.out.println("i: " + col);//debugging
                if(debug)System.out.println(compBoard.getBoard(col, row));//debugging
                if(compBoard.getBoard(col,row) == symb)//if symbol is found
                    diagItter++;//increase itterator
                else if(compBoard.getBoard(col, row) == 0){//if empty space
                    emptySpace = compBoard.convToLeg(col, row);//set emptySpace value
                    if(debug)System.out.println("ES:" + emptySpace);//debugging
                }//end else if

                if(compBoard.getBoard(col,row) != symb)//if not symbol
                    blockingSpace = compBoard.convToLeg(col, row);//set blocking space

                if(diagItter == 2)//if the diagItterator is 2
                    inDiag = (emptySpace == blockingSpace);//set the inDiag only if the empty space matches the blocking space
            
            }//end for
            if(debug) System.out.println("1st inDiag: " + inDiag);
            if(debug){ 
                System.out.println("blockSpace: " + blockingSpace);
                System.out.println("emptySpace: " + emptySpace);
                System.out.println("diagItter: " + diagItter);
            }//end debug if  
            //if diagItter is less than 2 set reset the inDiag and do next check
            if(diagItter < 2) 
                inDiag = false;
            else//if greater than 2 return value if matched with needing blockign 
                return (diagItter > 2)? ((emptySpace == blockingSpace)? emptySpace: -1) : -1;
            
            //if first inDiag is false, check the other side
            if(!inDiag){
                emptySpace = 0;
                blockingSpace = 0;;
                for(int row = compBoard.DIM -1, col = 0;  row >= 0 && col < compBoard.DIM && !inDiag; row--, col++ ){
                    if(debug)System.out.println("i:" + row);//debugging
                    if(debug)System.out.println("i: " + col);//debugging
                    if(debug)System.out.println(compBoard.getBoard(col, row));//debugging
                    
                    if(compBoard.getBoard(col,row) == symb)
                        diagItter++;
                    else if(compBoard.getBoard(col, row) == 0){
                        emptySpace = compBoard.convToLeg(col, row);
                        if(debug)System.out.println("ES:" + emptySpace);//debugging
                    }//end else if

                    if(compBoard.getBoard(col,row) != symb)
                        blockingSpace = compBoard.convToLeg(col, row);
                    
                    if(debug){ 
                        System.out.println("blockSpace: " + blockingSpace);
                        System.out.println("emptySpace: " + emptySpace);
                        System.out.println("diagItter: " + diagItter);

                    }//end debug if  
            
                    if(diagItter == 2)
                        inDiag = (emptySpace == blockingSpace);
                
                }//end for
                if(inDiag)
                    return (emptySpace == blockingSpace)? emptySpace: -1;
            }//end if
            if(debug)System.out.println("2nd inDiag:" + inDiag);//debugging
            return (diagItter < 2)? -1 : ((emptySpace == blockingSpace)? emptySpace: -1);
        }//end checkInDiag
        
        
        
        /**
         * tests to see if can block the user if it is a winning move
         * attempts to block the user's move
         * 
         * checks the row first, then checks the column, and if 2 use values are found returns the empty spot found
         * same as is winner, but returns the empty value needed to block
         * in future could have them as one method
         * @param symb
         * @return 
         */
        public int checkWin( char symb){//runs through all the checks to see if can block, if not sees if preferred space is open
            if(debug)System.out.println(checkInRow(symb));//end debugging
            if(checkInRow(symb) != -1)
                return checkInRow(symb);
            else if (checkInCol(symb) != -1)
                return checkInCol(symb);
            else if (checkInDiag(symb) != -1)
                return checkInDiag(symb);
            else if(preferredOpen() != -1)
                return preferredOpen();
          return -1;
        }//end int endCheckwin
        
        /**
         * algorithm for conversion to values: (col * 3 )+ row
         * updates the compBoard
         * @param board
         */
        public void updateBoard(TicTacToe board){
            for(int i = 0; i < compBoard.DIM; i++){
                if(debug) System.out.println("i:" + i);//debugging
                for(int j = 0; j < compBoard.DIM; j++){
                    if(debug){
                        System.out.println("j:" + j);//debugging
                        System.out.println("comp board" + (char)compBoard.getBoard(i,j));
                    }//end debugging if
                    if(compBoard.getBoard(i,j) != board.getBoard(i, j))//if the playing board doens't equal the copy
                        compBoard.setMove((i*3) + j, board.getBoard(i,j));//sets the value within the computer's board
                }//end for
            }//end for
        }//end updateBoard
        
        /**
         * gets the computers choice
         * @param board
         * @return 
         */
        public int compChoice(TicTacToe board){
            updateBoard(board);//updates the computer's board
            int move = 0;//for when there is a draw or exhausted options
            //TicTacToe testPlayer = new TicTacToe(userSymb, compSymb);

            //if no spot will stop the user
            //then pick a preferredOpen
            
            if (checkWin(compBoard.getUserSymb()) != -1){//if user symbol doesn't have move to block
                //compBoard.setMove(((checkWin(compBoard.getUserSymb())) != -1)? (checkWin(compBoard.getUserSymb())) :, compBoard.getUserSymb());
                //if(compBoard.isWinner(compBoard.getCompSymb()))//if this truly  makes the computer a winner
                
                if(debug){
                    System.out.println("----- Inside user checks -----");
                    System.out.println("check win of user " + (checkWin( compBoard.getUserSymb()) != -1));
                    System.out.println("Check Win user retruns:" + checkWin(compBoard.getUserSymb()) );
                }//end debugging block
                
                return checkWin(compBoard.getUserSymb());
            }//end else if
            
            if(debug){
                System.out.println("computer Board");//debugging
                compBoard.drawBoard();
                //System.out.println("end debugging");
            
                System.out.println("check win of computer ( if != -1 )" + (checkWin(compBoard.getCompSymb()) != -1));
                System.out.println("check win computer returns: " + checkWin(compBoard.getCompSymb()));
                System.out.println("check preferred Opens" + preferredOpen());
            }//end debugging block
            
            if(checkWin(compBoard.getCompSymb()) != -1){//if the computer has a winnable spot
                compBoard.setCompMove(checkWin(compBoard.getCompSymb()), compBoard.getCompSymb());
                if(compBoard.isWinner(compBoard.getCompSymb()))//if this truly  makes the computer a winner
                    return checkWin(compBoard.getCompSymb());
            }//end if
            
            else if (preferredOpen() != -1){
                return preferredOpen();//return the preferredOpen value
            }//end else if
            //returns -1 if there is an error / cats game draw
            for(int i = 0 ; i < compBoard.DIM; i++)
                for(int j = 0; j< compBoard.DIM; j++)
                    if(isEmpty(i,j))
                        move = compBoard.convToLeg(i, j);
            return move;
        }//end compChoice
        
        /**
         * similar to the getBoard method in the superclass , retrieves the board of the computer
         * @return 
         */
        public char[][] getCompBoard(){return compBoard.getBoard();}
    

       
    }//end class CompB_I

//    public void testCheck(){
//
//        TicTacToe newBoard = new TicTacToe();
//        newBoard.clear();
//        newBoard.setMove(0, userSymb);
//        newBoard.setMove(7, userSymb);
//        
//        newBoard.setCompMove(3, compSymb);
//        newBoard.setCompMove(2, compSymb);
//        newBoard.setCompMove(6, compSymb);
//        newBoard.setMove( 1, userSymb);
//        newBoard.drawBoard();
//        CompB_I test = new CompB_I(newBoard.getBoard());
//        System.out.println(test.checkInRow(userSymb));
//        System.out.println("------------------------");
//        //System.out.println(test.checkInRow(compSymb));
//        System.out.println(test.checkInCol(compSymb));
//        System.out.println("-------------------------");
//        System.out.println(test.checkInDiag(compSymb));
//        System.out.println("---------------------------");
//        System.out.println(test.checkWin(compSymb));
//        
//    
//    } //

    
    
    
 
}//end class




//Discussion Question:

//did  breaking up the functions allow you to test some parts individually?   Did you test?   
    
/*
*   I broke up the function into seperate functions which allowed me to test the parts individually. I had to take 
*       multiple approaches to this. The first time I had function broken up but alot of my funcitonality was in the 
*       computer processing algorithm. This proved very complicated for debugging. Several hours worth, until I decided to
*       start from the beginning. Once rewriting the actions in seperate classes things went by alot smoother.
*
*   I did some testing. At first my I had fallen to some simple mistakes like missing a curly brace here or there, which was very annoying to find
*       Once I found many of the issues things smoothed out. If it weren't for some slight fuzzing and testing, I wouldn't have found these errors
*       The testing allowed me to make my program break and allowed me to strengthen my code and test somethings as well
*/


//How did you approach debugging?

/*
*   My approach to testing was trial and error, then after trial and error I went through the code to slowly hand trace the program.
*   I designed the class to potentially have more future functionality. I had the hopes of incorporating JOptionPane GridLayout to play the TicTacToe game
*   However that along with the debugging was proving to take a little too long. I may impliment it after.
*   By using also using the error thread it allowed me to trace the errors as well which was convinient.
*/
 


/*statement of completion:
* Describe what portions of the assignment are done and complete.
* 
*   As far as I know all portions of the assingments are done and complete. The program prompts the user which difficulty they would,
*       as well as asking for them to set the symbols for the game play ( if they choose to go first ). From there it initializes the game baord
*       Shows the user a legend and then clears the board for game play. It loops while asking the player for thier moves. The hard difficulty takes the
*       current board and ( is meant to, but isn't dependent on it yet ), runs checks on that board and then returns the value of the computers next move to the program,
*       which is then set to the board. Then once again queries the user for a move. It keeps tabs on the amount of points each player has accumulated. There is also the 
*       potential for the game to be Person to Person if implimented. ( I however didn't impliment this as of yet ).
*   
**What is missing? What caused the incompleteness.
*
*   As far as I can tell nothing is missing. The incompleteness however would be the daly in the submission of my code
*   I am a little of a perfectionist, and wanted to keep toying with my code and implementation of it. ( like the possible implementation fo JOptionpane)
*   Also time managament and a heavy workload this week contributed to my delay. ( but of course that is no excuse )
*   I understand that the methods may not be organized in such a structured flow. I had tried to impliment them in a c++ style, where the dependant methods came first.
*   Some of that was not the case in terms fo the computerAlgorithms. I chose to put them at the end. Some of the code doesn't have so many comments, becuase
*   even with some written algorithms for the procedural calls, I had to take alot of trial and error and writing and mapping out to get some of the logic right to figure out where
*   my logical errors were. This could be imporved on in the future.
*   
**How do you feel about the assignment or what did you learn while doing it?
*   
*   I am very proud of my code for the most part. I really like my algorithm for the TicTacToe. It is fairly difficult. Hard to beat,
*   out of 15 games almost all of them ended up being draws, unless the computer started, then it had the advantage but still many draws.
*   If you don't pay attention it can get the upper hand.
*   I learned to write alot fo code and alot fo debugging in single sittings which was pretty fun. I also learned more about JOption pane and how it works
*   Even if it isn't implemented here in the code.
*   
*/