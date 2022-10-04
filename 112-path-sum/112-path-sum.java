class Solution {
    public boolean hasPathSum(TreeNode root, int k) {
        if(root == null) 
            return false;
        return solve(root, 0, k);
    }
    private boolean solve(TreeNode root, int curr, int k) {
        if(root == null) return false;
        int sum = curr + root.val;
        
        if(root.left == null && root.right == null)
            return sum == k;
        
        boolean left = solve(root.left, sum, k);
        boolean right = solve(root.right, sum, k);
        
        return left || right;
    }
}