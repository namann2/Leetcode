class Solution {
    public ListNode frequenciesOfElements(ListNode head) {
        Map<Integer, Integer> map = new HashMap<>();
        ListNode temp = head;
        while(temp != null) {
            map.put(temp.val, map.getOrDefault(temp.val, 0)+1);
            temp = temp.next;
        }
        ListNode newHead = new ListNode(-1);
        temp = newHead;
        for(int key : map.keySet()) {
            ListNode newNode = new ListNode(map.get(key));
            temp.next = newNode;
            temp = newNode;
        }
        return newHead.next;
    }
}