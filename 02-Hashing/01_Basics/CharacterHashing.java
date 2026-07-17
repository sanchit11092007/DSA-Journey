import java.util.Scanner; 

/**
 * Problem: Character Hashing (Uppercase + Lowercase)
 * Difficult: Easy 
 * Pattern: Array Hashing (fixed key space)
 * 
 * Approach: 
 * 1. Character can be 'a' - 'z' (26) or 'A' - 'Z' (26) - 52 possible values total. 
 * 2. Instead of one array of size 52, use two separate arrays: one for lowercase, one for uppercase. 
 *    This keeps the index math simple and avoids off-by-one mistakes from trying to cram both cases into one array. 
 * 3. For lowercase: index = c - 'a' (gives 0 to 25)
 *    For uppercase: index = c - 'A' (gives 0 to 25)
 * 4. Loop through the string once, check each character's case, increment the correct array at the correct index. 
 * 5. Answer any "how many times does X appear" query in 0(1) by reading the array.
 * 
 * Time Complexity: 0(n) to build the hash, 0(1) per query 
 * Space Complexity: 0(1) - arrays are fixed size (26 + 26), doesn't grow with input  
 */

public class CharacterHashing {

    public static void main(String[] args) {
        String s = "Hashing in Java"; 

        int[][] hash = precomputeFrequency(s); 
        int[] lower = hash[0]; 
        int[] upper = hash[1]; 

        System.out.println("a: " + lower['a' - 'a']); // expected: 1 (from "Java")
        System.out.println("H: " + upper['H' - 'A']); // expected: 1 (from "Hashing")
        System.out.println("n: " + lower['n' - 'a']); // expected: 2 (from "Hashing")
        System.out.println("J: " + upper['J' - 'A']); // expected: 1 (from "Java")
    }

    // precompute frequency of lowercase and uppercase letters separately - 0(n)
    static int[][] precomputeFrequency(String s) {
        int[] lower = new int[26]; 
        int[] upper = new int[26]; 

        for (char c: s.toCharArray()) {
            if (c >= 'a' && c <= 'z') {
                lower[c-'a']++;
            } else if (c >= 'A' && c <= 'Z') {
                upper[c-'A']++;
            }
            // anything else (spaces, digits, symbols) is just skipped
        }

        return new int[][] {lower,upper};
    }
}