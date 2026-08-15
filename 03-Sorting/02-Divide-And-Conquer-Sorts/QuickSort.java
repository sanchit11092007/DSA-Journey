import java.util.Arrays;

/**
 * Problem: Quick Sort
 * Difficulty: Medium
 * Pattern: DIvide and Conquer - partition around a pivot, then recurse
 * Approach:
 * 1. Pick a "pivot" element from the array (here, we pick the first element of
 * the current range)
 * 2. Partition: rearrange the array so that all elements smaller than the pivot
 * end up on its left, and all elements greater end up on its right.
 * After partioning, pivot is ints final correct sorted position
 * 3. Recursively apply the same process to the left part (elements smaller than
 * pivot) and the right part (elements greater than pivot).
 * 4. Base case: a sub-array of size 1 or 0 is already sorted - stop recursing.
 * 5. Unlike Merge Sort, there's no separate "merge" step - the array is sorted
 * in-place purely through partitioning.
 * 
 * Time Complexity:
 * Average case: 0(nlogn) - pivot roughly splits array in half each time.
 * Worst case: 0(n^2): happens when pivot is always the smallest or largest
 * element
 * (e.g. already sorted array with the first-element pivot), casuing very
 * unbalanced splits.
 * Space Complexity: 0(log n) - no extra array needed (unline Merge Sort), but
 * recursion call stack uses 0(log n) space on average (0(n) worst case).
 */

public class QuickSort {

    static void quickSort(int[] arr, int low, int high) {
        // base case: a sub-array of size 1 (or 0) is already sorted
        if (low >= high) {
            return;
        }

        int pivotIndex = partition(arr, low, high);

        quickSort(arr, low, pivotIndex - 1); // sort left part
        quickSort(arr, pivotIndex + 1, high); // sort right part
    }

    static int partition(int arr[], int low, int high) {
        int pivot = arr[low];
        int i = low;
        int j = high;

        while (i < j) {
            // move i right until we find an element greater than pivot
            while (arr[i] <= pivot && i < high) {
                i++;
            }
            // move j left until we find an element smaller than or equal to pivot
            while (arr[j] > pivot) {
                j--;
            }

            // if i is still left of j, swap them (both are out of place)
            if (i < j) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // place pivot in its correct final position (at index j)
        int temp = arr[low];
        arr[low] = arr[j];
        arr[j] = temp;

        return j; // pivot's final index
    }

    public static void main(String[] args) {
        int[] arr = { 64, 25, 12, 22, 11 };

        quickSort(arr, 0, arr.length - 1);

        System.out.println(Arrays.toString(arr));
        // Expected output: [11,12,22,25,64];
    }
}