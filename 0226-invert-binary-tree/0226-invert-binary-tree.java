class Solution {
    // this is the bottom up manner to solve this. One can also do it in top-down manner, which get struck at the
    // crunch time
    public TreeNode invertTree(TreeNode root) {
        if(root == null) 
            return root;
        invertTree(root.left);
        invertTree(root.right);
        
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        
        return root;
    }
}