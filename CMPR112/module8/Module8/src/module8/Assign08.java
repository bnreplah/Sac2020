/**
*Ticket : 86713
*Course : CMPR 112
*Student : Ben Halpern
*Instructor : Professor Kirscher
*Environment: Win 10 NetBeans
*Project Title : Assign 08 - Temperature Class
*
*
*Assignment details:
* Look at and implement exercise # 8 from the book   
* HOWEVER,   I find it a bit limiting.   
* 
* We can keep the Constructor that has a double as the parameter that specifies a temperature in Fahrenheit.  
* 
* Do do all the methods that they show.   
* ADD 
* 
* Add a method to set the temperature given it is in Kelvin   
* void setKelvin ( double tempInKelvin)
* Add a method to set the temperature given it is in Celsius:
* void setCelcius ( double tempInCelsius ) 
* 
* Please document your test cases:
* 
* 
* That means you should log each value/function that you use and the result.   

* DISCUSSION QUESTIONS:
* 
* How many data items are private and hidden inside the class?
* 
* Do you have 1, 2 or 3 data items in the class?   
* Why did you implement that way ?
* 
* How many test cases are need and why?
* 
* Did you exercise all the lines of code in the class?
 
* Question # 8 from the book:
* Write a Temperature class that will hold a temperature in Fahrenheit,   And provide methods to get the temperature in Fahrenheit, Celsius, and Kelvin.   The class should have the following field
* 
* 
* fahrenheit - A double that holds a Fahrenheit Temperature.
* 
* The class should have the following methods:
* Constructor - The constructor accepts a Fahrenheit temperature ( as a double) and stores it in the ftemp field. 
* setFahrenheit - The setFahrenheit method accepts  a Fahrenheit temperature ( as a double) and stores it in the ftemp field. 
* 
* getFahrenheit - Returns the value of the ftemp field, as a Fahrenheit temperature.
* celsius - Returns the temperature in Celsius.
* kelvin - Returns the value of the ftemp field converted to Kelvin.  
* Use the following formula to convert the Fahrenheit temperature to Celsius
* Celsius = ( 5/9 ) * ( Fahrenheit - 32.0 )
* Use the following to convert Fahrenheit to Kelvin:
* 
* 
* Kelvin = ( ( 5/9 ) * ( Fahrenheit - 32.0 ))  + 273.15
* ######################################################################################################################################3
* notes:
* ######################################################################################################################################3 
* conversion table: https://contractorquotes.us/temperature-conversion-table/
* It seems the kelvin value is accurate in the table rounded to the nearest degree
*   Fahrenheit	Celsius	Kelvin
*       0	-18	255
*       2	-17	256
*       4	-16	258
*       6	-14	259
*       8	-13	260
*       10	-12	261
*       12	-11	262
*       14	-10	263
*       16	-9	264
*       18	-8	265
*       20	-7	266
*       22	-6	268
*       24	-4	269
*       26	-3	270
*       28	-2	271
*       30	-1	272
*       32	0	273
*       34	1	274
*       36	2	275
*       38	3	276
*       40	4	278
*       42	6	279
*       44	7	280
*       46	8	281
*       48	9	282
*       50	10	283
*       52	11	284
*       54	12	285
*       56	13	286
*       58	14	288
*       60	16	289
*       62	17	290
*       64	18	291
*       66	19	292
*       68	20	293
*       70	21	294
*       72	22	295
*       74	23	296
*       76	24	298
*       78	26	299
*       80	27	300
*       82	28	301
*       84	29	302
*       86	30	303
*       88	31	304
*       90	32	305
*       92	33	306
*       94	34	308
*       96	36	309
*       98	37	310
*       100	38	311
* 
* 
* going to try to create a dictionary like 2d array which will hold the predicted values for each.
* will ask user if they would like to output their data to a file/log
* will attempt to populate another 2d array of the test cases and display to the screen in a report table fashion:
* TEST CASES:
*========================================================================================================================
* predicted fahrenehit         fahreneheit         predicted celsius       celsius         predicted kelvin        kelvin
* 
* 
* 
* 
*/
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package module8;
import java.util.Scanner;
/**
 *
 * @author benha
 */
