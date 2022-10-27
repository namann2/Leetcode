class Solution {
    int moves;
    public int distributeCoins(TreeNode root) {
        if(root == null)
            return 0;
        
        moves = 0;
        postOrder(root);
        return moves;
    }
    private int postOrder(TreeNode root) {
        if(root == null)
            return 0;
        
        int left = postOrder(root.left);
        int right = postOrder(root.right);
        
        moves += Math.abs(left) + Math.abs(right); // number of excess coins
        return left + right + root.val - 1; // remaining coins after balancing the subtree
    }
}