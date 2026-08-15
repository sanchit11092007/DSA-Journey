import java.util.Arrays; 

/**
 * Problem: Merge Sort 
 * Difficulty: Medium 
 * Pattern: Divide and Conquer - split, sort recursively, then merge 
 * Approach: 
 *  1. Divide: split the array into two halves (left and right) at the middle index. 
 *  2. Conquer: recursively sort the left half and the right half separately. until each sub-array has only 1 element (which is trivally sorted)
 *  3. Combine: merge the two sorted halves back together into one sorted array. 
 *     This merge step uses a temporary array and two pointers, one for each half, picking the smaller of the two front elemenents each time. 
 * 4. This "split until trival, then merge back up" process happens for every level of recursion until the whole array is one sorted piece. 
 * 
 * Time Complexity: 0(n log n) in all cases (best, average, worst) - the array is always split into halves (log n levels), and merging at each level takes 0(n) total work, so log n * n = 0(n log n).
 * Space Complexity: 0(n) - the merge step needs a temporary array to hold elements during merging (unlike Selection/Bubble/Insertion which are 0(1))
 */


import java.util.Arrays; 

public class MergeSort {

    static void mergeSort(int[] arr, int low, int high) {
        // base case: a sub-array of size 1 (or 0) is already sorted
        if (low >= high) {
            return; 
        }

        int mid = low + (high - low) / 2; 

        mergeSort(arr, low, mid);    // sort left half
        mergeSort(arr, mid + 1, high);  // sort right half 
        merge(arr, low, mid, high);    // merge the two sorted halves
    }

    static void merge(int[] arr, int low, int mid, int high) {
        int[] temp = new int[high - low + 1]; 

        int left = low;   // pointer for left half, starts at low 
        int right = mid + 1;  // pointer for right half, starts right after mid
        int k = 0;            // pointer for temp array 

        // pick the smaller of the two front elements, one at a time 
        while(left <= mid && right <= high) {
            if (arr[left] <= arr[right]) {
                temp[k] = arr[left]; 
                left++;
            } else {
                temp[k] = arr[right]; 
                right++;
            }
            k++;
        }

        
        while (left <= mid) {
            temp[k] = arr[left]; // changed from arr[right] to arr[left]
            left++;              // changed from right++ to left++
            k++; 
        }
        
        
        while (right <= high) {  
            temp[k] = arr[right]; 
            right++; 
            k++; 
        }

        // copy sorted temp array back into the original array 
        for (int i = 0; i < temp.length; i++) {
            arr[low + i] = temp[i]; 
        }
    }

    public static void main(String[] args) {
        int[] arr = {64, 25, 12, 22, 11}; 

        mergeSort(arr, 0, arr.length - 1); 

        System.out.println(Arrays.toString(arr));
        // Expected output: [11, 12, 22, 25, 64]
    }
}