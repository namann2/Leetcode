class Solution {
    public int maximumRobots(int[] chargeTimes, int[] runningCosts, long budget) {
        // Similar to : Sliding Window Maximum
        int n = chargeTimes.length;
        Deque<Integer> q = new ArrayDeque<>();
        
        int begin = 0, end = 0, maxi = 0;
        long sum = 0;
        while(end < n) {
            sum += runningCosts[end];
            while(!q.isEmpty() && chargeTimes[q.peekLast()] < chargeTimes[end]) {
                q.pollLast();
            }
            q.addLast(end);
            long cb = sum * (end - begin + 1) + chargeTimes[q.peekFirst()];
            if(cb > budget) {
                if(!q.isEmpty() && q.peekFirst() == begin) q.pollFirst();
                sum -= runningCosts[begin++];
            }
            if(cb <= budget) maxi = Math.max(maxi, end-begin+1);
            end++;
        }
        return maxi;
    }
}
