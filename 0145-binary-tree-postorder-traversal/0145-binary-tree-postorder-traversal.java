class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> answer = new ArrayList<>();
        if(root == null) return answer;
        postorderTraversal(root, answer);
        return answer;        
    }

    /* helper functions */
    private void postorderTraversal(TreeNode root, List<Integer> answer) {
        if(root == null) return;
        postorderTraversal(root.left, answer);
        postorderTraversal(root.right, answer);
        answer.add(root.val);
    }
}