package dataStructures;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {
    // Inner Node class
    private class Node {
        String data;
        Node left, right;

        Node(String data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }

        // Method to check if the node is a leaf
        public boolean isLeaf() {
            return left == null && right == null;
        }
    }

    private Node root;

    public BinaryTree() {
        root = null;
    }

    // Method to insert a new node into the binary tree using Queue
    public void insert(String data) {
        Node newNode = new Node(data);

        if (root == null) {
            root = newNode;
            return;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node current = queue.remove();

            if (data.compareTo(current.data) < 0) {
                if (current.left == null) {
                    current.left = newNode;
                    return;
                } else {
                    queue.add(current.left);
                }
            } else {
                if (current.right == null) {
                    current.right = newNode;
                    return;
                } else {
                    queue.add(current.right);
                }
            }
        }
    }

    // Method to search for a node in the binary tree
    public boolean search(String data) {
        return searchRec(root, data);
    }

    private boolean searchRec(Node root, String data) {
        if (root == null) {
            return false;
        }

        if (data.equals(root.data)) {
            return true;
        }

        if (data.compareTo(root.data) < 0) {
            return searchRec(root.left, data);
        } else {
            return searchRec(root.right, data);
        }
    }

    // Method to perform in-order traversal
    public void inOrder() {
        inOrderRec(root);
        System.out.println();
    }

    private void inOrderRec(Node root) {
        if (root != null) {
            inOrderRec(root.left);
            System.out.print(root.data + " ");
            inOrderRec(root.right);
        }
    }

    // Method to perform pre-order traversal
    public void preOrder() {
        preOrderRec(root);
        System.out.println();
    }

    private void preOrderRec(Node root) {
        if (root != null) {
            System.out.print(root.data + " ");
            preOrderRec(root.left);
            preOrderRec(root.right);
        }
    }

    // Method to perform post-order traversal
    public void postOrder() {
        postOrderRec(root);
        System.out.println();
    }

    private void postOrderRec(Node root) {
        if (root != null) {
            postOrderRec(root.left);
            postOrderRec(root.right);
            System.out.print(root.data + " ");
        }
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();

        // Insert elements
        tree.insert("50");
        tree.insert("30");
        tree.insert("20");
        tree.insert("40");
        tree.insert("70");
        tree.insert("60");
        tree.insert("80");

        // Perform in-order traversal
        System.out.println("In-order traversal:");
        tree.inOrder();

        // Check if nodes are leaves (optional test)
        Node node30 = tree.root.left;
        Node node20 = node30.left;
        Node node70 = tree.root.right;

        System.out.println("Is node '30' a leaf? " + node30.isLeaf());
        System.out.println("Is node '20' a leaf? " + node20.isLeaf());
        System.out.println("Is node '70' a leaf? " + node70.isLeaf());
    }
}
