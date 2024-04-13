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
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null)
            return head;
        
        ListNode middle = findMiddle(head);
        ListNode middleNext = middle.next;
        middle.next = null;
        
        ListNode a = sortList(head);
        ListNode b = sortList(middleNext);
        
        return mergeHalves(a, b);
    }
    private ListNode findMiddle(ListNode head) {
        ListNode slow = head, fast = head;
        while(fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    private ListNode mergeHalves(ListNode a, ListNode b) {
        if(a == null && b == null) return null;
        if(a == null || b == null) return a == null ? b : a;
        
        ListNode result = null;
        if(a.val <= b.val) {
            result = a;
            result.next = mergeHalves(a.next, b);
        } else {
            result = b;
            result.next = mergeHalves(a, b.next);
        }
        return result;
    }
}