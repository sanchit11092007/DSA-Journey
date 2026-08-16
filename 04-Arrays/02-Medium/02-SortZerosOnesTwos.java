/**
 * Problem: Sort an Array of 0s,1s, and 2s
 * Pattern:Dutch National Flag Algorithm
 * 
 * Approach: 
 * 1. Brute Force: 
 *   Use any sorting algorithm or the Java built-in Arrays.sort()
 * 
 * 2. Better (Counting): 
 *    Count how many 0s, 1s, and 2s are there in the array in one pass. 
 *   Then overwrite the array in a second pass: first place all the 0s, then all the 1s, then all the 2's based on the counts. 
 * 
 * 3. Optimal (Dutch National Flag- Three Pointers): 
 *  Use three pointers: low, mid, high 
 *   - low tracks where the next 0 should go. 
 *   - high tracks where the next 2 should go. 
 *   - mid scans through the array 
 * 
 * Rules while mid <= high: 
 *   - If arr[mid] == 0, swap arr[low] and arr[mid], move low and mid forward. 
 *   - If arr[mid] == 1, just move mid forward (1 is already in the right zone). 
 *   - If arr[mid] == 2, swap arr[mid] and arr[high], move high backward (don't move mid yet, since the swapped-in value at mid still needs to be checked).
 *  By the end, the array is sorted in a single pass.
 * 
 * Edge Cases: 
 * - Empty array: nothing to sort, return as is. 
 * - Single element array: already sorted, return as is. 
 * - Array with only one distinct value (e.g. all 1s): works fine, no swap needed.
 * - Array already sorted: works fine, still 0(N) but no real change. 
 * - Array in reverse order (all 2s then 1s then 0s): works fine, swap happen correctly using low/mid/high logic.
 * 
 * Time Complexity: 
 * - Brute Force: 0(N log N)
 * - Better: 0(2N) ~ 0(N)
 * - Optimal: 0(N)
 * 
 * Space Complexity: 
 * - Brute Force: 0(1) 
 * - Better: 0(1) 
 * - Optimal: 0(1) 
 */


import java.util.Arrays;

class SortZerosOnesTwos {

    // Approach 1: Brute Force- Built-in Sort 
    public static void sortBrute(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }
        Arrays.sort(arr);
    }

    // Approach 2: Better - Counting 
    public static void sortBetter(int[] arr) {
        if(arr == null || arr.length <= 1) {
            return; 
        }

        int count0 = 0, count1 = 0, count2 = 0; 

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) count0++; 
            else if (arr[i] == 1) count1++; 
            else count2++;
        }

        int index = 0; 

        for (int i = 0; i < count0; i++) {
            arr[index++] = 0; 
        }
        for (int i = 0; i < count1; i++) {
            arr[index++] = 1; 
        }
        for (int i = 0; i < count2; i++) {
            arr[index++] = 2; 
        }
    }

    // Approach 3: Optimal - Dutch National Flag Algorithm
    public static void sortOptimal(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }

        int low = 0, mid = 0, high = arr.length - 1; 

        while (mid <= high) {
            if (arr[mid] == 0) {
                int temp = arr[low]; 
                arr[low] = arr[mid]; 
                arr[mid] = temp; 
                low ++; 
                mid ++;
            } else if (arr[mid] == 1) {
                mid++;
            } else {
                int temp = arr[mid]; 
                arr[mid] = arr[high]; 
                arr[high] = temp; 
                high --;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {2,0,2,1,1,0};
        sortOptimal(arr);
        System.out.println(Arrays.toString(arr)); 
        // Expected output: [0,0,1,1,2,2]
    }
}