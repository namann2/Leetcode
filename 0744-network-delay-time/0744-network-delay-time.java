class Solution {
    public int networkDelayTime(int[][] times, int n, int source) {
        /* 
            This is a direct application of Djikstra Algorithm.
            Given the edge weights are positive, bellman ford would be an overkill
        */

        Map<Integer, List<int[]>> g = new HashMap<>();
        int length = times.length;
        for(int i = 0; i < length; i++) {
            g.putIfAbsent(times[i][0], new ArrayList<>());
            g.get(times[i][0]).add(new int[]{times[i][1], times[i][2]});
        }

        int INF = (int)1e9+7;
        int[] timeTaken = new int[n+1];
        Arrays.fill(timeTaken, INF);
        timeTaken[source] = 0;
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((p, q) -> {
            return p[1] - q[1];
        });
        // node, timeTakenToReach
        pq.offer(new int[]{source, 0});

        while(!pq.isEmpty()) {
            int[] curr = pq.poll();
            int currNode = curr[0], currTime = curr[1];
            if(!g.containsKey(currNode)) continue;
            for(int[] neigh : g.get(currNode)) {
                int neighNode = neigh[0], neighTime = neigh[1];
                if(timeTaken[neighNode] > currTime + neighTime) {
                    timeTaken[neighNode] = currTime + neighTime;
                    pq.offer(new int[]{neighNode, timeTaken[neighNode]});
                }
            }
        }

        int min = -1;
        for(int i = 1; i < n+1; i++) {
            if(timeTaken[i] == INF) return -1;
            min = Math.max(min, timeTaken[i]);
        }
        return min;
    }
}