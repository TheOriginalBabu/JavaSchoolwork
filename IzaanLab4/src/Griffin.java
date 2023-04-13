
import java.io.File;//required for file access (reading)
import java.io.FileNotFoundException;
import java.io.FileWriter;//required for file access (writing)
import java.io.IOException;
import java.util.Scanner;

/**
 * @author grif8680
 * @date 23-Mar-2023
 * @ProjectName SortAlgorithms
 * @Description Demonstrate the use of sorting algorithms
 */

public class Griffin {

    public static String FILENAME = "Results.txt";

    public static void saveFile(long time, long iterations, String algorithm) {
        //In java we can read from and write to files with relative ease.
        //We MUST place file access inside a try catch that catches at least
        //IOException or our code will not compile.

        String results = "\n\t\t" + algorithm + ":\n\t\t\t" + "Time: " + time + "ms\n\t\t\t" + "Iterations: " + iterations + "\n";

        try{
            //creates (or opens) the file called filename.txt
            try (FileWriter writeArray = new FileWriter(FILENAME, true)) {
                writeArray.append(results);
            }
        }catch (IOException  e){
            System.out.println("File could not be created!");
        }
    }

    public static void saveFile(String sortType) {
        try {
            try (FileWriter writeArray = new FileWriter(FILENAME, true)) {
                writeArray.append(sortType + ":");
            }
        } catch (IOException e) {
            System.out.println("File could not be created!");
        }
    }

    public static void saveFile(int arrayLength) {
        try {
            try (FileWriter writeArray = new FileWriter(FILENAME, true)) {
                writeArray.append("\n\t" + arrayLength + ":");
            }
        } catch (IOException e) {
            System.out.println("File could not be created!");
        }
    }

    /**
     * generateArrayInt will open the text file called fileName that is
     * (stored in the same directory as the .java file). It will then
     * read each int stored in that file into an array of ints and return it
     * @param fileName The name of the file where our ints are stored.
     * @return an int array of the read data.
     */
    public static int[] generateArrayInt(String fileName){
        //In java we can read from and write to files with relative ease.
        //We MUST place file access inside a try catch that catches at least the
        //FileNotFoundException or our code will not compile.
        int[] array;
        try{
            File saveFile = new File(fileName+".txt");
            //We still can use scanners to read input.
            Scanner fileScanner =new Scanner(saveFile);//notice how the parameters have changed?
            int fileLength = 0; //used to determine the length of our array
            while(fileScanner.hasNextLine()){//as long as there is a next line.
                fileScanner.nextLine();
                fileLength++;//increase the counter so we learn how many lines are in the file.
            }//end of while
            array = new int[fileLength];
            fileScanner =new Scanner(saveFile); //reset our scanner to read the file again.
            int counter = 0;
            while(fileScanner.hasNextLine()){
                //reads the line and converts to an int.
                array[counter] = Integer.parseInt(fileScanner.nextLine());
                counter++;
            }
            fileScanner.close();//closes the Scanner to avoid memory leaks
        }catch (FileNotFoundException e){
            System.out.println("File not found!");
            return new int[1];
        }
        return array;
    }

    /**
     * generateArrayInt is used to return an array of integers
     * of length size. These integers can be sorted in ascending,
     * descending or random orders (determined by type). If
     * an invalid choice type is given, an array of 0's will be returned.
     * @param type determines the type of array returned.
     *             random: an array of random ints (from 0 to size)
     *             ascending: an array of sorted ints (0 to size-1)
     *             descending: an array of sorted ints (size-1 to 0)
     * @param size determines the size of the array.
     *             invalid sizes instead will return an array of length 1.
     * @return - an array of length size prefilled with integers.
     */
    public static int[] generateArrayInt(String type, int size){
        if (size<=0){ //To handle 0 or negative array sizes.
            size = 1;
        }
        int[] array = new int[size];
        switch (type) {
            case "random" -> {
                for (int x = 0; x < size; x++) {
                    array[x] = (int) (Math.random() * size);
                }
            }
            case "ascending" -> {
                for (int x = 0; x < size; x++) {
                    array[x] = x;
                }
            }
            case "descending" -> {
                for (int x = 0; x < size; x++) {
                    array[x] = size - x;
                }
            }
            default -> throw new IllegalStateException("Unexpected value: " + type);
        }//end of switch
        return array;
    }//end of generateArrayInt

