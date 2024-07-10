/*
    1. bottom up fashion traversal
*/

class Solution {
    public TreeNode removeLeafNodes(TreeNode root, int target) {
        if(root == null)
            return root;
        return removeLeafNodesUtil(root, target);
    }
    
    private TreeNode removeLeafNodesUtil(TreeNode root, int target) {
        if(root == null) return null;
        
        root.left = removeLeafNodesUtil(root.left, target);
        root.right = removeLeafNodesUtil(root.right, target);
        
        if(isLeaf(root) && root.val == target) {
            return null;
        }
        return root;
    }
    
    private boolean isLeaf(TreeNode root) {
        return root.left == null && root.right == null;
    }
}