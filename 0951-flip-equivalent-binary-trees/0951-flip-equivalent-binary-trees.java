class Solution {
    public boolean flipEquiv(TreeNode p, TreeNode q) {
        if(p == null && q == null) return true;
        if(p == null || q == null) return false;
        
        if(p.val != q.val) return false;
        
        boolean isFlip = flipEquiv(p.left, q.right) && flipEquiv(p.right, q.left);
        boolean isNotFlip = flipEquiv(p.left, q.left) && flipEquiv(p.right, q.right);
        
        return isFlip || isNotFlip;
    }
}