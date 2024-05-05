/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void deleteNode(ListNode node) {
        ListNode prev = node;
        while(node.next != null) {
            int tmp = node.val;
            node.val = node.next.val;
            node.next.val = tmp;
            prev = node;
            node = node.next;
        }
        prev.next = null;
    }
}