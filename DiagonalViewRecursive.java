package tree;

import java.util.*;

class ttt {
    int val;
    ttt left;
    ttt right;

    public ttt(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }
}

public class DiagonalViewRecursive {
    // Recursive function to print nodes in a diagonal
    private static void diagonalViewUtil(ttt root, int diagonal, Map<Integer, List<Integer>> diagonalMap) {
        if (root == null)
            return;

        // Store the current node's value in the corresponding diagonal list
        List<Integer> diagonalList = diagonalMap.getOrDefault(diagonal, new ArrayList<>());
        diagonalList.add(root.val);
        diagonalMap.put(diagonal, diagonalList);

        // Recur for the left child with the same diagonal value
        diagonalViewUtil(root.left, diagonal + 1, diagonalMap);

        // Recur for the right child with the same diagonal value
        diagonalViewUtil(root.right, diagonal, diagonalMap);
    }

    // Function to print diagonal view of the tree
    public static void diagonalView(ttt root) {
        if (root == null)
            return;

        // Map to store nodes in different diagonals
        Map<Integer, List<Integer>> diagonalMap = new HashMap<>();

        // Fill the diagonal map using recursive utility function
        diagonalViewUtil(root, 0, diagonalMap);

        // Print the diagonal view
        for (int diagonal : diagonalMap.keySet()) {
            List<Integer> diagonalList = diagonalMap.get(diagonal);
            for (int val : diagonalList) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        // Create a sample binary tree
        ttt root = new ttt(100);
        root.left = new ttt(1);
        root.right = new ttt(200);
        root.left.left = new ttt(2);
        root.right.right = new ttt(300);
        root.right.left = new ttt(60);
        root.right.left.right = new ttt(160);
        root.right.left.left = new ttt(94);

        // Print the diagonal view of the binary tree
        diagonalView(root);
    }
}
