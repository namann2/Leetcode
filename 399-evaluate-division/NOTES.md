```
class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        HashMap<String, List<Pair>> adj = new HashMap<>();
        // build graph
        buildGraph(adj, equations, values);
        
        int n = queries.size();
        double [] result = new double[n];
        
        for(int i=0;i<n;i++) {
            List<String> curr = queries.get(i);
            result[i] = dfs(curr.get(0), curr.get(1), adj, new HashSet<>());
        }
        return result;
    }
    private void buildGraph(HashMap<String, List<Pair>> adj, List<List<String>> equations, double[] values) {
        int n = equations.size();
        
        for(int i=0;i<n;i++) {
            List<String> nodeInfo = equations.get(i);
            String u = nodeInfo.get(0), v = nodeInfo.get(1);
            double v1 = values[i], v2 = 1/v1;
            
            if(!adj.containsKey(u))
                adj.put(u, new ArrayList<Pair>());
            if(!adj.containsKey(v))
                adj.put(v, new ArrayList<Pair>());
            
            adj.get(u).add(new Pair(v, v1));
            adj.get(v).add(new Pair(u, v2));
        }
    }
    
    private double dfs(String src, String dest, HashMap<String, List<Pair>> adj, HashSet<String> visited) {
        
        if(!adj.containsKey(src) || !adj.containsKey(dest))
            return -1.0;
        if(src.equals(dest))
            return 1.0;
        
        visited.add(src);
        
        List<Pair> neigh = adj.get(src);
        for(Pair v : neigh) {
            if(!visited.contains(v.node)) {
                double value = dfs(v.node, dest, adj, visited);
                if(value != -1.0)
                    return value * v.val;
            }
        }
        return -1.0;
    }
}
class Pair {
    String node;
    double val;
    Pair(String node, double val) {
        this.node = node;
        this.val = val;
    }
}
```
