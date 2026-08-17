/**
 * 📌 Problem: Check if Array is Sorted in Non-Decreasing Order
 * ⚡ Difficulty: Easy
 * 💡 Pattern: Single Pass / Linear Scan
 * 
 * 🔍 Description:
 * Traverses the array from index 1 to the end, comparing each element with the previous one.
 * If any element is smaller than its predecessor, the array is not sorted.
 * 
 * 📈 Complexity Analysis:
 * - Time Complexity: O(N) -> We scan the array at most once.
 * - Space Complexity: O(1) -> No extra space is used.
 */

class CheckIfArraySorted {

    public static boolean isSorted(int[] arr) {
        // Edge Case: Empty or single-element arrays are always sorted
        if (arr == null || arr.length <= 1) {
            return true;
        }

        // Check if any element is smaller than the previous one
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < arr[i - 1]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 3, 4};
        System.out.println(isSorted(arr));
    }
}