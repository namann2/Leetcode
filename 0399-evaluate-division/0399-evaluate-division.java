class Solution {

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, List<Pair<String, Double>>> g = new HashMap<>();
        constructGraph(g, equations, values);

        int qsize = queries.size();
        double[] answer = new double[qsize];
        Arrays.fill(answer, -1d);

        for(int i = 0; i < qsize; i++) {
            List<String> query = queries.get(i);
            String u = query.get(0), v = query.get(1);
            if(g.containsKey(u))
                answer[i] = dfs(g, u, v, new HashSet<>());
        }
        return answer;
    }

    private void constructGraph(Map<String, List<Pair<String, Double>>> g, List<List<String>> equations, double[] values) {
        int n = values.length;
        for(int i = 0; i < n; i++) {
            List<String> equation = equations.get(i);
            String u = equation.get(0), v = equation.get(1);
            updateGraph(g, u, v, values[i]);
        }
    }

    private void updateGraph(Map<String, List<Pair<String, Double>>> g, String u, String v, double value) {
        g.putIfAbsent(u, new ArrayList<>());
        g.get(u).add(new Pair(v, value));
        g.putIfAbsent(v, new ArrayList<>());
        g.get(v).add(new Pair(u, 1 / value));
    }

    private double dfs(Map<String, List<Pair<String, Double>>> g, String source, String destination, Set<String> visited) {
        
        visited.add(source);

        if(source.equals(destination)) 
            return 1d;

        if(g.containsKey(source)) {
            for(Pair<String, Double> neigh : g.get(source)) {
                String currNode = neigh.getKey();
                Double value = neigh.getValue();
                if(!visited.contains(currNode)) {
                    double returnValue = dfs(g, currNode, destination, visited);
                    if(returnValue != -1d) {
                        updateGraph(g, source, currNode, value * returnValue);
                        return value * returnValue;
                    }
                }
            }
        }

        return -1d;
    }
}