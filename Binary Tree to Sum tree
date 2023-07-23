//GFG Practice

class Solution{
    public void toSumTree(Node root){
        //add code here.
        findSum(root);
    }
    
    public int findSum(Node root)
    {
        if (root.left == null && root.right == null){
            int val = root.data;
            root.data = 0;
            return val;
        }
        
        int currVal = root.data;
        int a = 0, b = 0;
        if (root.left != null){
            a = findSum(root.left);
        }
            
        if (root.right != null){
            b = findSum(root.right);
        }
            
        root.data = a+b;
        return (root.data)+ currVal;
    }
}
