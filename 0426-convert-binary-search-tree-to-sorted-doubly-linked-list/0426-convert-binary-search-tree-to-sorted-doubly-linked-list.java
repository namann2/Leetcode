class Solution {
    public Node treeToDoublyList(Node root) {
        if(root == null) return null;
        Node prev = null, curr = root, head = null;
        Stack<Node> stack = new Stack<>();
        
        while(!stack.isEmpty() || curr != null) {
            while(curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            
            curr = stack.pop();
            if(prev == null) {
                prev = curr;
                head = curr;
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