/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package module07;
import java.lang.*;
import java.util.Random;
/**
 *
 * @author Ben Halpern
 */
public class Lecture07 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Circle cA = new Circle();
        System.out.println(cA);//will print the address of the object
        Circle cA23 = new Circle( 23.0);
        System.out.println(cA.getRadius() + ": circleN1  " + cA23.getRadius() + ": CircleN2 \n");
        displayCircle(cA);//note data space is only needed for the data, each class doesn't copy the code only stores the data and the code are pointers what to do
        displayCircle(cA23);
        System.out.println(cA.rad);//this is possible only because of inheritance and the class is within the lecture07 class
        //If the circle class was outside of the lecture class this wouldn't be possible 
        
        //Circle[] array = new Circle[1000]; instatiates an array of a thousand objects of type class Circle. 
        
        //to create random numbers in 2 method
        for (int i = 1; i < 10; i++){
            System.out.println( Math.random() );//creates random number between 0, and 1 [0,1)
            //numbers are psuedo random. ( actually uses java.util.random )
            //multiply it by the value desired, and the numbers will be between 0 and value exclusively
            
        }//end for
        
        int min = 1;
        int max = 12;
        //int range = max - min + 1;
        for (int i = 1; i < 10; i++){
            System.out.println( Math.random() * ((max - min) + 1) + min);//creates random number between 0, and 1 [0,12)
            
            //formatting for Math.random
            //Math.random() * upperLimit : [0, upperLimit)
            //Math.random() * upperLimit + lowerLimit : [lowerLimit, upperLimit]
            //Math.random() * (range) + min : [0, upperlimit]
            //same without abstraction 
            //Math.random() * (max - min + 1) : [0, upperLimit)
            //Math.random() * (max - min + 1) + min  : [0, upperLimit]
            
            //numbers are psuedo random. ( actually uses java.util.random )
            //multiply it by the value desired, and the numbers will be between 0 and value exclusively
            
        }//end for
        
        Dice die1 = new Dice();
        Dice die2 = new Dice();
        for (int i = 1; i <= 20; i++){
            die1.rollDie();
            die2.rollDie();
            System.out.println("\nDie 1: " + die1.getRoll());
            System.out.println("Die 2: " + die2.getRoll());
        }
    }
    
    //public is outside visibility
    //can create class inside class
    public static class Circle{
         
        //private means it can't be accessed directly from outside the class
        //most of the time data inside a class is private
        private double rad;
        
        //Scanner keyboard = new Scanner ( System.in );
        //note this is an instatiation of the scanner class it has an reuired parameter
        
        //below is a constructors ( special type of method ()).
        //you can tell because it has no return type
        //has same name as the class
        public Circle(){
            //generally sets default internal variables
            rad = 1.0;
        }//default constructor
        //overloaded constructor to take parameter
        
        public Circle(double rad){
            //setRadius(rad);//program mentions how they reccomend to either set the class or the method as final so it can't be changed
            //initialize set the private variable
            //not good practice to set up the the parameter to be the same name as the global variable
            
            
        }//end overloaded constructor
        
        public double getRadius(){//getter method
            return rad;
            
        }//doesn't need parameter simply returining the private data
        
        public void setRadius(double radius){//setter method
            //don't set the parameter to the same name 
            rad = radius;
            
        }//setter method
        
        //setters and getters are also called accessors and mutators 
        
        public double getArea(){
            return ( Math.pow(rad, 2)* Math.PI) ;
        }//end get circumfrence
        
        public double getCircumfrence(){
            return Math.PI * 2 * rad;
        }//end get Circumference
        public double getDiameter(){
            return rad * 2;
            
        }//end getDiameter
        
        public void setDiameter(double diameter){//abstraction: the user doesn't understand what is happening but they understand the output
            setRadius(diameter / 2);
            
        }//end setDiameter
    }//end class Circle
    
//creating method that will take a circle object
//when you create your own class you can create types of that class
    //this is autility method that allows us to accept a class object and print it
    public static void displayCircle(Circle c){//takes in te parameters of a Circle class object 
        System.out.println(c.getRadius() + ": radius,  " + c.getDiameter() + ": Diameter \n" + c.getCircumfrence() + ": Circumfrence\n  " + c.getArea() + ": area\n" );
       
    }
    
    public static class Dice{
        final private int[] face = new int[]{1,2,3,4,5,6};
        private int dieRoll;
        public Dice(){//creates dice object
            //rolls dice
            dieRoll = (int)(Math.random() * 6 + 1);
        }//end constructor
        public void rollDie(){
            dieRoll = (int)(Math.random() * 6 + 1);
        }
        public int getRoll(){
            return dieRoll;
        }
    }///end class
    
}//end class Lecture07



