class Solution {
    public int rob(TreeNode root) {
        if(root == null)
            return 0;
        int[]data = solve(root);
        return Math.max(data[0], data[1]);
    }
    private int[] solve(TreeNode root) {
        if(root == null)
            return new int[]{0, 0}; // include, exclude
        
        int[] left = solve(root.left);
        int[] right = solve(root.right);
        
        int include = root.val + left[1] + right[1];
        int exclude = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        
        return new int[]{include, exclude};
    }
}