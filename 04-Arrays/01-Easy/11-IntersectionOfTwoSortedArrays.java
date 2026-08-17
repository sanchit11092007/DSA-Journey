import java.util.ArrayList; 
import java.util.HashMap; 

/**
 * 📌 Problem: Intersection of Two Sorted Arrays
 * ⚡ Difficulty: Easy
 * 💡 Pattern: Two Pointers / Hashing
 * 
 * 🔍 Description:
 * Finds common elements between two sorted arrays.
 * - Brute Force: Iterate through arr1 and search each element in arr2, keeping track of visited elements.
 * - Better: Count frequencies of elements in arr2 using a HashMap, then scan arr1.
 * - Optimal: Use two pointers `i` and `j` to traverse both arrays. Since they are sorted, we can 
 *   compare elements directly: if equal, add to results and advance both; otherwise, advance 
 *   the pointer pointing to the smaller element.
 * 
 * 📈 Complexity Analysis:
 * - Time Complexity:
 *   - Brute Force: O(N * M)
 *   - Better: O(N + M)
 *   - Optimal: O(N + M) -> Single pass.
 * - Space Complexity:
 *   - Brute Force: O(M) -> Visited array.
 *   - Better: O(M) -> Frequency map.
 *   - Optimal: O(1) -> Done in-place without extra space.
 */

class IntersectionofTwoSortedArrays {

    // Approach 1: Brute Force
    public static ArrayList<Integer> findIntersectionBrute(int[] arr1, int[] arr2) {
        ArrayList<Integer> result = new ArrayList<>(); 
        boolean[] visited = new boolean[arr2.length]; 

        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr2.length; j++) {
                if (arr1[i] == arr2[j] && !visited[j]) {
                    result.add(arr1[i]); 
                    visited[j] = true; 
                    break;
                }
            }
        }
        return result; 
    }

    // Approach 2: Better - Hashing
    public static ArrayList<Integer> findIntersectionBetter(int[] arr1, int[] arr2) {
        ArrayList<Integer> result = new ArrayList<>(); 
        HashMap<Integer, Integer> freq = new HashMap<>(); 

        for (int num : arr2) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        for (int num : arr1) {
            if (freq.getOrDefault(num, 0) > 0) {
                result.add(num);
                freq.put(num, freq.get(num) - 1);
            }
        }
        return result;
    }

    // Approach 3: Optimal - Two Pointers
    public static ArrayList<Integer> findIntersectionOptimal(int[] arr1, int[] arr2) {
        ArrayList<Integer> result = new ArrayList<>(); 

        int n1 = arr1.length; 
        int n2 = arr2.length; 
        int i = 0, j = 0; 

        while (i < n1 && j < n2) {
            if (arr1[i] == arr2[j]) {
                result.add(arr1[i]); 
                i++; 
                j++;
            } else if (arr1[i] < arr2[j]) {
                i++; 
            } else {
                j++;
            }
        }
        return result; 
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 2, 2, 3, 3, 4}; 
        int[] arr2 = {2, 2, 3, 5}; 

        System.out.println(findIntersectionBrute(arr1, arr2)); 
        System.out.println(findIntersectionBetter(arr1, arr2));
        System.out.println(findIntersectionOptimal(arr1, arr2)); 
    }
}