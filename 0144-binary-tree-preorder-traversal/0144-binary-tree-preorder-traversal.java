class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> answer = new ArrayList<>();
        if(root == null) return answer;

        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.addLast(root);

        while(!stack.isEmpty()) {
            TreeNode curr = stack.removeLast();
            answer.add(curr.val);
            if(curr.right != null) stack.addLast(curr.right);
            if(curr.left != null) stack.addLast(curr.left);
        }
        return answer;
    }
}