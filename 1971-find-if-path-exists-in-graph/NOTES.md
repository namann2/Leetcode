Approach 1 : DFS <br>
Approach 2 : BFS <br>
Approach 3 : Union Find
​
<br>
​
### DFS
​
```
class Solution {
// TC : O(V + E)
// SC : O(V + E)
public boolean validPath(int n, int[][] edges, int source, int destination) {
ArrayList<ArrayList<Integer>> g = new ArrayList<>();
for(int i = 0; i < n; i++) {
g.add(new ArrayList<>());
}
for(int[] edge : edges) {
g.get(edge[0]).add(edge[1]);
g.get(edge[1]).add(edge[0]);
}
return dfs(g, source, destination, new boolean[n]);
}
private boolean dfs(ArrayList<ArrayList<Integer>> g, int src, int dest, boolean[] visited) {
if(src == dest)
return true;
visited[src] = true;
for(int v : g.get(src)) {
if(!visited[v])
if(dfs(g, v, dest, visited))
return true;
}
return false;
}
}
```