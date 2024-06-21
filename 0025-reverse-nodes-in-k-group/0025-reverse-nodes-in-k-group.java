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
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null) return null;
        int length = findLength(head);
        return reverse(head, length, k);
    }
    
    private int findLength(ListNode head) {
        if(head == null) return 0;
        return 1 + findLength(head.next);
    }
    
    private ListNode reverse(ListNode head, int length, int k) {
        if(head == null)
            return head;
        
        ListNode curr = head, prev = null, next = null;
        int ck = k;
        while(curr != null && ck-- > 0) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        
        int remain = length - k;
        if(remain < k) {
            head.next = curr;
        } else {
            head.next = reverse(curr, remain, k);
        }
        
        return prev;
    }
}