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
    public ListNode plusOne(ListNode head) {
        if(head == null) return null;
        int carry = addOneHelper(head);
        if(carry != 0) {
            ListNode node = new ListNode(carry);
            node.next = head;
            head = node;
        }
        return head;
    }
    private int addOneHelper(ListNode node) {
        if(node == null) return 1;
        int carry = addOneHelper(node.next);
        int sum = node.val + carry;
        node.val = sum % 10;
        return sum / 10;
    }
}