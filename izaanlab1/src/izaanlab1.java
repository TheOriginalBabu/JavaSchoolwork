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
     
    System.out.println("Date analyzer program - enter a date and it will be analyzed!");     
    
    //--------------------------        
    
    System.out.println("Please insert the numerical integer value of a Month");        
    String inputMonth = scan.nextLine();
    Integer inputMonthInteger = Integer.valueOf(inputMonth); // Convert month to integer
    
    if (inputMonthInteger < 1 || Integer.parseInt(inputMonth)> 12){ // Check if input is in range of acceptable months
        System.out.println("invalid month");
        System.exit(-1);
    }
    
    System.out.println("Please insert the numerical integer value of the Day");        
    String inputDay = scan.nextLine();
    Integer inputDayInteger = Integer.valueOf(inputDay); // Convert day to integer
    
    if (inputDayInteger < 1){ // Check if input is within the LOWER limit range of acceptable days
        System.out.println("invalid day (hit lower limit)");
        System.exit(-1);
    }
    
    //--------------------------    
    
    String monthOfDate = "unknown month"; // necessary to convert month integer to string
    String seasonOfDate = "unknown season";
    String holidayOfDate = "unknown holiday"; 
    
    switch (inputMonthInteger) { // Switchcase to define seasons and upper limit validity check of "day" input.
        case 1 -> { // January
            monthOfDate = "January";
            if (inputDayInteger > 31)  // Set to last day of month (define upper limit)
                System.out.println("invalid day (hit upper limit)");
            else
                seasonOfDate = "Winter"; // entire month is winter, so no need for day check
            }
        case 2 -> { // February
            monthOfDate = "February";
            if (inputDayInteger > 29) // set to last day of month (leap year accounted for)
                System.out.println("invalid day (hit upper limit)");
            else
                seasonOfDate = "Winter";
            }
        case 3 -> { //March
            monthOfDate = "March";
            if (inputDayInteger > 31) // set to last day of month
                System.out.println("invalid day (hit upper limit)");
            else if (inputDayInteger < 21) // set to last  day of initial season
                seasonOfDate = "Winter";
            else
                seasonOfDate = "Spring";
            }
        case 4 -> { // April
            monthOfDate = "April";
            if (inputDayInteger > 30)
                System.out.println("invalid day (hit upper limit)");
            else
                seasonOfDate = "Spring";
            }
        case 5 -> { // May
            monthOfDate = "May";
            if (inputDayInteger > 31)
                System.out.println("invalid day (hit upper limit)");
            else
                seasonOfDate = "Spring";
            }
        case 6 -> { // June
            monthOfDate = "June";
            if (inputDayInteger > 30)
                System.out.println("invalid day (hit upper limit)");
            else if (inputDayInteger < 21)
                seasonOfDate = "Spring";
            else
                seasonOfDate = "Summer";            
            }
        case 7 -> { // July
            monthOfDate = "July";
            if (inputDayInteger > 31)
                System.out.println("invalid day (hit upper limit)");
            else
                seasonOfDate = "Summer";              
            }
        case 8 -> { // August
            monthOfDate = "August";
            if (inputDayInteger > 31)
                System.out.println("invalid day (hit upper limit)");
            else
                seasonOfDate = "Summer";              
            }
        case 9 -> { // September
            monthOfDate = "September";
            if (inputDayInteger > 30)
                System.out.println("invalid day (hit upper limit)");
            else if (inputDayInteger < 21)
                seasonOfDate = "Summer";
            else
                seasonOfDate = "Fall";     
            }
        case 10 -> { // October
            monthOfDate = "October";
            if (inputDayInteger > 31)
                System.out.println("invalid day (hit upper limit)");
            else
                seasonOfDate = "Fall";  
            }
        case 11 -> { // November
            monthOfDate = "November";
            if (inputDayInteger > 31)
                System.out.println("invalid day (hit upper limit)");
            else
                seasonOfDate = "Fall";  
            }
        case 12 -> { //December
            monthOfDate = "December";
            if (inputDayInteger > 31)
                System.out.println("invalid day (hit upper limit)");
            else if (inputDayInteger < 21)
                seasonOfDate = "Fall";
            else
                seasonOfDate = "Winter";                 
            }            
    }
    
    switch (inputMonthInteger) { // Determines holiday on date
        case 1 -> { // January
            switch (inputDayInteger) {
                case 1 -> {
                    holidayOfDate = ("New Years Day");
                }
                case 5 -> {
                    holidayOfDate = ("Izaan's birthday");
                }
            }
        }
        case 2 -> { // February
            switch (inputDayInteger) {
                case 4 -> {
                    holidayOfDate = ("World Cancer Day");
                }
                case 14 -> {
                    holidayOfDate = ("Valentines Day");
                }
                case 29 -> {
                    holidayOfDate = ("Leap Year Day");
                }
            }
        }
        default -> {
                holidayOfDate = ("no particular holiday");
            }
    }
   
    System.out.println("The date you entered was " + monthOfDate + " " + inputDay);
    System.out.println("The season of the date is " + seasonOfDate);
    System.out.println("This date corresponds to " + holidayOfDate);

    //Integer.parseInt(inputDay);
    }
}