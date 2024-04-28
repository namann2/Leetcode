class Solution {
    // Djikstra Algorithm : O(ElogV) + V
    public int networkDelayTime(int[][] times, int n, int source) {
        HashMap<Integer, List<int[]>> adj = new HashMap<>();
        for(int[] time : times) {
            int src = time[0]-1, dest = time[1]-1, wt = time[2];
            adj.putIfAbsent(src, new ArrayList<>());
            adj.get(src).add(new int[]{dest, wt});
        }
        
        source = source - 1;
        int max = Integer.MAX_VALUE;
        int[] D = new int[n];
        Arrays.fill(D, max);
        D[source] = 0;
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((p1, p2)->{
            return p1[1] - p2[1];
        });
        
        pq.offer(new int[]{source, 0}); // node, cost to reach till node
        
        while(!pq.isEmpty()) {
            int[] curr = pq.poll();
            int u = curr[0], cost = curr[1];
            if(!adj.containsKey(u))
                continue;
            for(int[] neigh : adj.get(u)) {
                int v = neigh[0], wt = neigh[1];
                if(D[v] > cost + wt) {
                    D[v] = cost + wt;
                    pq.offer(new int[]{v, D[v]});
                }
            }
        }
        
        int minTime = Integer.MIN_VALUE;
        for(int i=0;i<n;i++) {
            if(D[i] == max) return -1;
            minTime = Math.max(D[i], minTime);
        }
        return minTime;
    }
}