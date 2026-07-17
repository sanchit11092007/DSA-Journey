import java.util.ArrayList; 
import java.util.List; 

/**
 * Problem: Print All Permutations of an Array using Recursion 
 * Difficulty: Medium 
 * Pattern: Recursion + Backtracking (swap-based approach)
 * 
 * What is Permutation? 
 * Every possible arrangement of the elements of an array. 
 * Example: [1,2,3] has 3! = 6 permutations: 
 * [1,2,3] [1,3,2] [2,1,3] [2,3,1] [3,1,2] [3,2,1]
 * 
 * Approach (Swap-based Backtracking): 
 * - Use an index "start" to mark which position we're currently fixing 
 * - Base case: if start == arr.length, all permutations are fixed -> we have one complete permutation -> save/print it.
 * - Recursive case: for every index i from start to end, 
 *   1. Swap arr[start] with arr[i]  -> "choose" element at i for this position 
 *   2. Recurse with (start + 1)     -> fix the next position 
 *   3. Swap back arr[start] with arr[i] -> "undo" the choice (BACKTRACK)
 * - The swap-back step is critical - without it, the array stays modified and later permutations become incorrect 
 * 
 * Time Complexity: 0(N! * N) -> N! permutations, 0(N) to copy each one 
 * Space Complexity: 0(N) -> recursion stack depth (+0(N! * N) to store all results)
 */

public class PrintAllPermutations {
    public static void permute(int arr[], int start, List<List<Integer>> result) {
        // base case: fixed all positions -> one full permutation is ready 
        if (start == arr.length) {
            List<Integer> current = new ArrayList<>(); 
            for (int num: arr) {
                cirrent.add(num); 
            }
            result.add(current); 
            return; 
        }

        // recursive case: try every element at position "start"
        for (int i = start; i < arr.length; i++) {
            swap(arr,start,i);    //choose 
            permute(arr,start + 1, result);   // recurse (explore)
            swap(arr,start,i);  // un-choose (backtrack)
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i]; 
        arr[i] = arr[j]; 
        arr[j] = temp; 
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3}; 
        List<List<Integer>> result = new ArrayList<>(); 

        permute(arr,0,result); 

        for (List<Integer> perm: result) {
            System.out.println(perm); 
        }

        // Output: 
        // [1, 2, 3]
        // [1, 3, 2]
        // [2, 1, 3]
        // [2, 3, 1]
        // [3, 1, 2]
        // [3, 2, 1]
    }
}