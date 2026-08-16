/**
 * Problem: Longest Subarray with Sum K (Positives, Negatives and Zeros)
 * Pattern: Prefix Sum + Hashing
 * 
 * Approaches: 
 * 1. Brute Force (Check Every Subarray): 
 *    Use two loops to fix every possible starting and ending point of a subarray. 
 *    For each one, add up all elements in that range using a third inner loop, and check if the sum equals to k. 
 *    Keep track of the longest length found.
 * 
 * 2. Better (Two Loops, Running Sum): 
 *    Same idea of fixing a starting point with the outer loop, but instead of a third loop to calculate the sum every time, 
 *     keep adding to a running sum as the inner loop moves forward. 
 * 
 * 3. Optimal (Prefix Sum + Hashing): 
 *     Sliding window does NOT work here. since negative numbers make the sum behave unpredictably as the window grows or shrinks. 
 *   Instead walk through the array once, keeping a running prefix sum (sum of everything from index 0 upto the current index). 
 *   At each step:  
 *     - If the prefix sum itself equals to k, the subarray from index 0 to here is a valid answer. 
 *     - Check if (prefixSum - k) has been seen before, using a hashMap that stores each prefix sum value with the first index it was seen at. 
 *        If (prefixSum - k) exists in the map, it means the elements between that earlier index and the current index add up to exactly k. 
 * 
 * 
 * Time Complexity: 
 * - Brute Force: 0(N^3) 
 * - Better: 0(N^2)
 * - Optimal: 0(N)
 * 
 * Space Complexity: 
 * - Brute Force: 0(1) 
 * - Better: 0(1)
 * - Optimal: 0(N)
 */

import java.util.HashMap; 

class LongestSubarrayWithSumKPositivesAndNegatives {

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
                    maxLen = Math.max(maxLen,end-start+1);
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
                    maxLen = Math.max(maxLen, end-start+1);
                }
            }
        }
        return maxLen; 
    }

    // Approach 3: Optimal 
    public static int longestSubarrayOptimal(int[] arr, int k) {
        int n = arr.length; 
        HashMap <Integer, Integer> prefixSumIndex = new HashMap<>();  // prefixSum -> first index seen 
        int  sum = 0; 
        int maxLen = 0; 

        for (int i = 0; i < n; i++) {
            sum += arr[i]; 

            if (sum == k) {
                maxLen = Math.max(maxLen,i+1);
            }

            int needed = sum - k; 
            if (prefixSumIndex.containsKey(needed)) {
                int len = i - prefixSumIndex.get(needed); 
                maxLen = Math.max(maxLen,len);
            }

            // only store the FIRST time this prefix sum appears 
            if (!prefixSumIndex.containsKey(sum)) {
                prefixSumIndex.put(sum,i);
            }
        }
        return maxLen;
    }

    public static void main(String[] args) {
        int[] arr = {10,-10,20,30,-10,20}; 
        int k = 30; 

        System.out.println(longestSubarrayBrute(arr,k)); 
        System.out.println(longestSubarrayBetter(arr,k));
        System.out.println(longestSubarrayOptimal(arr,k));
    }
}

