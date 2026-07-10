#include <iostream> 
using namespace std; 

int getSum(int n) {
    // Base case: if number is 0, sum is 0 
    if (n == 0) {
        return 0; 
    }
    return (n % 10) + getSum(n/10);
}

int main() {
    int number; 
    cout << "Enter a number: "; 
    cin >> number; 

    int result = getSum(number); 
    cout << "Sum of digits is: " << result << endl; 

    return 0; 
}