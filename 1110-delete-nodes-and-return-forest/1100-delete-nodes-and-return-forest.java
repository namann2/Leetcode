class Solution {
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        /*
            Points to remember :
            1. Why we need to do post order traversal ? i.e. bottom to up
                consider a tree
                [1,2,null,4,3]
                [2,3]
                
                We want to delete the deepest tree nodes so that we are sure that it is not left out.
            2. Keep a check for the root node.
        */
        List<TreeNode> result = new ArrayList<>();
        Set<Integer> delete = new HashSet<>();
        for(int node : to_delete) delete.add(node);
        traverse(root, result, delete);
        if(!delete.contains(root.val))
            result.add(root);
        return result;
    }
    private TreeNode traverse(TreeNode root, List<TreeNode> result, Set<Integer> delete) {
        if(root == null) return null;
        root.left = traverse(root.left, result, delete);
        root.right = traverse(root.right, result, delete);
        if(delete.contains(root.val)) {
            if(root.left != null) result.add(root.left);
            if(root.right != null) result.add(root.right);
            return null;
        }
        return root;
    }
}
