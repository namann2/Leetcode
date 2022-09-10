class WordFilter {

    private Trie obj;
    private Node root;
    
    public WordFilter(String[] words) {
        obj = new Trie();
        root = obj.getRoot();
        
        int n = words.length;
        
        for(int i=0;i<n;i++) {
            String word = words[i];
            String toAdd = word+"$"+word; // apple$apple
            obj.insert(toAdd, i);
        }
    }
    
    public int f(String pref, String suff) {
        String word = suff+"$"+pref;
        return obj.search(root, word, 0);
    }
}

class Node {
    Map<Character, Node> children;
    int index;
    Node() {
        this.children = new HashMap<>();
        this.index = 0;
    }
}

class Trie {
    
    private Node root;
    
    Trie() {
        this.root = new Node();
    }
    
    public Node getRoot() {
        return this.root;
    }
    
    // TC : O(n * (L*L)) where n is the total number of words and L is the average length of word
    // SC : O(n * L*L)
    public void insert(String word, int index) {
        /*
            apple$apple
            pple$apple
            ple$apple
            le$apple
            e$apple
        */
        int n = word.length();
        for(int i=0;i<n;i++) { // apple$apple
            if(word.charAt(i) == '$') return;
            Node curr = this.root;
            for(int j=i;j<n;j++) {
                char ch = word.charAt(j);
                if(!curr.children.containsKey(ch))
                    curr.children.put(ch, new Node());
                curr = curr.children.get(ch);
                curr.index = Math.max(index, curr.index); // since we need to return the max index
                // curr.index = index; this could also be done as we are iterating over the words array from small to large indices
            }
        }
    }
    
    // TC : O(K) where K is the length of word that we need to search
    public int search(Node curr, String word, int index) {
        if(index == word.length())
            return curr.index;
        
        int n = word.length();
        for(int i=index;i<n;i++) {
            char ch = word.charAt(i);
            if(!curr.children.containsKey(ch))
                return -1;
            return search(curr.children.get(ch), word, i+1);
        }
        return -1;
    }
}