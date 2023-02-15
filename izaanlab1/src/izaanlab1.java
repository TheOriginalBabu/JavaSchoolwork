/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.util.Scanner;

/**
 *
 * @author Izaan Syed
 * @date Feb. 14, 2023
 * @ProjectName Date Analyzer
 * @Description First lab, takes date input then returns date info
 */

public class izaanlab1 {
    public static Scanner scan = new Scanner(System.in);
    public static void main(String[] args) {
     
    System.out.println("Please insert the Month");        
    String inputMonth = scan.nextLine();
    Integer inputMonthInteger = Integer.valueOf(inputMonth); // convert to integer
    
    if (inputMonthInteger < 1 || Integer.parseInt(inputMonth)> 12){ // range of acceptable months
        System.out.println("invalid month");
    }

    //-------------------------
    System.out.println("Please insert the Day");        
    String inputDay = scan.nextLine();
    Integer inputDayInteger = Integer.valueOf(inputDay); // convert to integer
    
    if (inputDayInteger < 1){ // lower limit validity check for the "day" input,
        System.out.println("invalid day (hit lower limit)");
    }
    
    //--------------------------
    String seasonOfDate = "notset";
    
    switch (inputMonthInteger) { // Switchcase to define seasons and upper limit validity check of "day" input.
        case 1 -> { //January
            if (inputDayInteger > 31)  // set to last day of month
                System.out.println("invalid day (hit upper limit)");
            else
                seasonOfDate = "Winter"; // entire month is winter, so no need for day check
            }
        case 2 -> { //Feb
            if (inputDayInteger > 29) // set to last day of month (leap year accounted for)
                System.out.println("invalid day (hit upper limit)");
            else
                seasonOfDate = "Winter";
            }
        case 3 -> { //Mar
            if (inputDayInteger > 31) // set to last day of month
                System.out.println("invalid day (hit upper limit)");
            else if (inputDayInteger < 21) // set to last  day of initial season
                seasonOfDate = "Winter";
            else
                seasonOfDate = "Spring";
            }
        case 4 -> { //Apr
            if (inputDayInteger > 30)
                System.out.println("invalid day (hit upper limit)");
            else
                seasonOfDate = "Spring";
            }
        case 5 -> { //May
            if (inputDayInteger > 31)
                System.out.println("invalid day (hit upper limit)");
            else
                seasonOfDate = "Spring";
            }
        case 6 -> { //June
            if (inputDayInteger > 30)
                System.out.println("invalid day (hit upper limit)");
            else if (inputDayInteger < 21)
                seasonOfDate = "Spring";
            else
                seasonOfDate = "Summer";            
            }
        case 7 -> { //July
            if (inputDayInteger > 31)
                System.out.println("invalid day (hit upper limit)");
            else
                seasonOfDate = "Summer";              
            }
        case 8 -> { //August
            if (inputDayInteger > 31)
                System.out.println("invalid day (hit upper limit)");
            else
                seasonOfDate = "Summer";              
            }
        case 9 -> { // September
            if (inputDayInteger > 30)
                System.out.println("invalid day (hit upper limit)");
            else if (inputDayInteger < 21)
                seasonOfDate = "Summer";
            else
                seasonOfDate = "Fall";     
            }
        case 10 -> { //October
            if (inputDayInteger > 31)
                System.out.println("invalid day (hit upper limit)");
            else
                seasonOfDate = "Fall";  
            }
        case 11 -> { //November
            if (inputDayInteger > 31)
                System.out.println("invalid day (hit upper limit)");
            else
                seasonOfDate = "Fall";  
            }
        case 12 -> { //December
            if (inputDayInteger > 31)
                System.out.println("invalid day (hit upper limit)");
            else if (inputDayInteger < 21)
                seasonOfDate = "Fall";
            else
                seasonOfDate = "Winter";                 
            }            
    }
    
    switch (inputMonthInteger) {
        case 1 -> {
            switch (inputDayInteger) {
                case 1 -> {
                    System.out.println("new years day");
                }
                case 5 -> {
                    System.out.println("my birthday");
                }
            }
        }
        case 2 -> {
            switch (inputDayInteger) {
                case 4 -> {
                    System.out.println("world cancer day");
                }
                case 14 -> {
                    System.out.println("valentines day");
                }
                case 29 -> {
                    System.out.println("leap year day");
                }
            }
        }
        default -> {
                System.out.println("boring day");
            }
    }
    System.out.println(seasonOfDate);            
   
   
    
    //---------------------------------
    
    
    
 
    //Integer.parseInt(inputDay);
    }
}