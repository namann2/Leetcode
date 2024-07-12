class Solution {
    public long[] placedCoins(int[][] edges, int[] cost) {
        Map<Integer, List<Integer>> g = new HashMap<>();
        // construct graph
        for(int[] edge : edges) {
            g.putIfAbsent(edge[0], new ArrayList<>());
            g.putIfAbsent(edge[1], new ArrayList<>());
            g.get(edge[0]).add(edge[1]);
            g.get(edge[1]).add(edge[0]);
        }
        
        int n = cost.length;
        long[] answer = new long[n];
        Arrays.fill(answer, 1l);
        dfs(g, -1, 0, cost, answer);
        return answer;
    }
    
    private List<Long> dfs(Map<Integer, List<Integer>> g, int parent, int u, int[] cost, long[] answer) {
        List<Long> requiredValues = new ArrayList<>();
        // current node is also inclusive in the subtree
        requiredValues.add((long)cost[u]);
        
        for(int v : g.get(u)) {
            if(v == parent) continue;
            requiredValues.addAll(dfs(g, u, v, cost, answer));
        }
            
        int size = requiredValues.size();
        if(size < 3) {
            return requiredValues;
        }
        
        Collections.sort(requiredValues);
        
        long option1 = requiredValues.get(size-1) * requiredValues.get(size-2) * requiredValues.get(size-3);
        long option2 = requiredValues.get(size-1) * requiredValues.get(0) * requiredValues.get(1);
        
        answer[u] = Math.max(0, Math.max(option1, option2));
        if(size <= 5)
            return requiredValues;
        
        return List.of(requiredValues.get(size-1), requiredValues.get(size-2), requiredValues.get(size-3), 
                       requiredValues.get(0), requiredValues.get(1));
    }
}