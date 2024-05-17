class Solution {
    int ans = 0;
    public int maxPathSum(TreeNode root) {
        if(root == null) return ans;
        ans = Integer.MIN_VALUE;
        bottomup(root);
        return ans;
    }
    
    private int bottomup(TreeNode root) {
        if(root == null) return 0;
        
        int left = bottomup(root.left);
        int right = bottomup(root.right);
        
        int onlyRoot = root.val;
        int rootLeft = root.val + left;
        int rootRight = root.val + right;
        int rootSub = root.val + left + right;
        
        int currmax = max(max(onlyRoot, rootLeft), max(rootRight, rootSub));
        ans = max(ans, currmax);
        
        // we need a sequence of path, a path can either go left or right
        return max(max(onlyRoot, rootLeft), rootRight);
    }
    
    private int max(int a, int b) {
        return Math.max(a, b);
    }
}