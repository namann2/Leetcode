class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null)
            return false;
        return hasPath(root, targetSum);
    }
    
    private boolean hasPath(TreeNode root, int target) {
        if(root == null) return false;
        if(isLeaf(root) && target == root.val) return true;
        
        return hasPath(root.left, target - root.val) || hasPath(root.right, target - root.val);
    }
    
    private boolean isLeaf(TreeNode root) {
        return root.left == null && root.right == null;
    }
}