class Solution {
    public Node connect(Node root) {
        if(root == null) return null;
        if(root.next != null && root.right != null) root.right.next = root.next.left;
        if(root.left != null) root.left.next = root.right;
        connect(root.left);
        connect(root.right);
        return root;
    }
}