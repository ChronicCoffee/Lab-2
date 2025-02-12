package exercise2;

import java.util.Random;
import java.util.Scanner;

public class Driver {

    public static final int SIZE = 100;
    public static final int UPPER_BOUND = 10;

    public static void main(String[] args) {
        // Generate a sorted array of integers
        Integer[] nums = new Integer[SIZE];
        Random rand = new Random();
        int randnum = rand.nextInt(UPPER_BOUND);
        nums[0] = randnum;

        for (int i = 1; i < SIZE; i++) {
            randnum = rand.nextInt(UPPER_BOUND);
            nums[i] = nums[i - 1] + randnum;
        }

        // Print the sorted array in a cleaner format
        System.out.println("Sorted array (first 10 and last 10 elements):");
        for (int i = 0; i < 10; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println("...");
        for (int i = SIZE - 10; i < SIZE; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println();

        // Prompt the user for the target
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nEnter the target integer to search for: ");
        int target = scanner.nextInt();
        scanner.close();

        // Perform binary search
        int result = binarySearch(nums, target);

        // Display the result
        if (result != -1) {
            System.out.println("\nTarget found at index: " + result);
        } else {
            System.out.println("\nTarget not found in the array.");
        }
    }

    // Binary search algorithm
    public static int binarySearch(Integer[] array, int target) {
        int left = 0;
        int right = array.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            // Check if target is at the middle
            if (array[mid] == target) {
                return mid;
            }

            // If target is greater, ignore the left half
            if (array[mid] < target) {
                left = mid + 1;
            }
            // If target is smaller, ignore the right half
            else {
                right = mid - 1;
            }
        }

        // Target not found
        return -1;
    }
}