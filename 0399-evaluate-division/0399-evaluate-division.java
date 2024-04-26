class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, List<Pair<String, Double>>> g = new HashMap<>();
        constructGraph(g, equations, values);
        
        int qsize = queries.size();
        double[] ans = new double[qsize];
        Arrays.fill(ans, -1d);
        
        for(int i = 0; i < qsize; i++) {
            List<String> query = queries.get(i);
            String u = query.get(0);
            String v = query.get(1);
            if(g.containsKey(u))
                ans[i] = dfs(g, u, v, new HashSet());
        }
        return ans;
    }
    private void constructGraph(Map<String, List<Pair<String, Double>>> g, List<List<String>> equations, double[] values) {
        int n = values.length;
        for(int i = 0; i < n; i++) {
            List<String> equation = equations.get(i);
            String A = equation.get(0), B = equation.get(1);
            
            g.putIfAbsent(A, new ArrayList<>());
            g.putIfAbsent(B, new ArrayList<>());
            
            Pair p1 = new Pair(B, values[i]);
            Pair p2 = new Pair(A, 1 / values[i]);
            
            g.get(A).add(p1);
            g.get(B).add(p2);
        }
    }
    
    private double dfs(Map<String, List<Pair<String, Double>>> g, String u, String v, HashSet<String> visited) {
        
        visited.add(u);
        
        if(u.equals(v))
            return 1d;
        
        if(!g.containsKey(u))
            return -1d;
        
        for(Pair<String, Double> p : g.get(u)) {
            if(!visited.contains(p.getKey())) {
                double value = dfs(g, p.getKey(), v, visited);
                if(value != -1d)
                    return value * p.getValue();
            }
        }
        
        return -1d;
    }
}