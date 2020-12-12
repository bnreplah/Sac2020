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
* 
* This is assignment number 8 from the book page 488.   At the end of chapter 7:

Please note I found their instructions confusing.  So I took the liberty to restructure the assignment. 

 

8. Grade Book

 

A teacher has 5 students who have taken 4 tests.   the teacher uses the following grading scale to assign a letter grade to a student,  Based on the average of the students test scores. 

 

Test Score       Letter Grade

90 - 100         A

80 - 89           B

70 - 79           C

60 - 69           D

 0  - 59           F

 

Write a class that contains the student name.   The class also has the 4 test scores recorded as well.  Provide methods to set and get the student name and  methods to set the test scores ( as a double ) .   the class also has a method to get the final Letter Grade based on the average of the test scores.   

 

Then using an array or an ArrayList create 5 or more students data using the student class.   And produce a report of the students.  

 

Hints:

the letter grade determination can be done with out resorting to 5 if statements.  

 

You may enbed the data into the program if you do not want to do a lot of input. 

Perhaps your student class has a nice constructor.  

 

please use a variable ( int ? ) with the Java Language 'final' attribute to specify that there are 4 tests.  

 
*
* ##########################################################################################################
* notes:
* I am planning on doing the code in stages:
*   X Console based, basic.
*   X Provide a menu with different student grade book manipulations
*   Read the data from a file
*   If I have even more time: create a log in page which reads encrypted passwords and matches the hashes to check if they are accurate,
*       if the user is a student they can view their own grade and the class average
*       if the user is a teacher they are allowed to do gradebook manipulations
*       the gradebook will be encrypted and salted;
* 
*/


package module14;
import java.util.Scanner;
import java.util.HashMap;
//import java.util.Collections.*;
import java.util.ArrayList;
/**
 *
 * @author benha
 */
public class Gradebook {
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
        // TODO Driver for Student class creating grade book application
        //First will create a console based application then will work on making GUI
        //HashMap<String, Student> gradebook = new HashMap<String, Student>();
        Scanner input = new Scanner(System.in);
        ArrayList<Student> myClass = new ArrayList<Student>();
        int numStudents = 0;
        int score = 0;
        int selection = 0;
        int foundIndex = 0;
        boolean found = false;
        String name = "";
        int testNum = 0;
        boolean loop = true;
        //end declarations
        
        //get the number of students
        System.out.println("Please enter how many students are in the class: ");
        numStudents = input.nextInt();
        input.nextLine();//eats the left over blank space
        //create a student class for each student
        for(int i = 0; i < numStudents; i++){
            System.out.println("Please enter the student name:");//prompt user for the name of the student
            myClass.add(new Student(input.nextLine()));
            //populats the test of that student
            for(int j = 0; j < myClass.get(i).getTestNum(); j++ ){
                System.out.println("\tPlease enter a value for test #" + (j + 1) + ":");//prompts user for the test results for the next test
                score = input.nextInt();// score variable
                if (validateScore(score))
                    myClass.get(i).setScore(score);//sets the next score
                else{
                    boolean notValid = true;//else local variable ( in order to be able to be changed in the efforts to prevent a forever loop case )
                    while(notValid){
                        System.out.println("\tPlease enter a score within the range of 0 - 100:");//prompt for a valid 
                        score = input.nextInt();
                        notValid = !validateScore(score);
                    }//end while
                    myClass.get(i).setScore(score);
                }//end else
                
                
            }//end for
            input.nextLine();//eats the blank space from the nextInt();
            //gradebook.put(myClass.get(i).getName(),myClass.get(i));
        }//end for
        
