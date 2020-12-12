/**
*Ticket : 86713
*Course : CMPR 112
*Student : Ben Halpern
*Instructor : Professor Kirscher
*Environment: Win 10 NetBeans
*Project Title : 
*
*
*Assignment details:
* 
* Glossary:
*
*In this assignment you will find a reference to a Big Loop.   A Big Loop is usually an outer loop.   Assuming you have two or more loops embedded inisde each other.   the big loop is the loop with the first for loop statement. 
*
*CAUTION: this code shows an outer big loop and inner smaller loop. This code does not solve the assignment.  This is to show that for loops can be embedded inside other loops.
*
*for ( int row = 0; row < 3; row++)      this for loop which is changing the row index is the big loop. 
*
*{
*
*        for ( int col = 0 ; col < 3; col ++ )
*
*       {
*
*             cout    <<   ticTacToeBoard  [ row]  [ col ] << "  ";
*
*       }
*
*       cout << endl;
*
*}

*Part 1:
*
*Using this web page create an array of strings that contain the Division Names at Santa Ana College.  Hint: First Division is the Business Division.  There are six divisions, see:
*
*https://sac.edu/AcademicAffairs/Pages/Divisions-Departments.aspx (Links to an external site.)
*
* 
*
* 
*
*Output the list of division names.  using an integer that indexes to each name.
*
*Output the list of  division names  using the  Java For-Each loop.  
*
* 
*
* 
*
*Part 2: 
*
*2 A ) create an  integer array of 40 elements
*
*2 B ) fill the first 2 elements with 1 and 2.    To be more clear set a 1 into the very first element.   Set a 2 in the second element.   
*
*2 C) then for the remaining 38 elements set the sum of the previous two elements into the element.   
*
*2 D) display the values of the 40 elements
*
* 
*
* 
*
*Part 3: 
*
*Create an array of 20 integers.
*
*Fill the array with the odd numbers starting at 1.   ( should be 1, 3, 5, 7, etc.   Use a loop! )
*
*using a big loop show the sum of the elements:
*
*So show the sum of the elements at position 0 ( 1) 
*
*then show the sum of the elements at positions 0 and 1. 
*
*then show the sum of the elements at positions 0,1,2
*
*etc. 
*
*then show the sum of the elements at positions 0,1,2,3 . . . , 18, 19
*
* 
*
*Part 4. 
*
*Create an array of doubles to hold the miles from the sun for each of the NINE planets.   
*
*Example for Earth    
*
*distances[2] = 93E6;     93000000 miles from earth to sun.   
*
* in Scientific Notation.    93 x 10 to the 6th.   
*
*   93.0    but move the decimal mount 6 places to the left.  
*
* 93 000 000 . 0
*
* 
*
* 
*
*Print out the distances. 
*
*( For those of you who think there are 8 planets, fine.   But answer this:
*
*What are we to do with Plutonium if we only have 8 planets? ) 
*
* 
*
* Discussion Questions. 
*
*How do you envision arrays? Or how would you describe them?
*
*Can you think of some applications where arrays are the appropriate data structure?  
*
* 
* 
* 
* 
* 
* 
* 
* ##########################################################################################
* Notes:
* https://stackabuse.com/web-scraping-the-java-way/
* thinking of using webscraping to extract the data from the site ( will put this class at the end in order not to distract from the assignment )
*   The methods of webscraping use packages : ( descriptions taken from the pages above )
*        JSoup - this is a simple open-source library that provides very convenient functionality for extracting and manipulating data by using DOM traversal or CSS selectors to find data. It does not support XPath-based parsing and is beginner friendly. More information about XPath parsing can be found here.
*
*        HTMLUnit - is a more powerful framework that can allow you to simulate browser events such as clicking and forms submission when scraping and it also has JavaScript support. This enhances the automation process. It also supports XPath based parsing, unlike JSoup. It can also be used for web application unit testing.
*
*        Jaunt - this is a scraping and web automation library that can be used to extract data from HTML pages or JSON data payloads by using a headless browser. It can execute and handle individual HTTP requests and responses and can also interface with REST APIs to extract data. It has recently been updated to include JavaScript support.
* 
*       The example in the article above uses a code handler to deal with dependecies ( maven or girdle ). From what I am understanding, the lack of use of these may make the code a little more legacy.
*       It is not my desrie to use maven or girdle at the moment, since I don't fully understand them and their functionality at the moment ( something for the future )
*       I will attempt to write the code without them, since I aslo want the code to be able to be run on different machines and I don't know how maven or girdle may effect that
* 
*       jsoup and jaunt seem to require third party packages, which is also not my aim
*       so I will use the next article
* 
* Here is another post by one of my favorite sections on medium.com ( hackernoon )
* https://medium.com/hackernoon/introduction-to-web-scraping-with-java-3d8a8d0f250b
*   In this post they use HTMLUnit and xpath
* Since htmlunit also requires an external pacakge, I'm going to try to do this with the basic packages provided
* 
* 
* basing my code for parsing off the example form the following site
* http://zetcode.com/java/httpclient/
* 
* In the article above the author shows many uses of the new package that has been introduced in java 11, httpclient.
* I am only intersted in the get request to get the body of the html site, and the status code ( to see fi permission is allowed ) however this has opened up the possibilities of so much
* ( as well as the ability to connect to websockets ( as I saw in search of this ) which I reviewed once in the hacking of an application that communicated with a sever, at the time I didn't recall too much about java.)
* ( this also opens the possibility to create simple chat engines to communicate with friends : like an ip chat, sendding out a request and connecting it over a websocket on the computer )
* For the mean time I will use httpclient
* https://docs.oracle.com/en/java/javase/11/docs/api/java.net.http/java/net/http/HttpClient.html#newHttpClient()
* https://docs.oracle.com/en/java/javase/11/docs/api/java.net.http/java/net/http/HttpRequest.Builder.html#uri(java.net.URI)
* Will create a web client object. This object will be used to fetch the site to be parsed.
* Possible will use xpath to do the parsing// I will simply be parsing through the code with a loop to select the node, the part with xpath is what required outside help.
* https://docs.oracle.com/javase/7/docs/api/java/net/URI.html
* The uri class will break downn the uri into componenets acceptable of the URI library ( Uniform Resource Identifier :  RFC 2396: Uniform Resource Identifiers (URI): Generic Syntax )
* 
* 
* note in order to run the httpClient and http class the jdk needs to be set to be jdk 11 or higher
* Through alot of trial and error, trying and resaerching and thinking, I was able to use the http methods to parse the data and extract the values I desired. If I have extra time I will try to use the HttpURL method
*
*
*/


