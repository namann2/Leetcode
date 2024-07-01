class Solution {
    public int maxSubarrayLength(int[] nums) {
        Deque<Integer> deque = new ArrayDeque<>();
        int n = nums.length;
        
        for (int i = 0; i < n; i++) {
            if (deque.isEmpty() || nums[i] > nums[deque.peekLast()]) {
                deque.addLast(i);
            }
        }
        
        int maxLength = 0;
        for (int i = n - 1; i >= 0; i--) {
            // remove from stack as soon as we find the nums[i] < nums[top] because we found the maxLength
            while (!deque.isEmpty() && nums[i] < nums[deque.peekLast()]) {
                maxLength = Math.max(maxLength, i - deque.removeLast() + 1);
            }
        }
        
        return maxLength;
    }
}