/**
 * 📌 Problem: Check if a Number is Prime
 * ⚡ Difficulty: Easy
 * 💡 Pattern: Math Recursion
 * 
 * 🔍 Description:
 * A prime number is a number greater than 1 that is only divisible by 1 and itself.
 * We test divisors starting from 2 up to sqrt(N). If no divisor is found by then, the number is prime.
 * 
 * 📈 Complexity Analysis:
 * - Time Complexity: O(sqrt(N)) -> We check divisors up to the square root of N.
 * - Space Complexity: O(sqrt(N)) -> Due to the recursion stack.
 */

public class PrimeNumbers {
    
    public static boolean isPrime(int n, int divisor) {
        // Base Case 1: If divisor * divisor > n, no divisor exists up to sqrt(n) -> n is prime
        if ((long) divisor * divisor > n) {
            return true;
        }
        
        // Base Case 2: If n is divisible by the current divisor, it is not prime
        if (n % divisor == 0) {
            return false; 
        }

        // Recursive Step: Check the next divisor
        return isPrime(n, divisor + 1);
    }

    public static void main(String[] args) {
        int n = 29; 
        boolean result = isPrime(n, 2);
        System.out.println(n + " is prime: " + result); 

        int n2 = 15; 
        System.out.println(n2 + " is prime: " + isPrime(n2, 2)); 
    }
}

// Trace for isPrime(29, 2):
// - divisor=2: 2*2=4  <= 29, 29%2 != 0 -> Recurse to 3
// - divisor=3: 3*3=9  <= 29, 29%3 != 0 -> Recurse to 4
// - divisor=4: 4*4=16 <= 29, 29%4 != 0 -> Recurse to 5
// - divisor=5: 5*5=25 <= 29, 29%5 != 0 -> Recurse to 6
// - divisor=6: 6*6=36 >  29            -> Return true