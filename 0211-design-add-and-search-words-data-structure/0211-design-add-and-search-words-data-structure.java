class Node {
    Map<Character, Node> children;
    boolean isEnd;
    
    Node() {
        children = new HashMap<>();
        isEnd = false;
    }
}

class WordDictionary {

    private Node root;
    
    public WordDictionary() {
        root = new Node();    
    }
    
    public void addWord(String word) {
        Node curr = root;
        int n = word.length();
        for(int i = 0; i < n; i++) {
            char ch = word.charAt(i);
            if(!curr.children.containsKey(ch))
                curr.children.put(ch, new Node());
            curr = curr.children.get(ch);
        }
        curr.isEnd = true;
    }
    
    public boolean search(String word) {
        return search(root, word, 0, word.length());
    }
    
    private boolean search(Node curr, String word, int index, int n) {
        if(index == n)
            return curr.isEnd;
        
        if(curr == null) return false;
        
        char ch = word.charAt(index);
        
        if(ch == '.') {
            for(char c : curr.children.keySet())
                if(search(curr.children.get(c), word, index + 1, n))
                    return true;
        } else {
            if(curr.children.containsKey(ch))
                if(search(curr.children.get(ch), word, index + 1, n))
                    return true;
        }
        return false;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */