/**
 * Problem: Union of Two Sorted Arrays 
 * Pattern: Two Pointers
 * 
 * Approach: 
 * 1. Brute Force: 
 *    Put every element from both arrays into a set. (this handles both the "no duplicate" rule and sorting automatically).
 *     Then copy the values from the set into a result array. 
 * 
 * 2. Optimal (Two Pointers): 
 *    Since both arrays are already sorted, use two pointers 'i' and 'j', one for each array. Compare arr1[i] and arr2[j]: 
 *      - If arr1[i] is smaller, add it to the result (if not already the last value added) and move i forward. 
 *      - If arr2[j] is smaller, add it to the result (if not already the last value added) and move j forward. 
 *      - If they're equal, add the value once and move both i and j forward. 
 *   Once one array is fully covered, and all the leftover elements from the other array, still checking for duplicates against the last added value.
 * 
 * Edge Cases: 
 * - One or both arrays empty: union is just whatever the non-empty array contains (or empty if both are empty). 
 * - Arrays with duplicates values inside themselves (e.g. {1,1,2}); still only added once in the result, 
 *    since we always check against the last value placed in the result. 
 * - NO common elements between two arrays: result is just a full merge of both, still sorted. 
 * - All elements common between both arrays: result is just one copy of each shared value.
 * 
 * 
 * Time Complexity: 
 * - Brute Force: 0((N+M) log (N+M)) - set insertion cost
 * - Optimal: 0(N+M) - single pass through both arrys combined
 * 
 * Space Complexity: 
 * - Brute Force: 0(N+M) - extra space for set
 * - Optimal: 0(1)
 */

import java.util.ArrayList; 

class UnionOfTwoSortedArrays {
    
    public static ArrayList<Integer> findUnion(int[] arr1, int[] arr2) {
        ArrayList<Integer> result = new ArrayList<>(); 

        int n1 = arr1.length;
        int n2 = arr2.length; 
        int i = 0, j = 0; 

        while (i < n1 && j < n2) {
            if (arr1[i] <= arr2[j]) {
                if (result.isEmpty() || result.get(result.size() -1) != arr1[i]) {
                    result.add(arr1[i]);
                }
                i++;
            } else {
                if (result.isEmpty() || result.get(result.size() -1) != arr2[j]) {
                    result.add(arr2[j]);
                }
                j++;
            }
        }

        // add leftover elements from arr1, if any 
        while (i < n1) {
            if (result.isEmpty() || result.get(result.size() -1) != arr1[i]) {
                result.add(arr1[i]);
            }
            i++;
        }

        // add leftover elements from arr2, if any 
        while (j < n2) {
            if (result.isEmpty() || result.get(result.size() -1) != arr2[j]) {
                result.add(arr2[j]);
            }
            j++;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr1 = {1,2,2,3}; 
        int[] arr2 = {2,3,4,5}; 

        System.out.println(findUnion(arr1,arr2)); 
        // Expected Output: [1,2,3,4,5]
    }
}