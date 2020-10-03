/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package module5;

/**
 *
 * @author benha
 */

public class labMaxFunc {
    static int myMax(int a, int b){
        if (a > b)
            return a;
        return b;

    }//end myMax
    static int myMax(int a, int b, int c){
        //ie: a = 1, b = 2 , c = 3
        //ie: a = 2, b = 1. c = 3
        if (a > b){//if a is greater than b : 1 > 2  ( false ) , 2 > 1 (true )
            if (a > c) // if a is greater than c : 1 > 3 ( false), 2 > 3 (false ): returns c
                return a;
            return c;
        }//end if
        else if (b > c){// if b is greater than c : 2 > 3 ( false ),return c
            return b;
        }//end else if
        return c;
    }//end myMax
    
    
    
    public static void main( String[] args){
        int a, b, c, d, e, f;
        
        
        a = 3;
        b = 5;
        c = 9;
        d = 3;
        e = 12;
        f = 12;
        //test case 1
        System.out.println("test case 1");
        System.out.println(myMax(a, b));//3, 5 : 5
        System.out.println(myMax(a, b, c));//3,5,9 : 9
        //test case 2
        System.out.println("test case 1");
        System.out.println(myMax(a, c));//3, 9: 9
        System.out.println(myMax(a,b,d));//3,5,3 : 5
        //test case 3
        System.out.println("test case 1");
        System.out.println(myMax(a,d));//3,3 : 3
        System.out.println(myMax(a,c,e));//3, 9, 12: 12
        
        
       
        
        
    }//end public main
    
}
//Discussion Questions
//Did you have time to test your function?   How many test cases should you have at a minimum for the 2 parameter case?   
//      yes, for the two parameter method you should hava at minimum 3 test cases
//How many test cases at a minimum should you have for the three parameter case ?  
//       4 // 2 where all the numbers are different but rearranged , and a fourth where it is equal
//          //possibly a 5th where two numbers are equal
//Did you see a way to code the 3 and 4 parameter versions without an if statement?
//      yes with ternery operators
//How many test cases would you need for the 4 parameter max function?
//      5

 