/**
 * 📌 Problem: Print Numbers from N to 1 using Recursion
 * ⚡ Difficulty: Easy
 * 💡 Pattern: Tail Recursion (Action before recursive call)
 * 
 * 🔍 Approach:
 * - Base Case: If n is 0, stop recursion.
 * - Recursive Step: Print the current number first, then call the function with (n - 1).
 *   Since the print happens *before* the recursive call, numbers are printed in decreasing order (N to 1).
 * 
 * 📈 Complexity Analysis:
 * - Time Complexity: O(N) -> We make N recursive calls.
 * - Space Complexity: O(N) -> The recursion stack holds N active function calls.
 */

public class PrintNumbersNTo1 {
    public static void printNumbers(int n) {
        // Base Case: Stop recursion when n reaches 0
        if (n == 0) {
            return;
        }

        // Action: Print current number before going deeper
        System.out.print(n + " ");

        // Recursive Step: Call function with (n - 1)
        printNumbers(n - 1);
    }

    public static void main(String[] args) {
        int n = 5;
        printNumbers(n);
    }
}

// Expected Output: 5 4 3 2 1