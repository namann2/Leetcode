class Solution {
    public ListNode swapPairs(ListNode head) {
        if(head == null) return null;
        int length = findLength(head);
        return swap(head, length, 2);
    }
    
    private int findLength(ListNode head) {
        if(head == null) return 0;
        return 1 + findLength(head.next);
    }
    
    private ListNode swap(ListNode head, int length, int k) {
        if(head == null)
            return head;
        
        ListNode curr = head, prev = null, next = null;
        int ck = k;
        while(curr != null && ck-- > 0) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        
        int remain = length - k;
        if(remain < k) {
            head.next = curr;
        } else {
            head.next = swap(curr, remain, k);
        }
        
        return prev;
    }
}