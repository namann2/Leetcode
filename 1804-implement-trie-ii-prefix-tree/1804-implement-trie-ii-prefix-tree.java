class Trie {

    private Node root;
    
    public Trie() {
        this.root = new Node();    
    }
    
    public void insert(String word) {
        Node curr = this.root;
        for(char ch : word.toCharArray()) {
            if(!curr.children.containsKey(ch))
                curr.children.put(ch, new Node());
            curr = curr.children.get(ch);
            curr.length += 1;
        }
        curr.isEnd = true;
        curr.ending += 1;
    }
    
    public int countWordsEqualTo(String word) {
        Node curr = this.root;
        for(char ch : word.toCharArray()) {
            if(!curr.children.containsKey(ch))
                return 0;
            curr = curr.children.get(ch);
        }
        return curr.isEnd ? curr.ending : 0;
    }
    
    public int countWordsStartingWith(String prefix) {
        Node curr = this.root;
        for(char ch : prefix.toCharArray()) {
            if(!curr.children.containsKey(ch))
                return 0;
            curr = curr.children.get(ch);
        }
        return curr.length;
    }
    
    public void erase(String word) {
        Node curr = this.root;
        for(char ch : word.toCharArray()) {
            if(!curr.children.containsKey(ch))
                return;
            curr = curr.children.get(ch);
            curr.length -= 1;
            curr.length = Math.max(0, curr.length);
        }
        curr.ending--;
        curr.ending = Math.max(curr.ending, 0);
        
        cleanup(word);
    }
    
    private void cleanup(String word) {
        Node curr = this.root;
        for(char ch : word.toCharArray()) {
            if(curr.children.containsKey(ch) && curr.children.get(ch).length == 0) {
                Node temp = curr.children.get(ch);
                curr.children.remove(ch);
                curr = temp;
            }
        }
    }
}

class Node {
    Map<Character, Node> children;
    boolean isEnd;
    int ending; // number of words ending here
    int length;
    Node() {
        this.children = new HashMap<>();
        this.isEnd = false;
        this.length = 0;
        this.ending = 0;
    }
}