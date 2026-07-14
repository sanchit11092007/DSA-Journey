/**
 * Problem: GCD (Greatest Common Divisor) of Two Numbers using Recursion 
 * Difficulty: Easy 
 * Pattern: Math Recursion (Euclidean Algorithm)
 * 
 * What is GCD? 
 * The largest number that divides both given numbers exactly. 
 * Example: GCD(20,8) -> 4 (since 4 is the largest number dividing both)
 * 
 * Euclid's Algorithm (the key insight): 
 * GCD(a,b) = GCD(b, a % b)
 * Keep replacing (a,b) with (b, a % b) until b becomes 0. 
 * At that point, a itself is the GCD.
 * 
 * Approach: 
 * - Base case: if b == 0, return a (a is the GCD) 
 * - Recursive case: call gcd(b, a % b)
 * 
 * Time Complexity: 0(log(min(a,b))) -> much faster than checking every number up to min(a,b)
 * Space Complexity: 0(log(min(a,b))) -> recursion stack
 */

public class GCDUsingRecursion {
    
    public static int gcd(int a, int b) {
        // base case 
        if (b == 0) {
            return a; 
        }
        // recursive case: replace (a,b) with (b,a%b)
        return gcd(b,a % b);
    }

    public static void main(String[] args) {
        int a = 20, b = 8; 
        int result = gcd(a,b); 
        System.out.println("GCD of " + a + " and " + b + " is: " + result);

        // Output: GCD of 20 and 8 is 4
    }
}