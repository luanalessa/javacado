package dataStructures;

public class LinkedList {
    // Inner Node class
    private class Node {
        String data;
        Node next;

        Node(String data) {
            this.data = data;
        }
    }

    // Fields for head, tail, and length of the list
    private Node head;
    private Node tail;
    private int length;

    // Constructor to initialize the list with a single element
    public LinkedList(String data) {
        Node newNode = new Node(data);
        head = newNode;
        tail = newNode;
        length = 1;
    }

    // Getters for head, tail, and length
    public Node getHead() {
        return head;
    }

    public Node getTail() {
        return tail;
    }

    public int getLength() {
        return length;
    }

    // Method to empty the list
    public void makeEmpty() {
        head = null;
        tail = null;
        length = 0;
    }

    // Method to print the list
    public void print() {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }

    // Method to prepend an element to the list
    public void prepend(String data) {
        Node newNode = new Node(data);
        if (length == 0) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
        length++;
    }

    // Method to append an element to the list
    public void append(String data) {
        Node newNode = new Node(data);
        if (length == 0) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        length++;
    }

    // Method to remove the last element from the list
    public Node removeLast() {
        if (length == 0) return null;
        if (length == 1) {
            Node temp = tail;
            makeEmpty();
            return temp;
        }
        Node pre = head;
        while (pre.next != tail) {
            pre = pre.next;
        }
        Node temp = tail;
        tail = pre;
        tail.next = null;
        length--;
        return temp;
    }

    // Method to remove the first element from the list
    public Node removeFirst() {
        if (length == 0) return null;
        Node temp = head;
        head = head.next;
        temp.next = null;
        length--;
        if (length == 0) {
            tail = null;
        }
        return temp;
    }

    // Method to get the node at a specific index
    public Node get(int index) {
        if (index < 0 || index >= length) return null;
        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp;
    }

    // Method to insert an element at a specific index
    public boolean insert(int index, String data) {
        if (index < 0 || index > length) return false;
        if (index == 0) {
            prepend(data);
            return true;
        }
        if (index == length) {
            append(data);
            return true;
        }
        Node newNode = new Node(data);
        Node temp = get(index - 1);
        newNode.next = temp.next;
        temp.next = newNode;
        length++;
        return true;
    }

    // Main method for testing the LinkedList class
    public static void main(String[] args) {
        LinkedList list = new LinkedList("01");

        // Test appending elements
        list.append("02");
        list.append("03");
        System.out.println("After appending elements:");
        list.print();
        System.out.println("Length: " + list.getLength());

        // Test prepending elements
        list.prepend("00");
        System.out.println("\nAfter prepending elements:");
        list.print();
        System.out.println("Length: " + list.getLength());

        // Test inserting elements at specific indices
        list.insert(2, "01.5");
        System.out.println("\nAfter inserting at index 2:");
        list.print();
        System.out.println("Length: " + list.getLength());

        // Test removing the last element
        list.removeLast();
        System.out.println("\nAfter removing the last element:");
        list.print();
        System.out.println("Length: " + list.getLength());

        // Test removing the first element
        list.removeFirst();
        System.out.println("\nAfter removing the first element:");
        list.print();
        System.out.println("Length: " + list.getLength());

        // Test getting an element at a specific index
        Node node = list.get(1);
        if (node != null) {
            System.out.println("\nElement at index 1: " + node.data);
        } else {
            System.out.println("\nIndex out of bounds.");
        }

        // Test making the list empty
        list.makeEmpty();
        System.out.println("\nAfter making the list empty:");
        list.print();
        System.out.println("Length: " + list.getLength());
    }
}
