enum COLOR {
    WHITE, GREY, BLACK;    
}
class Solution {
    public boolean canFinish(int N, int[][] prerequisites) {
        List<List<Integer>> g = new ArrayList<>();
        for(int i = 0; i < N; i++)
            g.add(new ArrayList<>());
            
        for(int[] p : prerequisites) {
            g.get(p[1]).add(p[0]);
        }
        
        // check if there is a cycle
        COLOR[] states = new COLOR[N];
        Arrays.fill(states, COLOR.WHITE);
        
        for(int i = 0; i < N; i++) {
            if(states[i] == COLOR.WHITE) {
                if(dfs(g, i, states))
                    return false;
            }
        }
        
        return true;
    }
    private boolean dfs(List<List<Integer>> g, int u, COLOR[] states) {
        states[u] = COLOR.GREY;
        for(int v : g.get(u)) {
            if(states[v] == COLOR.GREY) return true;
            if(states[v] == COLOR.WHITE) 
                if(dfs(g, v, states)) return true;
        }
        states[u] = COLOR.BLACK;
        return false;
    }
}