## Recursive Approach :
​
Drawback : Using the global variable.
In the recursive approach, we will have to use a global variable, which is not a good approach
​
```
class Solution {
ListNode left = null;
public boolean isPalindrome(ListNode head) {
if(head == null || head.next == null) return true;
left = head;
return isPalindromeUtil(head);
}
private boolean isPalindromeUtil(ListNode right) {
if(right == null) return true;
boolean isPalindrome = isPalindromeUtil(right.next);
if(!isPalindrome) return false;
if(left.val != right.val) return false;
left = left.next;
return true;
}
}
```
​
## Iterative Approach :
​
​