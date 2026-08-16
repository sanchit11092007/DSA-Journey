/** 
 * Problem: Left Rotate Array by One Place 
 * Pattern: Simple Shifting 
 * 
 * Approach: 
 *     Store the first element in a temp variable. Then shift every other element one step to the left 
 *       (each element takes the place of the one before it). 
 *    At the end, put the saved first element at the very last position. 
 *   That's it - one full rotation done. 
 * 
 * Edge Cases: 
 *  - Empty array: nothing to rotate, just return as it is. 
 *  - Single element array: rotating one element does nothing, arrays stays the same. 
 * - Array with all same values: rotation still works fine, output looks the same as input since values repeat.
 *  
 * Time Complexity: 0(N) 
 * Space Complexity: 0(1)
 */

class LeftRotateArrayByOne {

    public static void rotateByOne(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;  // nothing to rotate
        }

        int first = arr[0];  // save the first value 

        for (int i = 0; i < arr.length - 1; i++) {
            arr[i] = arr[i+1];  // shift each values one step left
        }

        arr[arr.length - 1] = first;  // put saved value at the end
    }

    public static void main (String[] args) {
        int[] arr = {1,2,3,4,5}; 
        rotateByOne(arr); 

        for (int val: arr) {
            System.out.print(val + " ");
        }
        // Expected output: 2 3 4 5 1 
    }
}