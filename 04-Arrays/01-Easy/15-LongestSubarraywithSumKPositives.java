/**
 * Problem: Longest Subarray with sum k (Positive only)
 * Pattern: Sliding Window / Two Pointers
 * 
 * Approaches: 
 * 1. Brute Force (Check Every Subarray): 
 *    Use two loops to fix every possible starting and ending point of a subarray. 
 *    For each one, add up all elements in that range using a third inner loop, and check if the sum equals k. 
 *    Keep track of the longest length found. Very slow, checks every subarray from scratch.
 * 
 * 2. Better (Two Loops, Running Sum): 
 *    Same idea of fixing a starting point with the outer loop, but instead of a third loop to calculate the sum every time, 
 *    keep adding to a running sum as the inner loop moves forward. 
 *     This avoids recalculating the sum from scratch each time.
 * 
 * 3. Optimal (Sliding Window, Two Pointers): 
 *    Since all numbers are positive, the sum only increases as the window grows and only decreases as it shriks - this predictable behavior is what makies sliding window possible here. 
 *    Keep two pointers 'left' and 'right', marking the current window. Expand the window by moving 'right' forward, adding to the running sum. 
 *    If the sum becomes greater than k, shrink thr window from the left (subtract arr[left], move left forward) until the sum is back to k or less. 
 *    Whenever sum equals k, check if this window is the longest one found so far.
 * 
 * Edge Cases: 
 * - Empty array: no subarray possible, return 0. 
 * - No subarray sums to k: return 0 
 * - Single element equal to k: that element alone is a valid subarray of length 1. 
 * 
 * Time Complexity: 
 * - Brute Force: O(N^3) - three nested loops
 * - Better: O(N^2) - two nested loops, constant time sum calculation
 * - Optimal: O(N) - single pass through the array (each element enters and leaves the window at most once)
 * 
 * Space Complexity: 
 * - Brute Force: O(1) - no extra space
 * - Better: O(1) - no extra space
 * - Optimal: O(1) - only two pointer variables
 */


class LongestSubarrayWithSumKPositives {

    // Approach 1: Brute Force
    public static int longestSubarrayBrute(int[] arr, int k) {
        int n = arr.length; 
        int maxLen = 0; 

        for (int start = 0; start < n; start ++) {
            for (int end = start; end < n; end++) {
                int sum = 0; 
                for (int i = start; i <= end; i++) {
                    sum += arr[i];
                }
                if (sum == k) {
                    maxLen = Math.max(maxLen, end-start+1);
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
                    maxLen = Math.max(maxLen,end-start+1);
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

            while (sum > k && left <= right) {
                sum -= arr[left];
                left++;
            }
            if (sum == k) {
                maxLen = Math.max(maxLen,right-left+1);
            }
            right++;
        }
        return maxLen;
    }

    public static void main(String[] args) {
        int[] arr = {2,3,5,1,9}; 
        int k = 10; 

        System.out.println(longestSubarrayBrute(arr,k));
        System.out.println(longestSubarrayBetter(arr,k));
        System.out.println(longestSubarrayOptimal(arr,k));
    }
}