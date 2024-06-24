class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null) return head;
        ListNode B = head;
        
        while(--n >= 0) {
            B = B.next;
        }
        
        if(B == null) return head.next;
        
        ListNode A = head;
        while(B.next != null) {
            A = A.next;
            B = B.next;
        }
        
        A.next = A.next.next;
        return head;
    }
}