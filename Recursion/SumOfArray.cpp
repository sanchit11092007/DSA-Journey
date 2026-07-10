#include <iostream> 
using namespace std; 

// n is the number of elements left to add 
int getArraySum(int arr[], int n) {
    // Base Case: If the array is empty, the sum is 0
    if (n <= 0) {
        return 0;
    }
    // Recursive Case: Add the last element to the sum of the remaining elements 
    return arr[n-1] + getArraySum(arr,n-1);
}

int main() {
    int size; 
    cout << "Enter the size of the array: "; 
    cin >> size; 

    int arr[100]; 
    cout << "Enter " << size << "numbers: "; 
    for (int i = 0; i < size; i++) {
        cin >> arr[i];
    }
    int totalSum = getArraySum(arr,size); 
    cout << "The sum of all numbers in the array is: " << totalSum << endl; 

    return 0; 
}