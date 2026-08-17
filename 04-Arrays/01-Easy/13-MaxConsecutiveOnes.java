/**
 * 📌 Problem: Maximum Consecutive Ones
 * ⚡ Difficulty: Easy
 * 💡 Pattern: Single Pass / Running Count
 * 
 * 🔍 Description:
 * Finds the maximum number of consecutive 1s in a binary array.
 * We traverse the array keeping a running count of 1s. Whenever we encounter 1, we increment 
 * the count and update the maximum count. If we encounter 0, we reset the running count.
 * 
 * 📈 Complexity Analysis:
 * - Time Complexity: O(N) -> Single pass through the array.
 * - Space Complexity: O(1) -> Only constant variables are used.
 */

class MaxConsecutiveOnes {

    public static int findMaxConsecutiveOnes(int[] arr) {
        int maxCount = 0; 
        int currentCount = 0; 

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 1) {
                currentCount++; 
                maxCount = Math.max(maxCount, currentCount);
            } else {
                currentCount = 0;
            }
        }

        return maxCount;
    }

    public static void main(String[] args) {
        int[] arr = {1, 1, 0, 1, 1, 1, 0, 1}; 
        System.out.println(findMaxConsecutiveOnes(arr));
    }
}