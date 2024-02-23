class Solution {
    public int getMinimumDifference(TreeNode root) {
        TreeNode curr = root, prev = null;
        Stack<TreeNode> stack = new Stack<>();
        int ans = Integer.MAX_VALUE;
        while(curr != null || !stack.isEmpty()) {
            while(curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            if(prev != null) ans = Math.min(ans, curr.val - prev.val);
            prev = curr;
            curr = curr.right;
        }
        return ans;
    }
}