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
    public int pairSum(ListNode head) {
        ListNode slow = head, fast = head;
        while(fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        fast = reverse(head, slow.next);
        slow.next = null;
        int maxTwinSum = 0;
        while(head != null) {
            maxTwinSum = Math.max(maxTwinSum, head.val + fast.val);
            head = head.next;
            fast = fast.next;
        }
        return maxTwinSum;
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