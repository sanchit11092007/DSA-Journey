import java.util.Arrays; 

/**
 * 📌 Problem: Insertion Sort
 * ⚡ Difficulty: Easy
 * 💡 Pattern: In-Place Comparison Sort
 * 
 * 🔍 Description:
 * Builds the final sorted array one element at a time. It takes each element (called the key) 
 * and inserts it into its correct position within the already sorted portion on its left.
 * 
 * 📈 Complexity Analysis:
 * - Time Complexity:
 *   - Best Case: O(N) -> Array is already sorted (no shifting needed).
 *   - Average/Worst Case: O(N^2) -> Array is sorted in reverse or random.
 * - Space Complexity: O(1) -> Sorting is done in-place.
 */

public class InsertionSort {
    
    static void insertionSort(int[] arr) {
        int n = arr.length; 

        for (int i = 1; i < n; i++) {
            int key = arr[i]; 
            int j = i - 1; 

            // Shift elements of the sorted portion that are greater than key to the right
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j]; 
                j--; 
            }

            // Place the key at its correct position
            arr[j + 1] = key; 
        }
    }

    public static void main(String[] args) {
        int[] arr = {64, 25, 12, 22, 11}; 

        insertionSort(arr);

        System.out.println(Arrays.toString(arr)); 
    }
}

// Dry Run:
// Initial Array: [64, 25, 12, 22, 11]
// 
// Pass i=1 (key = 25):
// - j=0: 64 > 25 -> Shift 64 -> [64, 64, 12, 22, 11]
// - Insert 25 at index 0 -> [25, 64, 12, 22, 11]
// 
// Pass i=2 (key = 12):
// - j=1: 64 > 12 -> Shift 64 -> [25, 64, 64, 22, 11]
// - j=0: 25 > 12 -> Shift 25 -> [25, 25, 64, 22, 11]
// - Insert 12 at index 0 -> [12, 25, 64, 22, 11]
// 
// Pass i=3 (key = 22):
// - j=2: 64 > 22 -> Shift 64 -> [12, 25, 64, 64, 11]
// - j=1: 25 > 22 -> Shift 25 -> [12, 25, 25, 64, 11]
// - j=0: 12 > 22? No -> Stop
// - Insert 22 at index 1 -> [12, 22, 25, 64, 11]
// 
// Pass i=4 (key = 11):
// - j=3: 64 > 11 -> Shift 64 -> [12, 22, 25, 64, 64]
// - j=2: 25 > 11 -> Shift 25 -> [12, 22, 25, 25, 64]
// - j=1: 22 > 11 -> Shift 22 -> [12, 22, 22, 25, 64]
// - j=0: 12 > 11 -> Shift 12 -> [12, 12, 22, 25, 64]
// - Insert 11 at index 0 -> [11, 12, 22, 25, 64]
// 
// Final Sorted Array: [11, 12, 22, 25, 64]