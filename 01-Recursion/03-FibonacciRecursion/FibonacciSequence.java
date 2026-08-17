/**
 * 📌 Problem: Print Fibonacci Sequence up to N Terms
 * ⚡ Difficulty: Easy
 * 💡 Pattern: Multiple Recursion
 * 
 * 🔍 Description:
 * Prints the first N numbers of the Fibonacci sequence by calling the recursive 
 * Fibonacci function for each position from 0 to N-1.
 * 
 * 📈 Complexity Analysis:
 * - Time Complexity: O(N * 2^N) -> Since we calculate fib(i) for each term from 0 to N-1.
 * - Space Complexity: O(N) -> The recursion stack depth goes up to N.
 */

public class FibonacciSequence {
    // Calculates the Nth Fibonacci number
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

    // Prints the sequence up to N terms
    public static void printSequence(int n) {
        for (int i = 0; i < n; i++) {
            System.out.print(fib(i) + " ");
        }
    }

    public static void main(String[] args) {
        int n = 8; 
        printSequence(n);
    }
}