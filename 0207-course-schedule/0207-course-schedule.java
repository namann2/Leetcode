enum COLOR {
    WHITE, GREY, BLACK;
}

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
        List<List<Integer>> g = new ArrayList<>();
        for(int i = 0; i < numCourses; i++)
            g.add(new ArrayList<>());
        
        // topo sort order of vertices
        for(int [] pre : prerequisites) {
            g.get(pre[0]).add(pre[1]);
        }
        
        Deque<Integer> stack = new ArrayDeque<>();
        COLOR[] visited = new COLOR[numCourses];
        Arrays.fill(visited, COLOR.WHITE);
        
        for(int i = 0; i < numCourses; i++) {
            if(visited[i] == COLOR.WHITE) {
                if(!dfs(g, i, visited, stack))
                    return false;
            }
        }
        
        return true;
    }
    
    static boolean dfs(List<List<Integer>> g, int u, COLOR[] visited, Deque<Integer> stack) {
        visited[u] = COLOR.GREY;
        for(int v : g.get(u)) {
            if(visited[v] == COLOR.GREY) {
                return false;
            }
            if(visited[v] == COLOR.WHITE) {
                if(!dfs(g, v, visited, stack))
                    return false;
            }
        }
        visited[u] = COLOR.BLACK;
        return true;
    }
}
