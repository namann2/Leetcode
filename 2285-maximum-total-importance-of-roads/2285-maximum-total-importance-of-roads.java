class Solution {
    public long maximumImportance(int n, int[][] roads) {
        int[] count = new int[n];
        for(int [] road : roads) {
            count[road[0]]++;
            count[road[1]]++;
        }
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i = 0; i < n; i++) {
            pq.offer(count[i]);
        }
        
        long ans = 0;
        while(!pq.isEmpty()) {
            ans += 1l * pq.poll() * n--;
        }
        
        return ans;
    }
}