class Solution {
    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        return height(root);
    }

    private int height(TreeNode root) {
        if(root == null) return 0;

        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        
        return 1 + Math.max(leftHeight, rightHeight);
    }
}