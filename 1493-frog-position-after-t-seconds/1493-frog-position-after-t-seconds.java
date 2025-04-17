class Solution {
    public double frogPosition(int n, int[][] edges, int time, int target) {
        // edge case
        if(edges.length == 0) return target == 1 ? 1d : 0d;
        Map<Integer, List<Integer>> g = new HashMap<>();
        constructGraph(g, edges);
        return dfs(g, 1, time, target, new boolean[n+1]);
    }

    /* helper functions */
    private void constructGraph(Map<Integer, List<Integer>> g, int[][] edges) {
        // construct graph
        for(int[] edge : edges) {
            g.putIfAbsent(edge[0], new ArrayList<>());
            g.putIfAbsent(edge[1], new ArrayList<>());
            g.get(edge[0]).add(edge[1]);
            g.get(edge[1]).add(edge[0]);
        }
    }

    private double dfs(Map<Integer, List<Integer>> g, int currNode, int time, int target, boolean[] visited) {
        // base case
        if(time == 0) {
            return currNode == target ? 1d : 0d;
        }
        // main logic
        visited[currNode] = true;
        // find all unvisitedChildren
        int unvisitedChildren = 0;
        for(int child : g.get(currNode)) {
            if(!visited[child])
                unvisitedChildren++;
        }

        if(unvisitedChildren == 0) 
            return currNode == target ? 1d : 0d;

        double prob_child = 1d / unvisitedChildren;
        for(int child : g.get(currNode)) {
            if(!visited[child]) {
                double prob_path_from_child = dfs(g, child, time - 1, target, visited);
                if(prob_path_from_child > 0)
                    return prob_path_from_child * prob_child;
            }
        }
        return 0d;
    }
}