package assign09;

import java.io.IOException;//according to the java doc ioexception and interuptexception is needed for http
//import java.util.Scanner;//scanner package to request input
//web scraper packages:
import java.net.URI;//converts the url into a uniform resouce identifier ( breaks apart the request method, the directory, etc in the OSI stack )
import java.net.URISyntaxException;
import java.net.http.*;
import java.net.*;
import java.text.*;//used to format string and numbers
//NOT USED:
//import java.net.http.HttpClient;//stages the http client to wait on the socket to send out the request ( two ways to build the httpclient : .newHttpClient() //default  .HttpClient.newBuilder().build(); )
//import java.net.http.HttpRequest;//is used to post the request to aquire the http get request ( in the format : HttpRequest request = HttpRequest.newBuilder().uri(URI.create("http://webcode.me")).build();)
//import java.net.http.HttpResponse;//stores the request response ( can be stored as a string using  HttpResponse<String> )
//end web scaraper packages
//discovered a possible easier way to do the webscraping is with a single package
//import java.net.HttpURLConnection;
//DOM parsing https://www.tutorialspoint.com/java_xml/java_dom_parse_document.htm
//will try to populate the object into a DOM event
//import org.w3c.dom.*;
//import javax.xml.parsers.*;
//import java.io.*;

//end preprocessor commands

/**
 *
 * @author benha
 */
