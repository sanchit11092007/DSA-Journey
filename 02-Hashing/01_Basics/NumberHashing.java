import java.util.Scanner; 

/**
 * Problem: Number Hashing 
 * Difficulty: Easy 
 * Pattern: Array Hashing (fixed key space)
 * 
 * Approach: 
 * 1. Goal: answer "how many times does X appear?" instantly, for many queries, without rescanning the array every time. 
 * 2. This only works when the numbers fall in a known, small range (say 0 to 1000). 
 *    If numbers could be arbitrarily large or negative, an array wouldn't work here. 
 * 3. Make one pass through the input array, and for each number x, increment hash[x]. This builds a frequency table in one shot. 
 * 4. After that, any query "how many times does X appear?" is just hash[X] - a direct array lookup, 0(1).
 * 
 * Time Complexity: 0(n) to build the hash, 0(1) per query 
 * Space Complexity: 0(maxVal) - array size depends on the range of values, not input size 
 */


public class NumberHashing {

    public static void main(String[] args) {
        int[] arr = {1,2,2,3,5,5,10}; 
        int maxVal = 1000;  //assuming values are within 0 to 1000

        int[] hash = precomputeFrequency(arr,maxVal); 

        System.out.println("Count of 5: "+ hash[5]);  //expected: 3 
        System.out.println("Count of 2: " + hash[2]);  // expected: 2 
        System.out.println("Count of 7: " + hash[7]);  // expected: 0 (never appears)
    }

    // precompute frequency of each number using array hashing - 0(n)
    static int[] precomputeFrequency(int[] arr, int maxVal) {
        int[] hash = new int[maxVal + 1]; 
        for (int x: arr) {
            hash[x]++;
        }
        return hash;   // each query now 0(1)
    }
}