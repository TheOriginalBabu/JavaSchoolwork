/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author Izaan Syed
 * @date Feb. 22, 2023
 * @ProjectName izaanLab2
 * @Description Loop lab
 */

public class IzaanLab2 {
    public static Scanner scan = new Scanner(System.in);
    public static int intUserSelection; // program selection
    
    public static void main(String[] args) {
    
    System.out.println("Enter corresponding integer (1 = Postal code, 2 = Multiplication table, 3 = Quit)");

    while (true) {
        String userSelection = (scan.nextLine());
        intUserSelection = Integer.parseInt(userSelection);
        if (intUserSelection == 1 || intUserSelection == 2 || intUserSelection == 3) break;
        System.out.println("Bad number u idiot");
        }

    switch(intUserSelection){
        case 1 ->{
            System.out.println("postal code program");
            String inputPostalCode = (scan.nextLine());
            String[] inputPostalCode2 = inputPostalCode.split("");
            System.out.println(Arrays.toString(inputPostalCode2));
            if (inputPostalCode.length() > 6) {
                System.out.println("your postal code was too long");
            }
            System.out.println("your postal code was " + inputPostalCode);
        }
        case 2 ->{
            System.out.println("multiplication program");
            String inputMultiplication = (scan.nextLine());
            System.out.println("you wanted to multiply " + inputMultiplication);
        }
        case 3 ->{
            System.out.println("u quitted");
            System.exit(0);
        }
    }
    }
}