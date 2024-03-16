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
    public String gameResult(ListNode head) {
        int odd = 0, even = 0;
        while(head != null) {
            int cur1 = head.val;
            int cur2 = head.next.val;
            if(cur1 % 2 == 0) {
                if(cur1 > cur2) even++;
                else odd++;
            } else {
                if(cur1 > cur2) odd++;
                else even++;
            } 
            head = head.next.next;
        }
        return odd == even ? "Tie" : (odd > even ? "Odd" : "Even");
    }
}