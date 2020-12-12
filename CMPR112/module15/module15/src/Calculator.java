/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
// Module15;

import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.math.*;

class Calculator implements ActionListener // Action Listener is a interface.
{
    JFrame f;
    JTextField t,h,hextx , octtx;
    JButton b1,b2,b3,b4,b5,b6,b7,b8,b9,b0,bdiv,bmul,bsub,badd,bdec,beq,bdel,bclr, hx, ot, tohx, help;
    JButton hexB[] = new JButton[6];
    static double a=0,b=0,result=0;
    static Hex ax = new Hex(), bx= new Hex();
    static String resultx = "";
    static int operator=0;
    static boolean hexidecimal = false;
    static boolean oct = false;

    Calculator()
    {
    f=new JFrame("Calculator");

    //https://chortle.ccsu.edu/Java5/Notes/chap56/ch56_9.html
    // f.setDefaultCloseOperation ( JFrame.DO_NOTHING_ON_CLOSE);

    //manually initializes each button ( this is very time consuming )
    //included a for loop to speed up the process for the new data
    t=new JTextField();
    h=new JTextField();
    hextx = new JTextField();
    octtx = new JTextField();
    b1=new JButton("1");
    b2=new JButton("2");
    b3=new JButton("3");
    b4=new JButton("4");
    b5=new JButton("5");
    b6=new JButton("6");
    b7=new JButton("7");
    b8=new JButton("8");
    b9=new JButton("9");
    b0=new JButton("0");
    for(int i = 0; i < hexB.length; i++){//initializes hex avaialable buttons
        hexB[i] = new JButton(String.valueOf((char)('A' + i)));
    }//end for
    bdiv=new JButton("/");
    bmul=new JButton("*");
    bsub=new JButton("-");
    badd=new JButton("+");
    bdec=new JButton(".");
    beq=new JButton("=");
    bdel=new JButton("Delete");
    bclr=new JButton("Clear");
    hx = new JButton("Hexidecimal");//hex switch
    ot = new JButton("Octal");//octal switch
    tohx = new JButton("to Hex");//conversion button
    help = new JButton("Help");//help button
    //Rectangle rect = new Rectangle(50,40);


    // 30,40 ( x, y ) cordinates on the screen.
    // Screen cordinate are 0 at the top of the screen and larger positive numbers as you go down.
    // Screen cordinate for the horizontal says the left margin is zero and increases as you you go to the right.
    // so 30,40 means 30 pixesl from the left. and 40 pixels down.
    
    //sets the positions of all the units on the calculator
    t.setBounds(30,40,280,30);
    hextx.setBounds(30,70 ,280,30);
    octtx.setBounds(30,100, 280,30);
    b7.setBounds(40,140,50,40);
    b8.setBounds(110,140,50,40);
    b9.setBounds(180,140,50,40);
    bdiv.setBounds(250,140,50,40);

    b4.setBounds(40,210,50,40);
    b5.setBounds(110,210,50,40);
    b6.setBounds(180,210,50,40);
    bmul.setBounds(250,210,50,40);

    b1.setBounds(40,280,50,40);
    b2.setBounds(110,280,50,40);
    b3.setBounds(180,280,50,40);
    bsub.setBounds(250,280,50,40);
    
    bdec.setBounds(40,350,50,40);
    b0.setBounds(110,350,50,40);
    beq.setBounds(180,350,50,40);
    badd.setBounds(250,350,50,40);
    
    
    for(int i = 3; i >= 0 ; i--)
        hexB[i].setBounds((40 + (i* 70)), 420, 50, 40);
    for(int i = hexB.length - 1; i > 3 ; i--)
        hexB[i].setBounds((40 + (i* 70)), 420, 50, 40);
    hx.setBounds(30, 490, 150, 40);
    bdel.setBounds(190,490,100,40);
    bclr.setBounds(290,490,100,40);
    ot.setBounds(40,570,100, 40);
    tohx.setBounds(150,570, 100, 40);
    h.setBounds(270,570 ,50 ,40 );
    help.setBounds(320,40,100, 40);
    
    //adding the buttons to the field
    f.add(t);
    f.add(hextx);
    f.add(octtx);
    for(int i = 0; i < hexB.length; i++)
        f.add(hexB[i]);
    f.add(b7);
    f.add(b8);
    f.add(b9);
    f.add(bdiv);
    f.add(b4);
    f.add(b5);
    f.add(b6);
    f.add(bmul);
    f.add(b1);
    f.add(b2);
    f.add(b3);
    f.add(bsub);
    f.add(bdec);
    f.add(b0);
    f.add(beq);
    f.add(badd);
    f.add(hx);
    f.add(ot);
    f.add(bdel);
    f.add(bclr);
    f.add(tohx);
    f.add(h);
    f.add(help);
    
    tohx.setActionCommand("hex");
    
    f.setLayout(null);
    f.setVisible(true);
    f.setSize(600,650);
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    //f.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
    f.setResizable(false);
    
    //setting tooltips for each of the buttons
    
    for(JButton hb : hexB)
       hb.setToolTipText(hb.getText() + " Hexidecimal value");
      
    //could have used a loop to set the values, but copied and pasted the buttons from below to save time for the already implemented format
    b1.setToolTipText("Button value 1");
    b2.setToolTipText("Button value 2");
    b3.setToolTipText("Button value 3");
    b4.setToolTipText("Button value 4");
    b5.setToolTipText("Button value 5");
    b6.setToolTipText("Button value 6");
    b7.setToolTipText("Button value 7");
    b8.setToolTipText("Button value 8");
    b9.setToolTipText("Button value 9");
    b0.setToolTipText("Button value 0");
    badd.setToolTipText("Addition +");
    bdiv.setToolTipText("Division /");
    bmul.setToolTipText("Multiplication *");
    bsub.setToolTipText("Subtraction -");
    bdec.setToolTipText("Decimal place .");
    beq.setToolTipText("Equals/ Evaluate");
    hx.setToolTipText("Convert to hexidecimal/ back to decimal format");
    bdel.setToolTipText("Delete the last entered value from the screen");
    bclr.setToolTipText("Clear the data input field");
    tohx.setToolTipText("Manipulates the text box next to it converting the value to hex and to decimal (vice-versa)");
    help.setToolTipText("Help button: click to open up a prompt about the calculator");
    ot.setToolTipText("Conver to octal/ back to decimal ");
    
    
    //adds action listeners for all the objects
    for(JButton hb : hexB)
        hb.addActionListener(this);
    b1.addActionListener(this);
    b2.addActionListener(this);
    b3.addActionListener(this);
    b4.addActionListener(this);
    b5.addActionListener(this);
    b6.addActionListener(this);
    b7.addActionListener(this);
    b8.addActionListener(this);
    b9.addActionListener(this);
    b0.addActionListener(this);
    badd.addActionListener(this);
    bdiv.addActionListener(this);
    bmul.addActionListener(this);
    bsub.addActionListener(this);
    bdec.addActionListener(this);
    beq.addActionListener(this);
    hx.addActionListener(this);
    bdel.addActionListener(this);
    bclr.addActionListener(this);
    tohx.addActionListener(this);
    h.addActionListener(this);
    ot.addActionListener(this);
    help.addActionListener(this);
    
    for(JButton hb : hexB )
        hb.setEnabled(hexidecimal);
    
    }//end calculator

