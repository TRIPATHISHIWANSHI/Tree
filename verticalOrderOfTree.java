package tree;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

class BinaryTreeNodes<T> {
    T data;
    BinaryTreeNode<T> left;
    BinaryTreeNode<T> right;

    public BinaryTreeNode(T data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

public class verticalOrderOfTree {

    public void printVerticalOrder(BinaryTreeNode<Integer> root) {
        TreeMap<Integer, ArrayList<Integer>> map = new TreeMap<>();
        verticalOrder(root, 0, map);
        for (Map.Entry<Integer, ArrayList<Integer>> m : map.entrySet()) {
            System.out.println(m.getKey() + "  " + m.getValue());
        }
    }

    public void verticalOrder(BinaryTreeNode<Integer> root, int distance, TreeMap<Integer, ArrayList<Integer>> map) {
        // Termination Case
        if (root == null) {
            return;
        }
        if (map.get(distance) == null) {
            // create fresh arrayList
            ArrayList<Integer> list = new ArrayList<>();
            list.add(root.data);
            map.put(distance, list);
        } else {
            // distance exists
            // get the old list
            ArrayList<Integer> l = map.get(distance);
            l.add(root.data);
            map.put(distance, l);
        }
        verticalOrder(root.left, distance - 1, map);
        verticalOrder(root.right, distance + 1, map);
    }

    public static void main(String[] args) {
        // Create the binary tree
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(1);
        root.left = new BinaryTreeNode<>(2);
        root.right = new BinaryTreeNode<>(3);
        root.left.left = new BinaryTreeNode<>(4);
        root.left.right = new BinaryTreeNode<>(5);
        root.right.left = new BinaryTreeNode<>(6);
        root.right.right = new BinaryTreeNode<>(7);

        verticalOrderOfTree verticalOrder = new verticalOrderOfTree();
        verticalOrder.printVerticalOrder(root);
    }
}
