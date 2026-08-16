/**
 * Problem: Maximum Consecutive ones 
 * Pattern: Single Pass / Running Count
 * 
 * Approach: 
 * 1. Optimal (Single Pass, Running Count):
 *    Walk through the array once. Keep a counter for the current streak of consecutive 1s. 
 *     Whenever you see a 1, increase the counter. 
 *   Whenever you see a 0, the streak breaks - compare the current counter with the maximum seen so far, then reset the counter to 0.
 *  At the end, do one final comparison, in case the array ends on a streak of 1s (otherwise you'd miss counting the last streak)
 * 
 * 
 * Edge Cases: 
 * - Empty array: no ones at all, return 0. 
 * - All zeros: no streak ever forms, max stays 0. 
 * - All ones: one big streak, max equals array length. 
 * - Array ends with a streak of ones (no trailing zero): handled by the final comparison after the loop ends. 
 * - Single element array (either 0 or 1): works correctly either way.
 * 
 * Time Complexity: 0(N) - single pass through the array  
 * Space Complexity: 0(1) - constant extra space for counters  
 */

class MaxConsecutiveOnes {

    public static int findMaxConsecutiveOnes(int[] arr) {
        int maxCount = 0; 
        int currentCount = 0; 

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 1) {
                currentCount++; 
                maxCount = Math.max(maxCount,currentCount);
            } else {
                currentCount = 0;
            }
        }

        return maxCount;
    }

    public static void main (String[] args) {
        int[] arr = {1,1,0,1,1,1,0,1}; 
        System.out.println(findMaxConsecutiveOnes(arr));
        // Expected output: 3 
    }
}