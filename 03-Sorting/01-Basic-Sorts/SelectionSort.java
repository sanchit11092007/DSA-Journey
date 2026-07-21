import java.util.Arrays; 

/**
 * Problem: Selection Sort 
 * Difficulty: Easy 
 * Pattern: In-place comparison sort - repeatedly select the minimum 
 * Approach: 
 *   1. Divide the array into a "sorted" part (left) and "unsorted" part (right). 
 *   Initially, the sorted part is empty. 
 *   
 *   2. For each position i from 0 to n-1: 
 *     - Scan the unsorted part (from i to n-1) to find the index of the smallest element. 
 *     - Swap that smallest element with the element at position i. 
 * 
 *   3. After each pass, the sorted part grows by one element on the left, and it's guranteed to be in its final correct position. 
 *   4. Repeat until the whole array is sorted. 
 * 
 * Time Complexity; 0(n^2) in all case (best, average, worst) - becaue we always scan the remaining unsorted part fully, regardless of whether the array is already sorted. 
 * Space Complexity: 0(1) - sorting in don in-place, no extra array used.
 */

public class SelectionSort {

    static void selectionSort(int[] arr) {
        int n = arr.length; 

        for (int i = 0; i < n - 1; i++) {
            int minIndex = i; 

            // find the index of the minimum element in the unsorted part 
            for (int j = i+1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j; 
                }
            }

            // swap only if a smaller element was found 
            if (minIndex != i) {
                int temp = arr[i]; 
                arr[i] = arr[minIndex]; 
                arr[minIndex] = temp; 
            }
        }
    }
    
    public static void main(String[] args) {
        int[] arr = {64, 25, 12, 22,11}; 

        selectionSort(arr); 

        System.out.println(Arrays.toString(arr)); 
        // Expected output: [11,12,22,25,64]
    }
}


/** 
 *  arr = [64,25,12,22,11]
 * After pass 1 (i = 0): [11,25,12,22,64] -> smallest (11) moved to front 
 * After pass 2 (i = 1): [11,12,25,22,64] -> next smallest (12) placed at index 1 
 * After pass 3 (i = 2): [11,12,22,25,64] -> next smallest (22) placed at index 2 
 * After pass 4 (i = 3): [11,12,22,25,64] -> no change (25 was already in the right place)
 * Final sorted array: [11,12,22,25,64]
 */