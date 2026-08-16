/** 
 * Problem: Remove Duplicates from Sorted Array 
 * Pattern: Two Pointers (Slow - Fast)
 * 
 * Approach: 
 *   Since the array is already sorted, all duplicates are next to each other. 
 *   Keep a slow pointer 'i' at index 0, marking the last unique element placed so far. 
 *   Use a fast pointer 'j' to scan through the array.
 * 
 *   If arr[j] != arr[i], it's a new unique element. Increment i and copy arr[j] to arr[i+1].
 *   If arr[j] == arr[i], it's a duplicate. Skip it by incrementing j only.
 * 
 * Edge Cases:
 *  - Empty array: no elements to process, return 0 unique elements. 
 *  - Single element array: only one unique element, return 1. 
 * - All elements same (e.g. {2,2,2}): only one unique element remains, handled naturally since 'j' never finds a value different from 'i'. 
 * - No duplicates at all: every element is unique, i moves every step, final count equals array length. 
 * - Negative numbers: works fine, only equality comparison is used. 
 * 
 * Time Complexity: O(N) - one pass through the array.
 * Space Complexity: O(1) - no extra space needed.  
 */


class RemoveDuplicatesFromSortedArray {

    public static int removeDuplicates(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0; 
        }

        int i = 0;  // slow pointer: last position of a unique element

        for (int j = 1; j < arr.length; j++) {
            if (arr[j] != arr[i]) {
                i++; 
                arr[i] = arr[j]; 
            }
        }

        return i + 1;  // count of unique elements 
    }

    public static void main (String[] args) {
        int[] arr = {1,1,2,2,2,3,4,4}; 

        int uniqueCount = removeDuplicates(arr); 
        System.out.println(uniqueCount); 
        // Expected output: 4

        // Print the unique elements
        
        for (int k = 0; k < uniqueCount; k++) { 
            System.out.print(arr[k] + " "); 
        } 
        // Expected output: 1 2 3 4 
    }   
}