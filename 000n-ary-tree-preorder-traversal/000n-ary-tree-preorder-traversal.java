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
    public List<Integer> preorder(Node root) {
        List<Integer> ans = new ArrayList<>();
        if(root == null) return ans;
        Deque<Node> stack = new ArrayDeque<>();
        stack.addLast(root);
        while(!stack.isEmpty()) {
            Node curr = stack.removeLast();
            ans.add(curr.val);
            int n = curr.children.size();
            for(int i = n-1; i >= 0; i--) {
                stack.addLast(curr.children.get(i));
            }
        }
        return ans;
    }
}