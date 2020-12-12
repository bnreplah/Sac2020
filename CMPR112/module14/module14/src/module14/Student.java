/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package module14;

/**
 * Class for each student in a class, accessor class for the private Tests class 
 * @author benha
 */
public class Student {
    
    private enum LETTERGRADE {A, B, C,D, F};//letter grades
    
    private final int TESTS = 4;//max number of tests
    private String studentName;
    private Tests grades;//calls teh Tests class which holds all the values of the tests
    
    /**
     * initializes the tests class with the max number of tests and adds the values of the students score on each test from an array
     * initializes the student name
     * @param name
     * @param test 
     */
    public Student(String name,int[] test){
        this.studentName = name;
        grades = new Tests(test, this.TESTS);
        
    }//end Student constructor
    
    /**
     * initializes the Tests class with the max number of tests and student name
     * @param name 
     */
    public Student(String name){
        this.studentName = name;
        this.grades = new Tests(this.TESTS);
    }//end default constructor
    
    /**
     * initializes the Tests with individually inputted test values
     * initializes the student name 
     * @param name
     * @param test
     * @param test2
     * @param test3
     * @param test4 
     */
    public Student(String name,int test, int test2, int test3, int test4){
        this.studentName = name;
        this.grades = new Tests(test, test2, test3, test4);
        
    }//end student constructor
    
    /**
     * gets the max number of tests
     * @return 
     */
    public int getTestNum(){
        return this.TESTS;
    }
    
    /**
     * gets the student's name
     * @return 
     */
    public String getName(){return this.studentName;}
    //end getName
    
    /**
     * gets the average from the Tests object
     * @return 
     */
    public int getAverage(){return this.grades.average();}
    //end getAverage
    
    /**
     * gets a specific test number from the test class
     * @param testNum
     * @return 
     */
    public int getScore(int testNum){return this.grades.getScore(testNum);}
    //end getScore
   
    /**
     * adds an individual test score to the student's Tests object
     * if all the scores are populated, then does nothing
     * @param score 
     */
    public void setScore(int score){
        this.grades.setScore(score);//once again does nothing if the tests are full        
    }//end setScore
    
    /**
     * sets the score of a specific test ( overwrites if present )
     * @param score
     * @param testNum
     * @return 
     */
    public boolean setScore(int score, int testNum){
        return this.grades.setScore(score, testNum);
    }//end setScore
    
    /**
     * 
     * @return 
     */
    public LETTERGRADE getGrade(){//letter grade determined by integer average ( rounds down )//adding 0.5 would allow for the grade to be rounded up
        int score = getAverage();
        //System.out.println(score);
        int upperLim = 100;
        int lowerLim = upperLim - 10;
        for(int i = 0; i < 5 && lowerLim != 0; i++ ){
            //System.out.println(LETTERGRADE.values()[i]);
            if(score < lowerLim){
                lowerLim -=10;
                //System.out.println(lowerLim);
            }//end if
            else
                return (LETTERGRADE.values()[i]);
        }
        return LETTERGRADE.F;
    }//end getGrade
    
    /**
     * test class which holds the test scores
     */
    private class Tests{
        private int test[];
        private int active = 0;
        
        /**
         * first constructor
         * @param numTests 
         */
        public Tests(int numTests){
            this.test = new int[numTests];
        }//end Tests
        
        /**
         * 
         * @param tests
         * @param numTests 
         */
        public Tests(int tests[], int numTests){
            this.test = new int[numTests];
            for(int i = 0; i < test.length; i++){
                test[i] = tests[i];
            active = test.length;
            }//end for
            
        }//end Tests
        
        /**
         * 
         * @param test
         * @param test2
         * @param test3
         * @param test4 
         */
        public Tests(int test, int test2, int test3, int test4){
            int load[] = {test, test2, test3, test4};
            this.test = new int[load.length];
            for(int i = 0; i < this.test.length; i++)
                this.test[i] = load[i];
            active = this.test.length;
        }//end Tests
        
        /**
         * adds a score inside the test class
         * @param score
         * @return 
         */
        public boolean setScore(int score){
            boolean success = false;
            if(active < test.length){
                this.test[active] = score;
                active++;
                success = true;
            }//end if
            return success;
        }
        
        /**
         * sets the score inside the encapsulated test class
         * @param score
         * @param index
         * @return 
         */
        public boolean setScore(int score, int index){
            boolean success = false;
            if(index < this.test.length && index >= 0){
                this.test[index] = score;
                success = true;
            }//end if
            return success;
        }
        
        /**
         * gets the active tests/ how full the test array is
         * @return 
         */
        public int getActive(){return active;}
        
        
        /**
         * gets the average ( integer division )
         * @return 
         *///add 0.5 prior to the division to cause the values to round up
        public int average(){
            int total = 0;
            for(int testScore : this.test){
                total += testScore;
            }//end for
            return total/this.test.length;//integer division returns an average as an int
        }//end getAverage
        
        /**
         * get the score of the test ( index ) ( test at index )
         * @param index
         * @return 
         */
        public int getScore(int index){
            if (index < this.test.length && index >= 0)
                return this.test[index];
            return -1;//returns -1 if the index is out of bounds
            //could implement a try and catch to catch an error instead.
            
        }
        
        
    }//end test class
    
    
}//end student class