    public void actionPerformed(ActionEvent e)
    {
    if(e.getSource()==hx){
        
        //there was an issue with the conversion with the added octal boolean, needs to be debugged
        //issue between octal and hex and hex to decimal
        //removed the ability to convert diretly from hex to decimal ( although the bug was fixed )
        //in order to convert from hex to octal must use decimal as a middle man
        //also need to add the functions for octal
        if(hexidecimal){//if the hexidecimal was already pressed
            hexidecimal = false;
            for(JButton hb : hexB )
                hb.setEnabled(hexidecimal);
            //hx.setText("Hexidecimal");
            if(!hextx.getText().isBlank())
                t.setText("" + ax.hx2D(hextx.getText()));
            bdec.setEnabled(!hexidecimal);
            b8.setEnabled(!oct);
            b9.setEnabled(!oct);
            bdec.setEnabled(!oct);
        }//end if
        else{//otherwise turn it on
            hexidecimal = true;
            
            for(JButton hb : hexB )
                hb.setEnabled(hexidecimal);
            //if(oct)//if coming from octal
              //  t.setText("");//zero out the text box
            oct = false;
            if(!t.getText().isBlank())
                ax.d2Hx(Integer.parseInt(t.getText()));
                hextx.setText("" + ax.getHex());
            //hx.setText("Decimal");
            bdec.setEnabled(!hexidecimal);
            b8.setEnabled(!oct);
            b9.setEnabled(!oct);
            bdec.setEnabled(!oct);
        }//end else

    }//end if
    
    if(e.getSource() == ot){
        if(oct){//if octal is true and clicked
            oct = false;
            for(JButton hb : hexB )
                hb.setEnabled(hexidecimal);
            b8.setEnabled(!oct);
            b9.setEnabled(!oct);
            bdec.setEnabled(!oct);
            if(!octtx.getText().isBlank())
                ax.o2D(octtx.getText());
                t.setText("" + ax.getDec() );
        }//end if
        else{//if octal is false and clicked
            oct = true;
            //if(hexidecimal){//if coming from hexidecimal
            //    t.setText("");//clear
            //}else{
               if(!t.getText().isBlank()){
                   ax.d2O(Integer.parseInt(t.getText()));
                   octtx.setText("" + ax.getOct());
               }
            //}
            hexidecimal = false;
            for(JButton hb : hexB )
                hb.setEnabled(hexidecimal);
            b8.setEnabled(!oct);
            b9.setEnabled(!oct);
            bdec.setEnabled(!oct);
        }//end else
    }//end if
    
    
    //the actions for all the other buttons
    if(e.getSource()==b1){
        if(oct)
            octtx.setText(octtx.getText().concat("1"));
        else if(hexidecimal)
            hextx.setText(hextx.getText().concat("1"));
        else
            t.setText(t.getText().concat("1"));
    }
    if(e.getSource()==b2){
        if(oct)
            octtx.setText(octtx.getText().concat("2"));
        else if(hexidecimal)
            hextx.setText(hextx.getText().concat("2"));
        else
            t.setText(t.getText().concat("2"));
    }
    if(e.getSource()==b3)
        {
        if(oct)
            octtx.setText(octtx.getText().concat("3"));
        else if(hexidecimal)
            hextx.setText(hextx.getText().concat("3"));
        else
            t.setText(t.getText().concat("3"));
    }
    if(e.getSource()==b4){
        if(oct)
            octtx.setText(octtx.getText().concat("4"));
        else if(hexidecimal)
            hextx.setText(hextx.getText().concat("4"));
        else
            t.setText(t.getText().concat("4"));
    }
    if(e.getSource()==b5){
        if(oct)
            octtx.setText(octtx.getText().concat("5"));
        else if(hexidecimal)
            hextx.setText(hextx.getText().concat("5"));
        else
            t.setText(t.getText().concat("5"));
    }
    if(e.getSource()==b6){
        if(oct)
            octtx.setText(octtx.getText().concat("6"));
        else if(hexidecimal)
            hextx.setText(hextx.getText().concat("6"));
        else
            t.setText(t.getText().concat("6"));
    }
    if(e.getSource()==b7){
        if(oct)
            octtx.setText(octtx.getText().concat("7"));
        else if(hexidecimal)
            hextx.setText(hextx.getText().concat("7"));
        else
            t.setText(t.getText().concat("7"));
    }

    if(e.getSource()==b8){
        if(hexidecimal)
            hextx.setText(hextx.getText().concat("8"));
        else
            t.setText(t.getText().concat("8"));
    }
    if(e.getSource()==b9){
        if(hexidecimal)
            hextx.setText(hextx.getText().concat("9"));
        else
            t.setText(t.getText().concat("9"));
    }
    if(e.getSource()==b0){
        if(hexidecimal)
            hextx.setText(hextx.getText().concat("0"));
        else
            t.setText(t.getText().concat("0"));
    }
    if(hexidecimal)
        for(JButton hb : hexB)
            if(e.getSource()==hb)
                t.setText(t.getText().concat(hb.getText()));
    
    //operators
    
    
    //decimal
    if(e.getSource()==bdec)
    t.setText(t.getText().concat("."));
    
    
    //addition
    if(e.getSource()==badd){
        if(hexidecimal){
            ax.hx2D(t.getText());
        }//end if
        else
            a=Double.parseDouble(t.getText());
    operator=1;
    t.setText("");
    }

    
    //substitution
    if(e.getSource()==bsub)
    {
        if(hexidecimal)
            ax.hx2D(t.getText());
        else
            a=Double.parseDouble(t.getText());
        operator=2;
    t.setText("");
    }

    
    //multiply
    if(e.getSource()==bmul)
    {
        if(hexidecimal)
            ax.hx2D( t.getText());
        else
            a=Double.parseDouble(t.getText());
        operator=3;
    t.setText("");
    }

    
    //divide
    if(e.getSource()==bdiv)
    {
        if(hexidecimal)
            ax.hx2D(t.getText());
        else
            a=Double.parseDouble(t.getText());  
        operator=4;
    t.setText("");
    }

    //most of the Hex object operation functions are done to and from the decimals and the result is the value which is converted for viewing
    //equals sign
    if(e.getSource()==beq){
        if(hexidecimal)
            bx.hx2D(t.getText());
        else if(oct)
            bx.o2D(t.getText());
        else
            b=Double.parseDouble(t.getText());

        switch(operator){//switch to check which operation was used
        case 1: 
            if(hexidecimal)
                resultx = ax.add(bx);
            else if(oct)
                resultx = ax.add(bx);
            else
                result=a+b;
        break;

        case 2: 
            if(hexidecimal)
                resultx = ax.sub(bx);
            else if(oct)
                resultx = ax.sub(bx);
            else
                result=a-b;
        break;

        case 3:
            if(hexidecimal)
                resultx = ax.mult(bx);
            else if (oct)
                resultx = ax.mult(bx);
            else
            result=a*b;
        break;

        case 4:
            if(hexidecimal)
                resultx = ax.div(bx);
            else if(oct)
                resultx = ax.div(bx);
            else
                result= a/b;
        break;

        default:
            result=0;
        }//end switch
        if(hexidecimal)
            t.setText(resultx);
        else if (oct)
            t.setText(ax.hx2O(resultx));
        else
            t.setText(""+result);
    }//end if

    //clear button
    if(e.getSource()==bclr){
        t.setText("");
        h.setText("");//clears the to hex/ to dec text field
    }//end if
    
    //delete button
    if(e.getSource()==bdel)
    {
    String s=t.getText();
    t.setText("");
    for(int i=0;i<s.length()-1;i++)
    t.setText(t.getText()+s.charAt(i));
    }
    
    //the to hex button for testign conversion
    if(e.getSource()==tohx){
        if(tohx.getActionCommand()=="hex"){//converts the value to hex
            tohx.setActionCommand("dec");
            tohx.setText("to dec");
            if(!h.getText().isBlank())
                h.setText(ax.d2Hx(Integer.parseInt(h.getText())));
        }//end if
        else{
            tohx.setActionCommand("hex");//converts the value to decimal
            tohx.setText("to hex");
            if(!h.getText().isBlank())
                h.setText("" + ax.hx2D(h.getText()));
        }//end else
           
    }//end if
    
    //the help button
    //when pressed produces a pop up help prompt.
    if(e.getSource()==help){
        String message = String.format("%s %n %-10s %70s %n %-10s %70s %n %-10s %70s %n %-10s %70s %n %s %n %s %n %s" ,"How to use the calculator:", "Hex:", "Press \'Hexidecimal\' to use the hexidecimal calculator", "Octal:", "Press \'Octal\' to use the Octal calculator, repress to switch back", "Decimal:", "Click on \'Decimal\' to switch back", "to hex/to dec:", "Converts the box next to it between hex and decimal","Hexidceimal is base 16", "Octal is base 8", "Decimal is base 10" );
        JOptionPane.showMessageDialog(null, message , "Help", JOptionPane.INFORMATION_MESSAGE);
        
        
        
    }//end if
    
    }


    
    
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

