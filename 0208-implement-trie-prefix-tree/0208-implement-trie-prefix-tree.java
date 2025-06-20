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
    
    public void insert(String word) {
        Node curr = this.root;
        int wordLength = word.length();
        for(int i = 0; i < wordLength; i++) {
            char ch = word.charAt(i);
            if(!curr.children.containsKey(ch))
                curr.children.put(ch, new Node());
            curr = curr.children.get(ch);
        }
        curr.isEnd = true;
    }
    
    public boolean search(String word) {
        Node curr = this.root;
        int wordLength = word.length();
        for(int i = 0; i < wordLength; i++) {
            char ch = word.charAt(i);
            if(!curr.children.containsKey(ch)) return false;
            curr = curr.children.get(ch);
        }
        return curr.isEnd;
    }
    
    public boolean startsWith(String prefix) {
        Node curr = this.root;
        int prefixLength = prefix.length();
        for(int i = 0; i < prefixLength; i++) {
            char ch = prefix.charAt(i);
            if(!curr.children.containsKey(ch)) return false;
            curr = curr.children.get(ch);
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */