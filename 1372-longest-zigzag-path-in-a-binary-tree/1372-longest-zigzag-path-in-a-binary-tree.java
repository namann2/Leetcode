class Solution {

    public int longestZigZag(TreeNode root) {
        if(root == null) 
            return 0;

        int[]data = solve(root);
        return data[2] - 1;
    }
    private int[] solve(TreeNode root) {
        if(root == null) 
            return new int[]{0, 0, 0};
        
        int[] leftSide = solve(root.left);
        int[] rightSide = solve(root.right);
        
        int max = Math.max(leftSide[2], rightSide[2]);
        // get the maximum value for the subtree rooted at the current node
        int cx = 1 + leftSide[1];
        int cy = 1 + rightSide[0];
        
        max = Math.max(max, Math.max(cx, cy));
        
        return new int[]{cx, cy, max};
    }
}