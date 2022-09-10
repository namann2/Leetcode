n words,
L average length of each word
sL length of searchWord

`TC : O(n*L) + O(min(sL, n*L) * L * 26) + O(3 * L) = O(n*L) + O(min(sL, n*L) * L);`

`SC : O(n*L)`


# Suggestion : 
Copy this code in the editor and read through to resolve the doubts : 
```
class Solution {

    // TC : O(n * m + O(k) -> to add 3 words of length k + 26 * s * m) 
    // where n is the products.length and m is the avg length of each product[i]
    // and s is the length of searhWord, k is the average length of suggestion word
    // SC : O(n * m)
    
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Trie obj = new Trie();
        for(String w : products)
            obj.addWord(w);
        
        List<List<String>> R = new ArrayList<>();
        Node curr = obj.root;
        for(char ch : searchWord.toCharArray()) {

            if(curr!=null)
            {
                curr = curr.children.get(ch);
                List<String> t = obj.search(curr, new ArrayList<String>());
                R.add(t);
            }
            // no suggestions
            else R.add(new ArrayList<String>());
        }
        return R;
    }
}

class Node {
    HashMap<Character, Node> children;
    boolean isEnd;
    String word;
    
    Node() {
        this.children = new HashMap<>();
        this.isEnd = false;
    }
}

class Trie {
    
    public Node root;
    
    Trie() {
        this.root = new Node();
    }
    
    public void addWord(String w) {
        Node curr = this.root;
        for(char ch : w.toCharArray()) {
            if(!curr.children.containsKey(ch))
                curr.children.put(ch, new Node());
            curr = curr.children.get(ch);
        }
        curr.isEnd = true;
        curr.word = w;
    }
    
    public List<String> search(Node curr, List<String> T) {
        if(T.size() >= 3 || curr == null) {
            return T;
        }
        
        if(curr.isEnd) {
            T.add(curr.word);
        }
        
        for(char ch='a';ch<='z';ch++) {
            if(curr.children.containsKey(ch)) {
                search(curr.children.get(ch), T);
            }
        }
        return T;
    }
}
```
