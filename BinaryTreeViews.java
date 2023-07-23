package tree;
import java.util.*;

//Node structure for binary tree
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

public class BinaryTreeViews {
 // Function for top view traversal using queue
 public static void topView(TreeNode root) {
     if (root == null)
         return;

     // Map to store nodes with horizontal distance from the root
     Map<Integer, Integer> horizontalDistanceMap = new HashMap<>();

     // Queue for level-order traversal
     Queue<Map.Entry<TreeNode, Integer>> queue = new LinkedList<>();
     queue.add(new AbstractMap.SimpleEntry<>(root, 0));

     while (!queue.isEmpty()) {
         Map.Entry<TreeNode, Integer> entry = queue.poll();
         TreeNode node = entry.getKey();
         int horizontalDistance = entry.getValue();

         if (!horizontalDistanceMap.containsKey(horizontalDistance)) {
             horizontalDistanceMap.put(horizontalDistance, node.val);
         }

         if (node.left != null) {
             queue.add(new AbstractMap.SimpleEntry<>(node.left, horizontalDistance - 1));
         }
         if (node.right != null) {
             queue.add(new AbstractMap.SimpleEntry<>(node.right, horizontalDistance + 1));
         }
     }

     // Printing the top view nodes
     for (int value : horizontalDistanceMap.values()) {
         System.out.print(value + " ");
     }
 }

 // Function for bottom view traversal using queue
 public static void bottomView(TreeNode root) {
     if (root == null)
         return;

     // Map to store nodes with horizontal distance from the root
     Map<Integer, Integer> horizontalDistanceMap = new TreeMap<>();

     // Queue for level-order traversal
     Queue<Map.Entry<TreeNode, Integer>> queue = new LinkedList<>();
     queue.add(new AbstractMap.SimpleEntry<>(root, 0));

     while (!queue.isEmpty()) {
         Map.Entry<TreeNode, Integer> entry = queue.poll();
         TreeNode node = entry.getKey();
         int horizontalDistance = entry.getValue();

         // Update the map for each horizontal distance encountered
         horizontalDistanceMap.put(horizontalDistance, node.val);

         if (node.left != null) {
             queue.add(new AbstractMap.SimpleEntry<>(node.left, horizontalDistance - 1));
         }
         if (node.right != null) {
             queue.add(new AbstractMap.SimpleEntry<>(node.right, horizontalDistance + 1));
         }
     }

     // Printing the bottom view nodes
     for (int value : horizontalDistanceMap.values()) {
         System.out.print(value + " ");
     }
 }

 public static void main(String[] args) {
     // Create a sample binary tree
     TreeNode root = new TreeNode(1);
     root.left = new TreeNode(2);
     root.right = new TreeNode(3);
     root.left.right = new TreeNode(4);
     root.left.right.right = new TreeNode(5);
     root.left.right.right.right = new TreeNode(6);

     System.out.println("Top View:");
     topView(root);

     System.out.println("\nBottom View:");
     bottomView(root);
 }
}
