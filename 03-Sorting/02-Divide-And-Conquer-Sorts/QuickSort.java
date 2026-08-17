import java.util.Arrays;

/**
 * 📌 Problem: Quick Sort
 * ⚡ Difficulty: Medium
 * 💡 Pattern: Divide and Conquer
 * 
 * 🔍 Description:
 * Selects a 'pivot' element and partitions the array such that elements smaller than the 
 * pivot are moved to its left, and elements greater are moved to its right. It then 
 * recursively sorts the left and right sub-arrays. This is done in-place.
 * 
 * 📈 Complexity Analysis:
 * - Time Complexity:
 *   - Average Case: O(N log N) -> When the pivot splits the array relatively evenly.
 *   - Worst Case: O(N^2) -> When the pivot is consistently the smallest or largest element (e.g. sorted input).
 * - Space Complexity: O(log N) -> Average depth of the recursion call stack.
 */

public class QuickSort {

    static void quickSort(int[] arr, int low, int high) {
        // Base Case: Sub-array of size 1 or 0 is already sorted
        if (low >= high) {
            return;
        }

        int pivotIndex = partition(arr, low, high);

        quickSort(arr, low, pivotIndex - 1);  // Sort the left part recursively
        quickSort(arr, pivotIndex + 1, high); // Sort the right part recursively
    }

    static int partition(int[] arr, int low, int high) {
        int pivot = arr[low];
        int i = low;
        int j = high;

        while (i < j) {
            // Find the first element greater than the pivot from the left
            while (arr[i] <= pivot && i < high) {
                i++;
            }
            // Find the first element smaller than or equal to the pivot from the right
            while (arr[j] > pivot) {
                j--;
            }

            // Swap them if pointers haven't crossed
            if (i < j) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // Place the pivot in its correct sorted position
        int temp = arr[low];
        arr[low] = arr[j];
        arr[j] = temp;

        return j; // Return the final index of the pivot
    }

    public static void main(String[] args) {
        int[] arr = {64, 25, 12, 22, 11};

        quickSort(arr, 0, arr.length - 1);

        System.out.println(Arrays.toString(arr));
    }
}