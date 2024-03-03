class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode temp = head;
        while(n > 0) {
            temp = temp.next;
            n--;
        }
        if(temp == null) 
            return head.next;
        ListNode curr = head;
        while(temp.next != null) {
            curr = curr.next;
            temp = temp.next;
        }
        curr.next = curr.next.next;
        return head;
    }
}
