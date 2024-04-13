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
        int length = findLengthOfLinkedList(head);
        return swaps(head, k, length);
    }
    private ListNode swaps(ListNode node, int k, int length) {
        if(node == null || node.next == null) 
            return node;
        
        ListNode prev = null, curr = node, next = null;
        int ck = k;
        while(curr != null && ck-- > 0) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        if(length - k >= k) node.next = swaps(curr, k, length - k);  
        else node.next = curr;
        return prev;
    }
    private int findLengthOfLinkedList(ListNode node) {
        if(node == null) return 0;
        return 1 + findLengthOfLinkedList(node.next);
    }
}