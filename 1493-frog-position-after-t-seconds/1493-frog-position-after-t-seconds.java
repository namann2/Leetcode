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

        // TODO : edge case : if frog can not move to any other vertex and there is still time left
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

// class Solution {
//     public double frogPosition(int n, int[][] edges, int t, int target) {
        
//         List<Integer>[] graph = new ArrayList[n + 1];
//         for (int i = 1; i <= n; i++) {
//             graph[i] = new ArrayList<>();
//         }
        
//         for (int[] edge : edges) {
//             graph[edge[0]].add(edge[1]);
//             graph[edge[1]].add(edge[0]);
//         }
        
        
//         double[] prob = new double[n + 1];
//         prob[1] = 1.0;
        
        
//         boolean[] visited = new boolean[n + 1];
        
        
//         return dfs(graph, prob, visited, 1, t, target);
//     }
    
//     private double dfs(List<Integer>[] graph, double[] prob, boolean[] visited, int vertex, int t, int target) {
//         if (t == 0) {
//             return vertex == target ? prob[vertex] : 0.0;
//         }
        
//         visited[vertex] = true;
//         int unvisitedChildren = 0;
//         for (int neighbor : graph[vertex]) {
//             if (!visited[neighbor]) {
//                 unvisitedChildren++;
//             }
//         }
        
//         if (unvisitedChildren == 0) {
//             return vertex == target ? prob[vertex] : 0.0;
//         }
        
//         double result = 0.0;
//         for (int neighbor : graph[vertex]) {
//             if (!visited[neighbor]) {
//                 prob[neighbor] = prob[vertex] / unvisitedChildren;
//                 result += dfs(graph, prob, visited, neighbor, t - 1, target);
//             }
//         }
        
//         // visited[vertex] = false;
//         return result;
//     }
// }