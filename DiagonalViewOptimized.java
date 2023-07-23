package tree;
//}
import java.util.*;

class tt {
    int val;
    tt left;
    tt right;

    public tt(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }
}

public class DiagonalViewOptimized {
    // Function to print diagonal view of the tree
    public static void diagonalView(tt root) {
        if (root == null)
            return;

        // Queue to perform level-order traversal
        Queue<tt> queue = new LinkedList<>();
        // Map to store nodes in different diagonals
        Map<Integer, List<Integer>> diagonalMap = new HashMap<>();

        queue.add(root);
        int diagonal = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                tt node = queue.poll();

                // Store the current node's value in the corresponding diagonal list
                List<Integer> diagonalList = diagonalMap.getOrDefault(diagonal, new LinkedList<>());
                diagonalList.add(node.val);
                diagonalMap.put(diagonal, diagonalList);

                if (node.left != null)
                    queue.add(node.left);

                if (node.right != null)
                    queue.add(node.right);
            }
            diagonal++;
        }

        // Print the diagonal view
        for (List<Integer> diagonalList : diagonalMap.values()) {
            for (int val : diagonalList) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }
        public static void main(String[] args) {
            // Create a sample binary tree
            tt root = new tt(100);
            root.left = new tt(1);
            root.right = new tt(200);
            root.left.left = new tt(2);
            root.right.right = new tt(300);
            root.right.left = new tt(60);
            root.right.left.right = new tt(160);
            root.right.left.left = new tt(94);

            // Print the diagonal view of the binary tree
            diagonalView(root);
        
    }}
