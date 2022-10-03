class Solution {
    
    static enum COLOR {
        WHITE, GREY, BLACK;
    }
    
    public String alienOrder(String[] words) {
        
        // those char which maps with the same words eg : 
        // ["alien", "alien"] - we can not deduce anything from here, so we add 'a' in sames to check afterwards 
        // if this char was already seen and picked for ordering
        // another eg : ["z", "z"]
        boolean[] unique = new boolean[26];
        for(String word : words) {
            for(char ch : word.toCharArray())
                unique[ch-'a'] = true;
        }
        
        Map<Character, List<Character>> g = constructGraph(words);
        if(g == null) return "";
        
        int n = words.length;
        COLOR[] color = new COLOR[26];
        Arrays.fill(color, COLOR.WHITE);
        
        Stack<Character> stack = new Stack<>();
        for(char ch='a';ch<='z';ch++) {
            if(g.containsKey(ch) && color[ch-'a'] == COLOR.WHITE) {
                if(!dfs(g, ch, color, stack))
                    return "";
            }
        }
        
        for(char ch='a';ch<='z';ch++) {
            if(unique[ch-'a'] && color[ch-'a'] == COLOR.WHITE)
                stack.push(ch);
        }
        
        StringBuilder order = new StringBuilder();
        while(!stack.isEmpty()) {
            order.append(stack.pop());
        }
        
        return order.toString();
    }
    
    private Map<Character, List<Character>> constructGraph(String[] words) {
        // N is the number of words that we have in dict array, L is the average length of the words 
        // TC : O(N * L)
        Map<Character, List<Character>> g = new HashMap<>();
        int n = words.length;
        for(int i=1;i<n;i++) {
            String word1 = words[i-1];
            String word2 = words[i];
            
            if(word1.equals(word2)) continue;
            int w1 = word1.length(), w2 = word2.length();
            int minLength = Math.min(w1, w2);
            
            if(w2 == minLength && word1.startsWith(word2)) return null;
            
            for(int j=0;j<minLength;j++) {
                char ch1 = word1.charAt(j);
                char ch2 = word2.charAt(j);
                
                if(ch1==ch2) continue;
                g.putIfAbsent(ch1, new ArrayList<>());
                g.get(ch1).add(ch2);
                break;
            }
        }
        return g;
    }
    
    private boolean dfs(Map<Character, List<Character>> g, char src, COLOR[] color, Stack<Character> stack) {
        color[src-'a'] = COLOR.GREY;
        if(g.containsKey(src)) {
            for(char v : g.get(src)) {
                COLOR curr = color[v-'a'];
                if(curr == COLOR.GREY) return false;
                if(color[v-'a'] == COLOR.WHITE) {
                    if(!dfs(g, v, color, stack))
                        return false;
                }
            }
        }
        color[src-'a'] = COLOR.BLACK;
        stack.push(src);
        return true;
    }
}