/* 
    Complexity : 
    TC : Let N be the number of equations that we are given, M be the length of queries
        1. O(N) -> Build the graph
        2. Query result : For each query, we need to traverse the graph. In the worst case, we would need to traverse
                         the complete graph, hence, for M queries, we would take O(N * M)
    SC : 
        1. O(N) + O(N) -> Build the graph (edges in reverse as well)
        2. While traversing, dfs call would become O(N) at the maximum
        
    TC => O(N * M)
    SC => O(N)
*/

class Solution {

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {    
        Map<String, List<Pair>> g = constructGraph(equations, values);
        int n = queries.size();
        double[]answer = new double[n];
        Arrays.fill(answer, -1.0);
        
        for(int i=0;i<n;i++) {
            List<String> query = queries.get(i);
            String source = query.get(0);
            String destination = query.get(1);
            if(g.containsKey(source))
                answer[i] = dfs(g, source, destination, new HashSet());
        }
        return answer;
    }
    
    private Map<String, List<Pair>> constructGraph(List<List<String>> equations, double[] values) {
        Map<String, List<Pair>> g = new HashMap<>();
        int n = values.length;
        for(int i=0;i<n;i++) {
            List<String> equation = equations.get(i);
            String source = equation.get(0);
            String destination = equation.get(1);
            
            g.putIfAbsent(source, new ArrayList<>());
            g.putIfAbsent(destination, new ArrayList<>());
            
            Pair currPair1 = new Pair(destination, values[i]);
            Pair currPair2 = new Pair(source, 1/values[i]);
            
            g.get(source).add(currPair1);
            g.get(destination).add(currPair2);
        }
        return g;
    }
    
    private double dfs(Map<String, List<Pair>> g, String source, String destination, Set<String> visited) {
        if(source.equals(destination))
            return 1.0;

        if(g.containsKey(source)) {
            visited.add(source);
            for(Pair pair : g.get(source)) {
                String node = pair.getNodeRepresentation();
                double value = pair.getNodeValue();
                if(visited.contains(node)) continue;
                double ans = dfs(g, node, destination, visited);
                if(ans != -1.0) 
                    return ans * value;
            }
        }
        return -1.0;
    }
}

class Pair {
    private final String node;
    private final double val;
    Pair(String node, double val) {
        this.node = node;
        this.val = val;
    }
    
    public String getNodeRepresentation() {
        return this.node;
    }
    
    public double getNodeValue() {
        return this.val;
    }
}