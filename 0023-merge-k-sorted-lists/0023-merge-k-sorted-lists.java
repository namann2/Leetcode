class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        // consider every list as an element in an array for a merge sort
        if(lists == null || lists.length == 0) return null;
        return mergeSort(lists, 0, lists.length - 1); // n log k
    }
    private ListNode mergeSort(ListNode[] lists, int leftStart, int rightEnd) {
        if(leftStart == rightEnd) return lists[leftStart];
        
        int mid = leftStart + (rightEnd - leftStart) / 2;
        
        ListNode a = mergeSort(lists, leftStart, mid);
        ListNode b = mergeSort(lists, mid + 1, rightEnd);
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