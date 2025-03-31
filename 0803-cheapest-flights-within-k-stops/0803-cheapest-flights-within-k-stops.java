class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        Map<Integer, List<int[]>> g = new HashMap<>();
        for(int[] flight : flights) {
            int srcn = flight[0], dest = flight[1], cost = flight[2];
            g.putIfAbsent(srcn, new ArrayList<>());
            g.get(srcn).add(new int[]{dest, cost});
        }

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{src, 0, 0});
        int[] distance = new int[n];
        int INF = (int)(1e9+7);
        Arrays.fill(distance, INF);
        distance[src] = 0;

        while(!q.isEmpty()) {
            int[] curr = q.poll();
            int city = curr[0], ck = curr[1], cdis = curr[2];
            if(g.containsKey(city)) {
                for(int[] neigh : g.get(city)) {
                    int dest = neigh[0], cost = neigh[1];
                    if(distance[dest] > cdis + cost && ck <= k) {
                        distance[dest] = cdis + cost;
                        q.offer(new int[]{dest, ck + 1, distance[dest]});
                    }
                }
            }
        }
        return distance[dst] == INF ? -1 : distance[dst];
    }
}