public class Assign08 {
    //protected static Scanner pause = new Scanner( System.in );//debugging pause object to slow down some of the driver output
    /**
     * Temperature class will hold a temperature in Fahrenheit
     * Contains the following methods:
     *      Constructor - The constructor accepts a Fahrenheit temperature ( as a double) and stores it in the ftemp field. 
     *      setFahrenheit - The setFahrenheit method accepts  a Fahrenheit temperature ( as a double) and stores it in the ftemp field. 
     *      getFahrenheit - Returns the value of the ftemp field, as a Fahrenheit temperature.
     *      celsius - Returns the temperature in Celsius.
     *      kelvin - Returns the value of the ftemp field converted to Kelvin.  
     * Uses the following formula to convert the Fahrenheit temperature to Celsius
     *          Celsius = ( 5/9 ) * ( Fahrenheit - 32.0 )
     
     * @author BenHalpern
     */
    public static class Temperature{
        private double ftemp;//fahrenheit global variable
        public final String DEGREE = "\u00B0";
        /**
         * Default constructor
         */
        public Temperature(){//default constructor contains no parameters
            this.ftemp = 75.0;//sets default fahrenheit to room temperature
            
        }//end default constructor
        
        /**
         * Overloaded constructor
         * @param tempF
         * 
         */
        public Temperature( double tempF ){//overloaded constructor
            this.ftemp = tempF;//sets passed parameter to tempF
            
        }//end overloaded constructor
        
        /**
         * Sets the temperature in fahrenheit and stores it
         * The setFahrenheit method accepts  a Fahrenheit temperature ( as a double) and stores it in the ftemp field.
         * @param tempF
         * 
         */
        public void setFahrenheit( double tempF ){//sets given Fahrenheit and stores it
            this.ftemp = tempF;//sets passed parameter to tempF
            
        }//end method setFahrenheit
        
        /**
         * Returns the value of the ftemp field, as a Fahrenheit temperature.
         * @return ftemp
         */
        public double getFahrenheit(){//getter method for ftemp
            return ftemp;//returns the private variable ftemp
            
        }//end method getFahrenehit
        
        
        /**
         * Returns the temperature in Celsius.
         * Celsius = ( 5/9 ) * ( Fahrenheit - 32.0 )
         * @return temperature in Celsius( 5/9 ) * ( Fahrenheit - 32.0 )
         */
        public double celsius(){//getter method for celsius
            return ( (ftemp - 32.0)*(5.0/9.0));//returns value in celsius
            //note that 5/9 is put into floating point format in order to not do integer division and implicitly convert the ftemp - 32.0 into an int
            
        }//end method celcius 
        
        /**
         * kelvin - Returns the value of the ftemp field converted to Kelvin.
         * Kelvin = ( ( 5/9 ) * ( Fahrenheit - 32.0 )  + 273.15
         *      or celsius + 273.15
         * @return temperature in kelvin 
         */
        public double kelvin(){//getter method kelvin
            return (this.celsius() + 273.15);//uses the celsius method to convert to celsius then adds 273.15
            
        }//end method kelvin
        
        public void setKelvin ( double tempInKelvin ){//setter method kelvin, dependent on setCelsius and setFahrenheit
            //this.setCelsius(tempInKelvin);
            this.setCelsius( tempInKelvin - 273.15 );
            //this.ftemp = (9.0/5.0) * (tempInCelsius + 32.0) - 273.15;
            
        }//end method setKelvin
        
        public void setCelsius ( double tempInCelsius ){//setter method celsius, dependent on setFahrenheit
            this.setFahrenheit(((((9.0/5.0) * tempInCelsius) + 32.0)));//this is the inverse of the function above in the celsius method
            //this.ftemp = (9.0/5.0) * (tempInCelsius + 32.0);
            
        }//end method setCelsius
        
    }//end class Temperature
    //end temperature class block
    