        printReport(myClass);
        System.out.println("Press enter to continue...");
        input.nextLine();//eats the blank space input
        while(loop){
            System.out.println();//blank line for visibility
            selection =  menu(input);
            //input.nextLine();//to eat up blank space
            switch(selection){
            case(1)://add another student
                input.nextLine();//eats blank space;
                System.out.println("Please enter the student name:");//prompt user for the name of the student
                myClass.add(new Student(input.nextLine()));//adds to the end

                for(int j = 0; j < myClass.get(myClass.size() -1).getTestNum(); j++ ){
                    System.out.println("\tPlease enter a value for test #" + (j + 1) + ":");//prompts user for the test results for the next test
                    score = input.nextInt();// score variable
                    input.nextLine();//eats the blank space input
                    if (validateScore(score))
                        myClass.get(myClass.size() -1).setScore(score);//sets the next score
                    else{
                        boolean notValid = true;//else local variable ( in order to be able to be changed in the efforts to prevent a forever loop case )
                        while(notValid){
                            System.out.println("\tPlease enter a score within the range of 0 - 100:");//prompt for a valid 
                            score = input.nextInt();
                            input.nextLine();//eats the blank space input
                            notValid = !validateScore(score);
                        }//end while
                        myClass.get(myClass.size() - 1).setScore(score);
                    }//end else


                }//end for

                break;
            case(2)://get all grades from a specific test


                System.out.println("Please enter a test number to print out");

                testNum = input.nextInt();
                input.nextLine();//eats the blank space input
                System.out.println();//blank line for visibility
                for(int i = 0; i < myClass.size(); i++){
                    System.out.println(myClass.get(i).getName() + "  -  "+ myClass.get(i).getScore(testNum - 1));
                }//end for


                break;
            case(3)://gets the grade from a test from a student
                input.nextLine();//eats up blank space
                System.out.println("Please enter the student name in which you would like to display the records:");
                name = input.nextLine();
                //System.out.println(found);//debugging
                for(int i = 0; i < myClass.size(); i++){
                    if(name.equals(myClass.get(i).getName())){
                        found = true;
                        foundIndex = i;
                    }//end if
                }//end for
                //System.out.println(found);//debugging
                if(found){
                    System.out.println( myClass.get(foundIndex).getName()+ " - ");
                    for(int i = 0; i < myClass.get(foundIndex).getTestNum(); i++)//prints out each test score
                        System.out.println("\t" + myClass.get(foundIndex).getScore(i));
                }//end if
                else
                    System.out.println("record not found");
                break;
            case(4)://set the grade of a specific test
    //            int foundIndex = 0;
    //            boolean found = false;
    //            String name = "";
                input.nextLine();//eat blank space
                System.out.println("Please enter the student name in which you would like to set the test");
                name = input.nextLine();

                for(int i = 0; i < myClass.size(); i++){
                    if(name.equals(myClass.get(i).getName())){
                        found = true;
                        foundIndex = i;
                    }//end if
                }//end for
                if(found){
                    do{
                        System.out.println("Please enter the test number which you would like to set (1-4)");
                        testNum = input.nextInt();//could add input validation here
                    }while(testNum > 4 || testNum < 1);
                    do{
                        System.out.println("Please enter the score for that test number:");
                        score = input.nextInt();
                    }while(!validateScore(score));
                    if(validateScore(score))
                        if(myClass.get(foundIndex).setScore(score, testNum - 1))//needs -1 because dealing with the index
                            System.out.println("Test score was set");

                }//end if
                else
                    System.out.println("The record was not found");

                break;
            case(5)://print out the gradebook

                printReport(myClass);



                break;
            case(6)://remove a student    
                input.nextLine();//eats up blank space
                System.out.println("Which student would you like to remove");
                name = input.nextLine();

                for(int i = 0; i < myClass.size(); i++){
                    if(name.equals(myClass.get(i).getName())){
                        found = true;
                        foundIndex = i;
                    }//end if
                }//end for
                if(found){
                    System.out.println(myClass.remove(foundIndex).getName() + " was removed");


                }//end if
                else
                    System.out.println("The record was not found");

                break;
            case(7)://exit
                loop = false;


            }//end switch

        }//end while
        System.gc();
    }//end main

    
    public static int menu(Scanner in){
        int selected = 0;
        //prints out menu
        System.out.println("Which function do you want to run?");
        System.out.println("1: add another student");
        System.out.println("2: get all grades from one of the tests");
        System.out.println("3: gets the grade from a test from a student");
        System.out.println("4: set the grade of a specific test");
        System.out.println("5: print out the gradebook");
        System.out.println("6: remove a student");
        System.out.println("7: exit");
        //things to do: add a gui option
        //              add an option to read from file
        //              add an option to output to a file
        System.out.println("Which would you like to select:");
        selected = in.nextInt();
        while ((( selected > 7 || selected < 0) )){
            System.out.println("please input a valid response");
            selected = in.nextInt();
            in.nextLine();//eat up blank space
        }//end while
        return selected;
        
        
    }
    
    public static boolean validateScore(int score){
        final int UPPER = 100;
        final int LOWER = 0;
        return score >= LOWER && score <= UPPER;
    }//end validateScore
    
    public static boolean validateScore(int score, int lower, int upper){
        return score >= lower && score <= upper;
    }//end validateScore
    
    public static void printReport(ArrayList<Student> myClass){
        for(int i = 0; i < 71; i++ ) System.out.print("#");//prints border for title
        System.out.println();//blank line for visibility
        System.out.println("\t++++++++++++++ \t\t Gradebook \t +++++++++++++");
        System.out.println();//blank line for visibility
        for(int i = 0; i < 71; i++ ) System.out.print("#");//prints border for title
        System.out.println();//blank line for visibility
        
        System.out.printf("%-20s %20s %20s %n","Student","Average Grade"," Letter Grade");
        for(Student student : myClass)
            System.out.printf("%-20s %20s %20s %n", student.getName(),student.getAverage(), student.getGrade());
        
        
    }//end 
    
    
}//end Gradebook
/*
 

Discussion Questions:

1) Would adding a telephone number to the student class be complicated?
    
    Adding a telephone would not be difficult because it would be another value added to Student class. It could be added to the student class
    as a data type or one could create a class called PersonalInfo or PI, etc, and within that class would contain student info for each student such as address, 
    phone number, emergency contact. One could even create functions of the student class which would access the data from the PersonalInfo class and use it such
    as email the emergency contact in case of an emergency or use VOIP to call the numbers in the PersonalInfo class


2) can this be expanded to handle many students?   what would that be like?

    Yes, The current implementation of the program allows for as many students as desired, as it uses an ArrayList to hold the Student objects.
    The only issue would be memory space. Something I need to remember to ask is the signifcance of the difference in memory which an ArrayList vs an array of the same size.
    Wondering if it is worth it to use an array list for items with small amounts of data and items with large amounts, and when would it be more appropriate to use a Map instead of an array.


3) Any easy/difficult  parts? 
    
    The program was fairly easy. I found many of the parts easy. The more difficult part was figuring the approach in which I wanted to program the application.
    GUI's tend to provide more debugging I find, ( since I am still becoming more familiar with their usage ) So I providing the console based application, and then
    I will tackle the GUI based apporach to make a fully functional application.


######################################3
Statement of completion:
######################################3

Describe what portions of the assignment are done and complete. 

    As far as I know all portions of the assignmnet is done and complete.
    I created a student class which holds the student's name and which holds the student's four test scores ( or however many is set in the final int TESTS ).
    In the Student class there is a subclass/inner class which holds the test scores. The instance of Tests is called which holds all four test scores. Currently
    the Student class is practically an accessor class of the Test class with the exception of the Student name and max number of tests. Adding a phone number or any other
    Personal Infromation attached to the Student class could provide mroe functionality for the Student class.

What is missing? What caused the incompleteness.

    As far as I know nothing is missing or incomplete. I provide most of the comments/ explanations of the code in the java docs above the functions.
    There is more I plan on doing to the program after submission. But the current program meets the requirments of the assignmnet. In the comments I will attach the next version, or just resubmit the updated code.
    
How do you feel about the assignment or what did you learn while doing it?
    
    It was a fun assignment. It is intersting to see how to do it in C++ then in java as well. I took different approaches granted for each. ( I had this assignment
    assigned the past week in the C++ class ). Since the C++ class hasn't covered the creation of advanced user interfaces quite yet, I hope to be able to do that here.
    
    I have not done extensive fuzzing on the code yet.





*/