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

    public static Integer arrayLength = 10;
    public static String[][] postCodes = new String[arrayLength][arrayLength];


    public static void main(String[] args) {
        System.out.println("Postal code lab 3");
        System.out.println(Arrays.toString(postCodes));
        System.out.println(ValidityCheck("A1A 1A1"));
    }
}