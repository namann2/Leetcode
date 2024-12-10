class Solution {
    public int minReorder(int n, int[][] connections) {
        /*
            Idea : The graph is a tree structure means, the graph is connected.
            Assume a tree rooted at 0. If we consider a tree structure (of the given graph)
            with no direction in edges and do a dfs on the same.
            Now, doing a dfs on a tree rooted at 0 means we are going away from root. 
            If while doing a dfs traversal, we find a path in our map which already exists,
            this means this is the path that is going away from root(0) and this path needs to be changed.
        */
        Map<Integer, List<int[]>> g = new HashMap<>();
        int connectionLength = connections.length;
        for(int i = 0; i < connectionLength; i++) {
            int[] connection = connections[i];
            g.putIfAbsent(connection[0], new ArrayList<>());
            g.putIfAbsent(connection[1], new ArrayList<>());
            g.get(connection[0]).add(new int[]{connection[1], 1});
            g.get(connection[1]).add(new int[]{connection[0], 0});
        }
        
        return dfs(g, 0, -1);
    }
    
    private int dfs(Map<Integer, List<int[]>> g, int src, int parent) {
        int count = 0;
        if(g.containsKey(src)) {
            for(int[] v : g.get(src)) {
                if(v[0] == parent) continue;
                count += v[1];
                count += dfs(g, v[0], src);
            }
        }
        return count;
    }
}