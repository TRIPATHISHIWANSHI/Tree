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
public class nodeAtKthDistance {

	 public static void printNodesAtDistanceK(NodesTree root, int k) {
	        if (root == null || k < 0) {
	            return;
	        }

	        if (k == 0) {
	            System.out.print(root.data + " ");
	            return;
	        }

	        printNodesAtDistanceK(root.left, k - 1);
	        printNodesAtDistanceK(root.right, k - 1);
	    }
	
		 public static void main(String[] args) {
		        // Creating the binary tree
		        NodesTree root = new NodesTree(1);
		        root.left = new NodesTree(2);
		        root.right = new NodesTree(3);
		        root.left.left = new NodesTree(4);
		        root.left.right = new NodesTree(5);
		        root.right.left = new NodesTree(6);
		        root.right.right = new NodesTree(7);
		        root.left.left.left = new NodesTree(8);

		        int k = 2; // Distance from the root to find nodes
		        printNodesAtDistanceK(root,k);


	}

}
