enum COLOR {
    WHITE, RED, BLACK;    
}

class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        List<List<Integer>> g = new ArrayList<>();
        
        for(int i = 0; i < n; i++) 
            g.add(new ArrayList<>());
        
        for(int i = 0; i < n; i++) {
            for(int j : graph[i])    
                g.get(i).add(j);
        }
        
        COLOR[] states = new COLOR[n];
        Arrays.fill(states, COLOR.WHITE);
        
        for(int i = 0; i < n; i++) {
            if(states[i] == COLOR.WHITE)
                if(!dfs(g, i, COLOR.RED, states))
                    return false;
        }
        
        return true;
    }
    private boolean dfs(List<List<Integer>> g, int src, COLOR color, COLOR[] states) {
        states[src] = color;
        for(int v : g.get(src)) {
            if(states[v] == COLOR.WHITE) {
                if(!dfs(g, v, color == COLOR.RED ? COLOR.BLACK : COLOR.RED, states))
                    return false;
            }
            if(states[v] == states[src]) return false;
        }
        return true;
    }
}