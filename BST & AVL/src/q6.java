// Node class representing a node in the AVL Tree
class Node3 {
    int key;
    Node left, right;
    int height;

    public Node3(int key) {
        this.key = key;
        this.height = 1;
        this.left = null;
        this.right = null;
    }
}

// AVL Tree class implementing the AVL Tree operations
class AVLTree {
    private Node root;

    // Get height of a node
    private int height(Node node) {
        if (node == null) {
            return 0;
        }
        return node.height;
    }

    // Get balance factor of a node
    private int getBalance(Node node) {
        if (node == null) {
            return 0;
        }
        return height(node.left) - height(node.right);
    }

    // Perform right rotation
    private Node rightRotate(Node y) {
        Node x = y.left;
        Node T2 = x.right;

        // Perform rotation
        x.right = y;
        y.left = T2;

        // Update heights
        y.height = Math.max(height(y.left), height(y.right)) + 1;
        x.height = Math.max(height(x.left), height(x.right)) + 1;

        // Return new root
        return x;
    }

    // Perform left rotation
    private Node leftRotate(Node x) {
        Node y = x.right;
        Node T2 = y.left;

        // Perform rotation
        y.left = x;
        x.right = T2;

        // Update heights
        x.height = Math.max(height(x.left), height(x.right)) + 1;
        y.height = Math.max(height(y.left), height(y.right)) + 1;

        // Return new root
        return y;
    }

    // Insert a key into the AVL Tree
    public void insert(int key) {
        root = insertNode(root, key);
    }

    // Helper function to insert a key into the AVL Tree
    private Node insertNode(Node node, int key) {
        // Perform normal BST insertion
        if (node == null) {
            return new Node(key);
        }

        if (key < node.key) {
            node.left = insertNode(node.left, key);
        } else if (key > node.key) {
            node.right = insertNode(node.right, key);
        } else { // Duplicate keys are not allowed in AVL Tree
            return node;
        }

        // Update height of this ancestor node
        node.height = 1 + Math.max(height(node.left), height(node.right));

        // Get balance factor of this ancestor node to check whether it became unbalanced
        int balance = getBalance(node);

        // If node becomes unbalanced, perform rotations to rebalance the tree
        // Left Left Case
        if (balance > 1 && key < node.left.key) {
            return rightRotate(node);
        }
        // Right Right Case
        if (balance < -1 && key > node.right.key) {
            return leftRotate(node);
        }
        // Left Right Case
        if (balance > 1 && key > node.left.key) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }
        // Right Left Case
        if (balance < -1 && key < node.right.key) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }

        // Return the (unchanged) node pointer
        return node;
    }

    // Delete a key from the AVL Tree
    public void delete(int key) {
        root = deleteNode(root, key);
    }

    // Helper function to delete a key from the AVL Tree
    private Node deleteNode(Node node, int key) {
        // Perform normal BST deletion
        if (node == null) {
            return node;
        }

        if (key < node.key) {
            node.left = deleteNode(node.left, key);
        } else if (key > node.key) {
            node.right = deleteNode(node.right, key);
        } else { // Found the node to be deleted
            if (node.left == null || node.right == null) {
                Node temp = (node.left != null) ? node.left : node.right;

                // No child case
                if (temp == null) {
                    temp = node;
                    node = null;
                } else { // One child case
                    node = temp; // Copy the contents of the non-empty child
                }
            } else { // Node with two children: Get the inorder successor (smallest in the right subtree)
                Node temp = minValueNode(node.right);

                // Copy the inorder successor's data to this node
                node.key = temp.key;

                // Delete the inorder successor
                node.right = deleteNode(node.right, temp.key);
            }
        }

        // If the tree had only one node then return
        if (node == null) {
            return node;
        }

        // Update the height of the current node
        node.height = 1 + Math.max(height(node.left), height(node.right));

        // Get the balance factor of this node to check whether it became unbalanced
        int balance = getBalance(node);

        // If the node becomes unbalanced, then there are 4 cases
        // Left Left Case
        if (balance > 1 && getBalance(node.left) >= 0) {
            return rightRotate(node);
        }
        // Left Right Case
        if (balance > 1 && getBalance(node.left) < 0) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }
        // Right Right Case
        if (balance < -1 && getBalance(node.right) <= 0) {
            return leftRotate(node);
        }
        // Right Left Case
        if (balance < -1 && getBalance(node.right) > 0) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }

        return node;
    }

    // Get the node with the minimum key value in the subtree rooted at given node
    private Node minValueNode(Node node) {
        Node current = node;
        while (current.left != null) {
            current = current.left;
        }
        return current;
    }

    // Print the AVL Tree in in-order traversal
    public void printInOrder() {
        printInOrderRecursive(root);
        System.out.println();
    }

    private void printInOrderRecursive(Node node) {
        if (node != null) {
            printInOrderRecursive(node.left);
            System.out.print(node.key + " ");
            printInOrderRecursive(node.right);
        }
    }

    // Print the AVL Tree in pre-order traversal
    public void printPreOrder() {
        printPreOrderRecursive(root);
        System.out.println();
    }

    private void printPreOrderRecursive(Node node) {
        if (node != null) {
            System.out.print(node.key + " ");
            printPreOrderRecursive(node.left);
            printPreOrderRecursive(node.right);
        }
    }

    // Print the AVL Tree in post-order traversal
    public void printPostOrder() {
        printPostOrderRecursive(root);
        System.out.println();
    }

    private void printPostOrderRecursive(Node node) {
        if (node != null) {
            printPostOrderRecursive(node.left);
            printPostOrderRecursive(node.right);
            System.out.print(node.key + " ");
        }
    }
}

public class AVLTreeExample {
    public static void main(String[] args) {
        AVLTree avlTree = new AVLTree();

        // Insert values 6, 7, 9
        avlTree.insert(6);
        avlTree.insert(7);
        avlTree.insert(9);

        System.out.println("AVL Tree after inserting 6, 7, 9:");
        avlTree.printInOrder();
        avlTree.printPreOrder();
        avlTree.printPostOrder();

        // Delete the root node 7
        avlTree.delete(7);

        System.out.println("AVL Tree after deleting the root node 7:");
        avlTree.printInOrder();
        avlTree.printPreOrder();
        avlTree.printPostOrder();

        // Insert more elements 12, 13, 14, 4, 2, 5, 8
        avlTree.insert(12);
        avlTree.insert(13);
        avlTree.insert(14);
        avlTree.insert(4);
        avlTree.insert(2);
        avlTree.insert(5);
        avlTree.insert(8);

        System.out.println("AVL Tree after inserting more elements:");
        avlTree.printInOrder();
        avlTree.printPreOrder();
        avlTree.printPostOrder();

        // Delete nodes 8 and 5
        avlTree.delete(8);
        avlTree.delete(5);

        System.out.println("AVL Tree after deleting nodes 8 and 5:");
        avlTree.printInOrder();
        avlTree.printPreOrder();
        avlTree.printPostOrder();
    }
}
