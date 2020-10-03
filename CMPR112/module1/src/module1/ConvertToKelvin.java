package module1;
import java.util.Scanner;
/*
 * @author Ben Halpern
 */
public class ConvertToKelvin {

    /**
     * @param degrees
     * @param convertTo
     */
    public static double algorithm(double degrees, char convertTo ){//made the algorithm into a method for future use
        //conversion Fahrenheit to Centigrade
        //  to convert to celcius subtract 32 and multiply by 5/9 (or divided by 1.8 )
        //  ( degreesFahrenheit - 32 )/1.8 = degreesCelcius
        //conversion Centigrade to Kelvin
        //  to convert to kelvin add 293.15 to the degrees in celsius
        //  ( degreesCelcius + 273.15 ) = degreesKelvin
        //initialization of variables
        
        double degreesCelcius;
        double degreesKelvin;
        //algorithm for the conversion to celcius
        degreesCelcius = ( degrees - 32 ) / 1.8 ;
        //algorithm for the converstion to kelvin
        degreesKelvin = degreesCelcius + 273.15 ;
        
        if ( convertTo == 'C'){
            return degreesCelcius;
        }
        else{
            return degreesKelvin;
        }//end of if else block    
    }//end of algorithm method
    
    public static void main(String[] args) {
        //Homework Header is always required:
        System.out.println("Ticket : 86713");
        System.out.println( "Course : CMPR 112  ");
        System.out.println( "Student : Ben Halpern ");
        System.out.println( "Instructor : Joel Kirscher");
        System.out.println( "Environment: Win 10 NetBeans ");
        System.out.println( "Project Title : Convert to Kelvin  ");
        //Date 08/26/20
        //End of homework header
        System.out.println();//creates blank line
        
        //conversion Fahrenheit to Centigrade
        //  to convert to celcius subtract 32 and multiply by 5/9 (or divided by 1.8 )
        //  ( degreesFahrenheit - 32 )/1.8 = degreesCelcius
        //conversion Centigrade to Kelvin
        //  to convert to kelvin add 293.15 to the degrees in celsius
        //  ( degreesCelcius + 293.15 ) = degreesKelvin
        
        
        //initialization of variables
        double degreesCelcius;
        double degreesKelvin;
        double degreesFahrenheit;
        
        //initialization of scanner
        Scanner input;
        input = new Scanner ( System.in );
        
        //prompt
        System.out.println("Please input in degrees the temperature in Fahrenheit");
        System.out.print("Degrees in Fahrenheit:");
        //requesting input from user
        degreesFahrenheit = input.nextDouble();
        
        //converts to Centigrade and Kelvin
        degreesCelcius = ( degreesFahrenheit - 32 ) / 1.8 ;//note because I converted the divisor to a double instead of doing the computation seperatly it doesn't provide a logical error
        degreesKelvin = degreesCelcius + 273.15 ;
        //the best solution is to conver them all into doubles if trying to put them into a double
        //wrong: (degreesF - 32 )*(5/9) results in a 0.0 celcius because when dividing int numbers the answer is an int

        //used for debugging, verbose
        //System.out.println("The degrees Fahrenheit " + degreesFahrenheit + " is equal to " + degreesCelcius + " degrees Centigrade, and " + degreesKelvin + " degrees Kelvin");
        
        
        /*if temperature in Kelvin is 0.0 or greater output :
        *
        *       Temperature is valid,  72.3 in F is 22.3 in C and is 295.45 in Kelvin.
        *
        *if temperature in Kevin is less than 0.0 output :  
        *
        *     Temperature is not valid,  72.3 in F is 22.3 in C and is 295.45 in Kelvin.  
        */
        
        if (degreesKelvin >= 0.0){
            System.out.println("Temperature is valid, " + degreesFahrenheit + " in F is " + degreesCelcius + " in C and is " + degreesKelvin + " in Kelvin.");
        }
        else{
            System.out.println("Temperature is valid ");
        }
        
        //At what temperature does Fahrenheit produce a negative values of Kelvin temperature?
        //    At -459.68 degrees Fahrenheit, a negative value of kelvin is reached and at -459.67 kelvin is at 0.0
        //How did you figure that out?   ( Direct computation, or trial and error , or using your code or some other method ) 
        //    Trial and Error, testing numbers around 0 Kelvin
        
        //the same if statment using the algorithm method declared above
        /*
        *if (algorithm(degreesFahrenheit, 'K') >= 0.0 ){
        *    System.out.println("Temperature is valid, " + degreesFahrenheit + " in F is " + algorithm(degreesFahrenheit, 'C') + " in C and is " + algorithm(degreesFahrenheit, 'K') + " in Kelvin.");
        *}
        *else{
        *   System.out.println("Temperature is not valid ");
        *}
        */  
        
    }//end of main method   
    
}//EOF, End of Public Class ConverToKelvin
