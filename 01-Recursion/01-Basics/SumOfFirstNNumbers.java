/**
 * Problem: Sum of First N Numbers using Recursion
 * Difficulty: Easy 
 * Pattern: Basic Recursion (Tail Recursion style)
 * 
 * Approach: 
 * - Base case: if n == 0, return 0 (sum of nothing is 0)
 * - Recursive case: return n + sum of first (n-1) numbers 
 * - Each call adds the current n to the result of the smaller subproblem 
 * 
 * Time Complexity: 0(N) -> one call per value from N down to 0 
 * Space Complexity: 0(N) -> recursion stack holds N pending calls
 */


public class SumOfFirstNNumbers {
    
    public static int sum(int n) {
        // base case 
        if (n == 0) {
            return 0;
        }
        // recursive case: n + sum of remaining (n - 1) numbers 
        return n + sum(n - 1);
    }

    public static void main(String[] args) {
        int n = 5; 
        int result = sum(n); 
        System.out.println("Sum of first" + n + "numbers: " + result);

        // Output: Sum of first 5 numbers: 15 
        // (5 + 4 + 3 + 2 + 1 = 15)
    }
}

/**
 * sum(5) = 5 + sum(4)
 *        = 5 + (4 + sum(3))
 *        = 5 + (4 + (3 + sum(2)))
 *        = 5 + (4 + (3 + (2 + (1 + sum(0)))))
 *        = 5 + (4 + (3 + (2 + (1 + 0)))
 *        = 15
 */