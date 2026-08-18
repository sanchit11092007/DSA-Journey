/**
 * Problem: Implement a Stack Using an Array 
 * Difficulty: Easy 
 * Pattern: Stack Implementation 
 * Approach: 
 *    Use a fixed-size array and a variable 'top' that tracks the index of the topmost element. 
 *    Start with top = -1 (empty stack). 
 *    push() increases top by 1 and places the value there. 
 *    pop() just decreases top by 1 (we don't need to erase the value, since the top no longer points to it)
 * 
 * Time Complexity: 0(1) for push, pop, peek, isEmpty
 * Space Complexity: 0(N) - fixed size array
 */

class StackUsingArray {
    private int[] arr; 
    private int top; 
    private int capacity; 

    public StackUsingArray(int size) {
        arr = new int[size]; 
        capacity = size; 
        top = -1;
    }

    // Add elements on the top of the stack 
    public void push (int x) {
        if (top == capacity - 1) {
            System.out.println("Stack Overflow");
            return;
        }
        top ++; 
        arr[top] = x;
    }

    // Remove the top element 
    public void pop() {
        if (top == -1) {
            System.out.println("Stack Underflow");
            return;
        }
        top--;
    }

    // Look at the top element without removing it
    public int peek() {
        if (top == -1) {
            System.out.println("Stack is Empty");
            return -1; 
        }
        return arr[top];
    }

    // Check if stack has no elements
    public boolean isEmpty() {
        return top == -1;
    }

    public static void main(String[] args) {
        StackUsingArray stack = new StackUsingArray(5);
        stack.push(5); 
        stack.push(10); 
        stack.push(15); 
        System.out.println("Top element: "+ stack.peek());  // 15
        stack.pop(); 
        System.out.println("Top after pop: " + stack.peek());  // 10
        System.out.println("Is Empty: " + stack.isEmpty()); // false
    }
}