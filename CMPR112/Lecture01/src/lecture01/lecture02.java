/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lecture01;

/**
 *
 * @author benha
 */
public class lecture02 {
        public static void main(String[] args) {
            //while loop
            int counter = 1;
            while( counter <= 8)
            {
                System.out.println(counter++);//can also do counter= counter + 1; counter ++, ++ counter
            }
            //counter = 1;
            //for(  ((initilization))   ;   ((test for termination))    ;   ((modification of control)))
            for (int c = 1; c >=8 ; counter = counter + 1)//modification doesn't need to be in the intro to the for loop
            {
                System.out.print("\n" + c);
            }
            int primeC = 7;
            int divisor;
            for(divisor = 2; divisor < (primeC -1); divisor++ )
            {
             if( (primeC % divisor ) == 0)
             {
                 System.out.println("the Candidate" + primeC + "is not prime");
                 break;//breaks out of the loop
             }
            }
            if(divisor == (primeC -1))
            {
                    System.out.println("The candidate " + primeC + " is prime");
            }
            int numberOfStars = 12;
            //int c;
            for(int c=1; c <= numberOfStars; c++)
            {
                System.out.print("*");
        
            }
            System.out.println();
        }
        
}       
