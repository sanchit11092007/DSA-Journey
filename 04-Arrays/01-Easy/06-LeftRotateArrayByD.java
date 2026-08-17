/**
 * 📌 Problem: Left Rotate Array by D Places
 * ⚡ Difficulty: Easy
 * 💡 Pattern: Rotation using Reversal
 * 
 * 🔍 Description:
 * Rotates an array to the left by D positions.
 * - Brute Force: Shift left by 1 place, repeated D times.
 * - Optimal: Reverse the first D elements, reverse the remaining N-D elements, 
 *   and then reverse the entire array.
 * 
 * 📈 Complexity Analysis:
 * - Time Complexity:
 *   - Brute Force: O(N * D)
 *   - Optimal: O(N) -> Three linear-time reversals.
 * - Space Complexity:
 *   - Brute Force: O(1)
 *   - Optimal: O(1) -> Performed in-place.
 */

class LeftRotateArrayByD {

    // Approach 1: Brute Force - Rotate by One, D Times 
    public static void rotateBrute(int[] arr, int d) {
        if (arr == null || arr.length <= 1) {
            return; 
        }

        int n = arr.length; 
        d = d % n;  // Avoid redundant full rotations

        for (int count = 0; count < d; count++) {
            int first = arr[0]; 
            for (int i = 0; i < n - 1; i++) {
                arr[i] = arr[i + 1];
            }
            arr[n - 1] = first; 
        }
    }

    // Approach 2: Optimal - Reversal Trick 
    public static void rotateOptimal(int[] arr, int d) {
        if (arr == null || arr.length <= 1) {
            return; 
        }

        int n = arr.length; 
        d = d % n;  // Avoid redundant full rotations

        reverse(arr, 0, d - 1);     // Step 1: Reverse first D elements
        reverse(arr, d, n - 1);     // Step 2: Reverse remaining elements
        reverse(arr, 0, n - 1);     // Step 3: Reverse the whole array
    }

    // Helper method to reverse a portion of the array
    private static void reverse(int[] arr, int start, int end) {
        while (start < end) {
            int temp = arr[start]; 
            arr[start] = arr[end]; 
            arr[end] = temp; 
            start++; 
            end--; 
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7}; 
        rotateOptimal(arr, 2); 

        for (int val : arr) {
            System.out.print(val + " ");
        }
    }
}