    /**
     * swap is used to swap the values of two elements in an array.
     * @param array is the array where the swap will occur.
     * @param a is the index of the first element to be swapped.
     * @param b is the index of the second element to be swapped.
     */
    private static void swap(int[] array, int  a, int b) {
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }

    /**
     * displayArray is used to print the contents of an array to the console.
     * @param array is the array to be printed.
     */
    public static void displayArray(int[] array){
        for (int i : array) {
            System.out.println(i);
        }
    }

    /**
     * insertionSort will return an array of integers sorted from lowest to highest.
     * It does this through an insertion sorting algorithm.
     * This algorithm functions by comparing a target element (starting at index 1)
     * to all elements to the left of it (lower indexes in the array).
     * If the element to the left is lower,  they are swapped (higher to the right).
     * This repeats until target is not less than the element to its left.
     * When this occurs, the target is considered sorted, and
     * The process restarts with the new target being the right most unsorted element.
     * @param array is an array of ints to be sorted
     * @return the sorted array of ints.
     */
    public static long insertionSort(int[] array, long startTime){
        long counter = 0; //used to count the number of iterations (not necessary)
        for (int i = 1; i < array.length; i++) {
            if (System.nanoTime()/1_000_000_000 - startTime/1_000_000_000 <= 60) {//loops through each element (left to right)
                int target = array[i]; //target to be placed in sorted postion.
                int left = i - 1; //elements left of the target
                counter++;
                while (left >= 0 && array[left] > target) {
                    counter++;
                    //while the target is not in left most sorted postion
                    array[left + 1] = array[left];// swaps elements to the right.
                    left--;
                }
                array[left + 1] = target;
            } else { return -1; }
        }
        return counter;
    }//end of insertionSort

    /**
     * selectionSort will return an array of integers sorted from lowest to highest.
     * It does this through a selection sorting algorithm.
     * This algorithm functions by finding the lowest element in the array,
     * and swapping it with the element at index 0.
     * It then finds the next lowest element in the array (excluding the first element)
     * and swaps it with the element at index 1.
     * This repeats until the array is sorted.
     * @param array is an array of ints to be sorted
     * @return the sorted array of ints.
     */
    public static long selectionSort(int[] array, long startTime) {
        long counter = 0;
        for (int i = 0; i < array.length; i++) {
            if (System.nanoTime()/1_000_000_000 - startTime/1_000_000_000 <= 60) {
                int min = i;
                for (int j = i + 1; j < array.length; j++) {
                    counter++;
                    if (array[j] < array[min]) {
                        min = j;
                    }
                }
                int temp = array[min];
                array[min] = array[i];
                array[i] = temp;
            } else { return -1; }
        }
        return counter;
    }

    /**
     * bubbleSort will return an array of integers sorted from lowest to highest.
     * It does this through a bubble sorting algorithm.
     * This algorithm functions by comparing each element to the element to its right.
     * If the element to the right is lower,  they are swapped (higher to the right).
     * This repeats until the array is sorted.
     * @param array is an array of ints to be sorted
     * @return the sorted array of ints.
     */
    public static long bubbleSort(int[] array, long startTime) {
        long counter = 0;
        boolean swapped;
        do {
            if (System.nanoTime()/1_000_000_000 - startTime/1_000_000_000 <= 60) {
                swapped = false;
                for (int j = 0; j < array.length - 1; j++) {
                    counter++;
                    if (array[j] > array[j + 1]) {
                        int temp = array[j];
                        array[j] = array[j + 1];
                        array[j + 1] = temp;
                        swapped = true;
                    }
                }
            } else { return -1; }
        } while (swapped);
        return counter;
    }

    /**
     * quickSort will return an array of integers sorted from lowest to highest.
     * It does this through a quick sorting algorithm.
     * This algorithm functions by selecting a pivot element (the last element in the array).
     * It then compares each element to the pivot element.
     * If the element is less than the pivot element, it is swapped with the element to the right of the current element.
     * This repeats until the array is sorted.
     * @param array is an array of ints to be sorted
     * @return the sorted array of ints.
     */
    public static long quickSort(int[] array, int low, int high, long startTime)  {
        if (System.nanoTime()/1_000_000_000 - startTime/1_000_000_000 <= 60) {
            try {
                long counter = 0;
                if (low < high) {
                    int l = low;
                    int current = low - 1;
                    int pivot = array[high];
                    // Search through array for values to switch
                    while (l <= high - 1) {

                        // Checks if current element is less that pivot element
                        if (array[l] < pivot) {
                            current++;
                            swap(array, l, current);
                        }

                        // Increments what element were looking at
                        l++;
                        counter++;
                    }

                    // Recursively calls itself until array is sorted
                    long counterReturnedLow = 0;
                    long counterReturnedHigh = 0;
                    if (current > -1) {
                        swap(array, current + 1, high);
                        counterReturnedLow = quickSort(array, low, current, startTime);
                        counterReturnedHigh = quickSort(array, current + 2, high, startTime);
                    }

                    if (counterReturnedLow < 0 || counterReturnedHigh < 0) {
                        return -1;
                    } else {
                        counter += counterReturnedLow + counterReturnedHigh;
                    }
                }
                return counter;
            } catch (StackOverflowError e) {
                System.out.println("Stack Overflow Error");
                return -1;
            }
        } else { return -1; }
    }

    /**
     * comparison is used to compare the number of iterations
     * of the four sorting algorithms on a given array.
     */
    public static void comparisonSetter(){
        // Compare for different array sizes
        int[][] exampleArray = new int[6][];
/*
        System.out.println("Randomized:");
        saveFile("Random");
        for (int i = 0; i < 6; i++) {
            exampleArray[i] = generateArrayInt("random", (int) Math.pow(10, i + 2));
            System.out.println("\tLength " + (int) Math.pow(10, i + 2) + ":");
            saveFile((int) Math.pow(10, i + 2));
            comparison(exampleArray[i]);
        }

        System.out.println("Ascending:");
        saveFile("Ascending");
        for (int i = 0; i < 6; i++) {
            exampleArray[i] = generateArrayInt("ascending", (int) Math.pow(10, i + 2));
            System.out.println("\tLength " + (int) Math.pow(10, i + 2) + ":");
            saveFile((int) Math.pow(10, i + 2));
            comparison(exampleArray[i]);
        }
*/
        System.out.println("Descending:");
        saveFile("Descending");
        for (int i = 0; i < 6; i++) {
            exampleArray[i] = generateArrayInt("descending", (int) Math.pow(10, i + 2));
            System.out.println("\tLength " + (int) Math.pow(10, i + 2) + ":");
            saveFile((int) Math.pow(10, i + 2));
            comparison(exampleArray[i]);
        }
    }

    /**
     * This method compares the ability of the four sorting algorithms to sort an array
     * and prints the results to a text file.
     * @param array is an array of integers to be sorted.
     */
    public static void comparison(int[] array){
        String iterationText = " iterations";
        String timeText = " nanoseconds\n";
        long iterations;
        long startTime;
        long endTime;
        long duration;

        System.out.println("\t\tInsertion Sort:");
        startTime = System.nanoTime();
        iterations = insertionSort(array.clone(), startTime);
        endTime = System.nanoTime();
        duration = (endTime - startTime);
        System.out.println("\t\t\t" + iterations + iterationText);
        System.out.println("\t\t\t" + duration + timeText);
        saveFile(duration, iterations, "Insertion");


        System.out.println("\t\tSelection Sort:");
        startTime = System.nanoTime();
        iterations = selectionSort(array.clone(), startTime);
        endTime = System.nanoTime();
        duration = (endTime - startTime);
        System.out.println("\t\t\t" + iterations + iterationText);
        System.out.println("\t\t\t" + duration + timeText);
        saveFile(duration, iterations, "Selection");

        System.out.println("\t\tBubble Sort:");
        startTime = System.nanoTime();
        iterations = bubbleSort(array.clone(), startTime);
        endTime = System.nanoTime();
        duration = (endTime - startTime);
        System.out.println("\t\t\t" + iterations + iterationText);
        System.out.println("\t\t\t" + duration + timeText);
        saveFile(duration, iterations, "Bubble");

        System.out.println("\t\tQuick Sort:");
        startTime = System.nanoTime();
        iterations = quickSort(array.clone(), 0, array.length-1, startTime);
        endTime = System.nanoTime();
        duration = (endTime - startTime);
        System.out.println("\t\t\t" + iterations + iterationText);
        System.out.println("\t\t\t" + duration + timeText);
        saveFile(duration, iterations, "Quick");
    }

    public static void main(String[] args) {
        comparisonSetter();
    }
}