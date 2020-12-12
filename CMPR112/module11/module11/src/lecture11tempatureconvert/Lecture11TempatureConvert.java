
package lecture11tempatureconvert;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import javax.accessibility.*;

/**
*
* @author jkirs
*/
public class Lecture11TempatureConvert extends JFrame {

private JPanel inputOutputPanel;
// private JPanel outputPanel;
// private JButton inIsF;
// private JButton inIsC;
// private JButton inIsK;
private JLabel tempLabel; // Enter temp in appropriage box to convert

private JLabel fLabel;
private JLabel cLabel;
private JLabel kLabel;

private JTextField fTempText;
private JTextField cTempText;
private JTextField kTempText;

//private J
public Lecture11TempatureConvert() {
// Set the title
setTitle("My Temperature Converter ");
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
// Create a BorderLayout manager:
setLayout(new BorderLayout());

// Build the panels:
buildInputOutputPanel();

// Add the panels to the cntent pane:
add(inputOutputPanel, BorderLayout.CENTER);
//Pack and display the window:
pack();
setVisible(true);
}

private void buildInputOutputPanel() {
// Creat a panel
inputOutputPanel = new JPanel();

// Create a label.
tempLabel = new JLabel("Enter a tempature in the appropriate box. ");

inputOutputPanel.add(tempLabel);

fLabel = new JLabel("Farhenheit");
cLabel = new JLabel("Celius");
kLabel = new JLabel("Kelvin");

fTempText = new JTextField(12);
cTempText = new JTextField(12);
kTempText = new JTextField(12);

textListener tL = new textListener();
fTempText.setEditable(true);
//fTempText.addActionListener(new fListener());
fTempText.addActionListener(tL);
fTempText.setActionCommand("Farh Temp");

cTempText.setEditable(true);
// cTempText.addActionListener(new cListener());
cTempText.setActionCommand("Celc Temp");
//cTempText.addActionListener(new textListener () );
cTempText.addActionListener(tL);

kTempText.setEditable(true);
kTempText.setActionCommand("Kelv Temp");
kTempText.addActionListener(tL);

// fLabel.setLabelFor(fTempText);
// cLabel.setLabelFor(cTempText);
// kLabel.setLabelFor(kTempText);

// inputOutputPanel.add(fLabel);
// inputOutputPanel.add(cLabel);
// inputOutputPanel.add(kLabel);
//
// inputOutputPanel.add(fTempText);
// inputOutputPanel.add(cTempText);
// inputOutputPanel.add(kTempText);


inputOutputPanel.add(fLabel);
inputOutputPanel.add(fTempText);
inputOutputPanel.add(cLabel);
inputOutputPanel.add(cTempText);
inputOutputPanel.add(kLabel);
inputOutputPanel.add(kTempText);

}

// class fListener implements ActionListener {
//
// public void actionPerformed(final ActionEvent e)
// {
//
//
// String newData = fTempText.getText();
// double farhTemp = Double.parseDouble(newData);
// double Celcius = ((farhTemp - 32.0) * 5.0 / 9.0);
// double Kelvin = Celcius + 273.15;
// String updateTemp = String.valueOf(Celcius);
// cTempText.setText(updateTemp);
// updateTemp = String.valueOf(Kelvin);
// kTempText.setText(updateTemp);
// }
// }
//
// class cListener implements ActionListener {
//
// public void actionPerformed(final ActionEvent e) {
// String newData = cTempText.getText();
// double CelTemp = Double.parseDouble(newData);
// double Farh = ((CelTemp * 9.0 / 5.0) + 32.0);
// double Kelvin = CelTemp + 273.15;
// String updateTemp = String.valueOf(Farh);
// fTempText.setText(updateTemp);
// updateTemp = String.valueOf(Kelvin);
// kTempText.setText(updateTemp);
// }
// }
private class textListener implements ActionListener { // implemnts implements a 'interface'

public void actionPerformed(final ActionEvent e) {
final String s = e.getActionCommand();
System.out.println ( " the getActionCommand ( ) = " + s);
if (s == "Farh Temp") {
String newData = fTempText.getText();
double farhTemp = Double.parseDouble(newData);
double Celcius = ((farhTemp - 32.0) * 5.0 / 9.0);
double Kelvin = Celcius + 273.15;
String updateTemp = String.valueOf(Celcius);
cTempText.setText(updateTemp);
updateTemp = String.valueOf(Kelvin);
kTempText.setText(updateTemp);
}

if (s == "Celc Temp") {

String newData = cTempText.getText();
double CelTemp = Double.parseDouble(newData);
double Farh = ((CelTemp * 9.0 / 5.0) + 32.0);
double Kelvin = CelTemp + 273.15;
String updateTemp = String.valueOf(Farh);
fTempText.setText(updateTemp);
updateTemp = String.valueOf(Kelvin);
kTempText.setText(updateTemp);
}

if (s == "Kelv Temp") {

String newData = kTempText.getText();
double KelvinTemp = Double.parseDouble(newData);

double Celcius = KelvinTemp - 273.15;
double Farh = ((Celcius * 9.0 / 5.0) + 32.0);

String updateTemp = String.valueOf(Farh);
fTempText.setText(updateTemp);

updateTemp = String.valueOf(Celcius);
cTempText.setText(updateTemp);
}//end if
}//end action performed
}//end private class

// public void actionPreformed(ActionEvent e) {
//
// }
/**
* @param args the command line arguments
*/
public static void homeworkHeader(String title) {
/**
* @param String is the title to give the program/project
*/
homeworkHeader();
System.out.println("Project Title : " + title);
}

public static void homeworkHeader() {
/**
* @param no parameters; output of lines of data that are constant
* through the semester. identifies the class, instructor, student, etc.
*/
System.out.println("Ticket : 86713 ");
System.out.println("Class : CMPR 112 ");
System.out.println("Student Name : Joel Kirscher ");
System.out.println("Instructor Name : Joel Kirscher ");
System.out.println(" ");
}

public static void main(String[] args) {
// TODO code application logic here
homeworkHeader("GUI Temperature Converter");
new Lecture11TempatureConvert();

}

}//end public class