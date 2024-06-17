package dataStructures;

public class Queue {
    // Inner Node class
    private class Node {
        String data;
        Node next;

        Node(String data) {
            this.data = data;
        }
    }

    // Fields for the front, rear, and size of the queue
    private Node front;
    private Node rear;
    private int size;

    // Constructor to initialize the queue
    public Queue() {
        front = null;
        rear = null;
        size = 0;
    }

    // Method to add an element to the end of the queue
    public void enqueue(String data) {
        Node newNode = new Node(data);
        if (isEmpty()) {
            front = newNode;
            rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
        size++;
    }

    // Method to remove and return the front element of the queue
    public String dequeue() {
        if (isEmpty()) {
            return null;
        }
        String data = front.data;
        front = front.next;
        size--;
        if (isEmpty()) {
            rear = null;
        }
        return data;
    }

    // Method to get the front element of the queue without removing it
    public String peek() {
        if (isEmpty()) {
            return null;
        }
        return front.data;
    }

    // Method to check if the queue is empty
    public boolean isEmpty() {
        return size == 0;
    }

    // Method to get the size of the queue
    public int size() {
        return size;
    }

    // Method to print the queue
    public void print() {
        Node temp = front;
        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }

    // Main method for testing the Queue class
    public static void main(String[] args) {
        Queue queue = new Queue();

        // Test enqueuing elements
        queue.enqueue("01");
        queue.enqueue("02");
        queue.enqueue("03");
        System.out.println("After enqueuing elements:");
        queue.print();
        System.out.println("Size: " + queue.size());

        // Test peeking at the front element
        System.out.println("\nFront element (peek): " + queue.peek());

        // Test dequeuing elements
        System.out.println("\nDequeued element: " + queue.dequeue());
        System.out.println("After dequeuing an element:");
        queue.print();
        System.out.println("Size: " + queue.size());

        // Test if the queue is empty
        System.out.println("\nIs queue empty? " + queue.isEmpty());

        // Dequeue all elements to empty the queue
        queue.dequeue();
        queue.dequeue();
        System.out.println("\nAfter dequeuing all elements:");
        queue.print();
        System.out.println("Size: " + queue.size());
        System.out.println("Is queue empty? " + queue.isEmpty());

        // Test peek on an empty queue
        System.out.println("\nFront element on empty queue (peek): " + queue.peek());
    }
}
