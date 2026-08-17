/**
 * 📌 Problem: Number Hashing
 * ⚡ Difficulty: Easy
 * 💡 Pattern: Array Hashing (Fixed Key Space)
 * 
 * 🔍 Description:
 * Count the frequency of each number in an array. By storing the frequency in an index-based
 * array (where hash[x] stores the count of x), we can perform lookup queries instantly.
 * Note: This works only when numbers are non-negative and fall within a relatively small range.
 * 
 * 📈 Complexity Analysis:
 * - Time Complexity: O(N) to precompute the frequency + O(1) per lookup query.
 * - Space Complexity: O(maxVal) -> Size of the hash array depends on the maximum value.
 */

public class NumberHashing {

    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 3, 5, 5, 10}; 
        int maxVal = 1000;  // Assuming values are in the range [0, 1000]

        int[] hash = precomputeFrequency(arr, maxVal); 

        System.out.println("Count of 5: " + hash[5]);   // Expected: 2
        System.out.println("Count of 2: " + hash[2]);   // Expected: 2
        System.out.println("Count of 7: " + hash[7]);   // Expected: 0
    }

    // Precomputes the frequency of each number using an array
    static int[] precomputeFrequency(int[] arr, int maxVal) {
        int[] hash = new int[maxVal + 1]; 
        for (int x : arr) {
            hash[x]++;
        }
        return hash;
    }
}