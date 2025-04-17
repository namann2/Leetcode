### First Attempt : Correct Solution but not optimal

```
class NodePair {
    double prob;
    boolean found;

    public NodePair(double prob, boolean found) {
        this.prob = prob;
        this.found = found;
    }
}

class Solution {
    public double frogPosition(int n, int[][] edges, int t, int target) {
        if(edges.length == 0) return 1d;
        Map<Integer, List<Integer>> g = new HashMap<>();
        for (int[] edge : edges) {
            g.putIfAbsent(edge[0], new ArrayList<>());
            g.putIfAbsent(edge[1], new ArrayList<>());
            g.get(edge[0]).add(edge[1]);
            g.get(edge[1]).add(edge[0]);
        }

        // NOTE : edge case : if frog can not move to any other vertex and there is still time left
        boolean[] visited = new boolean[n + 1];
        return dfs(g, 1, t, target, visited).prob;
    }

    private NodePair dfs(Map<Integer, List<Integer>> g, int u, int time, int target, boolean[] visited) {
        // base case
        // target is leaf node
        if (time == 0) {
            return new NodePair(u == target ? 1d : 0d, u == target);
        }
        // main logic
        visited[u] = true;
        List<Integer> childNodes = g.get(u);
        double countUnVisitedNodes = 0;

        for (int childNode : childNodes) {
            if (!visited[childNode])
                ++countUnVisitedNodes;
        }
        if (countUnVisitedNodes == 0)
            return u == target ? new NodePair(1d, true) : new NodePair(0d, false);

        // common prob of current child nodes
        double prob = (double) (1d / countUnVisitedNodes);
        for (int childNode : childNodes) {
            if (!visited[childNode]) {
                NodePair current = dfs(g, childNode, time - 1, target, visited);
                if (current.found)
                    return new NodePair(1d * prob * current.prob, true);
            }
        }
        return new NodePair(0d, false);
    }
}
```


### Attempt 2 : Better than approach 1 but still needs improvement

```
class Solution {
    public double frogPosition(int n, int[][] edges, int time, int target) {
        // edge case
        if(edges.length == 0) return target == 1 ? 1d : 0d;
        Map<Integer, List<Integer>> g = new HashMap<>();
        constructGraph(g, edges);
        return dfs(g, 1, time, target, new boolean[n+1]);
    }

    /* helper functions */
    private void constructGraph(Map<Integer, List<Integer>> g, int[][] edges) {
        // construct graph
        for(int[] edge : edges) {
            g.putIfAbsent(edge[0], new ArrayList<>());
            g.putIfAbsent(edge[1], new ArrayList<>());
            g.get(edge[0]).add(edge[1]);
            g.get(edge[1]).add(edge[0]);
        }
    }

    private double dfs(Map<Integer, List<Integer>> g, int currNode, int time, int target, boolean[] visited) {
        // base case
        if(time == 0) {
            return currNode == target ? 1d : 0d;
        }
        // main logic
        visited[currNode] = true;
        // find all unvisitedChildren
        int unvisitedChildren = 0;
        for(int child : g.get(currNode)) {
            if(!visited[child])
                unvisitedChildren++;
        }

        // if there are no childpath to explore
        if(unvisitedChildren == 0) 
            return currNode == target ? 1d : 0d;

        double prob_child = 1d / unvisitedChildren;
        for(int child : g.get(currNode)) {
            if(!visited[child]) {
                double prob_path_from_child = dfs(g, child, time - 1, target, visited);
                // prob_path_from_child > 0 means that there exist a path which passes through this child
                // that contains a node that equals target
                if(prob_path_from_child > 0)
                    return prob_path_from_child * prob_child;
            }
        }
        return 0d;
    }
}
```

### Attempt3 : Need to remove the currNode list iteration to find unvisited child in dfs
