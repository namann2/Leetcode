class Solution {
    public Node connect(Node root) {
        if(root == null || isLeaf(root)) return root;
        
        if(root.next != null) root.right.next = root.next.left;
        root.left.next = root.right;
        
        connect(root.right);
        connect(root.left);
        return root;
    }
    private boolean isLeaf(Node root) {
        return root.left == null && root.right == null;
    }
}