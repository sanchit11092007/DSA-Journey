/**
 * Problem: Intersection of Two Sorted Arrays 
 * Pattern: Hashing / Two pointers
 * 
 * Approach: 
 * 1. Brute Force (Directed Nested Loop + Visited Check): 
 *     For every element in arr1, check every element in arr2 to see if it matches. 
 *    If it does, add it to the result, and mark that position in arr2 as "used" (visited array) so it cant be matched again for a repeated value in arr1.
 * 
 * 2. Better (Hashing):
 *    Store the frequency of every element of arr2 in a HashMap
 *     (value -> count). Then walk through arr1. For each value, check if its exists in the map with a count greater than 0. 
 *    If yes, add it to the result and reduce its count in the map by 1 (so it can't be reused more times than it actually apprars in arr2).
 * 
 * 3. Optimal (Two Pointers): 
 *     Since both arrays are already sorted, use two pointers 'i' and 'j' one for each array
 *     Compare arr1[i] and arr2[j]: 
 *      - If they are equal, add the value to the result, then move both i and j forward. 
 *      - If arr1[i] is smaller, move i forward. 
 *      - If arr2[j] is smaller, move j forward.
 *   Stop once either pointer reaches the end of its array. No extra data structure needed, since sorting already gives us the order for free.
 * 
 * Edge Cases: 
 * - One or both arrays empty: no intersection possible, return an empty result
 * - No common elements at all: result stays empty. 
 * 
 * Time Complexity: 
 * - Brute Force: 0(N * M) - nested loop checking every pair 
 * - Better: 0(N + M) - one pass to build the map, one pass to check 
 * - Optimal: 0(N + M) - single pass through both arrays combined
 * 
 * Space Complexity: 
 * - Brute Force: 0(M) - visited array to track used elements in arr2 
 * - Better: 0(M) - HashMap storing frequency of arr2 elements 
 * - Optimal: 0(1) 
 */


import java.util.ArrayList; 
import java.util.HashMap; 

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

    // Approach 2:Better - Hashing
    public static ArrayList<Integer> findIntersectionBetter(int[] arr1, int[] arr2) {
        ArrayList<Integer> result = new ArrayList<>(); 
        HashMap<Integer,Integer> freq = new HashMap<>(); 

        for (int num: arr2) {
            freq.put(num,freq.getOrDefault(num,0) + 1);
        }

        for (int num: arr1) {
            if (freq.getOrDefault(num,0) > 0) {
                result.add(num);
                freq.put(num,freq.get(num) -1);
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
        int[] arr1 = {1,2,2,3,3,4}; 
        int[] arr2 = {2,2,3,5}; 

        System.out.println(findIntersectionBrute(arr1,arr2)); 
        System.out.println(findIntersectionBetter(arr1,arr2));
        System.out.println(findIntersectionOptimal(arr1,arr2)); 
    }
}