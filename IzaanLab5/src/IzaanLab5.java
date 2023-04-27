/**
 *
 * author Izaan Syed
 * date April 26, 2023
 * ProjectName IzaanLab5
 * Description Recursion lab
 */

import java.util.Scanner;

public class IzaanLab5 {
    //Fibonacci algorithm, found from https://www.javatpoint.com/fibonacci-series-in-java
    public static long fibonacci(long num, long startTime) {
        if (System.currentTimeMillis() - startTime < 10000) { // If the time elapsed is greater than 10 seconds
            if (num <= 1) { // Base case
                return num; // returns 0 or 1
            } else {
                try {
                    long run1 = fibonacci(num - 1, startTime);
                    long run2 = fibonacci(num - 2, startTime); // Recursive cal
                    if (run1 == -1 || run2 == -1) { // If either of the recursive calls return -1
                        return -1; // returns -1
                    } else {
                        return run1 + run2; // returns the sum of the two recursive calls
                    }
                } catch (StackOverflowError e) { // Catches stack overflow error
                    return -1; // returns
                }
            }
        } else {
            return -1;
        }
    }

    //Towers of Hanoi algorithm, found from https://www.digitalocean.com/community/tutorials/tower-of-hanoi
    public static int hanoi(long n, char from, char to, char aux, long startTime) {
        if (System.currentTimeMillis() - startTime < 10000) { // If the time elapsed is greater than 10 seconds
            if (n == 1) { // Base case
                System.out.println("Move disk 1 from rod " + from + " to rod " + to); // Prints the move
                return 0; // returns 0
            } else {
                try {
                    int run1 = hanoi(n - 1, from, aux, to, startTime); // Recursive call
                    if (run1 == -1) { // If the recursive call returns -1
                        return -1; // returns -1
                    }
                    System.out.println("Move disk " + n + " from rod " + from + " to rod " + to); // Prints the move
                    int run2 = hanoi(n - 1, aux, to, from, startTime); // Recursive call
                    if (run2 == -1) { // If the recursive call returns -1
                        return -1; // returns -1
                    }
                    return 0; // returns 0
                } catch (StackOverflowError e) { // Catches stack overflow error
                    return -1; // returns -1
                }
            }
        } else {
            return -1;
        }

    }

    //Quicksort algorithm, found from https://www.geeksforgeeks.org/quick-sort/
    public static int[] quickSort(int[] arr, int low, int high, long startTime) { // arr is the array to be sorted, low is the first index and high is the last index
        if (System.currentTimeMillis() - startTime < 10000) { // If the time elapsed is greater than 10 seconds
            if (arr == null || arr.length == 0) // Base case
                return arr; // returns if the array is empty
            if (low >= high) // Base case
                return arr; // returns if the array is sorted
            int middle = low + (high - low) / 2; // Finds the middle index
            int pivot = arr[middle]; // Finds the pivot
            int i = low, j = high; // Sets i to the first index and j to the last index
            while (i <= j) { // While i is less than or equal to j
                while (arr[i] < pivot) { // While the value at i is less than the pivot
                    i++; // Increment i
                }
                while (arr[j] > pivot) { // While the value at j is greater than the pivot
                    j--; // Decrement j
                }
                if (i <= j) { // If i is less than or equal to j
                    int temp = arr[i]; // Swap the values at i and j
                    arr[i] = arr[j];
                    arr[j] = temp;
                    i++; // Increment i
                    j--; // Decrement j
                }
            }
            if (low < j) // Recursive call
                quickSort(arr, low, j, startTime);
            if (high > i) // Recursive call
                quickSort(arr, i, high, startTime);
            return arr; // Returns the sorted array
        }
        else {
            return arr;
        }
    }

    // method for user input for fibonacci
    public static void userFibonacci() {
        try {
            Scanner input = new Scanner(System.in);
            System.out.println("Enter a number to find the fibonacci of: ");
            long num = input.nextLong();
            long startTime = System.currentTimeMillis();  // Tracks time at run prevent infinite loop
            long varFibonacci = fibonacci(num, startTime);
            if (varFibonacci == -1) {
                System.out.println("The program took too long to run, exiting. Please try again with a smaller number");
            } else {
                System.out.println("The fibonacci of " + num + " is " + varFibonacci);
            }
        }
        catch (Exception e){
            System.out.println("The program encountered the error " + e + ". Please try again."); // shows user what the encountered error was and asks them to try again
        }
    }

    public static void userHanoi() {
        try {
            Scanner input = new Scanner(System.in);
            System.out.println("Enter the number of disks: ");
            long n = input.nextLong();
            System.out.println("Enter the source rod: "); // Rod where disks are initially placed
            char from = input.next().charAt(0);
            System.out.println("Enter the destination rod: "); // Rod where disks are to be transferred
            char to = input.next().charAt(0);
            System.out.println("Enter the auxiliary rod (the last remaining rod): "); // Rod that is used for temporary storage
            char aux = input.next().charAt(0);
            long startTime = System.currentTimeMillis(); // Tracks time at run prevent infinite loop
            if (hanoi(n, from, to, aux, startTime) == -1) {
                System.out.println("The program could not run. Please try again with a smaller number.");
            }
        } catch (Exception e) {
            System.out.println("The program encountered the error " + e + ". Please try again."); // shows user what the encountered error was and asks them to try again
        }
    }

    public static void userQuicksort() {
        try {
            Scanner input = new Scanner(System.in);
            System.out.println("Enter the number of elements in the randomized array: ");
            int size = input.nextInt();
            int[] arr = new int[size];
            for (int i = 0; i < size; i++) { // for loop to fill the array with random numbers
                arr[i] = (int) (Math.random() * 100000); // multiplies by 100000 to get a number between 0 and 100000
            }
            System.out.println("The randomized array is: " + java.util.Arrays.toString(arr));
            long startTime = System.currentTimeMillis();   // Tracks time at run prevent infinite loop
            int[] sortedarr = quickSort(arr, 0, size - 1, startTime);
            System.out.println("The sorted array is: " + java.util.Arrays.toString(sortedarr));
        }
        catch (Exception e) {
            System.out.println("The program encountered the error " + e + ". Please try again."); // shows user what the encountered error was and asks them to try again
        }
    }

    public static void main(String[] args) { // main menu loop for 3 options + quit
        Scanner input = new Scanner(System.in);
        int choice = 0;
        while (choice != 4) {
            System.out.println("Enter 1 for fibonacci, 2 for Towers of Hanoi, 3 for quicksort, or 4 to quit: ");
            try { // try catch block to catch invalid inputs
                choice = input.nextInt();
            }
            catch (Exception e) {
                System.out.println("Invalid input, try again.");
                input.next(); // clears the scanner
                continue; // continues the loop
            }
            if (choice == 1) {
                userFibonacci();
            } else if (choice == 2) {
                userHanoi();
            } else if (choice == 3) {
                userQuicksort();
            } else if (choice == 4) {
                System.out.println("Goodbye!");
            } else {
                System.out.println("Invalid input, try again.");
            }
        }
    }
}