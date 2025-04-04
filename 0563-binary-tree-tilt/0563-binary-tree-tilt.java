class Solution {
    public int findTilt(TreeNode root) {
        int tilt[] = {0};
        if(root == null) return 0;
        findTiltHelper(root, tilt);
        return tilt[0];
    }

    private int findTiltHelper(TreeNode root, int[] tilt) {
        // base case
        if(root == null) return 0;
        if(root.left == null && root.right == null) return root.val;

        // main logic
        int left = findTiltHelper(root.left, tilt);
        int right = findTiltHelper(root.right, tilt);

        tilt[0] += Math.abs(left - right);
        return root.val + left + right;
    }
}