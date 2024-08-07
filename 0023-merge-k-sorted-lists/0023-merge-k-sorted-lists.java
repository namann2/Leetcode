class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0) return null;
        return mergeSort(lists, 0, lists.length - 1);
    }
    
    private ListNode mergeSort(ListNode[] lists, int leftStart, int rightEnd) {
        if(leftStart >= rightEnd) 
            return lists[leftStart];
        
        int mid = leftStart + (rightEnd - leftStart) / 2;
        ListNode a = mergeSort(lists, leftStart, mid);
        ListNode b = mergeSort(lists, mid + 1, rightEnd);
        return mergeHalves(a, b);
    }
    
    private ListNode mergeHalves(ListNode a, ListNode b) {
        if(a == null) return b;
        if(b == null) return a;
        
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