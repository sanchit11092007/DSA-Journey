/**
 * Problem: Factorial of N using Recursion
 * Difficulty: Easy 
 * Pattern: Math Recursion
 * 
 * What is Factorial? 
 * N! = N x (N - 1) x (N - 2) x ... x 1
 * Example: 5! = 5 x 4 x 3 x 2 x 1 = 120
 * 
 * Approach: 
 * - Base case: if n == 0 or n == 1, return 1 (0! and 1! are both 1)
 * - Recursive case: return n * factorial(n - 1)
 * - Each call multiplies its own n with the result of the smaller subproblem
 * 
 * Time Complexity: 0(N) -> one call per value from N down to 1 
 * Space Complexity: 0(N) -> recursion stack holds N pending calls 
 */

public class FactorialofN {

    public static int factorial(int n) {
        // base case 
        if (n == 0 || n == 1) {
            return 1; 
        } 
        // recursive case: n * factorial of remaining (n - 1)
        return n * factorial(n - 1); 
    }

    public static void main(String[] args) {
        int n = 5; 
        int result = factorial(n); 
        System.out.println("Factorial of " + n + " is: " + result); 

        // Output: Factorial of 5 is: 120
    }
}

/**
 * factorial(5) = 5 * factorial(4)
             = 5 * (4 * factorial(3))
             = 5 * (4 * (3 * factorial(2)))
             = 5 * (4 * (3 * (2 * factorial(1))))
             = 5 * (4 * (3 * (2 * 1)))
             = 120
 */