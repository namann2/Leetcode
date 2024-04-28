/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        Map<Node, Node> g = new HashMap<>();
        return cloneGraph(g, node);
    }
    private Node cloneGraph(Map<Node, Node> g, Node node) {
        // base case
        if(node == null) return null;
        
        if(g.containsKey(node))
            return g.get(node);
        
        // main logic
        Node newRoot = new Node(node.val);
        g.put(node, newRoot);
        
        for(Node neigh : node.neighbors) {
            newRoot.neighbors.add(cloneGraph(g, neigh));
        }
        return newRoot;
    }
}