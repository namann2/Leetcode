class Trie {

    private Node root;
    
    public Trie() {
        this.root = new Node();    
    }
    
    // TC : O(L), SC : O(L)
    
    public void insert(String word) {
        Node curr = this.root;
        for(char ch : word.toCharArray()) {
            if(!curr.children.containsKey(ch))
                curr.children.put(ch, new Node());
            curr = curr.children.get(ch);
        }
        curr.isEnd = true;
    }
    
    // TC : O(L), SC : O(1)
    
    public boolean search(String word) {
        Node curr = this.root;
        for(char ch : word.toCharArray()) {
            if(!curr.children.containsKey(ch))
                return false;
            curr = curr.children.get(ch);
        }
        return curr.isEnd;
    }
    
    // TC : O(L), SC : O(1)
    public boolean startsWith(String prefix) {
        Node curr = this.root;
        for(char ch : prefix.toCharArray()) {
            if(!curr.children.containsKey(ch))
                return false;
            curr = curr.children.get(ch);
        }
        return true;
    }
}

class Node {
    Map<Character, Node> children;
    boolean isEnd;
    Node() {
        this.children = new HashMap<>();
        this.isEnd = false;
    }
}