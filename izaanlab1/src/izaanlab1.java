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
    Integer inputMonthInteger = Integer.parseInt(inputMonth); //casting
    System.out.println(inputMonthInteger);
    if (inputMonthInteger < 0 || Integer.parseInt(inputMonth)> 12){
        System.out.println("invalid month");
    }

    
    //-------------------------
    System.out.println("Please insert the Day");        
    String inputDay = scan.nextLine();
    if (Integer.parseInt(inputDay) < 0 || Integer.parseInt(inputDay)> 31){ //todo fix for months with less than 31 days
    System.out.println("invalid day");
    }
   
    
    //---------------------------------
    
    
    
    
    
    
    
    
    //System.out.println("Poo");
    //System.out.println(10+2);    
    
    //Integer.parseInt(inputDay);
   
    //System.out.println(Integer.parseInt(inputDay)); 
    
    //if (examplestring.equals("hehe")){
    //System.out.println("Haha");
    }
}