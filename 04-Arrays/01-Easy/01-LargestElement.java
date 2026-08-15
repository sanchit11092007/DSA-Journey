/**
 * Problem: Largest Element in the Array
 * Difficulty: Easy
 * Pattern: Single Pass
 * 
 * Approach:
 * Keep the variable largest initialized to the first element.
 * Traverse the array once, and whenever you find an element bigger than largest
 * update it.
 * By the end, "largest" holds the answer.
 * 
 * Time Complexity: 0(N) - single traversal
 * Space Complexity: 0(1) - only one extra variable used
 * 
 */

class LargestElement {

public static int findLargest(int[]arr){if(arr==null||arr.length==0){return-1; // invalud input signal
}

int largest=arr[0];for(int i=1;i<arr.length;i++){if(arr[i]>largest){largest=arr[i];}}

return largest;}

public static void main(String[]args){int[]arr={4,7,8,6,7,6};

System.out.println(findLargest(arr));
// Expected output: 8
}}