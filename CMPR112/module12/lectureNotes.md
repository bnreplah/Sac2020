 Lecture notes 
---

**date: November 18th, 2020 lecture** 

computers don't have a concept of time, they use edxternal function calls to deal with time...

### A little bit of homework review ###


```java

/*
* Java code 
*
*/

import java.util.Scanner;


public class Lecture13Code{

    public static void main(Stringp[ ] args){
        double planetDistanceFromSun[] = {123, 345, 455,643, 456,543,345,343,231};
        //initiailize distances arrays

        String planetNames [] = {"mercury", "venus", "earth", "mars", "jupiter", "saturn", "uranus", "neptune", "pluto"};

        //use the parallel arrays above in order to itterate through both

        for(int i = 0; i < pleantNames.length; i ++){
            displayPlanetDistance(planetDistanceFromSun[i],planetNames[i]);// this works

            //but an easier way may be to create a class called planets holding all the information of all planets

            //note: this lecture was covered before, the instructor is going over stuff again, possibly from a different angle.


        }//end for
```

### alternative : ###


Create a class which can hold planet objects, each object holds two things the planet name and distance
```java
    Planet allPlanets[] = {new Planet("name", distance)};
```
this will hold all the plantes in the array being of type planet. 

last time he used this code to create a class which held all the data in instead. 

this is `object oriented programming`

...


moved to talking about html, likely related to the code I wrote to fetch and search for the divisions in the code.

...

    goes into an aside about why plutonium was named:
        - named after the planet


In tic tac toe, you should have put the display numbers to 1-9 because non-programmers may be confused by why 0 is present

challenge:

given the function, given a 2d tic tac toe board and given a token
```java

public static boolean checkForWinDiag(char board[][], char token){
    //write using a single for loop to check if there is a win in either diagonal
    
    int winCounter01 = 0, winCounter02 = 0

    //loop:
    for(int i = 0; i < board[0].length; i++){
        if(board[i][i] == token)
            winCounter01++;
        if(board[i][((board[0].length -1) -i)] == token)
            winCounter02++;
    }//end for loop


}//end 
```
alternative solution
```java
public static boolean checkForWinDiag(char board[][], char token){
    //write using a single for loop to check if there is a win in either diagonal
    
    boolean threeInRow01 = true;
    boolean threeInRow01 = true;

    //loop:
    for(int i = 0; i < board[0].length; i++){
        if(board[i][i] != token)
            threeInRow01 = false;
        if(board[i][((board[0].length -1) -i)] != token)
            threeInRow02 = false;
    }//end for loop

    return threeInRow01 || threeInRow02;

}//end 
```


```java
import java.util.Scanner;
```
in main:
```java
Scanner scanKey = new Scanner( System.in );

```
this creates a Scanner object
java creates objects at run time and allocated the memory at runtime

the `new` means create an object of this kinda and allocate memory for it.
Think of it lke a data type.

Runtime class
--- 

```java
Runtime runtime = Runtime.getRuntime();
```
this creates a varaible allocation of getRuntime() from the Runtime class.

note `new` is not present in this command, because it doesn't need to instatiate the object, since the object is likely already instatiated by the jvm. ( needs confirming and testing )

The whole point of these instantiations were to test garbage collection:
---
garbage collection attempts to combine bytes that are similiar in order to save space. It will start and run in the background and collect deallocated data types to open up space.

```java
runtime.gc();
System.gc();
```
both of these method calls will tell the system to start garbage collector when it has a chance

intersting thing: memory has a nursery/newsest section of memory where the newest objects are created

in the program, he has the free memory displayed in order to possibly see a difference in memory before and after the `gc()` call.


 If we wanted to run the garbage collector every 100th instance of an object? 
--- 

```java
for(int i = 1; i <= 10000; i++){
    Bank b = new Bank();
    if(i % 100 == 0){
        runtime.gc();
    }//initializes garbage collector every 100 bank objects



}
```

## Enums ##
- enums in java are virtually identical to those in c++
- in the book `pg. 531`
### concept ###
~~~ 
An enumerated data type consists of a set of predefined values. You can use the data type to create varaibles that can hold only the values that belong to the enumerated data type.
~~~

```java
enum Day { SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY};
//enum should be global/ can be global
```

implementation:
```java

Day DayOfWeek;//creates enum type object
public bank(){

    DayOfWeek = Day.MONDAY;
}

```
This is good because it allows easy managability of options, and allows programs to be implemented with others.

