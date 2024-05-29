enum COLOR {
    WHITE, GREY, BLACK;    
}

class Solution {
    
    private static final String INVALID_EMPTY = "";
    
    public String alienOrder(String[] words) {
        if(words == null || words.length == 0)
            return INVALID_EMPTY;
        
        // get count of all the characters in the word
        boolean[] diffChars = new boolean[26];
        for(String w : words)
            for(char ch : w.toCharArray())
                diffChars[ch-'a'] = true;
        
        Map<Character, List<Character>> g = new HashMap<>();
        boolean isValid = checkDictionaryValid(g, words);
        
        if(!isValid)
            return INVALID_EMPTY;
        
        StringBuilder answer = new StringBuilder();
        Deque<Character> stack = new ArrayDeque<>();
        
        COLOR[] visited = new COLOR[26];
        Arrays.fill(visited, COLOR.WHITE);
        
        for(int i = 0; i < 26; i++) {
            if(diffChars[i] && visited[i] == COLOR.WHITE)
                if(dfs(g, (char)(i + 'a'), stack, visited, diffChars))
                    return INVALID_EMPTY;
        }
        
        while(!stack.isEmpty())
            answer.append(stack.removeLast());
        
        return answer.toString();
    }
    
    private boolean dfs(Map<Character, List<Character>> g, char u, Deque<Character> stack, COLOR[] visited, boolean[] diffChars) {
        
        visited[u-'a'] = COLOR.GREY;
        
        if(g.containsKey(u)) {
            for(char v : g.get(u)) {
                if(visited[v-'a'] == COLOR.GREY) 
                    return true;
                if(visited[v-'a'] == COLOR.WHITE)
                    if(dfs(g, v, stack, visited, diffChars))
                        return true;
            }
        }
        
        visited[u-'a'] = COLOR.BLACK;
        stack.addLast(u);
        return false;
    }
    
    private boolean checkDictionaryValid(Map<Character, List<Character>> g, String[] words) {
        int n = words.length;
        
        for(int i = 0; i < n-1; i++) {
            String w1 = words[i], w2 = words[i+1];
            int minLength = Math.min(w1.length(), w2.length());
            
            if(w1.equals(w2)) continue;
            if(w2.length() == minLength && w1.startsWith(w2)) return false;
            
            for(int j = 0; j < minLength; j++) {
                char ch1 = w1.charAt(j), ch2 = w2.charAt(j);
                if(ch1 == ch2) continue;
                g.putIfAbsent(ch1, new ArrayList<>());
                g.get(ch1).add(ch2);
                break;
            }
        }
        return true;
    }
}