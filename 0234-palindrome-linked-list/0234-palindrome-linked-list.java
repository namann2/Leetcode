class Solution {
    ListNode left;
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null) return true;
        left = head;
        return isPalindromeHelper(head);
    }
    private boolean isPalindromeHelper(ListNode right) {
        // base case
        if(right == null) return true;
        
        boolean isPalin = isPalindromeHelper(right.next);
        
        if(!isPalin) return false;
        
        if(left.val != right.val) return false;
        left = left.next;
        return true;
    }
}