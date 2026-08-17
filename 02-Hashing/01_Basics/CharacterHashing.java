/**
 * 📌 Problem: Character Hashing (Uppercase & Lowercase)
 * ⚡ Difficulty: Easy
 * 💡 Pattern: Array Hashing (Fixed Key Space)
 * 
 * 🔍 Description:
 * Count the frequency of each letter in a string. Since uppercase and lowercase letters 
 * have separate ASCII values, we use two separate array tables of size 26 (one for 'a'-'z' 
 * and one for 'A'-'Z') to keep the index arithmetic simple and clean.
 * 
 * 📈 Complexity Analysis:
 * - Time Complexity: O(N) to precompute the frequency + O(1) per lookup query.
 * - Space Complexity: O(1) -> We use fixed-size tables (26 * 2 = 52 integers).
 */

public class CharacterHashing {

    public static void main(String[] args) {
        String s = "Hashing in Java"; 

        int[][] hash = precomputeFrequency(s); 
        int[] lower = hash[0]; 
        int[] upper = hash[1]; 

        System.out.println("a: " + lower['a' - 'a']); // Expected: 1 (from "Java")
        System.out.println("H: " + upper['H' - 'A']); // Expected: 1 (from "Hashing")
        System.out.println("n: " + lower['n' - 'a']); // Expected: 2 (from "Hashing in Java")
        System.out.println("J: " + upper['J' - 'A']); // Expected: 1 (from "Java")
    }

    // Precomputes the frequency of each letter in the string
    static int[][] precomputeFrequency(String s) {
        int[] lower = new int[26]; 
        int[] upper = new int[26]; 

        for (char c : s.toCharArray()) {
            if (c >= 'a' && c <= 'z') {
                lower[c - 'a']++;
            } else if (c >= 'A' && c <= 'Z') {
                upper[c - 'A']++;
            }
            // Non-alphabetic characters (e.g. spaces) are ignored
        }

        return new int[][] {lower, upper};
    }
}