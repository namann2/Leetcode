class Solution {
    public int numOfMinutes(int n, int headId, int[] manager, int[] informTime) {
        Map<Integer, List<Integer>> g = new HashMap<>();
        // construct graph
        for(int i = 0; i < n; i++) {
            if(headId == i) continue;
            g.putIfAbsent(manager[i], new ArrayList<>());
            g.get(manager[i]).add(i);
        }

        return dfs(g, headId, informTime);
    }

    private int dfs(Map<Integer, List<Integer>> g, int source, int[] informTime) {
        // base case
        if(!g.containsKey(source)) return 0;
        // main logic
        // bottom up traversal
        // ideation : at each node, consider the max time it took to inform the subtree
        // return max time to the root. 
        // root will consider the max time it got from its child they took to inform their subtree
        int maxInformTime = 0;
        for(int child : g.get(source)) {
            maxInformTime = Math.max(maxInformTime, dfs(g, child, informTime));
        }
        return maxInformTime + informTime[source];
    }
}