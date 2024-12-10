/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Codec {
    
    private final String DEL = "X";
    private final String SEP = ",";
    
    // Encodes a tree to a single string.
    public String serialize(Node root) {
        if(root == null) return DEL;
        
        StringBuilder tree = new StringBuilder();
        tree.append(root.val);
        tree.append(SEP);
        
        tree.append(root.children.size());
        tree.append(SEP);
        
        for(Node child : root.children) {
            tree.append(serialize(child));
            tree.append(SEP);
        }
        tree.deleteCharAt(tree.length()-1);
        return tree.toString();
    }
	
    // Decodes your encoded data to tree.
    public Node deserialize(String data) {
        if(data == null) return null;
        Queue<String> q = new LinkedList<>();
        for(String d : data.split(SEP)) q.offer(d);
        
        return construct(q);
    }
    
    // helper function
    
    private Node construct(Queue<String> q) {
        if(q.isEmpty()) return null;
        if(q.peek().equals(DEL)) {
            q.remove();
            return null;
        }
        
        Node root = new Node(Integer.valueOf(q.remove()));
        int childCount = Integer.valueOf(q.remove());
        root.children = new ArrayList<>();
        for(int i = 0; i < childCount; i++) {
            root.children.add(construct(q));
        }
        return root;
    }
    
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));