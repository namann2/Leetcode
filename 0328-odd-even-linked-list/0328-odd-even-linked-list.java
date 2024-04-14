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
    public ListNode oddEvenList(ListNode head) {
        if(head == null) return null;
        ListNode first = new ListNode(-1), second = new ListNode(-1), temp = head;
        ListNode fh = first, sh = second;
        //     p t
        // 1 2 3 4
        // -1 1 3
        //       f
        // -1 2 4
        //        s
        while(temp != null) {
            first.next = temp;
            first = first.next;
            ListNode ptr = temp.next;
            temp.next = null;
            second.next = ptr;
            second = second.next;
            if(ptr == null) break;
            temp = ptr.next;
            ptr.next = null;
        }
        
        temp = fh.next;
        while(temp.next != null) temp = temp.next;
        temp.next = sh.next;
        return fh.next;
    }
}