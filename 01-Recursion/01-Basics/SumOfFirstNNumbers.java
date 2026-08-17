/**
 * 📌 Problem: Sum of First N Numbers using Recursion
 * ⚡ Difficulty: Easy
 * 💡 Pattern: Basic Recursion
 * 
 * 🔍 Approach:
 * - Base Case: If n is 0, return 0 (sum of first 0 numbers is 0).
 * - Recursive Step: Return the current number n plus the sum of first (n - 1) numbers.
 * 
 * 📈 Complexity Analysis:
 * - Time Complexity: O(N) -> We make N recursive calls.
 * - Space Complexity: O(N) -> The recursion stack holds N active function calls.
 */

public class SumOfFirstNNumbers {
    
    public static int sum(int n) {
        // Base Case: Sum of first 0 numbers is 0
        if (n == 0) {
            return 0;
        }

        // Recursive Step: n + sum of (n - 1) numbers
        return n + sum(n - 1);
    }

    public static void main(String[] args) {
        int n = 5; 
        int result = sum(n); 
        System.out.println("Sum of first " + n + " numbers: " + result);
    }
}

// Expected Output: Sum of first 5 numbers: 15
// Trace:
// sum(5) = 5 + sum(4)
//        = 5 + (4 + sum(3))
//        = 5 + (4 + (3 + sum(2)))
//        = 5 + (4 + (3 + (2 + (1 + sum(0)))))
//        = 5 + (4 + (3 + (2 + (1 + 0))))
//        = 15