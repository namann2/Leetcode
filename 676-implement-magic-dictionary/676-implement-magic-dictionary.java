class MagicDictionary {
    // TOTAL TC : O(L*M) + O(L^2)
    // TOTAL SC : O(L*M) + O(L)
    private Node root;
    
    public MagicDictionary() {
        this.root = new Node();
    }
    
    // TC : O(L * M) -> average length of words L, total words M
    // SC : O(L * M)
    public void buildDict(String[] dictionary) {
        for(String word : dictionary) {
            insert(word);
        }
    }
    
    // TC : O(L * L * 26)
    // SC : O(L)
    public boolean search(String searchWord) {
        char[]ch = searchWord.toCharArray();
        int n = ch.length;
        Node curr = this.root;
        for(int i=0;i<n;i++) {
            // make one char change and see if we are able to find it
            char org = ch[i];
            for(char c = 'a'; c <= 'z' ; c++) {
                if(c == org || !curr.children.containsKey(c)) continue;
                if(search(searchWord, curr.children.get(c), i+1))
                    return true;
            }
            if(!curr.children.containsKey(org)) 
                return false;
            curr = curr.children.get(org);
        }
        return false;
    }
    
    private void insert(String word) {
        Node curr = this.root;
        for(char ch : word.toCharArray()) {
            if(!curr.children.containsKey(ch))
                curr.children.put(ch, new Node());
            curr = curr.children.get(ch);
        }
        curr.isEnd = true;
    }
    
    private boolean search(String searchWord, Node curr, int index) {
        int n = searchWord.length();
        for(int i=index;i<n;i++) {
            char ch = searchWord.charAt(i);
            if(!curr.children.containsKey(ch))
                return false;
            curr = curr.children.get(ch);
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