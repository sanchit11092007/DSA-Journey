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
 *  Selection Sort Dry Run
Initial Array: [64, 25, 12, 22, 11]

Pass 1 (i=0), scanning j from 1 to 4 for minimum:
  start: minIndex=0 (value 64)
  j=1: 25 < 64 -> minIndex=1
  j=2: 12 < 25 -> minIndex=2
  j=3: 22 < 12? No
  j=4: 11 < 12 -> minIndex=4
  Minimum found at index 4 (value 11) -> swap arr[0] and arr[4]
After Pass 1: [11, 25, 12, 22, 64]

Pass 2 (i=1), scanning j from 2 to 4 for minimum:
  start: minIndex=1 (value 25)
  j=2: 12 < 25 -> minIndex=2
  j=3: 22 < 12? No
  j=4: 64 < 12? No
  Minimum found at index 2 (value 12) -> swap arr[1] and arr[2]
After Pass 2: [11, 12, 25, 22, 64]

Pass 3 (i=2), scanning j from 3 to 4 for minimum:
  start: minIndex=2 (value 25)
  j=3: 22 < 25 -> minIndex=3
  j=4: 64 < 22? No
  Minimum found at index 3 (value 22) -> swap arr[2] and arr[3]
After Pass 3: [11, 12, 22, 25, 64]

Pass 4 (i=3), scanning j=4 for minimum:
  start: minIndex=3 (value 25)
  j=4: 64 < 25? No
  Minimum already at index 3 -> minIndex == i -> no swap
After Pass 4: [11, 12, 22, 25, 64]

Final Sorted Array: [11, 12, 22, 25, 64]

Note: Unlike Bubble Sort, Selection Sort always scans the full remaining
unsorted range every pass, even when nothing needs to move (see Pass 4).
There's no early-exit optimization possible here - that's why Selection
Sort is always O(n^2), even on a nearly-sorted array.
 */