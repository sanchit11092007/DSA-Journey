import java.util.HashMap; 

/**
 * 📌 Problem: Longest Subarray with Sum K (Positives, Negatives and Zeros)
 * ⚡ Difficulty: Easy
 * 💡 Pattern: Prefix Sum + Hashing
 * 
 * 🔍 Description:
 * Finds the length of the longest subarray that sums to exactly K, where elements can 
 * be positive, negative, or zero.
 * - Brute Force / Better: Check all subarrays using nested loops (O(N^3) or O(N^2)).
 * - Optimal: Store prefix sums and their first occurrence indices in a HashMap. 
 *   If the current prefix sum equals K, the subarray starts at index 0. If `prefixSum - K` 
 *   exists in the map, a subarray with sum K exists between the stored index and the current index.
 * 
 * 📈 Complexity Analysis:
 * - Time Complexity:
 *   - Brute Force: O(N^3)
 *   - Better: O(N^2)
 *   - Optimal: O(N) -> Single pass with map lookups in O(1) time.
 * - Space Complexity:
 *   - Brute Force: O(1)
 *   - Better: O(1)
 *   - Optimal: O(N) -> To store prefix sums in the HashMap.
 */

class LongestSubarrayWithSumKPositivesAndNegatives {

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

    // Approach 3: Optimal (Prefix Sum + Hashing)
    public static int longestSubarrayOptimal(int[] arr, int k) {
        int n = arr.length; 
        HashMap<Integer, Integer> prefixSumIndex = new HashMap<>();  // prefixSum -> first index seen 
        int sum = 0; 
        int maxLen = 0; 

        for (int i = 0; i < n; i++) {
            sum += arr[i]; 

            // If prefix sum itself is K, we have a valid subarray starting at index 0
            if (sum == k) {
                maxLen = Math.max(maxLen, i + 1);
            }

            // Check if we have seen prefix sum - K before
            int needed = sum - k; 
            if (prefixSumIndex.containsKey(needed)) {
                int len = i - prefixSumIndex.get(needed); 
                maxLen = Math.max(maxLen, len);
            }

            // Store only the first occurrence of prefix sum to maximize length
            if (!prefixSumIndex.containsKey(sum)) {
                prefixSumIndex.put(sum, i);
            }
        }
        return maxLen;
    }

    public static void main(String[] args) {
        int[] arr = {10, -10, 20, 30, -10, 20}; 
        int k = 30; 

        System.out.println(longestSubarrayBrute(arr, k)); 
        System.out.println(longestSubarrayBetter(arr, k));
        System.out.println(longestSubarrayOptimal(arr, k));
    }
}
