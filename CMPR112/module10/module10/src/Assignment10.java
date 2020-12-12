/**
*Ticket : 86713
*Course : CMPR 112
*Student : Ben Halpern
*Instructor : Professor Kirscher
*Environment: Win 10 NetBeans
*Project Title : 
*
*
*Assignment details:
* 
Write a tic tac toe game.   Use a 2- d board 3 x 3. 

CAUTION: I will not accept an assignment if you use a one dimensional array for the board.  

 

I suggest using X  for the human tokens and O for the computer tokens.  

 

Nice ergonomics would be nice.  

 

Extra task  :    If you wish add some extras like have multiple ways to say :

You won.   You got this game, good job!    You got it. 

so different responses come out for various situations.  

 

I expect to see a board with a somewhat obvious way to play.   

I expect to see functions that break up the program into reasonable units of work.  I will deduct if this is one giant mess. 

 

Discussion Question:

did  breaking up the functions allow you to test some parts individually?   Did you test?   

How did you approach debugging?
* 
* 
*/

import javax.swing.*;
import java.awt.*;
/**
 *
 * @author benha
 */
public class Assignment10 {
    static void homeworkHeader(String title){   //this method is overloaded, takes in a string value for the title
    //homeworkHeader function which when called will produce the homework header

        System.out.println("Homework Header");
        
        System.out.println();//blank line for visibility
        System.out.println("Ticket : 86713");
        System.out.println( "Course : CMPR 112  ");
        System.out.println( "Student : Ben Halpern ");
        System.out.println( "Instructor : Joel Kirscher");
        System.out.println( "Environment: Win 10 NetBeans ");
        System.out.println( "Project Title : " + title);    //the input from the user is printed out to the screen here
        System.out.println("\n\n");
        //end homework header outputs
    }//end homeworkHeader method
        
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
       homeworkHeader("Assignment 10 - TicTacToe");
       //System.out.println((int)'x' + " " + (int)'o');
       //TicTacToe game = new TicTacToe();
       JTicTacToe game = new JTicTacToe();
       //game.testCheck();
      
       
       //header for TicTacToe game
       for(int i = 0; i < 100; i++)
           System.out.print("+");
       System.out.println();
       System.out.println("\t\t\tW  WW   W   EEEE  L      CCCCCC  OOOOOO  MMM     MM  EEEEEEE ");
       System.out.println("\t\t\tW  W W  W   E     L      C       O    O  M  M   M M  E       ");
       System.out.println("\t\t\tw  W W  W   EEEE  L      C       O    O  M   M M  M  EEEEEEE ");
       System.out.println("\t\t\t W W  W W   E     L      C       O    O  M   M M  M  EE      ");
       System.out.println("\t\t\t  Ww  WW    EEEE  LLLLL  CCCCCC  OOOOOO  M   MMM  M  EEEEEEE ");
       System.out.printf("%60s%n", "TO TIC TAC TOE");
       for(int i = 0; i < 100; i++)
           System.out.print("+");
       System.out.println();
       //game.play();
       //System.out.println( board.isEmpty(1, 1));//debugging
       //System.out.println(board.isEmpty(1, 2));//debugging
       //int x = 20;
       //System.out.println((int)'1');
        
        
    }//end main


}//end class Assignment10




//the following were in a seperate class called TicTacToe.java: