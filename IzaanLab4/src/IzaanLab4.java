

import java.io.File;//required for file access (reading)
import java.io.FileNotFoundException;
import java.io.FileWriter;//required for file access (writing)
import java.io.IOException;
import java.util.Scanner;

/**
 * author: Izaan
 * date: 30-Mar-2022
 * filename: IzaanLab4.java
 * description: this is my lab 4 for sorting algorithms
 */
public class IzaanLab4 {
    /**
     * saveFile will store the data stored in the array of ints to fileName.txt
     * (stored in the same directory as the .java file).
     * @param fileName The name of the file where our ints will be stored.
     */
    public static void saveFile(String fileName, int[] array){
        //In java we can read from and write to files with relative ease.
        //We MUST place file access inside a try catch that catches at least
        //IOException or our code will not compile.
        try{
            //creates (or opens) the file called filename.txt
            FileWriter writeArray = new FileWriter(fileName + ".txt");
            for (int i : array) {
                //the data written must be a String or char.
                String line = Integer.toString(i);
                writeArray.write(line + '\n');//writes the data stored in line to the file
            }
            //closes the file (should be done to avoid memory leaks, and file conflicts)
            writeArray.close();
        }catch (IOException  e){
            System.out.println("File could not be created!");
        }
    }

    public static void saveResults(long time, long iterations, String algorithm) {
        //In java we can read from and write to files with relative ease.
        //We MUST place file access inside a try catch that catches at least
        //IOException or our code will not compile.


        String results = "\n\t\t" + algorithm + ":\n\t\t\t" + "Time: " + time + "ms\n\t\t\t" + "Iterations: " + iterations + "\n";


        try{
            //creates (or opens) the file called filename.txt
            try (FileWriter writeArray = new FileWriter("Results", true)) {
                writeArray.append(results);
            }
        }catch (IOException  e){
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
    public static int[] generateArrayInt(String fileName){ // Reads array from file
        //In java we can read from and write to files with relative ease.
        //We MUST place file access inside a try catch that catches at least the 
        //FileNotFoundException or our code will not compile.
        int array[];

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
    public static int[] generateArrayInt(String type, int size){ // Generates an array of ints
        if (size<=0){ //To handle 0 or negative array sizes.
            size = 1;
        }
        int array[] = new int[size];
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
        }//end of switch
        return array;
    }//end of generateArrayInt
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
    public static int[] insertionSort(int array[]){
        int counter =0; //used to count the number of iterations (not necessary)
        for (int i =1;i<array.length;i++){ //loops through each element (left to right)
            int target = array[i]; //target to be placed in sorted postion.
            int left = i -1; //elements left of the target
            while (left>=0 && array[left] > target){
                counter++;
                //while the target is not in left most sorted postion
                array[left+1] = array[left];// swaps elements to the right.
                left--;
            }
            array[left+1] = target; 
        }
        System.out.println("Array sorted after " + counter + " loops.");
        return array;
    }

    public static int[] bubbleSort(int array[]){ // Bubble sort
        int counter =0; // used to count the number of iterations (not necessary)
        for (int i =0;i<array.length;i++){ //loops through each element (left to right)
            for (int j =0;j<array.length-1;j++){
                counter++;
                if (array[j] > array[j+1]){
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
        }
        System.out.println("Array sorted after " + counter + " loops.");
        return array;
    }

    public static int[] selectionSort(int array[]){  // Selection sort
        int counter =0;
        for (int i =0;i<array.length;i++){
            int min = i;
            for (int j =i+1;j<array.length;j++){
                counter++;
                if (array[j] < array[min]){
                    min = j;
                }
            }
            int temp = array[i];
            array[i] = array[min];
            array[min] = temp;
        }
        System.out.println("Array sorted after " + counter + " loops.");
        return array;
    }

    public static int [] gnomeSort(int array[]){ // Gnome sort
        long startTime = System.currentTimeMillis(); // starting time
        int counter =0;
        int i = 1;
        while (i < array.length){
            counter++;
            if (array[i-1] <= array[i]){
                i++;
            }else{
                int temp = array[i];
                array[i] = array[i-1];
                array[i-1] = temp;
                i--;
                if (i == 0){
                    i = 1;
                }
            }
        }
        long timeTaken = System.currentTimeMillis() - startTime; // ending time
        System.out.println("Array sorted after " + counter + " loops"  + "and" + timeTaken + "milliseconds.");
        return array;
    }
    
    public static void displayArray(int array[]){ // Method to print out Array
        for (int i : array) {
            System.out.println(i);
        }    
    }

    public static void initiaizeArrays(){
        int[] ascending10 = generateArrayInt("ascending", 10);
        saveFile("ascending10", ascending10);
        int[] ascending100 = generateArrayInt("ascending", 100);
        saveFile("ascending100", ascending100);
        int[] ascending1000 = generateArrayInt("ascending", 1000);
        saveFile("ascending1000", ascending1000);
        int[] ascending10000 = generateArrayInt("ascending", 10000);
        saveFile("ascending10000", ascending10000);
        int[] ascending1000000 = generateArrayInt("ascending", 1000000);
        saveFile("ascending1000000", ascending1000000);
        int[] ascending10000000 = generateArrayInt("ascending", 10000000);
        saveFile("ascending10000000", ascending10000000);

        int[] descending10 = generateArrayInt("descending", 10);
        saveFile("descending10", descending10);
        int[] descending100 = generateArrayInt("descending", 100);
        saveFile("descending100", descending100);
        int[] descending1000 = generateArrayInt("descending", 1000);
        saveFile("descending1000", descending1000);
        int[] descending10000 = generateArrayInt("descending", 10000);
        saveFile("descending10000", descending10000);
        int[] descending1000000 = generateArrayInt("descending", 1000000);
        saveFile("descending1000000", descending1000000);
        int[] descending10000000 = generateArrayInt("descending", 10000000);
        saveFile("descending10000000", descending10000000);

        int[] random10 = generateArrayInt("random", 10);
        saveFile("random10", random10);
        int[] random100 = generateArrayInt("random", 100);
        saveFile("random100", random100);
        int[] random1000 = generateArrayInt("random", 1000);
        saveFile("random1000", random1000);
        int[] random10000 = generateArrayInt("random", 10000);
        saveFile("random10000", random10000);
        int[] random1000000 = generateArrayInt("random", 1000000);
        saveFile("random1000000", random1000000);
        int[] random10000000 = generateArrayInt("random", 10000000);
        saveFile("random10000000", random10000000);
    }

    public static void main(String[] args) {
        initiaizeArrays();
        //Example for reading and writing to files

        
        //int exampleReadArray[] = generateArrayInt("random100");
        //displayArray(exampleReadArray);
        
        //Example Time tracking code.
        int[] currentArray = generateArrayInt("ascending10.txt");


        int[] timedArray= generateArrayInt("random",10000);
        long startTime = System.currentTimeMillis(); // starting time
        selectionSort(timedArray);                   // call sorting method on timedArray
        long timeTaken = System.currentTimeMillis() - startTime; // ending time
        System.out.println("Array sorted after " + timeTaken + " milliseconds.");
    }
}
