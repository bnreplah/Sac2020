/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lecture01;
//import java.util.Scanner;
/**
 *
 * @author Ben Halpern
 */
public class Lecture01 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //Homework Header is always required:
        System.out.println("Ticket : 86713");

        System.out.println( "Course : CMPR 112  ");

        System.out.println( "Student : Ben Halpern ");

        System.out.println( "Instructor : Joel Kirscher");

        System.out.println( "Environment: Win 10 NetBeans ");

        System.out.println( "Project Title : My first program ");
        //End of homework header
        System.out.println();//creates blank line
        
        //System.out.println("hello World!");
        
        int studentsInCMPR112;
        
        int numberOfPeopleInClassroom;
        
        numberOfPeopleInClassroom = 23;
        
        // 123.45 1.2345 x 10.2
        double bankAccountBalance = 123.45;
        bankAccountBalance = 1234.46;
                
        double atomWeightOfMyDragonInPounds = 4.285-23; //can write doubles in scientific notation
        String pirateName;
        pirateName = "jack sparrow";
        
        //we have now three data types: String double int
        //boolean
        boolean hallLightOn;
        hallLightOn = true;
        
        char studentInitial;
        studentInitial = 'A';
        
        short numberOfAntsOnTheCounter; //shorts only take 2 bytes
        //######################################################################
        //######################################################################
        
        //payroll problem
        //  hourly wage = 10.00
        //  hours = 30      then Gross pay = 300
        //
        //      hourlyWage = 10.00
        //      hours   =   46.0
        //      Gross Pay = 30 *10
        //      Gross Pay = 300
        //
        //
        
        //  test case 2
        //      hourlyWage = 10.00
        //      hours   =   46.0
        //      Gross Pay = 40.0 * hourlyWage + (hours - 40 ) * wage * 1.5;
        //      Gross Pay = 400                     6 * 10 * 1.5
        //      Gross Pay = 400 + 90
        //      Gross pay = 490
        
        //Algorithim for Payroll Gross pay calcuations with time and a half calculations
        //
        //get hours worked
        //get wage
        //if hours is less than or equal to 40.00 then:
        //      Gross Pay = hours * wage
        //else: Overtime
        //      Gross pay = 40 * wage + ( hours - 40 ) * wage * 1.5
        /*
        double hoursWorked;
        double hourlyWage;
        double grossPay;
        Scanner myKey;
        myKey = new Scanner ( System.in );
        
        System.out.println();
        System.out.print("Enter Hours Worked: ");
        hoursWorked = myKey.nextDouble();
        System.out.print("Enter Hourly wage: ");
        hourlyWage  = myKey.nextDouble();
        //algorithm
        if ( hoursWorked <= 40.0 )
        {
            //if wanted to add more than one statment add curly braces
            grossPay = hoursWorked * hourlyWage;
        }
        else
        {
            grossPay = 40 * hourlyWage + ( hoursWorked - 40 ) * hourlyWage * 1.5;
        }
        
        System.out.println( "Gross pay is $ " + grossPay );
        */
       

    }
    
}//EOF
