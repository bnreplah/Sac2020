/*


Ticket : 86713
Course : CMPR 112
Student : Ben Halpern
Instructor : Professor Kirscher
Environment: Win 10 NetBeans
Project Title : Assign 07 - Classes


#######################################################
Assignment detials:
#######################################################
Create two classes.   

Class one is a rectangle class.   store length and width.    Please use ints for this class
We need two constructors.   One with no parameters.  You decide what to set into the variables. 
A second constructor where the user can specify the length and width. 
Setter and getter functions. for length and width 
also a getter to get the area of the rectangle. 
and a getter to get the perimeter ( 2 * length + 2 * width)
 
A second class for a circle.   Please use doubles in this class:
We need two constructors.   One with no parameters.  You decide what to set into the variables. 
A second constructor that specifies the radius. 
a setter and getter for the radius.   
a getter for the diameter
a getter for the circumference
a getter for the area of the circle. 

 */

package module07;
import java.util.Scanner;
import java.lang.Math;
//compiler is saying that java.lang is imported by default

/**
 *
 * @author BenHalpern
 */

public class Assign07 {
    
    public static class Rectangle{
        private int length;//private global variables, need getter and setter to manipulate and access
        private int width;//private global variables, need getter and setter to manipulate and access
        //note the containing class ( parent class has access to these variables because of inheritance )
        //https://stackoverflow.com/questions/5770575/can-an-outer-class-access-the-members-of-inner-class/5770619#:~:text=the%20outer%20class.-,Can%20inner%20class%20access%20members%20of%20outer%20class%3F,as%20any%20instance%20method%20can.&text=%22A%20nested%20class%20is%20a,to%20serve%20its%20enclosing%20class.
        //see above for an example
        
        /*
        * @params no parameters; is constructor with no parameters
        */
        public Rectangle(){//constructor for rectangle class, takes no parameters, sets the global variables to 2, 3 respectively
           
            this.length = 2;//sets the initial length to 2 
            this.width = 3;//sets the initial width to 3
        }//end constructor //default constructor
        
        /*
        * @params 2 parameters; integer values for length, and integer values for width
        */
        public Rectangle( int w, int l ){//overloaded constructor, takes 2 int parameters, where w is the width , and l is the length
            
            this.length = l;
            this.width = w;
            //length = l;
            //width = w;
        }//end overloaded constructor
        
        //public rectangle(int width, int length){//overloaded constructor
        //    this.length = length;
        //    this.width = width;
        //}//end overloaded constructor
        
        //Setter and getter functions. for length and width 
        
        /*
        * @params 1 parameter; integer value for the length to be set
        */
        public void setLength( int len ){//setter method, sets the internal global variable of length to int len
            
            this.length = len;
            //length = len;
        }//end setLength
        
        /*
        * @params 1 parameters; integer value for the width to be set
        */
        public void setWidth( int wid ){//setter method, sets the internal global variable of width to int wid
            
            this.width = wid;
            //width = wid;
        }//end setWidth
        
        /*
        * @params no parameters; is a getter method with no parameters, returns the width
        */
        public int getWidth(){//getter method, returns the value of the width
            
            return this.width;
        }//end getWidth
        
        /*
        * @params no parameters; is getter method with no parameters, returns the length
        */
        public int getLength(){//getter method, returns the value of the length
            
            return this.length;
        }//end getLength
        
        //getter to get the area of the rectangle. 
        
        /*
        * @params no parameters; is getter method for the area of the rectangle, returns the length; Area = base * height || length * width
        *   Algorithm: Area of a rectangle is equal to the base times the height or the length times the width
        *       A = l*w
        */
        public int getArea(){//getter method, caluclates and returns the value of the area of the rectangle
            
            return (this.length * this.width);
            //return (length * width)
            //alternative:
            //int area = (length * width);
            //return area;
        }//end getArea
        
        //getter to get the perimeter ( 2 * length + 2 * width)
        
