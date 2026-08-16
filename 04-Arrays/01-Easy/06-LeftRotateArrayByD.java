/**
 * Problem: Left Rotate Array by D places 
 * Pattern: Rotating using Reversal 
 * 
 * Approaches: 
 *  1. Brute Force (Rotate One by One, D Times): 
 *      Just we did before for the "rotate by one", we just run it D times in a row. 
 *      Each run moves the whole array one step left. 
 *      Simple to think about, but slow if D is large.
 * 
 * 2. Optimal (Reversal Trick): 
 *     First handle D properly. if D is bigger than array size, takes D = D % n (since rotating by n does nothing). 
 *     Then do this in 3 steps: 
 *         Step 1: Reverse the first D elements. 
 *         Step 2: Reverse the remaining (n - D) elements. 
 *         Step 3: Reverse the whole array. 
 *   
 *   After these 3 reversals, the array is left rotated by D places. 
 *  Sounds strange at first, but it works because reversing parts and then reversing the whole thing puts everything in the right spot in one pass. 
 * 
 * 
 * Edge Cases: 
 * - Empty array: nothing to rotate, return as it is. 
 * - Single element array: rotating does nothing, stays teh same. 
 * - D = 0: no rotation needed, arrays stays the same. 
 * - D = n (array length): rotation by full length brings array back to original, handled by D = D % n. 
 * - D is greater than n: handled the same way using D = D % n.
 * 
 * Time Complexity: 
 *   - Brute Force: 0(N * D) - D full passes over the array 
 *   - Optimal: 0(N) - three reversals, each takes linear time, adds up to 0(N) total. 
 * 
 * Space Complexity: 
 *    - Brute Force: 0(1) - only a temp variable used each rotation 
 *    - Optimal: 0(1) - reversal is done in place, no extra array
 */


class LeftRotateArrayByD {

    // Approach 1: Brute Force - Rotate by One, D Times 
    public static void rotateBrute(int[] arr, int d) {
        if (arr == null || arr.length <= 1) {
            return; 
        }

        int n = arr.length; 
        d = d % n;  // no need to rotate more than array length 

        for (int count = 0; count < d; count++) {
            int first = arr[0]; 
            for (int i = 0; i < n -1; i++) {
                arr[i] = arr[i+1];
            }
            arr[n - 1] = first; 
        }
    }

    // Approach 2: Optimal - Reversal Trick 
    public static void rotateOptimal(int[] arr, int d) {
        if (arr == null || arr.length <= 1) {
            return; 
        }

        int n = arr.length; 
        d = d % n;  // handles d larger than array length 

        reverse(arr,0,d-1);     // reverse first d elements 
        reverse(arr,d,n-1);     // reverse remaining elements 
        reverse(arr,0,n-1);     // reverse the whole array 
    }

    private static void reverse(int[] arr, int start, int end) {
        while (start < end) {
            int temp = arr[start]; 
            arr[start] = arr[end]; 
            arr[end] = temp; 
            start ++; 
            end --; 
        }
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7}; 
        rotateOptimal(arr,2); 

        for (int val: arr) {
            System.out.print(val + " ");
        }
        // Expected output: 3 4 5 6 7 1 2 
    }
}