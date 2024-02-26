class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        // TC : O(N + M), SC : O(H1 + H2)
        // In worst case, N = M and H1 = H2 i.e. TC : O(N), SC : O(H)
        if(p == null && q == null) return true;
        if(p == null || q == null) return false;
        
        if(p.val != q.val) return false;
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}