Another example:
```java
enum stateMachine {INIT, STARTBUTTON, CLOSEDOOR, SHOOTLASER, OPEN DOOR, ALERTOPERATOR};
```

this is alot better code than constantly passing variables for enums and instead limits the possible options that can be used.

### back to garbage collection and classes ###
 -`finalize()` method is called when an object is being dereferenced

 so when the garbage collector is running and when it collects the data from the dereferenced variable, the finalize method is called if it is present

In the question 
### | Questions:
- what if you had the finalize object print out the time
and then you had the call of the garbage collector also print out the time to see the comparison of when it is called and when it is collected

 - and it still had memory, didn't get a out of memory error...
 - do you think that it is called automatically at a certain amount of memory free?

- In which way does the garbage collector it's garbage

-- There is a section in chapter 8 abot garbage collection as well -- 

```java
public static void main(string[] args){

    final int ROWMAX = 8;
    final int COLMAX = 13;

    int board[][] = new int[ROWMAX][COLMAX];

    for(int row = 0; row < ROWMAX; row++){
        for(int col = 0; col< COLMAX; col++){
            board[row][col] = row*100 + col;
        }

        for (int row = 0; row < ROWMAX; row++ ){
            System.out.println(board[row][col]);


        }//end for
    }//end for


}//end public main
```

output:
```

```

The book suggests following these nanes `matrix` as an exmple

```
int matrix[][][] = new int [3][6][12];
```
Here is an example for 3d arrays

uses for two dimensial arrays 

( and 3d dependign on the problem ):
    
    - linear algebra
    - data science
    - cargo problems
    - etc

sorting/ guessing algorithm 
(he's done this game before)

using a technique he can guess the number in 7 guesses or less:

- splits the search field in half and guess low, and see if too low or too high
- then split the next half again
 - and again, and keep splittign until you discover the value.


## Binary search: ##
also see the code the professor posts on canvas

```java

Random rand = new Random();// requires import java.util.Random
int sortedInts[] = new int[32];
for(int i = 0; i < 32; i++){
    
    sortedInts[i] = sortedInts[i-1] + Math.abs((rand.nextInt() % 5));

}//end for

//to see the list
for(int i = 0; i < 32; i++){
    System.out.print (sortedInts [i - 1] + " " );


}//end for

//professor's code:

// find 132
int target = 132;
int low = 0;
int hi = 31;
int mid = 0;
for ( int i = 1 ; i < 32; i ++ )
{
mid = (low+hi )/ 2;
if ( target == sortedInts[mid] ) {System.out.println ( " Found it at postiion mid = " + mid );break;}
if ( target > sortedInts[mid] )
{
low = mid;
System.out.println ( " low is now " + low );
}
if ( target < sortedInts[mid] )
{
hi = mid;
System.out.println ( " hi is now " + hi );

}
if ( hi == low || hi == ( low +1 )){
System.out.println ( " target not found. Closest postition = " + low);
break;
}


}

```

moves into talking about `monte carlo simulation`

~~~http
 https://www.investopedia.com/terms/m/montecarlosimulation.asp
~~~

```md
## What Is a Monte Carlo Simulation? ##
Monte Carlo simulations are used to model the probability of different outcomes in a process that cannot easily be predicted due to the intervention of random variables. It is a technique used to understand the impact of risk and uncertainty in prediction and forecasting models.

A Monte Carlo simulation can be used to tackle a range of problems in virtually every field such as finance, engineering, supply chain, and science. It is also referred to as a multiple probability simulation.

## KEY TAKEAWAYS ##
A Monte Carlo simulation is a model used to predict the probability of different outcomes when the intervention of random variables is present.
Monte Carlo simulations help to explain the impact of risk and uncertainty in prediction and forecasting models.

A variety of fields utilize Monte Carlo simulations, including finance, engineering, supply chain, and science.

The basis of a Monte Carlo simulation involves assigning multiple values to an uncertain variable to achieve multiple results and then to average the results to obtain an estimate.

Monte Carlo simulations assume perfectly efficient markets.
```

look up use cases and examples of `monte carlo prediction`:

```

```

### hint on how to find the lowest or highest in the array:

```
 - break it up into two parts
    - need a minimum to begin with
 - then go through the whole array and see if its minimum
    - stick it in a value called min
    - if there is an element less than minimum, that goes in the min value.
```

### best way to test a random number generator ###
use it in a poker game, after a couple rounds and a couple hands you see a pattern if present
 