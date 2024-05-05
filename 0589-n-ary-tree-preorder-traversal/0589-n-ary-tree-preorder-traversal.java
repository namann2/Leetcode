class Solution {
    public List<Integer> preorder(Node root) {
        List<Integer> ans = new ArrayList<>();
        if(root == null) return ans;
        Deque<Node> stack = new ArrayDeque<>();
        stack.addLast(root);
        while(!stack.isEmpty()) {
            Node curr = stack.removeLast();
            int n = curr.children.size();
            for(int i = n-1; i >= 0; i--) {
                stack.addLast(curr.children.get(i));
            }
            ans.add(curr.val);
        }
        return ans;
    }
}