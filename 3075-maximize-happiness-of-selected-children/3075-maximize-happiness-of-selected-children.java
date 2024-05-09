class Solution {
    public long maximumHappinessSum(int[] A, int k) {
        long ans = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->{
            return b[1] - a[1];
        });
        
        int n = A.length;
        for(int i = 0;i < n; i++)
            pq.offer(new int[]{i, A[i]});
        
        int turn = 0;
        while(!pq.isEmpty() && k-- > 0) {
            ans += Math.max(0, pq.poll()[1] - turn++);
        }
        return ans;
    }
}