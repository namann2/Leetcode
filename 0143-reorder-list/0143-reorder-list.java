class Solution {
    public void reorderList(ListNode head) {
        ListNode slow = head, fast = head;
        while(fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode middle = slow;
        ListNode middleNext = middle.next;
        middle.next = null;
        
        middleNext = reverse(middleNext, middleNext);
        merge(head, middleNext);
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
    private void merge(ListNode a, ListNode b) {
        while(b != null) {
            ListNode temp = a.next;
            a.next = b;
            a = temp;
            
            temp = b.next;
            b.next = a;
            b = temp;
        }
        if(b != null) {
            while(a.next != null) a = a.next;
            a.next = b;
        }
    }
}