public class assign09 {
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
     * @throws java.lang.InterruptedException
     * @throws java.net.URISyntaxException
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws InterruptedException,URISyntaxException,IOException {
        //main class of the function. Will call the driver methods here, and initialize the runtime enviornment for the user
        String[] divisionNames = new String[6];
        //declaration of variables ( initialization and instatiation )
        try{
            
            Webscraper web = new Webscraper("https://sac.edu/AcademicAffairs/Pages/Divisions-Departments.aspx");//creates webscraper class instance and initializes it with the provided SAC URI         
            if(web.connectSuccess()){
                divisionNames = web.parsePage();
            }//end if
            else{
                System.out.println("Connection failed, resorting to default values...");
                divisionNames[0] = "Busi​​n​ess​";
                divisionNames[1] = "Fine & Performing Arts";
                divisionNames[2] = "Human Services & Technology";
                divisionNames[3] = "Human​ities & Social Sciences";
                divisionNames[4] = "Kinesiology & Athletics";
                divisionNames[5] = "Science, Mathematics & Health Sciences";
            }//end else
        }catch(InterruptedException | URISyntaxException | IOException e){
            System.out.println("Connection failed, resorting to default values...");

            //e.printStackTrace();//prints error if one occurs and continues with the default values
            divisionNames[0] = "Busi​​n​ess​";
            divisionNames[1] = "Fine & Performing Arts";
            divisionNames[2] = "Human Services & Technology";
            divisionNames[3] = "Human​ities & Social Sciences";
            divisionNames[4] = "Kinesiology & Athletics";
            divisionNames[5] = "Science, Mathematics & Health Sciences";
        }//end catch
        //int part2Array[] = new int[40];
        //DecimalFormat format = new DecimalFormat();
        //end declaration of variables
        
        //calling of homeworkHeader method
        homeworkHeader("Assignmnet 09 - Arrays Intro");
        
        //part 1
        //divisionName array created by scrapping the website for the division names
        System.out.println("###########################  Divisions of Education at SAC  ##############################");
        for(String division : divisionNames)
            System.out.println(division);
        //test cases: Should produce the following names:
         //Busi​​n​ess​
         //Fine & Performing Arts
         //Human Services & Technology
         //Human​ities & Social Sciences
         //Kinesiology & Athletics
         //Science, Mathematics & Health Sciences
        
        
        //part 2
        //algorithm:
        // n = (n-2) + (n-1)
        System.out.println("###############################  Fibbonacci's Sequence ###################################");
        recursiveAddition(1,2, 40);//calls teh recursiveAddition method to do the encapsulated part 2
        //test cases: Should produce the following values:
        //1
        //2
        //3
        //5
        //8
        //13
        //21
        //34
        //55
        //89
        //144
        //233
        //377
        //610
        //987
        //1,597
        //2,584
        //4,181
        //6,765
        //10,946
        //17,711
        //28,657
        //46,368
        //75,025
        //121,393
        //196,418
        //317,811
        //514,229
        //832,040
        //1,346,269
        //2,178,309
        //3,524,578
        //5,702,887
        //9,227,465
        //14,930,352
        //24,157,817
        //39,088,169
        //63,245,986
        //102,334,155
        //165,580,141
        
        //part 3
        //recall if the num % 2 leaves a remainder 1, then it is odd
        //algorithm:
        //sum = part3Array[n] + part3Array[n-1]: where n starts off at 0 and n-1 DNE
        //arr[n] = (loop to next num : num %2 == 1)
        //part3Sum += arr[n];
        System.out.println("####################################  Odd Sum Game ##########################################");
        oddSumGame(20);
        //test cases: The values should be presented as such:
        //At itteration:         1 	The value is:          1 	The Rolling Sum is:          1
        //At itteration:         2 	The value is:          3 	The Rolling Sum is:          4
        //At itteration:         3 	The value is:          5 	The Rolling Sum is:          9
        //At itteration:         4 	The value is:          7 	The Rolling Sum is:         16
        //At itteration:         5 	The value is:          9 	The Rolling Sum is:         25
        //At itteration:         6 	The value is:         11 	The Rolling Sum is:         36
        //At itteration:         7 	The value is:         13 	The Rolling Sum is:         49
        //At itteration:         8 	The value is:         15 	The Rolling Sum is:         64
        //At itteration:         9 	The value is:         17 	The Rolling Sum is:         81
        //At itteration:        10 	The value is:         19 	The Rolling Sum is:        100
        //At itteration:        11 	The value is:         21 	The Rolling Sum is:        121
        //At itteration:        12 	The value is:         23 	The Rolling Sum is:        144
        //At itteration:        13 	The value is:         25 	The Rolling Sum is:        169
        //At itteration:        14 	The value is:         27 	The Rolling Sum is:        196
        //At itteration:        15 	The value is:         29 	The Rolling Sum is:        225
        //At itteration:        16 	The value is:         31 	The Rolling Sum is:        256
        //At itteration:        17 	The value is:         33 	The Rolling Sum is:        289
        //At itteration:        18 	The value is:         35 	The Rolling Sum is:        324
        //At itteration:        19 	The value is:         37 	The Rolling Sum is:        361
        //At itteration:        20 	The value is:         39 	The Rolling Sum is:        400
                
        
        //part4
        //scientific notation can be formatted with the format() method
        System.out.println("################################## Miles From the Sun #######################################");
        milesFromSun();
        //test cases: The values should be as such:
        //   Mercury is     36000000.00 Miles from the sun or       36E6 Miles from the sun (scientific notation) 
        //     Venus is     67200000.00 Miles from the sun or       67E6 Miles from the sun (scientific notation) 
        //     Earth is     93000000.00 Miles from the sun or       93E6 Miles from the sun (scientific notation) 
        //      Mars is    141600000.00 Miles from the sun or       14E7 Miles from the sun (scientific notation) 
        //   Jupiter is    483600000.00 Miles from the sun or       48E7 Miles from the sun (scientific notation) 
        //    Saturn is    886700000.00 Miles from the sun or       89E7 Miles from the sun (scientific notation) 
        //    Uranus is   1784000000.00 Miles from the sun or       18E8 Miles from the sun (scientific notation) 
        //   Neptune is   2794400000.00 Miles from the sun or       28E8 Miles from the sun (scientific notation) 
        //     Pluto is   3674500000.00 Miles from the sun or       37E8 Miles from the sun (scientific notation) 
        
    }//end public main 
    
    
    
    
    //part 2 of assignment
    /**
     * Part2 of Assignment
     * recursiveAddition - creates a loop adding the last 2 values to get the current one
     * This is also fibbonacci's sequence
     * algorithm:
     * n = (n-2) + (n-1)
     * 
     * encapsulation: placing the action of part2 of the assignment within a method
     *  @param int value1,value2, size
     */
    static void recursiveAddition(int value1, int value2, int size){
        int[] part2Array = new int[size];
        part2Array[0] = value1;
        part2Array[1] = value2;
                
                
        for(int i = 2; i < part2Array.length; i++){
            part2Array[i] = part2Array[i-1] + part2Array[i-2];//sets the current value to be the sum of the last 2
        }//end for
        System.out.println();//blank line for visibility
        
        System.out.println("The values of the Array from 0 - 40 :");
        for(int value : part2Array)//for-each loop to print out every value of the array
            System.out.printf("%,d%n",value);//formatted output
        // System.out.println(web.getResponseCode() + "\n" + web.sendGet(""));//
        //dipslays error if thrown//catch(InterruptedException e){e.getStackTrace();}
        
    }//end recursiveAddition ( part 2)
    //end part2
    
    
    //part 3 of assignment
    /**
     * part 3 of Assignment
     * @param size 
     */
    static void oddSumGame(int size){
        int odd = 0;
        int part3Array[] = new int[size];
        int part3Sum = 0; 
        for(int i = 0; i < part3Array.length; i++){   
            while(odd++ % 2 != 1){
                //System.out.println(odd);
                part3Array[i] = odd;//sets array to each value until it exits the loop //find better way to do this
            }//end while
            part3Sum += part3Array[i];
            System.out.printf("At itteration:%10d \tThe value is: %10d \tThe Rolling Sum is: %10d%n" ,i+1,part3Array[i],part3Sum );
        }//end for
       
    }//end oddSumGame
    //end part3
    
    
    //part 4 of the assignment
    /**
     * part 4 of the Assignment
     */
    static void milesFromSun(){
        double[] milesFromSun = new double[9];//for part 4
        NumberFormat form;
        String[] planetNames = {"Mercury","Venus","Earth","Mars","Jupiter","Saturn","Uranus","Neptune", "Pluto"};
        milesFromSun[0] = 36E6;
        milesFromSun[1] = 67.2E6;
        milesFromSun[2] = 93E6;
        milesFromSun[3] = 141.6E6;
        milesFromSun[4] = 483.6E6;
        milesFromSun[5] = 886.7E6;
        milesFromSun[6] = 1784E6;
        milesFromSun[7] = 2794.4E6;
        milesFromSun[8] = 3674.5E6;
        form = new DecimalFormat("00E0");//sets format for decimal scientific notation output
        System.out.println();//blank line for visibility
        for(int i = 0; i < 9; i++){
            System.out.printf("%10s is %15.2f Miles from the sun or %10s Miles from the sun (scientific notation) %n",planetNames[i],milesFromSun[i], form.format(milesFromSun[i]));
        }//end for
    }//end milesFromSun
    //end part 4
    
    
    //webscraper class
    /**
     * @see http://zetcode.com/java/httpclient/
     * a class based of the methods in the link above
     * The webscraper class will take the uri and send a get request to the site and retrieve the html code,
     * It will then parse through the html code in order to find the specific names desired to populate an array
     * 
     * 
     * algorithm: 
     *  -check if site is reachable
     *  -send get request
     *  -parse through the get response and populate array
     */
    public static class Webscraper{
        
        
        //first must check to see if the site is reachable
        //send get request
        //parse request into an array
        
