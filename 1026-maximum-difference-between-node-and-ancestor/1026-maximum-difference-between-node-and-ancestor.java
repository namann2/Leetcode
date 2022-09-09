class Solution {
    public int maxAncestorDiff(TreeNode root) {
        if(root == null) return 0;
        return preorder(root, root.val, root.val);
    }
    private int preorder(TreeNode root, int currMax, int currMin) {
        // base case
        if(root == null) return 0;
        
        // main logic
        currMax = Math.max(currMax, root.val);
        currMin = Math.min(currMin, root.val);
        
        int ans = currMax - currMin;
        
        int left = preorder(root.left, currMax, currMin);
        int right = preorder(root.right, currMax, currMin);
        
        int subtreeMax = Math.max(left, right);
        
        return Math.max(ans, subtreeMax);
    }
}