/*
Ticket : 86713
Course : CMPR 112
Student : Ben Halpern
Instructor : Professor Kirscher
Environment: Win 10 NetBeans
Project Title : Assign 05 - Java Methods




*************************************************
Assignment description: 
*************************************************
Please write these methods.   When appropriate write a driver so basic functionality can be demonstrated.   

 
1) enclose the HomeworkHeader in a method.   Most likely called HomeworkHeader.  

2) Create a second homeworkHeader that takes  a string as a parameter than can be used as a title for the project

3) write three methods to find the minimum value:

3A) one that takes 2 integers

3B) One that takes 3 integers

3C) one that takes 4 integers


4) write a method to tell if a number is even. 

5) write a method  to return a boolean true if a number ( an integer) is a prime. 

6) write a method to return an integer.    the integer is to be  first factor of a number.  ( an integer ) 

example the first factor of  111 is 3.   

example the first factor of 169 is 13. 

You better write it so if there are no factors ( because the number is a prime) it returns a one ?

7) write a method to put out a char , n times

                       an example of a driver to test this would be  putNchars ( 22,  '&');

 

Discussion Questions 

1) what was hard?   

2) is defining the function heading hard?

3) What besides the obvious points of the exercise did you learn?


*/
package module5;
//import javax.swing.JOptionPane;
import java.util.Scanner;
//import java.util.Random;

/**
 *
 * @author benha
 */
