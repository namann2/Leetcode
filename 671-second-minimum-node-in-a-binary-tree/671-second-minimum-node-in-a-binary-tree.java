class Solution {
    public int findSecondMinimumValue(TreeNode root) {
        // TC : O(N), SC : O(H)
        if(root == null) return -1;
        return secondMin(root, root.val);
    }
    private int secondMin(TreeNode node, int fm) {
        if(node == null) return -1;
        
        if(node.val > fm) return node.val;
        
        int left = secondMin(node.left, fm);
        int right = secondMin(node.right, fm);
        
        if(left != -1 && right != -1) return Math.min(left, right);
        return left == -1 ? right : left;
    }
}