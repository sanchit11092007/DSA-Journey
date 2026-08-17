/**
 * 📌 Problem: Linear Search
 * ⚡ Difficulty: Easy
 * 💡 Pattern: Simple Traversal
 * 
 * 🔍 Description:
 * Scans the array sequentially from the start to find a target value.
 * If the target is found, its index is returned. If the loop completes without 
 * finding the target, the method returns -1.
 * 
 * 📈 Complexity Analysis:
 * - Time Complexity: O(N) -> In the worst case, we check all N elements.
 * - Space Complexity: O(1) -> No extra space is used.
 */

class LinearSearch {

    public static int search(int[] arr, int target) {
        // Edge Case: Empty or null array
        if (arr == null || arr.length == 0) {
            return -1;
        }

        // Sequential scan for the target value
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i;
            }
        }

        return -1; // Target not found
    }

    public static void main(String[] args) {
        int[] arr = {5, 3, 8, 1, 9};
        System.out.println(search(arr, 8)); // Expected output: 2
    }
}