#include <iostream> 
using namespace std; 

int findFactorial(int n) {
    if (n <= 1) {
        return 1; 
    }
    return n * findFactorial(n-1);
}

int main() {
    int number; 
    cout << "Enter a number: "; 
    cin >> number; 

    int result = findFactorial(number); 
    cout << "Factorial of " << number << "is: "<< result << endl; 
    
    return 0;  
}