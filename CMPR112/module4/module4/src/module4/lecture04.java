///*
//* To change this license header, choose License Headers in Project Properties.
//* To change this template file, choose Tools | Templates
//* and open the template in the editor.
//*/
//
////package goldassign04max;
//
///**
//*
//* @author jkirs
//*/
////public class GoldAssign04Max {
//
//
//// int myMax ( int a, int b)
//// {
//// return ( a > b ? a:b);
////
//// }
////
// 
////
////
////
////
////
//// /* @param args the command line arguments
//// */
//public static void main(String[] args)
//{
//// // TODO code application logic here
////
////
//// int a = 23;
//// int b = 55;
////
//// a = 2123456789;
//// b = 2012345678;
////
//// System.out.println ( " a = " + a + " b = " + b );
////
////// int temp = a;
////// a = b;
////// b = temp;
////
////// a = a * b;
////// b = a / b;
////// a = a / b;
////
//// a = a ^ b; // ^ is the XOR operation ( exclusive OR )
//// b = a ^ b;
//// a = a ^ b;
//// System.out.println ( " a = " + a + " b = " + b );
//// ^ | 0 1
//// ----------
//// 0 | 0 1
//// 1 | 1 0
////
//
//int month = 3;
//String monthName ="";
//int numDays = 0;
//
//char division = 'c';
//
//
//// for ( division = 48; division <= 57; division ++)
//// {
//// System.out.print ( " " + division );
//// }
//
//// for ( division = 'A'; division <= 'P'; division ++)
//// {
//// System.out.print ( " " + division );
//// }
//
//
////double salesAmt = 12345.378;
////System.out.printf ("%,f", salesAmt); // output is 12,345.378000
//
// 
//
//
////double salesAmt = 12345.372;
////System.out.printf ("%,8.2f", salesAmt); // produces 12,345.37
//
// 
//
//
//// decomposing a coimposit number into its digits:
//// lets do a decimal number:
//// take the decimal number 637 apart. What is the value in the unit postiion?
//// what is the value in the ten postion what is the value in the hundres postion.
//int num = 623;
//int units ;
//int tens;
//int hundreds;
//
////units = num % 10;
////num = num / 10; // num now has 63.
////tens = num % 10; // now the 3 is in the tens variable.
////num = num / 10 ; // num is 63 /10 which is 6.
////hundreds = num % 10; // hundreds is a 6; and num is still 6
////
////System.out.println ( " hundreds = " + hundreds + " Tens = " + tens + " units = " + units);
//
//num = 38;
//// Fernando wants to work from the hundreds down to the units:
//hundreds = num / 100;
////num = num - ( 100 * hundreds);
//num = num % 100;
//tens = num / 10;
//num = num % 10;
//units = num;
//System.out.println ( " hundreds = " + hundreds + " Tens = " + tens + " units = " + units);
//
// 
//
// 
//
//// if we have the number of seconds into the day
//// we can decompos it into hours, minutes and seconds using a simular algorithm
////
////
////int secondsInToDay = 3600 * 18 + 55 * 60 + 35; // the value is 68135
////
////System.out.println (" Seconds into the day for 18:55:30 is " + secondsInToDay );
////
////System.out.println () ;
////
////int totSec = 68135;
////int hh; // hours
////int mm; // minutes
////int ss; // seconds
////
////ss = totSec % 60;
////System.out.println ( " totSec = " + totSec + " Second = " + ss ) ;
////totSec /= 60;
////mm = totSec % 60;
////System.out.println ( " totSec = " + totSec + " Minutes = " + mm);
////hh = totSec / 60;
////System.out.println ( " totSec = " + totSec + " Hours = " + hh);
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
//}
//
//}