        //global static final variable for the uri
        private final URI uri;
        
        /**
         * constructor which loads the uri to be used
         * @param uri
         * @throws URISyntaxException
         */
        public Webscraper(String uri) throws URISyntaxException{
            this.uri = new URI(uri); 
        }//end webscraper constructor
        
        /**
         * uses http.HttpClient , http.HttpRequest, http.HttpResponse to forge request
         * and send that request to the server and return the response
         * @return the response given from the request
         * @throws IOException
         * @throws InterruptedException 
         */
        public String sendGet() throws IOException, InterruptedException {//relies on IOException, InterruptedException, HttpClient, HttpRequest, HttpResponse
            HttpClient goCall = HttpClient.newHttpClient();//A new HTttpClient is created ( will be used to request a web page of uri )
            HttpRequest req = HttpRequest.newBuilder(uri).build();//by default uses get method, builds a http get request to the site 
            HttpResponse<String> response = goCall.send(req, HttpResponse.BodyHandlers.ofString());
            
            
            
            return response.body();
            
        }//end sendGet
        
        /**
         * Uses a different method to aquire the responseCode form the webserver than sendGet
         * @return responseCode from the website
         * @throws java.io.IOException 
         */
        public int getResponseCode() throws IOException {//relies on net.http.HttpURLConncetion and net.URL
            HttpURLConnection connect = (HttpURLConnection) uri.toURL().openConnection();//takes the URI and converts it to a URL to be passed of type URL whiich is the used to open a conncetion of type HttpURLConnection to be loaded into the refernce con
            int responseCode = connect.getResponseCode();//get's the response code of the site ( ie: 200 ok,302 redirect, 404 error, 500 forbidden etc )
            //if(responseCode == 200){// for debugging and testing purposes to print out the request
            //can pass con into scanner to be used as an input srtream to parse the page line by line
            connect.disconnect();//closes connection
            return responseCode;
           
        }//end sendGet no parameters
        
