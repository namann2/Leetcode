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
                if(!bfs(g, i, states))
                    return false;
        }
        
        return true;
    }
    private boolean bfs(List<List<Integer>> g, int src, COLOR[] states) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(src);
        states[src] = COLOR.RED;
        
        while(!q.isEmpty()) {
            int u = q.poll();
            for(int v : g.get(u)) {
                if(states[v] == COLOR.WHITE) {
                    states[v] = states[u] == COLOR.RED ? COLOR.BLACK : COLOR.RED;
                    q.offer(v);
                }
                if(states[v] == states[u]) return false;
            }
        }
        return true;
    }
}