class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null) return q == null;
        if(q == null) return p == null;
        
        if(p.val != q.val) return false;
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}