        /**
         * if returns 200 status code, then returns true
         * @return true/false
         * @throws java.io.IOException
         */
        public boolean connectSuccess() throws IOException{
            return this.getResponseCode() == 200;
        }//end connecSuccess
        
        
        /**
         * parse page - parses the page looking for the specific tag data
         * If the divisions on the SAC website are updated, this method should catch the updated terms
         * splits by the superior tag of values, then by the interior tags
         * @return string[]
         * @throws IOException
         * @throws InterruptedException 
         */
        public String[] parsePage() throws IOException, InterruptedException{//note this method is simply in place to do one specific task, must be repurposed for multifunctionality
            
            //todo : debugg first half and figure out how to isolate using the HttpURLConncetion
//            HttpURLConnection con = (HttpURLConnection) uri.toURL().openConnection();//takes the URI and converts it to a URL to be passed of type URL whiich is the used to open a conncetion of type HttpURLConnection to be loaded into the refernce con
//            try {
//                Scanner in = new Scanner(con.getInputStream()).useDelimiter("<|>|<\\|\\n"); //creates an input stream from the request and loads it into scanner
//                //String body = this.sendGet("");//uses the sendGet method to populate response from body
//                //System.out.println(body);//print out the whole response
//                //System.out.println(body.replaceAll(">", ">\n"));//breaks up every tag onto a new line
//                for(int i = 0; (i < 1000) && in.hasNext(); i++)
//                    System.out.println(in.next().compareTo("h1 class=\"sac-rteElement-H1\"​​​​​​") + "\n" + in.next("<h1 class=\"sac-rteElement-H1\">​​​​​​​​​"));//prints each line with
//                
//            }//end try
//            catch ( IOException e ){//try and catch put in by the compiler
//                System.out.println("failed");
//                e.getStackTrace();
//            }//end catch
//          

            //after much trial and error, the following produces the list of divisions taken from the html code
            ////method two, sort of binary search:
            
            //variable declarations
            String divisions[] = new String[6];//creates an array called divisions and sets the size to be 6;
            String body = this.sendGet();
            //Scanner in = new Scanner(body).useDelimiter(">");
            String split01[] = body.split("<h1 class=\"sac-rteElement-H1\">");//splits 7 times using the delimeter
            //end variable declarations

            //divisions[0] = split01[1].substring(split01[1].indexOf(">") + 1 , split01[1].indexOf("</a>"));//sets it to the value in between the first > and  </a> after the split
            for( int i = 0, j =1; i < 6; i++, j++){//isolates the divisions and extracts them from the split request body
                divisions[i] = split01[j].substring(split01[j].indexOf(">") + 1 , split01[j].indexOf("</a>"));//sets it to the value in between the first > and  </a> after the split
                divisions[i] = divisions[i].replace("&amp;", "&");//replaces &amp; with &
                divisions[i] = divisions[i].replace("&#160;", " ");//replaces all char values of &#160; with a space
               //System.out.println(divisions[i]);
            }//end for            
            //debugging:
            //System.out.println(divisions[0]);
            //System.out.println(split01[1].indexOf(divisions[0]));
            //body = split01[1].split(divisions[0])[1];//splits at last accepted value
            
            return divisions;//returns formatted array
        }//end method
        
    }//end class webcrawler
    

}//end class assign 09
//EOF





