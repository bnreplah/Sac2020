///*
//* To change this license header, choose License Headers in Project Properties.
//* To change this template file, choose Tools | Templates
//* and open the template in the editor.
//*/
//
//package Lecture08;
//
//import java.util.Scanner;
//
//
////
////
////
//// https://en.wikipedia.org/wiki/Javadoc
////
////
//
// 
//
///**
//* Lecture08  - package to use with Lecture 08
//*
//* @author Joel Kirscher and others
//* @version 1.0
//* @since 1.0
//*
//*
//*/
//public class Lecture08 {
//// https://en.wikipedia.org/wiki/Javadoc
//
//
///**
//* Lecture 08 is a class to contain demo code when teaching.
//*
//* @param title
//* Lecture 08 Writing Java with Structure. Separate files for classes, JavaDoc, test Cases ?
//*
//*/
//
//public static void homeworkHeader ( String title)
//{
///**
//* Display the required lines that the instructor wants. Class name, student name, tec.
//* Output is to the System.Out.println ()
//*
//* @param String is the title to give the program/project
//* displayed at the bottom for the homeworkHeader.
//*
//*/
//homeworkHeader () ;
//System.out.println ( "Project Title : " + title );
//
//
//}
//
///**
//* displays on the system console the required
//* Homework header for a student in CMPR classes.
//*
//*
//*
//* @author Jack Sparrow
//*
//*
//*/
//public static void homeworkHeader ( )
//{
///**
//* @param no parameters; output of lines of data that are constant through the semester.
//* identifies the class, instructor, student, etc.
//*/
//System.out.println ( "Ticket : 86713 ");
//System.out.println ( "Class : CMPR 112 ");
//System.out.println ( "Student Name : Joel Kirscher ");
//System.out.println ( "Instructor Name : Joel Kirscher ");
//System.out.println ( " ");
//}
//
///**
//*
//* @param args
//* String [ ] args; an array of strings
//*
//*
//* String parameters passed in via the command line.
//*
//*/
//public static void main(String[] args) {
//// TODO code application logic here
//homeworkHeader ( "Lecture 08 - How to put a class in to a separate file ");
//
//Circle cir = new Circle ( 23.3);
//
//
//Scanner scan = new Scanner ( System.in );
//
//// below are the step to creat a separate class file to hold a class.
//// this is the correct and well orgaized way to go.
////
//// Start your Java application/ project.
//// then go to File - > New File
////
//// The "Choose File Type" dialog window will come up.
////
//// the Project name . - I leave that alone for now.
//// Set the Catagories - > Java
//// Set the File Types to Java Class
////
//// Note the description below your selection helps describe what you are doing ( very helpfuil)
////
//// Click on - > Next
////
////The "New Java Class" dialog winodw will come up.
//// for now just set the name of the Java Name. It must be , it will be the name of your class.
//// if you want to use a different name for the class you will need to create a new file to hold the java code for the class.
////
//// Then click on Finish.
//// a additional edit window will be added to the editor window.
////
////
//// Created a Rectangle class. There is now a file that can be seen in the Project view.
//// we have Lecture08.java
//// and we have Rectangle/java
////Question: the name of the class in java is also the name of ?
//
//
//Rectangle rectA = new Rectangle ();
//Rectangle rectSq = new Rectangle ( 5.0);
//Rectangle rect4x6 = new Rectangle ( 4.0, 6.0);
//
//displayRectangle ( rectA);
//displayRectangle ( rectSq);
//displayRectangle ( rect4x6);
///// turn this on to see issue. System.out.print ( rectA.)
//System.out.println ( rectA.perimeter());
//
//
//
//
//final double PI = 3.1415926;
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//// final int MYSTERY;
//// // latter that night . . .
//// MYSTERY = 23;
//// // the next morning:
//// MYSTERY = 44;
//
//
//// now an array of rectangles:
//final int NUM_RECT = 4;
//
//
//
//Rectangle[ ] rectArr = new Rectangle[NUM_RECT];
//
//Rectangle rectZ;
//// System.out.println ( rectZ.getLength() );
//
//
//rectZ = new Rectangle ();
//
//
//
//for ( int i = 0 ; i < NUM_RECT; i ++ )
//{
//rectArr[i] = new Rectangle () ;
//}
//
//
//}
//
//
//
///**
//* Displays to the System.out.print () the rectangle length, width, area and perimeter.
//*
//* @param disRect
//* pass in the rectangle you wish to display to the System.out.println ()
//* displays
//*/
//public static void displayRectangle ( Rectangle disRect )
//{
//System.out.println ( "Rectangle width=" + disRect.getWidth() + " length- " + disRect.getLength() +
//" area="+disRect.area() + " peremeter= " + disRect.perimeter());
//// Comment : when typing this in and pausing after entering disRect. A message came up saying
//// JavaDoc not found.
//
//
//String firstName = "Jack" ;
//String lastName = "Smith";
//String formal = lastName + ", " + firstName;
//
//
//}
//
// 
//
//}
//
// 
//
///*
//
//JAVADOCS
//to verify your JavaDoc documentin the program
//Tools - > Analyze JavaDoc
//
//to display
//Run - > Generate JavaDoc.
//
//*/
//
// 
//
// 
//
// 
//
//// Examplse of overloade methods:
/////*
////
////
//// /**
//// *
//// * @param sqLength
//// */
//// public Rectangle(double sqLength) {
//// width = length = sqLength;
//// }
////
//// /**
//// *
//// * @param len
//// * @param wid
//// */
//// public Rectangle(double len, double wid) {
//// width = len;
//// length = wid;
//// }
////
//// /**
//// * set or change the width of the rectangle.
//// *
//// * @param newWidth
//// */
//// public void setWidth(double newWidth) {
//// width = newWidth;
//// }
////
//// /**
//// * * set or change the length of the rectangle.
//// *
//// * @param newLength
//// * double new length to set for the rectangle
//// */
//// public void setLength(double newLength) {
//// this.length = newLength;
//// }
////
//// public void setDim ( double userL, double userW)
//// { width = userW; length = userL; }
////
////
//// public void setDim ( double side)
//// {
//// width = length = side;
//// }
////
//// public void setDim ( double thisdim, int num ) { }
////
//// public void setDim ( int num, double thisdim ) { }
////
//// public void setName ( String firstName, String lastName ){ }
//// public void setName ( String firstName, String lastName , char middleInit ){ }
////
////
////
////
//// /// rect.setDim ( 12.0, 20.0);
//// /// rect.setDim ( 11.0 ) ;
//// /// rect.setDim ( 1.0, 7 );
////
////
////
////*/
//
