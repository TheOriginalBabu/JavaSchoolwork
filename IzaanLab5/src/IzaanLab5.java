/**
 *
 * author Izaan Syed
 * date April 26, 2023
 * ProjectName IzaanLab5
 * Description Recursion lab
 */

import java.util.Scanner;

public class IzaanLab5 {
    //error trapped Fibonacci algorithm, accounting for stack overflow error
    public static int fibonacci(int num, long startTime) {
        if (System.currentTimeMillis() - startTime < 10000) { // If the time elapsed is greater than 10 seconds
            if (num <= 1) { // Base case
                return num; // returns 0 or 1
            } else {
                try {
                    int var1 = fibonacci(num - 1, startTime);
                    int var2 = fibonacci(num - 2, startTime); // Recursive cal
                    if (var1 == -1 || var2 == -1) { // If either of the recursive calls return -1
                        return -1; // returns -1
                    } else {
                        return var1 + var2; // returns the sum of the two recursive calls
                    }
                } catch (StackOverflowError e) { // Catches stack overflow error
                    return -1; // returns 0
                }
            }
        } else {
            return -1;
        }
    }




    //Towers of Hanoi algorithm, found from https://www.digitalocean.com/community/tutorials/tower-of-hanoi

    public static void hanoi(int n, char from, char to, char aux, long startTime) {
        if (System.currentTimeMillis() - startTime < 10000) { // If the time elapsed is greater than 10 seconds
            if (n == 1) { // Base case
                System.out.println("Move disk 1 from rod " + from + " to rod " + to); // Prints the move
                return;
            }
            hanoi(n - 1, from, aux, to, startTime); // Recursive call, moves n-1 disks from source to auxiliary
            System.out.println("Move disk " + n + " from rod " + from + " to rod " + to); // Prints the move
            hanoi(n - 1, aux, to, from, startTime); // Recursive call, moves n-1 disks from auxiliary to destination
        }
        else {
            System.out.println("The program took too long to run, exiting. Please try again with a smaller number of disks.");
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
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a number to find the fibonacci of: ");
        int num = input.nextInt();
        long startTime = System.currentTimeMillis();
        int varFibonacci = fibonacci(num, startTime);
        if (varFibonacci == -1) {
            System.out.println("The program took too long to run, exiting.");
        }
        else {
            System.out.println("The fibonacci of " + num + " is " + varFibonacci);
        }
    }

    public static void userHanoi() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the number of disks: ");
        int n = input.nextInt();
        System.out.println("Enter the source rod: ");
        char from = input.next().charAt(0);
        System.out.println("Enter the destination rod: ");
        char to = input.next().charAt(0);
        System.out.println("Enter the auxiliary rod (the last remaining rod): ");
        char aux = input.next().charAt(0);
        hanoi(n, from, to, aux, System.currentTimeMillis());
    }

    public static void userQuicksort() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the number of elements in the randomized array: ");
        int size = input.nextInt();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = (int) (Math.random() * 1000); // multiplies by 1000 to get a number between 0 and 1000
        }
        System.out.println("The randomized array is: " + java.util.Arrays.toString(arr));
        long startTime = System.currentTimeMillis();
        int[] sortedarr = quickSort(arr, 0, size - 1, startTime);
        System.out.println("The sorted array is: " + java.util.Arrays.toString(sortedarr));
    }


    public static void main(String[] args) { // main menu loop for 3 options + quit
        Scanner input = new Scanner(System.in);
        int choice = 0;
        while (choice != 4) {
            System.out.println("Enter 1 for fibonacci, 2 for Towers of Hanoi, 3 for quicksort, or 4 to quit: ");
            choice = input.nextInt();
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