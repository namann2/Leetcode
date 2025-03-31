# Intuition :
We say that the breadth-first search is a good algorithm to use if we want to find the shortest path in an undirected, unweighted graph. The claim for BFS is that the first time a node is discovered during the traversal, that distance from the source would give us the shortest path. The same cannot be said for a weighted graph. <br>

For a weighted graph, there is no correlation between the number of edges composing the path and the actual length of the path which is composed of the weights of all the edges in it. Thus, we cannot employ breadth-first search for weighted graphs. <br>
​
Breadth-first search has no way of knowing if a particular discovery of a node would give us the shortest path to that node. And so, the only possible way for BFS (or DFS) to find the shortest path in a weighted graph is to search the entire graph and keep recording the minimum distance from source to the destination vertex. <br>
​
That being said, Breadth-first search is actually a great algorithm of choice for this problem because the number of levels to be explored by the algorithm is bounded by K <br>
​
The number of levels that the search would go to is limited by the value K+1 in the question. So essentially, we would be trying to find the shortest path, but we won’t have to explore the entire graph as such. We will just go up to the level K+1 and we just need to return the shortest path to the destination (if reachable by level K+1) at the end of the algorithm. <br>
​
TC : O(E * K) , since we can process each edge multiple times depending upon the improvement in the shortest distances. However, the maximum number of times an edge would be processed is bounded by K + 1 since that's the number of levels we are going to explore in this algorithm. <br>
​
​
```
class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        // V -> vertices = cities
        // E -> flights
        HashMap<Integer, List<int[]>> g = new HashMap<>();
        // V+E
        for(int[] flight : flights) {
            int u = flight[0],
                v = flight[1],
                d = flight[2];
            
            g.putIfAbsent(u, new ArrayList<>());
            g.get(u).add(new int[]{v, d});
        }
        // we do not need pq for this, as we are traversing all possible paths
        // and we need atmost k stops
        Queue<int[]> q = new LinkedList<>();
        
        int[]distance = new int[n];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[src] = 0;
        
        q.add(new int[]{src, 0, 0}); // src, dist, k
        
        // We would be processing an edge multiple times 
        // TC : E.K
        while(!q.isEmpty()) {
            int[] curr = q.poll();
            int u = curr[0], d = curr[1], currK = curr[2];
            if(!g.containsKey(u))
                continue;
            for(int[] neigh : g.get(u)) {
                int v = neigh[0];
                int wt = neigh[1];
                if(distance[v] > d + wt && currK <= k) {
                    distance[v] = d + wt;
                    q.add(new int[]{v, distance[v], currK+1});
                }
            } 
        }
        return distance[dst] == Integer.MAX_VALUE ? -1 : distance[dst];
    }
}
```
