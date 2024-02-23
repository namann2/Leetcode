class Solution {
    int left, right;
    public boolean btreeGameWinningMove(TreeNode root, int n, int x) {
        // bottom up or postorder to get the number of nodes in the left and right subtree
        traverse(root, x);
        int nodesInParentStructure = n - (left + right + 1);
        
        // max nodes second player can color
        int max = Math.max(nodesInParentStructure, Math.max(left, right));
        
        return max > n/2;
    }
    private int traverse(TreeNode root, int x) {
        if(root == null) return 0;
        int cntOnLeft = traverse(root.left, x);
        int cntOnRight = traverse(root.right, x);
        if(root.val == x) {
            left = cntOnLeft;
            right = cntOnRight;
        }
        return cntOnLeft + cntOnRight + 1;
    }
}