class Solution {
    public String alienOrder(String[] words) {
        Map<Character, List<Character>> g = new HashMap<>();
        Map<Character, Integer> indegree = new HashMap<>();
        
        for(String word : words) {
            int n = word.length();
            for(int i = 0; i < n; i++) {
                char ch = word.charAt(i);
                indegree.put(ch, 0);
            }
        }
        
        boolean valid = constructGraph(g, words, indegree);
        
        if(!valid) return "";
        
        StringBuilder ans = new StringBuilder();
        Deque<Character> q = new ArrayDeque<>();
        for(char ch : indegree.keySet()) {
            if(indegree.get(ch) == 0) {
                q.addLast(ch);
            }
        }
        
        if(q.size() == 0) return "";
        
        while(!q.isEmpty()) {
            char u = q.removeFirst();
            ans.append(u);
            if(!g.containsKey(u)) continue;
            for(char v : g.get(u)) {
                indegree.put(v, indegree.getOrDefault(v, 0) - 1);
                if(indegree.get(v) == 0)
                    q.addLast(v);
            }
        }
        
        if(ans.length() != indegree.size()) return "";
        
        return ans.toString();
    }
    private boolean constructGraph(Map<Character, List<Character>> g, String[] words, Map<Character, Integer> indegree) {
        int n = words.length;
        for(int i = 0; i < n - 1; i++) {
            String w1 = words[i];
            String w2 = words[i+1];
            
            if(w1.equals(w2)) continue;
            int minLength = Math.min(w1.length(), w2.length());
            
            if(w2.length() == minLength && w1.startsWith(w2)) return false;
            
            for(int j = 0; j < minLength; j++) {
                char c1 = w1.charAt(j);
                char c2 = w2.charAt(j);
                if(c1 == c2) continue;
                g.putIfAbsent(c1, new ArrayList<>());
                g.get(c1).add(c2);
                indegree.put(c2, indegree.getOrDefault(c2, 0) + 1);
                break;
            }
        }
        return true;
    }
}