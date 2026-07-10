#include <iostream> 
using namespace std; 

int countZeros (int n) {
    // Base case: If the number becomes 0, stop counting
    if (n == 0){ 
        return 0; 
    }
    // Checks if the last digit is a zero
    int lastDigit = n % 10; 

    if (lastDigit == 0) {
        return 1 + countZeros(n/10);
    } else {
        return countZeros(n/10);
    }
}

int main() { 
    int number; 
    cout << "Enter a number: "; 
    cin >> number; 

    // Special case: If the user inputs exactly 0
    if (number == 0) {
        cout << "Number of zeros: 1" << endl;
    } else {
        int result = countZeros(number); 
        cout << "Number of zeros: " << result << endl; 
    }
    return 0; 
}