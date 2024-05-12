class Job {
    int start,end,profit;
    public Job(int start, int end, int profit) {
        this.start = start;
        this.end = end;
        this.profit = profit;
    }
}
class Solution {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n = startTime.length;
        Job[] jobs = new Job[n];
        
        for(int i = 0; i < n; i++) {
            jobs[i] = new Job(startTime[i], endTime[i], profit[i]);
        }
        
        Arrays.sort(jobs, (j1, j2) -> {
            if(j1.start == j2.start) return j1.end - j2.end;
            return j1.start - j2.start;
        });
        
        Integer[] dp = new Integer[n+1];
        return recursive(jobs, 0, n, dp);
    }
    
    private int recursive(Job[] jobs, int index, int n, Integer[] dp) {
        if(index == n)
            return 0;
        
        if(dp[index] != null)
            return dp[index];
        
        int pick = jobs[index].profit;
        int gnj = findNextJob(jobs, jobs[index].end, n);
        
        if(gnj != -1)
            pick += recursive(jobs, gnj, n, dp);
        
        int skip = recursive(jobs, index + 1, n, dp);
        
        return dp[index] = Math.max(pick, skip);
    }
    
    private int findNextJob(Job[] jobs, int value, int n) {
        int start = 0, end = n-1, ans = -1;
        while(start <= end) {
            int mid = start + (end - start)/2;
            if(jobs[mid].start >= value) {
                ans = mid;
                end = mid - 1;
            } else start = mid + 1;
        }
        return ans;
    }
}