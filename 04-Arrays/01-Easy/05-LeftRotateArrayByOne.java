/**
 * 📌 Problem: Left Rotate Array by One Place
 * ⚡ Difficulty: Easy
 * 💡 Pattern: Simple Shifting
 * 
 * 🔍 Description:
 * Shifts every element in the array one position to the left. The first element 
 * is moved to the last position of the array.
 * 
 * 📈 Complexity Analysis:
 * - Time Complexity: O(N) -> Single pass to shift N - 1 elements.
 * - Space Complexity: O(1) -> Done in-place.
 */

class LeftRotateArrayByOne {

    public static void rotateByOne(int[] arr) {
        // Edge Case: Empty or single-element array needs no rotation
        if (arr == null || arr.length <= 1) {
            return; 
        }

        int first = arr[0];  // Store the first element temporarily

        // Shift all elements one position to the left
        for (int i = 0; i < arr.length - 1; i++) {
            arr[i] = arr[i + 1];
        }

        arr[arr.length - 1] = first;  // Put the first element at the end
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5}; 
        rotateByOne(arr); 

        for (int val : arr) {
            System.out.print(val + " ");
        }
    }
}