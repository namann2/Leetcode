class Node {
    Map<Character, Node> children;
    boolean isEnd;
    
    Node() {
        this.children = new HashMap<>();
    }
}

class Solution {
    
    private Node root;

    public Solution() {
        root = new Node();
    }
    public void insert(String word) {
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
    
    public String longestCommonPrefixUtil() {
        Node curr = root;
        StringBuilder ans = new StringBuilder();
        while(curr != null && curr.children.size() == 1) {
            if(curr.isEnd) break;
            for(char ch : curr.children.keySet()) {
                ans.append(ch);
                curr = curr.children.get(ch);
            }
        }
        return ans.toString();
    }
    
    public String longestCommonPrefix(String[] strs) {

        for(String s : strs) {
            insert(s);
        }
        
        return longestCommonPrefixUtil();
    }
}