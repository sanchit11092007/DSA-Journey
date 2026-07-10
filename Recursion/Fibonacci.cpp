#include <iostream> 
using namespace std; 

int getFibonacci (int n) {
    // Base case 1: The 0th Finonacci number is 0 
    if (n == 0) {
        return 0; 
    }
    // Base case 2: The 1st Fibonacci number is 1
    if (n == 1) {
        return 1; 
    }

    // Recursive case: Sum of the two previous numbers
    return getFibonacci(n-1) + getFibonacci(n-2);
}

int main() {
    int position; 
    cout << "Enter the position:"; 
    cin >> position; 

    int result = getFibonacci(position); 
    cout << "Fibonacci number at position " << position << "is: " << result << endl; 

    return 0;
}