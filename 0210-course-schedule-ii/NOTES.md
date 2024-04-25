Two ways : 
1. DFS + Color Theory
2. Topological Sort ( Suggested )

When we are talking about topological sort, we need to be able to determine that the graph is a DAG i.e there is no cycle in the graph. This is because a topological sort is only applicable on a DAG.

Also, the dependency should be clear [ which course is dependant on another ]


## Approach 1: DFS

```
class Solution {
    static enum COLOR {
        WHITE, GRAY, BLACK;
    }
    
    boolean isDAG = true;
    
    public int[] findOrder(int numCourses, int[][] pr) {
        
        if(numCourses == 0 || pr == null) return new int[]{};
        
        COLOR[] states = new COLOR[numCourses];
        for(int i=0;i<numCourses;i++)
            states[i] = COLOR.WHITE;
        
        ArrayList<ArrayList<Integer>> adj = new ArrayList();
        for(int i=0;i<numCourses;i++)
            adj.add(i, new ArrayList<Integer>());
        
            // [ai, bi] indicates that you must take 
            // course bi first if you want to take course ai
        
        
        for(int[] course : pr) {
            adj.get(course[1]).add(course[0]);
        }
        
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<numCourses;i++) {
            if(states[i] == COLOR.WHITE) {
                dfs(adj, i, states, stack);
            }
        }
        
        // check if all courses can be finished
        if(!isDAG) {
            return new int[]{};
        }
        // formulate the final result;
        int[] result = new int[stack.size()];
        int idx = 0;
        while(stack.size() > 0) {
            result[idx++] = stack.pop();
        }
        return result;
    }
    private void dfs(ArrayList<ArrayList<Integer>> adj, int src, COLOR[] states, Stack<Integer> stack) {
        states[src] = COLOR.GRAY;
        for(int i : adj.get(src)) {
            if(states[i] == COLOR.GRAY) {
                isDAG = false;
                return;
            }
            if(states[i] == COLOR.WHITE) {
                dfs(adj, i, states, stack);
            }
        }
        stack.push(src);
        states[src] = COLOR.BLACK;
    }
}​
```

## Approach 2 : Topological Sort

```
class Solution {
    public int[] findOrder(int n, int[][] prerequisites) {
        List<List<Integer>> g = new ArrayList<>();
        for(int i = 0; i < n; i++)
            g.add(new ArrayList<>());
            
        for(int[] p : prerequisites) {
            g.get(p[1]).add(p[0]);
        }
        
        int[] indegree = new int[n];
        for(int i = 0; i < n; i++) {
            for(int v : g.get(i))
                indegree[v]++;
        }
        
        Deque<Integer> q = new ArrayDeque<>();
        for(int i = 0; i < n; i++)
            if(indegree[i] == 0) 
                q.addLast(i);
        
        int[] order = new int[n];
        int index = 0;
        while(!q.isEmpty()) {
            int u = q.removeFirst();
            order[index++] = u;
            for(int v : g.get(u)) {
                indegree[v] -= 1;
                if(indegree[v] == 0) {
                    q.addLast(v);
                }
            }
        }
        
        for(int i = 0; i < n; i++)
            if(indegree[i] != 0) return new int[]{};
        
        return order;
    }
}
```
