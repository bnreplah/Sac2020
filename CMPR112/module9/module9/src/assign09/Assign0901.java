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
* Glossary:
*
*In this assignment you will find a reference to a Big Loop.   A Big Loop is usually an outer loop.   Assuming you have two or more loops embedded inisde each other.   the big loop is the loop with the first for loop statement. 
*
*CAUTION: this code shows an outer big loop and inner smaller loop. This code does not solve the assignment.  This is to show that for loops can be embedded inside other loops.
*
*for ( int row = 0; row < 3; row++)      this for loop which is changing the row index is the big loop. 
*
*{
*
*        for ( int col = 0 ; col < 3; col ++ )
*
*       {
*
*             cout    <<   ticTacToeBoard  [ row]  [ col ] << "  ";
*
*       }
*
*       cout << endl;
*
*}
*
* 
*
* 
*
* 
*
* 
*
*Part 1:
*
*Using this web page create an array of strings that contain the Division Names at Santa Ana College.  Hint: First Division is the Business Division.  There are six divisions, see:
*
*https://sac.edu/AcademicAffairs/Pages/Divisions-Departments.aspx (Links to an external site.)
*
* 
*
* 
*
*Output the list of division names.  using an integer that indexes to each name.
*
*Output the list of  division names  using the  Java For-Each loop.  
*
* 
*
* 
*
*Part 2: 
*
*2 A ) create an  integer array of 40 elements
*
*2 B ) fill the first 2 elements with 1 and 2.    To be more clear set a 1 into the very first element.   Set a 2 in the second element.   
*
*2 C) then for the remaining 38 elements set the sum of the previous two elements into the element.   
*
*2 D) display the values of the 40 elements
*
* 
*
* 
*
*Part 3: 
*
*Create an array of 20 integers.
*
*Fill the array with the odd numbers starting at 1.   ( should be 1, 3, 5, 7, etc.   Use a loop! )
*
*using a big loop show the sum of the elements:
*
*So show the sum of the elements at position 0 ( 1) 
*
*then show the sum of the elements at positions 0 and 1. 
*
*then show the sum of the elements at positions 0,1,2
*
*etc. 
*
*then show the sum of the elements at positions 0,1,2,3 . . . , 18, 19
*
* 
*
*Part 4. 
*
*Create an array of doubles to hold the miles from the sun for each of the NINE planets.   
*
*Example for Earth    
*
*distances[2] = 93E6;     93000000 miles from earth to sun.   
*
* in Scientific Notation.    93 x 10 to the 6th.   
*
*   93.0    but move the decimal mount 6 places to the left.  
*
* 93 000 000 . 0
*
* 
*
* 
*
*Print out the distances. 
*
*( For those of you who think there are 8 planets, fine.   But answer this:
*
*What are we to do with Plutonium if we only have 8 planets? ) 
*
* 
*
* Discussion Questions. 
*
*How do you envision arrays? Or how would you describe them?
*
*Can you think of some applications where arrays are the appropriate data structure?  
*
* 
* 
* I will work on the webscraping in a different instance of the program and incorporate it if I have time.
*/


package assign09;

/**
 *
 * @author benha
 */
public class Assign0901 {
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
    public static void main(String[] args) throws InterruptedException {
        //main class of the function. Will call the driver methods here, and initialize the runtime enviornment for the user
        
        
        //calling of homeworkHeader method
        homeworkHeader("Assignmnet 09 - Arrays Intro");   
    }//end public main 
    
    
    
    

}//end class
//EOf