        /*
        * @params no parameters; is getter method for the perimeter of the rectangle, returns the perimeter; perimeter = 2 * base + 2* height || 2( length + width)
        *   Algorithm: perimeter of a rectangle is equal to the sum of all the sides of the rectangle
        *       P = 2*(l + w)
        */
        public int getPerimeter(){//getter method, calculates and returns the value of the perimeter of the rectangle
           
            return ( ( 2 * this.length ) + (2 * this.width ) );
            //return (( 2 * length ) + (2 * width ));
            
            //alternative:
            //int perim = (( 2 * length ) + (2 * width ));
            //return perim;
            //or 
            //return (2 * (length + width));
        }//end getPerimeter
        
    //end of class Rectangle methods    
        
    }//end class Rectangle
    
    
    
    public static class Circle{
        //global variable instatiation 
        private double radius; //private double global variable radius
        //end global varaible instatiation
        
        //two constructors:
        
        /*
        * @params no parameters; is constructor with no parameters
        */
        public Circle(){
            //generally sets default internal variables
            radius = 1.0;
        }//end constructor //default constructor
        
        /*
        * @params 1 parameters; double values for radius
        */
        public Circle(double rad){//overloaded constructor takes parameter rad, initializes gloabal variable radius with parameter double rad
            this.radius = rad;
            //radius = rad;//since the name of the parameter is different
            
        }//end overloaded constructor
        
        //setter and getter for the radius
        
        /*
        * @params no parameters; is getter method with no parameters, returns the radius
        */
        public double getRadius(){//getter method, return the radius
            
            return this.radius;
            //return radius;
        }//end getRadius
        
        /*
        * @params 1 parameters; is setter method with 1 parameter, sets the radius of the circle
        */
        public void setRadius(double rad){//setter method, sets the global varible radius with the parameter double rad

            this.radius = rad;
            //radius = rad;
            
            //this.radius = radius;
            //^requires this. modifier because the name of the parameter and the variable are the same            
        }//end setRadius
        
        //getter for the diameter:
        
        /*
        * @params no parameters; is getter method with no parameters, returns the diameter of the circle; diameter = 2(radius)
        *   Algorithm: Diameter of the circle is the radius times 2
        *       d = 2r
        */
        public double getDiameter(){//getter method, returns the diameter of the circle based of the values of radius
            
            return (this.radius * 2);
            //retrun radius * 2;
            //alteranative:
            //double diameter = ( radius * 2 );
            //return diameter;
        }//end getDiameter
        
         /*
        * @params 1 parameter; is setter method with 1 parameters; diameter = 2(radius) .: radius = diameter / 2
        *   Algorithm: Radius of the circle is the diameter divided by 2
        *       r = d/2
        */
        public void setDiameter(double diameter){//setter method, calculates the radius from the diameter and sets it to the global radius, uses setRadius
        
            //use of abstraction
            setRadius((diameter / 2.0));
            //alternative:
            //this.radius = diameter / 2;
        }//end setDiameter
        
        //getter for the circumference:

        /*
        * @params no parameters; is getter method with no parameters, returns the circumference of the circle;  = 2pi(radius)
        *   Algorithm: Circumference of the circle is pi times the radius times 2
        *       C = 2PIr
        */
        public double getCircumference(){//getter method, calculates and returns the circumference
            
            return Math.PI * 2 * this.radius;
            //return Math.PI * 2 * radius;
            //alternative:
            //double circumference = (Math.PI * 2 * radius);
            //return circumference;
        }//end get Circumference
        
        //getter for the area of the circle:
        
        /*
        * @params no parameters; is getter method with no parameters, returns the area of the circle; Area = pi(radius ^2)
        *   Algorithm: Area of the circle is pi times the radius squared
        *       A = PI*r^2
        */
        public double getArea(){//getter method, returns the area of the circle using the radius and pi
            
            return ( Math.pow(this.radius, 2)* Math.PI) ;//returns the area of the circle
            //return ((this.radius * this.radius)* Math.PI);
            //return ( Math.pow(radius, 2)* Math.PI) ;
            //alternative:
            //double area = ( Math.pow(this.radius, 2)* Math.PI);
            //return area;            
        }//end getArea
        
        
        //end of methods in class Circle
        
    }//end class Circle
    
