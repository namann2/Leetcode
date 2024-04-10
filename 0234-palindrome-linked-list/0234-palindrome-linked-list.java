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
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null) return true;
        
        // In linkedlist questions, it is better to ask for -> whether we can update the links of the LL
        
        // Iterative Approach : 
        // 1. Find middle
        // 2. detach and reverse second half
        // 3. check both the halfs
        
        ListNode middle = getMiddleOfLinkedList(head);
        ListNode nextHalfHead = middle.next;
        middle.next = null;
        nextHalfHead = reverse(nextHalfHead);
        
        while(head != null && nextHalfHead != null) { 
            if(head.val != nextHalfHead.val) return false;
            head = head.next;
            nextHalfHead = nextHalfHead.next;
        }
        return true;
    }
    private ListNode reverse(ListNode head) {
        // there are two techniques to solve this. -> iterative and other is recursive
        ListNode curr = head, prev = null, next = null;
        while(curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
    private ListNode getMiddleOfLinkedList(ListNode head) {
        ListNode slow = head, fast = head;
        while(fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}