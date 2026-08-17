/**
 * 📌 Problem: Find the Second Largest Element in an Array
 * ⚡ Difficulty: Easy
 * 💡 Pattern: Single Pass / Linear Scan
 * 
 * 🔍 Description:
 * Keeps track of both `largest` and `secondLargest` elements during a single scan.
 * If the current element is larger than `largest`, then `largest` is updated, and the old 
 * `largest` becomes the `secondLargest`. Otherwise, if it is larger than `secondLargest` 
 * and not equal to `largest`, we update `secondLargest`.
 * 
 * 📈 Complexity Analysis:
 * - Time Complexity: O(N) -> Single pass through the array.
 * - Space Complexity: O(1) -> Uses constant extra space.
 */

class SecondLargestElement {

    public static int findSecondLargest(int[] arr) {
        // Edge Case: Array must have at least 2 elements
        if (arr == null || arr.length < 2) {
            return -1; 
        }

        int largest = arr[0];   
        int secondLargest = -1; 

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > largest) {
                secondLargest = largest;
                largest = arr[i];
            } else if (arr[i] > secondLargest && arr[i] != largest) {
                secondLargest = arr[i];
            }
        }
        return secondLargest;
    }

    public static void main(String[] args) {
        int[] arr = {12, 35, 1, 10, 34, 1};
        System.out.println(findSecondLargest(arr));
    }
}