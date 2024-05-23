class Solution {
    public Node treeToDoublyList(Node root) {
        if(root == null) 
            return null;
        Deque<Node> stack = new ArrayDeque<>();
        Node curr = root;
        Node head = null, prev = null;
        
        while(!stack.isEmpty() || curr != null) {
            while(curr != null) {
                stack.addLast(curr);
                curr = curr.left;
            }
            curr = stack.removeLast();
            if(prev == null) {
                head = curr;
                prev = curr;
            } else {
                prev.right = curr;
                curr.left = prev;
                prev = curr;
            }
            curr = curr.right;
        }
        prev.right = head;
        head.left = prev;
        
        return head;
    }
}