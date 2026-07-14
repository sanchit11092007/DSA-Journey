/**
 * Problem: Print Numbers from N to 1 using Recursion
 * Difficulty: Easy
 * Pattern: Basic Recursion (Tail Recursion)
 *
 * Approach:
 * - Base case: if n == 0, stop recursion
 * - Recursive case: print n FIRST, THEN call the function with (n - 1)
 * - Since the print happens BEFORE the recursive call, numbers get printed
 *   in decreasing order (N, N-1, ..., 1) as each call runs
 *
 * Time Complexity: O(N) -> one call per value from N down to 1
 * Space Complexity: O(N) -> recursion stack holds N pending calls
 */
public class PrintNumbersNTo1 {

    public static void printNumbers(int n) {
        // base case
        if (n == 0) {
            return;
        }

        // work done BEFORE the recursive call
        System.out.print(n + " ");

        // recursive case (called AFTER printing)
        printNumbers(n - 1);
    }

    public static void main(String[] args) {
        int n = 5;
        printNumbers(n);

        // Output: 5 4 3 2 1
    }
}