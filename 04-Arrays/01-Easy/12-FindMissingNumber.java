/**
 * 📌 Problem: Find the Missing Number in an Array
 * ⚡ Difficulty: Easy
 * 💡 Pattern: Sum Formula / XOR
 * 
 * 🔍 Description:
 * Finds the missing number in an array containing N-1 unique numbers in the range [1, N].
 * - Brute Force: Linear search for each number from 1 to N in the array.
 * - Better: Use a boolean array to mark present elements.
 * - Optimal 1 (Sum Formula): Subtract the actual sum of elements from the expected sum (N * (N + 1) / 2).
 * - Optimal 2 (XOR): XOR all numbers from 1 to N, then XOR all elements in the array. 
 *   The result of XORing both is the missing number because duplicate numbers cancel out.
 * 
 * 📈 Complexity Analysis:
 * - Time Complexity:
 *   - Brute Force: O(N^2)
 *   - Better: O(N)
 *   - Optimal 1 (Sum Formula): O(N)
 *   - Optimal 2 (XOR): O(N)
 * - Space Complexity:
 *   - Brute Force: O(1)
 *   - Better: O(N) -> Due to the boolean array.
 *   - Optimal 1 (Sum Formula): O(1)
 *   - Optimal 2 (XOR): O(1)
 */

class FindMissingNumber {

    // Approach 1: Brute Force - Check Every Number
    public static int findMissingBrute(int[] arr, int n) {
        for (int number = 1; number <= n; number++) {
            boolean found = false;

            for (int i = 0; i < arr.length; i++) {
                if (arr[i] == number) {
                    found = true;
                    break;
                }
            }

            if (!found) {
                return number;
            }
        }
        return -1;
    }

    // Approach 2: Better - Hashing
    public static int findMissingBetter(int[] arr, int n) {
        boolean[] seen = new boolean[n + 1]; 

        for (int num : arr) {
            seen[num] = true;
        }

        for (int number = 1; number <= n; number++) {
            if (!seen[number]) {
                return number;
            }
        }
        return -1;
    }

    // Approach 3: Optimal 1 - Sum Formula
    public static int findMissingSumFormula(int[] arr, int n) {
        int expectedSum = n * (n + 1) / 2;
        int actualSum = 0;

        for (int num : arr) {
            actualSum += num;
        }

        return expectedSum - actualSum;
    }

    // Approach 4: Optimal 2 - XOR
    public static int findMissingXOR(int[] arr, int n) {
        int xor1 = 0; // XOR of numbers 1 to N
        int xor2 = 0; // XOR of elements in the array

        for (int i = 1; i <= n; i++) {
            xor1 = xor1 ^ i;
        }

        for (int num : arr) {
            xor2 = xor2 ^ num;
        }

        return xor1 ^ xor2;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 5}; 
        int n = 5;

        System.out.println(findMissingBrute(arr, n));      
        System.out.println(findMissingBetter(arr, n));     
        System.out.println(findMissingSumFormula(arr, n)); 
        System.out.println(findMissingXOR(arr, n));        
    }
}