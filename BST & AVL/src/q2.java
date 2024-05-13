class Node2 {
    int key;
    String name;
    Node left, right;

    public Node2(int key, String name) {
        this.key = key;
        this.name = name;
        left = null;
        right = null;
    }
}

class Binarytree {
    private Node root;

    public Binarytree() {
        root = null;
    }

    // Method to add a new node into the binary search tree
    public void addNode(int key, String name) {
        root = insert(root, key, name);
    }

    // Helper method to recursively insert a new node into the binary search tree
    private Node insert(Node current, int key, String name) {
        if (current == null) {
            return new Node(key, name);
        }

        if (key < current.key) {
            current.left = insert(current.left, key, name);
        } else {
            current.right = insert(current.right, key, name);
        }

        return current;
    }

    // Preorder traversal: Visit Node, Traverse left subtree, Traverse right subtree
    public void preorderTraversal() {
        preorderRecursive(root);
    }

    private void preorderRecursive(Node node) {
        if (node != null) {
            System.out.print(node.key + " " + node.name + ", "); // Visit node
            preorderRecursive(node.left); // Traverse left subtree
            preorderRecursive(node.right); // Traverse right subtree
        }
    }

    // Inorder traversal: Traverse left subtree, Visit Node, Traverse right subtree
    public void inorderTraversal() {
        inorderRecursive(root);
    }

    private void inorderRecursive(Node node) {
        if (node != null) {
            inorderRecursive(node.left); // Traverse left subtree
            System.out.print(node.key + " " + node.name + ", "); // Visit node
            inorderRecursive(node.right); // Traverse right subtree
        }
    }
}

public class q2 {
    public static void main(String[] args) {
        Binarytree bst = new Binarytree();

        // Adding nodes to the binary search tree
        bst.addNode(50, "Ahmed");
        bst.addNode(25, "Amjad");
        bst.addNode(75, "Ali");
        bst.addNode(15, "Kamran");
        bst.addNode(30, "Khan");

        // Perform preorder traversal
        System.out.println("Preorder Traversal:");
        bst.preorderTraversal();
        System.out.println();

        // Perform inorder traversal
        System.out.println("Inorder Traversal:");
        bst.inorderTraversal();
        System.out.println();
    }
}
