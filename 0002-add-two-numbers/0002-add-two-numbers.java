class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode dH = new ListNode(-1);
        ListNode head = dH;
        while(l1 != null || l2 != null) {
            int sum = (l1 != null ? l1.val : 0) + (l2 != null ? l2.val : 0);
            sum += carry;
            // 14
            carry = sum / 10;
            sum %= 10;
            ListNode newNode = new ListNode(sum);
            dH.next = newNode;
            dH = dH.next;
            if(l1 != null) l1 = l1.next;
            if(l2 != null) l2 = l2.next;
        }
        
        if(carry != 0)
            dH.next = new ListNode(carry);
        
        return head.next;
    }
}