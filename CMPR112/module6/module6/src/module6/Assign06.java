/*
 *
Ticket : 86713
Course : CMPR 112
Student : Ben Halpern
Instructor : Professor Kirscher
Environment: Win 10 NetBeans
Project Title : Assign 06 - File I/O




*************************************************
Assignment description: 
*************************************************
Overall:

Write code to read a file and produce on the console a Monthly Sales Report. 

 

Open a file called Sales_2020_08.txt.   The file is below in this assignment page. 

Read each record which has FirstName, LastName, SalesAmount, 

Produce a nice looking professional report that includes  ( NOTICE: your report must include ) :

A) Headings

B) One line for each sales person;   each line includes a line number, sales persons names, gross sales and calculated sales commission

C) total line with a total of the gross sales and the commissions.  

 

Code Requirements:

Code to open the file

a loop that stops on EOF or other mechanism.  

a line counter for each line.  

Commission rates are based on gross sales amount:

5.5% for sales in the range of 0 - 10000.00    

6.7% for sales in the range of 10000.01 - 22500.00  

11.2% for sales greater than 22500.00    


 

                    

 

DO NOT 

1) do not manually count the number of records and put the reading of the records in a for loop or while loop with the number of records controlling the loop. 

2) do not manually code any of the data.   Read the data from the file.   The file is below:

 

 

Report Output SamplePreview the document

 

Data File ( do not modify ) name must be Sales_2020_08_txtPreview the document

 

 

Hints:

You have no input to code.   You run the program and it opens the file and reads the data from the file.  

If you copy the text of the data file and create a file on some other system be careful that you do not inadvertently add a blank line at the end of the data. 

 

Grading, 

Your output should match my output as close as you can.  

Money should have two digits to the right of the decimal point.  

The commission rate should have one digit. 
//end assignment description
 */
package module6;
import java.util.Scanner;
import java.io.*;
/**
 *
 * @author benha
 */
public class Assign06 {
    
    /**
     * @param String title, takes in a string and outputs the combined homework header
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

    /**
     * @param int , takes month as an int value and converts it to string
     */
    static String getDate( int mon){//takes in the month number and converts it to a string
        //initialize variables
        String result = "";
        //end initialization variables
        switch(mon){
            case(1):
                result = "Januarary";
                
                break;
            case(2):
                result = "Feburary";
                
                break;
            case(3):
                result = "March";
                
                break;
            case(4):
                result = "April";
                
                break;
            case(5):
                result = "May";
                
                break;
            case(6):
                result = "June";
                
                break;
            case(7):
                result = "July";
                
                break;
            case(8):
                result = "August";
                
                break;
            case(9):
                result = "September";
                
                break;
            case(10):
                result = "October";
                
                break;
            case(11):
                result = "November";
                
                break;
            case(12):
                result = "December";
                
                break;
            
        }//end switch
        return result;
    }//end getDate
    
    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        //
        
        //variable initialization
        String firstName = "";
        String lastName = "";
        double grossSales = 0;
        double commRate = 0;
        double commAmount = 0;
        double grossSum = 0;
        double commSum = 0;
        String sDate = "";
        int date = 0;
        //end variable initialization
        
        //calling of homework header
        homeworkHeader("Assign 06 - File I / O");//homewokr header method
        //end calling of homework header
        
