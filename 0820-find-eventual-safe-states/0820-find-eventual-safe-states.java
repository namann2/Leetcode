enum COLOR {
    WHITE, GREY, BLACK;
}

class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        Map<Integer, List<Integer>> g = new HashMap<>();
        boolean[] isSafeNodeReachable = new boolean[n];
        // construct graph
        for(int i = 0; i < n; i++) {
            g.put(i, new ArrayList<>());
            for(int j : graph[i]) {
                g.get(i).add(j);
            }
            if(g.get(i).size() == 0) {
                isSafeNodeReachable[i] = true;
            }
        }


        for(int i = 0; i < n; i++) {
            if(isSafeNodeReachable[i]) continue;
            COLOR[] state = new COLOR[n];
            Arrays.fill(state, COLOR.WHITE);
            boolean isSafe = true;
            for(int j : g.get(i)) {
                if(state[j] == COLOR.WHITE) {
                    isSafe &= dfs(g, j, isSafeNodeReachable, state);
                    if(!isSafe) break;
                }
            }
            isSafeNodeReachable[i] = isSafe;
        }
        
        // TODO : formulate answer from isSafeNodeReachable
        List<Integer> answer = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            if(isSafeNodeReachable[i]) answer.add(i);
        }
        return answer;
    }

    private boolean dfs(Map<Integer, List<Integer>> g, int u, boolean[] isSafeNodeReachable, COLOR[] state) {
        state[u] = COLOR.GREY;

        boolean isSafe = true;
        for(int v : g.get(u)) {
            if(isSafeNodeReachable[v]) continue;
            if(state[v] == COLOR.GREY) return false;
            if(state[v] == COLOR.WHITE) {
                isSafe &= dfs(g, v, isSafeNodeReachable, state);
                if(!isSafe) return false;
            }
        }
        state[u] = COLOR.BLACK;
        return isSafe;
    }
}