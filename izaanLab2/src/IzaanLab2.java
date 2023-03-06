/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.util.Scanner;

/**
 *
 * author Izaan Syed
 * date Feb. 22, 2023
 * ProjectName IzaanLab2
 * Description Loop lab
 */

public class IzaanLab2 {
    public static Scanner scan = new Scanner(System.in);
    public static int intUserSelection; // program selection

    public static boolean isInteger(String str) { // Simple method to check if input is an integer, based off https://stackoverflow.com/questions/1102891/how-to-check-if-a-string-is-numeric-in-java
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static void main(String[] args) {
        while (true) {     // Outer loop encasing all subprograms to allow user to return to main menu after each subprogram

            while (true) { // Main menu loop
                System.out.println("Welcome to Izaan's postal code and multiplication table program");
                System.out.println("Enter corresponding integer to choose your option (1 = Postal code, 2 = Multiplication table, 3 = Quit)");
                try {
                    intUserSelection = Integer.parseInt(scan.nextLine());
                    if (intUserSelection == 1 || intUserSelection == 2 || intUserSelection == 3) break;                     // Breaks loop once user input is valid
                    System.out.println("The integer you entered was not valid. Please enter a valid integer (1, 2, or 3)"); // Error message when user input is an integer, but does not correspond to switch statement
                } catch (Exception e) {
                    System.out.println("You did not enter an integer. Please enter a valid integer (1, 2, or 3)");          // Error message when user input is not an integer (and therefore cannot correspond to switch statement)
                }
            }

            switch (intUserSelection) { // Switch case that runs the corresponding subprogram based on user input. No default case as it is already error trapped in previous loop try/catch.
                case 1 -> { // Postal code program
                    while (true) {
                        System.out.println("Postal Code Validity Check");
                        System.out.println("Enter a postal code in the format (A1A 1A1)");
                        boolean validFormat = true; // Boolean used to break loop if postal code is valid
                        String inputPostalCode = (scan.nextLine());
                        String[] inputPostalCode2 = inputPostalCode.split(""); // Splits postal code string into array of characters that can be referenced easily in value checks

                        // Checks if postal code format is correct
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

                        // Checks if postal code numbers and letters are in correct spot
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

                        System.out.println("Your postal code was " + inputPostalCode);

                        if (validFormat) { // Loop break if postal code is valid
                            System.out.println("Your postal code fits all conventions and is valid");
                            break;
                        } else {          // Error message if postal code is invalid
                            System.out.println("Your postal code is invalid. Please fix above errors and try again");
                        }
                    }

                }

                case 2 -> { // Multiplication program
                    while (true) {
                        System.out.println("Multiplication program. Enter a number to see its multiplication table up to 12.");
                        try {
                            String inputMultiplication = (scan.nextLine());
                            double number = Double.parseDouble(inputMultiplication);
                            for (int i = 1; i <= 12; i++) {
                                System.out.println(number + " x " + i + " = " + (i * number)); // Calculates multiplication value within print statement, loops 12 times (for up to x12 multiplication table)
                            }
                            break;
                        } catch (Exception e) {
                            System.out.println("You did not enter a valid number.");           // number has to be less than 169999999999999993883079578865998174333346074304075874502773119193537729178160565864330091787584707988572262467983188919169916105593357174268369962062473635296474636515660464935663040684957844303524367815028553272712298986386310828644513212353921123253311675499856875650512437415429217994623324794855339589632
                        }
                    }
                }

                case 3 -> { // Exit program
                    System.out.println("You have chosen to exit the program. Have a good day!");
                    System.exit(0); // No error code, so program exits normally
                }
            }
        }
    }
}