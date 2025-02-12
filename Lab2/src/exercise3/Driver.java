package exercise3;

import java.util.Random;
import java.util.Scanner;

public class Driver {

    public static final int SIZE = 100; // Size of the array
    public static final int UPPER_BOUND = 1000; // Upper bound for random numbers

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random rand = new Random();

        // Generate an array of random integers
        Integer[] nums = new Integer[SIZE];
        for (int i = 0; i < SIZE; i++) {
            nums[i] = rand.nextInt(UPPER_BOUND);
        }

        // Main loop to allow continuous input
        while (true) {
            // Display the array before sorting
            System.out.println("\nArray before sorting:");
            printArray(nums);

            // Prompt the user to enter a sorting algorithm choice
            System.out.println("\nEnter a sorting algorithm choice:");
            System.out.println("b (Bubble Sort), i (Insertion Sort), s (Selection Sort), q (QuickSort), x (Exit)");
            String input = scanner.nextLine().trim(); // Read the input

            // Exit the program if the user enters 'x'
            if (input.equals("x")) {
                System.out.println("Exiting the program. Goodbye!");
                break;
            }

            // Validate the input
            if (input.length() != 1 || !input.matches("[b|i|s|q]")) {
                System.out.println("Invalid input. Please provide one of the following: b, i, s, q, or x to exit.");
                continue; // Skip the rest of the loop and prompt again
            }

            // Perform sorting based on the user's choice
            char choice = input.charAt(0);
            switch (choice) {
                case 'b':
                    bubbleSort(nums);
                    System.out.println("\nArray after Bubble Sort (descending order):");
                    break;
                case 'i':
                    insertionSort(nums);
                    System.out.println("\nArray after Insertion Sort (descending order):");
                    break;
                case 's':
                    selectionSort(nums);
                    System.out.println("\nArray after Selection Sort (descending order):");
                    break;
                case 'q':
                    quickSort(nums, 0, nums.length - 1);
                    System.out.println("\nArray after QuickSort (descending order):");
                    break;
            }

            // Display the array after sorting
            printArray(nums);

            // Reset the array to its original state for the next sorting
            for (int i = 0; i < SIZE; i++) {
                nums[i] = rand.nextInt(UPPER_BOUND);
            }
        }

        // Close the scanner
        scanner.close();
    }

    // Method to print the array
    public static void printArray(Integer[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
            if ((i + 1) % 10 == 0) { // Print 10 elements per line
                System.out.println();
            }
        }
    }

    // Bubble Sort algorithm (descending order)
    public static void bubbleSort(Integer[] array) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (array[j] < array[j + 1]) {
                    // Swap array[j] and array[j+1]
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    // Insertion Sort algorithm (descending order)
    public static void insertionSort(Integer[] array) {
        int n = array.length;
        for (int i = 1; i < n; i++) {
            int key = array[i];
            int j = i - 1;
            while (j >= 0 && array[j] < key) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = key;
        }
    }

    // Selection Sort algorithm (descending order)
    public static void selectionSort(Integer[] array) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            int maxIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (array[j] > array[maxIndex]) {
                    maxIndex = j;
                }
            }
            // Swap array[i] and array[maxIndex]
            int temp = array[i];
            array[i] = array[maxIndex];
            array[maxIndex] = temp;
        }
    }

    // QuickSort algorithm (descending order)
    public static void quickSort(Integer[] array, int low, int high) {
        if (low < high) {
            int pi = partition(array, low, high);
            quickSort(array, low, pi - 1);
            quickSort(array, pi + 1, high);
        }
    }

    // Helper method for QuickSort (partitioning)
    public static int partition(Integer[] array, int low, int high) {
        int pivot = array[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (array[j] >= pivot) {
                i++;
                // Swap array[i] and array[j]
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
        // Swap array[i+1] and array[high] (pivot)
        int temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;
        return i + 1;
    }
}