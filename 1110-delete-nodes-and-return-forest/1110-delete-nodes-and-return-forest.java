class Solution {
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        // we need to update the links, hence postorder traversal
        List<TreeNode> forest = new ArrayList<>();
        
        // check if current node is to be deleted or not, hence set provides O(1) lookup
        Set<Integer> values = new HashSet<>();
        for(int node : to_delete)
            values.add(node);
        
        // is root to be added ?
        if(!values.contains(root.val))
            forest.add(root);
        
        postOrder(root, values, forest);
        return forest;
    }
    
    private TreeNode postOrder(TreeNode root, Set<Integer> set, List<TreeNode> forest) {
        if(root == null)
            return root;
        
        root.left = postOrder(root.left, set, forest);
        root.right = postOrder(root.right, set, forest);
        
        // add the children sub roots if they exist for the node which is to be deleted
        if(set.contains(root.val)) {
            if(root.left != null) forest.add(root.left);
            if(root.right != null) forest.add(root.right);
            return null;
        }
        return root;
    }
}