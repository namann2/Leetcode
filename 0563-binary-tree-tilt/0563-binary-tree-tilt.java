class Solution {
    public int findTilt(TreeNode root) {
        if(root == null) return 0;
        // Every node will return [tilt, summation of all nodes in curr subtree]
        return findTilt2(root)[0];
    }

    private int[] findTilt2(TreeNode root) {
        // base case
        if(root == null) 
            return new int[]{0, 0};
        // leaf node
        if(root.left == null && root.right == null) {
            return new int[]{0, root.val};
        }
        // main logic
        int[] left = findTilt2(root.left);
        int[] right = findTilt2(root.right);

        int leftSubtreeTilt = left[0], rightSubtreeTilt = right[0];
        int currTilt = Math.abs(left[1] - right[1]);
        
        int overallTilt = leftSubtreeTilt + rightSubtreeTilt + currTilt;

        return new int[]{overallTilt, root.val + left[1] + right[1]};
    }
}