/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package module6;
import java.util.Scanner;
import java.io.*;
//import java.io.BufferedWriter;
/**
 *
 * @author BenHalpern
 */
public class Lecture06 {
    public static String data = "";
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
    

    public static void playWithStrings(){
        String mary = "Mary had a little lamb; whose fleece was white as snow";
        
        /*
        for(int i = 1; i < 30; i++){//to test the size fo the buffer
            mary += mary;
            System.out.println(mary.length() + " " + i + " ");
        }//end for
        */
        int l = mary.length();
        int posLamb = mary.indexOf("lamb");
        System.out.println("Mary is " + l + " long, and lamb is located at indexOf:" + posLamb);
        String sub1 = mary.substring(posLamb);//posLamb until the end
        String sub2 = mary.substring(0, posLamb -1);// posLamb -1 up to lamb but not including
        System.out.println(sub1 + " \n " + sub2); //prints the substrings and prints it backwards
        String concat = sub2.concat(sub1);
        String a = "aaaa";
        String b = "aaaa";//"bbbb" 
        String c = new String (b);//shows that java is pass-by-value and not pass-by-reference 
        System.out.println((b == c));//accurately compares two strings 
        //does equals check the location in memory or is that just in python?
        System.out.println(c.compareTo(a) + " " + b.compareTo(a) );//range of compareTo is [-2, 2] 
        //System.out.println(mary.hashCode());//just to see what it does
        //a filed goes from column 16 to column 19 how many columns are used for the field on the cards
        //think about it 16, 17, 18, 19 end thats four characters, but 16-19 is three
        //this is because when you subtract it doesn't include the value, it includes only the spaces inbetween not the point your on
        // the night doesn't count his current position in chess  but the next one, so this concept is the same
        // but computers work off the values of 0, so it includes the current position
        // to solve this issue ( max - min ) + 1 solves the problem
        
        //when dealing with strings be aware that the string method will concatinate anything after it if it isn't a string and will treat everything as a string
        //string also knows how to compare the values of two strings ( tests the characters, the length ) 
        //it allows you to do != and == to compare strings using .equals etc
        
        
    }//end public static playWithStrings


    
    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException{
        // TODO code application logic here
        homeworkHeader("Lecture 06 I/O");
        playWithStrings();
        try{//try-catch is error handeling  
        //were going to dive into reading and writing files
        //this covers stuff inside chapter 4 of the book
        
        //text writing
//        String strToWrite = "Helloo there I am data in a small file.";
//        BufferedWriter writer = new BufferedWriter (new FileWriter("BenData.txt"));//initializes object to write to this file
//        writer.write(strToWrite);//uses bufferedWriter to 
//        writer.close();//closes writer end tells system done writing to file
//        //prints the file to the module
        
        //reading from a file
        String fileNameMonthlyData = "TestReadME.txt";  //file path string to be passed to File class   //object
        data = fileNameMonthlyData;
        File fileInSales = new File (fileNameMonthlyData);//creates new object File path passed to the scanner object to read
        Scanner fileInData = new Scanner( fileInSales );//linked to scanner to read from the fileInSales File
        
        //below we will loop and process each record.
        while(fileInData.hasNext() == true){//checks until end of file and no more data
            String first;
            int id;
            first = fileInData.next(); //until the next blank space
            id = fileInData.nextInt();//gets the id from the file and loads it to an int
            
            System.out.println(first + ", " + id);
        }//end while
        fileInData.close();//closes scanner buffer
        //File class doesn't have a close() method
    
        }//when the text writing was commented out the IDE gives an error telling the programmer that the following code will never be thrown
        catch(FileNotFoundException exception){//if the error occurs then the following error is handeling like so:
            System.out.println(exception);
            System.out.println(" Exception File Not Found; File name is " + data);
            exception.printStackTrace();
            /*
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println("UH   OHH   STINNNNKYYYYYYYYYY");
            */
            //the error code afterwards
            //System.out.println("Oh... and one more thing, your stinky");//funny message
        }//end catch
        catch(Exception exception){//any other exception
            //exception.printStackTrace();
            System.out.println("OOOPS something went wrong");
        }//end catch
    }//end main

}//end class
//EOF
