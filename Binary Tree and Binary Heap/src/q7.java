class FamilyMember {
    private int wealth;
    private FamilyMember leftChild;
    private FamilyMember rightChild;

    public FamilyMember(int wealth) {
        this.wealth = wealth;
        this.leftChild = null;
        this.rightChild = null;
    }

    // Getters and setters
    public int getWealth() {
        return wealth;
    }

    public FamilyMember getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(FamilyMember leftChild) {
        this.leftChild = leftChild;
    }

    public FamilyMember getRightChild() {
        return rightChild;
    }

    public void setRightChild(FamilyMember rightChild) {
        this.rightChild = rightChild;
    }
}

public class q7 {
    public static FamilyMember buildFamilyTree() {
        // Creating nodes with corresponding wealth
        FamilyMember root = new FamilyMember(50000);
        FamilyMember leftChild = new FamilyMember(25000);
        FamilyMember rightChild = new FamilyMember(30000);
        FamilyMember leftLeftChild = new FamilyMember(10000);
        FamilyMember leftRightChild = new FamilyMember(15000);
        FamilyMember rightLeftChild = new FamilyMember(20000);
        FamilyMember rightRightChild = new FamilyMember(10000);
        FamilyMember bottom1 = new FamilyMember(5000);
        FamilyMember bottom2 = new FamilyMember(5000);
        FamilyMember bottom3 = new FamilyMember(5000);
        FamilyMember bottom4 = new FamilyMember(5000);
        FamilyMember bottom5 = new FamilyMember(5000);
        FamilyMember bottom6 = new FamilyMember(5000);
        FamilyMember bottom7 = new FamilyMember(5000);
        FamilyMember bottom8 = new FamilyMember(5000);

        // Building the tree structure
        root.setLeftChild(leftChild);
        root.setRightChild(rightChild);
        leftChild.setLeftChild(leftLeftChild);
        leftChild.setRightChild(leftRightChild);
        rightChild.setLeftChild(rightLeftChild);
        rightChild.setRightChild(rightRightChild);
        leftLeftChild.setLeftChild(bottom1);
        leftLeftChild.setRightChild(bottom2);
        leftRightChild.setLeftChild(bottom3);
        leftRightChild.setRightChild(bottom4);
        rightLeftChild.setLeftChild(bottom5);
        rightLeftChild.setRightChild(bottom6);
        rightRightChild.setLeftChild(bottom7);
        rightRightChild.setRightChild(bottom8);

        return root;
    }

    public static void main(String[] args) {
        // Build the family tree
        FamilyMember root = buildFamilyTree();

        // Print the wealth of each family member (in-order traversal)
        printWealth(root);
    }

    public static void printWealth(FamilyMember member) {
        if (member != null) {
            printWealth(member.getLeftChild());
            System.out.println("Wealth: $" + member.getWealth());
            printWealth(member.getRightChild());
        }
    }
}
