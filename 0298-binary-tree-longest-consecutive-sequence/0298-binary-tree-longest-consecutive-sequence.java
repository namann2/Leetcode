class Solution {
    int maxLCS = 0;
    public int longestConsecutive(TreeNode root) {
        if(root == null) return 0;
        if(root.left == null && root.right == null) return 1;
        
        lcs(root);
        return maxLCS;
    }
    private int lcs(TreeNode root) {
        // base case
        if(root == null) return 0;
        if(root.left == null && root.right == null) return 1;
        
        // main logic -> bottom up manner
        int l = lcs(root.left);
        int r = lcs(root.right);
        
        if(root.left != null && root.val + 1 == root.left.val) {
            l++;
        } else l = 0; 
        
        if(root.right != null && root.val + 1 == root.right.val) {
            r++;
        } else r = 0;
        
        int currMax = Math.max(1, Math.max(l, r));
        maxLCS = Math.max(maxLCS, currMax);
        
        return currMax;
    }
}