enum COLOR {
    WHITE, GREY, BLACK;
}
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // if two courses depend on each other then, it is not possible ->> cycle detection in directed graph

        // construct graph
        Map<Integer, List<Integer>> g = new HashMap<>();
        for(int[] prerequisite : prerequisites) {
            g.putIfAbsent(prerequisite[0], new ArrayList<>());
            g.get(prerequisite[0]).add(prerequisite[1]);
        }

        COLOR[] state = new COLOR[numCourses];
        Arrays.fill(state, COLOR.WHITE);

        // we are not sure if the given graph is connected
        for(int i = 0; i < numCourses; i++) {
            if(state[i] == COLOR.WHITE) {
                if(dfs(g, i, state)) return false;
            }
        }
        return true;
    }

    private boolean dfs(Map<Integer, List<Integer>> g, int u, COLOR[] state) {
        state[u] = COLOR.GREY;
        if(g.containsKey(u)) {
            for(int v : g.get(u)) {
                if(state[v] == COLOR.GREY) return true;
                if(state[v] == COLOR.WHITE) {
                    if(dfs(g, v, state)) return true;
                }
            } 
        }
        state[u] = COLOR.BLACK;
        return false;
    }
}