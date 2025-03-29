enum COLOR {
    WHITE, GREY, BLACK;
}

class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<Integer> answer = new ArrayList<>();
        Map<Integer, List<Integer>> g = new HashMap<>();
        int n = graph.length;
        boolean[] isEventualSafeNode = new boolean[n];

        // construct graph
        for (int i = 0; i < n; i++) {
            g.put(i, new ArrayList<>());
            for (int j : graph[i]) {
                g.get(i).add(j);
            }
            if (g.get(i).size() == 0)
                isEventualSafeNode[i] = true;
        }

        // step1 : dfs from each node, explore neigh node1, neigh node2.... neigh nodeN.
        // step2 : for the selected node, check if all paths lead to an eventual safe node
        for (int i = 0; i < n; i++) {
            boolean isSafe = true;
            COLOR[] state = new COLOR[n];
            Arrays.fill(state, COLOR.WHITE);

            for (int neigh : g.get(i)) {
                isSafe &= dfs(g, neigh, state, isEventualSafeNode);
                if (!isSafe)
                    break;
            }
            isEventualSafeNode[i] = isSafe;
            if(isEventualSafeNode[i]) {
                for (int neigh : g.get(i)) {
                    isEventualSafeNode[neigh] = true;
                }
            }
            if(isEventualSafeNode[i]) answer.add(i);
        }

        return answer;
    }

    private boolean dfs(Map<Integer, List<Integer>> g, int u, COLOR[] state, boolean[] isEventualSafeNode) {
        // base case
        // if 'u' is the terminal node
        if(isEventualSafeNode[u]) return true;
        state[u] = COLOR.GREY;

        boolean isSafe = true;
        for(int v : g.get(u)) {
            if(isEventualSafeNode[v]) continue;
            if(state[v] == COLOR.GREY) return false; // loop / cycle detected
            if(state[v] == COLOR.WHITE) {
                isSafe &= dfs(g, v, state, isEventualSafeNode);
                if(!isSafe) return false;
            }
        }
        state[u] = COLOR.BLACK;
        return true;
    }
}