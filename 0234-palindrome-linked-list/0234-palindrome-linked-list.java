class Solution {
    ListNode left;
    public boolean isPalindrome(ListNode node) {
        if(node == null)
            return true;
        left = node;
        return isPalindromeUtil(node);
    }
    private boolean isPalindromeUtil(ListNode right) {
        if(right == null)
            return true;
        
        boolean isPalindrome = isPalindromeUtil(right.next);
        
        if(!isPalindrome)
            return false;
        
        if(left.val != right.val) 
            return false;
        
        left = left.next;
        
        return true;
    }
}




























