import java.util.Arrays; 

/**
 * 📌 Problem: Merge Sort
 * ⚡ Difficulty: Medium
 * 💡 Pattern: Divide and Conquer
 * 
 * 🔍 Description:
 * Recursively splits the array into two halves, sorts each half, and then merges them back 
 * together. A temporary array is used during the merge step to hold the elements.
 * 
 * 📈 Complexity Analysis:
 * - Time Complexity: O(N log N) -> In all cases (best, average, worst), because the array 
 *   is always divided in half (log N levels) and merging takes O(N) at each level.
 * - Space Complexity: O(N) -> Due to the temporary array used for merging.
 */

public class MergeSort {

    static void mergeSort(int[] arr, int low, int high) {
        // Base Case: A subarray of size 1 or 0 is already sorted
        if (low >= high) {
            return; 
        }

        int mid = low + (high - low) / 2; 

        mergeSort(arr, low, mid);       // Sort the left half recursively
        mergeSort(arr, mid + 1, high);  // Sort the right half recursively
        merge(arr, low, mid, high);     // Merge the two sorted halves
    }

    static void merge(int[] arr, int low, int mid, int high) {
        int[] temp = new int[high - low + 1]; 

        int left = low;       // Pointer for the left half
        int right = mid + 1;  // Pointer for the right half
        int k = 0;            // Pointer for the temporary array

        // Compare elements from both halves and pick the smaller one
        while (left <= mid && right <= high) {
            if (arr[left] <= arr[right]) {
                temp[k] = arr[left]; 
                left++;
            } else {
                temp[k] = arr[right]; 
                right++;
            }
            k++;
        }

        // Copy any remaining elements from the left half
        while (left <= mid) {
            temp[k] = arr[left]; 
            left++; 
            k++; 
        }
        
        // Copy any remaining elements from the right half
        while (right <= high) {  
            temp[k] = arr[right]; 
            right++; 
            k++; 
        }

        // Copy the sorted temporary array back to the original array
        for (int i = 0; i < temp.length; i++) {
            arr[low + i] = temp[i]; 
        }
    }

    public static void main(String[] args) {
        int[] arr = {64, 25, 12, 22, 11}; 

        mergeSort(arr, 0, arr.length - 1); 

        System.out.println(Arrays.toString(arr)); 
    }
}