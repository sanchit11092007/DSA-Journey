/**
 * Problem: Find the Missing Number in an Array
 * Difficulty: Easy
 * Pattern: Sum Formula / XOR
 *
 * Approach(es):
 * 1. Brute Force (Check Every Number):
 *    The array has numbers from 1 to N, but one is missing (array size
 *    is N-1). For every number from 1 to N, search the whole array to
 *    see if that number exists. The number that is never found is the
 *    missing one.
 *
 * 2. Better (Hashing):
 *    Create a boolean array (or HashMap) of size N+1 to mark which
 *    numbers from 1 to N are present. Walk through the given array once
 *    and mark each number as seen. Then walk from 1 to N and return the
 *    number that was never marked.
 *
 * 3. Optimal 1 (Sum Formula):
 *    The sum of numbers from 1 to N has a direct formula:
 *    N * (N + 1) / 2. Calculate this expected total sum, then subtract
 *    the actual sum of all numbers present in the array. Whatever is
 *    left over is the missing number.
 *
 * 4. Optimal 2 (XOR):
 *    XOR has a special property: a number XORed with itself becomes 0,
 *    and XOR with 0 leaves a number unchanged, and XOR is order
 *    independent. XOR all numbers from 1 to N together, then XOR all
 *    numbers actually present in the array together. Every number that
 *    appears in both groups cancels itself out (becomes 0), and only
 *    the missing number is left standing at the end.
 *
 * Edge Cases:
 * - Array missing the smallest number (1): still works correctly in
 *   all approaches, no special handling needed.
 * - Array missing the largest number (N): still works correctly, since
 *   we always check against the full expected range 1 to N.
 * - Array with only one element (N=2, one number given): still works,
 *   smallest possible valid case.
 *
 * Time Complexity:
 * - Brute Force: O(N^2) — searching the array for every number
 * - Better: O(N) — one pass to mark, one pass to check, but uses
 *   extra space
 * - Optimal 1 (Sum Formula): O(N) — single pass to sum the array
 * - Optimal 2 (XOR): O(N) — single pass, technically two loops but
 *   both are O(N), so it adds up to O(N) overall
 *
 * Space Complexity:
 * - Brute Force: O(1) — no extra space used
 * - Better: O(N) — boolean array or HashMap used to mark presence
 * - Optimal 1 (Sum Formula): O(1) — only a couple of variables used
 * - Optimal 2 (XOR): O(1) — only a couple of variables used
 */
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

        return -1; // should not happen if input is valid
    }

    // Approach 2: Better — Hashing
    public static int findMissingBetter(int[] arr, int n) {
        boolean[] seen = new boolean[n + 1]; // index 0 unused

        for (int num : arr) {
            seen[num] = true;
        }

        for (int number = 1; number <= n; number++) {
            if (!seen[number]) {
                return number;
            }
        }

        return -1; // should not happen if input is valid
    }

    // Approach 3: Optimal 1 — Sum Formula
    public static int findMissingSumFormula(int[] arr, int n) {
        int expectedSum = n * (n + 1) / 2;
        int actualSum = 0;

        for (int num : arr) {
            actualSum += num;
        }

        return expectedSum - actualSum;
    }

    // Approach 4: Optimal 2 — XOR
    public static int findMissingXOR(int[] arr, int n) {
        int xor1 = 0; // XOR of 1 to N
        int xor2 = 0; // XOR of all array elements

        for (int i = 1; i <= n; i++) {
            xor1 = xor1 ^ i;
        }

        for (int num : arr) {
            xor2 = xor2 ^ num;
        }

        return xor1 ^ xor2;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 5}; // missing number is 3, N = 5
        int n = 5;

        System.out.println(findMissingBrute(arr, n));      // Expected output: 3
        System.out.println(findMissingBetter(arr, n));     // Expected output: 3
        System.out.println(findMissingSumFormula(arr, n)); // Expected output: 3
        System.out.println(findMissingXOR(arr, n));        // Expected output: 3
    }
}