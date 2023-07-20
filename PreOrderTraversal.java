package tree;

import java.util.Scanner;
import java.util.Stack;

class BinaryTreeNode<T> {
    T data;
    // Left Child Reference
    BinaryTreeNode<T> left;
    // Right Child Reference
    BinaryTreeNode<T> right;

    BinaryTreeNode(T data) {
        this.data = data;
        // left and right default value is null
    }
}

public class PreOrderTraversal {
    // Scanner to take user input
    private Scanner scanner = new Scanner(System.in);
    // Variable to keep track of the node type (left, right, or root)
    private String nodeName = "root";

    void preOrderRecursive(BinaryTreeNode<Integer> root) {
        if (root == null) {
            return;
        }
        System.out.print(root.data + " ");// parent
        preOrderRecursive(root.left);// left
        preOrderRecursive(root.right);// right
    }

    void preOrderIterative(BinaryTreeNode<Integer> root) {
        if (root == null) {
            return;
        }
        // Prepare a stack
        Stack<BinaryTreeNode<Integer>> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            BinaryTreeNode<Integer> currentNode = stack.pop();
            System.out.print(currentNode.data + "  ");
            // Now push right and left
            if (currentNode.right != null) {
                stack.push(currentNode.right);
            }
            // Push the left
            if (currentNode.left != null) {
                stack.push(currentNode.left);
            }
        }
        System.out.println();
    }

    // Since preOrderIterative2 is not functioning properly, let's remove it for now.

    BinaryTreeNode<Integer> insert() {
        System.out.println("Enter the " + nodeName + " Data or enter -1 to exit");
        int data = scanner.nextInt();
        if (data == -1) {
            return null;
        }
        // If data coming correct
        // Prepare a Node
        BinaryTreeNode<Integer> node = new BinaryTreeNode<>(data);
        // Prepare a Left Node (DFT)
        nodeName = "left";
        node.left = insert();
        // BackTrack
        nodeName = "right";
        node.right = insert();
        // BackTrack
        nodeName = "root";
        return node;
    }

    public static void main(String[] args) {
        PreOrderTraversal tree = new PreOrderTraversal();
        BinaryTreeNode<Integer> root = tree.insert();

        System.out.println("Pre-order Traversal - Recursive:");
        tree.preOrderRecursive(root);
        System.out.println();

        System.out.println("Pre-order Traversal - Iterative:");
        tree.preOrderIterative(root);
    }
}