    /**
     * reportTest - a method to create a table of predicted test cases and the result
     */
    static void reportTest(Temperature temp, double[][] calculatedValues){//a method to write a report and display test cases
        //initalizationa and instatiation
        //double predicted[][];
        //predicted = new double[101][3];
        //2D array populated with the following code:
        
        //pasted into code for display purposes
        //for(double i = 1.0; i <= 100; i++)
        //    System.out.printf("%s  %.2f  %s  %.2f  %s  %.2f  %s%n","\t\t\t\t{",((i*1.8) + 32),",", i , ",",(273.15 + i),"},");
        
        
        //test case 2D array 0 - 100 degrees celsius
        //array size as seen above double predicted
        double[][] predicted = {{  32.00  ,     0  ,  273.15  },
				{  33.80  ,  1.00  ,  274.15  },
				{  35.60  ,  2.00  ,  275.15  },
				{  37.40  ,  3.00  ,  276.15  },
				{  39.20  ,  4.00  ,  277.15  },
				{  41.00  ,  5.00  ,  278.15  },
				{  42.80  ,  6.00  ,  279.15  },
				{  44.60  ,  7.00  ,  280.15  },
				{  46.40  ,  8.00  ,  281.15  },
				{  48.20  ,  9.00  ,  282.15  },
				{  50.00  ,  10.00  ,  283.15  },
				{  51.80  ,  11.00  ,  284.15  },
				{  53.60  ,  12.00  ,  285.15  },
				{  55.40  ,  13.00  ,  286.15  },
				{  57.20  ,  14.00  ,  287.15  },
				{  59.00  ,  15.00  ,  288.15  },
				{  60.80  ,  16.00  ,  289.15  },
				{  62.60  ,  17.00  ,  290.15  },
				{  64.40  ,  18.00  ,  291.15  },
				{  66.20  ,  19.00  ,  292.15  },
				{  68.00  ,  20.00  ,  293.15  },
				{  69.80  ,  21.00  ,  294.15  },
				{  71.60  ,  22.00  ,  295.15  },
				{  73.40  ,  23.00  ,  296.15  },
				{  75.20  ,  24.00  ,  297.15  },
				{  77.00  ,  25.00  ,  298.15  },
				{  78.80  ,  26.00  ,  299.15  },
				{  80.60  ,  27.00  ,  300.15  },
				{  82.40  ,  28.00  ,  301.15  },
				{  84.20  ,  29.00  ,  302.15  },
				{  86.00  ,  30.00  ,  303.15  },
				{  87.80  ,  31.00  ,  304.15  },
				{  89.60  ,  32.00  ,  305.15  },
				{  91.40  ,  33.00  ,  306.15  },
				{  93.20  ,  34.00  ,  307.15  },
				{  95.00  ,  35.00  ,  308.15  },
				{  96.80  ,  36.00  ,  309.15  },
				{  98.60  ,  37.00  ,  310.15  },
				{  100.40  ,  38.00  ,  311.15  },
				{  102.20  ,  39.00  ,  312.15  },
				{  104.00  ,  40.00  ,  313.15  },
				{  105.80  ,  41.00  ,  314.15  },
				{  107.60  ,  42.00  ,  315.15  },
				{  109.40  ,  43.00  ,  316.15  },
				{  111.20  ,  44.00  ,  317.15  },
				{  113.00  ,  45.00  ,  318.15  },
				{  114.80  ,  46.00  ,  319.15  },
				{  116.60  ,  47.00  ,  320.15  },
				{  118.40  ,  48.00  ,  321.15  },
				{  120.20  ,  49.00  ,  322.15  },
				{  122.00  ,  50.00  ,  323.15  },
				{  123.80  ,  51.00  ,  324.15  },
				{  125.60  ,  52.00  ,  325.15  },
				{  127.40  ,  53.00  ,  326.15  },
				{  129.20  ,  54.00  ,  327.15  },
				{  131.00  ,  55.00  ,  328.15  },
				{  132.80  ,  56.00  ,  329.15  },
				{  134.60  ,  57.00  ,  330.15  },
				{  136.40  ,  58.00  ,  331.15  },
				{  138.20  ,  59.00  ,  332.15  },
				{  140.00  ,  60.00  ,  333.15  },
				{  141.80  ,  61.00  ,  334.15  },
				{  143.60  ,  62.00  ,  335.15  },
				{  145.40  ,  63.00  ,  336.15  },
				{  147.20  ,  64.00  ,  337.15  },
				{  149.00  ,  65.00  ,  338.15  },
				{  150.80  ,  66.00  ,  339.15  },
				{  152.60  ,  67.00  ,  340.15  },
				{  154.40  ,  68.00  ,  341.15  },
				{  156.20  ,  69.00  ,  342.15  },
				{  158.00  ,  70.00  ,  343.15  },
				{  159.80  ,  71.00  ,  344.15  },
				{  161.60  ,  72.00  ,  345.15  },
				{  163.40  ,  73.00  ,  346.15  },
				{  165.20  ,  74.00  ,  347.15  },
				{  167.00  ,  75.00  ,  348.15  },
				{  168.80  ,  76.00  ,  349.15  },
				{  170.60  ,  77.00  ,  350.15  },
				{  172.40  ,  78.00  ,  351.15  },
				{  174.20  ,  79.00  ,  352.15  },
				{  176.00  ,  80.00  ,  353.15  },
				{  177.80  ,  81.00  ,  354.15  },
				{  179.60  ,  82.00  ,  355.15  },
				{  181.40  ,  83.00  ,  356.15  },
				{  183.20  ,  84.00  ,  357.15  },
				{  185.00  ,  85.00  ,  358.15  },
				{  186.80  ,  86.00  ,  359.15  },
				{  188.60  ,  87.00  ,  360.15  },
				{  190.40  ,  88.00  ,  361.15  },
				{  192.20  ,  89.00  ,  362.15  },
				{  194.00  ,  90.00  ,  363.15  },
				{  195.80  ,  91.00  ,  364.15  },
				{  197.60  ,  92.00  ,  365.15  },
				{  199.40  ,  93.00  ,  366.15  },
				{  201.20  ,  94.00  ,  367.15  },
				{  203.00  ,  95.00  ,  368.15  },
				{  204.80  ,  96.00  ,  369.15  },
				{  206.60  ,  97.00  ,  370.15  },
				{  208.40  ,  98.00  ,  371.15  },
				{  210.20  ,  99.00  ,  372.15  },
				{  212.00  ,  100.00  ,  373.15  }};
        //end initialization and instatiation
        
        System.out.printf("%50s \n", "TESTING TABLE");
        System.out.println("====================================================================================================");//100 '='
        for(int i = 1; i <= 100; i++)
            System.out.print("=");
        System.out.printf("%n%15s %15s %15s %15s %15s %15s", "Predicted" + temp.DEGREE + "F" ,temp.DEGREE + "F", "Predicted" + temp.DEGREE + "C" ,temp.DEGREE + "C","Predicted" + temp.DEGREE + "K", temp.DEGREE + "K");//lists out the values predicted with the values from the driver class
        //lables printed on screen
        //populated 2D arrays with the predicted values printed to screen
        for(int i = 0; i < 100; i++)
            System.out.printf("%n%15.2f %15.2f %15.2f %15.2f %15.2f %15.2f", predicted[i][0], calculatedValues[i][0], predicted[i][1], calculatedValues[i][1], predicted [i][2], calculatedValues[i][2] );
        
        
    }//end method reportTest
    
