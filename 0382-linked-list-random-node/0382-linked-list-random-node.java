class Solution {
    // O(1)
    ListNode linkedList;
    public Solution(ListNode head) {
        linkedList = head;
    }
    // O(n)
    public int getRandom() {
        int seenTillNow = 0; // count of numbers seen till now
        ListNode curr = linkedList;
        int ans = -1;
        while(curr != null) {
            ++seenTillNow; // we have seen one number more
            int randomIndex = (int)(Math.random() * seenTillNow);
            if(randomIndex == seenTillNow - 1) { // assume these numbers are stored in an array, 1st number corresponds to 0th index
                ans = curr.val;
            }
            curr = curr.next;
        }
        return ans;
    }
}