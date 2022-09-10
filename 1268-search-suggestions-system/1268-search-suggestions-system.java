class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        List<List<String>> result = new ArrayList<>();
        if(searchWord == null || searchWord.length() == 0)
            return result;
        
        Trie trieObj = new Trie();
        
        for(String product : products) {
            trieObj.insert(product);    
        }
        
        Node curr = trieObj.getRoot();
        int index = 0, n = searchWord.length();
        while(curr != null && index < n) {
            curr = curr.children.get(searchWord.charAt(index));
            List<String> temp = new ArrayList<>();
            if(curr != null) 
                trieObj.search(curr, temp);
            result.add(temp);
            index++;
        }
        
        while(index++ < n) result.add(new ArrayList<>());
        
        return result;
    }
}

class Node {
    Map<Character, Node> children;
    String word;
    Node() {
        this.children = new HashMap<>();
        this.word = null;
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
    
    // TC : O(N * L) where N is the number of words and L is the average length of word
    public void insert(String word) {
        Node curr = this.root;
        for(char ch : word.toCharArray()) {
            if(!curr.children.containsKey(ch))
                curr.children.put(ch, new Node());
            curr = curr.children.get(ch);
        }
        curr.word = word;
    }
    
    // TC : O(L) + O(m * L) where m is the length of searchWord and L is the average length og word in Trie
    public void search(Node curr, List<String> temp) {
        
        if(temp.size() >= 3) return;
        
        if(curr.word != null) {
            temp.add(curr.word);
        }
        
        for(char ch='a';ch <='z';ch++) {
            if(!curr.children.containsKey(ch)) continue;
            search(curr.children.get(ch), temp);
        }
    }
}