/**
 * Problem: Linear Search
 * Difficulty: Easy
 * Pattern: Simple Traversal
 *
 * Approach(es):
 * 1. Optimal (Single Pass):
 *    Go through the array one element at a time from the start. If the
 *    current element matches the target value, return its index right
 *    away. If you finish checking the whole array and never find a
 *    match, return -1.
 *
 * Edge Cases:
 * - Empty array: nothing to search, return -1.
 * - Single element array: works fine, either matches or returns -1.
 * - Target not present: loop finishes without a match, return -1.
 * - Target present multiple times: returns the index of the first
 *   match found (since we return as soon as we find one).
 * - Target at the last position: still found correctly, just takes
 *   the full loop to reach it.
 *
 * Time Complexity:
 * - Optimal: O(N) — worst case checks every element
 *
 * Space Complexity:
 * - Optimal: O(1) — no extra space used
 */
class LinearSearch {

    public static int search(int[] arr, int target) {
        if (arr == null || arr.length == 0) {
            return -1;
        }

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i;
            }
        }

        return -1; // not found
    }

    public static void main(String[] args) {
        int[] arr = {5, 3, 8, 1, 9};
        System.out.println(search(arr, 8)); // Expected output: 2
    }
}