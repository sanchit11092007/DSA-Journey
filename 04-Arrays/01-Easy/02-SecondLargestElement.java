/**
 * Problem: Second Largest Element in the Array
 * Pattern: Single Pass / Linear Scan
 * 
 * Optimal Approach:
 * keep two variables, 'largest' and 'secondLargest'.
 * Traverse once:
 * - If current element > largest, then secondLargest = largest, and largest =
 * current element.
 * - Else if current element > secondLargest AND current element != Largest,
 * then secondLargest = current element.
 * 
 * Time Complexity: 0(N)
 * Space Complexity: 0(1)
 */

class SecondLargestElement {

    public static int findSecondLargest(int[] arr) {
        if (arr == null || arr.length < 2) {
            return -1; // not enough elements for a second largest
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
        int[] arr = { 12, 35, 1, 10, 34, 1 };
        System.out.println(findSecondLargest(arr));
        // Expected output: 34
    }
}