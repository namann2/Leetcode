Simpler Problem ( A kind of pre-requisite ) : https://practice.geeksforgeeks.org/problems/alien-dictionary

# Complexity Analysis : 

Let's say, 
* K - unique characters in the given words array
* N - number of words that we are given
* L - average length of word in words array

TC to build the graph : O(N * L) <br>

For DFS, 

In the worst case, we could have a type of graph which have total number of edges equal to 26 * 25 or more formally, K * K-1 <br>
a -> b,c,d,....z <br>
b -> a,c,d,....z <br>
. <br>
. <br>
. <br>
z -> a,b,c,d,...y <br>

TC : O(N * L) + O(K^2) ~  O( V + E ) <br>
SC : O(K^2)
 

```
class Solution {
    enum COLOR {
        WHITE, GREY, BLACK;
    }
    public String alienOrder(String[] words) {
        // TC : O(C) -> total length of words in input list
        // graph adjacency
        HashMap<Character, List<Character>> adj = new HashMap<>();
        // get different chars
        boolean[] diffChars = new boolean[26];
        for(String w : words) { // n*L ->n total words, L-> avg length of words
            for(char ch : w.toCharArray())
                diffChars[ch-'a'] = true;
        }
        
        int n = words.length;
        // TC : O(n * L) -> where n is the number of words and L is the average length of words
        for(int i=1;i<n;i++) { // nL
            String w1 = words[i-1];
            String w2 = words[i];
            
            if(w1.equals(w2)) continue;
            
            int minLength = Math.min(w1.length(), w2.length());
            
            if(minLength == w2.length() && w1.startsWith(w2))
                return "";
            
            for(int k=0;k<minLength;k++) {
                char ch1 = w1.charAt(k);
                char ch2 = w2.charAt(k);
                
                if(ch1 == ch2) continue;
                else {
                    List<Character> l = adj.getOrDefault(ch1, new ArrayList<Character>());
                    l.add(ch2);
                    adj.put(ch1, l);
                    break;
                }
            }
        }
        // topo sort with cycle detection
        Stack<Character> st = new Stack<>();
        COLOR[] state = new COLOR[26];
        Arrays.fill(state, COLOR.WHITE);
        for(int i=0;i<26;i++) { // total number of unique chars
            if(diffChars[i] && state[i] == COLOR.WHITE) {
                if(dfs(diffChars, (char)(i+'a'), adj, st, state))
                    return "";
            }
        }
        
        StringBuilder res = new StringBuilder();
        while(!st.isEmpty()) 
            res.append(st.pop());
        return res.toString();
    }
    private boolean dfs(boolean[]diffChars, char ch, HashMap<Character, List<Character>>adj, Stack<Character> st, COLOR[] state) {
        state[ch-'a'] = COLOR.GREY;
        if(adj.containsKey(ch)) {
            List<Character> l = adj.get(ch);
            for(char c : l) {
                if(diffChars[c-'a']) {
                    if(state[c-'a'] == COLOR.GREY)
                        return true;
                    if(state[c-'a'] == COLOR.WHITE) {
                        if(dfs(diffChars, c, adj, st, state))
                            return true;
                    }
                }
            }
        }
        state[ch-'a'] = COLOR.BLACK;
        st.push(ch);
        return false;
    }
}
```
