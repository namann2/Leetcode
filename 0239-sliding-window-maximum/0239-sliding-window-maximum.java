class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        Deque<Integer> q = new LinkedList<>();
        int end = 0, begin = 0, idx = 0;
        int[] answer = new int[n-k+1];
        while(end < n) {
            // keep monotonic increasing queue
            while(!q.isEmpty() && nums[end] > q.peekLast()) q.removeLast();
            q.addLast(nums[end]);
            // keep maintaining the size of window as k
            while(!q.isEmpty() && begin < end && end-begin+1 > k) {
                if(nums[begin] == q.peekFirst()) q.removeFirst();
                begin++;
            }
            // check if size of window is k and update the current maximum
            if(end-begin+1 == k) {
                answer[idx++] = q.isEmpty() ? 0 : q.peekFirst(); 
            }
            end++;
        }
        return answer;
    }
}