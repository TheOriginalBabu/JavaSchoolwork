/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.util.Scanner;

/**
 *
 * @author Izaan Syed
 * @date Feb. 22, 2023
 * @ProjectName izaanLab2
 * @Description Loop lab
 */

public class izaanLab2 {
    public static Scanner scan = new Scanner(System.in);
    
    public static void main(String[] args) {
    System.out.println("Enter corresponding integer (1 = Postal code, 2 = Multiplication table)");
    while (true) {
    String userSelection = scan.nextLine();
    if (Integer.valueOf(userSelection) == 1 || Integer.valueOf(userSelection) == 2)  {
        break;       
    }
    else;
        System.out.println("Bad number idiot");
    }
    }
}