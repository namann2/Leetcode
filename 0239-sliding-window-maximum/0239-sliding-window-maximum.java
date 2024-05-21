class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int end = 0, begin = 0, idx = 0;
        int[] ans = new int[n-k+1];
        Deque<Integer> q = new ArrayDeque<>();
        while(end < n) {
            while(!q.isEmpty() && q.peekLast() < nums[end])
                q.removeLast();
            q.addLast(nums[end]);
            if(end - begin + 1 == k) {
                ans[idx++] = q.peekFirst();
                if(q.peekFirst() == nums[begin++]) q.removeFirst();
            }
            end++;
        }
        return ans;
    }
}