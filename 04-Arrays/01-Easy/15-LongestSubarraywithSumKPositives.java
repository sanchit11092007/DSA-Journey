/**
 * 📌 Problem: Longest Subarray with Sum K (Positives Only)
 * ⚡ Difficulty: Easy
 * 💡 Pattern: Sliding Window / Two Pointers
 * 
 * 🔍 Description:
 * Finds the length of the longest subarray that sums to exactly K.
 * - Brute Force: Check all subarrays using three loops.
 * - Better: Check all subarrays using two loops by calculating running sum on the fly.
 * - Optimal: Use a sliding window with two pointers `left` and `right`. Expand the window by 
 *   moving `right` and adding to the sum. If the sum exceeds K, shrink the window by 
 *   moving `left` until the sum is less than or equal to K.
 * 
 * 📈 Complexity Analysis:
 * - Time Complexity:
 *   - Brute Force: O(N^3)
 *   - Better: O(N^2)
 *   - Optimal: O(N) -> Each element is visited at most twice (entered and exited the window).
 * - Space Complexity:
 *   - Brute Force: O(1)
 *   - Better: O(1)
 *   - Optimal: O(1) -> Done in-place without extra space.
 */

class LongestSubarrayWithSumKPositives {

    // Approach 1: Brute Force
    public static int longestSubarrayBrute(int[] arr, int k) {
        int n = arr.length; 
        int maxLen = 0; 

        for (int start = 0; start < n; start++) {
            for (int end = start; end < n; end++) {
                int sum = 0; 
                for (int i = start; i <= end; i++) {
                    sum += arr[i];
                }
                if (sum == k) {
                    maxLen = Math.max(maxLen, end - start + 1);
                }
            }
        }
        return maxLen;
    }

    // Approach 2: Better 
    public static int longestSubarrayBetter(int[] arr, int k) {
        int n = arr.length; 
        int maxLen = 0; 

        for (int start = 0; start < n; start++) {
            int sum = 0; 

            for (int end = start; end < n; end++) {
                sum += arr[end];

                if (sum == k) {
                    maxLen = Math.max(maxLen, end - start + 1);
                }
            }
        }
        return maxLen;
    }

    // Approach 3: Optimal (Sliding Window)
    public static int longestSubarrayOptimal(int[] arr, int k) {
        int n = arr.length; 
        int left = 0, right = 0; 
        int sum = 0; 
        int maxLen = 0; 

        while (right < n) {
            sum += arr[right];

            // Shrink the window if current sum exceeds K
            while (sum > k && left <= right) {
                sum -= arr[left];
                left++;
            }

            // Check if we found a subarray with sum K
            if (sum == k) {
                maxLen = Math.max(maxLen, right - left + 1);
            }
            right++;
        }
        return maxLen;
    }

    public static void main(String[] args) {
        int[] arr = {2, 3, 5, 1, 9}; 
        int k = 10; 

        System.out.println(longestSubarrayBrute(arr, k));
        System.out.println(longestSubarrayBetter(arr, k));
        System.out.println(longestSubarrayOptimal(arr, k));
    }
}