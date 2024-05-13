class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }
}

public class q5 {
    public TreeNode bstFromPreorder(int[] preorder) {
        if (preorder == null || preorder.length == 0) {
            return null;
        }

        // Start constructing the BST recursively from the first element of the preorder array
        return buildBST(preorder, 0, preorder.length - 1);
    }

    private TreeNode buildBST(int[] preorder, int start, int end) {
        if (start > end) {
            return null;
        }

        // The first element in the current range is the root of the subtree
        TreeNode root = new TreeNode(preorder[start]);

        // Find the index of the first element greater than the root (right subtree start)
        int i;
        for (i = start; i <= end; i++) {
            if (preorder[i] > root.val) {
                break;
            }
        }

        // Recursively build the left and right subtrees
        root.left = buildBST(preorder, start + 1, i - 1); // Left subtree (elements < root)
        root.right = buildBST(preorder, i, end); // Right subtree (elements > root)

        return root;
    }

    // Helper method to print the tree in inorder traversal for verification
    private void inorderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        inorderTraversal(root.left);
        System.out.print(root.val + " ");
        inorderTraversal(root.right);
    }

    public static void main(String[] args) {
        q5 solution = new q5();

        int[] preorder = {8, 5, 1, 7, 10, 12};

        TreeNode root = solution.bstFromPreorder(preorder);

        // Print inorder traversal of the constructed BST for verification
        System.out.println("Inorder Traversal of Constructed BST:");
        solution.inorderTraversal(root);
    }
}
