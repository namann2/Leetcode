class Solution {
    public void recoverTree(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        TreeNode prev = null, first = null, second = null;
        while(curr != null || !stack.isEmpty()) {
            while(curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            if(prev != null) {
                if(curr.val < prev.val && first == null) first = prev;
                if(curr.val < prev.val && first != null) second = curr;
            }
            prev = curr;
            curr = curr.right;
        }
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }
}