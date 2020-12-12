/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package Lecture09inclass;


import java.lang.String;
import java.lang.ArrayIndexOutOfBoundsException;

 

/**
*
* @author jkirs
*/
public class Lecture09InClass {

/**
* @param args the command line arguments
*/
public static void homeworkHeader(String title) {
/**
* @param String is the title to give the program/project
*/
homeworkHeader();
System.out.println("Project Title : " + title);
}

public static void homeworkHeader() {
/**
* @param no parameters; output of lines of data that are constant
* through the semester. identifies the class, instructor, student, etc.
*/
System.out.println("Ticket : 86713 ");
System.out.println("Class : CMPR 112 ");
System.out.println("Student Name : Joel Kirscher ");
System.out.println("Instructor Name : Joel Kirscher ");
System.out.println(" ");
}

public static void main(String[] args) {
// TODO code application logic here
homeworkHeader("Lecture 09 \n\n\n");

// below a short example of how floatin gpoint loses precisions at some points
int c = 1;
float Tester = 1;
for (c = 1; c <= 100000000;c++)
{

if (c != Tester)
{
break;
}
Tester += 1.0;

}
System.out.println("The value of the float is: " + Tester);
System.out.println("The value of the int is: " + c);


// 1.6777216 E 7
// 1 6777216 . 0
// c ( an integer ) = 16777218 roubgly 2 to the 24 power.
// 16777286

 

try
{
// Some arrays:
// we need two imports
// import java.lang.String;
// import java.lang.ArrayIndexOutOfBoundsException;
// 0 1 2 3 4 5
// int someInts[ ] = { 22,55,66,11,77,99};
int[] someInts = {22, 55, 66, 11, 77, 99};

//final int NUM_ELEMENTS = 99;

//final int NUM_ELEMENTS;
//NUM_ELEMENTS = 201;

final int NUM_ELEMENTS = 201;



int [] moreIntArray;// here we declare a variable that will point to 99 ints

moreIntArray = new int [NUM_ELEMENTS]; // is this memeory lost .
// moreIntArray = null;
System.gc();
//moreIntArray = new int [44];


// int [] moreIntArray = new int [99]; // valid indexes are from 0 to 98
System.out.println ( " number of element in the moreIntArray is 9 9? ) " + moreIntArray.length);

// code below Zero's the array. Puts a zero into every element.
for ( int index = 0 ; index < NUM_ELEMENTS; index ++ )
moreIntArray [ index ] = 0;

for ( int index = 0 ; index < NUM_ELEMENTS; index ++ )
moreIntArray [ index ] = index + 1;

// below put the squares of the numbers into the elements:
for ( int index = 0 ; index < NUM_ELEMENTS; ++ index )
moreIntArray [ index ] = ( index + 1 ) * ( index + 1);

for ( int index = 0 ; index < NUM_ELEMENTS; index ++ )
System.out.print ( moreIntArray [index] + " ");
System.out.println () ;


double myPi = Math.PI;




// with 6 elements the indexes into the array are from 0 to n-1.
// so in this case the indexes go from 0 to ( 6-1 ) 0 to 5.
for (int index = 0; index < 6; index++) {
System.out.print(someInts[index] + " ");
}
System.out.println();
// above is an example of declaring an array and setting values into the elements at the start.

String[] names = {"John", "Mary", "Pham", "Alex", "Manuel"};
//String names[] = {"John", "Mary", "Pham", "Alex", "Manuel"};

// format of the array declaration has two formats? ? why ?
// Strings are a class not a native data type
for (int index = 0; index < 5; index++) {
System.out.print(names[index] + " ");
}
System.out.println();

// Below is a Java For-Each loop.
for (String eachName : names ){
System.out.print ( eachName + " ");
}

System.out.println();
System.out.println();
// below caues a ArrayIndexOutOfBoundsException
//System.out.print ( names [ 23 ] + " ");
System.out.println();

int sizeOfArray = names.length;
System.out.println(" Size of the names string array is " + sizeOfArray);
System.out.println();

dispStringArray ( names );



// application example below:
// hold studnet names in a class.
// up to 50 names

// but we do notknow how many stuendts will register for the class.
String [ ] studentNames = new String [50];
int activeNumberOfStudents = 0;
// studentNames [0] = "john"; activeNumberOfStudents ++;
// studentNames [1] = "Alphred"; activeNumberOfStudents ++;
activeNumberOfStudents = addStudent ( studentNames, "John", activeNumberOfStudents);
activeNumberOfStudents = addStudent ( studentNames, "Mary", activeNumberOfStudents);

System.out.println ( " Acitve number of students = " + activeNumberOfStudents);
// this generates a throwanble exception:
// System.out.println ( studentNames [ 83] );




String Catch22 = "Read me back the last line! Read me back the last line. What ?!";









}
catch (ArrayIndexOutOfBoundsException ex )
{
System.out.println ( " Array index Out of Bounds exceptions get message = " + ex.getMessage () );
ex.printStackTrace();
}

}


// TODO can we make active a reference parameter?
public static int addStudent ( String [] studentNames, String nameToAdd, int active)
{
studentNames[active] = nameToAdd;
active ++ ;
return active;
}



public static void dispStringArray(String[] arrOfStr)
{
for (int index = 0; index < arrOfStr.length; index++) {
System.out.print(arrOfStr[index] + " ");
}
System.out.println();
}

}