    public static void main(String...s){
        
    homeworkHeader("Calculator - GUI project 15");
        
    new Calculator(); // anoymous 
    //Hex a1 = new Hex(20);
    //System.out.println(a1.getHex());
    //System.out.println(a1.hx2D("FF"));
    System.gc();//cleans up left over data

    }//end main

    
    
    
    //the algorithm for the conversions is:
    //from decimal find the remainder from the base value then divide by the value and find the remander from the new value. Those remainders are the values desired for the conversion
    //to convert back, multiply each value by it's base raised to the n power.
    public static class Hex{
        private int dec = 0;
        private String hex = "";
        private int oct = 0;
        HashMap<Integer, String> hexadeci = new HashMap<Integer, String>();
        //HashMap<Integer, String> deci = new HashMap<Integer, String>();
        /**
         * initializes the hex alphabet
         */
        public Hex(){
            hexadeci.put( 0,"0");
            hexadeci.put( 1,"1");
            hexadeci.put( 2,"2");
            hexadeci.put( 3,"3");
            hexadeci.put( 4,"4");
            hexadeci.put( 5,"5");
            hexadeci.put( 6,"6");
            hexadeci.put( 7,"7");
            hexadeci.put( 8,"8");
            hexadeci.put( 9,"9");
            hexadeci.put( 10,"A");
            hexadeci.put( 11,"B");
            hexadeci.put( 12,"C");
            hexadeci.put( 13,"D");
            hexadeci.put( 14,"E");
            hexadeci.put( 15,"F");
        }//end constructor
        