public class Assign05 {
    //This assignmnet will consist of multiple modules and a driver
    //the first two methods are homework header methods
    static void homeworkHeader(){
        //homeworkHeader function which when called will produce the homework header
        putChars(30, '=');//displays 10 =
        System.out.println("Homework Header");
        putChars(30, '=');//displays 10 =
        System.out.println("Ticket : 86713");
        System.out.println( "Course : CMPR 112  ");
        System.out.println( "Student : Ben Halpern ");
        System.out.println( "Instructor : Joel Kirscher");
        System.out.println( "Environment: Win 10 NetBeans ");
        System.out.println( "Project Title : Assignment 05 - Java Methods ");
        System.out.println("\n\n");
        //end homework header output
    }//end method homeworkHeader
    
    
    static void homeworkHeader(String title){   //this method is overloaded, takes in a string value for the title
        //homeworkHeader function which when called will produce the homework header

        putChars(30, '=');//displays 10 =
        System.out.println("Homework Header");
        putChars(30, '=');//displays 10 =
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
    
    static int minVal( int a, int b){    //function to find min value of two integers, return the lowest integer
        //logic:
        // if a is greater than b, then b is the minimum value
        //  else return a ( this way if they are the same, then one value is returned )
        if (a > b)
            return b;
        return a;
    }//end method minVal
    
    static int minVal(int a, int b, int c){     //function to find min value of three integers, returns the lowest integer
        //logic:
        //  1) check if a is the lowest one,
        //  2) check if b is the lowest one,
        //  3) if neither a or b are the lowest one then c is the lowest one
        //uses munVal( 2 param ) to create abstraction and make it easier to follow
        if (a == minVal(a,b)){//if a is lower than b 
            if(a == minVal(a,c))//if a is lower than c
                return a;       //return a if is smallest all the way down
            return c;       //if a is lower than b but not lower thn c .: c must be the smallerst
        }//end if
        else if (b == minVal(a,b)){//if b is smaller than a
            if (b == minVal(b, c))// if b is smaller than c
                return b;
            return c;             //if b is smaller than a but not smaller than c .: then the smallest must be c
        }//end else if 
        return c;// if both a and b are not the smaller than the other ( which is impossibly since there are only 2 values ) the result will be c
    }//end method minVal ( 3 params )
    
    //put in method minVal with four parameters here:
    static int minVal(int a, int b, int c, int d){  //minVal function evaluates the lowest value        takes 4 ints and returns an int
        
        //logic: (logic table)
        //
        int[] val = new int[]{a, b, c, d};          //loads it into a array to make it easier to cycle through
        if(a == minVal(val[0], val[1])){//if a is smaller than b
            if (a == minVal(val[0], val[2])){// if a is smaller than c
                if(a == minVal(val[0], val[3]))     //if a is smaller than d, return a
                    return a;
                return val[3];                      // if d is not smaller than a but a is smaller than the rest return d
            }//end if
            else if(c == minVal(val[2], val[3]))    //if a is smaller than b but not smaller than c, check if c is smaller than d
              return val[2];//return c
            return val[3];// if a is smaller than b but not smaller than c, and c is not smaller than d, return d 
        }//end if 
        else{ //if(b == minVal(val[0], val[1])){    //if b is smaller than a
            if (b == minVal(val[1], val[2])){       //if b is smaller than c
                if(b == minVal(val[1], val[3]))     //if b is smaller than d, return b
                    return b;
                return val[3];// if d is not smaller than a but a is smaller than the rest return d
            }//end if
            else if(c == minVal(val[2], val[3]))//if a is smaller than b but not smaller than c, check if c is smaller than d
              return val[2];//return c
            return val[3];// if a is smaller than b but not smaller than c, and c is not smaller than d, return d 
        }//end else
       
    }//end method minVal ( 4 params )
    
    //for the function to determine if the int was prime or not I had to think about it and figure out how to discover if a number is prime
    static boolean isPrime(int a){  //isPrime function evaluates if the int is prime        takes int and returns boolean
        //logic:
        //a number is prime if no other number is divisible by it other than 1 and itself.
        //algorithim: modulos every number until n to see if is divisible and modulos == 0 
        //faster way: check everynumber up until half of the the number. ( int division will cut off the decimal ) since if it is double, it will also be divisible by 2
        //not, start the loop after 1 because 1 is neither prime nor composite
        if ( a == 1){
            System.out.println("Error: 1 is neither prime nor composite");
            return false;
        }//end if
        for(int i = 2; i <= (a/2); i++){
            if(a % i == 0)//if the number is divisible by any number other than itself then it is not prime.
                return false;
        }//end for
        return true;    //if the number succesfully passes through the loop then it is a prime number and return true
        
    }//end method isPrime
    
    static int firstFactor(int a){  //firstFactor evaluates the first factor of the int         takes one int and returns an int
        //logic: same method as the isPrime algorithm, however returns the first result on the way up from 2
        int out = 1;
        int composite = a;//creates local varaible of inputted variable
        for(int i = 2; i <= composite/2; i++){
            //debugging
            //System.out.println(composite + " % " + i + " = " + (composite % i));
            //System.out.println(((composite % i) == 0));
            if( (composite % i) == 0){
                out = i;
                //System.out.println(out);
                return out;
            }//end if
        }//end for
        return out; //if no first factor is found defaults to 1 
        // if the number is prime or no whole factors were found returns 1
    }//end method firstFactor
    
    static boolean isEven( int a ){ //isEven function evaluates if the inputed int is even       takes one int and returns a boolean
        if (a % 2 == 0)// if modulos 2 results in a 0 the number is even
            return true;
        return false;   //if passes over the if statment then its odd and the result is false
        
    }//end isEven method
    
    static void putChars(int numChar, char charr){//putChars function outputs the charr, numChar times      takes two parameters
        while (numChar > 0){//if the numChar > 0 then print out the charr then decrement numChar by one and conitnue until numChar == 0 then stop
            System.out.print(charr);
            numChar --;
        }//end while
        System.out.println();//print a new line after done outputting the line
    }//end method putEquals
    
    static String putChars(int numChar){//this method will be used for testing
        String out = "";
        while (numChar > 0){//if the numChar > 0 then print out the charr then decrement numChar by one and conitnue until numChar == 0 then stop
            out += "&";
            numChar --;
        }//end while
        return out;
        //System.out.println();//print a new line after done outputting the line
    }//end method putEquals
    
    static void driver(){//test case driver
        //Random rand = new Random();//if needed
        //Scanner input = new Scanner(System.in);//if needed, will be commented out if not needed
        //#############################################################################################################2
        System.out.println("commencing driver(fuzzing) testing of homeworkHeader method");
        //System.out.print("putChars: ");
        putChars(15, '*');//creates a line of *
        homeworkHeader("Test Assignment 01 - 60000000000000000000001");
        for(int i = 0; i <= 10; i++){
            System.out.println("test itteration " + i);
            homeworkHeader(putChars(i));
        }//end for
        putChars(15, '*');//creates a line of *
        
        //############################################################################################################3
        //start test cases for minVal (2,3,4 parameters)
        System.out.println("commencing driver(fuzzing) testing of minVal method: ");
        putChars(15, '*');//creates a line of *
        for(int i = 1, a = 1, b = 1 ; i <= 3; i++){
            System.out.println("Test itteration " + i);
            System.out.println("Using parameters: " + a + ", " + b );
            System.out.println("The minimum value is :" + minVal(a,b));
            if(i != 3)
                a += 3;//second itteration a: 4     third itteration:   a:4
            b += 2;//second itteration b: 3     third itteration:   b:5
           // c --;//second itteration c: 2       third itteration:   c:1
        }//end for
        System.out.println("The results of the itteration should be: 1, 4, 5");
        putChars(15, '*');//creates a line of *
        
        //instead of using a for loop to initialize the values for the 3 parameters and the 4 parameters im going to create an array of arrays for each itteration and load those values.
        //the values have been decided by using hand tracing. Need to figure out a better way to pick the test case numbers to use more automation
        int[] case1 = new int[]{1,1,1,1};//case 1
        int[] case2 = new int[]{1,2,1,1};//case 2
        int[] case3 = new int[]{2,2,1,1};//case 3
        int[] case4 = new int[]{2,1,3,1};//case 4
        int[] case5 = new int[]{5,6,7,7};//case 5
        int[] case6 = new int[]{9,2,8,3};//case 6
        int[] case7 = new int[]{12,10,7,8};//case 7     //all even except for 7 so can be used in another test
        int[] case8 = new int[]{13,33,23,1};//case 8    // 2 prime,1 not prime including 1 so can be used in another test
        final int[][] valParam = new int[][]{case1, case2, case3, case4, case5, case6, case7, case8};
        //end initializationg of array of arrays
        
        System.out.println("commencing driver(fuzzing) testing of minVal method: 3 parameters ");
        putChars(15, '*');//creates a line of *
        for(int i = 0; i < 6; i++){
            System.out.println("Test itteration " + (i+1));
            System.out.println("Using parameters: " + valParam[i][0]+ ", " + valParam[i][1] + ", " + valParam[i][2] );//displays the parameters
            System.out.println("The minimum value is :" + minVal(valParam[i][0], valParam[i][1], valParam[i][2]));//runs the method with the above parameters
        }//end for
        //prints out the values of the array to validate 
        /*for debugging purposes
        for(int i = 0; i < 6; i++){
            for(int j = 0; j < 3; j++)
                System.out.print("\tCase " + i + " value" + j + ":" + valParam[i][j] + "\t\t");
            System.out.println();
        }//end for
        */
        putChars(15, '*');//creates a line of *
        //end test cases for 3 param minVal
        
        System.out.println("commencing driver(fuzzing) testing of minVal method: 4 parameters");
        putChars(15, '*');//creates a line of *
        for(int i = 0; i < 8; i++){
            System.out.println("Test itteration " + (i+1));
            System.out.println("Using parameters: " + valParam[i][0]+ ", " + valParam[i][1] + ", " + valParam[i][2] + ", " + valParam[i][3] ); //displays the parameters
            System.out.println("The minimum value is : " + minVal(valParam[i][0], valParam[i][1], valParam[i][2], valParam[i][3]));//runs the method with the above parameters
        }//end for
        //prints out the values of the array to validate 
        /* for debugging purposes
        for(int i = 0; i < 8; i++){
            for(int j = 0; j < 4; j++)
                System.out.print("\tCase " + i + " value" + j + ":" + valParam[i][j] + "\t\t");
            System.out.println();
        }//end for
        */
        putChars(15, '*');//creates a line of *
        //end testcases for 4 parameters
        //end test cases for minVal
        //############################################################################################################4
 
        //test cases for isEven method
        System.out.println();//blank line for visisbility
        System.out.println("commencing driver(fuzzing) testing of isEven method:");
        putChars(15, '*');//creates a line of *
        for(int i = 0; i < 4; i++){
            System.out.println("The number: " + valParam[6][i] + " is even:\t" + isEven(valParam[6][i]));
        }
        System.out.println();//blank line for visibility
        System.out.println("expecting: true, true, false, true");
        System.out.println();//expecting blank line for visibility
        putChars(15, '*');
        //end test cases for isEven method
        //############################################################################################################5

        //test cases for isPrime method
         //test cases for isEven method
        System.out.println();//blank line for visisbility
        System.out.println("commencing driver(fuzzing) testing of isPrime method:");
        putChars(15, '*');//creates a line of *
        for(int i = 0; i < 4; i++){
            System.out.println("The number: " + valParam[7][i] + " is prime:\t" + isPrime(valParam[7][i]));
        }//end for
        System.out.println();//blank line for visibility
        System.out.println("expecting: true, false, true, false ( 1 is neither prime nor composite) ");
        System.out.println();//blank line for visibility
        putChars(15, '*');
        //end test cases for isPrime method
        //############################################################################################################6
        
        //test cases for firstFactor method
        System.out.println();//blank line for visibility
        System.out.println("commencing driver(fuzzing) testing of firstFactor method:");
        putChars(15, '*');//creates a line of *
        System.out.println("The first factor of 111 is " + firstFactor(111));//answer should display 3
        System.out.println("The first factor of 169 is " + firstFactor(169));//answer should display 13
        System.out.println("The first factor of 12 is " + firstFactor(12));//answer should display 3
        System.out.println("The first factor of 11 is " + firstFactor(11));//answer should display 1 because 11 is prime
        System.out.println();//blank line for visibility
        System.out.println("Expecting: 3, 13, 2, 1");
        System.out.println();//blank line for visibility
        putChars(15, '*');//creates a line of *
        //end test cases for firstFactor
        //############################################################################################################7
        
        //test cases for putChars
        System.out.println();//blank line for visibility;
        System.out.println("commencing driver(fuzzing) testing of putChars method:");
        putChars(15, '*');
        System.out.println("Will print out the character '&' 50 times from 0 until 50");
        for(int i = 1; i <=50; i++ ){//will cycle to 50
            System.out.print(i + "\t");
            putChars(i, '&');//will end at printing 50 characters of &
        }//end for
        putChars(15, '*');
        //end test cases for putChars
    }//end method driver
    
    
    static void driver(boolean runAgain){//different signature than the driver above, this driver asks for user input
        
        Scanner input = new Scanner(System.in);//instatiation of scanner object
        int choice;             //the result of the choice which part the user wants to run
        //String jInput = " ";        //jInput is the temporary input for JOptionPane while the input is waiting to 
        
        boolean run = runAgain;//initialize local variable
         while(run){
             int a, b, c, d;             //instatiation of values to be used in minVal // to be reset everytime the loop is run
             String title;                          //initialized for homeworkHeader
            //query the user which program they would like to run:
            System.out.println( "1: Homework Header\n" + "2: Minimum Value (2)\n" + "3: Minimum Value (3)\n" + "4: Minimum Value (4)\n" + "5: Is Even?\n" + "6: Is Prime?\n" + "7: Frist Factor\n" + "8: Put Chars\n"); 
            System.out.println("Please input a number you would like to run:");
            System.out.print("Run number: ");
            choice = input.nextInt();
            if(choice <= 9 && choice > 0){
                switch(choice){//switch to make it easier to pick which part of the code to run

                    case(1)://homeworkHeader
                        System.out.println("Homework Header");
                        System.out.println();//added this because nextLine() would see the previous \n and skip 
                        input.nextLine();    //this nextLine eats the previous line's \n
                        System.out.println("Please input a title: ");
                        title = input.nextLine();
                        System.out.println(title);
                        homeworkHeader(title);
                        break;
                    case(2)://minVal(2)
                        System.out.println("Minimum Value ( 2 parameters ): returns the minimum value");
                        System.out.println("Please input the first value ");
                        a = input.nextInt();
                        System.out.println("Please input the second value ");
                        b = input.nextInt();
                        System.out.println("The minimum value is " + minVal(a,b));
                        break;
                    case(3):
                        System.out.println("Minimum Value ( 3 parameters ): returns the minimum value");
                        System.out.println("Please input the first value ");
                        a = input.nextInt();
                        System.out.println("Please input the second value ");
                        b = input.nextInt();
                        System.out.println("Please input the third value ");
                        c = input.nextInt();
                        System.out.println("The minimum value is " + minVal(a,b,c));
                        break;
                    case(4):
                        System.out.println("Minimum Value ( 4 parameters ): returns the minimum value");
                        System.out.println("Please input the first value ");
                        a = input.nextInt();
                        System.out.println("Please input the second value ");
                        b = input.nextInt();
                        System.out.println("Please input the third value ");
                        c = input.nextInt();
                        System.out.println("Please input the fourth value ");
                        d = input.nextInt();
                        System.out.println("The minimum value is " + minVal(a,b,c,d));
                        break;
                    case(5)://isEven
                        System.out.println("Is Even?");
                        System.out.println("Please input a value to check if it is even ");
                        a = input.nextInt();
                        System.out.println( a + " is even?: " + isEven(a));
                        break;
                    case(6)://isPrime
                        System.out.println("Is Prime?");
                        System.out.println("Please input a value to check if it is prime: ");
                        a = input.nextInt();
                        System.out.println(a + " is prime?: " + isPrime(a));
                        break;
                    case(7)://firstFactor
                        System.out.println("First Factor");
                        System.out.println("Please input a value to find the first factor ");
                        a = input.nextInt();
                        System.out.println("The first factor of " + a + " is  " + firstFactor(a));
                        break;
                    case(8)://putChars
                        System.out.println("Put Chars");
                        System.out.println("Please input the value of the amount of times you want a character to be printed to the screen ");
                        a = input.nextInt();
                        System.out.println("Please print the character you want printed to the screen: ");
                        putChars(a,(input.next().charAt(0)));
                        break;
                    case(9)://hidden case to run my test driver
                        driver();
                        break;
                }//end switch

                //this second JOptionPane prompts the user if they want to quit and exit the loop or rerun and pick another option
                System.out.println("Would you like to run again? (1: yes, 0: no)");
                choice = input.nextInt();
                System.out.println();//blank line for readibility
                if(choice == 0){//if option rerun is picked
                    run = false;
                }//end if
                else if (choice == 1){//if option quit is picked 
                    run = true; 
                }//end else if
            }//end if
            else
                System.out.println("please pick a number between 1 - 8");
        }//end while
    input.close();    
    }//end method driver (overloaded)
     
    public static void main(String[] args){
        //The driver of the methods created above
        //first display homeowork header
        homeworkHeader();
        //calls driver method
        System.out.println("Calling driver method:");
        driver(true);//runs choice driver
        //when prompted for a choice input 9 to see test driver
        System.out.println("End calling of driver method");
    
    }//end public main
    
}//end of public class
//EOF

/*
Discussion Questions 

1) what was hard?   

    Figuring out how many test cases to test was kind of difficult, I tried using hand tracing however was trying to think of a more automated way to pick or cycle through the test cases
    I created a driver so the user could test their own cases as they please of any method

2) is defining the function heading hard?

    No defining the function headers isn't difficult, since it follows a nice set of rules of how to define them. 
    I defined all the functions as static, however that may prove to take up more space in memory if I'm not mistaken

3) What besides the obvious points of the exercise did you learn?

    I feel like I learned alot in debugging. Upon testing my methods a couple resulted in errors as well as an arising issue where nextLine would read the previous inputs \n and skip over, 
    I had to go back and figure out where and what was going wrong.
    I feel like I learned alot in debugging larger programs.


Statement of Completion

Describe what portions of the assignment are done and complete. 
    
    I completed all 9 methods and created a driver that can test them. I aslo created a driver which allows the user to input values to test and run any method they pick.
    There are two homework header methods, one requires a title to be inputed then outputs the homework header with that title to the screen
    The minimum value methods can soert through 2 - 4 different numbers and tell the minimum value out of all of them.
    The isEven method will determine accurately if a number is even or not.
    The isPrime method will determine accurately if a number is prime or not.
    The firstFactor method will determine the first factor of a number ( had a logical error here at first where I had the modulos values switched
    The putChars method ( I created two, one to output symbols into the homework header to test it out ) will take in two parameters ( int and a char ) and will output the
        character as many times inputed (int)
    I feel that all portions of the assignment are complete. If anything I am lacking in some of the comments.

What is missing? 
What caused the incompleteness. 
    
    I would say my possibly lacking in the comments are due to the vast functionality that I tried to implement into the code.
    At times I felt my coding wasn't keeping up with my mind commenting

How do you feel about the assignment or what did you learn while doing it?

    I feel good about the assignment and I feel like a learned alot like mentioned in the discussion questions


*/
