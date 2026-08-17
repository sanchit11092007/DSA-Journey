/**
 * 📌 Problem: Check if a String is a Palindrome
 * ⚡ Difficulty: Easy
 * 💡 Pattern: Array/String Recursion (Two-Pointer Style)
 * 
 * 🔍 Description:
 * A palindrome is a string that reads the same forwards and backwards.
 * Example: "madam" is a palindrome, while "hello" is not.
 * We compare characters from both ends moving towards the center.
 * 
 * 📈 Complexity Analysis:
 * - Time Complexity: O(N) -> We check roughly N / 2 pairs of characters.
 * - Space Complexity: O(N) -> Due to the recursion stack.
 */

public class CheckPalindromeString {

    public static boolean isPalindrome(String str, int start, int end) {
        // Base Case: If pointers meet or cross, all characters matched
        if (start >= end) {
            return true;
        }

        // Base Case: If characters do not match, it's not a palindrome
        if (str.charAt(start) != str.charAt(end)) {
            return false;
        }

        // Recursive Step: Move both pointers inward and check again
        return isPalindrome(str, start + 1, end - 1);
    }

    public static void main(String[] args) {
        String s1 = "madam";
        System.out.println(s1 + " is palindrome: " + isPalindrome(s1, 0, s1.length() - 1));

        String s2 = "hello";
        System.out.println(s2 + " is palindrome: " + isPalindrome(s2, 0, s2.length() - 1));
    }
}