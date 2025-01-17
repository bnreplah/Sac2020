/**
*Ticket : 86713
*Course : CMPR 112
*Student : Ben Halpern
*Instructor : Professor Kirscher
*Environment: Win 10 NetBeans
*Project Title : Assignment 11 - Insertion Sort
*
*
*Assignment details:
* 
* 
* Create an ArrayList of Integers.   Add one by one each integer to an ArrayList.   Keeping all the integers in the ArrayList in sequence.  
*
*   Read from an array of At Least 10 integers.  
*
*   Do not hard code 10 anywhere in your program
*
*   int myIntegerData [ ] = { 11,55,22,88,33,66,11,99,0,123,166,77, 44,22,99};
*
*   I expect to see a function to insert a single int into the ArrayList 
*
*   Show the array list when you have input all the data.  
*
* 
*
*   Repeat the above instructions but use string and sort the strings.  
*
*   String myStringData [ ] = { "abc", "ydj", ide", "etc"};       // you need at least 10 strings   
*
* 
* 
* 
* 
* Notes:
* Things to do:
* x  - create sorting algorithm and methods
* x  - test the sorting algorithms and methods
*   - create a menu
*   - incorporate a possible GUI option 
*/


/**
 * A program which allows the user to enter values into an array list to be sorted either with an unsorted array or value by value
 * 
 * @author benha
 */