    //driver #1
    /**
     * Driver - tests cases for each of the object method
     * verbose driver
     * @param temp
     * @param lowerLim
     * @param upperLim 
     */
    static void driver( Temperature temp ,double lowerLim, double upperLim ){//driver method
        
        for(double i = lowerLim; i < upperLim; i++){//will loop incrementing by 1
            double fahren = ( 32.0 + (i * (5.0/9.0)));//local loop variable to calculate fahren to confim
            System.out.println("sets celsius to " + i);
            temp.setCelsius(i);
            System.out.printf("%s %.2f" + temp.DEGREE + "C is %.2f " + temp.DEGREE + "C %n","The value in Celsius of " , i , temp.celsius());
            System.out.printf("%s %.2f" + temp.DEGREE + "C is %.2f " + temp.DEGREE + "K %n","The value in Kelvin of " , i , temp.kelvin());
            System.out.printf("%s %.2f" + temp.DEGREE + "C is %.2f " + temp.DEGREE + "F %n","The value in Fahrenehit of " , i , temp.getFahrenheit());
            //pause.nextLine();//pause for debugging
        }//end for
        System.out.println();//blank line for visibility
        for(double i = lowerLim; i < upperLim; i++){//will loop incrementing by 1
            double fahren = ( 32.0 + (i * (5.0/9.0)));//local loop variable to calculate fahren to confim
            //temp.setCelsius(i);
            System.out.println("sets kelvin to " + i);
            temp.setKelvin(i);//this is redudent but done for recursion and testing purposes
            System.out.printf("%s %.2f" + temp.DEGREE + "K is %.2f " + temp.DEGREE + "C %n","The value in Celsius of " , i , temp.celsius());
            System.out.printf("%s %.2f" + temp.DEGREE + "K is %.2f " + temp.DEGREE + "K %n","The value in Kelvin of " , i , temp.kelvin());
            System.out.printf("%s %.2f" + temp.DEGREE + "K is %.2f " + temp.DEGREE + "F %n","The value in Fahrenehit of " , i , temp.getFahrenheit());
            //.nextLine();//pause for debugging
        }//end for
        System.out.println();//blank line for visibility
        for(double i = lowerLim; i < upperLim; i++){//will loop incrementing by 1
            double fahren = ( 32.0 + (i * (5.0/9.0)));//local loop variable to calculate fahren to confim
            //temp.setCelsius(i);
            System.out.println("sets fahrenheit to " + i);//blank line for visibility
            temp.setFahrenheit(i);//this is redudent but done for recursion and testing purposes
            System.out.printf("%s %.2f" + temp.DEGREE + "F is %.2f " + temp.DEGREE + "C %n","The value in Celsius of " , i , temp.celsius());
            System.out.printf("%s %.2f" + temp.DEGREE + "F is %.2f " + temp.DEGREE + "K %n","The value in Kelvin of " , i , temp.kelvin());
            System.out.printf("%s %.2f" + temp.DEGREE + "F is %.2f " + temp.DEGREE + "F %n","The value in Fahrenehit of " , i , temp.getFahrenheit());
            
           //pause.nextLine();//pause for debugging
        }//end for
        
    }//end overloaded driver
    
