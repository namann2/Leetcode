class Solution {
    public boolean areSentencesSimilarTwo(String[] sentence1, String[] sentence2, List<List<String>> similarPairs) {
        int n = sentence1.length, m = sentence2.length;
        if(n != m) 
            return false;
        Map<String, Set<String>> g = new HashMap<>();
        constructGraph(g, similarPairs);
        
        // TC : n * ( k * 2n ) = O(k * n^2)
        // SC : k * 2n for graph + k (for hashset) = O(k * n + k)
        for(int i = 0; i < n ; i++) {
            String w1 = sentence1[i], w2 = sentence2[i];
            if(w1.equals(w2)) continue;
            else if(dfs(g, w1, w2, new HashSet<>())) continue;
            return false;
        }
        return true;
    }
    private void constructGraph(Map<String, Set<String>> g, List<List<String>> similarPairs) {
        int k = similarPairs.size(); 
        // graph has k nodes and there can be 2n edges
        for(int i = 0; i < k ; i++) {
            g.putIfAbsent(similarPairs.get(i).get(0), new HashSet<>());
            g.putIfAbsent(similarPairs.get(i).get(1), new HashSet<>());
            g.get(similarPairs.get(i).get(0)).add(similarPairs.get(i).get(1));
            g.get(similarPairs.get(i).get(1)).add(similarPairs.get(i).get(0));
        }
    }
    private boolean dfs(Map<String, Set<String>> g, String w1, String w2, HashSet<String> visited) {
        if(w1.equals(w2))
            return true;
        visited.add(w1);
        if(!g.containsKey(w1))
            return false;
        for(String word : g.get(w1)) {
            if(!visited.contains(word))
                if(dfs(g, word, w2, visited))
                    return true;
        }
        return false;
    }
}