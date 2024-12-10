class Solution {
    public void flatten(TreeNode root) {
        if(root == null) return;
        TreeNode curr = root;
        while(curr != null) {
            if(curr.left != null) {
                TreeNode runner = curr.left;
                TreeNode currRight = curr.right;
                curr.right = curr.left;
                curr.left = null;
                while(runner.right != null)
                    runner = runner.right;
                runner.right = currRight;
            }
            curr = curr.right;
        }
    }
}