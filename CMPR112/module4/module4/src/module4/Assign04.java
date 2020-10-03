/*

    Ticket : 86713
    Course : CMPR 112  
    Student : Ben Halpern
    Instructor : Joel Kirscher
    Environment: Win 10 NetBeans
    Project Title : My first program
#########################################################
 *Assignment details:
#########################################################
Write Two Programs.   

First is a Commision program .   See page 179  Algorithm Workbench.  

Enter the Sales person name and the amount of the sales.  
Then show on the output the name and the gross sales and the commission amount
the commission amount is a percentage of the sales per this table
0 to 10,000 $     10 %
10,000 to 15,000 $ 15 %
15,000 and up 20%
Make the width of the name about 20 to 25 spaces wide. 
format the gross sales and the commission amount to look professional with $ and commas.  
1234.56
John Smith                       1,234.56 $            123.45 $

Note Loop until a null name is input or a zero for the sales amount ( your choice ) 
#########################################################
SECOND PROGRAM
#########################################################
Time Calculator:

input the number of seconds.   then convert the second into hours, minutes, seconds
Output using this format:   hh:mm:ss.   
Again please include a Statement of Completion 
Add comments to say how easy or difficult it was., etc.  
 *
 *
*/
package module4;
//import java.util.Scanner;
//using scanner will also require a (Scanner.object).close(); at the end
import javax.swing.JOptionPane;
/**
 *
 * @author BenHalpern
 */
public class Assign04 {

