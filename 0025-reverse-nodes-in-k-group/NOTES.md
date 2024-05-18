```
​
​
class Solution {
public ListNode reverseKGroup(ListNode head, int k) {
if(head == null || head.next == null) return head;
int length = findLength(head);
return reverseKGroup(head, k, length);
}
public ListNode reverseKGroup(ListNode head, int k, int length) {
if(head == null || head.next == null) return head;
ListNode curr = head;
ListNode prev = null;
ListNode next = null;
int count = 0;
while(curr!=null && count < k) {
next = curr.next;
curr.next = prev;
prev = curr;
curr = next;
count++;
}
// if we want to reverse only k groups