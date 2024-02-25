class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null) return null;
        if(key < root.val) {
            root.left = deleteNode(root.left, key);
        } else if(key > root.val) {
            root.right = deleteNode(root.right, key);
        } else {
            // case a : leaf node or node with no child
            if(root.left == null && root.right == null) return null;
            // case b : 
            else if(root.left != null && root.right != null) {
                // find max value in the left subtree of this node
                TreeNode leftMax = findMax(root.left);
                root.val = leftMax.val;
                root.left = deleteNode(root.left, leftMax.val);
            } else if(root.left == null) {
                return root.right;
            } else if(root.right == null) {
                return root.left;
            } 
        }
        return root;
    }
    private TreeNode findMax(TreeNode root) {
        while(root.right != null) root = root.right;
        return root;
    }
}