/**
 * 📌 Problem: Factorial of N
 * ⚡ Difficulty: Easy
 * 💡 Pattern: Math Recursion
 * 
 * 🔍 Description:
 * Factorial of N (written as N!) is the product of all positive integers from 1 to N.
 * Example: 5! = 5 * 4 * 3 * 2 * 1 = 120.
 * 
 * 📈 Complexity Analysis:
 * - Time Complexity: O(N) -> We make N recursive calls.
 * - Space Complexity: O(N) -> The recursion stack stores N active function calls.
 */

public class FactorialofN {

    public static int factorial(int n) {
        // Base Case: 0! and 1! are both 1
        if (n == 0 || n == 1) {
            return 1; 
        } 
        
        // Recursive Step: Multiply n with factorial of (n - 1)
        return n * factorial(n - 1); 
    }

    public static void main(String[] args) {
        int n = 5; 
        int result = factorial(n); 
        System.out.println("Factorial of " + n + " is: " + result); 
    }
}

// Trace:
// factorial(5) = 5 * factorial(4)
//              = 5 * (4 * factorial(3))
//              = 5 * (4 * (3 * factorial(2)))
//              = 5 * (4 * (3 * (2 * factorial(1))))
//              = 5 * (4 * (3 * (2 * 1)))
//              = 120