class WordDictionary {

    private Node root;
    
    public WordDictionary() {
        root = new Node();    
    }
    
    // TC : O(L), SC : O(L)
    public void addWord(String word) {
        Node curr = this.root;
        for(char ch : word.toCharArray()) {
            if(!curr.children.containsKey(ch))
                curr.children.put(ch, new Node());
            curr = curr.children.get(ch);
        }
        curr.isEnd = true;
    }
    
    // TC : O(L) - words without '.'
    // TC : O(26^L)
    public boolean search(String word) {
        return search(this.root, word, 0);
    }
    
    private boolean search(Node curr, String word, int index) {
        int n = word.length();
        for(int i=index;i<n;i++) {
            char ch = word.charAt(i);
            if(ch == '.') {
                Node temp = curr;
                for(char c : temp.children.keySet()) {
                    if(search(temp.children.get(c), word, i+1) == true)
                        return true;
                }
                return false; // if we encountered . and we are not able to search, thus word not there
            }
            else {
                if(!curr.children.containsKey(ch)) return false;
                curr = curr.children.get(ch);   
            }
        }
        return curr.isEnd;
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