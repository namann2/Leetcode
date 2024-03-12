class Solution {
    public ListNode removeZeroSumSublists(ListNode head) {
        // TC : in the worst case, we will traverse every node twice : O(2*n) : O(n)
        // SC : O(n)
        
        // this is same as subarray sum equals 0
        if(head == null)
            return null;
        Map<Integer, ListNode> map = new HashMap<>();
        // update a dummy head pointer because head also might get deleted
        ListNode dh = new ListNode(-1);
        map.put(0, dh);
        dh.next = head;
        // maintain a sum variable to calculate prefix sum
        int sum = 0;
        while(head != null) {
            sum += head.val;
            boolean contains = map.containsKey(sum);
            // if sum already found previously
            if(contains) {
                ListNode prev = map.get(sum);
                ListNode runner = prev;
                // todo : remove values of sum that contributed [prev, head)
                int temp_sum = sum;
                runner = runner.next;
                while(runner != head) {
                    temp_sum += runner.val;
                    map.remove(temp_sum);
                    runner = runner.next;
                }
                prev.next = head.next;
            } else map.put(sum, head);
            head = head.next;
        }
        return dh.next;
    }
}