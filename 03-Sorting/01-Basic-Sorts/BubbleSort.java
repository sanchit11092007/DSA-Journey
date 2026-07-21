import java.util.Arrays; 

/**
 * Problem: Bubble Sort 
 * Difficulty: Easy 
 * Pattern: In - place comparison sort - repeatedly swap adjacent out-of-order elements
 * Approach: 
 *   1. Compare each pair of adjacent elements in the array. 
 *   2. If the left element is greater than the right, swap them. 
 *   3. After one full pass through the array, the largest element "bubbles up" to its correct position at the end. 
 *   4. Repeat this process for the remaining unsorted part (excluding the last element(s) already placed correctly).
 *   5. Optimization: if during a pass no swaps happen at all, the array is already sorted - stop early instead of doing unnecessary passes. 
 * 
 * Time Complexity: 
 *    Worst/ Average case: 0(n^2) - array is reverse sorted or random, need full passes . 
 *    Best case: 0(n) - array is already sorted, detected via the no-swap flag. so we exit after just one pass. 
 * 
 * Space Complexity: 0(1) - sorting is done in-place, no extra array used.
 */


public class BubbleSort {

    static void bubbleSort(int[] arr) {
        int n = arr.length; 

        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false; 

            // last i elements are already sorted, so shrink the range each pass 
            for (int j = 0; j < n - 1; j++) {
                if (arr[j] > arr[j+1]) {
                    int temp = arr[j]; 
                    arr[j] = arr[j+1]; 
                    arr[j+1] = temp; 
                    swapped = true;
                }
            }

            // if no two elements were swapped, array is already sorted 
            if (!swapped) {
                break; 
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {64,25,12,22,11}; 

        bubbleSort(arr); 

        System.out.println(Arrays.toString(arr)); 
        // Expected output: [11,12,22,25,64]
    }
}


/**
 * Bubble Sort Dry Run
Initial Array: [64, 25, 12, 22, 11]

Pass 1 (i=0), j from 0 to 3:
  j=0: 64 > 25 -> swap -> [25, 64, 12, 22, 11]
  j=1: 64 > 12 -> swap -> [25, 12, 64, 22, 11]
  j=2: 64 > 22 -> swap -> [25, 12, 22, 64, 11]
  j=3: 64 > 11 -> swap -> [25, 12, 22, 11, 64]
  swapped = true
After Pass 1: [25, 12, 22, 11, 64]

Pass 2 (i=1), j from 0 to 2:
  j=0: 25 > 12 -> swap -> [12, 25, 22, 11, 64]
  j=1: 25 > 22 -> swap -> [12, 22, 25, 11, 64]
  j=2: 25 > 11 -> swap -> [12, 22, 11, 25, 64]
  swapped = true
After Pass 2: [12, 22, 11, 25, 64]

Pass 3 (i=2), j from 0 to 1:
  j=0: 12 > 22? No  -> [12, 22, 11, 25, 64]
  j=1: 22 > 11 -> swap -> [12, 11, 22, 25, 64]
  swapped = true
After Pass 3: [12, 11, 22, 25, 64]

Pass 4 (i=3), j=0 only:
  j=0: 12 > 11 -> swap -> [11, 12, 22, 25, 64]
  swapped = true
After Pass 4: [11, 12, 22, 25, 64]

Final Sorted Array: [11, 12, 22, 25, 64]

Note: In this array, every pass had at least one swap, so the early-exit
(swapped == false) never triggered. Try dry-running on [1, 2, 3, 4, 5]
to see Pass 1 complete with zero swaps and the loop break immediately.
 */