/* class lecture code:
//
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
//
package lecture07classes;

import java.lang.Math.*;

//
*
* @author jkirs
//
public class Lecture07Classes {

//
* @param args the command line arguments
//
public static void homeworkHeader(String title) {
//
* @param String is the title to give the program/project
//
homeworkHeader();
System.out.println("Project Title : " + title);
}

public static void homeworkHeader() {
//
* @param no parameters; output of lines of data that are constant
* through the semester. identifies the class, instructor, student, etc.
//
System.out.println("Ticket : 86713 ");
System.out.println("Class : CMPR 112 ");
System.out.println("Student Name : Joel Kirscher ");
System.out.println("Instructor Name : Joel Kirscher ");
System.out.println(" ");
}

public static void main(String[] args) {
// TODO code application logic here
homeworkHeader(" Clases Lecture ");

Circle cA = new Circle();
Circle c23 = new Circle(23.0);

// BOgus ( bad) code. Prints address of object in memoryt in Hexadecimal.
// not good; not what we want.
//System.out.println ( cA );
//System.out.println ( c23 );
//System.out.println ( " radius = " + cA.getRadius () );
// System.out.println ( " radius = " + c23.getRadius () );
c23.setRadius(33.3);

// displayCircle ( c23 );
// displayCircle ( cA );
cA.rad = 44.4; // Joel to investigate this

// Circle[] array = new Circle[]{};
// System.out.println ( Math.PI);
// arrays
//Circle[] array = new Circle[]{};
// Circle[] array = new Circle[1000];
// two approaches to getting random number i Java
for (int i = 1; i < 50; i++) {
// System.out.print ( 2.0 * Math.random() + " ");
// int max = 6;
// int min = 1;
//
// int random_int = (int) (Math.random() * (max - min + 1) + min);
// int random_int2 = (int) (Math.random() * (max - min + 1) + min);
// System.out.print ( ( random_int + random_int2) + " ");

int min = 2;
int max = 12;
//
int random_int = (int) (Math.random() * (max - min + 1) + min);
int random_int2 = (int) (Math.random() * (max - min + 1) + min);
System.out.print((random_int + random_int2) + " ");

if (i % 15 == 0) {
System.out.println();
}
}
}

// below ia utility =method that allows us to accept a class object and print it.
// Note: this is an example of a method that uses a class.
// but is not part of the class.
public static void displayCircle(Circle c) {
System.out.println(" radius = " + c.getRadius() + " diameter = " + c.getDiamter()
+ " Circumf = " + c.getCircuference() + " area = " + c.getArea());
}

public static class Circle {

// Most of the time data inside the class is private.
private double rad;

// Scanner keyboard = new Scanner ( System.in);
// below is a coinstrutor ( a spcial type of method ( ) .
// You can tell because it ahs NO return type
// the method name is the same as the name of the class
public Circle() // with no parameters is called the default constructor
{
rad = 1.0;

}
// what if they want to create an instance ( an object) from our class

// with a number right off the bat:
// - - > Circle myC = new Circle(23.0);
// we need a construtor that takes one parameter:
public Circle(double radius) {
rad = radius;
//setRadius ( radius );
}
// Constructors have no way ( except exceptions) check on this
// Coinstrutors need to always run.

// Below are exmaples of getters and setters
// accessors ( get ) and mutators ( set )
public double getRadius() {
return rad;
}

public void setRadius(double radius) {
rad = radius;
}

public double getDiamter() {
return (2.0 * rad);
}

public double getCircuference() {
return (2.0 * rad * 3.14159265359);
}

public double getArea() {
//return ( rad * rad * 3.14159265359 );
return (rad * rad * Math.PI);
}

// below is an exmaple of data Hyding
// user thinks they are storing diameter
// but we mutate it and store as radius.
public void setDiameter(double diam) {
rad = diam / 2.0;
}

}

}

// To  fix the indentation in Netbeans 

// do a Cntrl A

// do a Shift Alt F

 

*/