/*
*Ticket : 86713
*Course : CMPR 112
*Student : Ben Halpern
*Instructor : Professor Kirscher
*Environment: Win 10 NetBeans
*Project Title : Assign 03 - Sales Average
*
*

Assignment details:
use Scanner and System.out.println for input and output.
Using a while loop.
Input the total sales from a list of sales people.   
Add them together and show the total sales and the average sale amount.  
Use a sentinel value to stop the input ( see page 219).   You select the Sentinel value.  
https://stackoverflow.com/questions/21666508/can-someone-explain-to-me-what-a-sentinel-does-in-java-or-how-it-works#:~:text=There%20is%20nothing%20special%20about,as%20a%20break%2Fend%20marker.
^^ good example
So here would be an example of three sales amounts with a sentinel value of -73

 
Enter a sales amount : 900.00
Enter a sales amount : 1000.00
Enter a sales amount : 1100.00
Enter a sales amount : -73.0
Thank you
Number of sales figures is 3
Total sales is 3000.00 $
Average sales amount is 1000.00 $

 
SEE END OF CODE FOR THE ANSWERS TO THE FOLLOWING QUESTIONS
Please include inside the code as comments these items:

1) Why is -73.0 as a sentimental value bizarre?

2) what sentinel value did you chose for your program and why 

*
*
 */
package module3;
//import
import java.text.DecimalFormat;
import java.util.Scanner;
/**
 *
 * @author BenHalpern
 */
public class Assign03a {

    /**
     * @param args 
     */
    public static void main(String[] args) {
        //instantiation
        Scanner input;          //creates object of Class Scanner
        input = new Scanner( System.in );
        DecimalFormat dFormat = new DecimalFormat("#.##"); 
        //Instatiates object to allow for doubles to be limited to 2 decimal spaces
        
        
        //Homework Header
        System.out.println("Ticket : 86713");
        System.out.println( "Course : CMPR 112  ");
        System.out.println( "Student : Ben Halpern ");
        System.out.println( "Instructor : Professor Kirscher");
        System.out.println( "Environment: Win 10 NetBeans ");
        System.out.println( "Project Title : Assign 03 a - Sales Average ");
        //End of homework header
        
        //Define variables
        //Instantiation and initialization of variables
        int sales;
        sales = 0;
        //Counter for every time the loop runs
        double sumOfSales;
        sumOfSales = 0.0;
            //SumOfSales is the cumilative sum of all inputed values
        double averageOfSales;
        averageOfSales = 0.0;
            //Average number of sales = sumOfSales / sales
            //Output template
        //Defining of sentinel value
        double SENTINEL = 0.0;      //Constant
        double userIn = 1.0;        //Given a value that would pass in case wanted to use a condition to end the while loop instead of break
        //End initialization
        
        
        //Pre loop initialization and conditions to exit loop
        //Double temp = 0.0; //temperary variable
        System.out.println("\nPlease input a negative value when you are done inputting sales values");
            //Defines the sentinel value to the user
        
        //Input while loop
        while(true){            //Breaks loop when SENTINEL value is surpassed
            
            //Debugging purposes
            //System.out.println("Sales: " +sales);
            
            System.out.print("\nEnter a Sales amount:");
            userIn = input.nextDouble();
                //Loads userIn with the next double the user has inputed
            if(!(userIn >= SENTINEL)){
                break;
                //Checks to see if SENTINEL value is met before adding to sumOfSales
            }//End if
            
            sumOfSales += userIn;
            
            //Debugging purposes
            //System.out.println("Sum of Sales:" + sumOfSales);
            
            //Increases the number of sales by 1 ( post-increment )    
            sales++;
        }//end while
        
        System.out.println();            //blank line for readibility
        
        //output
        
        averageOfSales = sumOfSales / sales;
        //could be written on one line but written on multiple for readibility
        System.out.println("Thank you"); 
        System.out.println("Number of Sales figures is: " + sales);
        System.out.println("Gross sum of Sales is: " + dFormat.format( sumOfSales ) + "$");
        System.out.println("Average Sales amount is: " + dFormat.format( averageOfSales ) + "$");
        //end output
        input.close();
        
    }//end public main
    
}//end public class Assign03a
//EOF

//Answers to assignment questions:
//1) Why is -73.0 as a sentimental value bizarre?
//      -73.0 is a bizare value for a sentinel value because it is so large and specific instead of a commonly used value ( -1 )
//2) what sentinel value did you chose for your program and why 
//      I used a broad range sentinel value of 0 and any value below 0. I did this because I wanted to give the user usability and room for error, so any negative value inputed would result
//      in the loop exiting


//Statement of Completion:
//Describe what portions of the assignment are done and complete.
//      To the best of my knowledge I completed the assignment completly and following the assignment details ( as can be seen in the header of the program )
//What is missing? What caused the incompleteness.
//      To the best of my knowledge nothing is missing in the assignmnet.
//      I don't understand necessarily where the list of sales people comes from, is the assignment asking for their names to be inputed as well? 
//      For the time being I am leaving that up to user to input the values without the names.
//How do you feel about the assignment or what did you learn while doing it?
//      I enjoyed the assignment and enjoyed the application of JOptionPane for I feel it is very useful in querying the user. I reused my previous code and commented out lines which used the Scanner instead of JOption Pane


