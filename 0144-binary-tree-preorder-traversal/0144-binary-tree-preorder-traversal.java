class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> answer = new ArrayList<>();
        if(root == null) return answer;
        preorderTraversal(root, answer);
        return answer;
    }

    /* helper functions */
    private void preorderTraversal(TreeNode root, List<Integer> answer) {
        if(root == null) return;
        answer.add(root.val);
        preorderTraversal(root.left, answer);
        preorderTraversal(root.right, answer);
    }
}