    /**
     * @param args 
     */
    public static void main(String[] args) {
        //instatiation of Scanner object to request
        //end instatiation of Scanner //the scanner option could be used to do the same thing, however JOptionPane allows for the results to be printed to the scrin without the scanner interfering
        //initialization and instatiation of variables
        int choice = 1;             //the result of the choice which part the user wants to run  
        String associateName;       //instatiating associateName
        String jInput = " ";        //jInput is the temporary input for JOptionPane while the input is waiting to 
        associateName = " ";        //initializing associateName
        int totSec;                 //input given by the user
        boolean runAgain = true;    //boolean condition to see if user would like ro rerun 
        //int hh = 00;              //instatiated in the for loop
        //int mm = 00;
        //int sec = 00;
        //end initialization and instation of variables 
        //homework Header is always required:
        System.out.println("Ticket : 86713");
        System.out.println( "Course : CMPR 112  ");
        System.out.println( "Student : Ben Halpern ");
        System.out.println( "Instructor : Joel Kirscher");
        System.out.println( "Environment: Win 10 NetBeans ");
        System.out.println( "Project Title : Assignment-4 : Commission calculator and TimeConvert ");
        //end of homework header
        
        while(runAgain){
            //query the user which program they would like to run:
            String[] options = new String[]{"Commission Calculator", "Second Convertor"};
            choice = JOptionPane.showOptionDialog(null, "Please pick an option:", "Pick an option", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
            //researched how to use showOptionDialog to produce custom options
            //see https://docs.oracle.com/javase/7/docs/api/javax/swing/JOptionPane.html
            switch(choice){//switch to make it easier to pick which part of the code to run

                case(0)://part 1 of the assignment
                    //first query the user for the associateName and the salesAmount
                    //create a series of if statments within the loop to check what the commisisonRate should be 
                    //multiply the salesAmount by the commissionRate
                    //and loop until the user no longer desires ( blank line or 0 )
                    //assignment header
                    System.out.println("==========Sales Commission Calculator==========");
                    //end assignment header
                    for( double salesAmount = 1, commissionAmount = 0, commissionRate ;!( salesAmount == 0) ; ){// taken out of the loop because it is redundant : associateName.isEmpty() ||
                    //could possible use hasNextLine to check if the next line exists but this doesn't work with JOptionPane
                    //conditions to exit the loop: associateNaem == null or salesAmount == 0
                    //Using JOptionPane so the output is displayed to the screen neatly
                        System.out.println();
                        //blank line for readability

                        //gets input from the user asking for the associateName to display if nothing is entered it exits
                        //note when cancel is pressed the console will get a null pointer error to fix this may need to use a try and throw expression ( not covered yet )
                        associateName = JOptionPane.showInputDialog("Please input a name (enter a blank line when your done) ");    
                        //if( associateName.isEmpty())
                        //    System.out.print(associateName.isEmpty());
                        //associateName = input.nextLine();
                        //System.out.println();
                        //blank line for readability

                        //gets input from the user asking for the sales amount, if a 0 or nothing is inputed then it exits and exits the loop
                        jInput = JOptionPane.showInputDialog("Please input a sales amount (enter a blank line when your done or 0): ");
                        if(jInput.isEmpty()){//if the cancel button is hit will throw null pointer exception
                            salesAmount = 0;
                            //if this if statement is not included will create empty string error because it gets loaded into the salesAmount and can't parse an empty string 
                            //if it is empty sets it to a condition to break the loop
                            //could also use a break statement
                        }//end if
                        else{//otherwise parses the input into salesAmount
                            salesAmount = Float.parseFloat(jInput);//needed to use Float.parseFloat otherwise would have to change the formatting from f to d
                        }//end else
                        //salesAmount = input.nextDouble();
                        //using JOptionPane to query and print results to the screen
                        if (salesAmount > 0 && salesAmount < 10000 ){//if the sales amount is less that 10,000$
                            commissionRate = 0.10;//set the commission rate to 10%
                            commissionAmount = salesAmount * commissionRate;
                            System.out.printf("%-10s %,20.2f $ %,20.2f $\n", associateName, salesAmount, commissionAmount);
                            //formats the string left weighted with a width of 10
                            //salesAmount and commissionAmount is formatted with a precission of 2 decimal places and commas
                        }//end if
                        else if(salesAmount >= 10000 && salesAmount < 15000){//if the inputed sales amount is less than 15,000 and greater than 10,000$
                            commissionRate = 0.15;//set the commission rate to 15%
                            commissionAmount = salesAmount * commissionRate;
                            System.out.printf("%-10s %,20.2f $ %,20.2f $\n", associateName, salesAmount, commissionAmount);
                            //formats the string left weighted with a width of 10
                            //salesAmount and commissionAmount is formatted with a precission of 2 decimal places and commas
                        }//end else if
                        else if(salesAmount >= 15000){//if the inputed sales amount is greater that 15,000 $
                            commissionRate = 0.20;//set the commission rate to 20%
                            commissionAmount = salesAmount * commissionRate;
                            System.out.printf("%-10s %,20.2f $ %,20.2f $\n", associateName, salesAmount, commissionAmount);
                            //formats the string left weighted with a width of 10
                            //salesAmount and commissionAmount is formatted with a precission of 2 decimal places and commas
                        }//end else
                    }//end for
                    System.out.println("================ End ================");
                    //end part 1
                    break;
                    
                case(1):
                    //part 2
                    //Time calculator
                    /***********************************
                    Assignment details:
                    ***********************************
                    * SECOND PROGRAM
                    * Time Calculator:
                    * input the number of seconds.   then convert the second into hours, minutes, seconds
                    * Output using this format:   hh:mm:ss.   
                    * 
                    * 
                    */

                    //first query the user for the time in seconds
                    //then convert that time into minutes and hours and remainder seconds
                    //60 seconds = 1 minute
                    //60 min = 1 hr
                    //24 hr = 1 day
                    //assignment header
                    System.out.println("============Seconds Convertor=============");
                    //end assignment header
                    for(int sec = 1, mm = 1, hh = 1; !(sec == 0 && mm == 0 && hh == 0) ;){
                    //condition to break the loop: if the user inputs a 0 or no value the loop will end
                        jInput = JOptionPane.showInputDialog("Please input the amount of seconds you would like to convert");
                        if(!(jInput.isEmpty())){//if jInput is empty the parsing of an empty character to an int would create an error
                            sec = Integer.parseInt(jInput);
                        }//end if
                        else{
                            sec = 0;//setting sec to 0 will change everything else to 0
                        }//end else
                        //totSec = sec; //used for debugging    
                        mm = sec / 60;  //find out how many minutes
                        sec %= 60;      //find the remainder seconds
                        hh = mm / 60;   //find out how many hours
                        mm %= 60;       //find out how many remainder minutes
                        //output the data in the hh:mm:sec format
                        //I tried to use the printf formatting for the time however it seems that requires the current time and date class
                        //instead I used the d flag to allow me to use printf
                        System.out.printf("%d:%d:%d%n" ,hh,mm,sec);//formatted in the following format hh:mm:ss 

                        //to test the acuracy of the results
                        //totSec = 68135;
            //            int hhh; // hours
            //            int mmm; // minutes
            //            int sss; // seconds
            //
            //            sss = totSec % 60;
            //            System.out.println ( " totSec = " + totSec + " Second = " + sss ) ;
            //            totSec /= 60;
            //            mmm = totSec % 60;
            //            System.out.println ( " totSec = " + totSec + " Minutes = " + mmm);
            //            hhh = totSec / 60;
            //            System.out.println ( " totSec = " + totSec + " Hours = " + hhh);

                    }//end for
                    System.out.println("================ End ================");
                    break;
            }//end switch
            
            //this second JOptionPane prompts the user if they want to quit and exit the loop or rerun and pick another option
            String[] rerunOptions = new String[]{"Run again", "Quit"};//string array of the available options
            choice = JOptionPane.showOptionDialog(null, "Please pick an option:", "Pick an option", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, rerunOptions, rerunOptions[0]);
            if(choice == 0){//if option rerun is picked
                runAgain = true;
            }//end if
            else if (choice == 1){//if option quit is picked 
                runAgain = false; 
            }//end else
        }//end while
    }//end main
}//end of public class
//EOF

//Statement of Completion:
//Describe what portions of the assignment are done and complete. 
//      To the best of my knowledge I completed the assignment to its completion: the program starts by runs in a loop to allow the user to repeat their actions do they deem that their request, they can pick between both part of the assignmnet.
//      I used JOptionPane so that the display could appear on the console in a neat format in order not to interupt the listing of names and sales amounts and commissions as well as for the second convertor 
//      I had initially thought of using scanner however after my first run opted against it for the reasons above
//What is missing? What caused the incompleteness. 
//      To the best of my knowledge nothing is missing in the assignmnet.
//How do you feel about the assignment or what did you learn while doing it?
//      I enjoyed the assignment greatly. It was fun to make an eloquent program. I understand how I could have done it with if statements however we covered switches adn saw the perfect oppurtunity.
//      I also learned how to use JOptionPane.showOptionDialog which was nice. It took some research that started from the null exception being thrown when you hit cancel on the dialog box
//      That I haven't found a way around yet. I saw something online which used try, however in the time to do this assignment I hadn't fully researched into the try and throw statements and wasn't
//      ready for the complexity of those statements as of yet. ( I found multiple ways to get rid of the error, however they all varied vastly ).
//      In the discovery of JOptionPane.showOptionDialog I was also reminded of arrays which was in use, an example in the program is the String array options and rerunOptions.
//      I found this assignment very informative and very fun.
