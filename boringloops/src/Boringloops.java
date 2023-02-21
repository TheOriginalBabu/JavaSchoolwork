/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


/**
 *
 * @author Izaan Syed
 * @date Feb. 14, 2023
 * @ProjectName Date Analyzer
 * @Description First lab, takes date input then returns date info
 */

public class Boringloops {
    public static void main(String[] args) {
        /*For loops are used to count a numerically counted number of times.
        In Java they follow this notation:
        for(int x = 0; x < 10; x++){}
        
        Where: int x = 0 creates a variable to be used as a counter.
        x < 10 is the condition that the loop will repeat until.
        x++ is the incerment that the loop follows (ie. how much the counter changes by)
        and the code contained in the braces {} will repeat each time.
        */
        
        //To sum all of the numbers from 1 to 100 using a loop
        int sum = 0;
        for(int x = 0; x<=100; x++){
            sum = sum + x;
        }
        System.out.println("The sum of whole numbers from 1 to 100 is: " + sum);
        
       //To sum all of even numbers from 1 to 100 using a loop
        sum = 0;
        for(int x = 0; x<=100; x+=2){
            sum = sum + x;
        }
        System.out.println("The sum of all even numbers from 1 to 100 is: " + sum);
        
        //We can also use loops to count backwards
        //This will display all of the numbers from 1 to 10 backwards
        for(int x = 10; x>0; x--){
            System.out.println(x);
        }
        
        //And we can even nest for loops inside of other for loops to useful effect.
          for(int i = 10; i>0; i--){
              System.out.println();
            for (int j = 0; j < i; j++){
              System.out.print("*");
            }
         }
        // Practice program
        //Write a nested for loop that displays a calendar like format
            // M  T  W  H  F  S  U
            // 1  2  3  4  5  6  7
            // 8  9  10 11 12 13 14
            //etc...
        
    }
}