Two ways : 
1. DFS + Color Theory
2. Topological Sort ( Suggested )

When we are talking about topological sort, we need to be able to determine that the graph is a DAG i.e there is no cycle in the graph. This is because a topological sort is only applicable on a DAG.

Also, the dependency should be clear [ which course is dependant on another ]


## Approach 1: DFS

```
enum COLOR {
    WHITE, GREY, BLACK;
}
class Solution {
    public int[] findOrder(int N, int[][] prerequisites) {
        // topo sort 
        // DFS
        List<List<Integer>> g = new ArrayList<>();
        for(int i = 0; i < N; i++)
            g.add(new ArrayList<>());

        // topo sort order of nodes
        for(int[] pre : prerequisites) {
            g.get(pre[0]).add(pre[1]);
        }
        
        Deque<Integer> stack = new ArrayDeque<>();
        COLOR[] state = new COLOR[N];
        Arrays.fill(state, COLOR.WHITE);
        
        for(int i = 0; i < N; i++) {
            if(state[i] == COLOR.WHITE) {
                if(!dfs(g, i, state, stack))
                    return new int[]{};
            }
        }
        
        int[] answer = new int[N];
        int idx = 0;
        while(!stack.isEmpty()) {
            answer[idx++] = stack.removeFirst();
        }
        
        return answer;
    }
    
    private boolean dfs(List<List<Integer>> g, int u, COLOR[] state, Deque<Integer> stack) {
        state[u] = COLOR.GREY;
        for(int v : g.get(u)) {
            if(state[v] == COLOR.GREY) return false;
            if(state[v] == COLOR.WHITE) {
                if(!dfs(g, v, state, stack))
                    return false;
            }
        }
        stack.addLast(u);
        state[u] = COLOR.BLACK;
        return true;
    }
}
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
