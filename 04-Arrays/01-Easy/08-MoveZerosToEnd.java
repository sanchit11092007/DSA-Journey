import java.util.Arrays; 

/**
 * 📌 Problem: Move Zeros to the End of the Array
 * ⚡ Difficulty: Easy
 * 💡 Pattern: Two Pointers
 * 
 * 🔍 Description:
 * Moves all zeros in the array to the end while maintaining the relative order of 
 * non-zero elements.
 * - Brute Force: Copy non-zero elements to a temporary array, then fill the remaining 
 *   positions with zeros, and copy back.
 * - Optimal: Maintain a pointer `j` to track the position of the next non-zero element. 
 *   Scan the array with `i`, and swap `arr[i]` with `arr[j]` whenever `arr[i] != 0`.
 * 
 * 📈 Complexity Analysis:
 * - Time Complexity:
 *   - Brute Force: O(N)
 *   - Optimal: O(N) -> Single pass.
 * - Space Complexity:
 *   - Brute Force: O(N) -> Uses a temporary array.
 *   - Optimal: O(1) -> Performed in-place.
 */

class MoveZerosToEnd {

    // Approach 1: Brute Force 
    public static void moveZerosBrute(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }

        int n = arr.length; 
        int[] temp = new int[n]; 
        int index = 0; 

        // Copy non-zero elements to temp array
        for (int i = 0; i < n; i++) {
            if (arr[i] != 0) {
                temp[index] = arr[i]; 
                index++;
            }
        }

        // Fill remaining spaces in temp with zeros
        while (index < n) {
            temp[index] = 0; 
            index++;
        }

        // Copy temp back to original array
        for (int i = 0; i < n; i++) {
            arr[i] = temp[i];
        }
    }

    // Approach 2: Optimal
    public static void moveZerosOptimal(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }
        int j = 0;  // Pointer for the next non-zero element position

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                // Swap non-zero element with the element at j
                int temp = arr[i]; 
                arr[i] = arr[j]; 
                arr[j] = temp; 
                j++;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr1 = {0, 1, 0, 3, 12}; 
        moveZerosBrute(arr1);
        System.out.println(Arrays.toString(arr1)); 

        int[] arr2 = {0, 1, 0, 3, 12}; 
        moveZerosOptimal(arr2);
        System.out.println(Arrays.toString(arr2));
    }
}