        /**
         * Hex constructor
         * initializes the hex alphabet
         * and converts a decimal value to hexadecimal
         * @param decimal 
         */
        public Hex(int decimal){
            hexadeci.put( 0,"0");
            hexadeci.put( 1,"1");
            hexadeci.put( 2,"2");
            hexadeci.put( 3,"3");
            hexadeci.put( 4,"4");
            hexadeci.put( 5,"5");
            hexadeci.put( 6,"6");
            hexadeci.put( 7,"7");
            hexadeci.put( 8,"8");
            hexadeci.put( 9,"9");
            hexadeci.put( 10,"A");
            hexadeci.put( 11,"B");
            hexadeci.put( 12,"C");
            hexadeci.put( 13,"D");
            hexadeci.put( 14,"E");
            hexadeci.put( 15,"F");
            this.dec = decimal;
            d2Hx(decimal);

        }//end overloaded consuctor
        
        /**
         * Hex constructor
         * initializes the hex alphabet 
         * and converts a hexadecimal value to decimal value
         * @param hexi 
         */
        public Hex(String hexi){
            hexadeci.put( 0,"0");
            hexadeci.put( 1,"1");
            hexadeci.put( 2,"2");
            hexadeci.put( 3,"3");
            hexadeci.put( 4,"4");
            hexadeci.put( 5,"5");
            hexadeci.put( 6,"6");
            hexadeci.put( 7,"7");
            hexadeci.put( 8,"8");
            hexadeci.put( 9,"9");
            hexadeci.put( 10,"A");
            hexadeci.put( 11,"B");
            hexadeci.put( 12,"C");
            hexadeci.put( 13,"D");
            hexadeci.put( 14,"E");
            hexadeci.put( 15,"F");
            this.hex = hexi;
            hx2D(hexi);
        }//end public Hex
        
