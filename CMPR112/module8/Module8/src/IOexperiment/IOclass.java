/**
*Ticket : 86713
*Course : CMPR 112
*Student : Ben Halpern
*Instructor : Professor Kirscher
*Environment: Win 10 NetBeans
*Project Title : IO experiment
*
*
*Assignment details:
*/
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package IOexperiment;

import java.io.*;
/**
 *
 * @author benha
 */
public class IOclass {
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
        homeworkHeader("IO experiment");
        String fileName = "TestFormat.txt";
        
        try{
        
        PrintWriter outfile = new PrintWriter ( fileName );
        
        String name = "John Smith";
        double bal = 1345.58;
        outfile.printf("%60s %n %25s %n",name , "Balance = " + bal);//can use println, and printf and print all within the file
        outfile.printf("%10d %10d %10d %10d %10d%n", 11, 12, 13, 14, 14);
        outfile.printf("Format of dollars is %,12.2f $", 200000.5);
        String formattedString = String.format("%2s","format me");
        outfile.println(formattedString);
        outfile.close();
    
        }
        catch(FileNotFoundException e){
            e.getStackTrace();
        }//end catch
        }//end of method main
    }//end of class


/*

package ioexp;
import java.io.*;


*
* @author jkirs

public class IOExp {


* @param args the command line arguments

public static void homeworkHeader ( String title)
{

* @param String is the title to give the program/project

homeworkHeader () ;
System.out.println ( "Project Title : " + title );
}

public static void homeworkHeader ( )
{
* @param no parameters; output of lines of data that are constant through the semester.
* identifies the class, instructor, student, etc.

System.out.println ( "Ticket : 86713 ");
System.out.println ( "Class : CMPR 112 ");
System.out.println ( "Student Name : Joel Kirscher ");
System.out.println ( "Instructor Name : Joel Kirscher ");
System.out.println ( " ");
}

 

public static void main(String[] args) {
 
homeworkHeader ( "Code examples of formatted data written to a file  ");
String fileName = "TestFormat.md";
try
{
PrintWriter outFile = new PrintWriter ( fileName );

String name = " John Smith";
double bal = 12345.58;
int numOfDays = 16;

outFile . println ( "Top of Report\n");
outFile.printf ( " Current Balance = %f ", bal);
outFile.printf ( "\n");
outFile.printf ( " Number of Days %d yields a ballance of %f", numOfDays, bal);
outFile.printf ( "\n");
outFile.printf ( " %3d %3d %3d %3d %3d ", 23,4,33,2,11);

outFile.printf ( " Format of dollars %12.2f $\n", bal);
int lineNum;
for ( lineNum = 1; lineNum < 21; lineNum += 5)
{
outFile.printf ( "%3d '%22s' %10.2f\n", lineNum, name, bal);
}

bal = 123456789.12;

// below the name is 22 char wide right justified.
outFile.printf ( "%3d %22s %10.2f\n", lineNum, name, bal);


// below the name is 22 char widde left Justified:
outFile.printf ( "%3d %-22s %10.2f\n", lineNum, name, bal);

// Below is an example of creating a string the the fomratted data in it:
String lineOR = String.format ( "%3d %-22s %10.2f\n", lineNum, name, bal);

System.out.println ( lineOR );

outFile.close ();
}

catch ( FileNotFoundException ex )
{
System.out.println ( " File Not Found ! \n");
System.out.println ( ex.getMessage());

}
}
}
*/