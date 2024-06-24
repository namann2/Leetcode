class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null) return head;
        int length = findLength(head);
        // effective length
        length -= n;
        
        if(length == 0) return head.next;
        
        ListNode itr = head;
        while(itr != null && --length > 0) {
            itr = itr.next;
        }
        
        itr.next = itr.next.next;
        return head;
    }
    private int findLength(ListNode head) {
        if(head == null) return 0;
        return 1 + findLength(head.next);
    }
}