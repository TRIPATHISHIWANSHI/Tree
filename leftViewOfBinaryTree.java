package linkedList;

public class leftViewOfBinaryTree {
    public static class Node {
        int data;
        Node left = null, right = null;

        public Node(int data) {
            this.data = data;
        }
    }

    static int maxLevel = 0;

    public static void leftViewRecursive(Node root) {
        leftViewUtil(root, 1);
    }

    public static void leftViewUtil(Node node, int level) {
        if (node == null) {
            return;
        }

        if (maxLevel < level) {
            System.out.print(node.data + " ");
            maxLevel = level;
        }

        leftViewUtil(node.left, level + 1);
        leftViewUtil(node.right, level + 1);
    }

    public static void main(String[] args) {
        Node node = new Node(1);
        node.left = new Node(2);
        node.right = new Node(3);
        node.left.left = new Node(4);
        node.left.right = new Node(5);
        node.right.left = new Node(6);
        node.right.right = new Node(7);

        System.out.println("Left view of the binary tree:");
        leftViewRecursive(node);
    }
}
