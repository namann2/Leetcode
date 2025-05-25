class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        Map<Integer, List<int[]>> g = new HashMap<>();
        for(int[] flight : flights) {
            g.putIfAbsent(flight[0], new ArrayList<>());
            g.get(flight[0]).add(new int[]{flight[1], flight[2]});
        }

        Queue<int[]> q = new LinkedList<>();

        int INF = Integer.MAX_VALUE;
        int[] priceToReach = new int[n];
        Arrays.fill(priceToReach, INF);
        priceToReach[src] = 0;

        q.offer(new int[]{src, 0, 0});
        while(!q.isEmpty()) {
            int size = q.size();
            for(int i = 0; i < size; i++) {
                int[] curr = q.poll();
                int currNode = curr[0], currK = curr[1], currPrice = curr[2];
                if(!g.containsKey(currNode)) continue;
                for(int[] neighNode : g.get(currNode)) {
                    int neigh = neighNode[0], incurCost = neighNode[1];
                    if(currK <= k && priceToReach[neigh] > currPrice + incurCost) {
                        priceToReach[neigh] = currPrice + incurCost;
                        q.offer(new int[]{neigh, currK + 1, priceToReach[neigh]});
                    }
                }
            }
        }
        return priceToReach[dst] == INF ? -1 : priceToReach[dst];
    }
}