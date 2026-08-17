/**
 * 📌 Problem: Print Numbers from 1 to N using Recursion
 * ⚡ Difficulty: Easy
 * 💡 Pattern: Head Recursion (Action after recursive call)
 * 
 * 🔍 Approach:
 * - Base Case: If n is 0, stop recursion.
 * - Recursive Step: Call the function with (n - 1) first, and then print the current number.
 *   Since the print happens *after* the recursive call returns, numbers are printed in increasing order (1 to N).
 * 
 * 📈 Complexity Analysis:
 * - Time Complexity: O(N) -> We make N recursive calls.
 * - Space Complexity: O(N) -> The recursion stack holds N active function calls.
 */

public class PrintNumbers1ToN {
    public static void printNumbers(int n) {
        // Base Case: Stop recursion when n reaches 0
        if (n == 0) {
            return;
        }

        // Recursive Step: Go deeper first to print smaller numbers first
        printNumbers(n - 1); 

        // Action: Print the current number after returning from deeper calls
        System.out.print(n + " "); 
    }

    public static void main(String[] args) {
        int n = 5; 
        printNumbers(n); 
    }
}

// Expected Output: 1 2 3 4 5