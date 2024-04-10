```
class Solution {
public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
if(l1==null && l2==null) return null;
if(l1==null || l2==null) return l1==null ? l2 : l1;
ListNode dummy = new ListNode(-1);
ListNode newHead = dummy;
int carry = 0;
while(l1!=null || l2!=null) {
int sum = (l1==null ? 0 : l1.val) + (l2==null ? 0 : l2.val) + carry;
ListNode newNode = new ListNode(sum%10);
carry = sum/10;
dummy.next = newNode;
dummy = dummy.next;
if(l1!=null) l1 = l1.next;
if(l2!=null) l2 = l2.next;
}
if(carry!=0) {
dummy.next = new ListNode(carry);
}
return newHead.next;
}
}
```