        //in the future could add another cosntructor for octals
        
        /**
         * converts from octal to hex using decimal as a stepping stone
         * @param octal
         * @return 
         */
        public String o2Hx(String octal){
            return d2Hx(o2D(octal));
            
        }//end o2Hx
        
        /**
         * hex to octal conversion
         * using decimal as a stepping stone
         * @param hex
         * @return 
         */
        public String hx2O(String hex){
            return d2O(hx2D(hex));
            
        }//end hx2O
        
        /**
         * converts octal to decimal
         * important function
         * @param octal
         * @return 
         */
        public int o2D(String octal){
            int decimal = 0;
            this.oct = Integer.parseInt(octal);
            for(int i = octal.length() -1, j = 0; i >= 0; i--, j++ ){//counts 
                int value = (Integer.parseInt(String.valueOf(octal.charAt(j))));
                decimal +=  value * Math.pow(8, i);
            }//end for
            this.dec = decimal;
            updateHx();
            return this.dec;
            
        }//o2D
        
        /**
         * converts decimal to octal
         * @param decimal
         * @return 
         */
        public String d2O(int decimal){
            ArrayList<Integer> ocR = new ArrayList<Integer>();
            String octal = "";//intializes octal string
            int value = decimal;//sets to value
            this.dec = decimal;//sets to global variable
            while(value != 0){//converts to octal
                ocR.add(value % 8);
                value /= 8;
            }//end while
            for(int i = ocR.size() - 1; i >= 0; i--)
                octal += "" + ocR.get(i);
            this.oct = Integer.parseInt(octal);
            return octal;
        }//end d2O
        