import java.util.ArrayList;
import java.util.Arrays;//used for checking that the sort was accurate
import java.util.Scanner;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Assignment11 extends JFrame {
    
    private JPanel iOPanel; // creates JPanel of input and output
    private JPanel iOPanel2;
//    private ArrayList<JLabel> intArrLabel = new ArrayList<JLabel>();//prompting inputting of data for the int array
    private ArrayList<JLabel> strLabels= new ArrayList<JLabel>();//prompting inputting of data for the string array
//    private ArrayList<JTextField> intTextArr = new ArrayList<JTextField>();//creates an array list for the array to be sorted
    private ArrayList<JTextField> strText = new ArrayList<JTextField>();//creates an array list for the array to be sorted ( string )
    private ArrayList<Integer> sortInt = new ArrayList<Integer>();
    private ArrayList<String> sortStr = new ArrayList<String>();
    private static final boolean DEBUG = false;
    
    
    private JLabel label; // Enter temp in appropriage box to convert

    private ArrayList<JLabel> intLabels = new ArrayList<JLabel>(); 

    private ArrayList<JTextField> intText = new ArrayList<JTextField>();

    
    /**
     * constructor assignment11
     * implementing swing methods
     */
    public Assignment11() {
    // Set the title
    
    
    setTitle("My Temperature Converter ");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    // Create a BorderLayout manager:
    setLayout(new BorderLayout());

    // Build the panels:
    buildInputOutputPanel();
    iOPanel.setPreferredSize(new Dimension(200,500));
    iOPanel.setMinimumSize(new Dimension(150,500));
    iOPanel2.setPreferredSize(new Dimension(200,500));
    iOPanel2.setMinimumSize(new Dimension(150,500));
    
    // Add the panels to the cntent pane:
    add(iOPanel, BorderLayout.WEST);
    add(iOPanel2, BorderLayout.EAST);
    //Pack and display the window:
    pack();
    setVisible(true);
    }

    private void buildInputOutputPanel() {
    // Creat a panel
    int[] numberToSort = {0 , 15, 85, 75, 45, 5, 92, 70, 1, 95};
    String[] strToSort = {"a","z","s","p","lol","m","r","f","r","totally"};
    iOPanel = new JPanel();
    iOPanel2 = new JPanel();

    // Create a label.
    label = new JLabel("Enter a a value to be sorted. ");

    iOPanel.add(label);
    for(int i = 0; i <= numberToSort.length; i++){
    intLabels.add(new JLabel(String.valueOf(i)));
    }//end for
    textListener tL = new textListener();
    for(int i = 0; i < intLabels.size(); i++){
        if(DEBUG)System.out.println("Adding text field to the array");
        intText.add(new JTextField(12));
        intText.get(i).setEditable(true);
        intText.get(i).addActionListener(tL);
        intText.get(i).setActionCommand("I"+i);
        if(DEBUG)System.out.println(i);
        if(!(i >= numberToSort.length))
            intText.get(i).setText(String.valueOf(numberToSort[i]));
        else
            intText.get(i).setText("");
 
    }
    //new JTextField(12);




    for(int i = 0; i < intLabels.size(); i++){
        if(DEBUG)System.out.println("Adding everything to the pane");
        iOPanel.add(intText.get(i));
        iOPanel.add(intLabels.get(i));
        
    }//end for
    
    
    label = new JLabel("Enter a a String to be sorted. ");

    iOPanel2.add(label);
    for(int i = 0; i <= strToSort.length; i++){
    strLabels.add(new JLabel(String.valueOf(i)));
    }//end for
    //textListener tL = new textListener();
    for(int i = 0; i < strLabels.size(); i++){
        if(DEBUG)System.out.println("Adding text field to the array");
        strText.add(new JTextField(12));
        strText.get(i).setEditable(true);
        strText.get(i).addActionListener(tL);
        strText.get(i).setActionCommand("S"+i);
        if(DEBUG)System.out.println(i);
        if(!(i >= strToSort.length))
            strText.get(i).setText(strToSort[i]);
        else
            strText.get(i).setText("");
 
    }
    //new JTextField(12);




    for(int i = 0; i < strLabels.size(); i++){
        if(DEBUG)System.out.println("Adding everything to the pane");
        iOPanel2.add(strText.get(i));
        iOPanel2.add(strLabels.get(i));
        
    }//end for

    }//end build


    private class textListener implements ActionListener { // implemnts implements a 'interface'

        public void actionPerformed(final ActionEvent e){
            final String s = e.getActionCommand();
            if(DEBUG)System.out.println("getActionCommand() = " + s);//debugging
            if(!s.isEmpty()){
                if(s.charAt(0)=='I'){
                    sortInt.clear();//clears the arrayList to be repopulated
                    for(int i=0; i < intText.size(); i++){
                        if(!intText.get(i).getText().isBlank()){
                            //find way how to check if the value inputed is not a string
                            //if(!("1234567890").contains(intText.get(i).getText())){
                                    //System.out.println("string detected");
                                if(DEBUG)System.out.println(intText.get(i).getText().isBlank());
                                sort( sortInt ,Integer.parseInt(intText.get(i).getText()));//adds and sorts the value to the array
                                if(DEBUG)System.out.println("sorting into array");
                            //}//end if
                           
                        }//end if

                    }//end for

                    if(DEBUG){
                        System.out.println();
                        System.out.println("Printing out the sorted array");
                        for(int value : sortInt){
                            System.out.println(value);
                        }//end for
                    }//end if
                    //parallel arraylists
                    //updating the texts of the array
                    for(int i = 0; i < intText.size(); i++ ){
                        if(!intText.get(i).getText().isBlank()){
                            if(DEBUG)System.out.println("setting the array values shown");
                            intText.get(i).setText(String.valueOf(sortInt.get(i)));//sets the value at the sorted array tot he value of the texts int the text field
                        }//end if
                    }//end for
                }//end if
                
                else if(s.charAt(0) == 'S'){
                    sortStr.clear();//clears the arrayList to be repopulated
                    for(int i=0; i < strText.size(); i++){
                        if(!strText.get(i).getText().isBlank()){
                            //System.out.println(strText.get(i).getText().isBlank());
                            sort( sortStr,strText.get(i).getText());//adds and sorts the value to the array
                            if(DEBUG)System.out.println("sorting into array");
                        }//end if
                        
 
                    }//end for
                    
                    if(DEBUG){
                        System.out.println();
                        System.out.println("Printing out the sorted array");
                        for(String value : sortStr){
                            System.out.println(value);
                        }//end for
                    }//end if
                    //parallel arraylists
                    //updating the texts of the array
                    for(int i = 0; i < strText.size(); i++ ){
                        if(!strText.get(i).getText().isBlank()){
                        if(DEBUG)System.out.println("setting the array values shown");
                        strText.get(i).setText(sortStr.get(i));//sets the value at the sorted array tot he value of the texts int the text field
                        }//end if
                    }//end for
                }//end if
            }//end if
            
           
        }//end actionPerformed abstract override
        
        
    }//end class    
    
    
    
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
        //varaible declarations
        int numberToSort[] = {0 , 15, 85, 75, 45, 5, 92, 70, 1, 95};
        String stringToSort[] = { "abc", "ydj", "mark", "0of", "l33t", "3l1t3", "1337", "someonesName", "Oh Goody!", "numb" };
        boolean inputListBool = false;
        String boolResponse = "";
        int menuChoice;
        ArrayList<Integer> sortingInt = new ArrayList<Integer>();
        ArrayList<String> sortingString = new ArrayList<String>();
        
        Scanner input = new Scanner( System.in );
        //end declarations
        
        homeworkHeader("Assignment 11 - Insertion Sort");
        
        System.out.println();//blank line for visibility
        System.out.println("would you like to use the console, or a gui (1: console, 2: gui):");
        menuChoice = input.nextInt();
        input.nextLine();//eat the blank space
        if(menuChoice == 2){
            new Assignment11();
        }
        else{
            //boolRespose = "";
            //ask the user if they would like to input their own values for the array
            while(boolResponse.isEmpty() || boolResponse.isBlank()){//loops as long as bool reposne is null or bool doesn't equal yes
                System.out.println("Would you like to input your own numbers to be sorted? (Yes or No)");
                boolResponse = input.nextLine();
            }
            if (boolResponse.toLowerCase().charAt(0) == 'y')//if the user says yes
                inputListBool = true;//set inputListBool to true

            while(inputListBool){//if inputListBool is true
                //System.out.println("Pleae enter the next integer for the array: ");
                inputListBool = !popArray(numberToSort, input);//run the popArray method which returns true, ! turns false

            }//end while
    //        
    //        for(int arrayValue : numberToSort){
    //            sortingInt.add(arrayValue);
    //        }//end for each

            //insertion sort
            //algorithm:
            //  find the lowest value after the key 
            //  and compare to the last value of the array and either add to the end or add before

            //###############################################
            //the following code has been moved into a method
            //##############################################
    //        sortingInt.add(numberToSort[0]);
    //        for(int key = 1, nextLowest = numberToSort[0], nextHighest = sortingInt.get(0); key < numberToSort.length; key++){
    //            int current = numberToSort[key];
    //            int j = key -1;//the last value in the ArrayList
    //            
    //            System.out.println("current value :" + current);//debugging
    //            while ((j >= 0)&& (sortingInt.get(j) > current)){
    //                System.out.println(sortingInt.get(j) + " > " + current + " " + ((sortingInt.get(j) > current)));
    //                nextHighest = sortingInt.get(j);
    //                nextLowest = current;
    //                j--;
    //            }
    //            if(j != key - 1){//if the while loop was entered ( meaning that the sortingInt.get(j) was greater than the current value )
    //                sortingInt.add(sortingInt.indexOf(nextHighest), nextLowest);//place the current value which has been set to nextLowest to the integer
    //            }//end if
    //            else{
    //                sortingInt.add(current);
    //            }//end else if
    //            
    //            System.out.println();
    //            System.out.println("the current ArrayList");//debugging
    //            for(int value : sortingInt)//debugging
    //                System.out.println(value);
    //            System.out.println("End current ArrayList"); //debugging
    //        }//end for
    //        
            sort(numberToSort, sortingInt);


            //sort(numberToSort, sortingInt);
            //displays sorted arrayList to the screen
            System.out.println();//blank line for visibility
            System.out.println("Sorted Integer List");//label for sorted array
            for(int value : sortingInt)//testing that indeed array was pass by reference
                System.out.println(value);
            //sortingInt.add(input.nextInt());
            boolResponse = "";
            //input.next();//eats up next byte
            input.reset();
            while(boolResponse.isEmpty() || boolResponse.isBlank()){//loops as long as boolResponse is null
                System.out.println("Would you like to input your own String values to be sorted? (Yes or No)");
                boolResponse = input.nextLine();
            }//end while
            //System.out.println(boolResponse);//debugging

            if (boolResponse.toLowerCase().charAt(0) == 'y')
                inputListBool = true;

            while(inputListBool){
                //System.out.println("Pleae enter the next integer for the array: ");
                inputListBool = !popArray(stringToSort, input, "");
            }//end while
            sort(stringToSort, sortingString );

            //displays sorted arrayList to the screen
            System.out.println();//blank line for visibility
            System.out.println("Sorted String List");//label for sorted array
            for(String value : sortingString)//testing that indeed array was pass by reference
                System.out.println(value);


            //testing singular insertion int
            System.out.println();//blank line for visibility
            System.out.println("Testing singular insertion sort with an integer inserted into the sorted array");
            System.out.println("Inserting the value '7' into the array to be sorted");
            System.out.println();//blank line for visibility
            sort(sortingInt, 7);
            //displays sorted arrayList to the screen
            for(int value : sortingInt)//testing that indeed array was pass by reference
                System.out.println(value);


            if(DEBUG){
            System.out.println();//blank line for visibility
            System.out.println("The expected results before the inserted value");
            System.out.println();//blank line for visibility
            Arrays.sort(numberToSort);//uses the arrays class to sort the array to check the above array
            for(int value : numberToSort)//prints out the sorted array
                System.out.println(value);
            }//end if

            //https://tools.knowledgewalls.com/online-lexicographic-ascending-or-descending-sort
            //site above used to confirm lexigraphical sort
            //singular insertion method ( string )
            System.out.println();//blank line for visibility
            System.out.println("Testing single insertion sort with a string value inserting into the array");
            System.out.println("Inserting the value 'a' into the array to be sorted");//blank line for visibility
            System.out.println();//blank line for visbility
            sort(sortingString, "a");
            for(String value : sortingString)//testing that indeed array was pass by reference
                System.out.println(value);

            if(DEBUG){
            System.out.println();//blank line for visibility
            System.out.println("The expected results before the inserted value");
            System.out.println();//blank line for visibility
            Arrays.sort(stringToSort);//uses the arrays class to sort the array to check the above array
            for(String value : stringToSort)//prints out the sorted array
                System.out.println(value);
            }//end if

        }//end if
        input.close();//closes the scanner input stream
    }//end main


           
       
              
        
        
      
        
    /**
     * method to populate the integer array
     * custom values
     * @param array
     * @param in
     * @return 
     */
    public static boolean popArray(int array[], Scanner in){
        
        
        for(int i = 0; i < array.length ; i++ ){//loop runnign at the length of the array to populate it with values inputed by the user
            System.out.println("Pleae enter the next integer for the array: ");
            array[i] = in.nextInt();
        }//end for
        in.nextLine();//eat up blank whitespace
        return true;
    }//popArray

    /**
     * method to populate the string array
     * custom values
     * @param array
     * @param in
     * @param nullString
     * @return 
     */
    public static boolean popArray(String array[], Scanner in, String nullString){
        
        
        for(int i = 0; i < array.length ; i++ ){//loop to run at the lenght of the array to populate it with values from the user
            System.out.println("Pleae enter the next String value for the array: ");
            array[i] = in.nextLine();
        }//end for
        return true;
    }//popArray
    
    /**
     * sorts the int array into a sorted arrayList
     * 
     * @param unsorted
     * @param sorted 
     */
    public static void sort( int[] unsorted , ArrayList<Integer> sorted){//because arrays and ArrayList 
        sorted.add(unsorted[0]);
        for(int key = 1, nextLowest = unsorted[0], nextHighest = sorted.get(0); key < unsorted.length; key++){
            int current = unsorted[key];
            int j = key -1;//the last value in the ArrayList
            
            if(DEBUG) System.out.println("current value :" + current);//debugging
            while ((j >= 0)&& (sorted.get(j) > current)){
                if(DEBUG) System.out.println(sorted.get(j) + " > " + current + " " + ((sorted.get(j) > current)));
                nextHighest = sorted.get(j);//set the nextHighest to the current j value
                nextLowest = current;//set the nextLowest to the current value
                j--;
            }
            if(j != key - 1){//if the while loop was entered ( meaning that the sortingInt.get(j) was greater than the current value )
                sorted.add(sorted.indexOf(nextHighest), nextLowest);//place the current value which has been set to nextLowest to the integer
            }//end if
            else{
                sorted.add(current);//add the current value to the end if it was greater than sorted.get(key -1)
            }//end else if
            
            if(DEBUG){
                System.out.println();
                System.out.println("the current ArrayList");//debugging
                for(int value : sorted)//debugging
                    System.out.println(value);
                System.out.println("End current ArrayList"); //debugging
            }//end debugging 
        }//end for
        
    }//end sort
    
    /**
     * sorts the string array into a sorted ArrayList
     * 
     * @param unsorted
     * @param sorted 
     */
    public static void sort( String[] unsorted , ArrayList<String> sorted){//because arrays and ArrayList 
        sorted.add(unsorted[0]);
        String nextLowest = unsorted[0], nextHighest = sorted.get(0);
        for(int key = 1; key < unsorted.length; key++){
            String current = unsorted[key];
            int j = key -1;//the last value in the ArrayList
            
            if(DEBUG) System.out.println("current value :" + current);//debugging
            while ((j >= 0)&& (sorted.get(j).compareTo(current) > 0)){
                if(DEBUG) System.out.println(sorted.get(j) + " > " + current + " " + ((sorted.get(j).compareTo(current))));
                nextHighest = sorted.get(j);//set the nextHighest to the current j value
                nextLowest = current;//set the nextLowest to the current value
                j--;
            }
            if(j != key - 1){//if the while loop was entered ( meaning that the sortingInt.get(j) was greater than the current value )
                sorted.add(sorted.indexOf(nextHighest), nextLowest);//place the current value which has been set to nextLowest to the integer
            }//end if
            else{
                sorted.add(current);//add the current value to the end if it was greater than sorted.get(key -1)
            }//end else if
            
            if(DEBUG){
                System.out.println();
                System.out.println("the current ArrayList");//debugging
                for(String value : sorted)//debugging
                    System.out.println(value);
                System.out.println("End current ArrayList"); //debugging
            }//end debugging 
        }//end for

    }//end sort
    
    /**
     * sorts a singular value into the already sorted ArrayList
     * this algorithm is a manipulation of the algorithm form above
     * @param sorted
     * @param current 
     */
    public static void sort(ArrayList<Integer> sorted, int current){
        int nextLowest = current;
        int nextHighest = current;
        System.out.println(sorted.size());
        if(sorted.size() != 0){//if sorted already has values within it
            for(int i = sorted.size() - 1; i >= 0; i--){
                if(sorted.get(i) > current)
                    nextHighest = sorted.get(i);
            }//end for
            if(nextLowest == nextHighest){
                sorted.add(nextHighest);
                return;
            }//end if
            sorted.add(sorted.indexOf(nextHighest), nextLowest);
        }//end if
        else{//if sorted is unpopulated
            sorted.add(current);
        }//end else
    }//end sort
    
    
    /**
     * sorts a singular string value into the already sorted ArrayList
     * this algorithm is a manipulation of the algorithm above in the prime sort methods
     * @param sorted
     * @param current 
     */
    public static void sort(ArrayList<String> sorted, String current){
        String nextLowest = current;
        String nextHighest = current;
        //if(sorted.size() > 0){//comment out to test if needed
        for(int i = sorted.size() - 1; i >= 0; i--){
            if(sorted.get(i).compareTo(current) > 0)
                nextHighest = sorted.get(i);
        }//end for
        if(nextLowest == nextHighest){
            sorted.add(nextHighest);
            return;
        }//end if
        sorted.add(sorted.indexOf(nextHighest), nextLowest);
        //}//end if
    }//end sort
    
    
}//end Assignment11 class


