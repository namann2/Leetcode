```
​class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        
        /*
            1. Single Source Shortest Path
            Options: 
                1. Djikstra
                2. Bellman Ford
            Question : 
                Can there be any neg edge ? No, as per the given constraints
                the edge weight can not be negative hence, we can use either of the above
                algorithm but which one is optimal for our use-case ?
                
                Djisktra is more optimal for positive edge weights
        */
        
        // construct graph
        Map<Integer, List<int[]>> g = new HashMap<>();
        for(int[] time : times) {
            int src = time[0] - 1, dest = time[1] - 1, weight = time[2];
            g.putIfAbsent(src, new ArrayList<>());
            g.get(src).add(new int[]{dest, weight});
        }

        PriorityQueue<int[]> q = new PriorityQueue<>((p1, p2) -> {
            return p1[1] - p2[1];
        });
        q.offer(new int[]{k-1, 0});

        int INF = (int)(1e9+7);
        int[] timeTaken = new int[n];
        Arrays.fill(timeTaken, INF);
        timeTaken[k-1] = 0;

        while(!q.isEmpty()) {
            int[] curr = q.poll();
            int u = curr[0], dist = curr[1];
            if(!g.containsKey(u)) continue;
            for(int[] neigh : g.get(u)) {
                int v = neigh[0], d = neigh[1];
                if(timeTaken[v] > timeTaken[u] + d) {
                    timeTaken[v] = timeTaken[u] + d;
                    q.offer(new int[]{v, timeTaken[v]});
                }
            }
        }

        System.out.println(Arrays.toString(timeTaken));
        int maxTime = 0; // dist(src, src)
        for(int i = 0; i < n; i++) {
            if(timeTaken[i] == INF) return -1; // we are unable to reach a node
            if(i != k-1)
                maxTime = Math.max(maxTime, timeTaken[i]);
        }
        return maxTime;
    }
}
```
