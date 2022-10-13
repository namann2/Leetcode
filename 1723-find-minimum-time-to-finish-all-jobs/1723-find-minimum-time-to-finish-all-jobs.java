class Solution {
    public int minimumTimeRequired(int[] jobs, int k) {
        // TC : O(log(SUM - MAX) * k^n)
        // SC : O(log(SUM - MAX) * N)
        // subsequence, hence order won't matter
        Arrays.sort(jobs);
        int n = jobs.length;
        int start = jobs[n-1], end = Arrays.stream(jobs).sum();
        
        int ans = 0;
        while(start <= end) {
            int mid = start + (end - start)/2;
            if(canAssign(jobs, new int[k], mid, 0, n, k)) {
                ans = mid;
                end = mid - 1;
            } else start = mid + 1;
        }
        return ans;
    }
    private boolean canAssign(int[] jobs, int[] tmp, int maxCanAssign, int index, int n, int k) {
        // base condition
        if(index == n) {
            return true;
        }
        // main logic
        // a specific job could be assigned to many workers, hence,
        // here we are trying to assing jobs[index] to every worker
        int currJob = jobs[index];
        for(int i=0;i<k;i++) {
            if(currJob + tmp[i] <= maxCanAssign) {
                tmp[i] += currJob;
                if(canAssign(jobs, tmp, maxCanAssign, index+1, n, k))
                    return true;
                tmp[i] -= currJob;
            }
            if(tmp[i] == 0) break; // if we can not assign any job to this current worker
        }
        return false;
    }
}