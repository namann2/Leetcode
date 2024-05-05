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

class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> tree = new ArrayList<>();
        if(root == null) return tree;
        
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        
        while(!q.isEmpty()) {
            int size = q.size();
            List<Integer> level = new ArrayList<>();
            for(int i=0;i<size;i++) {
                Node curr = q.poll();
                level.add(curr.val);
                for(Node child : curr.children) 
                    q.add(child);
            }
            tree.add(level);
        }
        return tree;
    }
}