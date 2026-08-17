/**
 * 📌 Problem: Print "Programming" N times using Recursion
 * ⚡ Difficulty: Easy
 * 💡 Pattern: Basic Recursion
 * 
 * 🔍 Approach:
 * - Base Case: If n is 0, stop recursion.
 * - Recursive Step: Print the message first, then call the function with (n - 1).
 * 
 * 📈 Complexity Analysis:
 * - Time Complexity: O(N) -> We make N recursive calls.
 * - Space Complexity: O(N) -> The recursion stack holds N active function calls.
 */

public class PrintNTimes {
    public static void printN(int n) {
        // Base Case: Stop recursion when n reaches 0
        if (n == 0) {
            return; 
        }

        // Action: Print the message
        System.out.println("Programming");

        // Recursive Step: Call the function for (n - 1)
        printN(n - 1);
    }

    public static void main(String[] args) {
        int n = 5; 
        printN(n); 
    }
}

// Expected Output:
// Programming
// Programming
// Programming
// Programming
// Programming