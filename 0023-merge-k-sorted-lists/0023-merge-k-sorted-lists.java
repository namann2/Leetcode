class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0) return null;
        int n = lists.length;
        return merge(lists, 0, n-1);
    }
    
    private ListNode merge(ListNode[] lists, int left, int right) {
        if(left == right) {
            return lists[left];
        }
        int mid = left + (right - left) / 2;
        ListNode a = merge(lists, left, mid);
        ListNode b = merge(lists, mid+1, right);
        return mergeHalves(a, b);
    }
    
    private ListNode mergeHalves(ListNode a, ListNode b) {
        if(a == null && b == null) return null;
        if(a == null || b == null) return a == null ? b : a;
        
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