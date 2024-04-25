class Solution {
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        List<String> answer = new ArrayList<>();
        Map<String, List<String>> g = new HashMap<>();
        Map<String, Integer> wordIndex = new HashMap<>();

        int n = recipes.length;
        int[] indegree = new int[n];
        
        for(int i = 0; i < n ; i++) {
            List<String> in = ingredients.get(i);
            for(String word : in) {
                g.putIfAbsent(word, new ArrayList<>());
                g.get(word).add(recipes[i]);
                indegree[i]++;
            }
            wordIndex.put(recipes[i], i);
        }
        
        Deque<String> q = new LinkedList<>();
        for(String supply : supplies) q.addLast(supply);
        
        while(!q.isEmpty()) {
            String word = q.removeFirst();
            if(wordIndex.containsKey(word)) answer.add(word);
            if(!g.containsKey(word)) continue;
            for(String w : g.get(word)) {
                int idx = wordIndex.get(w);
                indegree[idx] -= 1;
                if(indegree[idx] == 0) {
                    q.addLast(w);
                }
            }
        }
            
        return answer;
    }
}