/**
 * Problem: Check if a Number is an Armstrong Number using Recursion
 * Difficulty: Easy
 * Patter: Math Recursion
 * 
 * What is an Armstrong Number ? 
 * A number is Armstrong if the sum of its own digits, each raised to the power of the total number of digits, equals the number itself. 
 * Example: 153 -> 1^3 + 5^3 + 3^3 = 1 + 125 + 27 = 153 ~
 * 
 * Approach: 
 * - First find the total number of digits (needed for the power)
 * - Base case: if n == 0, return 0 (nothing left to add)
 * - Recursive case: take the last digit (n % 10), raise to the power of totalDigits, and add it to the recursive call on the rest of the number (n / 10)
 * - Compare the final sum with the original number
 * 
 * Time Complexity: 0(D) where D = numbe of digits 
 * Space Complexity: 0(D) -> recursion stack
 */

public class ArmstrongNumber {
    public static int countDigits(int n) {
        // base case 
        if (n == 0) {
            return 0; 
        }
        // recursive case: 1 for current digit + count of remaining digits
        return 1 + countDigits(n / 10);
    }
    public static int sumOfPowers(int n, int totalDigits) {
        // base case 
        if (n == 0) {
            return 0;
        }
        int lastDigit = n % 10; 
        int power = (int) Math.pow(lastDigit,totalDigits); 

        //recursion case: current digit's power + sum from remaining digits
        return power + sumOfPowers(n / 10, totalDigits);
    }

    public static boolean isArmstrong(int n) {
        int totalDigits = countDigits(n); 
        int sum = sumOfPowers(n , totalDigits); 
        return sum == n; 
    }

    public static void main(String[] args) {
        int n = 153; 
        boolean result = isArmstrong(n);
        System.out.println(n + " is Armstrong: " + result); 

        // Output: 153 is Armstrong: true 

        int n2 = 123; 
        System.out.println(n2 + " is Armstrong: " + isArmstrong(n2)); 

        // Output: 123 is Armstrong: false 
    }
}