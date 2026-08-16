/**
 * Problem: Move Zeros to End of Array 
 * Pattern: Two Pointers 
 * 
 * Approaches: 
 * 1. Brute Force (Extra Array): 
 *     Create a new array. Walk through the original array and copy all non-zero values into the new array in order. 
 *     Then fill the rest of the new array with zeros. Copy this new array back into the original. 
 *   Works, but uses extra space. 
 * 
 * 2. Optimal (Two Pointers): 
 *     Keep a pointer 'j' that tracks the position where the next non-zero value should go. 
 *     Walk through the array with pointer 'i'. Whenever arr[i] is non-zero, swap it with arr[j], then move j forward. 
 *    This pushes all non-zero values to the front in order. and all zeros naturally end up at the back. 
 *   No extra array needed, and it's done in a single pass.
 * 
 * Edge Cases: 
 * - Empty array: nothing to move, return as is. 
 * - Single element array: stays the same either way. 
 * - All zeros: nothing moves, array stays all zeros. 
 * - No zeros at all: array stays exactly the same, since i and j stay equal the whole time and every swap is with itself. 
 * - Zeros already at the end: still works correctly, no unnecessary changes to order.
 * 
 * Time Complexity: 
 * - Brute Force: 0(N) - one pass to collect non-zeros, one pass to fill zeros, one pass to copy back- still counts as 0(N) overall
 * - Optimal: 0(N) - single pass with two pointers
 * 
 * Space Complexity: 
 * - Brute Force: 0(N) - extra array used 
 * - Optimal: 0(1) - done in place, no extra array
 */

import java.util.Arrays; 

class MoveZerosToEnd {

    // Approach 1: Brute Force 
    public static void moveZerosBrute(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }

        int n = arr.length; 
        int[] temp = new int[n]; 
        int index = 0; 

        for (int i = 0; i < n; i++) {
            if (arr[i] != 0) {
                temp[index] = arr[i]; 
                index ++;
            }
        }

        while (index < n) {
            temp[index] = 0; 
            index ++;
        }

        for (int i = 0; i < n; i++) {
            arr[i] = temp[i];
        }
    }

    // Approach 2: Optimal
    public static void moveZerosOptimal(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }
        int j = 0;  // position for next non-zero value

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                int temp = arr[i]; 
                arr[i] = arr[j]; 
                arr[j] = temp; 
                j++;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr1 = {0,1,0,3,12}; 
        moveZerosBrute(arr1);
        System.out.println(Arrays.toString(arr1)); 

        int[] arr2 = {0,1,0,3,12}; 
        moveZerosOptimal(arr2);
        System.out.println(Arrays.toString(arr2));
    }
}