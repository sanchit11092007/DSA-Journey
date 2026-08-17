import java.util.ArrayList; 
import java.util.List; 

/**
 * 📌 Problem: Print All Permutations of an Array
 * ⚡ Difficulty: Medium
 * 💡 Pattern: Recursion + Backtracking (Swap-Based)
 * 
 * 🔍 Description:
 * A permutation is any possible arrangement of the elements in an array.
 * For an array of size N, there are N! permutations.
 * This approach swaps elements to explore different choices and then swaps them back (backtracks)
 * to restore the array for the next choice.
 * 
 * 📈 Complexity Analysis:
 * - Time Complexity: O(N! * N) -> There are N! permutations, and copying each takes O(N) time.
 * - Space Complexity: O(N) -> The recursion stack depth is equal to the size of the array.
 */

public class PrintAllPermutations {
    public static void permute(int[] arr, int start, List<List<Integer>> result) {
        // Base Case: If we have fixed all positions, save the current permutation
        if (start == arr.length) {
            List<Integer> current = new ArrayList<>(); 
            for (int num : arr) {
                current.add(num); 
            }
            result.add(current); 
            return; 
        }

        // Recursive Step: Try placing each element at the 'start' position
        for (int i = start; i < arr.length; i++) {
            swap(arr, start, i);                  // Choose: Swap element at i to the start position
            permute(arr, start + 1, result);      // Explore: Recursively fix the next positions
            swap(arr, start, i);                  // Backtrack: Undo the swap for the next iterations
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i]; 
        arr[i] = arr[j]; 
        arr[j] = temp; 
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3}; 
        List<List<Integer>> result = new ArrayList<>(); 

        permute(arr, 0, result); 

        for (List<Integer> perm : result) {
            System.out.println(perm); 
        }
    }
}