class Solution {
    public Node connect(Node root) {
        if(root == null) return null;

        Node curr = root;
        Node dummyNode = new Node(-101);
        Node prev = dummyNode;

        while(curr != null) {
            if(curr.left != null) {
                prev.next = curr.left;
                prev = prev.next;
            }
            if(curr.right != null) {
                prev.next = curr.right;
                prev = prev.next;
            }
            curr = curr.next;
            if(curr == null) {
                curr = dummyNode.next;
                dummyNode.next = null;
                prev = dummyNode;
            }
        }

        return root;
    }
}