/**
 * 
 * 
 * assignment details:
 * 
 * This is Programming challenge 17.2D Array Operations
 * Page 489
 * Starting out with Java From control structure through object s 7th edition
 * write a program that creates a two-dimensional array initialized with test data.   Use any primitive data type that you wish ( int, float, double)    The program should have the following methods:
 * getTotal   This method should accept a two-dimensional array as its argument and return the total of all the values in the array.
 * getAverage This method should accept a two-dimensional array as its argument and return the average of all the values in the array. 
 * getRowTotal  This method should accept a two-dimensional array as its first argument and an integer as its second argument.   The second argument should be the subscript of a row in the array.    The method should return the total of the values in the specified row.
* getColumnTotal This method should accept a two-dimensional array as its argument and an integer as its second argument.   The second argument should be the subscript of a column in the array.    The method should return the total of the values in the specified column. 
* getHighestInRow  This method should accept a two-dimensional array as its first argument and an integer as its second argument.   The second argument should be the subscript of a row in the array.    The method should return the highest value in the specified row of the array.
* getLowestInRow This method should accept a two-dimensional array as its first argument and an integer as its second argument.   The second argument should be the subscript of a row in the array.    The method should return the Lowest value in the specified row of the array.
* Demonstrate each of the methods in this program.  
* 

 
 */
package module12;
import java.util.Scanner;


/**
 *
 * @author benha
 */
public class Assignment12 {
    /**
     * enum with OPT1, OPT2, OPT3, OPT4, OPT5
     */
    public enum Options{OPT1, OPT2, OPT3, OPT4, OPT5, OPT6, OPT7, OPT8, OPT9, DEF}
    
    /**
     * 
     * @param title 
     */
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
    
    public static void displayMatrix(int array[][]){
        for(int row[]: array){
            for(int col: row)
                System.out.print(col + "\t ");
            System.out.println();//new line after each row
        }//end for
        
    }//end displayMatrix
     
    public static void configMatrix(int array[][]){
        for(int row = 0; row < array.length; row++ ){
            for(int col = 0; col < array[row].length; col++){
                array[row][col] = row + (col*array.length);
            }//end for
            
        }//end for
    }//end configMatrix
    

    public static void configMatrix(int array[][], Scanner in){
        for(int row = 0; row < array.length; row++ ){
            for(int col = 0; col < array[row].length; col++){
                System.out.println("please enter the value at position (col: "+ col + ", row:" + row +") :" );
                array[row][col] = in.nextInt();
            }//end for
            
        }//end for
        //in.nextLine();//eats blank spaces
    }//end configMatrix
    
    
    
    /**
     * 
     * @param array
     * @return 
     */
    public static int getTotal(int[][] array){
        int total = 0;
        for( int row[]: array){
            for(int col : row)
                total += col;
        }
        return total;
    }//end getTotal
    
    /**
     * 
     * @param array
     * @return 
     */
    public static int getSize(int[][] array){
        int size = 0;
        for(int row[]: array){
            size += row.length;
        }//end for
        return size;
    }//end getSize
    
    
    /**
     * 
     * @param array
     * @return 
     */
    public static int getAverage(int[][] array){
        int total = getTotal(array);
        int size = getSize(array);
        
        return total/size;
       
    }//end getAverage
    
    
    /**
     * row total
     * @param array
     * @param row
     * @return 
     */
    public static int getRowTotal(int[][] array, int row){
        int rTotal = 0;
        for(int i = 0; i < array[0].length; i++ ){
            rTotal += array[row][i];
        }
        return rTotal;
        
    }//end getRowTotal
    
    /**
     * column total
     * @param array
     * @param col
     * @return 
     */
    public static int getColTotal(int[][] array, int col){
        int rTotal = 0;
        for(int i = 0; i < array.length; i++ ){
            rTotal += array[i][col];
        }
        return rTotal;
        
    }//end getRowTotal
    

    /**
     * highest in row
     * @param array
     * @param row
     * @return 
     */
    public static int getHighestIR(int[][] array, int row){
        int highest = array[row][0];
        for(int i = 0; i < array[0].length; i++ ){
            if(highest < array[row][i]){
                highest = array[row][i];
                //System.out.println("The next highest is : " + highest);
            }//end if
        }
        return highest;
    }//end getHighestIR    
    
    /**
     * lowest in row
     * @param array
     * @param row
     * @return 
     */    
    public static int getLowestIR(int[][] array, int row){//gets the lowest in the row
        int lowest = array[row][0];
        for(int i = 0; i < array[0].length; i++ ){
            if(lowest > array[row][i]){
                lowest = array[row][i];
                //System.out.println("The next lowest is : " + lowest);
            }//end if
        }
        return lowest;
    }//end getHighestIR          
    