/*


Describe what portions of the assignment are done and complete. 

    As far as I know no part fo the assignment is incomplete. The program takes an array and sorts it usign the insertion sort algorithm.
    The program also allows for the insertion of a single value inot the array to be sorted.
    I am currently working on tryign to turn the program into a GUI.


What is missing? What caused the incompleteness.

    As far as I know nothing is missing. I am trying to add a Gui functionality to the program. If anything the only thing that may not meet the standards are the itterator variables.
        With itterator variables I tend to use the variable i, j in order not to confuse myself with other variable expressions.
    I am submitting this version, to meet the deadline, and if I finish before the deadline will submit the version with the GUI.
    The singular sort methods still need some fuzzing to be done in the testing. I was hoping to do this through the GUI. ( recall it is lexigraphical comparison for strings, so lenght isnt the first check made )
    
How do you feel about the assignment or what did you learn while doing it?

    I really enjoyed the assignmnet, I like using ArrayLists. I find them a convinient and verstatile sub class of the Vector Class. 
    This type of algorithm with ArrayLists is something I did in highschool as well. However this time around I struggled a little bit witht he implementation of an algorithm that worked properly.
    This struggle ws likely due to lack of sleep accumulated throughout the past 2 weeks. After recovering with a little extra sleep things seemed to move forwards smoothly.
    I greatly enjoyed th eproject and am Excited for the possible implementations. 
*/