    //driver #2
    /**
     * Driver method, if no parameters are set, will test values from 0 to 100 degrees celsius
     * takes a Temperature class object to be used within the loop
     * verbose driver
     * @param temp
     */
    static void driver(Temperature temp){//overloaded driver
        //local variable declarations
        double lowerLim = 0;
        double upperLim = 100;
        //end local varaible declarations
        //used local variable by the same name as the overloaded parameters in order to allow reusability of code
        driver(temp, 0, 100);//passes to driver 1

    }//overloaded method driver
    
    //driver#3
    /**
     * driver to populate the array passed to it
     * @param temp
     * @return 
     */
    static double[][] driver(Temperature temp[]){
        //System.out.println(temp.length);//debugging
        double[][] calculatedValues = new double[temp.length][3];// calculatedValues;
        for(int i = 0; i < calculatedValues.length; i++ ){
            temp[i].setCelsius(i);
            calculatedValues[i][0] = temp[i].getFahrenheit();
            calculatedValues[i][1] = temp[i].celsius();
            calculatedValues[i][2] = temp[i].kelvin();
            //System.out.println(calculatedValues[i][0] + "\n" + calculatedValues[i][1] + "\n" + calculatedValues[i][2]);//debugging
            //System.out.println();
        }//end for
        return calculatedValues;
    }//end overloaded driver
    
    
    //driver #4
     /**
     * Overloaded driver method
     * takes no parameter
     */
    static void driver(){//takes no parameters //dependent on driver(Temperature, double, double)
        //instatiates class object
        Temperature temp = new Temperature();//initializes with the default constructor
        double lowerLim = 0;
        double upperLim = 100;
        //end instatiation
        
        //
        driver(temp, lowerLim, upperLim);//calls overlaoded version itself
    
    }//end overlaoded variable
    
