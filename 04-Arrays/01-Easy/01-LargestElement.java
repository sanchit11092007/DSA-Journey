/**
 * 📌 Problem: Find the Largest Element in an Array
 * ⚡ Difficulty: Easy
 * 💡 Pattern: Single Pass / Linear Scan
 * 
 * 🔍 Description:
 * Keeps track of the largest element found so far. We initialize `largest` with the 
 * first element, traverse the array from the second element to the end, and update 
 * `largest` whenever we find a larger value.
 * 
 * 📈 Complexity Analysis:
 * - Time Complexity: O(N) -> Single pass through the array.
 * - Space Complexity: O(1) -> Only one extra variable is used.
 */

class LargestElement {

    public static int findLargest(int[] arr) {
        // Edge Case: Empty or null array
        if (arr == null || arr.length == 0) {
            return -1;
        }

        int largest = arr[0]; 

        // Scan the rest of the array to find any larger element
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > largest) {
                largest = arr[i]; 
            }
        }

        return largest; 
    }

    public static void main(String[] args) {
        int[] arr = {4, 7, 8, 6, 7, 6}; 
        System.out.println(findLargest(arr)); 
    }
}