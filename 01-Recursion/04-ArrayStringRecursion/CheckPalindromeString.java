/**
 * Problem: Check if a String is a Palindrome using Recursion
 * Difficulty: Easy
 * Pattern: Array/String Recursion (Two-Pointer style)
 *
 * What is a Palindrome?
 * A string that reads the same forwards and backwards.
 * Example: "madam" -> same reversed. "hello" -> not the same reversed.
 *
 * Approach:
 * - Use two pointers: one starting from the left (start), one from the right (end)
 * - Base case: if start >= end, the whole string has been checked -> it's a palindrome
 * - If characters at start and end don't match -> not a palindrome, return false immediately
 * - Recursive case: move start forward (+1) and end backward (-1), check again
 *
 * Time Complexity: O(N/2) -> O(N) -> checks roughly half the characters
 * Space Complexity: O(N) -> recursion stack depth
 */
public class CheckPalindromeString {

    public static boolean isPalindrome(String str, int start, int end) {
        // base case: pointers have met or crossed -> all characters matched
        if (start >= end) {
            return true;
        }

        // mismatch found -> not a palindrome
        if (str.charAt(start) != str.charAt(end)) {
            return false;
        }

        // recursive case: move both pointers inward
        return isPalindrome(str, start + 1, end - 1);
    }

    public static void main(String[] args) {
        String s1 = "madam";
        System.out.println(s1 + " is palindrome: " + isPalindrome(s1, 0, s1.length() - 1));
        // Output: madam is palindrome: true

        String s2 = "hello";
        System.out.println(s2 + " is palindrome: " + isPalindrome(s2, 0, s2.length() - 1));
        // Output: hello is palindrome: false
    }
}