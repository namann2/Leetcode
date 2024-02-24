class Solution {
    int ans = 0;
    public int maxPathSum(TreeNode root) {
        if(root == null) return 0;
        ans = Integer.MIN_VALUE;
        bottomup(root);
        return ans;
    }
    private int bottomup(TreeNode root) {
        if(root == null) return 0;
        // if there is neg value from either subtree, ignore it since
        // we need to find the maximum sum
        int left = Math.max(0, bottomup(root.left));
        int right = Math.max(0, bottomup(root.right));
        
        ans = Math.max(ans, root.val); // only root
        ans = Math.max(ans, root.val + left + right); // consider this subtree
        ans = Math.max(ans, root.val + Math.max(left, right)); // consider the root and either of the left/right subtree
        
        // return max sum of current subtree to parent
        return root.val + Math.max(left, right);
    }
}