/**
 * Problem: Right Rotate Array by D Places
 * Difficulty: Easy
 * Pattern: Rotation using Reversal
 *
 * Approach(es):
 * 1. Brute Force (Rotate One by One, D Times):
 *    Take the last element and move it to the front. Do this D times
 *    in a row. Each run moves the whole array one step right.
 *
 * 2. Optimal (Reversal Trick):
 *    First fix D properly: if D is bigger than array size, use
 *    D = D % n (rotating by n does nothing).
 *    Then do this in 3 steps:
 *      Step 1: Reverse the last D elements.
 *      Step 2: Reverse the remaining (n - D) elements.
 *      Step 3: Reverse the whole array.
 *    This is basically the mirror image of left rotate — same idea,
 *    just start reversing from the other end.
 *
 * Edge Cases:
 * - Empty array: nothing to rotate, return as it is.
 * - Single element array: rotating does nothing, stays the same.
 * - D = 0: no rotation needed, array stays the same.
 * - D = n (array length): rotating by full length brings array back
 *   to original, handled by D = D % n.
 * - D greater than n: handled the same way using D = D % n.
 *
 * Time Complexity:
 * - Brute Force: O(N * D) — D full passes over the array
 * - Optimal: O(N) — three reversals, adds up to O(N) total
 *
 * Space Complexity:
 * - Brute Force: O(1) — only a temp variable used each rotation
 * - Optimal: O(1) — reversal done in place, no extra array
 */
class RightRotateArrayByD {

    // Approach 1: Brute Force — Rotate by One, D Times
    public static void rotateBrute(int[] arr, int d) {
        if (arr == null || arr.length <= 1) {
            return;
        }

        int n = arr.length;
        d = d % n;

        for (int count = 0; count < d; count++) {
            int last = arr[n - 1];
            for (int i = n - 1; i > 0; i--) {
                arr[i] = arr[i - 1];
            }
            arr[0] = last;
        }
    }

    // Approach 2: Optimal — Reversal Trick
    public static void rotateOptimal(int[] arr, int d) {
        if (arr == null || arr.length <= 1) {
            return;
        }

        int n = arr.length;
        d = d % n;

        reverse(arr, n - d, n - 1);   // reverse last d elements
        reverse(arr, 0, n - d - 1);   // reverse remaining elements
        reverse(arr, 0, n - 1);       // reverse the whole array
    }

    private static void reverse(int[] arr, int start, int end) {
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        rotateOptimal(arr, 2);

        for (int val : arr) {
            System.out.print(val + " ");
        }
        // Expected output: 6 7 1 2 3 4 5
    }
}