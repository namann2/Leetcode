class Solution {
    public ListNode removeNodes(ListNode head) {
        Deque<ListNode> stack = new ArrayDeque<>();
        ListNode curr = head;
        // [5,2,13,3,8]
        // 13 8
        while(curr != null) {
            while(!stack.isEmpty() && stack.peekLast().val < curr.val) stack.removeLast();
            stack.addLast(curr);
            curr = curr.next;
        }
        
        ListNode nHead = new ListNode(-1);
        ListNode temp = nHead;
        while(!stack.isEmpty()) {
            curr = stack.removeFirst();
            nHead.next = curr;
            nHead = nHead.next;
        }
        return temp.next;
    }
}