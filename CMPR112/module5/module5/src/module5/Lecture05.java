/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package module5;
import java.lang.*;

/**
 *
 * @author benha
 */
public class Lecture05 {
    //to define a method need:
  ///syntac  
    //identifier
    //data_type identifier(varaible name, function name, class name );
    //void is the nonexistent data type
    
    
    static void homeworkHeader(){
        //homeworkHeader function which when called will produce the homework header
        System.out.println("Ticket : 86713");
        System.out.println( "Course : CMPR 112  ");
        System.out.println( "Student : Ben Halpern ");
        System.out.println( "Instructor : Joel Kirscher");
        System.out.println( "Environment: Win 10 NetBeans ");
        System.out.println( "Project Title : My first program ");
        System.out.println("\n\n");
        //end homework header output
    }//end method homeworkHeader
    
    static int addition( int a){
        return a + 1;
    }//end method addition
    
    static int area(int base, int height){
        return (base * height);
        
    }//end method area
    
    //can create a pu blanks function and incorporate it into the putEquals
    static void putBlanks(int numChar){
        while (numChar > 0){
            System.out.print(" ");
            numChar --;
        }//end while
        
    }//end putBlanks method
    static void putEquals(int numChar){
        putBlanks(2);
        while (numChar > 0){
            System.out.print("=");
            numChar --;
        }//end while
        System.out.println();
    }//end method putEquals
    
    //can create a pu blanks function and incorporate it into the putEquals
    static void doTheAssignment(){
        System.out.println("");
        int numberStudentsPres = 23;
        System.out.println("There are " + numberStudentsPres + " tudents present");
        numberStudentsPres = (addition(numberStudentsPres));//this is called passing an argument or passing a parameter
        System.out.println("Now there are " + numberStudentsPres + " students present");
        System.out.println();//blank line
        int treeLimbs = 6;
        System.out.println("Now lets calculate the number of tree limbs:");
        System.out.println("Initially there are " + treeLimbs + " treeLimbs");
        treeLimbs = (addition(treeLimbs));
        System.out.println("Now there are " + treeLimbs + " treeLimbs");
        System.out.println();//blank line
        int x = 7;
        int y = 9;
        System.out.println("Now lets calculate the area of a rectangle with the base of "+ x + " and the height of " + y);
        System.out.println("The area of that rectangle is " + (area(x, y)));
        
        System.out.println();
        System.out.println("Is 6 odd?: " + oddNum(6) + "\nIs 9 odd?: " + oddNum(9));
        //this is a concept of a driver driving the function, testing out the function
        System.out.println("What about all the odd numbers between 1 - 36");
        //note commenting style
        //below: this for loop creates a test driver
        for(int i = 1; i <= 10; i++){
            System.out.println(i + " is odd?:" + oddNum(i) );
        }
        //myMax function call
        
        int x1, y1, x2;
        x1 = 10;
        x2 = 8;
        y1 = 8;
        
        System.out.println("Which is bigger " + x1 +", " + y1 + " : " +myMax(x1, y1));
        System.out.println("Which is bigger " + x2 + ", " + y1 + " : ");
        
        System.out.println();
        int numStudents = 1;
        //example of ternery operator in print
        System.out.println(numStudents + " student" + ((numStudents > 1)? "s" : "") + " took the test" );
    }//end method doTheAssignment
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        putEquals(18);
        homeworkHeader();
        putEquals(18);
        doTheAssignment();
        double fl = 47.568;
        System.out.println(Math.floor(fl));
        System.out.println(Math.ceil(fl));
        
        //data conversion
        int flr = (int)fl; //this is explicit casting
        //int flr1 = fl / 20; int will be converted to a double cause its the higher cast
        
    }
    
     static void putChars(int numChar, char charr){//note the signature of a function is the name and the parameter and the parameter types
        putBlanks(2);
        while (numChar > 0){
            System.out.print(charr);
            numChar --;
        }//end while
        System.out.println();
    }//end method putEquals
     
    static void putChars(int numChar){//This is known as overloading, creating different methods by the same name different parameters
        putBlanks(2);
        while (numChar > 0){
            System.out.print('=');
            numChar --;
        }//end while
        System.out.println();
    }//end method putEquals
    
    static boolean oddNum( int number ){
        //checks to see if number is odd
        if(number % 2 == 1)
            return true;
        return false;//this naturally becomes the else case
    }
    
    //an example fo a Stub function allows software development to continue even if you don't have access to all the data ie:
    static String stub(){
        return "break me apart by my spaces";
        
    }
    
    static int myMax(int x, int y){
        if (x < y)
            return y;
        return x;//this is an else condition
        //if one did this the following way then a problem may arise:
        /*
        if(x < y)
            return y;
        else if (x > y)
            return x
        //the problem that will arise is if x = y and is neither and no return value will be given
        */
        //for this reason, you need to create 3 test cases
                   
    }//end method myMax
    
    static int myMin(int x, int y){
        if (x < y)
            return x;
        return y;
    }//end method myMin
    
    static int myMax(int x, int y, boolean bigg){
        //instead can do it this way with an operator comparison switch:
        int big;
        big = (x > y ) ? x : y; //logical operator comparisons known as a ternary operator
        return big;
        /*if (x < y)
            return y;
        return x;//this is an else condition
        //the if else happens alot 
          */         
    }//end method myMax
    
}
