/**
 * 📌 Problem: Check if a Number is an Armstrong Number
 * ⚡ Difficulty: Easy
 * 💡 Pattern: Math Recursion
 * 
 * 🔍 Description:
 * An Armstrong number is a number that equals the sum of its own digits, 
 * each raised to the power of the total number of digits.
 * Example: 153 -> 1^3 + 5^3 + 3^3 = 1 + 125 + 27 = 153 (Armstrong).
 * 
 * 📈 Complexity Analysis:
 * - Time Complexity: O(D) -> where D is the number of digits.
 * - Space Complexity: O(D) -> due to the recursion stack.
 */

public class ArmstrongNumber {
    
    // Helper function to count total digits in the number
    public static int countDigits(int n) {
        // Base Case: No digits left
        if (n == 0) {
            return 0; 
        }
        // Recursive Step: Count current digit + count of remaining digits
        return 1 + countDigits(n / 10);
    }

    // Helper function to calculate sum of digits raised to power of totalDigits
    public static int sumOfPowers(int n, int totalDigits) {
        // Base Case: No digits left
        if (n == 0) {
            return 0;
        }
        int lastDigit = n % 10; 
        int power = (int) Math.pow(lastDigit, totalDigits); 

        // Recursive Step: Add current power + sum of remaining digits
        return power + sumOfPowers(n / 10, totalDigits);
    }

    // Main check function
    public static boolean isArmstrong(int n) {
        int totalDigits = countDigits(n); 
        int sum = sumOfPowers(n, totalDigits); 
        return sum == n; 
    }

    public static void main(String[] args) {
        int n = 153; 
        System.out.println(n + " is Armstrong: " + isArmstrong(n)); 

        int n2 = 123; 
        System.out.println(n2 + " is Armstrong: " + isArmstrong(n2)); 
    }
}