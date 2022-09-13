class Solution {
    // TC : N log k, where N is the length of linkedlist and K is the number of lists
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0) return null;
        return merge(lists, 0, lists.length-1);
    }
    private ListNode merge(ListNode[] lists, int start, int end) {
        // base case
        if(start >= end) return lists[start];
        // main logic
        int mid = start + (end - start) / 2;
        ListNode a = merge(lists, start, mid);
        ListNode b = merge(lists, mid + 1, end);
        return mergeHalves(a, b);
    }
    private ListNode mergeHalves(ListNode a, ListNode b) {
        if(a==null) return b;
        if(b==null) return a;
        
        ListNode result = null;
        if(a.val <= b.val) {
            result = a;
            result.next = mergeHalves(a.next, b);
        } else {
            result = b;
            result.next = mergeHalves(a, b.next);
        }
        return result;
    }
}