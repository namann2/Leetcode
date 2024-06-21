class Solution {
    public String longestCommonPrefix(String[] strs) {
        Trie trie = new Trie();
        Node root = trie.getRoot();
        
        for(String word : strs) {
            trie.insert(word);
        }
        
        return trie.findPrefix();
    }
}

class Node {
    Map<Character, Node> children;
    boolean isEnd;
    public Node() {
        this.children = new HashMap<>();
        this.isEnd = false;
    }
}

class Trie {
    
    private Node root;
    
    public Trie() {
        this.root = new Node();
    }
    
    public Node getRoot() {
        return this.root;    
    }
    
    public void insert(String word) {
        Node curr = this.root;
        int n = word.length();
        for(int i = 0; i < n; i++) {
            char ch = word.charAt(i);
            if(!curr.children.containsKey(ch))
                curr.children.put(ch, new Node());
            curr = curr.children.get(ch);
        }
        curr.isEnd = true;
    }
    
    public String findPrefix() {
        Node curr = this.root;
        StringBuilder prefix = new StringBuilder();
        while(curr != null && curr.children.size() == 1) {
            if(curr.isEnd) return prefix.toString();
            for(char ch : curr.children.keySet()) {
                prefix.append(ch);
                curr = curr.children.get(ch);
            }
        }
        return prefix.toString();
    }
}