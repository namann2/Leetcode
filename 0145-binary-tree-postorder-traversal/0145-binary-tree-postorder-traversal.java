class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> answer = new ArrayList<>();
        if(root == null) return answer;

        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.addLast(root);

        while(!stack.isEmpty()) {
            TreeNode curr = stack.removeLast();
            if(curr.left != null) stack.addLast(curr.left);
            if(curr.right != null) stack.addLast(curr.right);
            answer.add(curr.val);
        }
        Collections.reverse(answer);
        return answer;
    }
}