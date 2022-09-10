# Solution 1 : 
* TC : 
	*  buildDict : `O(n) `, where `n` is the number of words in the dictionary
	*  search : `O(n*k)`, where `k` is the length of word we are checking
    
* SC : `O(n)`
* Drawback : `Kills memory as the dictionary increases`

Point to note : Since we need to find if on changing one character, we are able to find then string in trie, we will first check the case by converting the characters to [a, z] and see if we can find it.

```
class MagicDictionary {
    
    HashMap<Integer, HashSet<String>> map; 
	// HashSet / Arraylist, doesn't make a diff bcz it is given in the question -> given a list of "different" words
    public MagicDictionary() {
        map = new HashMap<>();
    }
    
    public void buildDict(String[] dictionary) {
        for(String word : dictionary) {
            if(!map.containsKey(word.length())) {
                map.put(word.length(), new HashSet<String>());
            }
            map.get(word.length()).add(word);
        }
    }
    
    public boolean search(String searchWord) {
        if(!map.containsKey(searchWord.length()))
            return false;
        
        for(String words : map.get(searchWord.length())) {
            int count = 0;
            for(int i=0;i<searchWord.length();i++) {
                count += words.charAt(i) == searchWord.charAt(i) ? 0 : 1;
            }
            if(count == 1) return true;
        }
        return false;
    }
}
 ```
 
 # Solution 2: 
The given constraints is an intuition to use `Trie` data-structure.
Code Observations : 
* `Search Operation` is not optimized as we are changing one char and searching for the complete word again.

Complexity Analysis : 
* TC : `O(n*m) + O(k*26*k)`, where `k` is the length of word we are searching
* SC : `O(n*m)`
 ```
 class Node {
    HashMap<Character, Node> children;
    boolean isEnd;
    Node() {
        this.children = new HashMap<>();
        this.isEnd = false;
    }
}
class MagicDictionary {
    
    private Node root;
    private int maxLength;
    
    public MagicDictionary() {
        this.root = new Node();
        this.maxLength = 0;
    }
    
    public void buildDict(String[] dictionary) {
        for(String word : dictionary) {
            Node curr = this.root;
            maxLength = Math.max(maxLength, word.length());
            for(char ch : word.toCharArray()) {
                if(curr.children.get(ch) == null) 
                    curr.children.put(ch, new Node());
                curr = curr.children.get(ch);
            }
            curr.isEnd = true;
        }
    }
    
    public boolean search(String searchWord) {
        if(maxLength < searchWord.length()) 
            return false;
        
        char[] W = searchWord.toCharArray();
        int n = W.length;
        Node curr = this.root;
        for(int i=0;i<n;i++) {
            char original = W[i];
            for(char ch='a';ch<='z';ch++) {
                if(ch != original) 
                {
                    W[i] = ch;
                    // curr char changed -> search complete string
                    if(searchWord(W)) return true;
                    W[i] = original;
                }
            }
        }
        return false;
    }
    
    private boolean searchWord(char[] W) {        
        Node curr = this.root;
        for(int i=0;i<W.length;i++) {
            if(curr.children.get(W[i]) == null) return false;
            curr = curr.children.get(W[i]);
        }
        return curr.isEnd;
    }
}
```

# Solution 3 : 
This approach is bit more optimized in `search(searchWord)` functionality.
* Complexity of below solution would be better in average cases but in worst case, matches with the above solution.
```
class Node {
    HashMap<Character, Node> children;
    boolean isEnd;
    Node() {
        this.children = new HashMap<>();
        this.isEnd = false;
    }
}
class MagicDictionary {
    
    private Node root;
    private int maxLength;
    
    public MagicDictionary() {
        this.root = new Node();
        this.maxLength = 0;
    }
    
    public void buildDict(String[] dictionary) {
        for(String word : dictionary) {
            Node curr = this.root;
            maxLength = Math.max(maxLength, word.length());
            for(char ch : word.toCharArray()) {
                if(curr.children.get(ch) == null) 
                    curr.children.put(ch, new Node());
                curr = curr.children.get(ch);
            }
            curr.isEnd = true;
        }
    }
    
    public boolean search(String searchWord) {
        if(maxLength < searchWord.length()) 
            return false;
        
        char[] W = searchWord.toCharArray();
        int n = W.length;
        Node curr = this.root;
        for(int i=0;i<n;i++) {
            char original = W[i];
            for(char ch='a';ch<='z';ch++) {
                if(curr.children.get(ch) == null) continue;
                if(ch != original) 
                {
                    W[i] = ch;
                    // curr char changed -> search for string ahead
                    if(searchWord(curr.children.get(W[i]), W, i+1)) return true;
                    W[i] = original;
                }
            }
			// if we can not go ahead -> return false
            if(curr.children.get(W[i]) == null) return false;
            curr = curr.children.get(W[i]);
        }
        return false;
    }
    
    private boolean searchWord(Node curr, char[] W, int index) {        
        // Node curr = this.root;
        for(int i=index;i<W.length;i++) {
            if(curr.children.get(W[i]) == null) return false;
            curr = curr.children.get(W[i]);
        }
        return curr.isEnd;
    }
}
```
