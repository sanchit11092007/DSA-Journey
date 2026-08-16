/**
 * Problem: Find the Missing Number in an Array
 * Difficulty: Easy
 * Pattern: Sum Formula / Hashing
 *
 * Approach(es):
 * 1. Brute Force (Check Every Number):
 *    The array has numbers from 1 to N, but one number is missing, so
 *    the array has N-1 elements. For every number from 1 to N, scan
 *    the whole array to check if that number exists. The first number
 *    that isn't found is the missing one.
 *
 * 2. Better (Hashing):
 *    Create a HashMap (or simple array/set) and mark every number that
 *    is present in the array. Then loop from 1 to N and check which
 *    number was never marked — that's the missing one. Avoids
 *    re-scanning the whole array again and again like brute force does.
 *
 * 3. Optimal (Sum Formula):
 *    If the array had all numbers from 1 to N with nothing missing,
 *    the sum would be N*(N+1)/2 (a known math formula for sum of first
 *    N natural numbers). Calculate this expected total. Then add up
 *    all the numbers that are actually present in the array. The
 *    missing number is simply: expectedSum - actualSum.
 *
 * Edge Cases:
 * - Array missing the smallest number (1): still works, formula
 *   doesn't care which number is missing, just the total difference.
 * - Array missing the largest number (N): still works the same way.
 * - Very large N: sum formula could overflow int in extreme cases,
 *   but for normal DSA-sized inputs this isn't a concern.
 * - Only one element expected (N=1, array is empty): expectedSum = 1,
 *   actualSum = 0, correctly returns 1 as missing.
 *
 * Time Complexity:
 * - Brute Force: O(N^2) — for every number, scan the whole array
 * - Better: O(N) — one pass to mark, one pass to check
 * - Optimal: O(N) — single pass to calculate actual sum
 *
 * Space Complexity:
 * - Brute Force: O(1) — no extra space used
 * - Better: O(N) — HashMap/array to mark presence
 * - Optimal: O(1) — only a couple of variables used
 */
import java.util.HashMap;

class FindMissingNumber {

    // Approach 1: Brute Force — Check Every Number
    public static int findMissingBrute(int[] arr, int n) {
        for (int number = 1; number <= n; number++) {
            boolean found = false;

            for (int i = 0; i < arr.length; i++) {
                if (arr[i] == number) {
                    found = true;
                    break;
                }
            }

            if (!found) {
                return number;
            }
        }

        return -1; // no number missing (shouldn't happen if input is valid)
    }

    // Approach 2: Better — Hashing
    public static int findMissingBetter(int[] arr, int n) {
        HashMap<Integer, Boolean> present = new HashMap<>();

        for (int num : arr) {
            present.put(num, true);
        }

        for (int number = 1; number <= n; number++) {
            if (!present.containsKey(number)) {
                return number;
            }
        }

        return -1; // no number missing (shouldn't happen if input is valid)
    }

    // Approach 3: Optimal — Sum Formula
    public static int findMissingOptimal(int[] arr, int n) {
        int expectedSum = n * (n + 1) / 2;
        int actualSum = 0;

        for (int num : arr) {
            actualSum += num;
        }

        return expectedSum - actualSum;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 5}; // missing 3, n = 5
        int n = 5;

        System.out.println(findMissingBrute(arr, n));   // Expected output: 3
        System.out.println(findMissingBetter(arr, n));  // Expected output: 3
        System.out.println(findMissingOptimal(arr, n)); // Expected output: 3
    }
}