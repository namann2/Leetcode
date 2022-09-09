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
            curr.count += 1;
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
        return curr.count;
    }
    
    public void erase(String word) {
        Node curr = this.root;
        for(char ch : word.toCharArray()) {
            if(!curr.children.containsKey(ch))
                return;
            curr = curr.children.get(ch);
            curr.count -= 1;
            curr.count = Math.max(0, curr.count); // preventing to go negative
        }
        curr.ending--;
        curr.ending = Math.max(curr.ending, 0);
        
        cleanup(word);
    }
    
    private void cleanup(String word) {
        Node curr = this.root;
        for(char ch : word.toCharArray()) {
            if(curr.children.containsKey(ch) && curr.children.get(ch).count == 0) {
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
    int count;
    Node() {
        this.children = new HashMap<>();
        this.isEnd = false;
        this.count = 0;
        this.ending = 0;
    }
}