    //driver #5
    /**
     * An overloaded method of the driver that creates an object if one hasn't been provided and returns an array of type double
     * @param count
     * @return array of class Temperature objects
     */
    static double[][] driver(int count){//driver that returns a Class object array  //dependent on driver(Temperature)
        //instatiation and initialization
        Temperature[] temp = new Temperature[count];//creates array of type Temperature with the size of count
        for(int i = 0; i < count; i++)//loop to populate the array with type Temperature objects
            temp[i] = new Temperature();//initializes with the default constructor
        //end instatiation and initialization
        return driver(temp);
    }//end driver
    
    
    /**
     * Homework Header - takes a string and prints out homework header to the screen
     * @param title 
     */
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
        //initialization
        int count = 100;//creates count variable and sets it to 5, can be changed later, to test out the Temperature array driver
        boolean cont = true;//boolean to run loop while the user wants to continue to input values
        String answer = "";//the variable that is loaded for the answer to the users query below
        //end initialization
        //instatiation of objects
        Temperature temp = new Temperature();//sets the temperature of temp to be 78 degrees initially
        Scanner input = new Scanner( System.in );
        //end instatiation
        homeworkHeader(" Assign 08 - Temperature Class");//calls homework header method
        
        //tests out the DEGREE variable within the Temperature class
        //System.out.println( temp.DEGREE + "C");//prints out degree symbol
        //Temperature tempArr[] = driver(count); //passes the pointer reference of the returned array to tempArr //giving warning "unbalanced read/write for arrays"
        
        //creates table of printed test cases and calculated values
        reportTest(temp, driver(count));
        
        System.out.println();//blank line for visibility
        //asks uses to input values to convert
        do{
            System.out.println();                  //blank line for visibility
            System.out.println("Please input the value in farenheit to test");
            temp.setFahrenheit( input.nextDouble() );
            System.out.println("converted to celsius " + temp.celsius() + " \nConverted to kelvin " + temp.kelvin());
            System.out.println();                  //blank line for visibility
            System.out.println("Please input the value in Celsius to test");
            temp.setCelsius( input.nextDouble() );
            System.out.println("converted to fahrenheit " + temp.getFahrenheit() + " \nConverted to kelvin " + temp.kelvin());
            System.out.println();                  //blank line for visibility
            System.out.println("Please input the value in Kelvin to test");
            temp.setKelvin( input.nextDouble() );
            System.out.println("converted to fahrenheit " + temp.getFahrenheit() + " \nConverted to celsius " + temp.celsius());
            System.out.println();//blank line for visibility
            System.out.println("Do you want to enter more values ?");
            System.out.println("(y : yes or n : no): ");
            answer = input.nextLine();
            System.out.println(answer);
            answer = input.nextLine();
            cont = (answer.toLowerCase().equals("y") || answer.toLowerCase().equals("yes"));
        }while( cont );//loops aslong as the user wants to continue
        
        //(redudent because of testing table, but here for show and documentation)
        //test cases
        //need 3 test cases for the class, with 3 results each //my class needs 5 because I added an additional constructor ( this is tested in the program above )
        //testing: setFahrenheit, getFahrenheit, setKelvin, setCelsius, celsius, kelvin
        //(aditional test case needed for default constructor)
        
        double test1 = 0;
        double test2 = 32;
        double test3 = 100;
        System.out.println("Test Cases: 4");//4 test cases
        //when celsius is 0 fahrenheit should be 32, and kelvin should be 273.15
        Temperature testTemp = new Temperature(test2);//sets temperature of testTemp fahrenheit to be 32
        System.out.println(testTemp.getFahrenheit() + testTemp.DEGREE + "F ," + testTemp.celsius() + testTemp.DEGREE +"C ," + testTemp.kelvin() + testTemp.DEGREE +"K ,");//should produce 32.0, 0, 273.15
        testTemp.setCelsius(test1);//sets celsius to 0
        System.out.println(testTemp.getFahrenheit() + testTemp.DEGREE + "F ," + testTemp.celsius() + testTemp.DEGREE +"C ," + testTemp.kelvin() + testTemp.DEGREE +"K ,");//should output 32.0 , 0.0 , 273.15
        testTemp.setKelvin(test1);//sets kelvin to 0
        System.out.println(testTemp.getFahrenheit() + testTemp.DEGREE + "F ," + testTemp.celsius() + testTemp.DEGREE +"C ," + testTemp.kelvin() + testTemp.DEGREE +"K ,");//should output -459.67, -273.15, 0
        testTemp.setFahrenheit(test3);//sets fahrenheit to 100
        System.out.println(testTemp.getFahrenheit() + testTemp.DEGREE + "F ," + testTemp.celsius() + testTemp.DEGREE +"C ," + testTemp.kelvin() + testTemp.DEGREE +"K ,");//should output 100.0, 37.778, 310.928
        
