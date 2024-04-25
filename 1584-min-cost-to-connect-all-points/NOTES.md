How do we know that this is an MST problem?
​
Given a connected, weighted, and undirected graph, a minimum spanning tree is a subset of edges that connect all vertices while the total weights of these edges are minimum among all possible subsets.
​
```
class Solution {
public int minCostConnectPoints(int[][] points) {
PriorityQueue<int[]> pq = new PriorityQueue<>((p1, p2) -> {
return p1[2] - p2[2]; // based on smaller dis between two points
});
int n = points.length;
// O(V^2)
for(int i=0;i<n;i++) {
int[] p1 = points[i];
for(int j=i+1;j<n;j++) {
int[] p2 = points[j];
int dis = Math.abs(p2[1] - p1[1]) + Math.abs(p2[0] - p1[0]);
pq.add(new int[]{i, j, dis});
}
}
UnionFind uf = new UnionFind();
uf.makeSet(n);
int cost = 0;
// O(num of time we need to call union * log V^2)
// O(V-1 * log V^2)
while(!pq.isEmpty()) {
this.sets--;