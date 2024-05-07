/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode doubleIt(ListNode head) {
        ListNode rHead = reverse(head, head);
        // print(rHead);
        ListNode newHead = operate(rHead);
        return reverse(newHead, newHead);
    }
    private ListNode reverse(ListNode head, ListNode node) {
        if(node == null || node.next == null) {
            head = node;
            return node;
        }
        
        ListNode get = reverse(head, node.next);
        node.next.next = node;
        node.next = null;
        return get;
    }
    private ListNode operate(ListNode head) {
        int carry = 0;
        ListNode prev = null, temp = head;
        while(head != null) {
            int curr = head.val * 2 + carry;
            head.val = curr % 10;
            carry = curr / 10;
            prev = head;
            head = head.next;
        }
        if(carry != 0) {
            prev.next = new ListNode(carry);
        }
        return temp;
    }
}