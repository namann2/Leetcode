Video : https://www.youtube.com/watch?v=ivl6BHJVcB0
​
```
class Solution {
public List<Integer> findMinHeightTrees(int n, int[][] edges) {
List<Integer> result = new ArrayList<>();
if(n == 0)
return result;
if(n == 1)
{
result.add(0);
return result;
}
// the nodes with a degree of 1 can never be the root for a MHT. Hnce, apply topo-sort
// and remove those edges and node
List<List<Integer>> adj = new ArrayList<>();
for(int i=0;i<n;i++)
adj.add(i, new ArrayList<>());
// O(n + e)
int[] degree = new int[n];
for(int[] edge : edges) {
degree[edge[0]]++;
degree[edge[1]]++;
adj.get(edge[0]).add(edge[1]);
adj.get(edge[1]).add(edge[0]);
}
Queue<Integer> q = new LinkedList<>();
for(int i=0;i<n;i++)
if(degree[i]==1)
q.add(i);
// nodes with degree 1 will lie on the outer circumfrence and are not use full to us.