class Solution {
    public int sumOfLeftLeaves(TreeNode root) {
        if(root == null) return 0;
        return leftLeafSum(root, false);
    }
    private int leftLeafSum(TreeNode root, boolean isLeft) {
        // base case
        if(root == null) return 0;
        if(root.left == null && root.right == null) {
            return isLeft ? root.val : 0;
        }
        // main logic
        return leftLeafSum(root.left, true) + leftLeafSum(root.right, false);
    }
}