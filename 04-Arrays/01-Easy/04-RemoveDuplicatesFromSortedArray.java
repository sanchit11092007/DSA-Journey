/**
 * 📌 Problem: Remove Duplicates from Sorted Array
 * ⚡ Difficulty: Easy
 * 💡 Pattern: Two Pointers (Slow & Fast)
 * 
 * 🔍 Description:
 * Removes duplicate elements in-place from a sorted array.
 * We keep a slow pointer `i` at the position of the last found unique element. A fast pointer 
 * `j` scans the array. When `arr[j]` is different from `arr[i]`, we increment `i` and 
 * update `arr[i]` with `arr[j]`.
 * 
 * 📈 Complexity Analysis:
 * - Time Complexity: O(N) -> Single pass through the array.
 * - Space Complexity: O(1) -> Done in-place without extra memory.
 */

class RemoveDuplicatesFromSortedArray {

    public static int removeDuplicates(int[] arr) {
        // Edge Case: Empty array
        if (arr == null || arr.length == 0) {
            return 0; 
        }

        int i = 0;  // Slow pointer: tracks the last unique element position

        // Fast pointer 'j' scans the rest of the array
        for (int j = 1; j < arr.length; j++) {
            if (arr[j] != arr[i]) {
                i++; 
                arr[i] = arr[j]; 
            }
        }

        return i + 1;  // Number of unique elements
    }

    public static void main(String[] args) {
        int[] arr = {1, 1, 2, 2, 2, 3, 4, 4}; 

        int uniqueCount = removeDuplicates(arr); 
        System.out.println("Unique element count: " + uniqueCount); 

        // Print the unique elements in the modified array
        for (int k = 0; k < uniqueCount; k++) { 
            System.out.print(arr[k] + " "); 
        } 
    }   
}