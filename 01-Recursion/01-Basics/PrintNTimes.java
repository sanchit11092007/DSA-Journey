/**
* Problem: Print "N" (or any statement) N times using Recursion 
* Difficulty: Easy 
* Pattern: Basic Recursion
*
* Approach: 
* - Base case: if n == 0, stop recursion
* - Recursive case: print the statement, then call the function again with (n-1)
* - Each call reduces n by 1, moving it closer to the base case 
* 
* Time complexity:0(N) -> one call per value from N down to 1 
* Space complexity: 0(N) -> recursion stack holds N pending calls 
 */

public class PrintNTimes {
    public static void printN(int n) {
        // base case 
        if (n == 0) {
            return; 
        }
        // work done in this call 
        System.out.println("Programming");

        // recursive case 
        printN(n-1);
    }

    public static void main(String[] args) {
        int n = 5; 
        printN(n); 
    }
}

// Output: 
// Programming 
// Programming 
// Programming 
// Programming 
// Programming 