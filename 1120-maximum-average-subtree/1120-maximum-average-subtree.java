class Solution {
    public double maximumAverageSubtree(TreeNode root) {
        if(root == null) 
            return 0d;
        double[]answer = findMax(root);
        return answer[2];
    }
    
    private double[] findMax(TreeNode root) {
        if(root == null) return new double[]{0d, 0d, 0d};
        
        double[] left = findMax(root.left);
        double[] right = findMax(root.right);
        
        double totalNodesInSubtree = left[1] + right[1] + 1;
        double totalSumOfSubtree = left[0] + right[0] + root.val;
        
        double max = Math.max(totalSumOfSubtree / totalNodesInSubtree, Math.max(left[2], right[2]));
        return new double[]{totalSumOfSubtree, totalNodesInSubtree, max};
    }
}