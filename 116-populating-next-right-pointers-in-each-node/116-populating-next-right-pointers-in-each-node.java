class Solution {
    // number of leaf nodes in perfect binary tree -> N+1 / 2
    // TC : O(N)
    // SC : O(1) - not considering the implicit stack
    public Node connect(Node root) {
        if(root == null) return null;
        // leaf nodes do not have children, hence return
        if(root.left == null && root.right == null) return root;
        
        // 1. update right and then left links for the children of current node
        root.right.next = root.next == null ? null : root.next.left;
        root.left.next = root.right;
        
        connect(root.right);
        connect(root.left);
        
        return root;
    }
}