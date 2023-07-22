package tree;

class NodesTree {
    int data;
    NodesTree left;
    NodesTree right;

    NodesTree(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

public class MaximumElementInTree {

    // Function to find the maximum element in the binary tree
    public static int findMax(NodesTree root) {
        if (root == null) {
            return Integer.MIN_VALUE;
        }

        int leftMax = findMax(root.left);
        int rightMax = findMax(root.right);

        return Math.max(Math.max(leftMax, rightMax), root.data);
    }

    // Function to perform other tree operations (example: count nodes, calculate sum, etc.)
    // ...

    public static void main(String[] args) {
        NodesTree tree = new NodesTree(10);
        tree.left = new NodesTree(100);
        tree.right = new NodesTree(30);
        tree.right.left = new NodesTree(90);
        tree.right.right = new NodesTree(70);

        // Find the maximum element in the binary tree
        int maxElement = findMax(tree);
        System.out.println("Maximum element in the binary tree: " + maxElement);

        // Perform other tree operations
        // ...
    }
}
