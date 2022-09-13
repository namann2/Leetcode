class Solution {
    public int rangeSumBST(TreeNode root, int low, int high) {
        // TC : O(N) - In the worst case, we need to traverse complete tree
        if(root == null)
            return 0;
        
        if(root.val < low) 
            return rangeSumBST(root.right, low, high);
        
        if(root.val > high)
            return rangeSumBST(root.left, low, high);
            
        return root.val + rangeSumBST(root.left, low, high) + rangeSumBST(root.right, low, high);
    }
}