    /*
    * @params no parameters; prints out to screen
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
    public static void main(String[] args) {// main body of the program, driver of the classes
        
        //instatiation and initialization of variables
        Scanner input = new Scanner( System.in );
        //for circle
        double radius = 3;//will get implicitly converted to 3.0
        double diameter = 15;//will get implicitly converted to 15.0
        double circumference = 0; //to be reassigned
        double areaOfCircle = 0; //to be reassigned
        //for rectangle
        int length = 5;
        int width = 30;
        int areaOfRectangle = 0; //to be reassigned
        int perimeter = 0; //to be reassigned
        //instatiation of class objects
        //circle objects
        Circle circ01 = new Circle(); //default constructor, assigning radius to 1.0
        Circle circ02 = new Circle(radius);//overloaded contructor, assigning radius to 3.0
        //rectangle object
        Rectangle rect01 = new Rectangle();//default constructor, assigns rect01 length to 2 and width to 3
        Rectangle rect02 = new Rectangle(length, width);//overloaded constructor, assigns the rect02 the length of 5 and the width of 30
        //instatiation of circle
        //end instatiation
        
        //output
        //report of information from both objects.
        //uses all methods except for the setter methods. ( that can be done in the menu below )
        
        //start homeworkHeader
        homeworkHeader("Assign 07 - Classes");//calls the homework header method and prints to screen
        //end homeworkHeader
        
        System.out.println();//blank line for visibility
        System.out.println("We have created rectangle objects, and also have created two circle objects");
        System.out.println();//blank line for visibility
        System.out.println("The information about the first rectangle:");
        System.out.printf("%42s %-10d units%n","Length: ", rect01.getLength());
        System.out.printf("%42s %-10d units%n","Width: ", rect01.getWidth());
        System.out.printf("%42s %-10d units%n","Perimeter: ", rect01.getPerimeter());
        System.out.printf("%42s %-10d units^2%n","Area: ", rect01.getArea());
        System.out.println();//blank line for visibility
        System.out.println("The information about the second rectangle:");
        System.out.printf("%42s %-10d units%n","Length: ", rect02.getLength());
        System.out.printf("%42s %-10d units%n","Width: ", rect02.getWidth());
        System.out.printf("%42s %-10d units%n","Perimeter: ", rect02.getPerimeter());
        System.out.printf("%42s %-10d units^2%n","Area: ", rect02.getArea());
        //for the circle
        System.out.println();//blank line for visibility
        System.out.println("The information about the first circle:");
        System.out.printf("%42s %-10.2f units%n","Radius: ", circ01.getRadius());
        System.out.printf("%42s %-10.2f units%n","Diameter: ", circ01.getDiameter());
        System.out.printf("%42s %-10.2f units%n","Circumference: ", circ01.getCircumference());
        System.out.printf("%42s %-10.2f units^2%n","Area: ", circ01.getArea());
        System.out.println();//blank line for visibility
        System.out.println("The information about the second circle:");
        System.out.printf("%42s %-10.2f units%n","Radius: ", circ02.getRadius());
        System.out.printf("%42s %-10.2f units%n","Diameter: ", circ02.getDiameter());
        System.out.printf("%42s %-10.2f units%n","Circumference: ", circ02.getCircumference());
        System.out.printf("%42s %-10.2f units^2%n","Area: ", circ02.getArea());   
        System.out.println();//blank line for visibility
        System.out.println();//blank line for visibility
        System.out.println();//blank line for visibility
        
        while(true){//loops until user requests to exit
            
            int num = 0;//local variable within the loop, user decides which object number they want to modify
            int choice = 0; //local variable only within loop
            //displays menu with options
            //uses prinf to format the menu
            
            System.out.println("What would you like to do:");
            System.out.println("================== Menu ===================");
            //circle access
            System.out.printf("%45s%n"," Circles ");
            System.out.printf("%45s%n"," Radii: ");
            System.out.printf("%-45s%n"," 1 - set the Radius of the Circle ");
            System.out.printf("%-45s%n"," 2 - get the Radius of the Circle ");
            System.out.printf("%45s%n"," Diameters: ");
            System.out.printf("%-45s%n"," 3 - set the Diameter of the Circle ");
            System.out.printf("%-45s%n"," 4 - get the Diameter of the Circle ");
            System.out.printf("%45s%n"," Area: ");
            System.out.printf("%-45s%n"," 5 - get the Area of the Circle ");
            System.out.printf("%45s%n"," Circumference: ");
            System.out.printf("%-45s%n"," 6 - get the Circumference of the Circle");
            
            System.out.println();//blank line for visibility
            //rectangle access
            System.out.printf("%45s%n"," Rectangles ");
            System.out.printf("%45s%n"," Length: ");
            System.out.printf("%-45s%n"," 7 - set the Length of the Rectangle ");
            System.out.printf("%-45s%n"," 8 - get the Length of the Rectangle ");
            System.out.printf("%45s%n"," Width: ");
            System.out.printf("%-45s%n"," 9 - set the Width of the Rectangle ");
            System.out.printf("%-45s%n"," 10 - get the Width of the Rectangle ");
            System.out.printf("%45s%n"," Area: ");
            System.out.printf("%-45s%n"," 11 - get the Area of the Rectangle ");
            System.out.printf("%45s%n"," Perimeter: ");
            System.out.printf("%-45s%n"," 12 - get the Perimeter of the Rectangle ");
            
            System.out.println();//blank line for visibility
            System.out.printf("%-45s%n"," 13 - to exit ");
            do{//do-while loop, loops based off of users input, if out of bounds of required inputs continues loop
                
                while(choice > 13 || choice < 1){//initially choice = 0; 
                    System.out.println("Please enter a value within the range of 1 and 13 ");       
                    System.out.println("Your Choice:");
                    choice = input.nextInt();
                    
                    if(choice == 13){//if the user wishes to exit, break out of loop and exit
                        break;
                    }//end if
                }//end while
                
                if(choice == 13){//if the user wishes to exit, break out of loop and exit
                        break;
                }//end if
                //if the user exited, it short circuits the next loop and to the end of the next loop, in which another conditional statment will check if they want to exit and exit the loop and the program
                
                while(!(num == 1 || num == 2 )){
                    System.out.println("Please enter a object number of 1 or 2");                                      
                    System.out.println("Which object number do you want your choice to apply to ( 1, 2):");
                    num = input.nextInt();
                    System.out.println(num);//debugging
                }//end while
                
            }while(!(choice <= 13 && choice >= 1) && !(num == 1 || num == 2 ));//if both inner conditions are true, then exit loop
            if(choice == 13)//if user wishes to exit
                break;
            //breaks out of the outer loop and exits the program
            
            //could have used printf for the menu responses, however wanted to see full decimal places
            else if(num == 1){//if the user wants to access object numbers 01
                
                //switch acomplishing the actions of the user accessing object number 1 ( circ01, and rect01 )
                switch(choice){
                    case(1)://set radius
                        System.out.println("\nPlease input the desired Radius for Circle " + num);//set the value after "Circle " to be the object number they would like to access
                        circ01.setRadius(input.nextDouble());
                        break;
                    case(2)://get radius
                        System.out.println("\nThe Radius of Circle " + num + " is " + circ01.getRadius());
                        //circ01.getRadius();
                        break;
                    case(3)://set diameter
                        System.out.println("\nPlease input the desired Diameter for Circle " + num );
                        circ01.setDiameter(input.nextDouble());
                        break;
                    case(4)://get diameter
                        System.out.println("\nThe Diameter of Circle " + num + " is " + circ01.getDiameter());
                        break;
                    case(5)://get area
                        System.out.println("\nThe Area of Circle " + num + " is " + circ01.getArea());
                        break;
                    case(6)://get circumference
                        System.out.println("\nThe Circumference of Circle " + num + " is " + circ01.getCircumference());
                        break;
                    case(7)://set length
                        System.out.println("\nPlease input the desired Length for Rectangle " + num );
                        rect01.setLength(input.nextInt());
                        break;
                    case(8)://get length
                        System.out.println("\nThe Length of Rectangle " + num + " is " + rect01.getLength());
                        break;
                    case(9)://set width
                        System.out.println("\nPlease input the desired Width for Rectangle " + num );
                        rect01.setWidth(input.nextInt());
                        break;
                    case(10)://get width
                        System.out.println("\nThe Width of Rectangle " + num + " is " + rect01.getWidth());
                        break;
                    case(11)://get area
                        System.out.println("\nThe Area of Rectangle " + num + " is " + rect01.getArea());
                        break;
                    case(12)://get perimeter
                        System.out.println("\nThe Perimeter of Rectangle " + num + " is " + rect01.getPerimeter());
                        break;
                }//end switch
            }//end else if
            else if(num == 2){//if the user wants to access object number 02
                
                //switch acomplishing the actions of the user accessing object number 2 ( circ02, and rect02 )
                switch(choice){
                    case(1)://set radius
                        System.out.println("\nPlease input the desired Radius for Circle " + num );
                        circ02.setRadius(input.nextDouble());
                        break;
                    case(2)://get radius
                        System.out.println("\nThe Radius of Circle " + num + " is " + circ02.getRadius());
                        //circ02.getRadius();
                        break;
                    case(3)://set diameter
                        System.out.println("\nPlease input the desired Diameter for Circle " + num);
                        circ02.setDiameter(input.nextDouble());
                        break;
                    case(4)://get diameter
                        System.out.println("\nThe Diameter of Circle " + num + " is " + circ02.getDiameter());
                        break;
                    case(5)://get area
                        System.out.println("\nThe Area of Circle " + num + " is " + circ02.getArea());
                        break;
                    case(6)://get circumference
                        System.out.println("\nThe Circumference of Circle " + num + " is " + circ02.getCircumference());
                        break;
                    case(7)://set length
                        System.out.println("\nPlease input the desired Length for Rectangle " + num );
                        rect02.setLength(input.nextInt());
                        break;
                    case(8)://get length
                        System.out.println("\nThe Length of Rectangle " + num + " is " + rect02.getLength());
                        break;
                    case(9)://set width
                        System.out.println("\nPlease input the desired Width for Rectangle " + num );
                        rect02.setWidth(input.nextInt());
                        break;
                    case(10)://get width
                        System.out.println("\nThe Width of Rectangle " + num + " is " + rect02.getWidth());
                        break;
                    case(11)://get area
                        System.out.println("\nThe Area of Rectangle " + num + " is " + rect02.getArea());
                        break;
                    case(12)://get perimeter
                        System.out.println("\nThe Perimeter of Rectangle " + num + " is " + rect02.getPerimeter());
                        break;
                }//end switch
            }//end else if
            else//safety condition if breaks out of loop but other input was inputted
                break;
            
            //press any key to continue
            input.nextLine();//eats up whitespace \n
            System.out.println("Press ENTER to continue . . .");
            input.nextLine();
            
        }//end while
        
        System.out.println("BYE");
        input.close();//closes Scanner object
    }//end main

}//end class Assign07


//statement of completion:

//Describe what portions of the assignment are done and complete.

////I feel that all portions of the assignment are done and completed to the best of my knowledge.
////I created 2 classes, Circle and Rectangle, in which they are able to be instatiated and manipulated. Each have setter and getter functions for
////the required methods.
////circle: setter methods for: radius, diameter    getter methods for: area, circumference, diameter, radius
////rectangle: setter methods for: length, width    getter methods for: area, perimeter, length, width
////In the main method, of the Assign07 Class ( the outer class ), I created a driver which produces a report of the all of the objects, retrieving all their values
////Then I also provided a menu for the user to change and manipulate the values of the objec themselves. I used the Scanner class to instatiate a Scanner object,
////to request input from the user for this.
////I used a loop to allow the user to manipulate and read the objects until they choose to exit 
////In order to designate the task for each selection, I used a switch.

//What is missing? What caused the incompleteness.

////To the best of my knowledge nothing is missing. I provided a little less verbose comments in this program because I believe it's logical flow isn't very complex

//How do you feel about the assignment or what did you learn while doing it?

////I feel good about the assignment. Creating classes was fun and was fun to be able to instatiate the class objects and manipulate them. I am excited for
////all the various applications of this functionality. 