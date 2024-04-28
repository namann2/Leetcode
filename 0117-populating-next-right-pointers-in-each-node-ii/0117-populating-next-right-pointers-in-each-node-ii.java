class Solution {
    public Node connect(Node root) {
        if(root == null || isLeaf(root)) return root;
        
        if(root.right != null) root.right.next = findNext(root.next);
        if(root.left != null) root.left.next = root.right != null ? root.right : findNext(root.next);
        
        connect(root.right);
        connect(root.left);
        
        return root;
    }
    
    private Node findNext(Node root) {
        if(root == null) return null;
        if(root.left != null) return root.left;
        if(root.right != null) return root.right;
        return findNext(root.next);
    }
    private boolean isLeaf(Node root) {
        return root.left == null && root.right == null;
    }
}