        /**
         * converts decimal to hex
         * @param decimal
         * @return 
         */
        public String d2Hx(int decimal){
            ArrayList<Integer> hex = new ArrayList<Integer>();
            String hexString = "";
            int value = decimal;
            this.dec = decimal;//setting the global decimal value

            while(value != 0){
                hex.add(value % 16);//gets the remainder and adds it to the hex ArrayList
                value /= 16;//chaves off the digit moving to the next one
            }//end while

            for(int i = hex.size()-1; i >= 0 ; i--){
                hexString += hexadeci.get(hex.get(i));//prints the hex ArrayList out backwards and gets the value of each value
            }//end for

            this.hex = hexString;
            return this.hex;
        }//end public dex2Hex    
    
        /**
         * converts hex to decimal
         * @param hexi
         * @return 
         */
        public int hx2D(String hexi){
            int decimal = 0;
            //System.out.println(hexi);
            this.hex = hexi;
            for(int j = hexi.length() -1; j >= 0; j-- ){
                int value = 0;
                switch(hexi.charAt(j)){
                
                case('0'):
                    
                    value = 0;
                    break;
                case('1'):
                            
                    value = 1;
                    break;        
                case('2'):
                              
                    value = 2;
                    break;            
                case('3'):
                              
                    value = 3;
                    break;                
                case('4'):
                              
                    value = 4;
                    break;                    
                case('5'):
                              
                    value = 5;
                    break;
                case('6'):
                            
                    value = 6;
                    break;        
                case('7'):
                              
                    value = 7;
                    break;            
                case('8'):
                              
                    value = 8;
                    break;               
                case('9'):
                             
                    value = 9;
                    break;                    
                case('A'):
                    
                    value = 10;
                    break;
                case('B'):
                            
                    value = 11;
                    break;        
                case('C'):
                               
                    value = 12;
                    break;            
                case('D'):
                               
                    value = 13;
                    break;                
                case('E'):
                               
                    value = 14;
                    break;                    
                case('F'):
                
                    value = 15;
                    break;
                default:
                    
                    value = 0;
                    break;
                }//end 
                
                
                
                //the switch provides an easier visual
                //the following code works:
                  
//                //System.out.println(hexi.charAt(j));//debugging
//                for(int i = 0; i < hexadeci.values().toArray().length; i ++){//searches for the value 
//                    if ((hexadeci.values().toArray()[i].equals(String.valueOf((hexi.charAt(j))))))
//                       value = i;// gets the value of the decimal 
//
//                    //System.out.println((hexadeci.get(i).equals(String.valueOf((hexi.charAt(j))))));//debugging
//                }//end for
                //System.out.println(value); //debugging
                //System.out.println((value * Math.pow(16, (hexi.length() -1) - j)));
                decimal += (value * Math.pow(16, (hexi.length() -1) - j));
                //System.out.println(decimal);
            }//end for
            this.dec = decimal;
            return decimal;
        }//end public Hx2D
        
        /**
         * returns the hex value of the hex object
         * @return 
         */
        public String getHex(){return this.hex;}//end getHex

        /**
         * returns the decimal value of the hex object
         * @return 
         */
        public int getDec(){ return this.dec;}//end getDec
        
        /**
         * returns the octal value of the hex object
         * @return 
         */
        public int getOct(){ return this.oct;}//end getOct
        
        /**
         * updates the value of the current loaded global variables. Dependent on dec
         */
        public void updateHx(){
            d2Hx(this.dec);
        }//end updateHx
        
        /**
         * updates the value of the current loaded global variables dependent on hex
         */
        public void updateD(){
            hx2D(this.hex);
            //o2D(String.valueOf(this.oct));
        }//end updateD
        
        /**
         * updates the value of the current loaded global variables, dependent on dec
         */
        public void updateO(){
            d2O(this.dec);
            //d2Hx(this.dec);
            
        }//end updateO
        
        
        //creating an overlaoded set of the Math functions
        /**
         * adds the decimal values of 2 Hex objects
         * @param b
         * @return 
         */
        public String add(Hex b){//b from y = ax + b
            this.dec += b.getDec();
            updateHx();
            updateO();
            return this.hex;
            
        }//end public add
        
