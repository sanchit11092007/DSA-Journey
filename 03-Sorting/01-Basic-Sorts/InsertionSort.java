import java.util.Arrays; 

/**
 * Problem: Insertion Sort 
 * Difficulty: Easy 
 * Pattern: In - place comparison sort - build a sorted portion by inserting one element at a time
 * Approach: 
 *  1. Assume the first element (index 0) is trivially "sorted" by itself. 
 *  2. For each next element (starting at index 1), pick it as the "key".
 *  3. Compare the key with elements to its left (in the sorted portion). 
 *     Shift each element that is greater than the key one position to the right. 
 * 4. Keep shifting until you find an element smaller than or equal to the key, or you reach the start of the array. 
 * 5. Insert the key into the empty slot. 
 * 6. Repeat for all elements - the sorted portion grows by one each time. 
 * 
 * Time Complexity: 
 *   Worst/Average case: 0(n^2) - array is reverse sorted or random, lots of shifting. 
 *   Best case: 0(n) - array is already sorted, each key only needs one comparison (no shifting needed) before it's confirmed in place. 
 * 
 * Space Complexity: 0(1) - sorting is done in-place, no extra array used.
 */



public class InsertionSort {
    
    static void insertionSort(int[] arr) {
        int n = arr.length; 

        for (int i = 1; i < n; i++) {
            int key = arr[i]; 
            int j = i - 1; 

            // shift elements greater than key one step to the right 
            while (j >= 0 && arr[j] > key) {
                arr[j+1] = arr[j]; 
                j--; 
            }

            // place key in its correct position
            arr[j+1] = key; 
        }
    }

    public static void main(String[] args) {
        int[] arr = {64,25,12,22,11}; 

        insertionSort(arr);

        System.out.println(Arrays.toString(arr)); 
        // Expected output: [11,12,22,25,64]
    }
}


/**
 * Insertion Sort Dry Run
Initial Array: [64, 25, 12, 22, 11]

Pass i=1, key = arr[1] = 25:
  j=0: arr[0]=64 > 25 -> shift 64 right -> [64, 64, 12, 22, 11], j=-1
  j=-1: stop (j < 0)
  Insert key 25 at j+1=0 -> [25, 64, 12, 22, 11]
After Pass (i=1): [25, 64, 12, 22, 11]

Pass i=2, key = arr[2] = 12:
  j=1: arr[1]=64 > 12 -> shift 64 right -> [25, 64, 64, 22, 11], j=0
  j=0: arr[0]=25 > 12 -> shift 25 right -> [25, 25, 64, 22, 11], j=-1
  j=-1: stop (j < 0)
  Insert key 12 at j+1=0 -> [12, 25, 64, 22, 11]
After Pass (i=2): [12, 25, 64, 22, 11]

Pass i=3, key = arr[3] = 22:
  j=2: arr[2]=64 > 22 -> shift 64 right -> [12, 25, 64, 64, 11], j=1
  j=1: arr[1]=25 > 22 -> shift 25 right -> [12, 25, 25, 64, 11], j=0
  j=0: arr[0]=12 > 22? No -> stop
  Insert key 22 at j+1=1 -> [12, 22, 25, 64, 11]
After Pass (i=3): [12, 22, 25, 64, 11]

Pass i=4, key = arr[4] = 11:
  j=3: arr[3]=64 > 11 -> shift 64 right -> [12, 22, 25, 64, 64], j=2
  j=2: arr[2]=25 > 11 -> shift 25 right -> [12, 22, 25, 25, 64], j=1
  j=1: arr[1]=22 > 11 -> shift 22 right -> [12, 22, 22, 25, 64], j=0
  j=0: arr[0]=12 > 11 -> shift 12 right -> [12, 12, 22, 25, 64], j=-1
  j=-1: stop (j < 0)
  Insert key 11 at j+1=0 -> [11, 12, 22, 25, 64]
After Pass (i=4): [11, 12, 22, 25, 64]

Final Sorted Array: [11, 12, 22, 25, 64]

Note: Notice how each "shift" temporarily leaves a duplicate value in the
array (e.g. [64, 64, 12, 22, 11]) until the key is finally inserted into
the gap. This is normal and expected - it's not a bug, just an
intermediate state before the key overwrites one of the duplicates.
 */