        try{//to catch any errors may they arise in the file input stream
            String fileName = "Sales_2020_08.txt";//name of the file
            File fileInSales = new File (fileName);//instatiates the file location
            if(!(fileInSales.exists())){//if the file doesn't exist, output the error
               System.out.println("Error : The file doesn't exist");
            }//end if                                   //the netbeans hint is to use the above with try-with resource
            //will still be caught by the catch statment if file is missing
            Scanner read = new Scanner(fileInSales);//instatiates scanner object linked to fileInSales named read which reads from file
                
            
            //gets date from fileName
            String[] fileSub = fileName.split("_");//split up the date
            sDate = fileSub[2].substring(0,fileSub[2].indexOf('.'));//take of the file name extension
            date = Integer.parseInt(sDate);//parse as int so can be used in comparison
            sDate = getDate(date);//pass to getDate method to return the string equivalent date
            //end gets date
            
            //System.out.println(sDate+ " "+fileSub[0] + " : " + fileSub[1] + " : " + fileSub[2] );
            //report header
            System.out.println("Sales Monthly data file : "+ fileName );
            System.out.printf("%n %75s%n %n",("Monthly Sales Report    /    " + sDate));
            System.out.printf("%8s %22s %-15s %20s %24s %20s","Line","Last","First","Gross","Commission","Commission\n");
            System.out.printf("%10s %20s %-15s %20s %20s %22s","Number","Name","Name","Sales","Rate","Amount\n\n");
            //end report header
            
            //loop to cycle through file, uses hasNext() to check if at the end of the file
            for(int i = 1; read.hasNext() == true ; i++){//checks until end of file and no more data
                //reads the data from the file and then outputs it to the screen 
            
                //reads from file
                firstName = read.next(); //until the next blank space
                lastName = read.next();//Gets the last name from the space after
                grossSales = read.nextDouble();
                //end reading from file
                
                //commRate = read.nextDouble();
                //commAmount = read.nextDouble();
                //algorithm to calcualte commision amount
                    //5.5% for sales in the range of 0 - 10000.00    
                    //6.7% for sales in the range of 10000.01 - 22500.00  
                    //11.2% for sales greater than 22500.00    
                if(grossSales >= 0.0 && grossSales <= 10000.00)//commision rate is set 5.5%
                    commRate = 0.055;
                else if (grossSales >= 10000.01 && grossSales <= 22500.00)//commision rate is set to 6.7%
                    commRate = 0.067;
                else if(grossSales >= 22500.01)//commision rate is set to 11.2%
                    commRate = 0.112;
                else{//trailing else to catch any errors
                    System.out.println("Check evaluation, there is an error in the evaluation the commission rates.");//debugging
                }//end else
                
                //commision calculations
                commAmount = commRate * grossSales;//multiply the grossSales by the rate to get the commAmount
                //Totals calculations
                commSum += commAmount;  //for the total value of the commission amounts
                grossSum += grossSales; //for the total value of the sales amounts
                
                
                commRate *= 100;//make the rate presentable in percent format
                //contents of report:
                System.out.printf("%10s %20s %-15s %,20.2f %,20.1f  %,22.2f%n",i,lastName,firstName,grossSales,commRate,commAmount);
            }//end while
            
            System.out.println();//blank line for visibility
            //total values displayed:
            System.out.printf("%10s %20s %-15s %,20.2f %20s  %,22.2f%n","","T O T A L S : ","",grossSum,"",commSum );
           
            read.close();//closes file data stream
        
        }//end try
        catch( FileNotFoundException exception){//to catch if the file is not found
            System.out.print("Sorry, the file was not found");
            exception.printStackTrace();
            
            
            
        }//end catch
        catch( Exception exception){//to catch any other error that may be thrown
            System.out.print("Somethign went wrong!");
            //exception.printStackTrace();
            
            
            
        }//end catch
    }//end main

}//end class
//EOF


//statement of completion:

//Describe what portions of the assignment are done and complete.

////All portions of the assignment are done and complete to the best of my knowledge.
////The program reads file and then formats the data from the file into a nice report
////Takes the date from the filename ( filename must be in this format: name_DD_MM.txt , where DD is the day and MM is the month)
////to be added in the title

//What is missing? What caused the incompleteness.

////To the best of my knowledge nothing is missing and there is no incompleteness.

//How do you feel about the assignment or what did you learn while doing it?
////I feel good about the assignmnet and really enjoyed it. I learned how to read and format data from a file. I also used the exists() method to check if the 
////file exists before writitng to it.