/**
 * Problem: Check if a Number Prime using Recursion 
 * Difficulty: Easy 
 * Pattern: Math Recursion 
 * 
 * What is a Prime Number?
 * A number greater than 1 that has no divisors other than 1 and itself.
 * Example: 7 is prime (only divisible by 1 and 7). 8 is not (divisible by 2 , 4).
 * 
 * Approach:
 * - Start checking divisors from 2 upwards 
 * - Base case 1: if divisor * divisor > n, no divisor was found -> n IS prime 
 * - Base case 2: if n % divisor == 0, a divisor was found -> n is NOT prime
 * - Recursive case: move to the next divisor (divisor + 1) and check again 
 * - We only need to check up to sqrt(n) -> if no divisor exists till sqrt(n), none will exist beyond it either
 * 
 * Time Complexity: 0(sqrt(N)) -> only checks divisors up to sqrt(n)
 * Space Complexity: 0(sqrt(N)) -> recursion stack 
 */

public class PrimeNumbers {
    
    public static boolean isPrime(int n, int divisor) {
        // base case: no divisor found up to sqrt(n) -> n is prime
        if ((long) divisor * divisor > n) {
            return true;
        }
        // base case: divisor found -> n is NOT prime 
        if (n % divisor == 0) {
            return false; 
        }

        // recursive case: check the next divisor 
        return isPrime(n, divisor + 1);
    }

    public static void main(String[] args) {
        int n = 29; 
        boolean result = isPrime(n,2);
        System.out.println(n + " is prime: " + result); 

        // Output: 29 is prime: true 

        int n2 = 15; 
        System.out.println(n2 + " is prime: " + isPrime(n2,2)); 

        // Output: 15 is prime: false 
    }
}

/**
 * isPrime(29, 2) → 2*2=4, not >29, 29%2≠0 → check next
isPrime(29, 3) → 3*3=9, not >29, 29%3≠0 → check next
isPrime(29, 4) → 4*4=16, not >29, 29%4≠0 → check next
isPrime(29, 5) → 5*5=25, not >29, 29%5≠0 → check next
isPrime(29, 6) → 6*6=36, >29 → return true
 */