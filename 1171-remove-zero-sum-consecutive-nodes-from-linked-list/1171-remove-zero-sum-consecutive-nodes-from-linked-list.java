class Solution {
    public ListNode removeZeroSumSublists(ListNode head) {
        Map<Integer, ListNode> map = new HashMap<>();
        ListNode dH = new ListNode(-1);
        map.put(0, dH);
        dH.next = head;
        int sum = 0;
        
        while(head != null) {
            sum += head.val;
            boolean contains = map.containsKey(sum);
            
            if(contains) {
                ListNode prev = map.get(sum), temp = prev.next;
                prev.next = head.next;
                int temp_sum = sum;
                while(temp != head) {
                    temp_sum += temp.val;
                    map.remove(temp_sum);
                    temp = temp.next;
                }
            } else {
                map.put(sum, head);
            }
            head = head.next;
        }
        return dH.next;
    }
}