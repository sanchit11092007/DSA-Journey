import java.util.ArrayList; 

/**
 * 📌 Problem: Union of Two Sorted Arrays
 * ⚡ Difficulty: Easy
 * 💡 Pattern: Two Pointers
 * 
 * 🔍 Description:
 * Computes the union of two sorted arrays, containing only unique elements in sorted order.
 * - Brute Force: Insert all elements of both arrays into a Set, then copy to a list.
 * - Optimal: Use two pointers `i` and `j` to scan both arrays. Add the smaller element to 
 *   the result if it is not a duplicate of the last added element. Move the pointers 
 *   forward accordingly, then append any leftover elements.
 * 
 * 📈 Complexity Analysis:
 * - Time Complexity:
 *   - Brute Force: O((N + M) log (N + M)) -> Due to Set insertion cost.
 *   - Optimal: O(N + M) -> Single pass to traverse both arrays.
 * - Space Complexity:
 *   - Brute Force: O(N + M) -> To store elements in the Set.
 *   - Optimal: O(1) -> If we exclude the space for the output list.
 */

class UnionOfTwoSortedArrays {
    
    public static ArrayList<Integer> findUnion(int[] arr1, int[] arr2) {
        ArrayList<Integer> result = new ArrayList<>(); 

        int n1 = arr1.length;
        int n2 = arr2.length; 
        int i = 0, j = 0; 

        // Traverse both arrays simultaneously
        while (i < n1 && j < n2) {
            if (arr1[i] <= arr2[j]) {
                // Add element from arr1 if it's not a duplicate of the last added element
                if (result.isEmpty() || result.get(result.size() - 1) != arr1[i]) {
                    result.add(arr1[i]);
                }
                i++;
            } else {
                // Add element from arr2 if it's not a duplicate of the last added element
                if (result.isEmpty() || result.get(result.size() - 1) != arr2[j]) {
                    result.add(arr2[j]);
                }
                j++;
            }
        }

        // Add remaining elements from arr1, if any 
        while (i < n1) {
            if (result.isEmpty() || result.get(result.size() - 1) != arr1[i]) {
                result.add(arr1[i]);
            }
            i++;
        }

        // Add remaining elements from arr2, if any 
        while (j < n2) {
            if (result.isEmpty() || result.get(result.size() - 1) != arr2[j]) {
                result.add(arr2[j]);
            }
            j++;
        }
        
        return result;
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 2, 2, 3}; 
        int[] arr2 = {2, 3, 4, 5}; 

        System.out.println(findUnion(arr1, arr2)); 
    }
}