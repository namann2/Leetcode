class Solution {
    public int averageOfSubtree(TreeNode root) {
        int[] ans = iterate(root, 0, 0);
        return ans[2];
    }
    private int[] iterate(TreeNode root, int cntNodes, int sum) {
        if(root == null) 
            return new int[]{0, 0, 0};
        
        int[] left = iterate(root.left, cntNodes, sum);
        int[] right = iterate(root.right, cntNodes, sum);
        
        int totalNodes = 1 + left[0] + right[0];
        int currSum = root.val + left[1] + right[1];
        int currAns = left[2] + right[2];
        
        if(root.val == (int)(currSum / totalNodes)) currAns++;
        return new int[]{totalNodes, currSum, currAns};
    }
}