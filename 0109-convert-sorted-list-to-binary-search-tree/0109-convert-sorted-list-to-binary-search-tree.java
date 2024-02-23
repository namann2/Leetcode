class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        // TC : O(N)
        // SC : O(log N) [ recursive calls ] + [if we consider space for BST] O(N)
        return construct(head);
    }
    private TreeNode construct(ListNode head) {
        if(head == null) return null;
        if(head.next == null) return new TreeNode(head.val);
        
        ListNode middle = findMiddle(head);
        TreeNode newRoot = new TreeNode(middle.val);
        newRoot.left = construct(head);
        newRoot.right = construct(middle.next);
        return newRoot;
    }
    private ListNode findMiddle(ListNode head) {
        ListNode prev = null, slow = head, fast = head;
        while(fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        if(prev != null) 
            prev.next = null;
        return slow;
    }
}