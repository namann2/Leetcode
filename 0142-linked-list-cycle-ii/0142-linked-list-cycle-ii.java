public class Solution {
    public ListNode detectCycle(ListNode head) {
        // step 1 : detect cycle
        ListNode slow = head, fast = head;
        boolean cycle = false;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) {
                cycle = true;
                break;
            }
        }
        
        if(!cycle) return null;
        
        ListNode temp = head;
        while(temp != fast) {
            temp = temp.next;
            fast = fast.next;
        }
        return temp;
    }
}