        /**
         * overloaded add for decimal input
         * @param b
         * @return 
         */
        public String add(int b){//b from y = ax + b
            this.dec += b;
            updateHx();
            updateO();
            return this.hex;
            
        }//end public add
        
        /**
         * multiplies two hex objects together
         * @param b
         * @return 
         */
        public String mult(Hex b){
            this.dec *= b.getDec();
            updateHx();
            updateO();
            return this.hex;
        }//end mulit
        
        /**
         * overloaded multiply for decimal input
         * @param b
         * @return 
         */
        public String mult(int b){
            this.dec *= b;
            updateHx();
            updateO();
            return this.hex;
        }//end mulit
        
        /**
         * divide between hex objects
         * @param b
         * @return 
         */
        public String div(Hex b){
            this.dec /= b.getDec();
            updateHx();
            updateO();
            return this.hex;
        }//end div

        /**
         * divide between decimal
         * @param b
         * @return 
         */
        public String div(int b){
            this.dec /= b;
            updateHx();
            updateO();
            return this.hex;
        }//end div
        
        /**
         * subtract between hex objects
         * @param b
         * @return 
         */
        public String sub(Hex b){
            this.dec -= b.getDec();
            updateHx();
            updateO();
            return this.hex;
        }//end sub
        
        /**
         * overloaded subtract, for decimals
         * @param b
         * @return 
         */
        public String sub( int b){
            this.dec -= b;
            updateHx();
            updateO();
            return this.hex;
        }//end sub
        
        
        //more advanced mathematival functions which aren't present on the calculator but in place if the hex class is to be reused
        
        
        
        public String sqrt(){
            this.dec = (int) Math.sqrt(this.dec);
            updateHx();
            updateO();
            return this.hex;
        }//end sqrt
        
        public String cbrt(){
            this.dec = (int) Math.cbrt(this.dec);
            updateHx();
            updateO();
            return this.hex;
        }//end cbrt
        
        public String pow(int m){
            this.dec =(int) Math.pow(this.dec ,m);
            updateHx();
            updateO();
            return this.hex;
            
        }//end pow
        
        public String pow(Hex m){
            this.dec = (int) Math.pow(this.dec, m.getDec());
            updateHx();
            updateO();
            return this.hex;
        }//end pow
        
        
        public String mod(Hex b){
            this.dec %= b.getDec();
            updateHx();
            updateO();
            return this.hex;
        }//end mod
        
        
        public String mod(int b){
            this.dec %= b;
            updateHx();
            updateO();
            return this.hex;
        }//end mod
    }//end class hex



}//end classs




//statement of completion
/*
######################################3
Statement of completion:
######################################3

Describe what portions of the assignment are done and complete. 

    As far as I know all portions of the assignment are done and complete. I added the hexidecimal calculator, octal calcualtor, help button, tooltips, and a conversion feature to the calcualtor.
    I didn't do the recursive addition or more than 2 arguments per equation. The calcualtor is able to use the previous solution as the part of the next calucaltion by simple continuing after pressing enter.
    This is the case for hex and octal as well. I created a hex class and in it stored the values of all 3 to possible be used in the future. Granted I could of used on value and had that value converted, but I felt 
    it more appropriate to use 3 private values. This may not be advantageous from a storage perspective, but for this current use case it works. The code can easily be modified without storign these values at all. 
    I chose to store the three values since I wanted a easier recursive possibility for the future. 
  
What is missing? What caused the incompleteness.

    As far as I know nothing is missing. I modified the code that was provided in order to meet the assignment needs.
    The GUI might not be the most visually apealing but I feel like it has some value in it's button placement.

How do you feel about the assignment or what did you learn while doing it?
    
    I really liked this assignment. I worked on it for a decent amount of time. I enjoyed the conversions. I was considering adding a binary option as well, but felt that would add to much clutter 
    in the current format of the buttons. Another approach to the gui might have been one similiar to that of the temperature GUI where it shows all three values like the programming calculator in windows.
    I learned about the different uses and got practice with GUI implementation.
  


*/