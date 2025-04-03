class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> answer = new ArrayList<>();
        if(root == null) return answer;
        inorderTraversal(root, answer);
        return answer;
    }

    /* helper function */
    private void inorderTraversal(TreeNode root, List<Integer> answer) {
        if(root == null) return;
        inorderTraversal(root.left, answer);
        answer.add(root.val);
        inorderTraversal(root.right, answer);
    }
}