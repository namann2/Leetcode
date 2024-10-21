Simpler Problem ( A kind of pre-requisite ) : https://practice.geeksforgeeks.org/problems/alien-dictionary


TC for dfs ?
Total vertices in the graph are the total number of unique chars ( = O(V) )
Total edges ?
we are comparing two adjacent words to form an edge, hence, there will be atmost n-1 edges where n is the number of words we are given.
            
Hence, TC : O(V + n-1) = O(V+n)
            
Total TC : O(V + N) + O(N * L)

To be more generic, our graph won't have more than V^2 edges. Hence, 

TC : `O(V + Math.min(V^2, N-1))`

***

```

enum COLOR {
    WHITE, GREY, BLACK;
}

class Solution {
    public String alienOrder(String[] words) {
        int n = words.length;
        boolean[] uniqueChars = new boolean[26];
        
        for(String word : words) {
            for(char ch : word.toCharArray()) {
                uniqueChars[ch-'a'] = true;
            }
        }
        
        // construct graph
        Map<Character, List<Character>> g = new HashMap<>();
        boolean isCorrectMapping = constructGraph(g, words, n);
        // if the order of the input string isn't valid
        if(!isCorrectMapping)
            return "";
        // if the order of the input string is valid
        // construct the order of letters from the graph
        
        // topological sort
        COLOR[] state = new COLOR[26];
        Arrays.fill(state, COLOR.WHITE);
        
        Deque<Character> stack = new ArrayDeque<>();
        for(char ch : g.keySet()) {
            if(state[ch-'a'] == COLOR.WHITE) {
                if(!dfs(g, ch, state, stack))
                    return "";
            }
        }
        
        // formulate the answer
        StringBuilder answer = new StringBuilder();
        while(!stack.isEmpty())
            answer.append(stack.removeLast());
        
        for(int i = 0; i < 26; i++) {
            if(uniqueChars[i] && state[i] == COLOR.WHITE) {
                answer.append((char)(i+'a'));
            }
        }
        return answer.toString();
    }
    
    private boolean constructGraph(Map<Character, List<Character>> g, String[] words, int n) {

        for(int i = 0; i < n-1; i++) {
            String w1 = words[i];
            String w2 = words[i+1];
            
            if(w1.equals(w2)) continue;
            
            int s1Length = w1.length();
            int s2Length = w2.length();
            
            int minLength = Math.min(s1Length, s2Length);
            
            if(minLength == s2Length && w1.startsWith(w2)) return false;
            
            for(int j = 0; j < minLength; j++) {
                if(w1.charAt(j) != w2.charAt(j)) {
                    g.putIfAbsent(w1.charAt(j), new ArrayList<>());
                    g.get(w1.charAt(j)).add(w2.charAt(j));
                    break;
                }
            }
        }
        return true;
    }
    
    private boolean dfs(Map<Character, List<Character>> g, char u, COLOR[] state, Deque<Character> stack) {
        state[u-'a'] = COLOR.GREY;
        if(g.containsKey(u)) {
            for(char v : g.get(u)) {
                if(COLOR.GREY == state[v-'a']) return false;
                if(COLOR.WHITE == state[v-'a']) {
                    if(!dfs(g, v, state, stack))
                        return false;
                }
            }
        }
        state[u-'a'] = COLOR.BLACK;
        stack.addLast(u);
        return true;
    }
}
```
