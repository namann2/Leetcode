class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> answer = new ArrayList<>();
        if(root == null) return answer;

        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode curr = root;

        while(!stack.isEmpty() || curr != null) {
            // go to leftmost subnode of the curr node
            while(curr != null) {
                stack.addLast(curr);
                curr = curr.left;
            }
            curr = stack.removeLast();
            answer.add(curr.val);
            // explore the right subtree of the curr node
            curr = curr.right;
        }

        return answer;
    }
}