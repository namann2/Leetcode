class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        Map<Integer, List<int[]>> g = new HashMap<>();
        construct(g, flights);
        
        return bfs(g, n, src, dst, k);
    }
    
    private int bfs(Map<Integer, List<int[]>> g, int n, int src, int dest, int k) {
        Queue<int[]>q = new LinkedList<>();
        q.add(new int[]{src, 0, k+1});
        
        int[]dis = new int[n];
        Arrays.fill(dis, Integer.MAX_VALUE);
        dis[src] = 0;
        
        while(!q.isEmpty()) {
            int size = q.size();
            for(int i=0;i<size;i++) {
                int[] curr = q.poll();
                int u = curr[0], d = curr[1], currK = curr[2];
                if(!g.containsKey(u))
                    continue;
                for(int[] node : g.get(u)) {
                    int v = node[0], cost = node[1];
                    if(dis[v] > d + cost && currK > 0) {
                        dis[v] = d + cost;
                        q.add(new int[]{v, dis[v], currK-1});
                    }
                }
            }
        }
        return dis[dest] == Integer.MAX_VALUE ? -1 : dis[dest];
    }
    
    private void construct(Map<Integer, List<int[]>> g, int[][] flights) {
        for(int[] flight : flights) {
            int src = flight[0], dest = flight[1], cost = flight[2];
            g.putIfAbsent(src, new ArrayList<>());
            g.get(src).add(new int[]{dest, cost});
        }
    }
}