class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null) return head;
        int length = findLength(head);
        return reverseKGroupUtil(head, length, k);
    }
    
    // helper
    private ListNode reverseKGroupUtil(ListNode head, int length, int k) {
        if(head == null) return head;
        
        int ck = k;
        ListNode curr = head, prev = null, next = null;
        while(curr != null && ck-- > 0) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        
        int remainingLength = length - k;
        if(remainingLength >= k)
            head.next = reverseKGroupUtil(curr, remainingLength, k);
        else head.next = curr;
        
        return prev;
    }
    
    // find length of the linkedlist
    private int findLength(ListNode head) {
        if(head == null) return 0;
        return 1 + findLength(head.next);
    }
    
}