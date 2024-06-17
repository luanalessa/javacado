package dataStructures;

public class BinaryTreeSearch {
    // Classe interna para representar os nós da árvore
    private static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            left = null;
            right = null;
        }
    }

    private Node root;

    public BinaryTreeSearch() {
        root = null;
    }

    // Método para inserir um elemento na árvore binária de busca
    public void insert(int data) {
        root = insertRec(root, data);
    }

    // Método auxiliar recursivo para inserção
    private Node insertRec(Node root, int data) {
        if (root == null) {
            root = new Node(data);
            return root;
        }

        if (data < root.data) {
            root.left = insertRec(root.left, data);
        } else if (data > root.data) {
            root.right = insertRec(root.right, data);
        }

        return root;
    }

    // Método para buscar um elemento na árvore binária de busca
    public boolean search(int data) {
        return searchRec(root, data);
    }

    // Método auxiliar recursivo para busca
    private boolean searchRec(Node root, int data) {
        if (root == null) {
            return false;
        }

        if (data == root.data) {
            return true;
        } else if (data < root.data) {
            return searchRec(root.left, data);
        } else {
            return searchRec(root.right, data);
        }
    }

    // Método para realizar travessia in-order (esquerda, raiz, direita)
    public void inOrderTraversal() {
        inOrderTraversalRec(root);
        System.out.println();
    }

    // Método auxiliar recursivo para travessia in-order
    private void inOrderTraversalRec(Node root) {
        if (root != null) {
            inOrderTraversalRec(root.left);
            System.out.print(root.data + " ");
            inOrderTraversalRec(root.right);
        }
    }

    // Método para realizar travessia pré-ordem (raiz, esquerda, direita)
    public void preOrderTraversal() {
        preOrderTraversalRec(root);
        System.out.println();
    }

    // Método auxiliar recursivo para travessia pré-ordem
    private void preOrderTraversalRec(Node root) {
        if (root != null) {
            System.out.print(root.data + " ");
            preOrderTraversalRec(root.left);
            preOrderTraversalRec(root.right);
        }
    }

    // Método para realizar travessia pós-ordem (esquerda, direita, raiz)
    public void postOrderTraversal() {
        postOrderTraversalRec(root);
        System.out.println();
    }

    // Método auxiliar recursivo para travessia pós-ordem
    private void postOrderTraversalRec(Node root) {
        if (root != null) {
            postOrderTraversalRec(root.left);
            postOrderTraversalRec(root.right);
            System.out.print(root.data + " ");
        }
    }

    public void remove(int data) {
        root = removeRec(root, data);
    }

    // Método auxiliar recursivo para remoção
    private Node removeRec(Node root, int data) {
        if (root == null) {
            return null;
        }

        // Busca pelo nó a ser removido
        if (data < root.data) {
            root.left = removeRec(root.left, data);
        } else if (data > root.data) {
            root.right = removeRec(root.right, data);
        } else {
            // Caso 1: Nó é uma folha (sem filhos)
            if (root.left == null && root.right == null) {
                return null;
            }
            // Caso 2: Nó possui apenas um filho
            else if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }
            // Caso 3: Nó possui dois filhos
            else {
                // Encontrar o sucessor in-order (menor elemento na subárvore direita)
                root.data = minValue(root.right);

                // Remover o sucessor in-order
                root.right = removeRec(root.right, root.data);
            }
        }
        return root;
    }

    // Método auxiliar para encontrar o menor valor na árvore
    private int minValue(Node root) {
        int minValue = root.data;
        while (root.left != null) {
            minValue = root.left.data;
            root = root.left;
        }
        return minValue;
    }

    public static void main(String[] args) {
        BinaryTreeSearch tree = new BinaryTreeSearch();

        // Inserir elementos na árvore
        tree.insert(50);
        tree.insert(30);
        tree.insert(20);
        tree.insert(40);
        tree.insert(70);
        tree.insert(60);
        tree.insert(80);

        // Realizar travessias
        System.out.println("In-order traversal:");
        tree.inOrderTraversal();

        System.out.println("Pre-order traversal:");
        tree.preOrderTraversal();

        System.out.println("Post-order traversal:");
        tree.postOrderTraversal();

        // Buscar elementos na árvore
        int searchKey = 30;
        System.out.println("Search for " + searchKey + ": " + tree.search(searchKey));

        searchKey = 90;
        System.out.println("Search for " + searchKey + ": " + tree.search(searchKey));

        // Remover elementos da árvore
        System.out.println("Remove 30:");
        tree.remove(30);
        System.out.println("In-order traversal after removal:");
        tree.inOrderTraversal();
    }
}
