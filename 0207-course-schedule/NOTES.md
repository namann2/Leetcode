There are two ways to detect cycle in a directed graph : <br>
1. Color Theory + DFS <br>
2. Topological Sort -> if after topo sort, indegree of all nodes is 0, then no cycle else there is a cycle in directed graph

***

### TopoSort DFS + Cycle Detection

```
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
```

***

## Kahn's Algorithm (TopoSort BFS) + whether all nodes are visited

```
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
        List<List<Integer>> g = new ArrayList<>();
        for(int i = 0; i < numCourses; i++)
            g.add(new ArrayList<>());
        // topo sort order of vertices
        for(int [] pre : prerequisites) {
            g.get(pre[0]).add(pre[1]);
        }
        
        // kahn's algo
        int[] indegree = new int[numCourses];
        for(int[] course : prerequisites) {
            indegree[course[1]]++;
        }
        
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < numCourses; i++) {
            if(indegree[i] == 0) q.offer(i);
        }
        
        if(q.size() == 0) return false;
        
        int coursesDone = 0;
        while(!q.isEmpty()) {
            int curr = q.remove();
            coursesDone++;
            for(int v : g.get(curr)) {
                indegree[v]--;
                if(indegree[v] == 0) {
                    q.offer(v);
                }
            }
        }
        return coursesDone == numCourses;
    }
}
```
