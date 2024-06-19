class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode smaller = new ListNode(-1);
        ListNode greaterEqual = new ListNode(-1);
        ListNode sH = smaller, gH = greaterEqual, next = null;
        
        while(head != null) {
            if(head.val < x) {
                smaller.next = head;
                smaller = smaller.next;
            } else {
                greaterEqual.next = head;
                greaterEqual = greaterEqual.next;
            }
            head = head.next;
        }
        
        greaterEqual.next = null;
        smaller.next = gH.next;
        return sH.next;
    }
}