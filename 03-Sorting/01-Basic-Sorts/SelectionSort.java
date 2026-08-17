import java.util.Arrays; 

/**
 * 📌 Problem: Selection Sort
 * ⚡ Difficulty: Easy
 * 💡 Pattern: In-Place Comparison Sort
 * 
 * 🔍 Description:
 * Divides the array into a sorted and an unsorted part. It repeatedly finds the minimum 
 * element from the unsorted part and swaps it with the first element of the unsorted part.
 * This moves the boundary of the sorted portion one element to the right.
 * 
 * 📈 Complexity Analysis:
 * - Time Complexity: O(N^2) -> In all cases (best, average, worst), as it always scans the rest of the array.
 * - Space Complexity: O(1) -> Sorting is done in-place.
 */

public class SelectionSort {

    static void selectionSort(int[] arr) {
        int n = arr.length; 

        for (int i = 0; i < n - 1; i++) {
            int minIndex = i; 

            // Find the index of the smallest element in the remaining unsorted part
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j; 
                }
            }

            // Swap the found minimum element with the first element of the unsorted part
            if (minIndex != i) {
                int temp = arr[i]; 
                arr[i] = arr[minIndex]; 
                arr[minIndex] = temp; 
            }
        }
    }
    
    public static void main(String[] args) {
        int[] arr = {64, 25, 12, 22, 11}; 

        selectionSort(arr); 

        System.out.println(Arrays.toString(arr)); 
    }
}

// Dry Run:
// Initial Array: [64, 25, 12, 22, 11]
// 
// Pass 1 (i=0): minIndex starts at 0 (value 64)
// - Scan indices 1 to 4 -> Min is at index 4 (value 11)
// - Swap index 0 and 4 -> [11, 25, 12, 22, 64]
// 
// Pass 2 (i=1): minIndex starts at 1 (value 25)
// - Scan indices 2 to 4 -> Min is at index 2 (value 12)
// - Swap index 1 and 2 -> [11, 12, 25, 22, 64]
// 
// Pass 3 (i=2): minIndex starts at 2 (value 25)
// - Scan indices 3 to 4 -> Min is at index 3 (value 22)
// - Swap index 2 and 3 -> [11, 12, 22, 25, 64]
// 
// Pass 4 (i=3): minIndex starts at 3 (value 25)
// - Scan index 4 -> Min is already at index 3
// - No swap -> [11, 12, 22, 25, 64]
// 
// Final Sorted Array: [11, 12, 22, 25, 64]