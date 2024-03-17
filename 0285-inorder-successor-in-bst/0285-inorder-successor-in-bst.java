class Solution {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        /*
        TreeNode ptr = p.right;
        if(ptr != null) {
            while(ptr.left != null) ptr = ptr.left;
            return ptr;
        }

        TreeNode prev = null;
        while(root != p) {
            if(p.val > root.val) root = root.right;
            else if(p.val < root.val) {
                prev = root;
                root = root.left;
            }
        }
        return prev;
        */
    
        // All Nodes will have unique values
        TreeNode succ = null;
        while(root != null) {
            if(p.val < root.val) {
                succ = root;
                root = root.left;
            } else root = root.right;
        }
        return succ;
    }
}