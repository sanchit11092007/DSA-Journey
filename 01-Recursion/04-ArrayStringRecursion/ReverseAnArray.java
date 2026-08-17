/**
 * 📌 Problem: Reverse an Array using Recursion
 * ⚡ Difficulty: Easy
 * 💡 Pattern: Array Recursion (Two-Pointer Style)
 * 
 * 🔍 Description:
 * Reverses an array in-place using a two-pointer recursion.
 * We swap the elements at the start and end pointers, then move the pointers closer to each other.
 * 
 * 📈 Complexity Analysis:
 * - Time Complexity: O(N) -> We swap elements roughly N / 2 times.
 * - Space Complexity: O(N) -> Due to the recursion stack.
 */

public class ReverseAnArray {
    
    public static void reverse(int[] arr, int start, int end) {
        // Base Case: If pointers meet or cross, the array is fully reversed
        if (start >= end) {
            return; 
        }

        // Action: Swap the elements at start and end positions
        int temp = arr[start]; 
        arr[start] = arr[end]; 
        arr[end] = temp; 

        // Recursive Step: Move both pointers inward and repeat
        reverse(arr, start + 1, end - 1);
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5}; 

        reverse(arr, 0, arr.length - 1); 

        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}