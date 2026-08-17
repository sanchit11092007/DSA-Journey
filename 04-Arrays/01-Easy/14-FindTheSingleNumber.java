import java.util.HashMap;

/**
 * 📌 Problem: Find the Element that Appears Once
 * ⚡ Difficulty: Easy
 * 💡 Pattern: XOR
 * 
 * 🔍 Description:
 * Given a non-empty array of integers where every element appears twice except for one, 
 * find that unique element.
 * - Brute Force: Count occurrences of each element using a nested loop.
 * - Better: Count occurrences using a HashMap, then look for the element with a count of 1.
 * - Optimal: XOR all elements in the array. Since a XOR a = 0 and a XOR 0 = a, 
 *   all elements appearing twice cancel each other out, leaving only the unique element.
 * 
 * 📈 Complexity Analysis:
 * - Time Complexity:
 *   - Brute Force: O(N^2)
 *   - Better: O(N) -> One pass to build the map, one pass to check.
 *   - Optimal: O(N) -> Single pass.
 * - Space Complexity:
 *   - Brute Force: O(1)
 *   - Better: O(N) -> Due to the HashMap.
 *   - Optimal: O(1) -> Done in-place without extra space.
 */

class FindTheSingleNumber {

    // Approach 1: Brute Force - Count Each Number
    public static int findSingleBrute(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int count = 0;

            for (int j = 0; j < arr.length; j++) {
                if (arr[j] == arr[i]) {
                    count++;
                }
            }

            if (count == 1) {
                return arr[i];
            }
        }
        return -1; 
    }

    // Approach 2: Better - Hashing
    public static int findSingleBetter(int[] arr) {
        HashMap<Integer, Integer> freq = new HashMap<>();

        for (int num : arr) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        for (int num : arr) {
            if (freq.get(num) == 1) {
                return num;
            }
        }
        return -1; 
    }

    // Approach 3: Optimal - XOR
    public static int findSingleXOR(int[] arr) {
        int result = 0;

        for (int num : arr) {
            result = result ^ num;
        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr = {4, 1, 2, 1, 2};
        System.out.println(findSingleBrute(arr));  
        System.out.println(findSingleBetter(arr)); 
        System.out.println(findSingleXOR(arr));    
    }
}