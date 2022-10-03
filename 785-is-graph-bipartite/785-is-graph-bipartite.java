class Solution {
    static enum COLOR {
        WHITE, RED, BLUE;
    }
    public boolean isBipartite(int[][] graph) {
        if(graph == null || graph.length == 0)
            return true;
        
        int n = graph.length;
        COLOR[] color = new COLOR[n];
        Arrays.fill(color, COLOR.WHITE);
        
        for(int i=0;i<n;i++) {
            if(color[i] == COLOR.WHITE) {
                if(!dfs(graph, i, color, COLOR.RED))
                    return false;
            }
        }
        return true;
    }
    private boolean dfs(int[][]g, int src, COLOR[] color, COLOR c) {
        color[src] = c;
        for(int node : g[src]) {
            if(color[node] == c) return false;
            if(color[node] == COLOR.WHITE)
                if(!dfs(g, node, color, c == COLOR.RED ? COLOR.BLUE : COLOR.RED))
                    return false;
        }
        return true;
    }
}