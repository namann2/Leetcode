class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        /*
            For a given array, we can create multiple BST's but since we have to 
            find heigh-balanced BST, we will be limited in some way to pick such an index
            that yeilds a height balanced BST.
            To create a height balanced BST, we will make the middle element as the root of
            the binary tree
        */
        int n = nums.length;
        return construct(nums, 0, n-1);
    }
    private TreeNode construct(int[] nums, int start, int end) {
        if(start > end) return null;
        int index = (start + end) / 2;
        TreeNode newRoot = new TreeNode(nums[index]);
        newRoot.left = construct(nums, start, index-1);
        newRoot.right = construct(nums, index+1, end);
        return newRoot;
    }
}