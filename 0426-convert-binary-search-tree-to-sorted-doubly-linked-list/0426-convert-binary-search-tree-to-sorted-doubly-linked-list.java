/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};
*/

class Solution {
    // TODO : do this using morris-traversal
    public Node treeToDoublyList(Node root) {
        if(root == null) return null;
        Node head = null, prev = null, curr = root;
        Stack<Node> stack = new Stack<>();
        while(curr != null || !stack.isEmpty()) {
            while(curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            if(prev == null) {
                prev = curr;
                head = prev;
            } else {
                curr.left = prev;
                prev.right = curr;
                prev = curr;
            }
            curr = curr.right;
        }
        // update the pointer of current head
        head.left = prev;
        prev.right = head;
        return head;
    }
}