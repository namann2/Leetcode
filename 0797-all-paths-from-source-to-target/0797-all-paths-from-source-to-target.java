class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> result = new ArrayList<>();
        HashMap<Integer, List<Integer>> g = new HashMap<>();
        int n = graph.length;
        for(int i=0;i<n;i++) {
            g.putIfAbsent(i, new ArrayList<>());
            for(int val : graph[i])
                g.get(i).add(val);
        }
        
        
        ArrayList<Integer> temp = new ArrayList<>();
        temp.add(0);
        dfs(g, 0, n-1, temp, result);
        return result;
    }
    // TC : O(n * 2^n), SC : O(n)
    // Time Complexity : O(N*2^N), where N is the number of nodes in the graph. Every node except the start and end node of graph can either be part of a path or not be part of a path. For a path consisting of k (3 <= k <= n) nodes, we have k-2 intermediate nodes and we can choose from n-2 available nodes. So, the total number of paths are Σ n-2Ck-2 for all 3 <= k <= n, which comes out to be O(2N-2) = O(2^N). Each path requires O(N) to be computed. Thus resulting time complexity becomes O(N*2^N)
    private void dfs(HashMap<Integer, List<Integer>> g, int src, int dest, ArrayList<Integer> temp, List<List<Integer>> result) {
        if(src == dest) {
            result.add(new ArrayList<>(temp));
            return;
        }
        
        for(int neigh : g.get(src)) {
            temp.add(neigh);
            dfs(g, neigh, dest, temp, result);
            temp.remove(temp.size()-1);
        }
    }
}