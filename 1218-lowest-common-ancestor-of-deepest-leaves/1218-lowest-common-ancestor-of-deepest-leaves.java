class Solution {
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        if(root == null) return null;
        int height = getHeight(root);
        return LCA(root, height);
    }

    private int getHeight(TreeNode root) {
        if(root == null) return 0;
        int left = getHeight(root.left);
        int right = getHeight(root.right);
        return 1 + Math.max(left, right);
    }

    private TreeNode LCA(TreeNode root, int height) {
        if(root == null) return null;
        if(height == 1) return root;
        
        TreeNode left = LCA(root.left, height - 1);
        TreeNode right = LCA(root.right , height - 1);
        
        if(left != null && right != null) return root;
        return left == null ? right : left;
    } 
}