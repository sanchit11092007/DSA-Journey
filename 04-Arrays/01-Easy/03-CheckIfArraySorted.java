/**
 * Problem: Check if Array is Sorted 
 * Difficulty: Easy 
 * Pattern: Single Pass / Linear Scan 
 * 
 * Approach: 
 *   Traverse the array from index 1 to end, comparing each element with the previous one. 
 *   If any element is smaller than the previous element, the array is not sorted. 
 *   If you finish the loop without finding such a case, the array is sorted.
 * 
 * Time Complexity: O(N) - single traversal, worst case check every element 
 * Space Complexity: O(1) - no extra space used
*/

class CheckIfArraySorted {

    public static boolean isSorted(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return true; 
        }

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < arr[i-1]) {
                return false; 
            }
        }
        return true; 
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 3, 4}; 
        System.out.println(isSorted(arr));
        // Expected output: true
    }
}
