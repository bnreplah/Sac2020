/**
 * TicTacToe class use to create a graphical interface fo the TicTacToe application
 */


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.*;
import javax.swing.*;
import javax.swing.JOptionPane;
import java.awt.ActiveEvent;
//import javax.swing.event.*;
import java.awt.event.ActionListener;
import java.awt.event.*;
import java.util.Random;

//import java
import java.awt.*;
/**
 *
 * @author benha
 */
public class JTicTacToe extends JFrame {
    private JButton[][] buttons = new JButton[3][3];
    private JLabel prompt;
    private JLabel startLabel;
    private boolean userStarts;
    private JButton esButton;
    private JFrame board;
    private JFrame start;
    private TicTacToe game;
    private final int EXIT = -1;
    private final int PLAY = 9;
    
    /**
     * default constructor
     */
    public JTicTacToe(){
        this.game = new TicTacToe();//creates the game of TicTacToe
        buttonListener bL = new buttonListener();
        
        //setTitle("Tic Tac Toe");//sets the title

        computerBuild(bL);
        buildBoard(bL);
                
        
        
    }//end JTicTacToe

    private void computerBuild(buttonListener bL){
        JFrame compChoice = new JFrame("Which computer do you want to play against?");
        JLabel compPrompt = new JLabel("Which computer do you want to play against?");
        JButton easy = new JButton("Easy");
        easy.addActionListener(bL);
        easy.setActionCommand("easy");
        JButton hard = new JButton("Hard");   
        hard.addActionListener(bL);
        hard.setActionCommand("hard");
        this.prompt = new JLabel("Please click on a square to play at that square");
        this.esButton = new JButton("Begin Play");
        this.esButton.addActionListener(bL);
        this.esButton.setActionCommand(String.valueOf(9));
        //GridBagConstraints gbc = new GridBagConstraints();
        compChoice.add(compPrompt);
        compChoice.add(easy);
        compChoice.add(hard);
        compChoice.add(prompt);
        compChoice.add(esButton);
        compChoice.setSize(300,300);
        compChoice.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//sets the application to close upon closing
        compChoice.setVisible(true);
        compChoice.setLayout(new GridBagLayout());
        compChoice.pack();
        
    }
    
    private void buildBoard(buttonListener bL){
        Random rand = new Random(System.currentTimeMillis());//seeds random generator

        for(int i = 0; i < 3; i++)
            for(int j = 0; j < 3; j++){
                this.buttons[i][j] = new JButton();
                this.buttons[i][j].setText(String.valueOf((i*3)+j));
                this.buttons[i][j].setActionCommand(String.valueOf((i*3)+j));
                //board.add(buttons[i][j]);
                //buttons[i][j].addActionListener(this);//because impliments ActionListener allows this
                this.buttons[i][j].addActionListener(bL);//referecnes the bL object which is a built listenenr that overidea the ActionPerformed of the ActionListener implementation

            }//end for
        
        //compChoice.add(compPrompt);
        JLabel empty[] = new JLabel[3];
        empty[0] = new JLabel();
        empty[1] = new JLabel();
        empty[2] = new JLabel();
        this.userStarts = (rand.nextInt()*(2) == 1);
        this.board = new JFrame("TicTacToe");
        
        //this.startLabel = new JLabel("Your turn");
        

        //this.board.add(prompt);
        //if(userStarts) board.add(startLabel);
        
        //this.board.add(esButton);

        
        
        
       
        
        for(int i = 0; i < 3; i++)
                for(int j = 0; j< 3; j++){
                    board.add(buttons[i][j]);//sets all the value to blank strings
                    //gbc.gridy = i + 1;
                    //gbc.gridx = j;
                    //gbc.
                }
        
        this.board.setLayout(new GridLayout(3,2));
        this.board.setVisible(true);
        this.board.setSize(350, 350);
        this.board.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//sets the application to close upon closing
        //board.pack();
    }//end buildBoard
    
    
    
    public class buttonListener implements ActionListener{
            
    @Override //tells the compiler overiding actionsPerformed of the abstract class
    public void actionPerformed( ActionEvent e){//when actionListener or any listener is activated the following commands are done
        final String action = e.getActionCommand();
        if(game.getDebugStatus())System.out.println(action);//debugging
        game.clear();
        if(Integer.parseInt(action) == PLAY){
            esButton.setText("Exit");
            esButton.setActionCommand(String.valueOf(EXIT));//change the action command value
            prompt.setText(prompt.getText() + "\nPlease press a square to set your move");
            for(JButton[] col: buttons)
                for(JButton row: col){
                    row.setEnabled(true);
                    row.setText(" ");//sets all the value to blank strings
                }//end for
        }//end if
        while(game.isWinner(game.getCompSymb())||game.isWinner(game.getUserSymb())||game.isDraw()){
            if(!userStarts){
                //the user doesn't start so needs to get the computers move
                
                int compMove = (action == "easy")? game.getCompAMove(): game.getCompBMove();
                game.setCompMove(compMove, game.getCompSymb());//gets and sets the computers move
                userStarts = true;
                buttons[game.convToCol(compMove)][game.convToRow(compMove)].setEnabled(false);//turns off the button from use
                for(int i = 0; i < 3; i++)//updates the buttons to match the board
                    for(int j = 0; j < 3; j++)
                        buttons[i][j].setText(String.valueOf(game.getBoard(i,j)));//sets all the value to blank strings
            }//end if
            else if(userStarts){
                if(action != String.valueOf(EXIT)){
                    int userMove = Integer.parseInt(action);
                    game.setMove(userMove, game.getUserSymb());//gets and sets the computers move
                    userStarts = false;
                    buttons[game.convToCol(userMove)][game.convToRow(userMove)].setEnabled(false);//turns off the button from use
                    for(int i = 0; i < 3; i++)//updates the buttons to match the board
                        for(int j = 0; j < 3; j++)
                            buttons[i][j].setText(String.valueOf(game.getBoard(i,j)));//sets all the value to blank strings

                }//end if
        }//end elseif
        
        }//end while
            if(game.isWinner(game.getCompSymb()))
                prompt.setText("THE COMPUTER WON!!!");
            else if(game.isWinner(game.getUserSymb()))
                prompt.setText("YOU WON !!!!!");
            else if(game.isDraw())
                prompt.setText("IT WAS A DRAW");
            else//trailing else
                prompt.setText("There was an error");
            
            esButton.setActionCommand(String.valueOf(PLAY));
            esButton.setText("Play again?");
        
        //if()
        
        }//end actionPerformed
        
    }//end buttonListener
}//end class JTicTacToe
