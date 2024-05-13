class Node {
    int key;
    String name;
    Node left, right;

    public Node(int key, String name) {
        this.key = key;
        this.name = name;
        left = null;
        right = null;
    }
}

class BinaryTree {
    private Node root;

    public BinaryTree() {
        root = null;
    }

    public void addNode(int key, String name) {
        Node newNode = new Node(key, name);

        if (root == null) {
            // If tree is empty, make the new node as root
            root = newNode;
        } else {
            Node current = root;
            Node parent;

            while (true) {
                parent = current;

                // If new node's key is less than current node's key, go to the left child
                if (key < current.key) {
                    current = current.left;
                    if (current == null) {
                        // If left child is null, insert new node here
                        parent.left = newNode;
                        break;
                    }
                } else {
                    // If new node's key is greater than or equal to current node's key, go to the right child
                    current = current.right;
                    if (current == null) {
                        // If right child is null, insert new node here
                        parent.right = newNode;
                        break;
                    }
                }
            }
        }
    }
}

public class q1 {
    public static void main(String[] args) {
        BinaryTree bst = new BinaryTree();

        // Adding nodes to the binary search tree
        bst.addNode(50, "Ehtesham");
        bst.addNode(25, "Amjad");
        bst.addNode(75, "Ahmed");
        bst.addNode(15, "Asim");
        bst.addNode(30, "Qasim");

        // Optionally, you can add more nodes and perform operations on the BST here
    }
}
