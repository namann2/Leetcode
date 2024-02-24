class Solution {
    public int rangeSumBST(TreeNode root, int low, int high) {
        if(root == null) return 0;
        return traverse(root, low, high);
    }
    private int traverse(TreeNode root, int L, int R) {
        if(root == null) return 0;
        
        int ans = 0;
        if(root.val >= L && root.val <= R)
            ans += root.val;
        
        if(root.val < L || root.val <= R)
            ans += traverse(root.right, L, R);
        
        if(root.val > R || root.val >= L)
            ans += traverse(root.left, L, R);
        
        return ans;
    }
}