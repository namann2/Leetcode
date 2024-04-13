class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null) return null;
        ListNode temp = head;
        
        while(n-- > 0) temp = temp.next;
        
        if(temp == null) return head.next;
        
        ListNode curr = head;
        while(temp.next != null) {
            temp = temp.next;
            curr = curr.next;
        }
        curr.next = curr.next.next;
        return head;
    }
}