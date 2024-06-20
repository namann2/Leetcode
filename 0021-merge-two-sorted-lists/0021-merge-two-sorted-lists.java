class Solution {
    public ListNode mergeTwoLists(ListNode a, ListNode b) {
        if(a == null) return b;
        if(b == null) return a;
        
        ListNode result = null;
        if(a.val < b.val) {
            result = a;
            result.next = mergeTwoLists(a.next, b);
        } else {
            result = b;
            result.next = mergeTwoLists(a, b.next);
        }
        return result;
    }
}