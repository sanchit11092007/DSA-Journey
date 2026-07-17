/**
 * Problem: Reverse an Array using Recursion 
 * Difficulty: Easy 
 * Pattern: Array Recursion (Two-Pointer style)
 * 
 * Approach: 
 * - Same two-pointer idea as CheckPallindromeString - one pointer from the start, one from the en 
 * - Base case: if start >= end, the whole array has been swapper -> stop 
 * - Recursive case: swap arr[start] and arr[end], then move both pointers inward (start + 1, end - 1) and recurse 
 * 
 * Time Complexity: 0(N/2) -> 0(N) -> visits roughly half the array (each call handles 2 elements)
 * Space Complexity: 0(N) -> recursion stack depth 
 */

public class ReverseAnArray {
    
    public static void reverse(int[] arr, int start, int end) {
        // base case: pointers have met or crossed -> fully reversed 
        if (start >= end) {
            return; 
        }

        // swap current pair 
        int temp = arr[start]; 
        arr[start] = arr[end]; 
        arr[end] = temp; 

        // recursive case: move both pointers inward 
        reverse(arr, start + 1, end - 1);
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5}; 

        reverse(arr, 0, arr.length-1); 

        for (int num:arr) {
            System.out.print(num + " ");
        }

        // Output: 5 4 3 2 1 
    }

}