/* Discussion Questions. 
* 
* How do you envision arrays? Or how would you describe them?
* 
*       The way I see arrays are like tables in math. Just like the table has a label and value and each one has rows and columns arrays have rows and columns.
*   multidimensional arrays are simply more complex tables and like the name implies multidimensional. In my head when I see a 1d array it is flat, and 2d it is still falt but spanning out
*   like a bar graph. 3d arrays are like cubes, 4d arrays are like mazes, and so forth. I picture an array as an actual space in existence. Each value and spot is a room. the more multidemensional it becomes
*   ,the more complex that room becomes. It evolves from being a flat room to a 3d room to a filing cabnit type room and so forth.
*
*
*
* Can you think of some applications where arrays are the appropriate data structure?  
*
*       One good example is Sorting; I feel sorting is a good example in which arrays are appropriate data structure, or when there is alot of automation that needs to be done. If you had to enter in every single value, and define a new variable name
*   for everysingle value, 1, that would take up alot of space in your program, 2, that would be very time consuming. I think arrays are appropriate data structures in graphical interfaces as well. Any time geometry is involved,
*   and as it sounds, multidemnsions, multidemnsional arrays may be appropriate if not the best data type for that problem/solution.
*/




/*statement of completion:
*
* Describe what portions of the assignment are done and complete.
*
*   To the best of my knowledge all parts of the assignment are done and complete. Only thing that may be missing may be the test case documentation.
*   In the assignment I used http methods in  order to get the request from the server, and then parse the request in order to find the most updated Division Names.
*   If this fails, the program resorts to the original provided. ( I use a connetion test method to check if the site is reachable through it's status code
*   Using the information gathered, the program then proceeds to itterate through the array with a for-each loop. Moving into part 2, where a loop adds the first tow ( previous 2 values ) in order
*   to find the current value of the array. Part 3 uses modulos to compute if a number is odd, and exit's the loop if it is, setting the value of the  array at that itteration to the loop. Part 4 uses
*   the DecimalFormat method in order to properly format the scientific notation to be at a precision of 2 decimals. It then prints out the values to the screen both in floating point notation and scientific notation
*
*
*What is missing? What caused the incompleteness.
*
*   To the best of my knowledge nothing is missing from the assignment. The only possible thing missing from the assignmnet, in my mind, is comments and extensive error documentation, along with test case documentation
*   Although I am trying to keep anything I delete in the code, some of the comments of my commented out code overcluttered the code and I deleted many of them to take a fresh take on the issue.
*   I didn't provide a menu and a secondary retrieval method for the aquiring of the division names needs work. These two are not required but incomplete because of current workload time constraints.
*
*How do you feel about the assignment or what did you learn while doing it?
*   
*   I really enjoyed the assignment. I learned how to use http methods and get connection. I learned about the existence of document builder's for DOM as well as package manager/project managers ( I think that's what it is called ?) such
*   as maven and girdle. I reinforced my skills with arrays, and clarified some things in that regard. This was a really fun assignment, I spent countless hours toiling away and researching to figure out how to parse the code ( without external help ).
*
*
*/