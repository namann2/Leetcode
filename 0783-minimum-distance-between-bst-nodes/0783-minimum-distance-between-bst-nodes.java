class Solution {
    public int minDiffInBST(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root, prev = null;
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