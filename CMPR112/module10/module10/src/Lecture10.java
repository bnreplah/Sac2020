///*
//* To change this license header, choose License Headers in Project Properties.
//* To change this template file, choose Tools | Templates
//* and open the template in the editor.
//*/
//
//
//
//import java.util.ArrayList;
//import java.util.Collections;
//
//
///**
//*
//* @author jkirs
//*/
//public class Lecture10Pre {
//
//
//public static void tictactoe ()
//{
//final int DIM = 3;
//
//// char [DIM][DIM] board = new char [ DIM] [ DIM];
//char board [] [] = new char [DIM] [DIM];
//
//for ( int row = 0 ; row < DIM; row ++)
//{
//for ( int col =0 ; col < DIM; col ++ )
//{
//board [row][col] = (char) ( 'a' + col + ( row * DIM) );
//}
//}
//// print routine:
//for ( int row = 0 ; row < DIM; row ++)
//{
//System.out.print("\t\t|");
//for ( int col =0 ; col < DIM; col ++ )
//{
//System.out.print ( board [row][col] + "|" );
//}
//System.out.println ();
//
//}
//System.out.println ();
//
//// random number generator is from 0 to 8
//// if value = 5 then col = 2; row = 1
//// if value = 7 then col = 1; row = 2
////
////
////
//// if value is 7
//// row = value / 3
//// col = value % 3
////
//// Below is bad code. get one randoim number and use it in the row and col calculation
//// row = ( rand () % 8 ) / 3;
//// col = ( rand () % 8 ) % 3;
////
//
///*
//|0|1|2|
//|3|4|5|
//|6|7|8|
//*/
//}
//
//
//
///**
//* @param args the command line arguments
//*/
//public static void homeworkHeader(String title) {
///**
//* @param String is the title to give the program/project
//*/
//homeworkHeader();
//System.out.println("Project Title : " + title);
//}
//
//public static void homeworkHeader() {
///**
//* @param no parameters; output of lines of data that are constant
//* through the semester. identifies the class, instructor, student, etc.
//*/
//System.out.println("Ticket : 86713 ");
//System.out.println("Class : CMPR 112 ");
//System.out.println("Student Name : Joel Kirscher ");
//System.out.println("Instructor Name : Joel Kirscher ");
//System.out.println(" ");
//}
//
//public static void main(String[] args) {
//// TODO code application logic here
//homeworkHeader("\n\nLecture 10 Ovct 28, 2020 \n Parallel arrays, Initilize arrays , Floating point, \n\n ");
//
//
//// Lecture10Pre l10p = new Lecture10Pre();
//// String arg [] = {"list", "+all"};
//// l10p.main(arg);
////
//tictactoe() ;
//if ( 3 > 1 ) return ;
//
//
//
//
//
//Tempature room = new Tempature ( 88.0 );
//System.out.println ( " Celcius = " + room.Celicus());
//// this tempature class stores only one data item for the tempature.
//// Data Hiding.
//
//
//
//
//
////
//// static void partFour()
////{
////double planetDistanceFromSun[] = new double [9];
////// Mercury
////planetDistanceFromSun[0] = 35.98E6;
////// Venus
////planetDistanceFromSun[1] = 67.24E6;
////// Earth
////planetDistanceFromSun[2] = 92.96E6;
////// Mars
////planetDistanceFromSun[3] = 141.6E6;
////// Jupiter
////planetDistanceFromSun[4] = 483.8E6;
////// Saturn
////planetDistanceFromSun[5] = 890.8E6;
////// Uranus
////planetDistanceFromSun[6] = 1.784E9;
////// Neptune
////planetDistanceFromSun[7] = 2.793E9;
////// Pluto
////planetDistanceFromSun[8] = 3.7E9;
////
////displayPlanetDistance(planetDistanceFromSun[0],"Mercury");
////displayPlanetDistance(planetDistanceFromSun[1],"Venus");
////displayPlanetDistance(planetDistanceFromSun[2],"Earth");
////displayPlanetDistance(planetDistanceFromSun[3],"Mars");
////displayPlanetDistance(planetDistanceFromSun[4],"Jupiter");
////displayPlanetDistance(planetDistanceFromSun[5],"Saturn");
////displayPlanetDistance(planetDistanceFromSun[6],"Uranus");
////displayPlanetDistance(planetDistanceFromSun[7],"Neptune");
////displayPlanetDistance(planetDistanceFromSun[8],"Pluto");
////}
//
//
//
//
//
//
//double planetDistanceToSun[] = {36E6, 67E6, 93E6, 142E6, 484E6, 891E6, 1784E6, 2793E6, 3700E6};
//
//String planetName[] = {"Mercury", "Venus", "Earth", "Mars", "Jupiter", "Saturn", "Uranus", "Neptune", "Pluto"};
//
//System.out.println ( " Output the planets loop number ONE ! ");
//for (int index = 0; index < planetName.length; index++) {
//System.out.println(planetName[index] + " " + planetDistanceToSun[index]);
//}
//System.out.println ( " \n\n");
//
//// where you have two or more arrays and the elements at the same index are related.
//// Consider elements at index = 2. the name is Earth. the distance is 93E6.
//// When you diesign using multiple arrays this is called Parallel arrays.
////
////
//
//
//
//
//
//
//
//Planet pMars = new Planet ( "Mars",141.6E6 );
//// ORRRR we create a planet class:
//Planet earth = new Planet("Earth", 93000000.0);
//
//
//
// 
//
//// an array of planets:
////'; Planet myPlanets [ ] = new { Planet("Mercury", 36E6), new Planet ("Venus",67E6 ) };\
//Planet myPlanets[] = new Planet[9];
//
//myPlanets[0] = new Planet("Mercury", 36E6);
//myPlanets[1] = new Planet("Venus", 67E6);
//myPlanets[2] = new Planet("Earth", 93000000.0);
//myPlanets[3] = new Planet("Mars", 142E6);
//myPlanets[4] = new Planet("Jupiter", 484E6);
//myPlanets[5] = new Planet("Saturn", 891E6);
//myPlanets[6] = new Planet("Uranus", 1784E6);
//myPlanets[7] = new Planet("Neptune", 2793E6);
//myPlanets[8] = new Planet("Pluto", 3700E6);
//
//System.out.println ( " Display the Array of Planet class objects. Display the 9 instances of the planet class\n\n");
//for ( int i = 0 ; i < myPlanets.length; i ++)
//{
//System.out.println ( myPlanets[i].getName() + " \t" + myPlanets[i].getDist());
//}
//System.out.println ( "\n\n");
//
//
//
//
//
//
//
//
//System.out.println ( " Show the planets but loop through the array of Planet objects using a For - Each loop \n");
//// myPlanets is an array of Planet objects
//for (Planet p: myPlanets )
//{
//System.out.println ( p.getName() + " \t" + p.getDist());
//}
//System.out.println ( "\n\n");
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
//// can we make an arrayList of planets?
//// needs twow import statements to use ArryList:
//// import java.util.ArrayList;
//// import java.util.Collections;
//
//ArrayList <Planet> myPlan = new ArrayList <Planet> () ;
//myPlan.add ( new Planet("Mercury", 36E6));
//myPlan.add ( new Planet( "Venus", 67E6));
//myPlan.add ( new Planet( "Earth", 93000000.0 ));
//
//System.out.println ( " Number of planets = " + myPlan.size());
//System.out.println ( " Show the planets from an ArrayList \n");
//for ( int index = 0 ; index < myPlan.size () ; index ++ )
//{
////string pName = myplan.get
//System.out.println ( myPlan.get(index).getName() + " \t" + myPlan.get(index).getDist() );
//
//}
//System.out.println ("\n\n");
//
//System.out.println ( " Show the planets from an ArrayList Using an For-Each loop \n");
//for ( Planet pal : myPlan)
//{
//System.out.println ( pal.getName() + " \t" + pal.getDist() );
//}
//
//
///// joel is going to put plants in order sorted by there names!
//// this attitude is put things in one by one. Each time put each item in to the appropriate place.
////
//myPlan.clear ();
//System.out.println ( " Number of planets after the .clear() = " + myPlan.size());
//
//myPlan.add ( new Planet("Mercury", 36E6));
//myPlan.add ( 1, new Planet( "Venus", 67E6));
//myPlan.add (0, new Planet( "Earth", 93000000.0));
//myPlan.add (1, new Planet("Mars", 142E6));
//
//for ( Planet pal : myPlan)
//{
//System.out.println ( pal.getName() + " \t" + pal.getDist() );
//}
//
//
///// add some more planets:
//insertPlanet( myPlan ,new Planet("Jupiter", 484E6));
//insertPlanet( myPlan ,new Planet("Saturn", 891E6));
//insertPlanet( myPlan ,new Planet("Uranus", 1784E6));
//insertPlanet( myPlan ,new Planet("Pluto", 3700E6));
//
//
//
//
//System.out.println ( " Planets list after our insert that should be sorted by planet name: \n\n ");
//
//for ( Planet pal : myPlan)
//{
//System.out.println ( pal.getName() + " \t" + pal.getDist() );
//}
//
//
//
//System.out.println ( " delete index 5 ( Saturn ) ");
//myPlan.remove(5);
//for (Planet pal : myPlan)
//{
//System.out.println ( pal.getName() + " \t" + pal.getDist() );
//}
//
//
//}
//
//
//
//
//
///// ArrayList <Planet> myPlan = new ArrayList <Planet> () ;
//public static void insertPlanet (ArrayList <Planet> myPlanets , Planet thisOne )
//{
//if ( myPlanets.isEmpty() )
//{
//myPlanets.add ( thisOne);
//return;
//}
//int i;
////System.out.print ( " Planet name = " + thisOne.getName () +" " );
//
//for ( i = 0 ; i < myPlanets.size() ; i ++ )
//{
//int compareResult = myPlanets.get(i ).getName().compareTo ( thisOne.getName() ) ;
////System.out.print ( " i="+ i+ "comp reult= " + compareResult);
//if ( compareResult >= 0 )
//{
////System.out.println ( " inserting at i=" + i );
//myPlanets.add ( i, thisOne);
//return;
//}
//
//}
////System.out.println ( "End of loop inserting at i=" + i );
//myPlanets.add ( myPlanets.size(), thisOne);
//return;
//
//}
//
//}
//
//
//// key Data
//// WorksheetName Column Row Power 6 X760
////
//
// 
//
