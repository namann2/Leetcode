class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null) return null;
        
        // move currentNode n steps ahead in the list
        ListNode currentNode = head;
        for(int i=0;i<n;i++)
            currentNode = currentNode.next;
        
        // head is the node to be removed
        if(currentNode == null) {
            return head.next;
        }
        
        // maintain the gap of n nodes between the two pointers so as to connect them
        ListNode nodeBeforeNodeToRemove = head;
        
        // reach the last node while doing the above operation
        while(currentNode.next != null) {
            currentNode = currentNode.next;
            nodeBeforeNodeToRemove = nodeBeforeNodeToRemove.next;
        }
        
        nodeBeforeNodeToRemove.next = nodeBeforeNodeToRemove.next.next;
        
        return head;
    }
}