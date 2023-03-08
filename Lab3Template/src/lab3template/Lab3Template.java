/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

package lab3template;

import java.util.Scanner;

/**
 *
 *@author ljohnstonflanagan
* @date Mar. 7, 2023
* @projectname Lab3Template
* @Description: This is a code skeleton for Lab 3
 */
public class Lab3Template {
    public static String[][] postCodes = new String[10][10];
    public static void menu(){
        //ASK THE USER WHAT OPTION TO DO
        //CALL THE REQUIRED METHOD
    }
    public static void add(){
        //This method allows the user to add postal codes.
        String newCode = enterCode(); //this vaild
        System.out.println("Please enter the new address: ");
        Scanner input = new Scanner (System.in);
        String newAddress = input.nextLine(); 
        //ALSO ENSURE THAT WE ARE NOT GOING OVER THE LIMIT OF 10
        
        //BEFORE YOU ADD, USE DUPCHECK TO SEE IF MAKE A NEW ROW
        
        //WHEN YOU ADD DO ONE OF:
            //ADD TO NEXT BLANK?
            //ADD TO END OF ROW? 
    }
    public static String enterCode(){
        //This method allows the user to enter a postal code
        Scanner input = new Scanner (System.in);
        String newCode = "";
        do{
            System.out.println("Please enter your postal code: ");
            newCode = input.nextLine();
        }while (verifyCode(newCode) == false);
        return newCode;
                 
    }
    public static boolean verifyCode(String code){
        boolean vaild = true;
        //ADD IMPLENTMENTATION FOR CHECKING THE CODES
            //SEE LAB 2
        return vaild; 
    }
    public static void delete(){
        //This method will look through the 2D and delete
        //the address that the user choices.
        String deleteCode = enterCode(); // this will be vaild
        if (dupCodeCheck(deleteCode)){
            String newCode = enterCode(); //this vaild
            System.out.println("Please enter the address you want delete: ");
            //CONDSIDER THE ADDRESS NOT EXISTING
            Scanner input = new Scanner (System.in);
            String deleteAddress = input.nextLine(); 
            for (int row = 0 ; row < postCodes.length;row++){
                if (postCodes[row].equals(newCode)){
                    for (int col =0; col> postCodes[row].length;col++){
                        //DELETE THE ADDRESS
                            //MOVE EVERYTHING TO LEFT
                            //LEAVE BLANK
                    }//end of col
                }//end of if
            }//end of row
        }//end of vaild postal code
    }//end of delete
    
    public static boolean dupCodeCheck(String code){
        //this method will look for an existing postal code
        //and return true if the postalcode already exists
        //and false if it does not.
        for (int row = 0; row < postCodes.length;row++){
            if (postCodes[row].equals(code)){
                return true; //code found
            }//end of if
        }//end of for
        return false; // no code found
    }//end of dupCodeCheck
    
    
    public static void Edit(){
        //ENTER AN ADDRESS
        //CALL DELETE ON THAT ADDRESS
        //CALL ADD TO ADD A NEW ONE
    }//end of edit
    
    public static void display(){
        //This will display the full post code array
        for (int row = 0; row<postCodes.length;row++){
            System.out.println();
            for (int col = 0 ; col < postCodes[row].length;col ++){
                System.out.print(postCodes[row][col]);
            }//end of col
        }//end of row
    }//end of display
    
    public static void main(String[] args) {
        while(true){
            menu();
        }//end of while

    }//wnd of main

}//end of class
