class Solution {
    public ListNode removeNodes(ListNode head) {
        if(head == null) return null;
        return reverse(head);
    }
    private ListNode reverse(ListNode head) {
        if(head.next == null) return head;
        ListNode get = reverse(head.next);
        
        if(head.val < get.val) {
            return get;
        }
        head.next = get;
        return head;
    }
}