/*
Ticket : 86713
Course : CMPR 112
Student : Ben Halpern
Instructor : Professor Kirscher
Environment: Win 10 NetBeans
Project Title : Assign 02 - Variables and Calculations        
*/
package module2;
import java.util.Scanner;
/**
 *
 * @author BenHalpern
 */
public class Assign02 {

    /**
     * @param args 
     */
    public static void main(String[] args) {
        
        //Instantiation of object Scanner:
        Scanner input;
        input = new Scanner ( System.in );
        
        //Homework Header
        System.out.println("Ticket : 86713");
        System.out.println( "Course : CMPR 112  ");
        System.out.println( "Student : Ben Halpern ");
        System.out.println( "Instructor : Professor Kirscher");
        System.out.println( "Environment: Win 10 NetBeans ");
        System.out.println( "Project Title : Assign 02 - Variables and Calculations ");
        //End of homework header
        
        
        System.out.println();       //Blank line for visibility
        System.out.println();       //Blank line for visibility
        

        //Part1
        //######################################################################
        //Compound interest problem ( Assignment part 1 of 2 ):
        //Write code to show the amount saved each year for 10 years.
        //Algorithm: New Balance = Balance + ( Balance * Interest Rate )
        /*
        Below is a segment of the output: 

        Year Total Savings
        0      3000.00
        1      3120.00
        2      3244.80  
        3      3374.59
        
        4
        . . .
        10   almost 4300 $
        */
        
        
        //Instantiation and initialization of variables
        double balance;
        balance = 0.00;
        double interestRate;
        interestRate = 0.00;
        int years;
        years = 10;
        //End insttization and initialization of variables
        
        System.out.println("Please input a Initial Bank Account value: ");
        balance = input.nextDouble();
        System.out.println("Please input an Interest Rate ( in decimal form, ie: 0.04 is 4 % ): ");
        interestRate = input.nextDouble();
        System.out.println("Please input the amount of years to calculate the compound interest for ( yearly ):");
        years = input.nextInt();
                
        System.out.println();       //Blank line for visibility
        
        //Calculate the yearly compound interest
        //Test of algorithm for debugging purposes
        //Balance = balance + ( balance * interestRate );
        //System.out.print("After a year the balance is: " + balance);
        //The first year compound interest isn't calculated
        System.out.println("Year Total Savings");
        for( int i = 1; i <= years; i++){
            if (i != 1){
                balance = balance + ( balance * interestRate );
                System.out.println("  " +i + " " + balance);
            }//End if statment
            else{                    
                System.out.println("  " + i + " " + balance);
            }//End else statment
        }//End for loop
        
        
        
        System.out.println();       //Blank line for visibility
        
        
        
        //Part2
        //######################################################################
        //Squares and Triangles ( Assignment 02 part 2 of 2 ):
        //Create loops to create shapes 1-4 ( see above )
        
        System.out.println("Shape 1");
        //Shape 1: Rectangle:
        /*
        
            ********
            ********
            ********
            ********
            ********
            ********
            ********
            ********
        
        */
        int numOfLines;
        numOfLines = 8;             //8 lines for the 
        String star;
        star = "*";
        for(int i = 1; i <= numOfLines; i++ ){
            for(int j = 1; j <= 8; j++){
                if(j != 8){
                    System.out.print(star);
                }//End if
                else{
                    System.out.println(star);
                }//End else
            }//End for                    
        }//End for
        //End shape 1
        
        System.out.println();       //Blank line for visibility
        
        System.out.println("Shape 2:");
        //Shape 2
        /*
        
            *
            **
            ***
            ****
            *****   
            ******
            *******
        
        */
        numOfLines = 7;
        for(int i = 1; i <= numOfLines; i++){
        //i <= 7 lines
            for(int j = 1; j <= i; j++){
            //loops until j reaches the current line value
                if(i != j){
                //if i is not on the last itteration print star without a line break
                    System.out.print(star);
                }//End if
                else{
                //if i == j print out the star then line break for the next line
                    System.out.println(star);
                }//End else    
            }//End for
        }//End for
        //End Shape 2
        
        System.out.println();       //Blank line for visibility    
        
        System.out.println("Shape 3:");
        /*
        
            *
            ***
            *****
            ******* 
            *********
            ***********
            *************
        
        */
        numOfLines = 7;
        for(int i = 1; i < (2 * numOfLines); i += 2){
        //loops while iteration is less than 2 times the numOfLines
            for(int s = 2; s <= (i + 1); s++){
            //loops for every value up to the line number + 1
                if(s == (i + 1)){
                //if star number is the last on the line, print and then create a line break
                    System.out.println(star);
                }//End if
                else{
                //if s < i + 1 then print a star, no line break
                   System.out.print(star);
                }//End else
            }//End for
        }//End for
        //End shape 3
        
        System.out.println();       //Blank line for visibility
        
        System.out.println("Shape 4:");
        //Shape 4
        /*
        
        *******
         ******
          *****
           ****
            ***
             **
              *
        
        */
        numOfLines = 7;
        String blank = " ";
        for (int i = numOfLines; i >= 1; i--){
        //loops for i as long as i >= 1
            for (int j = numOfLines; j > i; j--){
            //loops while j > current line number ( 7 -- )
            //number of spaces goes up as the line number goes up
                System.out.print(" ");
            }//End for
            for (int k = 1; k <= i;k++){
            //number of stars goes down as the line number goes up
                System.out.print("*");
            }//End for
            //Creates a new line break at the end of the line
            System.out.print("\n");
        }//End for
        //End Shape 4
        
        
        System.out.println();       //Blank line for visibility
       
        
        
        //Part 3:
        //######################################################################
        //Variable swap
        // Your output should look like this:
        //a = 13 b = 88
        //a = 88 b = 13
        System.out.println("Variable swap:");
        
        
        System.out.println();           //Blank line for readibility
        
        
        System.out.println("Please input a value for a: ");
        
        //Variables initialized
        int a = 13;
        int b = 88;
        int swap;           //swap variable to be temporarily populates
        
        //User defined variables:
        a = input.nextInt();
        System.out.println("Please input a value for b");
        b = input.nextInt();
        
        // below: we do a print to 'see' the values before the swap:
        System.out.println ( "a = " + a + "\t b = " + b );//Professor's code ( pre-display )
        
        // your code to swap the values goes here:
        swap = b;//swap = 88
        //System.out.println("swap: " + swap);     //Debugging
        b = a;//b = 13, swap = 88
        //System.out.println("b: " + b);          //Debugging
        a = swap;//a = swap ( 88 ); b = 13;
        //System.out.println("a: " + a);          //Debugging
        
        // below: we print the values after the swap;  variables and b should have to others variables original values:
        System.out.println ( "a = " + a + "\t b = " + b );//Professor's code ( display )
        //End part 3
        
        
        
        //Part 4
        //######################################################################
        //Professor's code:
        String dog = " and dog";
        String cat = "Cat";
        String out;
        int count;

        // part 4 A:
        out = cat;
        count=3;
        while ( --count >= 0)
            out = out + dog;
        System.out.println ( out ) ;
        
        // part 4 B:
        out = cat;
        count = 3;
        while ( count -- >= 0 )
            out = out + dog;
        System.out.println ( out ) ;
        //End Professor's code
 
        
        //Part 4
        //What is the output of part 4.a code ?
        //      "Cat and dog and dog and dog"
        //What is the output of part 4.b code ?
        //      "Cat and dog and dog and dog and dog"
        //Answer: What is the difference in the code?
        //      part 4.a is using a pre-decrement, and part 4.b is using a post-decrement
        //      pre-decrement decreases the value first before used, Post-decrement decreases the value after it is used
        //Answer: Why and did you predict the difference by just reading the code?
        //      I was able to predict the difference in my head by reading the code because the while loop is reduced by 1 initially in the pre-decrement
        
        //End Part 4
        input.close();               //close the scanner object
        
    }//End public main
}//EOF End public class Module2

//Statement Of Completion
//  What portions of the assignment are done and complete.
//      All portions of the Assignment are done and complete, except for turning it in on time
//  What is missing?
//      Nothing ot the best of my knowledge is missing
//  What caused the incompleteness.
//      The tardiness of the assignment is due to time wasted driving and assesing a plan for evacuation and return ( 
//      However that is no excuse for tardiness and I need to manage my time better with larger coding programs
//  How do you feel about the assignment or what did you learn while doing it?
//      I struggled to visualize the last part of part 2 Shapes, required breaking down the steps and trial and error
//      I liked the Assignment, and how I struggled and it made me think. Not necessarily a straight forward answer
//      Further clarified how to properly integrate 2 loops into another loop