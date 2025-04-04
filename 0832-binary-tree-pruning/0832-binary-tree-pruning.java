class Solution {
    public TreeNode pruneTree(TreeNode root) {
        if(root == null) return null;
        boolean isRoot = prune(root);
        return !isRoot ? null : root;
    }

    private boolean prune(TreeNode root) {
        if(root == null) return false;
        if(root.left == null && root.right == null) return root.val == 1;

        boolean left = prune(root.left);
        boolean right = prune(root.right);

        if(!left) root.left = null;
        if(!right) root.right = null;

        return left || right || root.val == 1;
    }
}