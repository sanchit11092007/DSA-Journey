/** 
 * Problem: Print Numbers from 1 to N using Recursion
 * Difficulty: Easy 
 * Pattern: Basic Recursion (Head Recursion)
 * 
 * Approach: 
 * - Base case: if n == 0, stop recursion
 * - Recursive case: call the function first with (n-1), THEN print n
 * - Since the print happens AFTER the recursive call, numbers get printed
 * in increasing order (1,2,3,....,N) as the calls return 
 * 
 * Time Complexity: 0(N) -> one call per value from N down to 1 
 * Space Complexity: 0(N) -> recursion stack holds N pending calls 
 */

public class PrintNumbers1ToN {
    public static void printNumbers(int n) {
        // base case 
        if (n == 0) {
            return ;
        }
        // recursive case (called BEFORE printing)
        printNumbers(n-1); 

        // work done AFTER the recursive call returns
        System.out.print(n + " "); 
    }

    public static void main(String[] args) {
        int n = 5; 
        printNumbers(n); 

        // Output: 1 2 3 4 5
    }
}