class Solution {
    public TreeNode invertTree(TreeNode root) {
        if(root == null) return null;

        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);

        TreeNode temp = left;
        root.left = right;
        root.right = temp;

        return root;   
    }
}