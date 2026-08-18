/**
 * Problem: Implement a Stack using a Linked List
 * Difficulty: Easy
 * Pattern: Stack Implementation
 * Approach: Use a singly linked list. Track 'head' as the top of the stack.
 *           New elements are always inserted at the head, never at the tail.
 *           This is because inserting/deleting at head only touches one
 *           pointer (O(1)), while doing it at tail would need traversing
 *           the whole list to update the second-last node (O(n)).
 * TC: O(1) for push, pop, peek, isEmpty
 * SC: O(n) - grows dynamically, no overflow
 */
class StackUsingLinkedList {

    // Node class representing each element of the stack
    private static class Node {
        int data;
        Node next;

        Node(int val) {
            data = val;
            next = null;
        }
    }

    private Node head;

    public StackUsingLinkedList() {
        head = null;
    }

    // Add element on top of the stack
    public void push(int x) {
        Node newNode = new Node(x);
        newNode.next = head;
        head = newNode;
    }

    // Remove the top element
    public void pop() {
        if (head == null) {
            System.out.println("Stack Underflow");
            return;
        }
        head = head.next;
    }

    // Look at the top element without removing it
    public int peek() {
        if (head == null) {
            System.out.println("Stack is empty");
            return -1;
        }
        return head.data;
    }

    // Check if stack has no elements
    public boolean isEmpty() {
        return head == null;
    }

    public static void main(String[] args) {
        StackUsingLinkedList stack = new StackUsingLinkedList();
        stack.push(5);
        stack.push(10);
        System.out.println("Top element: " + stack.peek()); // 10
        stack.pop();
        System.out.println("Top after pop: " + stack.peek()); // 5
        System.out.println("Is empty: " + stack.isEmpty()); // false
    }
}