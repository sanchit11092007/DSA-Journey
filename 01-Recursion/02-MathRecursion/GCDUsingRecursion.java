/**
 * 📌 Problem: Greatest Common Divisor (GCD) of Two Numbers
 * ⚡ Difficulty: Easy
 * 💡 Pattern: Euclidean Algorithm (Math Recursion)
 * 
 * 🔍 Description:
 * The GCD of two numbers is the largest positive integer that divides both numbers without leaving a remainder.
 * Euclid's Algorithm states: GCD(a, b) = GCD(b, a % b).
 * This reduces (a, b) until b becomes 0, at which point 'a' is the GCD.
 * 
 * 📈 Complexity Analysis:
 * - Time Complexity: O(log(min(a, b))) -> The parameters reduce exponentially.
 * - Space Complexity: O(log(min(a, b))) -> Due to the recursion stack.
 */

public class GCDUsingRecursion {
    
    public static int gcd(int a, int b) {
        // Base Case: If b becomes 0, then a is the GCD
        if (b == 0) {
            return a; 
        }
        
        // Recursive Step: Replace (a, b) with (b, a % b)
        return gcd(b, a % b);
    }

    public static void main(String[] args) {
        int a = 20, b = 8; 
        int result = gcd(a, b); 
        System.out.println("GCD of " + a + " and " + b + " is: " + result);
    }
}

// Trace:
// gcd(20, 8)
// = gcd(8, 20 % 8) -> gcd(8, 4)
// = gcd(4, 8 % 4)  -> gcd(4, 0)
// = b is 0, so returns 4