/*
*Ticket : 86713
*Course : CMPR 112
*Student : Ben Halpern
*Instructor : Professor Kirscher
*Environment: Win 10 NetBeans
*Project Title : Assign 03 - Sales Average




Assignment details:

Use JOptionPane to get input from the user.   
Using a while loop.
Input the total sales from a list of sales people.   
Add the sales amounts together and show the total sales and the average sale amount.  
Use a sentinel value to stop the input ( see page 219).   You select the Sentinel value.   
So here would be an example of three sales amounts with a sentinel value of -73

 
Your input and output will look substantically different since you are using JOptionPane.  objects
 

Enter a sales amount : 900.00
Enter a sales amount : 1000.00
Enter a sales amount : 1100.00
Enter a sales amount : -73.0

Thank you
Number of sales figures is 3
Total sales is 3000.00 $
Average sales amount is 1000.00 $

SEE END OF CODE FOR RESPONSE:
Please include inside the code as comments these items:

1) Why is -73.0 as a sentinel value bizarre?

2) what sentinel value did you chose for your program and why or how?

3) did you have any difficult spots?

*
 */
package module3;

//import java.util.Scanner;
import javax.swing.JOptionPane;
import java.text.DecimalFormat;


/**
 *
 * @author BenHalpern
 */
public class Assign03b {

    /**
     * @param args 
     */
    public static void main(String[] args) {
        //instantiation
        //Scanner input;          //creates object of Class Scanner
        //input = new Scanner( System.in );
        
        //Homework Header
        //Homework Header is not displayed with JOptionPane
        System.out.println("Ticket : 86713");
        System.out.println( "Course : CMPR 112  ");
        System.out.println( "Student : Ben Halpern ");
        System.out.println( "Instructor : Professor Kirscher");
        System.out.println( "Environment: Win 10 NetBeans ");
        System.out.println( "Project Title : Assign 03 b - AveSalesWindows ");
        //End of homework header
        
        //define variables
        //instantiation and initialization of variables
        int sales;
        sales = 0;
        //counter for every time the loop runs
        double sumOfSales;
        sumOfSales = 0.0;
            //SumOfSales is the cumilative sum of all inputed values
        double averageOfSales;
        averageOfSales = 0.0;
            //average number of sales = sumOfSales / sales
            //output template
        //defining of sentinel value
        final double SENTINEL = 0.0; //constant use the final operator to turn into immutable
        double userIn = 1.0;
        String input; //for JOption pane to be loaded directly into prior 
        DecimalFormat dFormat = new DecimalFormat("#.##");//keeps doubles to two decimal spaces
        //boolean checkSent;//checks if SENTINEL value was inputed
        //end initialization
        
        
        //pre loop initialization
        //checkSent = userIn >= SENTINEL; // true
        //double temp = 0.0; //temperary variable
        //System.out.println("Please input a negative value when you are done inputting values");
            //Defines the sentinel value to the user
        
        //input while loop
        while(true){            //breaks loop when SENTINEL value is surpassed
            
            //debugging purposes
            //System.out.println("Sales: " +sales);
            
            //System.out.print("\nEnter a Sales amount:");
            input = JOptionPane.showInputDialog ( "Please input a negative value when you are done inputting values \nEnter a Sales amount: ");
            userIn = Double.parseDouble( input ); //parses the input to be put into a double 
                //loads userIn with the next double the user has inputed
            if(!(userIn >= SENTINEL)){
                break;
                //checks to see if SENTINEL value is met before adding to sumOfSales
            }//end if
            
            sumOfSales += userIn;
            
            //debugging purposes
            //System.out.println("Sum of Sales:" + sumOfSales);
            
            //increases the number of sales by 1 ( post-increment )    
            sales++;
        }//end while
        
        //blank line is not needed becuase using JOption Pane
        //System.out.println();            //blank line for readibility
        
        //output
        //algorithm for averageOfSales
        averageOfSales = sumOfSales / sales;
        //could be written on one line but written on multiple for readibility
        JOptionPane.showMessageDialog( null, "Thank you \nNumber of Sales figures is: " + sales + "\nGross sum of Sales is: $" + dFormat.format(sumOfSales) + "\nAverage Sales amount is: $" + dFormat.format(averageOfSales) );
        //JOption pane dialog box
        //end output
        
    }//end public main
    
}//end public class Assign03a
//EOF

//Answers to assignment question
//1) Why is -73.0 as a sentinel value bizarre?
//      -73.0 is a bizarre sntinel value becuase it is an oddly specific sentinel value
//2) what sentinel value did you chose for your program and why or how?
//      I picked the value of any value less than 0, becuase it is unlikely someone wil make negative sales, and is a broad range that will allow for error in the user's case
//      I did this by setting the While loop to true and an if statment that would be triggered if the value that was inputed was less that 0 to break the loop
//3) did you have any difficult spots?
//      I didn't feel like I had any difficulty, since it is the same program as the Assign03 a simply using JOptionPane to query and post input


//Statement of Completion:
//Describe what portions of the assignment are done and complete. 
//      To the best of my knowledge I completed the assignment completly and following the assignment details ( as can be seen in the header of the program )
//What is missing? What caused the incompleteness. 
//      To the best of my knowledge nothing is missing in the assignmnet.
//      I don't understand necessarily where the list of sales people comes from, or how it should displayed, for the moment I am leaving that up to the user until they input a negative value
//How do you feel about the assignment or what did you learn while doing it?
//      I enjoyed the assignment and enjoyed the application of JOptionPane for I feel it is very useful in querying the user. I reused my previous code and commented out lines which used the Scanner instead of JOption Pane