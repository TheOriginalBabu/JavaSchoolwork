
package variablesiopractice;

import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 * @author $Lucas Johnston-Flanagan
 * @date 10-Feb-2022
 * @filename VariablesIOPractice.java
 * @description A program to practice java input/output and variable usage;
 */
public class VariablesIOPractice {

    public static void main(String[] args) {
        /** 
         * Use the code from the lesson yesterday (on D2L)
         * as a reference to complete the practice tasks below.
         * You can also ask your classmates to help if you get stuck :)
         */
        
        /**
         * Practice 1: Variables & Println
         * Create variables using appropriate data types and names for the following values
         * Use System.out.println to display them each to the console.
         * 34.53 -- completed below as an example
         * -7
         * Hello
         * g
         * true
         */
        double practice1Var1 = 34.53;
        int practice1Var2 = -7;
        String practice1Var3 = "Hello";
        
        System.out.println("Practice 1 variable 1 is: " + practice1Var1);
        System.out.println("Practice 1 variable 2 is: " + practice1Var2);
        System.out.println("Practice 1 variable 3 is: " + practice1Var3);
        
        /**
         * Practice 2: Casting & Printf
         * Convert or cast the variables you created above in the following ways. 
         * Use System.out.printf to display them each to the console, aligned to the right in a table.
         * See D2L for the printf reference guide.
         * 34.53 --> int -- completed below as an example
         * -7    --> double 
         * Hello --> boolean
         * g     --> String
         * true  --> String
         */
        int practice2Var1 = (int)practice1Var1;
        System.out.printf("Practice 2 variable 1 is: %10d \n", practice2Var1);
        
        
        /**
         * Practice 3: Scanner Input
         * Use Scanners to take in user input values for the following data types
         * Keep in mind the Scanner bug mentioned in the lesson!
         * Output all of the inputs in a single line at the end of the inputs.
         * Boolean -- Completed as an example below
         * Integer
         * Double
         * String
         */
        Scanner inputScanner = new Scanner(System.in);
        System.out.print("Please enter a boolean value (true or false)");
        boolean practice3Var1 = inputScanner.nextBoolean();
        
        System.out.println("The inputs that recorded are: " + practice3Var1);
        /**
         * Practice 4: Dialog Boxes
         * Record input from the user using a pop up dialog box for each of the following
         * datatypes, then report them back to the user using a single pop up dialog box at the end.
         * NOTE: Sometimes the popups are hidden behind netBeans. Look out for them.
         * String -- Completed as an example below
         * Integer
         * Double
         * Yes/No Check (look online for the syntax for this option)
         */
        String dialogInput = JOptionPane.showInputDialog("Please enter a String");
        
        JOptionPane.showMessageDialog(null,"I recorded the following inputs:  " + dialogInput );
    
    }//end of main

}//end of class
