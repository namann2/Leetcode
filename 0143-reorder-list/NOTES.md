public ListNode reorderList(ListNode root, ListNode curr) {
if (curr == null) return root;
​
// keep on passing the intial root to the end
root = reorderList(root, curr.next);
​
if (root == null) return null;
//          * we stop reconfiguring in 2 cases.
//          *   1. returned new root is same as head: Odd number of list
//                 items so we have come to the middle
//          *   2. returned new root's next is same as head: Even number of list items
ListNode temp = null;
if (root == curr || root.next == curr) {
curr.next = null;
} else {
// make returned root's next to be curr and return root's next as the new root
temp = root.next;
root.next = curr;
curr.next = temp;
}
return temp;
}
}
``
​