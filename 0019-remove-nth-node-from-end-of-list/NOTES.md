### Approch 1:
​
```
class Solution {
public ListNode removeNthFromEnd(ListNode head, int n) {
int length = findLinkedListLength(head);
int rem = length - n;
if(rem == 0)
return head.next;
ListNode curr = head;
while(curr != null && --rem > 0) {
curr = curr.next;
}
curr.next = curr.next.next;
return head;
}
private int findLinkedListLength(ListNode head) {
if(head == null) return 0;
return 1 + findLinkedListLength(head.next);
}
}
​
```
return head.next;