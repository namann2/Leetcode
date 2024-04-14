/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

class Solution {
    public Node flatten(Node head) {
        if(head == null) return null;
        
        Node dh = new Node(-1, null, head, null);
        Deque<Node> stack = new ArrayDeque<>();
        stack.push(head);
        
        Node prev = dh, curr = null;
        
        while(!stack.isEmpty()) {
            curr = stack.removeLast();
            prev.next = curr;
            curr.prev = prev;
            
            if(curr.next != null) stack.addLast(curr.next);
            if(curr.child != null) {
                stack.addLast(curr.child);
                curr.child = null;
            }
            prev = curr;
        }
        dh.next.prev = null;
        return dh.next;
    }
}