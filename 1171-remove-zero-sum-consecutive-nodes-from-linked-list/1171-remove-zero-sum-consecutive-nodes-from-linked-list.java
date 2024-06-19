class Solution {
    public ListNode removeZeroSumSublists(ListNode head) {
        Map<Integer, ListNode> map = new HashMap<>();
        ListNode dH = new ListNode(0);
        ListNode tempHead = dH;
        dH.next = head;
        // 1 2 -2 -1 0 0 5
        // 
        map.put(0, dH);
        int sum = 0;
        while(head != null) {
            sum += head.val;
            if(map.containsKey(sum)) {
                ListNode prev = map.get(sum);
                ListNode temp = prev.next;
                int temp_sum = sum;
                
                while(temp != head) {
                    temp_sum += temp.val;
                    map.remove(temp_sum);
                    temp = temp.next;
                }
                prev.next = head.next;
                
            } else {
                map.put(sum, head);
            }
            head = head.next;
        }
        
        return tempHead.next;
    }
}