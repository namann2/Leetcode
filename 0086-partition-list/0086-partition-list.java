class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode smaller = new ListNode(-1);
        ListNode greaterEqual = new ListNode(-1);
        ListNode sH = smaller, gH = greaterEqual;
        
        while(head != null) {
            if(head.val < x) {
                smaller.next = head;
                smaller = smaller.next;
                ListNode next = head.next;
                head.next = null;
                head = next;
            } else {
                greaterEqual.next = head;
                greaterEqual = greaterEqual.next;
                ListNode next = greaterEqual.next;
                head.next = null;
                head = next;
            }
        }
        
        smaller.next = gH.next;
        return sH.next;
    }
}