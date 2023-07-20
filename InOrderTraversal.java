package tree;
import java.util.Stack;

public class InOrderTraversal {

    void iterativeInOrder(BinaryTreeNode<Integer> root) {
        Stack<BinaryTreeNode<Integer>> stack = new Stack<>();
        BinaryTreeNode<Integer> currentNode = root;
        
        while (currentNode != null || !stack.isEmpty()) {
            while (currentNode != null) {
                stack.push(currentNode);
                currentNode = currentNode.left;
            }
            
            currentNode = stack.pop();
            System.out.print(currentNode.data + " "); // Print nodes on the same line, separated by spaces
            currentNode = currentNode.right;
        }
    }

    public static void main(String[] args) {
        // Sample usage
        InOrderTraversal traversal = new InOrderTraversal();
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(1);
        root.left = new BinaryTreeNode<>(2);
        root.right = new BinaryTreeNode<>(3);
        root.left.left = new BinaryTreeNode<>(4);
        root.left.right = new BinaryTreeNode<>(5);
        
        traversal.iterativeInOrder(root);
    }
}
