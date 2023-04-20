public class Main {
    //Fibonacci algorithm
    public static int fibonacci(int num) {
        if (num == 0) { // Base case
            return 0;
        } else if (num == 1) { // Base case
            return 1;
        } else {
            return fibonacci(num - 1) + fibonacci(num - 2); // Recursive call
        }
    }
    //Tower of Hanoi algorithm
    public static void hanoi(int n, char from, char to, char aux) { // n is number of disks
        if (n == 1) { // Base case
            System.out.println("Move disk 1 from rod " + from + " to rod " + to);
            return;
        }
        hanoi(n - 1, from, aux, to); // Recursive call
        System.out.println("Move disk " + n + " from rod " + from + " to rod " + to);
        hanoi(n - 1, aux, to, from); // Recursive call
    }

    //Quicksort algorithm
    public static void quickSort(int[] arr, int low, int high) { // arr is the array to be sorted, low is the first index and high is the last index
        if (arr == null || arr.length == 0) // Base case
            return;
        if (low >= high) // Base case
            return;
        int middle = low + (high - low) / 2;
        int pivot = arr[middle];
        int i = low, j = high;
        while (i <= j) {
            while (arr[i] < pivot) {
                i++;
            }
            while (arr[j] > pivot) {
                j--;
            }
            if (i <= j) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j--;
            }
        }
        if (low < j) // Recursive call
            quickSort(arr, low, j);
        if (high > i) // Recursive call
            quickSort(arr, i, high);
    }

    public static void main(String[] args) {
        System.out.println(fibonacci(10));
        hanoi(3, 'A', 'C', 'B'); // A, B and C are names of rods

        int[] arr = { 4, 2, 3, 1, 6, 5, 7, 9, 8 }; // Example array for quicksort
        quickSort(arr, 0, arr.length - 1);
    }
}