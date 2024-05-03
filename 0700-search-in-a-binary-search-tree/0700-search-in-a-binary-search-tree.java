class Solution {
    public TreeNode searchBST(TreeNode root, int val) {
        if(root == null || val == root.val) return root;
        else if(val > root.val)
            return searchBST(root.right, val);
        else if(val < root.val)
            return searchBST(root.left, val);
        return null;
    }
}