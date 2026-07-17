/**
 * Problem: Print the Fibonacci Sequence up to N terms using Recursion 
 * Difficulty: Easy 
 * Pattern: Multiple Recursion + Head Recursion 
 * 
 * Approach: 
 * - This reuses the same fib(n) logic from FibonacciNumber.java
 * - To print the whole SEQUENCE (not just one number), loop from 0 to N - 1 and call fib(i) for each position
 * - Base call for fib: n == 0 -> return 0, n == 1 -> return 1 
 * - Recursive case for fib: fib(n-1) + fib(n-2)
 * 
 * Time Complexity: O(N * 2^N) -> fib(i) is O(2^i), called N times in the loop
 * O(N) -> max recursion depth at any single fib(i) call
 */


public class FibonacciSequence {
    public static int fib(int n) {
        // base cases 
        if (n == 0) {
            return 0; 
        }
        if (n == 1) {
            return 1; 
        }
        // recursive case 
        return fib(n-1) + fib(n-2);
    }

    public static void printSequence(int n) {
        for (int i = 0; i < n; i++) {
            System.out.print(fib(i) + " ");
        }
    }

    public static void main(String[] args) {
        int n = 8; 
        printSequence(n); 

        // Output: 0 1 1 2 3 5 8 13 
    }
}