    /**
     * reusing the highest in roe to produce highest in column
     * @param array
     * @param col
     * @return 
     */
    public static int getHighestIC(int[][] array, int col){
        int highest = array[0][col];
        for(int i = 0; i < array.length; i++ ){
            if(highest < array[i][col]){
                highest = array[i][col];
                //System.out.println("The next highest is : " + highest);
            }//end if
        }
        return highest;
    }//end getHighestIR    
    
        public static int getLowestIC(int[][] array, int col){
        int lowest = array[0][col];
        for(int i = 0; i < array.length; i++ ){
            if(lowest > array[i][col]){
                lowest = array[i][col];
                //System.out.println("The next highest is : " + highest);
            }//end if
        }
        return lowest;
    }//end getLowestIC    
    
    /**
     * 
     * @param in
     * @return 
     */
    public static Options menu(Scanner in ){
        int selected = 0;
        //prints out menu
        System.out.println("Which function do you want to run?");
        System.out.println("1: getAverage");
        System.out.println("2: getRowTotal");
        System.out.println("3: getColTotal");
        System.out.println("4: getHighestInRow");
        System.out.println("5: getLowestInRow");
        System.out.println("6: getHighestInCol");
        System.out.println("7: getLowestInCol");
        System.out.println("8: configMatrix");
        System.out.println("9: displayMatrix");
        System.out.println("Which would you like to select:");
        selected = in.nextInt();
        while ((( selected > 9 || selected < 0) )){
            System.out.println("please input a valid response");
            selected = in.nextInt();

        }//end while
        switch(selected){//switch to return the enum type
            
            case(1):
            
                
                return Options.OPT1;
            case(2):
                
                return Options.OPT2;
                //break;
            case(3):
                
                
                return Options.OPT3;
                //break;
            case(4):
                
                
                return Options.OPT4;
                //break;
            case(5):
                
                
                return Options.OPT5;
            case(6):
                
                
                return Options.OPT6;
                //break;
            case(7):
                
                
                return Options.OPT7;
                //break;
            case(8):
                
                
                return Options.OPT8;
                
                
            case (9):
                
                
                return Options.OPT9;
            default:
                return Options.DEF;
        }//end switch
    
    }//end menu
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try{                                                            //row totals:
         int[][] array = { {0,  1,  2,  3},//lowest is 0, highest is 3          rT: 6
                           {3,  2,  1,  0},//lowest is 0, highest is 3          rT: 6
                           {2,  1 , 8,  4}};//lowest is 1, highest is 8         rT: 15
        //columnT :         5   4   11  7      
         Scanner in = new Scanner(System.in);
         int row = 0;
         int col = 0;
         boolean cont = true;
         
        homeworkHeader("Assignment 12 - Matrix Operations");//homework header
        while(cont){
        Options selected = menu(in);
        col = 0;//resets 
        row = 0;//resets
        switch(selected){
            
            case OPT1://get average
                System.out.println("Get Average");
                System.out.println("Average: " + getAverage(array));
                break;
            case OPT2://row total
                System.out.println("Row total");
                System.out.println("Which Row:");//queries user
                row = in.nextInt() - 1;//fills variable row
                while ( (row >= array.length || row < 0)){//loops while is out of bounds
                    System.out.println("Please input a valid answer from 1 - " + array.length);
                    row = in.nextInt() - 1;
                }
                System.out.println("Row total: " + getRowTotal(array,row));
                break;
            case OPT3://col total
                System.out.println("Column total");
                System.out.println("Which Column:");//queries user
                col = in.nextInt() - 1;//fills variable col
                System.out.println(array[0].length);
                while ((col >= array[0].length || col < 0)){//loops while is out of bounds
                    System.out.println("Please input a valid answer, please select a valid asnwer from 1 - " + (array[0].length ));
                    col = in.nextInt() - 1;
                }//end while
                System.out.println("Column total: " + getColTotal(array,col));
                break;
            case OPT4://highest in row
                System.out.println("Highest in row");
                System.out.println("Which Row:");//queries user
                row = in.nextInt() - 1;//fills variable row
                while ( (row >= array.length || row < 0)){//loops while is out of bounds
                    System.out.println("Please input a valid answer from 1 - " + (array.length));
                    row = in.nextInt() - 1;
                }//end while
                System.out.println("Highest in row: " + getHighestIR(array,row));
                break;
                
            case OPT5://lowest in row
                System.out.println("Lowest in row");
                System.out.println("Which Row:");//queries user
                row = in.nextInt() - 1;//fills variable row
                while ( (row >= array.length || row < 0)){//loops while is out of bounds
                    System.out.println("Please input a valid answer from 1 - " + ( array.length));
                    row = in.nextInt() - 1;
                }//end while2
                System.out.println("Lowest in row: " + getLowestIR(array, row));
                break;
            case OPT6://highest in col
                System.out.println("Highest in Column");
                System.out.println("Which Column");//queries user
                col = in.nextInt() - 1;//fills variable row
                while ( (col >= array.length || col < 0)){//loops while is out of bounds
                    System.out.println("Please input a valid answer from 1 - " + (array.length));
                    col = in.nextInt() - 1;
                }//end while
                System.out.println("Highest in column " + getHighestIC(array,col));
                
                
                break;
            case OPT7://lowest in col
                System.out.println("Lowest in column");
                System.out.println("Which Column:");//queries user
                col = in.nextInt() - 1;//fills variable row
                while ( (col >= array.length || col < 0)){//loops while is out of bounds
                    System.out.println("Please input a valid answer from 1 - " + (array.length));
                    col = in.nextInt() - 1;
                }//end while
                System.out.println("Lowest in column " + getLowestIC(array,col));
                
                
                break;
            case OPT8:
                configMatrix(array, in);
                
                
                break;
            case OPT9:
                
                
                displayMatrix(array);
                break;
            default:
                System.out.println("Automation");

                System.out.println("The average is " + getAverage(array));
                for ( int i = 0; i < array.length; i++){
                    System.out.println("The highest in the row " + (i +1) + " is " + getHighestIR(array,i));
                    System.out.println("The lowest in the row " + (i + 1) + " is " + getLowestIR(array, i));
                    System.out.println("The sum of the row " + (i + 1) + " is " + getRowTotal(array, i));
                    System.out.println();//blank line for visibility
                }//end for

                for(int i = 0; i < array[0].length; i++){
                    System.out.println("The highest in the column " + (i + 1) + " is " + getHighestIC(array,i));
                    System.out.println("The lowest in the column " + (i + 1) + " is " + getLowestIC(array,i));
                    System.out.println("The sum of the column " + (i + 1) + " is " + getColTotal(array, i));

                    System.out.println();//blank line for visibility
                }//end for
                
                
                configMatrix(array);
                displayMatrix(array);
                configMatrix(array, in);
                break;
        }//end switch
        System.out.println("Press any key to continue, enter to exit...");
        in.nextLine();//eat up blank space
        cont = !in.nextLine().isBlank();//if is not blank cont is true
        }//end while
        }
        catch(Exception e){
            System.out.println("That value was not a valid value");
            e.printStackTrace();
        }
        
    }
    
}
/*
Discussion Questions:

//1) feel free to answer your own question as well as mine:

2) Which function(s) were the hardest?

I didn't really find too many of the functions to be hard. The functions for the addition of each row as well as finding the highest,
are both algorithms we used in previous assignments for sorting and when arrays were introduced. I had a validation error where I used the wrong bounds on one
of the functions I created for getting the highest from the column, but that was a simple switch of the conditional statement from array[0].length, to array.length.
In the future a possible alteration could be to change the 0 in the array[0].length to the iterator so each time it may be different in the case of a jagged array.
The code presented will adjust more or less the out of bounds error message ( not the try-catch message ) in regards to the amount which are within the array.

3) was generating the data a significant task even though the assignment does not say much about it?

Not really. I generated the data by varying different numbers in an rectangular 2D array. I furthered the testing of the data by simply deleting or adding a row and seeing
how the program adapted. If I have more time I will add a function which will allow for the user to input the values that they would like to test within the array.

4) did you create a displayMatrix ( ) function?

I did create a displayMatrix function ( after reading this question ). It can be seen if the user enters 0 and drops into the default section of the switch ( kinda hidden )
I incorporated a relational configuration method ( as is mentioned in the next question ) prior to running the displayMatrix function. Following the running of this method, the
program then runs the configMatrix method which is overloaded to allow for the user to input their own data.


5) can you come up with a function to fill the matrix elements with a value that helps you know where it came from?

The configMatrix function(method) does that very similarly to the way it was done in the TicTacToe game. The further away from the position 0,0 in the array, the larger the number is
seen. the row increments by one and the column increments by the length of the row. This could easily be switched however as long as the method remains consistent it is possible to reverse engineer how the numbers
were produced and create coordinates based of these relational positional indicators.

 

Statement of completion:

 

Describe what portions of the assignment are done and complete. What is missing?

To the best of my knowledge, all parts of the assignment are done and complete. The program displays a menu and allows the user to pick which function they would like to run on the array. If the default ( 0 ) is entered, then the program will run most of the functions using a automated loop and then it ends with the user entering their own values into the array. 

 

What caused the incompleteness.

To the best of my knowledge there wasn't any incompleteness in this project. I could have written more lines of code, however felt that the size of the code and functionality was sufficient and versatile. 

 

How do you feel about the assignment or what did you learn while doing it?

I enjoyed the assignment. I enjoyed that the array was not meant to be equal like a square but a rectangle. I considered writing some of the functions to work with jagged arrays, however only some of them at the moment are compatible with jagged arrays. This was a fun project further instilling the use of array and matrices. 

 */