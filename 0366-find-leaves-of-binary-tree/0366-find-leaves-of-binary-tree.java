class Solution {
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> answer = new ArrayList<>();
        if(root == null) return answer;
        helper(root, answer);
        return answer;
    }
    private int helper(TreeNode root, List<List<Integer>> answer) {
        // base case
        if(root == null) return 0;

        // main logic
        int left = helper(root.left, answer); 
        int right = helper(root.right, answer);

        int height = 1 + Math.max(left, right);
        if(answer.size() < height) {
            answer.add(new ArrayList<>());
        }
        answer.get(height-1).add(root.val);
        return height;
  }
}