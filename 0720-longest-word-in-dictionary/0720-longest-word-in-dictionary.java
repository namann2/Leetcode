class Node {
    Map<Character, Node> children;
    boolean isEnd;
    String word;
    Node() {
        this.children = new HashMap<>();
    }
}

class Trie {
    
    private Node root;
    private String longestWord;
    
    Trie() {
        root = new Node();   
        longestWord = "";
    }
    
    public Node getRoot() {
        return this.root;    
    }
    
    public String getLongestWord() {
        return this.longestWord;    
    }
    
    public void insert(String[] words) {
        for(String word : words) {
            Node curr = root;
            int n = word.length();
            for(int i = 0; i < n; i++) {
                char ch = word.charAt(i);
                if(!curr.children.containsKey(ch))
                    curr.children.put(ch, new Node());
                curr = curr.children.get(ch);
            }
            curr.isEnd = true;
            curr.word = word;
        }
    }
    
    public void searchWord(Node curr) {
        // base case
        if(curr == null) return;
        
        if(curr.isEnd) {
            int currLength = curr.word.length();
            int longestLength = longestWord.length();
            if(currLength > longestLength) {
                longestWord = curr.word;
            } else if(currLength == longestLength) {
                longestWord = curr.word.compareTo(longestWord) <= 0 ? curr.word : longestWord;
            } 
        }
        
        // main logic
        for(char ch : curr.children.keySet()) {
            // from the problem statement : 
            // Note that the word should be built from left to right with each 
            // additional character being added to the end of a previous word. 
            if(curr.children.get(ch).isEnd)
                searchWord(curr.children.get(ch));
        }
    }
    
}

class Solution {
    public String longestWord(String[] words) {
        Trie trie = new Trie();
        trie.insert(words);
        
        trie.searchWord(trie.getRoot());
        return trie.getLongestWord();
    }
}