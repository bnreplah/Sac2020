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
*/
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package lecture11tempatureconvert;

import java.util.Scanner;
import java.util.Random;
/**
 *
 * @author benha
 */
public class extraCredit {
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
        //Scanner input = new Scanner(System.in);
        
        homeworkHeader("Extra Credit");
        
        //System.out.println("please enter the number of tests, and the number of people:");
        
        
        report(100);
        report(1000);
    }
    
    /**
     * returns a number 1/365
     * @return 
    */
    public static int getBirthday(){
        Random rand = new Random();
        return rand.nextInt(365) + 1;
    }//end getBirthday
    
    public static double runTests(int numberOfPeople, int testNumbers){
        int birthdays[] = new int[numberOfPeople];
        int sameBirthday = 0;
        //int birthdaysCreated = 0;
        for(int testNum = 0; testNum <= testNumbers ; testNum++){
            popBirthdays(birthdays);
            if(match(numberOfPeople, birthdays))
                sameBirthday++;
        }//endfor
        return (double)sameBirthday/(double)(testNumbers);
    }//end runTests
    
    public static boolean match(int numPeople, int birthdays[]){
        int cases = 0;
        for(int i = 0; i < birthdays.length/2 ; i++){
                for(int k = birthdays.length/2; k < birthdays.length; k++ )
                    if(birthdays[i] == birthdays[k]){
                        cases++;
                    }//end if
        }//end for
        return (cases >=1);
    }//end match
    
    
    public static void popBirthdays(int birthdays[]){
        for(int j = 0; j < birthdays.length; j++)
            birthdays[j] = getBirthday();
    }//end popBirthdays
    
    public static void report(int testCases){
        final int MAXPEOPLE = 80;
        System.out.printf("%20s %20s %10s %20s %n","Tests Cases","Number of People","","Percentage sharing a birthday");
        for(int tests = testCases,people = 2; people < MAXPEOPLE; people += 5){
            System.out.printf("%20d %20d %20.2f %% %n",tests, people ,runTests(people, tests)*100 );
        }//end for
        System.out.println();//blank line for visibility
    }

}



//Discussion Questions
/*
Did you expect to see these results?   After running these simulations is it a big deal when in a small group ( perhaps 12 people) two people have the same birthday?   

I don't really know what I expected. I kind of expected to see the results shown, knowing that the more comparisons the more likely there are those who share a birthday out of 1/365.
When 2 people have the same birthday in a small group it is a big deal since that is a 100% match out of the whole in that group. However the percentage is calculated more on liklihood of a mathch in a group not
how many match in a group. Therefore


What was easy?   Did you find breaking it up into functions helped?   Is that comfortable now?

Was there an unexpected difficult/challenging portion of the assignment?  What data structure did you use?   Did you consider a different solution?
*/