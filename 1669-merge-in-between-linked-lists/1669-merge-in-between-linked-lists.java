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
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode dh = new ListNode(-1);
        dh.next = list1;
        ListNode temp = dh;
        ListNode ptr1 = null, ptr2 = null;
        while(temp.next != null) {
            if(a == 0) ptr1 = temp;
            if(b == 0) {
                ptr2 = temp.next.next;
                break;
            }
            temp = temp.next;
            a--;
            b--;
        }
        ptr1.next = list2;
        while(list2.next != null) list2 = list2.next;
        list2.next = ptr2;
        return dh.next;
    }
}