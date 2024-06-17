package dataStructures;

public class Stack {
    // Inner Node class
    private class Node {
        String data;
        Node next;

        Node(String data) {
            this.data = data;
        }
    }

    // Fields for top and size of the stack
    private Node top;
    private int size;

    // Constructor to initialize the stack
    public Stack() {
        top = null;
        size = 0;
    }

    // Method to push an element onto the stack
    public void push(String data) {
        Node newNode = new Node(data);
        newNode.next = top;
        top = newNode;
        size++;
    }

    // Method to pop an element from the stack
    public String pop() {
        if (isEmpty()) {
            return null;
        }
        String data = top.data;
        top = top.next;
        size--;
        return data;
    }

    // Method to get the top element of the stack without removing it
    public String getTop() {
        if (isEmpty()) {
            return null;
        }
        return top.data;
    }

    // Method to check if the stack is empty
    public boolean isEmpty() {
        return size == 0;
    }

    // Method to get the size of the stack
    public int size() {
        return size;
    }

    // Method to print the stack
    public void print() {
        Node temp = top;
        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }

    // Main method for testing the Stack class
    public static void main(String[] args) {
        Stack stack = new Stack();

        // Test pushing elements onto the stack
        stack.push("01");
        stack.push("02");
        stack.push("03");
        System.out.println("After pushing elements:");
        stack.print();
        System.out.println("Size: " + stack.size());

        // Test getTop to retrieve the top element
        System.out.println("\nTop element (getTop): " + stack.getTop());

        // Test popping elements from the stack
        System.out.println("\nPopped element: " + stack.pop());
        System.out.println("After popping an element:");
        stack.print();
        System.out.println("Size: " + stack.size());

        // Test if the stack is empty
        System.out.println("\nIs stack empty? " + stack.isEmpty());

        // Pop all elements to empty the stack
        stack.pop();
        stack.pop();
        System.out.println("\nAfter popping all elements:");
        stack.print();
        System.out.println("Size: " + stack.size());
        System.out.println("Is stack empty? " + stack.isEmpty());

        // Test getTop on an empty stack
        System.out.println("\nTop element on empty stack (getTop): " + stack.getTop());
    }
}
