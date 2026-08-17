/**
 * 📌 Problem: Find the Nth Fibonacci Number
 * ⚡ Difficulty: Easy
 * 💡 Pattern: Multiple Recursion
 * 
 * 🔍 Description:
 * The Fibonacci sequence is a series of numbers where each number is the sum 
 * of the two preceding ones, starting from 0 and 1.
 * formula: fib(n) = fib(n-1) + fib(n-2) where fib(0) = 0 and fib(1) = 1.
 * 
 * 📈 Complexity Analysis:
 * - Time Complexity: O(2^N) -> Each call branches into two more calls.
 * - Space Complexity: O(N) -> The recursion stack depth goes up to N.
 */

public class FibonacciNumber {
    public static int fib(int n) {
        // Base Cases: Return n if it is 0 or 1
        if (n == 0) {
            return 0; 
        }
        if (n == 1) {
            return 1; 
        }
        
        // Recursive Step: Sum of the two preceding Fibonacci numbers
        return fib(n - 1) + fib(n - 2);
    }

    public static void main(String[] args) {
        int n = 6; 
        int result = fib(n); 
        System.out.println("Fibonacci number at position " + n + " is: " + result);
    }
}

// Recursion Tree for fib(4):
// fib(4)
// ├── fib(3)
// │   ├── fib(2)
// │   │   ├── fib(1) -> 1
// │   │   └── fib(0) -> 0
// │   └── fib(1) -> 1
// └── fib(2)
//     ├── fib(1) -> 1
//     └── fib(0) -> 0