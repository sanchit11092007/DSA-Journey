import java.util.Arrays; 

/**
 * 📌 Problem: Bubble Sort
 * ⚡ Difficulty: Easy
 * 💡 Pattern: In-Place Comparison Sort
 * 
 * 🔍 Description:
 * Repeatedly steps through the list, compares adjacent elements, and swaps them if they 
 * are in the wrong order. This process is repeated until no swaps are needed.
 * In each pass, the largest unsorted element "bubbles up" to its correct position at the end.
 * Optimization: If a pass completes without any swaps, the array is already sorted, and we stop early.
 * 
 * 📈 Complexity Analysis:
 * - Time Complexity:
 *   - Best Case: O(N) -> Array is already sorted (exits after 1 pass).
 *   - Average/Worst Case: O(N^2) -> Array is sorted in reverse or random.
 * - Space Complexity: O(1) -> Sorting is done in-place.
 */

public class BubbleSort {

    static void bubbleSort(int[] arr) {
        int n = arr.length; 

        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false; 

            // Last i elements are already in place, so we don't check them
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    // Swap arr[j] and arr[j+1]
                    int temp = arr[j]; 
                    arr[j] = arr[j + 1]; 
                    arr[j + 1] = temp; 
                    swapped = true;
                }
            }

            // If no elements were swapped in this pass, the array is sorted
            if (!swapped) {
                break; 
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {64, 25, 12, 22, 11}; 

        bubbleSort(arr); 

        System.out.println(Arrays.toString(arr)); 
    }
}

// Dry Run:
// Initial Array: [64, 25, 12, 22, 11]
// 
// Pass 1 (i=0): j goes from 0 to 3
// - j=0: 64 > 25 -> swap -> [25, 64, 12, 22, 11]
// - j=1: 64 > 12 -> swap -> [25, 12, 64, 22, 11]
// - j=2: 64 > 22 -> swap -> [25, 12, 22, 64, 11]
// - j=3: 64 > 11 -> swap -> [25, 12, 22, 11, 64]
// 
// Pass 2 (i=1): j goes from 0 to 2
// - j=0: 25 > 12 -> swap -> [12, 25, 22, 11, 64]
// - j=1: 25 > 22 -> swap -> [12, 22, 25, 11, 64]
// - j=2: 25 > 11 -> swap -> [12, 22, 11, 25, 64]
// 
// Pass 3 (i=2): j goes from 0 to 1
// - j=0: 12 > 22? No swap
// - j=1: 22 > 11 -> swap -> [12, 11, 22, 25, 64]
// 
// Pass 4 (i=3): j goes from 0 to 0
// - j=0: 12 > 11 -> swap -> [11, 12, 22, 25, 64]
// 
// Final Sorted Array: [11, 12, 22, 25, 64]