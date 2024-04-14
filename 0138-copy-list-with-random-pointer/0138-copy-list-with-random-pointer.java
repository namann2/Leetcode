/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if(head == null) return head;
        
        Node temp = head;
        while(temp != null) {
            Node next = temp.next;
            Node newNode = new Node(temp.val);
            newNode.next = temp.next;
            temp.next = newNode;
            temp = next;
        }
        
        temp = head;
        while(temp != null) {
            if(temp.random != null) {
                temp.next.random = temp.random.next;
            }
            temp = temp.next.next;
        }
        
        Node newHead = null;
        temp = head;
        while(temp != null) {
            Node onext = temp.next.next;
            if(newHead == null) newHead = temp.next;
            if(onext != null) temp.next.next = onext.next;
            temp.next = onext;
            temp = onext;
        }
        return newHead;
    }
}