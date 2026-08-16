/**
 * Problem: Two Sum 
 * Pattern: Hashing / Two Pointers 
 * 
 * Approach: 
 * 1. Brute Force (Two loops): 
 *     Check every pair of elements using two loops. If any pair adds up to target, return their indices. 
 * 
 * 2. Better (Hashing): 
 *     Walk through the arry once. For each number, check if the value needed to complete the pair (target - current number) is already 
 *       seen before. Use a hashmap to store each number with its index. 
 *     Faster than brute force, but uses extra space for the Hashmap.
 * 
 * 3. Optimal (Two Pointers): 
 *    Sort the array first. Keep one pointer at the start, one at the end. 
 *     If the sum is too small, move the start pointer forward. 
 *    If too big, move the end pointer backward. 
 *  Uses no extra space.
 * 
 *  Time Complexity: 
 * - Brute Force: 0(N^2)
 * - Better: 0(N)
 * - Optimal: 0(N log N)
 * 
 * Space Complexity: 
 * - Brute Force: 0(1)
 * - Better: 0(N)
 * - Optimal: 0(1)
 */


import java.util.HashMap; 
import java.util.Arrays; 

class TwoSum {

    // Approach 1: Brute Force - Two Loops 
    public static int[] twoSumBrute(int[] arr, int target) {
        if (arr == null || arr.length < 2) {
            return new int[]{-1,-1};
        }

        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] + arr[j] == target) {
                    return new int[]{i,j};
                }
            }
        }

        return new int[]{-1,-1}; 
    }

    // Approach 2: Better - Hashing 
    public static int[] twoSumBetter(int[] arr, int target) {
        if (arr == null || arr.length < 2) {
            return new int[]{-1,-1};
        }

        HashMap<Integer,Integer> seen = new HashMap<>();  // value -> Index 

        for (int i = 0; i < arr.length; i++) {
            int needed = target - arr[i]; 

            if (seen.containsKey(needed)) {
                return new int[]{seen.get(needed),i};
            }
            seen.put(arr[i],i);
        }
        return new int[]{-1,-1};
    }

    // Approach 3: Optimal - Two Pointers 
    public static int[] twoSumOptimal(int[] arr, int target) {
        if (arr == null || arr.length < 2) {
            return new int[]{-1,-1}; 
        }

        Arrays.sort(arr);  

        int left = 0, right = arr.length - 1; 

        while (left < right) {
            int sum = arr[left] + arr[right]; 

            if (sum == target) {
                return new int[]{arr[left], arr[right]};
            } else if (sum < target) {
                left ++;
            } else {
                right --;
            }
        }

        return new int[]{-1,-1};
    }

    public static void main (String[] args) {
        int[] arr = {2,7,11,15}; 
        int target = 9; 
        int[] result = twoSumOptimal(arr, target);
        System.out.println(Arrays.toString(result));
    }
}