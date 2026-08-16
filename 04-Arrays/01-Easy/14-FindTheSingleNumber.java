/**
 * Problem: Find the Number that Appears Once (Rest Appear Twice)
 * Difficulty: Easy
 * Pattern: XOR
 *
 * Approach(es):
 * 1. Brute Force (Count Each Number):
 *    For every element in the array, count how many times it appears
 *    in the whole array (using a nested loop). The number whose count
 *    comes out to 1 is the answer.
 *
 * 2. Better (Hashing):
 *    Walk through the array once and store the count of every number
 *    in a HashMap (value -> count). Then walk through the map (or the
 *    array again) and return the number whose count is 1.
 *
 * 3. Optimal (XOR):
 *    XOR has two useful properties: a number XORed with itself becomes
 *    0, and XOR with 0 leaves a number unchanged. So if you XOR every
 *    element of the array together, every number that appears twice
 *    cancels itself out (becomes 0), and only the number that appears
 *    once is left standing at the end.
 *
 * Edge Cases:
 * - Array with only one element: that single element is the answer,
 *   works fine in all approaches.
 * - The unique number is at the start or end of the array: doesn't
 *   matter for any approach, since order doesn't affect the result.
 * - Large array with many pairs: XOR approach stays O(1) space, while
 *   hashing would use more memory as the array grows.
 *
 * Time Complexity:
 * - Brute Force: O(N^2) — counting occurrences for every element
 * - Better: O(N) — one pass to build the map, one pass to check
 * - Optimal: O(N) — single pass, XOR-ing every element together
 *
 * Space Complexity:
 * - Brute Force: O(1) — no extra space used
 * - Better: O(N) — HashMap storing counts
 * - Optimal: O(1) — only one variable used to track the running XOR
 */
import java.util.HashMap;

class FindTheSingleNumber {

    // Approach 1: Brute Force — Count Each Number
    public static int findSingleBrute(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int count = 0;

            for (int j = 0; j < arr.length; j++) {
                if (arr[j] == arr[i]) {
                    count++;
                }
            }

            if (count == 1) {
                return arr[i];
            }
        }

        return -1; // should not happen if input is valid
    }

    // Approach 2: Better — Hashing
    public static int findSingleBetter(int[] arr) {
        HashMap<Integer, Integer> freq = new HashMap<>();

        for (int num : arr) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        for (int num : arr) {
            if (freq.get(num) == 1) {
                return num;
            }
        }

        return -1; // should not happen if input is valid
    }

    // Approach 3: Optimal — XOR
    public static int findSingleXOR(int[] arr) {
        int result = 0;

        for (int num : arr) {
            result = result ^ num;
        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr = {4, 1, 2, 1, 2};
        System.out.println(findSingleBrute(arr));  // Expected output: 4
        System.out.println(findSingleBetter(arr)); // Expected output: 4
        System.out.println(findSingleXOR(arr));    // Expected output: 4
    }
}