/**
 * Problem: Find the Nth Fibonacci Number using Recursion
 * Difficulty: Easy 
 * Pattern: Multiple Recursion (calls itself twice per call)
 * 
 * What is the Fibonacci Sequence? 
 * Each number is the sum of the two numbers before it. 
 * 0, 1, 1, 2, 3, 5, 8, 13, 21,......
 * fib(0) = 0, fib(1) = 1, fib(n) = fib(n-1) + fib(n-2)
 * 
 * Approach: 
 * - Base case: if n == 0, return 0. If n == 1, return 1
 * - Recursive case: return fib(n-1) + fib(n-2)
 * - Unlike previous problems, this makes TWO recursive calls per call, not one- this is called "multiple recursion"
 */ 

public class FibonacciNumber {
    public static int fib(int n) {
        // base cases 
        if (n == 0) {
            return 0; 
        }
        if (n == 1) {
            return 1; 
        }
        // recursive case: sum of previous two fibonacci numbers 
        return fib(n-1) + fib(n-2);
    }

    public static void main(String[] args) {
        int n = 6; 
        int result = fib(n); 
        System.out.println("Fibonacci number at position " + n + " is: " + result);

        // Output: Fibonacci number at position 6 is: 8
    }
}


/**
 * fib(4)
├── fib(3)
│   ├── fib(2)
│   │   ├── fib(1) → 1
│   │   └── fib(0) → 0
│   └── fib(1) → 1
└── fib(2)
    ├── fib(1) → 1
    └── fib(0) → 0
 */