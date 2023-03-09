/**
 *
 * author Izaan Syed
 * date March. 7, 2023
 * ProjectName IzaanLab3
 * Description Complicated lab
 */

import java.util.Scanner;
import java.util.*;

public class IzaanLab3 {
    public static boolean isInteger(String check) { // Simple method to check if input is an integer, based off https://stackoverflow.com/questions/1102891/how-to-check-if-a-string-is-numeric-in-java
        try {
            Integer.parseInt(check);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    public static Boolean ValidityCheck(String inputPostalCode) {
        System.out.println("Postal Code Validity Check for " + inputPostalCode);
        boolean validFormat = true; // Boolean used to break loop if postal code is valid
        String[] inputPostalCode2 = inputPostalCode.split(""); // Splits postal code string into array of characters that can be referenced easily in value checks
        // Format Checks
        if (inputPostalCode.length() > 7) {
            System.out.println("your postal code was too long");
            validFormat = false;
        }
        if (inputPostalCode.length() < 7) {
            System.out.println("your postal code was too short");
            validFormat = false;
        }
        if (!inputPostalCode2[3].equals(" ")) {
            System.out.println("your postal code does not has a space separating the first and second half");
            validFormat = false;
        }
        // Validity Checks
        if (isInteger(inputPostalCode2[0])) {
            System.out.println("your postal code has a number in the first spot");
            validFormat = false;
        }
        if (!isInteger(inputPostalCode2[1])) {
            System.out.println("your postal code has a letter in the second spot");
            validFormat = false;
        }
        if (isInteger(inputPostalCode2[2])) {
            System.out.println("your postal code has a number in the third spot");
            validFormat = false;
        }
        if (!isInteger(inputPostalCode2[4])) {
            System.out.println("your postal code has a letter in the fourth spot");
            validFormat = false;
        }
        if (isInteger(inputPostalCode2[5])) {
            System.out.println("your postal code has a number in the fifth spot");
            validFormat = false;
        }
        if (!isInteger(inputPostalCode2[6])) {
            System.out.println("your postal code has a letter in the sixth spot");
            validFormat = false;
        }

        if (validFormat) { // Loop break if postal code is valid
            System.out.println("Your postal code fits all conventions and is valid");
            return true;
        } else {           // Error message if postal code is invalid
            System.out.println("Your postal code is invalid. Please fix above errors and try again");
            return false;
        }
    }

    public static String[][] postCodes = new String[10][10];

    //todo code program to add postal codes (alongside street address) from user input to postCodes 2d Array database
    public static void add() {
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter your postal code: ");
        String newCode = input.nextLine();
        if (ValidityCheck(newCode)) {
            System.out.println("Please enter the new address: ");
            String newAddress = input.nextLine();
            if (check(newAddress)) {
                System.out.println("Address already exists in database");
            }
            else
                for (int row = 0; row < postCodes.length; row++) {
                    if (postCodes[row][0] == null) {
                        postCodes[row][0] = newCode;
                        postCodes[row][1] = newAddress;
                        break;
                    }
            }
        }
    }
    public static void delete() {
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter the address you wish to delete: ");
        String deleteAddress = input.nextLine();
        for (int row = 0; row < postCodes.length; row++) {
            if (postCodes[row][1] != null && postCodes[row][1].equals(deleteAddress)) {
                postCodes[row][0] = null;
                postCodes[row][1] = null;
                break;
            }
        }
    }
    public static void edit() { //method to allow the user to edit the postal code of a single address
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter the address you wish to edit: ");
        String editAddress = input.nextLine();
        for (int row = 0; row < postCodes.length; row++) {
            if (postCodes[row][1] != null && postCodes[row][1].equals(editAddress)) {
                System.out.println("Please enter the new postal code: ");
                String newCode = input.nextLine();
                if (ValidityCheck(newCode)) {
                    postCodes[row][0] = newCode;
                    break;
                }
            }
        }
    }

    //todo code function to check if specified street address is already in database
    public static boolean check(String address) {
        for (String[] postCode : postCodes) {
            if (postCode[1] != null && postCode[1].equals(address)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println("Postal code lab 3");
        //todo implement main menu loop that allows user to choose between add, delete, edit, and print
        while(true){
            Scanner input = new Scanner(System.in);
            System.out.println("Please enter a number to select an option: ");
            System.out.println("1. Add");
            System.out.println("2. Delete");
            System.out.println("3. Edit");
            System.out.println("4. Print");
            System.out.println("5. Exit");
            int choice = input.nextInt();
            switch (choice){
                case 1:
                    add();
                    break;
                case 2:
                    delete();
                    break;
                case 3:
                    edit();
                    break;
                case 4:
                    for (String[] postCode : postCodes) {
                        if (postCode[0] != null) System.out.println(postCode[0] + " " + postCode[1]);
                    }
                    break;
                case 5:
                    break;
                default:
                    System.out.println("Invalid input");
            }
        }
        //for (String[] postCode : postCodes) {
        //    if (postCode[0] != null) System.out.println(postCode[0] + " " + postCode[1]);
        }
}