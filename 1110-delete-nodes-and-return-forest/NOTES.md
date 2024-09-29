Points to remember :
1. Why we need to do post order traversal ? consider a tree
[1,2,null,4,3]
[2,3]
We want to delete the deepest tree nodes so that we are sure that it is not left out.
2. Keep a check for the root node.

```

class Solution {
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        List<TreeNode> forestNodes = new ArrayList<>();
        if(root == null) return forestNodes;
        
        Set<Integer> toDelete = new HashSet<>();
        // add all the nodes that we need to remove to a set :: for better lookup
        for(int nodeToDelete : to_delete) toDelete.add(nodeToDelete);
        // iterate the tree in bottom-up fashion to delete the nodes
        traverse(root, toDelete, forestNodes);
        // if root nodes is not the part of nodesToDelete, add it to the forest
        if(!toDelete.contains(root.val)) forestNodes.add(root);
        return forestNodes;
    }
    
    private TreeNode traverse(TreeNode root, Set<Integer> nodesToDelete, List<TreeNode> forestNodes) {
        // base case
        if(root == null) return null;
        // main logic
        root.left = traverse(root.left, nodesToDelete, forestNodes);
        root.right = traverse(root.right, nodesToDelete, forestNodes);
        
        if(nodesToDelete.contains(root.val)) {
            if(root.left != null) forestNodes.add(root.left);
            if(root.right != null) forestNodes.add(root.right);
            return null;
        }
        return root;
    }
}

```