        System.out.println();//blank line for visibility

        System.out.println("This testing is called from a method:");
        driver(testTemp, 0, 5);//bounds are 0, 5, will produce all degrees between 0 and 5 for each
        
        System.out.println();//blank line for visibility
        
        System.out.println("BYE");
        
        input.close();//closes scanner instance
        //pause.close();//closes global scanner instance
    }//end main
    
}//end main class


/*
* DISCUSSION QUESTIONS:
* 
* How many data items are private and hidden inside the class?
*   only one data item within the class is private/hidden. The class is made public but the value within it, ftemp is private
*   This is in order to require the use of modifiers and accessor methods to change or view the value of ftemp
*   
* Do you have 1, 2 or 3 data items in the class?   
* Why did you implement that way ?
*   I have 2 data items in the class. One is of string type and one is of double type.
*   The string is a value holding the symbol for degrees so it may be used in output
*   The double is the variable ftemp which is changed by the setters of the class
*
* How many test cases are need and why?
*   4 test cases are need because they need to test every method in which data is set to the class. 
*   Becuase there are 3 setter method and the default constructor which set values to ftemp within the class object, 4 test cases are needed
*   In my case 5 are needed because I also created an additional constructor that takes no parameters.
*   Each of these test cases will produce 3 results, one for celsius, one for fahreneheit, and one for kelvin

* Did you exercise all the lines of code in the class?
*   I excercise all the lines within the Temperature class, however I don't excersize all lines of code within the Assign08 class because some
*   are too verbose and clutter up the output. I provide 4 overloaded drivers which test out the output and produce the results in different ways.
*   Driver #1: takes 3 parameters, and loops through the values of the last two parameters, taking 3 turns loading the value into the object as fahreneheit, as celsius, and as kelvin
*   Driver #2: the same as driver 1 however only takes in the temperature object. loops until 100 producing 900 values (testcases). It does this by passing it to driver #1 with the limits of [0,100)
*   Driver #3: takes in a temperature array and returns a 2d double array of the results
*   Driver #4: takes no parameters, creates an object of the temperature class ( with default constructor, setting the ftemp by default to 75 ) and passes that object to driver #1
*   Driver #5: takes in a size for an array that it creates of object temp and passes that array to driver 3 which returns a 2d array of the output
*/



//statement of completion:

//Describe what portions of the assignment are done and complete.

/////To the best of my knowledge all parts of the assignment are done and complete. I didn't like how the constructor for the temperature class required a parameter,
////Which I think works in individual cases when the temperature won't be changed right away. However for the testing and mass use of the prodcution of objects, with the understanding of
////testing in mind, I created another constructor which doesn't require any parameters and sets the temperature by default to 75 degrees fahrenheit.

//What is missing? What caused the incompleteness.

////To the best of my knowledge nothing is missing. I provided a little less verbose comments in this program because I believe it's logical flow isn't very complex.
////I know I jump around a bit between methods instead of all the methods having a flow from one to the next. This could be imporved upon. The other issue was submission timing, and I apologize about the delay.
////I feel like I am lacking a bit in the comments as well, especially in concern of the algorithms needed used for each section. I can attribute this issue to changing how I wanted to write my code in the middle.

//How do you feel about the assignment or what did you learn while doing it?

////I feel good about the assignment, I learned how to use 2D arrays ( as well as return them from methods ) and improved on creating and using methods.
///Due to all the outsourced code to methods, debugging required alot of hand tracing and was very streneous 