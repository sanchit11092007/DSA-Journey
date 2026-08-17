import java.util.HashMap; 
import java.util.Arrays; 

/**
 * 📌 Problem: Two Sum
 * ⚡ Difficulty: Medium
 * 💡 Pattern: Hashing / Two Pointers
 * 
 * 🔍 Description:
 * Find two numbers in an array that add up to a specific target.
 * - Brute Force: Check every pair using two nested loops.
 * - Better: Use a HashMap to store seen values and their indices. For each element, 
 *   check if `target - element` is already in the map.
 * - Optimal (For returning values): Sort the array and use two pointers (`left` and `right`) 
 *   to find the pair. Note: Sorting changes the indices, so this approach is suitable 
 *   when returning the values themselves, not their original indices.
 * 
 * 📈 Complexity Analysis:
 * - Time Complexity:
 *   - Brute Force: O(N^2)
 *   - Better: O(N) -> Single pass.
 *   - Optimal: O(N log N) -> Due to sorting.
 * - Space Complexity:
 *   - Brute Force: O(1)
 *   - Better: O(N) -> HashMap storage.
 *   - Optimal: O(1) -> Constant extra space.
 */

class TwoSum {

    // Approach 1: Brute Force - Two Loops 
    public static int[] twoSumBrute(int[] arr, int target) {
        if (arr == null || arr.length < 2) {
            return new int[]{-1, -1};
        }

        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] + arr[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{-1, -1}; 
    }

    // Approach 2: Better - Hashing 
    public static int[] twoSumBetter(int[] arr, int target) {
        if (arr == null || arr.length < 2) {
            return new int[]{-1, -1};
        }

        HashMap<Integer, Integer> seen = new HashMap<>();  // value -> index 

        for (int i = 0; i < arr.length; i++) {
            int needed = target - arr[i]; 

            if (seen.containsKey(needed)) {
                return new int[]{seen.get(needed), i};
            }
            seen.put(arr[i], i);
        }
        return new int[]{-1, -1};
    }

    // Approach 3: Optimal - Two Pointers 
    public static int[] twoSumOptimal(int[] arr, int target) {
        if (arr == null || arr.length < 2) {
            return new int[]{-1, -1}; 
        }

        Arrays.sort(arr);  

        int left = 0, right = arr.length - 1; 

        while (left < right) {
            int sum = arr[left] + arr[right]; 

            if (sum == target) {
                return new int[]{arr[left], arr[right]};
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
        int[] arr = {2, 7, 11, 15}; 
        int target = 9; 
        int[] result = twoSumOptimal(arr, target);
        System.out.println(Arrays.toString(result));
    }
}