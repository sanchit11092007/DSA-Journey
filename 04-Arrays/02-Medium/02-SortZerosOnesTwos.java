import java.util.Arrays;

/**
 * 📌 Problem: Sort an Array of 0s, 1s, and 2s
 * ⚡ Difficulty: Medium
 * 💡 Pattern: Dutch National Flag Algorithm (Three Pointers)
 * 
 * 🔍 Description:
 * Sorts an array containing only 0s, 1s, and 2s in-place.
 * - Brute Force: Use built-in sorting (Arrays.sort()).
 * - Better: Count occurrences of 0s, 1s, and 2s, then overwrite the array in a second pass.
 * - Optimal: Use three pointers (`low`, `mid`, `high`). 
 *   `low` tracks the next position for 0, `high` tracks the next position for 2, and `mid` 
 *   scans the array:
 *   - If arr[mid] == 0, swap arr[low] and arr[mid], increment low and mid.
 *   - If arr[mid] == 1, increment mid.
 *   - If arr[mid] == 2, swap arr[mid] and arr[high], decrement high.
 * 
 * 📈 Complexity Analysis:
 * - Time Complexity:
 *   - Brute Force: O(N log N)
 *   - Better: O(N) -> Two passes (O(2N)).
 *   - Optimal: O(N) -> Single pass.
 * - Space Complexity: O(1) -> All sorting is done in-place.
 */

class SortZerosOnesTwos {

    // Approach 1: Brute Force - Built-in Sort 
    public static void sortBrute(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }
        Arrays.sort(arr);
    }

    // Approach 2: Better - Counting 
    public static void sortBetter(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return; 
        }

        int count0 = 0, count1 = 0, count2 = 0; 

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) count0++; 
            else if (arr[i] == 1) count1++; 
            else count2++;
        }

        int index = 0; 

        for (int i = 0; i < count0; i++) {
            arr[index++] = 0; 
        }
        for (int i = 0; i < count1; i++) {
            arr[index++] = 1; 
        }
        for (int i = 0; i < count2; i++) {
            arr[index++] = 2; 
        }
    }

    // Approach 3: Optimal - Dutch National Flag Algorithm
    public static void sortOptimal(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }

        int low = 0, mid = 0, high = arr.length - 1; 

        while (mid <= high) {
            if (arr[mid] == 0) {
                // Swap arr[low] and arr[mid], move low and mid forward
                int temp = arr[low]; 
                arr[low] = arr[mid]; 
                arr[mid] = temp; 
                low++; 
                mid++;
            } else if (arr[mid] == 1) {
                // 1 is in the correct place, just move mid forward
                mid++;
            } else {
                // Swap arr[mid] and arr[high], move high backward
                int temp = arr[mid]; 
                arr[mid] = arr[high]; 
                arr[high] = temp; 
                high--;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {2, 0, 2, 1, 1, 0};
        sortOptimal(arr);
        System.out.println(Arrays.toString(arr)); 
    }
}