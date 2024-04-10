class Solution {
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null) return head;
        return reverse(head, head);
    }
    private ListNode reverse(ListNode head, ListNode node) {
        if(node == null || node.next == null) {
            head = node;
            return head;
        }
        
        ListNode get = reverse(head, node.next);
        node.next.next = node;
        node.next = null;
        return get;
    }
}